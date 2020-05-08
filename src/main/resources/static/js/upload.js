var accessid = '';
//更换oss需要修改此处host
var host = 'http://music-exam.oss-cn-beijing.aliyuncs.com';
var policyBase64 = '';
var signature = '';
var callbackbody = '';
var key = '';
var expire = 0;
var g_object_name = '';

function send_request(url) {
    var xmlhttp = null;
    if (window.XMLHttpRequest) {
        xmlhttp = new XMLHttpRequest();
    } else if (window.ActiveXObject) {
        xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }

    if (xmlhttp != null) {
        xmlhttp.open("GET", url, false);
        xmlhttp.send(null);
        return xmlhttp.responseText
    } else {
        alert("Your browser does not support XMLHTTP.");
    }
}

function get_signature(url) {
    // 可以判断当前expire是否超过了当前时间， 如果超过了当前时间， 就重新取一下，3s 作为缓冲。
    now = timestamp = Date.parse(new Date()) / 1000;
    if (expire < now + 3) {
        body = send_request(url);
        var obj = eval("(" + body + ")");
        host = obj['host'];
        policyBase64 = obj['policy'];
        accessid = obj['accessid'];
        signature = obj['signature'];
        expire = parseInt(obj['expire']);
        callbackbody = obj['callback'];
        key = obj['dir'];
        return true;
    }
    return false;
}

function random_string(len) {
    len = len || 32;
    var chars = 'ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678';
    var maxPos = chars.length;
    var pwd = '';
    for (i = 0; i < len; i++) {
        pwd += chars.charAt(Math.floor(Math.random() * maxPos));
    }
    return pwd;
}

function get_suffix(filename) {
    pos = filename.lastIndexOf('.');
    suffix = '';
    if (pos !== -1) {
        suffix = filename.substring(pos)
    }
    return suffix;
}

function calculate_object_name(filename) {
    suffix = get_suffix(filename);
    g_object_name = key + $("#info-username").text() + "_" + random_string(5) + suffix;
    return ''
}

function set_upload_param(filename, url) {
    get_signature(url);
    g_object_name = key;
    if (filename !== '') {
        calculate_object_name(filename)
    }
}

//选择器指的是：$(xxx) 即使用jquery的元素选择器
//上传视频，提供进度支持，细节需要自定义
// bar是可以改变宽度的进度条，value是相对应的进度数字选择器（可选，可传null），applicationId是本次上传视频的关联报名Id
function uploadVideo(fileSelector, progressBarSelector, progressValueSelector, applicationId) {
    expire = 0;//设置立即过期
    progressBarSelector.removeAttr("hidden");
    set_upload_param(fileSelector[0].files[0].name, "/upload/videoPolicy/" + applicationId);
    expire = 0;
    var formData = new FormData();
    formData.append("key", g_object_name);
    formData.append("policy", policyBase64);
    formData.append("callback", callbackbody);
    formData.append("OSSAccessKeyId", accessid);
    formData.append("success_action_status", 200);
    formData.append("x:application_id", applicationId);
    formData.append("signature", signature);
    formData.append("file", fileSelector[0].files[0]); //append()里面的第一个参数file对应permission/upload里面的参数file
    $.ajax({
        type: "post",
        async: true, //这里要设置异步上传，才能成功调用myXhr.upload.addEventListener('progress',function(e){}),progress的回掉函数
        Accept: 'text/html;charset=UTF-8',
        data: formData,
        contentType: "multipart/form-data",//不要动
        url: host,
        processData: false, // 告诉jQuery不要去处理发送的数据
        contentType: false, // 告诉jQuery不要去设置Content-Type请求头
        xhr: function () {
            myXhr = $.ajaxSettings.xhr();
            if (myXhr.upload) { // check if upload property exists
                myXhr.upload.addEventListener('progress', function (e) {
                    var loaded = e.loaded; //已经上传大小情况
                    var total = e.total; //附件总大小
                    var percent = Math.floor(100 * loaded / total) + "%"; //已经上传的百分比
                    progressBarSelector.css("width", percent);
                    if (progressBarSelector != null)
                        progressValueSelector.text(percent);
                }, false);
            }
            return myXhr;
        },
        /**
         修改回显在这里修改
         **/
        success: function (data) {
            if (data.code == null) {//正常上传返回的是服务器的返回信息，为null说明返回的是oss给的错误
                alert("服务端出现错误，请联系管理员");
            } else if (data.code != 1) {//有code是服务器返回的信息
                alert(data.msg);
            }else{
                alert("上传视频成功!");
            }
        },
        error: function () {//后端验证文件大小不符合要求或者纂改签名
            alert("上传失败！请检查文件大小");
        }
    });
    expire = 0;
}

//上传图片，参数无可选项，fileSelector为上传框的选择器
//filenameSelector是一个带有数据库字段对应name的input标签选择器，value是上传成功后图片的url，上传成功后自动更新，该input用于在表单中提交，写入数据库
function uploadImage(fileSelector, filenameSelector,labelElement) {
    set_upload_param(fileSelector[0].files[0].name, "/upload/imagePolicy");
    var formData = new FormData();
    formData.append("key", g_object_name);
    formData.append("policy", policyBase64);
    formData.append("callback", callbackbody);
    formData.append("OSSAccessKeyId", accessid);
    formData.append("success_action_status", 200);
    if (filenameSelector.val().length > 0)
        formData.append("x:image", filenameSelector.val());
    formData.append("signature", signature);
    formData.append("file", fileSelector[0].files[0]); //append()里面的第一个参数file对应permission/upload里面的参数file
    $.ajax({
        type: "post",
        async: true, //这里要设置异步上传，才能成功调用myXhr.upload.addEventListener('progress',function(e){}),progress的回掉函数
        Accept: 'text/html;charset=UTF-8',
        data: formData,
        contentType: "multipart/form-data",//不要动
        url: host,
        processData: false, // 告诉jQuery不要去处理发送的数据
        contentType: false, // 告诉jQuery不要去设置Content-Type请求头
        /**
         修改回显在这里修改
         **/
        success: function (data) {
            if (data.code == null) {//正常上传返回的是服务器的返回信息，为null说明返回的是oss给的错误
                alert("服务端出现错误，请联系管理员");
            } else if (data.code != 1) {//有code是服务器返回的信息
                labelElement.attr("class", "table-danger");
                alert(data.msg);
            } else {
                filenameSelector.val(data.data);//赋值value
                labelElement.attr("class","table-info");
                alert("上传成功!");
            }
        },
        error: function () {//后端验证文件大小不符合要求或者纂改签名
            labelElement.attr("class", "table-danger");
            alert("上传失败！请检查文件大小");
        }
    });
}

function uploadZip(fileSelector, filenameSelector, labelElement) {
    expire= 0;
    set_upload_param(fileSelector[0].files[0].name, "/upload/zipPolicy");
    expire = 0;
    var formData = new FormData();
    formData.append("key", g_object_name);
    formData.append("policy", policyBase64);
    formData.append("callback", callbackbody);
    formData.append("OSSAccessKeyId", accessid);
    formData.append("success_action_status", 200);
    if (filenameSelector.val().length > 0)
        formData.append("x:zip", filenameSelector.val());
    formData.append("signature", signature);
    formData.append("file", fileSelector[0].files[0]); //append()里面的第一个参数file对应permission/upload里面的参数file
    $.ajax({
        type: "post",
        async: true, //这里要设置异步上传，才能成功调用myXhr.upload.addEventListener('progress',function(e){}),progress的回掉函数
        Accept: 'text/html;charset=UTF-8',
        data: formData,
        contentType: "multipart/form-data",//不要动
        url: host,
        processData: false, // 告诉jQuery不要去处理发送的数据
        contentType: false, // 告诉jQuery不要去设置Content-Type请求头
        /**
         修改回显在这里修改
         **/
        success: function (data) {
            if (data.code == null) {//正常上传返回的是服务器的返回信息，为null说明返回的是oss给的错误

                alert("服务端出现错误，请联系管理员");
            } else if (data.code != 1) {//有code是服务器返回的信息
                labelElement.attr("class", "table-danger");
                alert(data.msg);
            } else {
                filenameSelector.val(data.data);//赋值value
                labelElement.attr("class", "table-info");
                alert("上传成功!");
            }
        },
        error: function () {//后端验证文件大小不符合要求或者纂改签名
            labelElement.attr("class", "table-danger");
            alert("上传失败！请检查文件大小");
        }
    });
}
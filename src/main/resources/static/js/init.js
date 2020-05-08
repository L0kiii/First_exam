var Name;
var username;

function initUserInfo() {
    $.ajax({
        url: "/api/users/self",
        method: "get",
        success: (data) => {
            Name = data.data.name;
            username = data.data.username;
            $("#info-name").text(Name);
            $("#info-username").text(username);
        }
    })
}

initUserInfo();
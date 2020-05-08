package cn.rend.applysystem.service;

import cn.rend.applysystem.controller.UploadController;
import cn.rend.applysystem.pojo.po.Application;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.*;

@SpringBootTest
public class applicationServiceTest {
    @Autowired
    public ApplicationService applicationService;

    @Test
    public void countTest() {
        System.out.println(applicationService.count());
        QueryWrapper<Application> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", 12);
        System.out.println(applicationService.count(queryWrapper));
    }


    @Test
    public void ossDelete() {
        UploadController up = new UploadController();
        up.deleteObject("2020/04/12/image/AHfRRtTcP8.png");
    }

    @Test
    public void videoInfoTest() {
        List<Map<String, Object>> maps = applicationService.selectVideoInfoById(14L);
        System.out.println(maps);
    }

    @Test
    public void applicationsGen() {
        Date now = new Date();
        Random df = new Random();
        String[] names = new String[]{"梦琪", "忆柳", "之桃", "慕青", "问兰", "尔岚", "元香", "初夏", "沛菡", "傲珊", "曼文", "乐菱", "痴珊", "恨玉", "惜文", "香寒", "新柔", "语蓉", "海安", "夜蓉", "涵柏", "水桃", "醉蓝", "春儿", "语琴", "从彤", "傲晴", "语兰", "又菱", "碧彤", "元霜", "怜梦", "紫寒", "妙彤", "曼易", "南莲", "紫翠", "雨寒", "易烟", "如萱", "若南", "寻真", "晓亦", "向珊", "慕灵", "以蕊", "寻雁", "映易", "雪柳", "孤岚", "笑霜", "海云", "凝天", "沛珊", "寒云", "冰旋", "宛儿", "绿真", "盼儿", "晓霜", "碧凡", "夏菡", "曼香", "若烟", "半梦", "雅绿", "冰蓝", "灵槐", "平安", "书翠", "翠风", "香巧", "代云", "梦曼", "幼翠", "友巧", "听寒", "梦柏", "醉易", "访旋", "亦玉", "凌萱", "访卉", "怀亦", "笑蓝", "春翠", "靖柏", "夜蕾", "冰夏", "梦松", "书雪", "乐枫", "念薇", "靖雁", "寻春", "恨山", "从寒", "忆香", "觅波", "静曼", "凡旋", "以亦", "念露", "芷蕾", "千兰", "新波", "代真", "新蕾", "雁玉", "冷卉", "紫山", "千琴", "恨天", "傲芙", "盼山", "怀蝶", "冰兰", "山柏", "翠萱", "恨松", "问旋", "从南", "白易", "问筠", "如霜", "半芹", "丹珍", "冰彤", "亦寒", "寒雁", "怜云", "寻文", "乐丹", "翠柔", "谷山", "之瑶", "冰露", "尔珍", "谷雪", "乐萱", "涵菡", "海莲", "傲蕾", "青槐", "冬儿", "易梦", "惜雪", "宛海", "之柔", "夏青", "亦瑶", "妙菡", "春竹", "痴梦", "紫蓝", "晓巧", "幻柏", "元风", "冰枫", "访蕊", "南春", "芷蕊", "凡蕾", "凡柔", "安蕾", "天荷", "含玉", "书兰", "雅琴", "书瑶", "春雁", "从安", "夏槐", "念芹", "怀萍", "代曼", "幻珊", "谷丝", "秋翠", "白晴", "海露", "代荷", "含玉", "书蕾", "听白", "访琴", "灵雁", "秋春", "雪青", "乐瑶", "含烟", "涵双", "平蝶", "雅蕊", "傲之", "灵薇", "绿春", "含蕾", "从梦", "听兰", "听蓉", "语芙", "夏彤", "凌瑶", "忆翠", "幻灵", "怜菡", "紫南", "依珊", "妙竹", "访烟", "怜蕾", "映寒", "友绿", "冰萍", "惜霜", "凌香", "芷蕾", "雁卉", "迎梦", "元柏", "代萱", "紫真", "千青", "凌寒", "紫安", "寒安", "怀蕊", "秋荷", "涵雁", "以山", "凡梅", "盼曼", "翠彤", "谷冬", "新巧", "冷安", "千萍", "冰烟", "雅阳", "友绿", "南松", "诗云", "飞风", "寄灵", "书芹", "幼蓉", "以蓝", "笑寒", "忆寒", "秋烟", "芷巧", "水香", "映之", "醉波", "幻莲", "夜山", "芷卉", "向彤", "小玉", "幼南", "凡梦", "尔曼", "念波", "迎松", "青寒", "笑天", "涵蕾", "碧菡", "映秋", "盼烟", "忆山", "以寒", "寒香", "小凡", "代亦", "梦露", "映波", "友蕊", "寄凡", "怜蕾", "雁枫", "水绿", "曼荷", "笑珊", "寒珊", "谷南", "慕儿", "夏岚", "友儿", "小萱", "紫青", "妙菱", "冬寒", "曼柔", "语蝶", "青筠", "夜安", "觅海", "问安", "晓槐", "雅山", "访云", "翠容", "寒凡", "晓绿", "以菱", "冬云", "含玉", "访枫", "含卉", "夜白", "冷安", "灵竹", "醉薇", "元珊", "幻波", "盼夏", "元瑶", "迎曼", "水云", "访琴", "谷波", "乐之", "笑白", "之山", "妙海", "紫霜", "平夏", "凌旋", "孤丝", "怜寒", "向萍", "凡松"};
        String[] professionName = new String[]{"竹笛", "笙", "唢呐", "扬琴", "柳琴", "中阮", "琵琶", "古筝", "古琴", "二胡", "板胡", "三弦", "民打"};
        String[] professioncategory = new String[]{"声乐", "钢琴调律", "理论作曲", "舞蹈表演", "中国乐器演奏", "管乐乐器演奏", "弦乐乐器演奏", "键盘乐器演奏", "现代乐器演奏"};
        for (int i = 0; i < names.length; i++) {
            Application application = new Application();
            application.setUserId(i + 50);
            application.setName(names[i]);
            application.setProfessionalName(professionName[(int) (Math.random() * professionName.length)]);
            application.setProfessionalCategory(professioncategory[(int) (Math.random() * professioncategory.length)]);
            application.setStage(df.nextInt(10));
            application.setStatus(df.nextInt(2));
            application.setUserIdNum(getRandomID());
            application.setCreatedAt(now);
            applicationService.save(application);
            System.out.println(i);
        }
    }

    public String getRandomID() {
        String id = "420222199204179999";
        // 随机生成省、自治区、直辖市代码 1-2
        String provinces[] = {"11", "12", "13", "14", "15", "21", "22", "23",
                "31", "32", "33", "34", "35", "36", "37", "41", "42", "43",
                "44", "45", "46", "50", "51", "52", "53", "54", "61", "62",
                "63", "64", "65", "71", "81", "82"};
        String province = randomOne(provinces);
        // 随机生成地级市、盟、自治州代码 3-4
        String city = randomCityCode(18);
        // 随机生成县、县级市、区代码 5-6
        String county = randomCityCode(28);
        // 随机生成出生年月 7-14
        String birth = randomBirth(20, 50);
        // 随机生成顺序号 15-17(随机性别)
        String no = new Random().nextInt(899) + 100 + "";
        // 随机生成校验码 18
        String checks[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "X"};
        String check = randomOne(checks);
        // 拼接身份证号码
        id = province + city + county + birth + no + check;
        return id;
    }

    /**
     * 从String[] 数组中随机取出其中一个String字符串
     *
     * @param s
     * @return
     * @author mingzijian
     */
    public String randomOne(String s[]) {
        return s[new Random().nextInt(s.length - 1)];
    }

    /**
     * 随机生成两位数的字符串（01-max）,不足两位的前面补0
     *
     * @param max
     * @return
     * @author mingzijian
     */
    public String randomCityCode(int max) {
        int i = new Random().nextInt(max) + 1;
        return i > 9 ? i + "" : "0" + i;
    }

    /**
     * 随机生成minAge到maxAge年龄段的人的生日日期
     *
     * @param minAge
     * @param maxAge
     * @return
     * @author mingzijian
     */
    public String randomBirth(int minAge, int maxAge) {
        SimpleDateFormat dft = new SimpleDateFormat("yyyyMMdd");// 设置日期格式
        Calendar date = Calendar.getInstance();
        date.setTime(new Date());// 设置当前日期
        // 随机设置日期为前maxAge年到前minAge年的任意一天
        int randomDay = 365 * minAge
                + new Random().nextInt(365 * (maxAge - minAge));
        date.set(Calendar.DATE, date.get(Calendar.DATE) - randomDay);
        return dft.format(date.getTime());
    }

}

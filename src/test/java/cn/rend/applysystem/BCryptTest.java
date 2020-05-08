package cn.rend.applysystem;

import cn.rend.applysystem.utils.BCrypt;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BCryptTest {
    @Test
    public void pswTest() {
        String pwd = "1";
        String genPwd = BCrypt.hashpw(pwd, BCrypt.gensalt());
        System.out.println(BCrypt.checkpw(pwd, genPwd));
        System.out.println(genPwd);
    }
}

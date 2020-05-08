package cn.rend.applysystem.service;

import cn.rend.applysystem.pojo.po.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.dozer.DozerBeanMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private DozerBeanMapper defaultDozerMapper;

    @Test
    public void saveUserTest() {
        User user = new User(7L, "123123", "123123", "123123", "123", "123123", new Date());
        System.out.println(userServiceImpl.saveOrUpdate(user));
        user.setName("修改后");
        System.out.println(userServiceImpl.saveOrUpdate(user));
    }

    @Test
    public void queryWrapperLinkTest() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        ArrayList<String> strings = new ArrayList<>();
        strings.add("id");
        strings.add("username");
        queryWrapper.select(strings.toArray(new String[0]));
        System.out.println(userServiceImpl.selectList(queryWrapper));
    }

    @Test
    void selectUserTest() {
        System.out.println(userServiceImpl.getById(1));
    }

    @Test
    void deleteTest() {
        System.out.println(userServiceImpl.removeById(6));
    }

    @Test
    void selectListObjsTest() {
        List<Object> objects = userServiceImpl.getBaseMapper().selectObjs(null);
        System.out.println(objects);
    }
}

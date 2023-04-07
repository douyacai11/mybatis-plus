package com.douya;

import com.douya.entity.User;
import com.douya.service.UserService;
import com.douya.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;

@SpringBootTest
public class ServiceTests {


    @Resource
    private UserService userService ;


    @Test
    void countTest() {
        int count = userService.count();
        System.out.println("count = " + count);
    }



    @Test
    void testSaveBatch() {

        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            User user = new User();
            user.setName("花花"+i);
            user.setAge(20+i);
            users.add(user);
        }

        userService.saveBatch(users);
    }

}

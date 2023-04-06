package com.douya;

import com.douya.entity.User;
import com.douya.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * selectBatchIds 根据给定的集合id查询
 * selectByMap   根据给定的map键值对来 条件查询
 *
 * */

@SpringBootTest
public class MapperTests {
    @Resource
    private UserMapper userMapper;


    @Test
    void testInsert() {
        User user = new User();
        user.setName("豆芽");
        user.setAge(20);
        user.setEmail("douya@qq.com");
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());

        int result = userMapper.insert(user);
        System.out.println("result = " + result);
    }

    @Test
    void testSelect() {
        User user = userMapper.selectById(1);
        System.out.println("user = " + user);


        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);


        Map<String, Object> map = new HashMap<>();
        map.put("name","建国");
        map.put("age",74);
        List<User> users1 = userMapper.selectByMap(map);
        users1.forEach(System.out::println);
    }


    @Test
    void update() {
        User user = new User();
        user.setId(1L);
        user.setAge(74);
        int i = userMapper.updateById(user);
        System.out.println("i = " + i);
    }

    @Test
    void delete() {
        int i = userMapper.deleteById(1642910069565296642L);
        System.out.println("i = " + i);
    }

    @Test
    void selectAllByName() {
        List<User> jone = userMapper.selectAllByName("Jone");
        jone.forEach(System.out::println);
    }
}

package com.douya;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.douya.entity.User;
import com.douya.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class WrapperTests {

    @Resource
    private UserMapper userMapper;


    //查询名字中包含n，年龄大于等于10且小于等于20，email不为空的用户
    @Test
    void test1() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        queryWrapper.like("name","n")
                    .between("age",51,80)
                    .isNotNull("email");


        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

    }

    //按年龄降序查询用户，如果年龄相同则按id升序排列
    @Test
    void test2() {

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //组装排序条件
        queryWrapper.orderByDesc("age")
                    .orderByAsc("id");


        List<User> users = userMapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    //删除email为空的用户
    @Test
    void test3() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.isNull("email");

        int i = userMapper.delete(queryWrapper);
        System.out.println("删除email为空的用户有"+i+"条记录");
    }


    //查询所有用户的用户名和年龄
    @Test
    void test4() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","age");
        List<Map<String, Object>> maps = userMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);
    }

    //condition的使用 避免多一部的判断空值
    //查询名字中包含n，年龄大于10且小于20的用户，查询条件来源于用户输入，是可选的
    @Test
    void test5(String name,Integer ageBegin,Integer ageEnd) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(name),"name",name);
        queryWrapper.ge(ageBegin!=null,"age",10);
        queryWrapper.le(ageEnd!=null,"age",20);
    }
}

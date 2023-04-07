package com.douya;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.douya.entity.Product;
import com.douya.entity.User;
import com.douya.mapper.ProductMapper;
import com.douya.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class InterceptorTests {

    @Resource
    private UserMapper userMapper;

    @Resource
    private ProductMapper productMapper;


    @Test
    void testSelectPage() {
        Page<User> pageParam = new Page<>(1, 5);
        userMapper.selectPage(pageParam,null);


        List<User> users = pageParam.getRecords();
        users.forEach(System.out::println);


    }

    @Test
    void testPageByAge() {
        Page<User> pageParam = new Page<>(1,5);
        userMapper.selectPageByAge(pageParam,18);

        List<User> users = pageParam.getRecords();
        users.forEach(System.out::println);
    }

    @Test
    void concurrentUpdate() {
        //小李取数据
        Product p1 = productMapper.selectById(1l);
        //小王取数据
        Product p2 = productMapper.selectById(1l);

        //小李修改 +50
        p1.setPrice(p1.getPrice()+50);
        int result1 = productMapper.updateById(p1);
        System.out.println("小李修改的结果"+result1);

        //小王修改 -30
        p2.setPrice(p2.getPrice()-30);
        int result2 = productMapper.updateById(p2);
        System.out.println("小王修改的结果"+result2);
        if (result2 ==0){
            //重新获取数据
            Product p22 = productMapper.selectById(1l);
            p22.setPrice(p22.getPrice()-30);
            int result = productMapper.updateById(p22);
            System.out.println("小王重试的结果 = " + result);
        }

        //老板看价格
        Product p3 = productMapper.selectById(1l);
        System.out.println("最终价格"+p3.getPrice());

    }
}

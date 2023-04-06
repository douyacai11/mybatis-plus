package com.douya.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.douya.entity.User;
import com.douya.mapper.UserMapper;
import com.douya.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{
    /**
     * 先继承ServiceImpl ,这里的ServiceImpl看源码 得出它继承的是Mybatis Plus中的IService
     * 可以继承Mybatis Plus中绝大多数的方法了
     *
     * 再实现 自己定义的UserService接口  ，就可以实现自己在接口中定义的一些方法；
     *
     */

    @Override
    public List<User> selectAllByName(String name) {
        return baseMapper.selectAllByName(name);
    }

}

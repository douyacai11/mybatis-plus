package com.douya.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.douya.entity.User;

import java.util.List;

public interface UserService extends  IService<User> {

    //接口 此处可以自己定义 Mybatis Plus中没有的方法

    List<User> selectAllByName(String name);
}

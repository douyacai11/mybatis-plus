package com.douya.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.douya.entity.User;

import java.util.List;


public interface UserMapper extends BaseMapper<User> {

       List<User> selectAllByName(String name);
}

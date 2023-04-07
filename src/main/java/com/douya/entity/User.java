package com.douya.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName(value = "t_user")
public class User {

//    @TableId(type = IdType.ASSIGN_ID)

//    @TableId(type = IdType.AUTO)  可以在配置文件中设置全局(数据库中所有实体类 主键自增
    private Long id;
    private String name;
    private Integer age;
    private String email;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;


    @TableLogic
    @TableField(value = "is_deleted")
    private boolean deleted;


}

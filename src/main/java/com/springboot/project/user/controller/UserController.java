package com.springboot.project.user.controller;

import com.springboot.common.util.RestfulBean;
import com.springboot.project.user.data.UserData;
import com.springboot.project.user.model.bo.User;
import com.springboot.project.user.model.dao.UserDao;
import com.springboot.web.util.BaseController;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/project/user")
public class UserController extends BaseController {
    @Autowired
    UserDao userDao;

    @PostMapping
    public ResponseEntity<RestfulBean<Object>> add(@RequestBody UserData bean) {
        User data = new User();
        BeanUtils.copyProperties(bean,data);
        this.userDao.save(data);
        return success(data);
    }

    @GetMapping
    public String user() {
        return "user";
    }

    @GetMapping("/getUserName")
    public String getUserName() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
}

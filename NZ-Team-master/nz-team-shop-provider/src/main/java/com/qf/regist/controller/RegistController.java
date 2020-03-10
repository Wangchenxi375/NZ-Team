package com.qf.regist.controller;


import com.qf.regist.service.IregistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qf.dto.ResultBean;


import javax.mail.internet.MimeMessage;

@RestController
@RequestMapping("user")
public class RegistController {

    @Autowired
    private IregistService registService;

    @RequestMapping("regist/{uname}/{password}")
    public ResultBean regist(@PathVariable String uname, @PathVariable String password){
        return registService.regist(uname,password);
    }

}

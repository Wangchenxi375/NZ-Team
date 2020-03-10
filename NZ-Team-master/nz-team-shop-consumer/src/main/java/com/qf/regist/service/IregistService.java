package com.qf.regist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import qf.dto.ResultBean;

@FeignClient("regist-service")
public interface IregistService {

    @RequestMapping("user/regist")
    ResultBean regist(@RequestParam String uname, @RequestParam String password);
}

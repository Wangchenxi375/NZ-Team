package com.qf.service;

import com.qf.constant.CookieConstant;
import com.qf.dto.ResultBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@FeignClient(value = "cart-service")
public interface IcartService {
//添加商品到购物车
    @RequestMapping("add/{productId}/{count}")
    public ResultBean addProduct(@CookieValue(name = CookieConstant.USER_CART, required = false) String uuid,
                                 @PathVariable Long productId,
                                 @PathVariable int count,
                                 HttpServletResponse response);


//清空购物车
    @RequestMapping("/clean")
    public ResultBean cleanCart(@CookieValue(name=CookieConstant.USER_CART,required = false)String uuid,HttpServletResponse response);



//更新购物车
    @RequestMapping("update/{productId}/{count}")
    public ResultBean updateCart(
            @PathVariable Long productId,
            @PathVariable int count,
            @CookieValue(name=CookieConstant.USER_CART,required = false)String uuid);


//查看购物车
    @RequestMapping("/show")
    public ResultBean showCart(@CookieValue(name=CookieConstant.USER_CART,required = false)String uuid);

    @RequestMapping("/merge")
    public ResultBean merge(@CookieValue(name = CookieConstant.USER_CART,required = false)String uuid,
                            HttpServletRequest request, HttpServletResponse response);
    }

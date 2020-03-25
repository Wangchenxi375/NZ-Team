package com.qf.controller;

import com.qf.constant.CookieConstant;
import com.qf.dto.ResultBean;
import com.qf.service.IcartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CartController {
    @Autowired
    private IcartService icartService;
    //添加商品到购物车
    @RequestMapping("add/{productId}/{count}")
    public ResultBean addProduct(@CookieValue(name = CookieConstant.USER_CART, required = false) String uuid,
                                 @PathVariable Long productId,
                                 @PathVariable int count,
                                 HttpServletResponse response){
        return icartService.addProduct(uuid, productId, count, response);
    }


    //清空购物车
    @RequestMapping("/clean")
    public ResultBean cleanCart(@CookieValue(name=CookieConstant.USER_CART,required = false)String uuid,HttpServletResponse response){
        return icartService.cleanCart(uuid, response);
    }



    //更新购物车
    @RequestMapping("update/{productId}/{count}")
    public ResultBean updateCart(
            @PathVariable Long productId,
            @PathVariable int count,
            @CookieValue(name=CookieConstant.USER_CART,required = false)String uuid){
        return icartService.updateCart(productId, count, uuid);
    }


    //查看购物车
    @RequestMapping("/show")
    public ResultBean showCart(@CookieValue(name=CookieConstant.USER_CART,required = false)String uuid){
        return icartService.showCart(uuid);
    }
    /**
     * 合并两种状态下的购物车
     * @param uuid
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/merge")
    public ResultBean merge(@CookieValue(name = CookieConstant.USER_CART,required = false)String uuid,
                            HttpServletRequest request, HttpServletResponse response){
        return icartService.merge(uuid, request, response);
    }



}

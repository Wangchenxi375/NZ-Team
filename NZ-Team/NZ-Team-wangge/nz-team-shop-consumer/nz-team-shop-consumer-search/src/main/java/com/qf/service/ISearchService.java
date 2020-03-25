package com.qf.service;

import com.qf.dto.ResultBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "search-service")
public interface ISearchService {
    @RequestMapping("/select")
    public String searchByKeyword(String keyword);

    @RequestMapping("/addProduct")
    public ResultBean addProduct(Long pid);
}

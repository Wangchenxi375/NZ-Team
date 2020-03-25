package com.qf.controller;

import com.qf.dto.ResultBean;
import com.qf.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class SearchController {
   @Autowired
    private ISearchService searchService;

    @RequestMapping("/select")
    public String searchByKeyword(String keyword){

      return searchService.searchByKeyword(keyword);




    }


    @RequestMapping("/addProduct")
    public ResultBean addProduct(Long pid){

        return searchService.addProduct(pid);


    }

}

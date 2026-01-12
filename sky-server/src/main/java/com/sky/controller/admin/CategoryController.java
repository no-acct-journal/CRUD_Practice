package com.sky.controller.admin;


import com.sky.dto.EmployeeDTO;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * catalog management
 */
@RestController
@RequestMapping("/admin/category")
@Slf4j
@Api(tags = "categoryApi")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    /**
     * update category
     *
     * @param
     * @return
     */
    @PutMapping
    @ApiOperation("update category")
    public Result update(@RequestBody CategoryDTO categoryDTO){
        log.info("update category:{}",categoryDTO);
        categoryService.update(categoryDTO);
        return Result.success();
    }

    /**
     * category page query
     *
     * @param
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("category page query")
    public Result<PageResult> page(CategoryPageQueryDTO categoryPageQueryDTO){
        log.info("category page query:{}",categoryPageQueryDTO);
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }


}

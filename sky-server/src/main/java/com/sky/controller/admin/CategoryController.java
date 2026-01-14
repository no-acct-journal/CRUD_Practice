package com.sky.controller.admin;


import com.sky.dto.EmployeeDTO;
import com.sky.entity.Category;
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
import java.util.List;
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

    /**
     * start or stop
     *
     * @param
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("start or stop category")

    public Result startOrStop(@PathVariable Integer status, Long id){
        log.info("start or stop:{},{}",status,id);
        categoryService.startOrStop(status,id);
        return Result.success();
    }

    @PostMapping
    @ApiOperation("new category")
    public Result save(@RequestBody CategoryDTO categoryDTO){
        log.info("new category:{}",categoryDTO);
        categoryService.save(categoryDTO);
        return Result.success();
    }

    /**
     * delet category by id
     *
     * @param
     * @return
     */
    @DeleteMapping
    @ApiOperation("deleted category by id")
    public Result delete(Long id){
        log.info("deleted category by id:{}",id);
        categoryService.delete(id);
        return Result.success();
    }

    /**
     * get category by type
     *
     * @param
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("get category by type")
    public Result<List<Category>> list(Integer type){
        log.info("get category by type:{}",type);
        List<Category> list = categoryService.list(type);
        return Result.success(list);
    }
}

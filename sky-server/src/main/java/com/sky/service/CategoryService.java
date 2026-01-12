package com.sky.service;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    /**
     * update category
     * @param categoryDTO
     */
    void update(CategoryDTO categoryDTO);

    /**
     * Paginated query
     * @param categoryPageQueryDTO
     * @return
     */
    PageResult pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    /**
     * start or stop
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);

    /**
     * new category
     * @param categoryDTO
     */
    void save(CategoryDTO categoryDTO);

    /**
     * delete category
     * @param id
     */
    void delete(Long id);

    /**
     * get category list
     * @param type
     * @return
     */
    List list(Integer type);
}

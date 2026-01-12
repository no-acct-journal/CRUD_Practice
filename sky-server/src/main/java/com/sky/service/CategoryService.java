package com.sky.service;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.result.PageResult;
import org.springframework.stereotype.Service;

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
}

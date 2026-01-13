package com.sky.service.impl;

import com.sky.dto.DishDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.service.DishService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
public class DishServicelmpl implements DishService {

    private DishMapper dishMapper;

    private DishFlavorMapper dishFlavorMapper;

    /**
     * 新增菜品，同时保存对应的口味数据
     * @param dishDTO
     */
    @Override
    @Transactional
    public void saveWithFlavor(DishDTO dishDTO) {
        //向菜品中加入1条数据
        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO, dish);
        dishMapper.insert(dish);

        //向口味表插入n条数据
        List<DishFlavor> flavors = dishDTO.getFlavors();

        if (flavors != null && flavors.size() > 0) {
            for (DishFlavor flavor : flavors) {
                flavor.setDishId(dish.getId());
            }
            dishFlavorMapper.insertBatch(flavors);
        }

    }
}

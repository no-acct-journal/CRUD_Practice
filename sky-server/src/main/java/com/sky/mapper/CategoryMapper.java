package com.sky.mapper;


import com.github.pagehelper.Page;
import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


@Mapper
public interface CategoryMapper {


    void update(Category category);


    Page<Category> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO);

    @Insert("insert into category (type, name, sort, create_time, update_time, create_user, update_user) select #{type}, #{name}, #{sort}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser} from dual where not exists (select 1 from category where name = #{name} or sort = #{sort})")
    void insert(Category category);

    /**
     * delete category
     * @param id
     */
    @Delete("delete from category where id = #{id}")
    void deleteById(Long id);


    @Select("select * from category where type = #{type} order by sort")
    List<Category> list(Integer type);
}

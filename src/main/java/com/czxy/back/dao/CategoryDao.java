package com.czxy.back.dao;

import com.czxy.back.bean.Category;

import java.util.List;


public interface CategoryDao {

    /**
     * 根据id查询
     * @param id
     * @return
     */
    public Category getCategoryById(Integer id);

    /**
     * 查询商品的所有分类
     * @return
     */
    List<Category> getAllCategory();

}

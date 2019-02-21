package com.czxy.back.service;

import com.czxy.back.bean.Category;

import java.util.List;

public interface CategoryService {

    /**
     * 获取所有的分类
     * @return
     */
    List<Category> getAllCategory();

    /**
     * 添加分类
     * @param category
     * @return
     */
    boolean addCategory(Category category);
}

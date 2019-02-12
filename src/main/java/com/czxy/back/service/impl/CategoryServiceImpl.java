package com.czxy.back.service.impl;

import com.czxy.back.bean.Category;
import com.czxy.back.dao.CategoryDao;
import com.czxy.back.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("categoryService")
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    /**
     * 获取所有的商品分类
     * @return
     */
    @Override
    public List<Category> getAllCategory() {
        return categoryDao.getAllCategory();
    }
}

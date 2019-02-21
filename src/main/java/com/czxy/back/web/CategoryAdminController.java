package com.czxy.back.web;

import com.czxy.back.bean.Category;
import com.czxy.back.service.CategoryService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/category")
public class CategoryAdminController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/getallcategory", method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> getAllCategory(){
        Map<String,Object> modelMap = new HashMap<>();
        List<Category> list = categoryService.getAllCategory();
        if(list != null){
            modelMap.put("success",true);
            modelMap.put("categoryList",list);
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","操作失败");
        }
        return  modelMap;
    }

    @RequestMapping(value = "/addcategory", method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> addCategory(@RequestBody Map map){
        Map<String,Object> modelMap = new HashMap<>();
        boolean result = false;
        try {
            JSONObject object = JSONObject.fromObject(map.get("category"));
            Category category = (Category) JSONObject.toBean(object,Category.class);
            result = categoryService.addCategory(category);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(result)
            modelMap.put("success",true);
        else
            modelMap.put("success",false);
        return  modelMap;
    }

}

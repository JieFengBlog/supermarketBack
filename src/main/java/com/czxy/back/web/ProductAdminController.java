package com.czxy.back.web;

import com.czxy.back.bean.Category;
import com.czxy.back.bean.Product;
import com.czxy.back.service.ProductService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/product")
public class ProductAdminController {

    @Autowired
    private ProductService productService;

    /**
     * 通过商品id获取商品信息
     *
     * @param productId
     * @return
     */
    @RequestMapping(value = "/getproductbyid", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getProductById(@RequestParam Integer productId) {
        Map<String, Object> modelMap = new HashMap<>();
        if (productId > -1) {
            Product product = productService.getProductById(productId);
            modelMap.put("product", product);
            modelMap.put("success", true);
        } else {
            modelMap.put("success", false);
            modelMap.put("errMsg", "empty productId");
        }
        return modelMap;
    }

    /**
     * 获取所有的商品
     * @return
     */
    @RequestMapping(value = "/getallproduct", method = RequestMethod.GET)
    @ResponseBody
    private Map<String, Object> getAllProduct() {
        Map<String, Object> modelMap = new HashMap<>();
        List<Product> products = productService.getAllProducts();
        modelMap.put("success",true);
        modelMap.put("products",products);
        return modelMap;
    }


    /**
     * 根据ID删除对应的商品
     * @return
     */
    @RequestMapping(value = "/deleteproductbyid", method = RequestMethod.POST)
    @ResponseBody
    private Map<String, Object> deleteProductById(@RequestBody Map map) {
       int id = (int) map.get("id");
        System.out.println(id);
        Map<String, Object> modelMap = new HashMap<>();
        Boolean result = productService.deleteProductById(id);
        if(result){
            modelMap.put("success",true);
        }else{
            modelMap.put("success",false);
        }
        return modelMap;
    }

    /**
     * 批量删除
     * @param map
     * @return
     */
    @RequestMapping(value = "/batchdeleteproduct", method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> batchDeleteProduct(@RequestBody Map map){
        Map<String, Object> modelMap = new HashMap<>();
        JSONArray jsonArray =JSONArray.fromObject(map.get("batchID"));
        System.out.println(jsonArray);
        List<Integer> list = (List<Integer>) jsonArray.toCollection(jsonArray,Integer.class);
        boolean result = productService.batchDeleteProduct(list);
        if(result){
            modelMap.put("success",true);
        }else{
            modelMap.put("success",false);
        }
        return modelMap;
    }

    /**
     * 添加商品或者更新商品
     * @param map
     * @return
     */
    @RequestMapping(value = "/addoreditproduct", method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> addOrEditProduct(@RequestBody Map map){
        Map<String,Object> modelMap = new HashMap<>();
        boolean result = false;
        Product product = new Product();
        //将传过来的json字符串转化为json
        JSONObject object = JSONObject.fromObject(map.get("product"));
        try{
            product.setName((String)object.get("name"));
            product.setPrice((Integer)object.get("price"));
            product.setProductDesc((String)object.get("productDesc"));
            Category category = new Category((Integer)object.get("category"),null);
            product.setCategory(category);
            product.setStock((Integer)object.get("stock"));
            product.setProvide((String)object.get("provide"));
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(map.get("addOrEdit"));
        if((boolean)map.get("addOrEdit")){
            product.setCreateTime(new Date());
            product.setLastEditTime(new Date());
            result = productService.addProduct(product);
        }else{
            product.setId((Integer)object.get("id"));
            product.setLastEditTime(new Date());
            result = productService.updateProduct(product);
        }
        if(result){
            modelMap.put("success",true);
        }else{
            modelMap.put("success",false);
        }
        return modelMap;
    }

    /**
     * 模糊查询
     * @param map
     * @return
     */
    @RequestMapping(value = "/selectcondition", method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> selectCondition(@RequestBody Map map){
        Map<String,Object> modelMap = new HashMap<>();
        String searchCondition = (String) map.get("searchCondition");
        System.out.println(map);
        Product product = new Product();
        product.setName(searchCondition);
        product.setProvide(searchCondition);
        List<Product> list = productService.getProductListByCondition(product);
        if(list != null){
            modelMap.put("success",true);
            modelMap.put("list",list);
        }else{
            modelMap.put("success",false);
        }
        return modelMap;
    }

    @RequestMapping(value = "/changestatus", method = RequestMethod.POST)
    @ResponseBody
    private void changeStatus(@RequestBody Map map){
        System.out.println(map);
        Product product = new Product();
        Integer id = (Integer)map.get("id");
        boolean status = (boolean) map.get("status");
        product.setId(id);
        product.setStatus(status);
        productService.updateProduct(product);
    }

}

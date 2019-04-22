package com.czxy.back.dao;

import com.czxy.back.bean.OrderDetail;
import com.czxy.back.bean.Product;
import com.czxy.back.bean.ProductCount;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductDao {

    /**
     * 根据id查询商品信息
     * @param id
     * @return
     */
     Product getProductById(Integer id);

    /**
     * 多条件查询，包含模糊查询
     * @param condition
     * @return
     */
     List<Product> getProductListByCondition(Product condition);

    /**
     * 获取所有的商品
     * @return
     */
    List<Product> getAllProducts(Integer type);

    /**
     * 根据ID删除一个信息
     * @param id
     * @return
     */
    boolean deleteProductById(Integer id);


    /**
     * 批量删除
     * @param list
     * @return
     */
    boolean batchDeleteProduct(@Param("batchDeleteList") List<Integer> list);

    /**
     * 添加一个商品
     * @param product
     * @return
     */
    boolean addProduct(Product product);

    /**
     *更新商品
     */
    boolean updateProduct(Product product);

    /**
     * 更新库存
     */
    boolean updateStockIn(@Param("orderDetails") List<OrderDetail> orderDetails);
    /**
     * 更新库存
     */
    boolean updateStockOut(@Param("orderDetails") List<OrderDetail> orderDetails);

    /**
     * 计算总的商品数
     * @return
     */
    int countProduct();

    /**
     * 查询前五条或者后五条数据
     * 1 查询前五条   0 查询后五条
     * @param type
     * @return
     */
    List<ProductCount> productCountTopAndEndFive(int type);

}

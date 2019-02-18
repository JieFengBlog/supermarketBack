package com.czxy.back.service.impl;

import com.czxy.back.service.OrderService;
import net.sf.json.JSONArray;
import org.springframework.stereotype.Service;

@Service("orderService")
public class OrderServiceImpl implements OrderService {



    @Override
    public String orderIn(String inListJSON) {
        JSONArray array = null;
        try{
            array = JSONArray.fromObject(inListJSON);
            System.out.println(array.get(1));
        }catch (Exception e){
            e.printStackTrace();
        }

        return (String)array.get(1);
    }
}

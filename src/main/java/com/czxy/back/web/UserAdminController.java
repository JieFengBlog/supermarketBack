package com.czxy.back.web;

import com.czxy.back.bean.User;
import com.czxy.back.service.UserService;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserAdminController {

    @Autowired
    private UserService userService;

    /**
     * 注册用户
     * @param map
     * @return
     */
    @RequestMapping(value = "/registeroredituser",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> registerOrEditUser(@RequestBody Map map){
        Map<String,Object> modelMap = new HashMap<>();
        boolean result = false;
        boolean addOrEdit = (boolean) map.get("addOrEdit");
        JSONObject object = JSONObject.fromObject(map.get("user"));
        User user = (User)JSONObject.toBean(object,User.class);
        if(addOrEdit){
            user.setRegisterTime(new Date());
            result = userService.addUser(user);
        }else{
            result = userService.updateUserById(user);
        }
        System.out.println(map);
        if(result)
            modelMap.put("success",true);
        else
            modelMap.put("success",false);
        return modelMap;
    }


    /**
     * 获取所有用户
     * @return
     */
    @RequestMapping(value = "/getalluser",method = RequestMethod.GET)
    @ResponseBody
    private Map<String,Object> registerUser(){
        Map<String,Object> modelMap = new HashMap<>();
        List<User> list = userService.getAllUser();
        if(list != null){
            modelMap.put("success",true);
            modelMap.put("userList",list);
        }else{
            modelMap.put("success",false);
        }
        return modelMap;
    }

    /**
     * 删除用户
     * @param map
     * @return
     */
    @RequestMapping(value = "/deleteuser",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> deleteUserById(@RequestBody Map map){
        Map<String,Object> modelMap = new HashMap<>();
        Integer id = (Integer)map.get("userId");
        boolean result = userService.deleteUserById(id);
        if(result)
            modelMap.put("success",true);
        else
            modelMap.put("success",false);
        return modelMap;
    }
}

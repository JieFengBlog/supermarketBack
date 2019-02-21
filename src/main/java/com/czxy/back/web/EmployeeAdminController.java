package com.czxy.back.web;


import com.czxy.back.bean.Employee;
import com.czxy.back.service.EmployeeService;
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
@RequestMapping("/employee")
public class EmployeeAdminController {

    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @RequestMapping(value = "/getallemployee",method = RequestMethod.GET)
    private Map<String,Object> getAllEmployee(){
        Map<String,Object> modelMap = new HashMap<>();

        List<Employee> employeeList = employeeService.getAllEmployee();
        if(employeeList != null){
            modelMap.put("success",true);
            modelMap.put("employeeList",employeeList);
        }else{
            modelMap.put("success",false);
        }
        return modelMap;
    }

    @ResponseBody
    @RequestMapping(value = "/addoreditemployee",method = RequestMethod.POST)
    private Map<String,Object> addOrEditEmployee(@RequestBody Map map){
        Map<String,Object> modelMap = new HashMap<>();
        boolean result = false;
        try{
            boolean addOrEditFlag = (boolean)map.get("addOrEdit");
            JSONObject object = JSONObject.fromObject(map.get("employee"));
            Employee employee = (Employee)JSONObject.toBean(object,Employee.class);
            System.out.println("jsonObject to bean employee: " + employee);
            if(addOrEditFlag) {
                employee.setStartTime(new Date());
                result = employeeService.insertEmployee(employee);
            }
            else {
                employee.setId(object.getInt("id"));
                result = employeeService.updateEmployeeById(employee);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        if(result)
            modelMap.put("success",true);
        else
            modelMap.put("success",false);
        return modelMap;
    }

    /**
     * 删除用户
     * @param map
     * @return
     */
    @RequestMapping(value = "/deleteemployee",method = RequestMethod.POST)
    @ResponseBody
    private Map<String,Object> deleteEmployeeById(@RequestBody Map map){
        Map<String,Object> modelMap = new HashMap<>();
        Integer id = (Integer)map.get("employeeId");
        boolean result = employeeService.deleteEmployeeById(id);
        if(result)
            modelMap.put("success",true);
        else
            modelMap.put("success",false);
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
        Employee employee = new Employee();
        employee.setName(searchCondition);
        employee.setNumber(searchCondition);
        List<Employee> employeeList = employeeService.getEmployeeListByCondition(employee);
        if(employeeList != null){
            modelMap.put("success",true);
            modelMap.put("searchEmployeeList",employeeList);
        }else{
            modelMap.put("success",false);
        }
        return modelMap;
    }

}

package com.czxy.back.service;

import com.czxy.back.bean.Employee;

import java.util.List;

public interface EmployeeService {

    /**
     * 获取所有的
     * @return
     */
    List<Employee> getAllEmployee();

    /**
     * 添加员工
     * @param employee
     * @return
     */
    boolean insertEmployee(Employee employee);

    /**
     * 根据员工id删除员工信息
     * @param id
     * @return
     */
    boolean deleteEmployeeById(Integer id);

    /**
     * 根据id更新员工信息
     * @param employee
     * @return
     */
    boolean updateEmployeeById(Employee employee);

    /**
     * 统计
     * @return
     */
    int countEmployee();

    List<Employee> getEmployeeListByCondition(Employee employee);
}

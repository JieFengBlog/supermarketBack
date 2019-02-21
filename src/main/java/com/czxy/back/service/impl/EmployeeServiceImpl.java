package com.czxy.back.service.impl;

import com.czxy.back.bean.Employee;
import com.czxy.back.dao.EmployeeDao;
import com.czxy.back.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    @Override
    public boolean insertEmployee(Employee employee) {
        return employeeDao.insertEmployee(employee);
    }

    @Override
    public boolean deleteEmployeeById(Integer id) {
        return employeeDao.deleteEmployeeById(id);
    }

    @Override
    public boolean updateEmployeeById(Employee employee) {
        return employeeDao.updateEmployeeById(employee);
    }

    @Override
    public int countEmployee() {
        return employeeDao.countEmployee();
    }

    @Override
    public List<Employee> getEmployeeListByCondition(Employee employee) {
        return employeeDao.getEmployeeListByCondition(employee);
    }
}

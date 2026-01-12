package com.sky.service;

import com.sky.dto.EmployeeLoginDTO;
import com.sky.dto.EmployeeDTO;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import com.sky.result.PageResult;

public interface EmployeeService {

    /**
     * 员工登录
     * @param employeeLoginDTO
     * @return
     */
    Employee login(EmployeeLoginDTO employeeLoginDTO);

    /**
     * new employee
     * @param employeeDTO
     * @return
     */
    void save(EmployeeDTO employeeDTO);


    /**
     * page query
     * @param employeePageQueryDTO
     * @return
     */
    PageResult pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * start or stop
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);

    /**
     * get employee by id
     * @param id
     * @return
     */
    Employee getById(Long id);

    /**
     * update employee
     * @param employeeDTO
     */
    void update(EmployeeDTO employeeDTO);
}

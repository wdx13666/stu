package com.stu.mp.service.impl;

import com.stu.mp.beans.Employee;
import com.stu.mp.mapper.EmployeeMapper;
import com.stu.mp.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wdx
 * @since 2019-01-18
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

}

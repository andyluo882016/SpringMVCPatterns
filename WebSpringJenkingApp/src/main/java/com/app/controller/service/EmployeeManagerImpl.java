package com.app.controller.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.controller.dao.*;
import com.app.controller.domain.*;

@Service
public class EmployeeManagerImpl implements EmployeeManager{

	@Autowired
    EmployeeDAO dao;
     
    public List<EmployeeVO> getAllEmployees()
    {
        return dao.getAllEmployees();
    }
}

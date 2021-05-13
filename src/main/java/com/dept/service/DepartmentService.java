package com.dept.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dept.core.Department;
import com.dept.dao.DepartmentDAO;

@Service
public class DepartmentService {
	Logger logger = LoggerFactory.getLogger(DepartmentService.class);
	
	@Autowired
	DepartmentDAO departmentDAO;

	public List<Department> getDeptList() {
		logger.info("Inside DepartmentService...");
		return departmentDAO.getDeptList();
	}

	public Department getDeptById(Integer deptno) {
		return departmentDAO.getDeptById(deptno);
	}
	

}

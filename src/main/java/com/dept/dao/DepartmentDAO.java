package com.dept.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dept.core.Department;

@Repository
public interface DepartmentDAO extends CrudRepository<Department, Long> {
	Logger logger = LoggerFactory.getLogger(DepartmentDAO.class);

    @Query("select d from Department d")
    public List<Department> getDeptList();

    @Query("select d from Department d where d.deptno=:deptno")
    public Department getDeptById(@Param("deptno") Integer deptno);

}

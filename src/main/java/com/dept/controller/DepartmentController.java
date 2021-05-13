package com.dept.controller;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dept.core.Department;
import com.dept.service.DepartmentService;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
	Logger logger = LoggerFactory.getLogger(DepartmentController.class);

	@Autowired
	DepartmentService departmentService;

	@GetMapping("/list")
	public List<Department> getDeptList() {
		logger.info("Inside DepartmentController...");
		return departmentService.getDeptList();
	}

	@GetMapping("/deptno/{id}")
	public Department getDeptById(@PathVariable Integer id) {
		return departmentService.getDeptById(id);
	}
	
	@GetMapping("/circuit/deptno/{id}")
	public ResponseEntity<Department> getCircutBreakByNo(@PathVariable Integer id) throws InterruptedException {
		Department dept =departmentService.getDeptById(id);
		return this.failReandomly(dept);
	}
	
	@GetMapping("/circuittimer/deptno/{id}")
	public ResponseEntity<Department> getCircutBreakTimerByNo(@PathVariable Integer id) throws InterruptedException {
		Department dept =departmentService.getDeptById(id);
		System.out.println(dept.getDname());
		Thread.sleep(ThreadLocalRandom.current().nextInt(10, 10000));
		return ResponseEntity.ok(dept);
	}
	
	
	
	public ResponseEntity<Department> failReandomly(Department dept) throws InterruptedException {
		
		Thread.sleep(100);
		
		int random = ThreadLocalRandom.current().nextInt(1,4);
		System.out.println("Random Number: "+random);
		if(random < 3)
			return ResponseEntity.status(500).build();
		return ResponseEntity.ok(dept);
		
	}

}

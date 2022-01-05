package com.cg.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.app.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer> {
	
	public  List<Student> findByAddress(String address);
	
	@Query("select s.name from Student s where s.roll=:roll")        
	public String getStudentNameByRoll(@Param("roll") int roll);


}

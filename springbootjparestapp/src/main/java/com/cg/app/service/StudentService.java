package com.cg.app.service;

import java.util.List;

import com.cg.app.model.Student;

public interface StudentService {
	
	public Student saveStudentDetails(Student student);
	
	public Student getStudentByRoll(Integer roll);
	
	public List<Student> getAllStudentDetails();
	
	public String deleteStudentByRoll(int roll);
	
	public Student giveTheGraceMarks(Integer roll,Integer graceMarks);
	
	public Student updateStudentDetails(Student student);
	
	public List<Student> getStudentDetailsByAddress(String address);
	
}

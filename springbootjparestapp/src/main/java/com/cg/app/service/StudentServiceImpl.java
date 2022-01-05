package com.cg.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.app.exception.StudentNotFoundException;
import com.cg.app.model.Student;
import com.cg.app.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentDao sdao;

	
	
	@Override
	public Student saveStudentDetails(Student student) {
		
		Student savedStudent= sdao.save(student);
		
		return savedStudent;
	}



	@Override
	public Student getStudentByRoll(Integer roll) {
	
		
		
		/*
		Optional<Student> opt= sdao.findById(roll);
		
		if(opt.isPresent()) {
			Student student= opt.get();
			return student;
		}else
			throw new StudentNotFoundException("Student does not exist with roll "+roll);
		
		*/
		
		return  sdao.findById(roll).orElseThrow(() -> new StudentNotFoundException("Student does not exist with roll "+roll));
		
		
		
	}



	@Override
	public List<Student> getAllStudentDetails() {
		
		return  sdao.findAll();
		
	}



	@Override
	public String deleteStudentByRoll(int roll) {
		
		Optional<Student> opt= sdao.findById(roll);
		
		if(opt.isPresent()) {
			
			Student student= opt.get();
			
			sdao.delete(student);
			
			return "student deleted Sucessfully";
			
		}else
			throw new StudentNotFoundException("Student does not exist with the Roll "+roll);
		
		
		
		
		
		
	}



	@Override
	public Student giveTheGraceMarks(Integer roll, Integer graceMarks) {
	
		Optional<Student> opt= sdao.findById(roll);
		
		
		if(opt.isPresent()) {
			
			
			Student student=  opt.get();
			
			student.setMarks(student.getMarks()+graceMarks);
			
			Student updatedStudent= sdao.save(student);
			
			return updatedStudent;
			
			
		}else
			throw new StudentNotFoundException("Student does not exist with the Roll "+roll);
		
		
	}



	@Override
	public Student updateStudentDetails(Student student) {
		
		Optional<Student> opt = sdao.findById(student.getRoll());
		
		if(opt.isPresent()) {
			
			Student updatedStudent =  sdao.save(student);
			
			return updatedStudent;
			
			
			
		}else
			throw new StudentNotFoundException("Student does not exist with the roll "+student.getRoll());
		
		
		
	}



	@Override
	public List<Student> getStudentDetailsByAddress(String address) {
		
		 List<Student> students= sdao.findByAddress(address);
		
		 if(students.size() > 0)
			 return students;
		 else
			 throw new StudentNotFoundException("There is no any student with the address "+address);
		
	}
	
	
	
	
	
	
	
	
	
	

}

package com.cg.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.app.model.Student;
import com.cg.app.repository.StudentDao;
import com.cg.app.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService stService;
	

/*	
	@PostMapping("/saveStudent")
	public Student registerStudent(@RequestBody Student student) {
		
		//Student savedStudent= sdao.save(student);
		//return savedStudent;
		
		return stService.saveStudentDetails(student);
	}
	
*/
	
	@PostMapping("/saveStudent")
	public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
		
		
		//Student savedStudent= sdao.save(student);
		//return savedStudent;
		
		  Student savedStudent=stService.saveStudentDetails(student);
		  System.out.println(savedStudent);
		  
		  
		  return new ResponseEntity<Student>(savedStudent,HttpStatus.CREATED);
		  
		  
		  
	}
		
	
	
	
	
	
	
	
	@GetMapping("/students/{roll}")
	public Student getStudentByRollHandler(@PathVariable int roll) {
	
		return  stService.getStudentByRoll(roll);
	}
	
	@GetMapping("/students")
	public List<Student> getAllStudentHandler(){
		
		return stService.getAllStudentDetails();
	}
	
	/*
	 * @DeleteMapping("/students/{roll}")
	 *  public String deleteStudentHandler(@PathVariable Integer roll) {
	 * 
	 * return stService.deleteStudentByRoll(roll);
	 * 
	 * }
	 */
	
	
	
	  @DeleteMapping("/students/{roll}") 
	  public ResponseEntity<String> deleteStudentHandler(@PathVariable Integer roll) {
	  
		  String result= stService.deleteStudentByRoll(roll);
		  
		  
		  ResponseEntity<String> re=new ResponseEntity<String>(result,HttpStatus.OK);
		  
		  return re;
	  }
	 
	
	  
	  @PutMapping("/giveGraceMarks/{roll}/{graceMarks}")
	  public ResponseEntity<Student> giveGraceMarksHandler(@PathVariable Integer roll, @PathVariable Integer graceMarks ){
		  
		  
		  Student updatedStudent=  stService.giveTheGraceMarks(roll, graceMarks);
		  
		  return new ResponseEntity<Student>(updatedStudent, HttpStatus.OK);
		  
		  
	  }
	  
	  
	  @PutMapping("/updateStudent")
	  public Student updateStudentHandler(@RequestBody Student student) {
		  
		  return stService.updateStudentDetails(student);
	  }
	
	
	  @GetMapping("/getStudentsByAddress/{address}")
	  public List<Student> getAllStudentByAddressHandler(@PathVariable String address) {
		  
		 return stService.getStudentDetailsByAddress(address);
		  
	  }
	
	
	
	
}

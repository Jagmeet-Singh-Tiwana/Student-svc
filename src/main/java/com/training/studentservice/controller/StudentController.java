package com.training.studentservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.studentservice.model.Student;
import com.training.studentservice.repository.StudentRepository;

@RestController //combination of @Controller and @ResponseBody
@RequestMapping("/studapi")
public class StudentController {

	@Autowired
	StudentRepository repository;
	
	@GetMapping("/stud")
	public List<Student> getStud()
	{
//		List<Student> studList = new ArrayList<>();
//		studList.add(new Student("Raj", 21, "A+"));
//		studList.add(new Student("jags", 22, "B+"));
//	    return studList;
		
		
		return repository.findAll();
	}
	
	@PostMapping("/post")
	public void post(@RequestBody Student stud)
	{
		repository.save(stud);
	}
	
	@GetMapping("/stud/{id}")
	public Student getStudById(@PathVariable("id") long id)
	{
		Optional<Student> stud = repository.findById(id);
		
		if(stud.isPresent())
		{
			return stud.get();
		}
		else
		{
			return null;
		}
	}
	
	@PostMapping("/stud")
	public Student getStud(@PathVariable("id") long id)
	{
		Optional<Student> stud = repository.findById(id);
		
		if(stud.isPresent())
		{
			return stud.get();
		}
		else
		{
			return null;
		}
	}
	
	public void updateUser(@PathVariable("id") long id, @RequestBody Student stud)
	{
		Optional<Student> oldData = repository.findById(id);
		
		if(oldData.isPresent()) {
			Student std = oldData.get();
			std.setAge(stud.getAge());
			std.setGrade(stud.getGrade());
			std.setStudName(stud.getStudName());
		}
		else
		{
			System.out.println("No data Found");
		}
	}
}



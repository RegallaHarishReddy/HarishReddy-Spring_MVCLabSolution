package com.studentmanagement.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.studentmanagement.entity.Student;
import com.studentmanagement.service.IStudentService;


@Controller
@RequestMapping("/student")
public class StudentController {
	@Autowired
	private IStudentService studentService;

	@RequestMapping("/register")
	public String registerStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "student-form";
	}

	@RequestMapping("/update")
	public String updateStudent(@RequestParam("id") int id, Model model) {
		Student student = studentService.findById(id);
		model.addAttribute("student", student);
		return "student-form";
	}

	@RequestMapping("/save")
	public String saveStudent(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		if (!name.equals("") || !department.equals("") || !country.equals("")) {
			Student student = null;
			if (id != 0) {
				student = studentService.findById(id);
				student.setName(name);
				student.setDepartment(department);
				student.setCountry(country);
			} else {
				student = new Student(name, department, country);
			}
			studentService.save(student);
			return "redirect:./registeredStudents";
		} else {
			return "redirect:./register";
		}
	}

	@RequestMapping("/delete")
	public String updateStudent(@RequestParam("id") int id) {
		studentService.deleteById(id);
		return "redirect:./registeredStudents";
	}

	@RequestMapping("/registeredStudents")
	public String listStudents(Model model) {
		System.out.println(">> in list student");
		List<Student> students = studentService.findAll();
		System.out.println(students);
		model.addAttribute("registeredStudents", students);
		return "list-student";
	}
}

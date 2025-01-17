package basic.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import basic.entity.Student;
import basic.service.StudentService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class K8SApiController {
	
	private final StudentService studentService;	
	
	// 테스트
	@GetMapping(value = "/api/actions")
	public String actionsTest() {
		return "app-with-actions version:0.0.4";
	}	
	
	// 모든 학생 조회
    @GetMapping("/api/students")
    public List<Student> getStudents() {
    	List<Student> students = studentService.getStudents();
    	return students;
    }    
    
    // ID로 학생 조회
    @GetMapping("/api/students/{id}")
    public Student getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return student;
    }        		
    
    // 새로운 학생 추가
    @PostMapping("/api/students")
    public Student registerStudent(@RequestBody Student newStudent) {
    	Student student = studentService.registerStudent(newStudent);
    	return student;
    }  
    
    // 학생 정보 수정
    @PutMapping("/api/students/{id}")
	public Student updateStudent(@RequestBody Student updateStudent, @PathVariable Long id) {
    	Student student = studentService.updateStudent(updateStudent, id);
		return student;
	}
    
    // 학생 삭제
    @DeleteMapping("/api/students/{id}")
	public Student deleteStudentById(@PathVariable Long id) {
    	Student student = studentService.deleteStudentById(id);
		return student;
	}
	
}
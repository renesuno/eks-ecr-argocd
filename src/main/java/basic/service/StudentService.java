package basic.service;

import java.util.List;

import org.springframework.stereotype.Service;

import basic.entity.Student;
import basic.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class StudentService {

	private final StudentRepository studentRepository;
	
	// 모든 학생 조회
	@Transactional
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	
	// ID로 학생 조회
	@Transactional
	public Student getStudentById(Long id) {
		return studentRepository.findById(id)
								.orElseThrow(() -> new EntityNotFoundException("정보가 존재하지 않습니다."));
	}
	
	// 새로운 학생 추가
	@Transactional
	public Student registerStudent(Student newStudent) {
		return studentRepository.save(newStudent);
	}
	
	// 학생 정보 수정
	@Transactional
	public Student updateStudent(Student updateStudent, Long id) {
		Student student = studentRepository.findById(id)
									.orElseThrow(() -> new EntityNotFoundException("정보가 존재하지 않습니다."));		
		student.setId(updateStudent.getId());
		student.setName(updateStudent.getName());		
		return student;
	}
	
	// 학생 삭제
	@Transactional
	public Student deleteStudentById(Long id) {
		Student student = studentRepository.findById(id)
									.orElseThrow(() -> new EntityNotFoundException("정보가 존재하지 않습니다."));
		studentRepository.delete(student);
		return student;
	}
}
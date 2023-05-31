package io.swagger.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import io.swagger.model.ModelApiResponse;
import io.swagger.model.Student;
import io.swagger.repository.StudentRepositoryInterface;


@ExtendWith(SpringExtension.class)
@SpringBootTest
class StudentServiceTest {
	
	  


	    @Mock
	   StudentRepositoryInterface studentRepository;

	   @InjectMocks
	    StudentService studentService;
	    

	@Test
	void testAddStudent() {
		Student student=new Student();
		
		student.setId(1);
		student.setName("John");
		student.setMarks((long) 99);
		
		Mockito.when(studentRepository.save(any(Student.class))).thenReturn(student);
		ModelApiResponse modelApiResponse = studentService.addStudent(student);
		assertNotNull(modelApiResponse);
		assertEquals(modelApiResponse.getType(), "SUCCESS");
		
	}

	@Test
	void testUpdateStudent() throws Exception {
		Student student=new Student();
		student.setId(1);
		student.setName("John");
		student.setMarks((long) 99);
		
		Mockito.when(studentRepository.findById(1)).thenReturn(Optional.of(student));
		
		
		when(studentRepository.save(any(Student.class))).thenReturn(student);
		student.setName("RAM");
		
		ModelApiResponse modelApiResponse = studentService.updateStudent(student);
		
		
		assertNotNull(modelApiResponse);
		assertEquals(student.getName(),"RAM");
		
	}

	@Test
	void testGetStudentById() throws Exception {
		
		Student student=new Student();
		
		student.setId(1);
		student.setName("John");
		student.setMarks((long) 99);
		
		Mockito.when(studentRepository.findById(1)).thenReturn(Optional.of(student));
		assertEquals(student, studentService.getStudentById(1));
        
	}

	@Test
	void testDeleteStudent() throws Exception {
		Student student=new Student();
		student.setId(1);
		student.setName("John");
		student.setMarks((long) 99);
		
		Mockito.when(studentRepository.findById(1)).thenReturn(Optional.of(student));
		
		ModelApiResponse modelApiResponse = studentService.deleteStudent(1);
		
		
		assertNotNull(modelApiResponse);
		assertEquals(modelApiResponse.getType(),"SUCCESS");
		
		
	}
//
//	@Test
//	void testGetAllStudent() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetStudentMarksGreater() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetTop5Students() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testFindStudentByPage() {
//		fail("Not yet implemented");
//	}

}

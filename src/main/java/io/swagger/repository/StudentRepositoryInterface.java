package io.swagger.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import io.swagger.model.Student;


@Repository
@EnableJpaRepositories
public interface StudentRepositoryInterface extends JpaRepository<Student,Integer>{


	public List<Student> findTop5ByOrderByMarksDesc();
	
	public List<Student> findByMarksGreaterThan(long m);
	
	
	
	
	 
//	 @Query("select s from student s where s.marks>:m")
//	 public List<Student> findStudentsByMarksGreaterThan(long m);

}


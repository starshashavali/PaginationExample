package com.org.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.domain.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}

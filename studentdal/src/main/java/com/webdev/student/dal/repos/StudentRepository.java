package com.webdev.student.dal.repos;

import org.springframework.data.repository.CrudRepository;

import com.webdev.student.dal.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {

}

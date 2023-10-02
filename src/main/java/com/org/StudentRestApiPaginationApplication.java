package com.org;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.org.domain.Student;
import com.org.repo.StudentRepo;

@SpringBootApplication
public class StudentRestApiPaginationApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StudentRestApiPaginationApplication.class, args);

		StudentRepo repo = context.getBean(StudentRepo.class);

		/*
		 * List<Student> list= new ArrayList<>(); list.add(new Student(101, "Ramaa",
		 * "Ramarajyam")); list.add(new Student(102, "Krishna", "Gokulam"));
		 * list.add(new Student(103, "hari", "Vaikuntam")); list.add(new Student(104,
		 * "Govindaa", "Vaikuntam")); list.add(new Student(105, "Mukundaa",
		 * "GovarthanParvatham")); list.add(new Student(106, "Bismilla", "Jannath"));
		 * list.add(new Student(107, "Allah", "World")); list.add(new Student(108,
		 * "Siva", "World")); list.add(new Student(109, "Arunachalam", "Tamilanadu"));
		 * list.add(new Student(110, "Parvathi", "Ramarajyam"));
		 * 
		 * repo.saveAll(list); System.out.println(repo.count());
		 */

		Sort ascending = Sort.by("name").ascending();
		Integer pageNo = 1;
		PageRequest pageRequest = PageRequest.of(pageNo - 1, 3);
		Page<Student> findAll = repo.findAll(pageRequest);
		List<Student> content = findAll.getContent();
		content.forEach(System.out::println);


	}

}

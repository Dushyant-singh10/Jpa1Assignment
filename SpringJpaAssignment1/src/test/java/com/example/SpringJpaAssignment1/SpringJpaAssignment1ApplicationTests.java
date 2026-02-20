package com.example.SpringJpaAssignment1;

import com.example.SpringJpaAssignment1.Entities.Employee;
import com.example.SpringJpaAssignment1.Repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
class SpringJpaAssignment1ApplicationTests {
    @Autowired
	EmployeeRepository repository;

     @Test
	public void createTestemploye(){
		Employee emp = new Employee();
		emp.setName("dushyant");
		emp.setAge(22);
		emp.setLocation("noida");
		repository.save(emp);
		System.out.println(emp);
	}
	@Test
	public void FindbyID(){
		Employee emp = repository.findById(1).get();
		System.out.println(emp);

	}
    @Test
	public void getAllEmployees(){
		 List<Employee> list = repository.findAll();
		System.out.println(list);
	}

	@Test
	public void Updatelocation(){
		 Employee emp = repository.findById(2).orElseThrow();
		 emp.setLocation("losangele");
		 repository.save(emp);
	}
	@Test
	public void deleteEmployee(){
		 Employee emp = repository.findById(1).orElseThrow();
		 repository.delete(emp);

	}
	@Test
	public void  countEmployee(){
		 long emp = repository.count();
		System.out.println(emp);

	}

	@Test
	public void findByName(){
	List<Employee> emp = repository.findByName("priya");
		System.out.println(emp);
	}


	@Test
	public void findByNameAndLocation() {

		List<Employee> emp = repository.findByNameAndLocation("priya", "Mumbai");
		System.out.println(emp);
	}
	@Test
	public void testFindEmployeesBetween(){
		repository.findEmployeeByAgeIsBetween(28,32)
				.forEach(System.out::println);
	}

	@Test
	public void testEmployeeUsingPaging(){
		Pageable pageable= PageRequest.of(0,2);
		repository.findByAge(pageable,21).forEach(System.out::println);


	}
	@Test
	public void testEmployeeFindByAgeSort(){
		Sort sort=Sort.by(Sort.Direction.DESC,"name");
		repository.findAllByAge(21,sort).forEach(System.out::println);
	}

}

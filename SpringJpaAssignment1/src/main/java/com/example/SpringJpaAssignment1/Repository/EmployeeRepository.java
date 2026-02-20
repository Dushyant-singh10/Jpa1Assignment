package com.example.SpringJpaAssignment1.Repository;

import com.example.SpringJpaAssignment1.Entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findByName(String name);
    List<Employee> findByNameAndLocation(String name,String location);
    List<Employee> findEmployeeByAgeIsBetween(Integer ageAfter, Integer ageBefore);
    Page<Employee> findByAge(Pageable pageable, Integer age);
    List<Employee> findAllByAge(Integer age, Sort sort);
}

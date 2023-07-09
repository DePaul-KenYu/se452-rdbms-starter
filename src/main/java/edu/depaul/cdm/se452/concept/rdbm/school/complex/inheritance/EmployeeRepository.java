package edu.depaul.cdm.se452.concept.rdbm.school.complex.inheritance;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository<T extends Employee> extends JpaRepository<T, Long> {
    
}

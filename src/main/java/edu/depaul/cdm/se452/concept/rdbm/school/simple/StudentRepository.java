package edu.depaul.cdm.se452.concept.rdbm.school.simple;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Example of adding additional finders
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByAgeLessThanEqual(long age);
}

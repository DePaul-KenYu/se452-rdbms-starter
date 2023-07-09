package edu.depaul.cdm.se452.concept.rdbm.school.complex;

import org.springframework.data.jpa.repository.JpaRepository;

public interface InstructorRepository extends JpaRepository<Instructor, Long> { 
    public Instructor findByName(String name);
}

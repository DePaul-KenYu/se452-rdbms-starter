package edu.depaul.cdm.se452.concept.rdbm.school.complex;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Long> { 
    public University findByName(String name);
}
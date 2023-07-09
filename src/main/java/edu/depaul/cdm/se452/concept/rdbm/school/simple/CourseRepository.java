package edu.depaul.cdm.se452.concept.rdbm.school.simple;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @see JpaRepository that extends PagingAndSortingRepository that expends CrudRepository
 */
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}

package edu.depaul.cdm.se452.concept.rdbm.user;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<AppUser, Integer> {
    Optional<AppUser> findByUsername(String username);    
}

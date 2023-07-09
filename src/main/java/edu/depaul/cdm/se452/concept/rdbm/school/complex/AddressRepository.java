package edu.depaul.cdm.se452.concept.rdbm.school.complex;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address findByLocation(String location);
}
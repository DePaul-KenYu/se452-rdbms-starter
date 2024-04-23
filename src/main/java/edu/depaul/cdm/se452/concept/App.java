package edu.depaul.cdm.se452.concept;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import edu.depaul.cdm.se452.concept.rdbm.school.complex.School;
import edu.depaul.cdm.se452.concept.rdbm.school.complex.SchoolRepository;
import edu.depaul.cdm.se452.concept.rdbm.school.complex.University;
import edu.depaul.cdm.se452.concept.rdbm.school.complex.UniversityRepository;
import edu.depaul.cdm.se452.concept.rdbm.school.complex.inheritance.HourlyEmployee;
import edu.depaul.cdm.se452.concept.rdbm.school.complex.inheritance.HourlyEmployeeRepository;
import edu.depaul.cdm.se452.concept.rdbm.school.complex.inheritance.SalaryEmployee;
import edu.depaul.cdm.se452.concept.rdbm.school.complex.inheritance.SalaryEmployeeRepository;
import edu.depaul.cdm.se452.concept.rdbm.user.AppUser;
import edu.depaul.cdm.se452.concept.rdbm.user.UserRepository;
import edu.depaul.cdm.se452.concept.rdbm.user.UserRole;
import edu.depaul.cdm.se452.concept.rdbm.user.UserRoleRepository;
import lombok.extern.log4j.Log4j2;

@SpringBootApplication
@Log4j2
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	CommandLineRunner addUserDemoRun(UserRoleRepository roleRepo, UserRepository userRepo) {
		return args -> {

			log.info("checking adding user5");
			if (roleRepo.findByAuthority("ADMIN").isPresent())
				return;

			log.info("adding user");
			roleRepo.save(new UserRole("USER"));
			UserRole adminRole = roleRepo.save(new UserRole("ADMIN"));

			Set<UserRole> roles = new HashSet<>();
			roles.add(adminRole);

			AppUser admin = new AppUser("admin", "password", roles);

			userRepo.save(admin);
		};
	}


}

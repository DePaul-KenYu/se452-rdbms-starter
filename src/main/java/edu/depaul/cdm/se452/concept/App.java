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

	@Bean
	CommandLineRunner addInheritanceExampleDemoRun(HourlyEmployeeRepository hrlyRepo, SalaryEmployeeRepository salaryRepo) {
		return args -> {

			var hrly = new HourlyEmployee();
			hrly.setName("GS-Joe");
			hrly.setRate(15.00);
			hrlyRepo.save(hrly);
			var after_hrly = hrlyRepo.count();
			log.debug(after_hrly);

			var b4_sal = salaryRepo.count();
			log.debug(b4_sal);
			var salary = new SalaryEmployee();
			salary.setName("Down Under");
			salary.setSalary(90000);
			salaryRepo.save(salary);
			var after_sal = salaryRepo.count();
			log.debug(after_sal);
		};
	}

	@Bean
	CommandLineRunner addOneToManyDemoRun(SchoolRepository schoolRepo, UniversityRepository uniRepo) {
		return args -> {
			ArrayList<School> schools = new ArrayList<School>();

			School cdm = new School();
			cdm.setName("CDM");
			schoolRepo.save(cdm);
			schools.add(cdm);

			School kellSchool = new School();
			kellSchool.setName("KellStadt");
			schoolRepo.save(kellSchool);
			schools.add(kellSchool);

			School under = new School();
			under.setName("Under");
			schoolRepo.save(under);
			schools.add(under);

			University depaul = new University();
			depaul.setName("DePaul");
			depaul.setSchools(schools);
			uniRepo.save(depaul);

			School cdmFinder = schoolRepo.findByName("CDM");
			cdmFinder.setUniversity(depaul);
			schoolRepo.save(cdmFinder);

			University loyola = new University();
			loyola.setName("Loyla");
			uniRepo.save(loyola);

			University uniFinder = uniRepo.findByName("DePaul");
			log.info(uniFinder);

		};
	}

}

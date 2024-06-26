package edu.depaul.cdm.se452.concept.rdbm.complex.inheritance;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.depaul.cdm.se452.concept.rdbm.school.complex.inheritance.HourlyEmployee;
import edu.depaul.cdm.se452.concept.rdbm.school.complex.inheritance.HourlyEmployeeRepository;
import edu.depaul.cdm.se452.concept.rdbm.school.complex.inheritance.SalaryEmployee;
import edu.depaul.cdm.se452.concept.rdbm.school.complex.inheritance.SalaryEmployeeRepository;

@SpringBootTest
public class EmployeeRepositoryTest {
    @Autowired
    private HourlyEmployeeRepository hrlyRepo;

    @Autowired
    private SalaryEmployeeRepository salaryRepo;

    
    /**
     * Demonstrate inheritance
     */
    @Test
    public void testAdd() {
        var b4_hrly = hrlyRepo.count();
        var hrly = new HourlyEmployee();
        hrly.setName("GS-Joe");
        hrly.setRate(15.00);
        hrlyRepo.save(hrly);
        var after_hrly = hrlyRepo.count();

        var b4_sal = salaryRepo.count();
        var salary = new SalaryEmployee();
        salary.setName("Down Under");
        salary.setSalary(90000);
        salaryRepo.save(salary);        
        var after_sal = salaryRepo.count();
        
        assertEquals(b4_hrly+1, after_hrly);
        assertEquals(b4_sal+1, after_sal);
    }    
}

package edu.depaul.cdm.se452.concept.rdbm.user;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AuthenticationService {

    private UserRepository userRepo;
    
    private UserRoleRepository userRoleRepo;

    public AppUser registerUser(String username, String password) {
        UserRole userRole = userRoleRepo.findByAuthority("USER").get();

        Set<UserRole> authorities = new HashSet<>();
        authorities.add(userRole);
        return userRepo.save(new AppUser(username, password, authorities));
    }
    

    public AppUser loginUser(String username, String password) {
        AppUser retval = new AppUser();

        retval = userRepo.findByUsername(username).get();

        return retval;
    }

}

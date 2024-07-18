package com.joseflores.examenspring.validations;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;

import com.joseflores.examenspring.models.Role;
import com.joseflores.examenspring.models.User;
import com.joseflores.examenspring.services.RolesServices;
import com.joseflores.examenspring.services.UserServices;

import org.springframework.validation.Errors;


@Component
public class UserValidator implements Validator{
    private final UserServices userServices;
    private final RolesServices rolesServices;
    

    public UserValidator(RolesServices rolesServices, UserServices userServices){
        this.rolesServices = rolesServices;
        this.userServices = userServices;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors){
        User user = (User) target;
        assignUserRoles(user);

        if (passwordsMismatch(user)) {
          errors.rejectValue("passwordConfirmation", "USER_PASSWORDS_MISMATCH");
        }
    
        if (userServices.emailExists(user.getEmail())) {
          errors.rejectValue("email", "USER_EMAIL_ALREADY_REGISTERED"); 
        }
    
        if (user.getRoles().size() == 0) {
          errors.rejectValue("email", "USER_ROLE_MISSING");
        }
    
        if(passwordNotContainAtLeastOneCharacter(user)){
          errors.rejectValue("password", "USER_PASSWORD_MISSING_SPECIAL_CHARACTER");
        }
      }

      private void assignUserRoles(User user) {
        Set<Role> userRoles = new HashSet<>();
        Role role;
        long totalUsers = userServices.getTotalUsers();

        if(totalUsers == 0){ 
            role = rolesServices.findByName("ROLE_USER");
            userRoles.add(role);
        
            role = rolesServices.findByName("ROLE_ADMIN");
            userRoles.add(role);
          } else if(totalUsers == 1){
            role = rolesServices.findByName("ROLE_ADMIN");
            userRoles.add(role);
          } else {
            role = rolesServices.findByName("ROLE_USER");
            userRoles.add(role);
          }
      
          user.setRoles(userRoles);
        }
        private boolean passwordNotContainAtLeastOneCharacter(User user) {
            return !user.getPassword().matches(".*[!@#$%^&*()<>?].*");
        }
        public boolean passwordsMismatch(User user) {
            return user.getPassword().equals(user.getConfirmPassword()) == false;
          }
    }

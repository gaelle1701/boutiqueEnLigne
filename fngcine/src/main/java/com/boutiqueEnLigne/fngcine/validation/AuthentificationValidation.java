package com.boutiqueEnLigne.fngcine.validation;

import com.boutiqueEnLigne.fngcine.entity.Role;
import com.boutiqueEnLigne.fngcine.security.services.UserDetailsImpl;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AuthentificationValidation {

    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

    public UserDetailsImpl getUserDetails(){
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return userDetails;
    }

    public Long getTokenUserId(){
        UserDetailsImpl userDetails = getUserDetails();
        Long tokenUserId = userDetails.getId();
        return tokenUserId;
    }

    public boolean isAdmin(){
        UserDetailsImpl userDetails = getUserDetails();
        String roles = userDetails.getAuthorities().toString();
        if (roles.contains("ADMIN")){
            return true;
        } else {
            return false;
        }
    }

}

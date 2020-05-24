package com.mvm.MVM.security;


import org.springframework.stereotype.Service;

@Service
public class AuthorizationCustom {

    /*@Autowired
    private UserService userService;

    public Boolean hasAccess(String role){
        if(role.equals("ROLE_USER"))
            return true;
        else if(role.equals("ROLE_ADMIN")){
            User user = userService.getCurrentUser();
            Set<Role> usersRoles = user.getRoles();
            for(Role r : usersRoles)
                if(r.getName().equals("ROLE_ADMIN"))
                    return true;

        }
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "You don't have a permission!");
    }*/
}

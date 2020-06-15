package controller;

import com.sun.org.apache.bcel.internal.generic.GETFIELD;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
public class UserController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String loadIndex() {
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user(Principal principal) {
        System.out.println(principal.getName());
        return "user";
    }

    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String admin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        System.out.println(securityContext.getAuthentication().getName());
        return "admin";
    }
}

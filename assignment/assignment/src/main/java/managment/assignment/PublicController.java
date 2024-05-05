package managment.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

//@Controller  //I am not using '@Controller' and '@RestController' because of limited time to submission of Assignment.
@RestController
@RequestMapping("/public")
public class PublicController {
    @Autowired
    Transaction transaction;

    @Autowired
    PasswordEncoder passwordEncoder;

    @PostMapping("/signUpMeth")
    public ModelAndView signUp(@ModelAttribute SignUp signUp) {
        MyUser myUser = new MyUser();

        myUser.setName(signUp.getName());
        myUser.setAddress(signUp.getAddress());
        myUser.setEmail(signUp.getEmail());
        myUser.setPassword(passwordEncoder.encode(signUp.getPassword()));
        myUser.setRole(signUp.getUserType());
        myUser.setProfileHeadline(signUp.getProfileHeadline());

        System.out.println(myUser);
        transaction.saveMyUser(myUser);
        return new ModelAndView("afterSignUp");
    }

    @GetMapping("/signup")
    public ModelAndView signUpPage(){
        return new ModelAndView("signup");
    }

}

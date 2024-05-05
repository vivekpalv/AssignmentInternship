package managment.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

//@Controller  //I am not using '@Controller' and '@RestController' because of limited time to submission of Assignment.
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    Transaction tx;

    @GetMapping("/applicants")
    public List<MyUser> admin(){
        return tx.findAll();
    }

    @GetMapping("/applicant/{id}")
    public MyUser fetchApplicant(@PathVariable("id") int id){
        MyUser getById = tx.findId(id);
        return getById;
    }

    @PostMapping("/job")
    public ModelAndView jobPosting(@ModelAttribute Job job,@AuthenticationPrincipal UserDetails userDetails){
        String username = userDetails.getUsername();
        MyUser byEmail = tx.getByEmail(username);
        job.setPostedBy(byEmail);
        System.out.println(job);
        Job job1 = tx.saveJob(job);
        String email = job1.getPostedBy().getPassword();
        System.out.println(email);
        return new ModelAndView("signup");
    }

    @GetMapping("/jobCreation")
    public ModelAndView jobPage(){
        return new ModelAndView("job");
    }

    @GetMapping("/job/{id}")
    public Job getJobDetails(@PathVariable("id") int id){
        return tx.findJobThroughId(id);
    }
}

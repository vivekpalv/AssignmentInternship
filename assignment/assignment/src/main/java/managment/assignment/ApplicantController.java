package managment.assignment;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//@Controller  //I am not using '@Controller' and '@RestController' because of limited time to submission of Assignment.
@RestController
public class ApplicantController {
    @Autowired
    Transaction tx;

    @PostMapping("/profileCreation")
    public MyProfile createProfile(@ModelAttribute MyProfile profile, @AuthenticationPrincipal UserDetails currentUserDetails,@RequestParam MultipartFile file){
        MyUser user = tx.getByEmail(currentUserDetails.getUsername());
        profile.setApplicant(user);
        profile.setName(user.getName());
        profile.setResumeFileAddress(file.getOriginalFilename());
        MyProfile myProfile = tx.saveProfile(profile);

        //setting value to myProfile instance variable's column's value into the database/schema.
        user.setMyProfile(tx.getExistingMyProfileEntity(profile.getId()));
        tx.saveMyUser(user);

        return myProfile;
    }

    @GetMapping("createProfile")
    public ModelAndView create(){
        return new ModelAndView("profile");
    }

    @GetMapping("/jobs")
    public List<Job> jobOpenings(){
        return tx.findAllJobs();
    }

    @GetMapping("/apply/{jobId}")
    public Job applyToJobByJobId(@PathVariable("jobId") int id,@AuthenticationPrincipal UserDetails userDetails){
        Job jobThroughId = tx.findJobThroughId(id);
        int totalApplication = jobThroughId.getTotalApplication();
        totalApplication++;
        jobThroughId.setTotalApplication(totalApplication);
        Job job = tx.saveJob(jobThroughId);
        MyUser byEmail = tx.getByEmail(userDetails.getUsername());
        byEmail.getAppliedJob().add(jobThroughId);
        tx.saveMyUser(byEmail);
        job.getAppliedBy().add(byEmail);
        tx.saveJob(jobThroughId);
        return jobThroughId;
    }

    @PostMapping("/uploadResume")
    public String uploadResume(@RequestParam MultipartFile uploadedFile) throws IOException {
        System.out.println(uploadedFile.getOriginalFilename());
        if (uploadedFile==null){
            return "file is null, or not uploaded";
        }else {
            try (InputStream inputStream = uploadedFile.getInputStream()) {
                PDDocument load = PDDocument.load(inputStream);
                PDFTextStripper stripper=new PDFTextStripper();
                String text = stripper.getText(load);
                System.out.println(text);
                return text;
            }
        }
    }

    @GetMapping("/uploadResumeForm")
    public ModelAndView upload(){
        return new ModelAndView("uploadResume");
    }
}

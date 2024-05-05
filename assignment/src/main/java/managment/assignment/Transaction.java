package managment.assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Transaction {

    @Autowired
    private MyUserRepository myUserRepository;

    @Autowired
    private MyProfileRepository myProfileRepository;

    @Autowired
    private JobRepository jobRepository;

    public MyUser getByEmail(String email){
        MyUser byEmail = myUserRepository.findByEmail(email);
        return byEmail;
    }

    public MyUser saveMyUser(MyUser myUser){
        MyUser savedMyUser = myUserRepository.save(myUser);
        return savedMyUser;
    }

    public Job saveJob(Job job){
        Job savedJob = jobRepository.save(job);
        return savedJob;
    }

    public MyProfile saveProfile(MyProfile profile){
        MyProfile savedProfile = myProfileRepository.save(profile);
        return savedProfile;
    }

    public MyUser findId(int id){
        return myUserRepository.findById(id).get();
    }

    public Job findJobThroughId(int id){
        return jobRepository.findById(id).get();
    }

    public List<MyUser> findAll(){
        List<MyUser> all = myUserRepository.findAll();
        return all;
    }

    public List<Job> findAllJobs(){
        return jobRepository.findAll();
    }
    
    public MyProfile getExistingMyProfileEntity(int id){
        return myProfileRepository.findById(id).get();
    }

}

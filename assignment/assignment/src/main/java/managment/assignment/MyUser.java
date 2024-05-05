package managment.assignment;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@ToString
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String email;
    private String address;
    private String role;
    private String password;
    private String profileHeadline;
    @OneToOne
    private MyProfile myProfile;
    @ManyToMany
    private List<Job> appliedJob;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfileHeadline() {
        return profileHeadline;
    }

    public void setProfileHeadline(String profileHeadline) {
        this.profileHeadline = profileHeadline;
    }

    public MyProfile getMyProfile() {
        return myProfile;
    }

    public void setMyProfile(MyProfile myProfile) {
        this.myProfile = myProfile;
    }

    @JsonIgnore
    public List<Job> getAppliedJob() {
        return appliedJob;
    }

    public void setAppliedJob(List<Job> appliedJob) {
        this.appliedJob = appliedJob;
    }
}

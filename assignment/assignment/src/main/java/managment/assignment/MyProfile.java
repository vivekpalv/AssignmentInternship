package managment.assignment;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString
public class MyProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    private MyUser applicant;
    private String resumeFileAddress;
    private String skills;
    private String education;
    private String experience;
    private String name;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MyUser getApplicant() {
        return applicant;
    }

    public void setApplicant(MyUser applicant) {
        this.applicant = applicant;
    }

    public String getResumeFileAddress() {
        return resumeFileAddress;
    }

    public void setResumeFileAddress(String resumeFileAddress) {
        this.resumeFileAddress = resumeFileAddress;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

package managment.assignment;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.sql.Date;
import java.util.List;

@Entity
@ToString
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String title;
    private String companyName;
    private String description;
    private Date postedOn;
    private int totalApplication=0;
    @ManyToOne
    private MyUser postedBy;
    @OneToMany
    private List<MyUser> appliedBy;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }

    public int getTotalApplication() {
        return totalApplication;
    }

    public void setTotalApplication(int totalApplication) {
        this.totalApplication = totalApplication;
    }

    public MyUser getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(MyUser postedBy) {
        this.postedBy = postedBy;
    }
    @JsonIgnore
    public List<MyUser> getAppliedBy() {
        return appliedBy;
    }

    public void setAppliedBy(List<MyUser> appliedBy) {
        this.appliedBy = appliedBy;
    }
}
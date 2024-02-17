package User;

import Enums.UserTypeEnum;
import JobComparisonElement.JobComparisonElement;

import java.util.List;

public class User {
    private Long userId;
    private String username;
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private UserTypeEnum type;
    private List<JobComparisonElement> jobComparisonElements;

    // Getters and Setters

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserTypeEnum getType() {
        return type;
    }

    public void setType(UserTypeEnum type) {
        this.type = type;
    }

    public List<JobComparisonElement> getJobComparisonElements() {
        return jobComparisonElements;
    }

    public void setJobComparisonElements(List<JobComparisonElement> jobComparisonElements) {
        this.jobComparisonElements = jobComparisonElements;
    }
}

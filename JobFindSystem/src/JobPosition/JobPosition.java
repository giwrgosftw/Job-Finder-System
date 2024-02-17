package JobPosition;

import Models.JobCategory;
import User.EmployerUser;

import java.time.LocalDate;

public class JobPosition {
    private Long jobPositionId;
    private String jobPlace;
    private String jobDescription;
    private String minimumRequirements;
    private String minimumWorkExperience;
    private LocalDate postDate;
    private boolean isActive;
    private boolean requireBusinessTrips;
    private boolean requireDriverLicence;
    private EmployerUser employer;
    private JobCategory jobCategory;

    private int score;

    public void deactivate() {
        this.isActive = false;
    }

    // getters and setters

    public Long getJobPositionId() {
        return jobPositionId;
    }

    public void setJobPositionId(Long jobPositionId) {
        this.jobPositionId = jobPositionId;
    }

    public String getJobPlace() {
        return jobPlace;
    }

    public void setJobPlace(String jobPlace) {
        this.jobPlace = jobPlace;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getMinimumRequirements() {
        return minimumRequirements;
    }

    public void setMinimumRequirements(String minimumRequirements) {
        this.minimumRequirements = minimumRequirements;
    }

    public String getMinimumWorkExperience() {
        return minimumWorkExperience;
    }

    public void setMinimumWorkExperience(String minimumWorkExperience) {
        this.minimumWorkExperience = minimumWorkExperience;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isRequireBusinessTrips() {
        return requireBusinessTrips;
    }

    public void setRequireBusinessTrips(boolean requireBusinessTrips) {
        this.requireBusinessTrips = requireBusinessTrips;
    }

    public boolean isRequireDriverLicence() {
        return requireDriverLicence;
    }

    public void setRequireDriverLicence(boolean requireDriverLicence) {
        this.requireDriverLicence = requireDriverLicence;
    }

    public EmployerUser getEmployer() {
        return employer;
    }

    public void setEmployer(EmployerUser employer) {
        this.employer = employer;
    }

    public JobCategory getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(JobCategory jobCategory) {
        this.jobCategory = jobCategory;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}

package JobApplication;

import Enums.ApplicationStatusEnum;
import JobPosition.JobPosition;
import User.ApplicantUser;

import java.time.LocalDate;

public class JobApplication {
    private long jobApplicationId;
    private ApplicationStatusEnum applicationStatus;
    private LocalDate applicationDate;
    private ApplicantUser applicant;
    private JobPosition jobPosition;

    // getters and setters
    public long getJobApplicationId() {
        return jobApplicationId;
    }

    public void setJobApplicationId(long jobApplicationId) {
        this.jobApplicationId = jobApplicationId;
    }

    public ApplicationStatusEnum getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatusEnum applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public ApplicantUser getApplicant() {
        return applicant;
    }

    public void setApplicant(ApplicantUser applicant) {
        this.applicant = applicant;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

}

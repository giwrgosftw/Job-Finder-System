package JobFindSystem;

import JobApplication.JobApplication;
import JobPosition.JobPosition;
import Models.CompanyDetails;
import Models.JobCategory;
import JobComparisonElement.JobComparisonElement;
import User.ApplicantUser;
import User.EmployerUser;

import java.util.List;

public interface JobFindSystemInterface {
    void registerApplicant(ApplicantUser applicant);
    void registerEmployer(EmployerUser employer);
    void registerJobPosition(JobPosition jobPosition);
    void registerJobApplication(JobApplication jobApplication);
    void calculateProposalsPerCandidate();
    List<JobComparisonElement> createDummyJobComparisonElements();
    List<CompanyDetails> createDummyCompanyDetails();
    List<EmployerUser> createDummyEmployers();
    List<JobCategory> createDummyJobCategories();
    List<JobPosition> createDummyJobPositions();

    List<JobPosition> getJobPositionsList();
    List<ApplicantUser> getApplicantsList();
    List<EmployerUser> getEmployersList();
    List<CompanyDetails> getCompanyDetailsList();
    List<JobCategory> getJobCategoriesList();
    List<JobApplication> getJobApplicationList();
}


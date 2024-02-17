package JobFindSystem;

import JobApplication.JobApplication;
import JobPosition.JobPosition;
import Models.CompanyDetails;
import Models.JobCategory;
import JobComparisonElement.JobComparisonElement;
import User.ApplicantUser;
import User.EmployerUser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JobFindSystemImpl implements JobFindSystemInterface {
    private final List<JobPosition> jobPositionsList;
    private final List<ApplicantUser> applicantsList;
    private final List<EmployerUser> employersList;
    private List<CompanyDetails> companyDetailsList;
    private List<JobCategory> jobCategoriesList;

    private List<JobApplication> jobApplicationList;

    private List<JobComparisonElement> jobComparisonElements;

    private List<CompanyDetails> jobCompanyDetails;

    public JobFindSystemImpl() {
        this.jobApplicationList = new ArrayList<>();
        this.applicantsList = new ArrayList<>();
        this.employersList = new ArrayList<>();
        this.companyDetailsList = new ArrayList<>();
        this.jobCategoriesList = new ArrayList<>();
        this.jobPositionsList = new ArrayList<>();
        this.jobComparisonElements = new ArrayList<>();
        this.jobCompanyDetails = new ArrayList<>();
        createDummyEmployers();
        createDummyCompanyDetails();
        createDummyJobCategories();
        createDummyJobPositions();
        createDummyJobComparisonElements();
        createDummyCompanyDetails();
    }

    @Override
    public void registerApplicant(ApplicantUser applicant) {
        this.applicantsList.add(applicant);
    }

    @Override
    public void registerEmployer(EmployerUser employer) {
        this.employersList.add(employer);
    }

    @Override
    public void registerJobPosition(JobPosition jobPosition){this.jobPositionsList.add(jobPosition); }

    @Override
    public void registerJobApplication(JobApplication jobApplication){this.jobApplicationList.add(jobApplication); }
    @Override
    public void calculateProposalsPerCandidate() {
        // implement the logic to calculate proposals per candidate
    }

    @Override
    // Create some dummy JobComparisonElements
    public List<JobComparisonElement> createDummyJobComparisonElements() {

        JobComparisonElement element1 = new JobComparisonElement();
        element1.setJobComparisonElementId(1);
        element1.setValue("New York");
        element1.setDescription("City of desire for work");
        element1.setJobCategory(jobCategoriesList.get(0));  // replace with actual JobCategory
        jobComparisonElements.add(element1);

        JobComparisonElement element2 = new JobComparisonElement();
        element2.setJobComparisonElementId(2);
        element2.setValue("Boston");
        element2.setDescription("City of residence of the candidate");
        element2.setJobCategory(jobCategoriesList.get(1));  // replace with actual JobCategory
        jobComparisonElements.add(element2);

        JobComparisonElement element3 = new JobComparisonElement();
        element3.setJobComparisonElementId(3);
        element3.setValue("2 years");
        element3.setDescription("Years of experience");
        element3.setJobCategory(jobCategoriesList.get(2));  // replace with actual JobCategory
        jobComparisonElements.add(element3);

        JobComparisonElement element4 = new JobComparisonElement();
        element4.setJobComparisonElementId(4);
        element4.setValue("Software Engineering");
        element4.setDescription("Profession category of choice");
        element4.setJobCategory(jobCategoriesList.get(0));  // replace with actual JobCategory
        jobComparisonElements.add(element4);

        JobComparisonElement element5 = new JobComparisonElement();
        element5.setJobComparisonElementId(5);
        element5.setValue("Yes");
        element5.setDescription("Have a driver's license?");
        element5.setJobCategory(jobCategoriesList.get(3));  // replace with actual JobCategory
        jobComparisonElements.add(element5);

        JobComparisonElement element6 = new JobComparisonElement();
        element6.setJobComparisonElementId(6);
        element6.setValue("No");
        element6.setDescription("Ability to travel on business?");
        element6.setJobCategory(jobCategoriesList.get(4));  // replace with actual JobCategory
        jobComparisonElements.add(element6);

        return jobComparisonElements;
    }

    @Override
    // Create some dummy CompanyDetails
    public List<CompanyDetails> createDummyCompanyDetails(){
        CompanyDetails company1 = new CompanyDetails();
        company1.setCompanyDetailsId(1L);
        company1.setCompanyContact("1234567890");
        company1.setCompanyAddress("New York");
        company1.setCompanyName("Company 1");
        companyDetailsList.add(company1);

        CompanyDetails company2 = new CompanyDetails();
        company2.setCompanyDetailsId(2L);
        company2.setCompanyContact("0987654321");
        company2.setCompanyAddress("San Francisco");
        company2.setCompanyName("Company 2");
        companyDetailsList.add(company2);

        return companyDetailsList;
    }

    @Override
    // Create some dummy EmployerUsers
    public List<EmployerUser> createDummyEmployers(){

        companyDetailsList = createDummyCompanyDetails();

        EmployerUser employer1 = new EmployerUser();
        employer1.setUserId(1L);
        employer1.setUsername("employer1");
        employer1.setFirstName("John");
        employer1.setLastName("Doe");
        employer1.setPassword("password1");
        employer1.setEmail("employer1@example.com");
        employer1.setCompanyDetails(companyDetailsList.get(0));
        employersList.add(employer1);

        EmployerUser employer2 = new EmployerUser();
        employer2.setUserId(2L);
        employer2.setUsername("employer2");
        employer2.setFirstName("Jane");
        employer2.setLastName("Doe");
        employer2.setPassword("password2");
        employer2.setEmail("employer2@example.com");
        employer1.setCompanyDetails(companyDetailsList.get(1));
        employersList.add(employer2);

        return employersList;
    }

    @Override
    // Create some dummy JobCategories
    public List<JobCategory> createDummyJobCategories(){
        JobCategory category1 = new JobCategory();
        category1.setJobCategoryId(1);
        category1.setDescription("Software Engineering");
        jobCategoriesList.add(category1);

        JobCategory category2 = new JobCategory();
        category2.setJobCategoryId(2);
        category2.setDescription("Data Science");
        jobCategoriesList.add(category2);

        JobCategory category3 = new JobCategory();
        category3.setJobCategoryId(3);
        category3.setDescription("Product Management");
        jobCategoriesList.add(category3);

        return jobCategoriesList;

    }

    @Override
    // Create some dummy job positions
    public List<JobPosition> createDummyJobPositions(){

        List<EmployerUser> employersList = createDummyEmployers();
        List<JobCategory> jobCategoryList = createDummyJobCategories();

        JobPosition job1 = new JobPosition();
        job1.setJobPositionId(1L);
        job1.setJobPlace("New York");
        job1.setJobDescription("Software Engineer");
        job1.setMinimumRequirements("Bachelor's degree in Computer Science");
        job1.setMinimumWorkExperience("2 years");
        job1.setPostDate(LocalDate.now());
        job1.setActive(true);
        job1.setRequireBusinessTrips(false);
        job1.setRequireDriverLicence(false);
        job1.setEmployer(employersList.get(0));
        job1.setJobCategory(jobCategoryList.get(0));
        jobPositionsList.add(job1);

        JobPosition job2 = new JobPosition();
        job2.setJobPositionId(2L);
        job2.setJobPlace("San Francisco");
        job2.setJobDescription("Data Scientist");
        job2.setMinimumRequirements("Master's degree in Data Science");
        job2.setMinimumWorkExperience("3 years");
        job2.setPostDate(LocalDate.now());
        job2.setActive(true);
        job2.setRequireBusinessTrips(true);
        job2.setRequireDriverLicence(false);
        job2.setEmployer(employersList.get(1));
        job2.setJobCategory(jobCategoryList.get(1));
        jobPositionsList.add(job2);

        JobPosition job3 = new JobPosition();
        job3.setJobPositionId(3L);
        job3.setJobPlace("London");
        job3.setJobDescription("Product Manager");
        job3.setMinimumRequirements("Bachelor's degree in Business Administration");
        job3.setMinimumWorkExperience("5 years");
        job3.setPostDate(LocalDate.now());
        job3.setActive(true);
        job3.setRequireBusinessTrips(true);
        job3.setRequireDriverLicence(true);
        job3.setEmployer(employersList.get(1));
        job3.setJobCategory(jobCategoryList.get(2));
        jobPositionsList.add(job3);

        return jobPositionsList;
    }

    @Override
    public List<JobPosition> getJobPositionsList() {
        return jobPositionsList;
    }
    @Override
    public List<ApplicantUser> getApplicantsList() {
        return applicantsList;
    }

    @Override
    public List<EmployerUser> getEmployersList() {
        return employersList;
    }

    @Override
    public List<CompanyDetails> getCompanyDetailsList() {
        return companyDetailsList;
    }

    public List<JobCategory> getJobCategoriesList() {
        return jobCategoriesList;
    }

    @Override
    public List<JobApplication> getJobApplicationList() {
        return jobApplicationList;
    }
}

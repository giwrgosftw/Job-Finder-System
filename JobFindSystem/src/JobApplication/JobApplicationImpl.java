package JobApplication;

import Enums.ApplicationStatusEnum;
import JobFindSystem.JobFindSystemInterface;
import JobPosition.JobPosition;
import Shared.HelperMethods;
import User.ApplicantUser;

import java.time.LocalDate;
import java.util.Scanner;

public class JobApplicationImpl implements JobApplicationInterface {
    private JobFindSystemInterface system;
    private Scanner scanner;

    public JobApplicationImpl(JobFindSystemInterface system, Scanner scanner) {
        this.system = system;
        this.scanner = scanner;
    }

    @Override
    public void createJobApplication(ApplicantUser applicant, JobPosition jobPosition) {
        if (jobPosition != null && jobPosition.isActive()) {
            System.out.println("Your application details have automatically been filled");

            JobApplication jobApplication = new JobApplication();

            jobApplication.setJobApplicationId(HelperMethods.generateRandomIdInt());
            jobApplication.setApplicationStatus(ApplicationStatusEnum.PENDING);
            jobApplication.setApplicationDate(LocalDate.now());
            jobApplication.setApplicant(applicant);
            jobApplication.setJobPosition(jobPosition);

            system.registerJobApplication(jobApplication);
            System.out.println("Successfully applied for the job position!");
            System.out.println(" ");
        } else {
            throw new IllegalArgumentException("Invalid job position id entered or the job position is not active.");
        }
    }


}

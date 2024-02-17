import Enums.UserTypeEnum;
import JobApplication.JobApplicationImpl;
import JobApplication.JobApplicationInterface;
import JobComparisonElement.JobComparisonElementImpl;
import JobComparisonElement.JobComparisonElementInterface;
import JobFindSystem.JobFindSystemImpl;
import JobFindSystem.JobFindSystemInterface;
import JobPosition.JobPosition;
import JobPosition.JobPositionImpl;
import JobPosition.JobPositionInterface;
import User.User;
import User.ApplicantUser;
import User.EmployerUser;
import User.UserImpl;
import User.UserInterface;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        JobFindSystemInterface system = new JobFindSystemImpl();
        Scanner scanner = new Scanner(System.in);

        JobComparisonElementInterface jobComparison = new JobComparisonElementImpl(scanner);  // Create an instance of JobComparisonImpl
        UserInterface userInterface = new UserImpl(system, jobComparison, scanner); // Pass the JobComparisonInterface instance to UserImpl
        JobPositionInterface jobPosition = new JobPositionImpl(system, scanner);
        JobApplicationInterface jobApplication = new JobApplicationImpl(system, scanner);

        // Run the program
        User user = userInterface.registerUser();
        if (user.getType() == UserTypeEnum.APPLICANT) {
            // A. Select job to apply
            jobPosition.displayAllActiveJobPositions();
            List<JobPosition> jobPositionList = jobPosition.getRecommendedJobPositions((ApplicantUser) user);
            JobPosition selectedJobPosition = jobPosition.selectJobPositionToApply(jobPositionList);
            // B. Apply to that job
            jobApplication.createJobApplication((ApplicantUser) user, selectedJobPosition);
        } else {
            // Add a new job positions or disable one
            jobPosition.manageJobPositions((EmployerUser) user);
            jobPosition.displayAllActiveJobPositions();
        }
    }
}

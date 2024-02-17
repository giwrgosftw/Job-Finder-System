package User;

import Enums.UserTypeEnum;
import JobComparisonElement.JobComparisonElement;
import JobComparisonElement.JobComparisonElementInterface;
import JobFindSystem.JobFindSystemInterface;
import Models.CompanyDetails;
import Shared.HelperMethods;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class UserImpl implements UserInterface {
    private JobFindSystemInterface system;
    private JobComparisonElementInterface jobComparison;
    private Scanner scanner;

    public UserImpl(JobFindSystemInterface system, JobComparisonElementInterface jobComparison, Scanner scanner) {
        this.system = system;
        this.jobComparison = jobComparison;
        this.scanner = scanner;
    }
    @Override
    public User registerUser() {
        System.out.println("What type of user are you? - Type the according number:");
        System.out.println("1. " + UserTypeEnum.APPLICANT);
        System.out.println("2. " + UserTypeEnum.EMPLOYER);
        int userType = scanner.nextInt();

        System.out.println("Please enter your username:");
        String username = scanner.next();

        System.out.println("Please enter your first name:");
        String firstName = scanner.next();

        System.out.println("Please enter your last name:");
        String lastName = scanner.next();

        System.out.println("Please enter your password:");
        String password = scanner.next();

        System.out.println("Please enter your email:");
        String email = scanner.next();

        if (userType == 1) {
            ApplicantUser applicant = new ApplicantUser();
            collectCommonUserInfo(applicant, username, firstName, lastName, password, email);
            applicant.setType(UserTypeEnum.APPLICANT);
            collectApplicantInfo(applicant);
            system.registerApplicant(applicant);
            System.out.println("Successful Registration!");
            System.out.println(" ");
            return applicant;
        } else if (userType == 2) {
            EmployerUser employer = new EmployerUser();
            collectCommonUserInfo(employer, username, firstName, lastName, password, email);
            employer.setType(UserTypeEnum.EMPLOYER);
            collectEmployerInfo((EmployerUser) employer, scanner);
            system.registerEmployer(employer);
            System.out.println("Successful Registration!");
            return employer;
        } else {
            throw new IllegalArgumentException("Invalid user type entered.");
        }
    }

    public static User collectCommonUserInfo(User user, String username, String firstname, String lastName,
                                             String password, String email) {
        user.setUserId(HelperMethods.generateRandomIdLong());
        user.setUsername(username);
        user.setFirstName(firstname);
        user.setLastName(lastName);
        user.setPassword(password);
        user.setEmail(email);

        return user;
    }

    private void collectApplicantInfo(ApplicantUser applicant) {

        // Prompt for date of birth
        System.out.println("Please enter your date of birth (YYYY-MM-DD):");
        String dobInput = scanner.next();
        LocalDate dateOfBirth = LocalDate.parse(dobInput); // Add error handling for invalid dates
        applicant.setDateOfBirth(dateOfBirth);

        // Prompt for address
        System.out.println("Please enter your address:");
        scanner.nextLine(); // Consume the leftover newline
        String address = scanner.nextLine(); // Use nextLine to allow address to contain spaces
        applicant.setAddress(address);

        // Prompt for contact number
        System.out.println("Please enter your contact number:");
        String contactNumber = scanner.next();
        applicant.setContactNumber(contactNumber);

        // Prompt for CV (could be a description or a file path)
        System.out.println("Please enter your CV details or path to your CV file:");
        scanner.nextLine(); // Consume leftover newline
        String CV = scanner.nextLine(); // Use nextLine to allow CV details to contain spaces
        applicant.setCV(CV);

        List<JobComparisonElement> elements = jobComparison.collectJobComparisonElements();
        applicant.setJobComparisonElements(elements);
    }

    private void collectEmployerInfo(EmployerUser employer, Scanner scanner) {
        CompanyDetails companyDetails = new CompanyDetails();

        System.out.println("Please enter your company's name:");
        companyDetails.setCompanyName(scanner.next());

        System.out.println("Please enter your company's contact number:");
        companyDetails.setCompanyContact(scanner.next());

        System.out.println("Please enter your company's address:");
        scanner.nextLine(); // Consume the leftover newline from previous input
        companyDetails.setCompanyAddress(scanner.nextLine()); // Use nextLine to allow address to contain spaces

        employer.setCompanyDetails(companyDetails);
    }


}

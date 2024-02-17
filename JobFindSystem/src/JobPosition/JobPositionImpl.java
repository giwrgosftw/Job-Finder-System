package JobPosition;

import JobComparisonElement.JobComparisonElement;
import JobFindSystem.JobFindSystemInterface;
import Shared.HelperMethods;
import User.ApplicantUser;
import User.EmployerUser;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class JobPositionImpl implements JobPositionInterface {
    private JobFindSystemInterface system;
    private Scanner scanner;

    public JobPositionImpl(JobFindSystemInterface system, Scanner scanner) {
        this.system = system;
        this.scanner = scanner;
    }

    @Override
    // Method to manage job positions (create or disable)
    public void manageJobPositions(EmployerUser employer) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What would you like to do?");
        System.out.println("1. Create a new job position");
        System.out.println("2. Disable an existing job position");
        System.out.print("Enter your choice (1/2): ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            createJobPosition(employer); // Call the createJobPosition() method for creating a new job position
        } else if (choice == 2) {
            disableJobPosition(); // Call the disableJobPosition() method for disabling an existing job position
        } else {
            System.out.println("Invalid choice. Please select a valid option (1 or 2).");
        }
    }

    @Override
    // Method to create a new job position
    public void createJobPosition(EmployerUser employer) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user for input to create a new job position
        System.out.println("Creating a new Job Position:");

        System.out.print("Enter the job place: ");
        String jobPlace = scanner.nextLine();

        System.out.print("Enter the job description/title: ");
        String jobDescription = scanner.nextLine();

        System.out.print("Enter minimum requirements: ");
        String minimumRequirements = scanner.nextLine();

        System.out.print("Enter minimum work experience: ");
        String minimumWorkExperience = scanner.nextLine();

        System.out.print("Does this job require business trips? (true/false): ");
        boolean requireBusinessTrips = scanner.nextBoolean();

        System.out.print("Does this job require a driver's license? (true/false): ");
        boolean requireDriverLicence = scanner.nextBoolean();


        // Create a new JobPosition object with the collected information
        JobPosition newJobPosition = new JobPosition();
        newJobPosition.setJobPositionId(HelperMethods.generateRandomIdLong());
        newJobPosition.setJobPlace(jobPlace);
        newJobPosition.setJobDescription(jobDescription);
        newJobPosition.setMinimumRequirements(minimumRequirements);
        newJobPosition.setMinimumWorkExperience(minimumWorkExperience);
        newJobPosition.setPostDate(LocalDate.now());
        newJobPosition.setRequireBusinessTrips(requireBusinessTrips);
        newJobPosition.setRequireDriverLicence(requireDriverLicence);
        newJobPosition.setEmployer(employer);
        newJobPosition.setActive(true);

        // Add the new job position to the list
        system.registerJobPosition(newJobPosition);

        System.out.println("New job position created successfully.");
    }

    @Override
    // Method to disable an existing job position
    public void disableJobPosition() {
        Scanner scanner = new Scanner(System.in);

        // Display the list of job positions
        displayAllActiveJobPositions();

        // Ask the user to choose a job position to disable
        System.out.print("Enter the number of the job position to disable: ");
        int choice = scanner.nextInt();

        // Check if the choice is valid
        if (choice >= 1 && choice <= system.getJobPositionsList().size()) {
            // Disable the selected job position (you can add a 'disabled' flag to the JobPosition class)
            JobPosition selectedJobPosition = system.getJobPositionsList().get(choice - 1);
            selectedJobPosition.setActive(false);
            System.out.println("Job position '" + selectedJobPosition.getJobDescription() + "' is now disabled.");
        } else {
            System.out.println("Invalid choice. Please select a valid job position.");
        }
    }
    @Override
    public void displayAllActiveJobPositions() {
        List<JobPosition> jobPositions = getAllPositions();
        System.out.println("Available job positions:");
        for (int i = 0; i < jobPositions.size(); i++) {
            if (jobPositions.get(i).isActive()) {
                System.out.println((i + 1) + ". " + jobPositions.get(i).getJobDescription());
            }
        }
    }

    @Override
    public List<JobPosition> getAllPositions() {
        return system.getJobPositionsList();
    }

    @Override
    public JobPosition selectJobPositionToApply(List<JobPosition> jobPositionList) {
        System.out.println("Please enter the number of the job position you want to apply for:");
        int jobPositionIndex = scanner.nextInt() - 1;
        return jobPositionList.get(jobPositionIndex);
    }

    /**
     * Calculates and assigns a score to each job position based on how well they match the user's job comparison elements.
     * The scoring is based on the number of attributes of a job position that match the user's preferences, including:
     * - Job location matching the user's desired city to work in.
     * - Required work experience matching the user's years of experience.
     * - Job category matching the user's preferred profession category.
     * - Driver's license requirement matching the user's possession of a driver's license.
     * - Business travel requirement matching the user's ability to travel for business.
     *
     * The job positions are then sorted based on their scores in descending order, with higher scores indicating a better match.
     *
     * @param applicant The user for whom the job positions are to be recommended, containing their job comparison elements.
     * @return A list of job positions sorted by their match score in descending order, with the best matches first.
     */
    @Override
    public List<JobPosition> getRecommendedJobPositions(ApplicantUser applicant) {
        List<JobPosition> jobPositions = getAllPositions();
        for (JobPosition jobPosition : jobPositions) {
            int score = 0;

            // Compare jobPlace with "City of desire for work"
            if (userHasComparisonElement(applicant, "City of desire for work", jobPosition.getJobPlace())) {
                score++;
            }

            if (userHasComparisonElement(applicant, "City of residence of the candidate", jobPosition.getJobPlace())) {
                score++;
            }

            // Compare minimumWorkExperience with "Years of experience"
            if (userHasComparisonElement(applicant, "Years of experience", jobPosition.getMinimumWorkExperience())) {
                score++;
            }

            // Compare jobCategory with "Profession category of choice"
            // This assumes jobCategory and comparison element both use a common identifier or name
            if (userHasComparisonElement(applicant, "Profession category of choice", jobPosition.getJobCategory().getDescription())) {
                score++;
            }

            // Compare requireDriverLicence with "Have a driver's license?"
            if (userHasComparisonElement(applicant, "Have a driver's license?", jobPosition.isRequireDriverLicence() ? "Yes" : "No")) {
                score++;
            }

            // Compare requireBusinessTrips with "Ability to travel on business?"
            if (userHasComparisonElement(applicant, "Ability to travel on business?", jobPosition.isRequireBusinessTrips() ? "Yes" : "No")) {
                score++;
            }

            jobPosition.setScore(score); // Assume JobPosition has a setScore method
        }

        // Sort jobPositions based on score in descending order
        Collections.sort(jobPositions, Comparator.comparingInt(JobPosition::getScore).reversed());

        return jobPositions;
    }

    /**
     * Checks if the user has a specified job comparison element that matches a given description and expected value.
     * This method is used to determine if a particular preference or requirement of the user (represented as a
     * JobComparisonElement) matches a specific attribute or requirement of a job position.
     *
     * @param user The user whose job comparison elements are to be checked.
     * @param description The description of the job comparison element to match. This should correspond to
     *                    one of the predefined descriptors in the user's job comparison elements, such as
     *                    "City of desire for work" or "Years of experience".
     * @param expectedValue The value that the job comparison element's value should match. For example, if
     *                      the description is "City of desire for work", the expectedValue might be "New York".
     * @return true if the user has a job comparison element that matches the specified description and value,
     *         false otherwise.
     */
    private boolean userHasComparisonElement(ApplicantUser user, String description, String expectedValue) {
        for (JobComparisonElement element : user.getJobComparisonElements()) {
            if (element.getDescription().equals(description) && element.getValue().equals(expectedValue)) {
                return true;
            }
        }
        return false;
    }
}

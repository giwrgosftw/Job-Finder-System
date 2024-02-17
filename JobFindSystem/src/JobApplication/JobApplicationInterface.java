package JobApplication;

import JobPosition.JobPosition;
import User.ApplicantUser;

public interface JobApplicationInterface {
    void createJobApplication(ApplicantUser user, JobPosition jobPosition);
}

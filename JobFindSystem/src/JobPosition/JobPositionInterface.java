package JobPosition;

import User.ApplicantUser;
import User.EmployerUser;

import java.util.List;

public interface JobPositionInterface {
    void displayAllActiveJobPositions();
    List<JobPosition> getAllPositions();
    JobPosition selectJobPositionToApply(List<JobPosition> jobPositionList);
    List<JobPosition> getRecommendedJobPositions(ApplicantUser user);
    void manageJobPositions(EmployerUser employer);
    void createJobPosition(EmployerUser employer);
    void disableJobPosition();
}

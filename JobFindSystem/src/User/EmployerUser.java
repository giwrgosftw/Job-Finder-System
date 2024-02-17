package User;

import Models.CompanyDetails;

public class EmployerUser extends User {
    private CompanyDetails companyDetails;

    // getters and setters

    public CompanyDetails getCompanyDetails() {
        return companyDetails;
    }

    public void setCompanyDetails(CompanyDetails companyDetails) {
        this.companyDetails = companyDetails;
    }
}

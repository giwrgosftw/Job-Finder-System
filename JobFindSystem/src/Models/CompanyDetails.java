package Models;

public class CompanyDetails {
    private Long companyDetailsId;
    private String companyContact;
    private String companyAddress;
    private String companyName;

    // getters and setters

    public Long getCompanyDetailsId() {
        return companyDetailsId;
    }

    public void setCompanyDetailsId(Long companyDetailsId) {
        this.companyDetailsId = companyDetailsId;
    }

    public String getCompanyContact() {
        return companyContact;
    }

    public void setCompanyContact(String companyContact) {
        this.companyContact = companyContact;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}

package JobComparisonElement;

import Models.JobCategory;

public class JobComparisonElement {
    private int jobComparisonElementId;
    private String value;
    private String description;
    private JobCategory jobCategory;

    // getters and setters

    public int getJobComparisonElementId() {
        return jobComparisonElementId;
    }

    public void setJobComparisonElementId(int jobComparisonElementId) {
        this.jobComparisonElementId = jobComparisonElementId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public JobCategory getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(JobCategory jobCategory) {
        this.jobCategory = jobCategory;
    }
}

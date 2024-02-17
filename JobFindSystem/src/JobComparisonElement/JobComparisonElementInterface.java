package JobComparisonElement;

import java.util.List;

public interface JobComparisonElementInterface {
    List<JobComparisonElement> collectJobComparisonElements();
    JobComparisonElement promptForJobComparisonElement(String description);
}

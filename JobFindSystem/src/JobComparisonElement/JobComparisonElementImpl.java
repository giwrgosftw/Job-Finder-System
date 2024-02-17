package JobComparisonElement;

import Shared.HelperMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JobComparisonElementImpl implements JobComparisonElementInterface {
    private Scanner scanner;

    public JobComparisonElementImpl(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<JobComparisonElement> collectJobComparisonElements() {
        List<JobComparisonElement> elements = new ArrayList<>();
        System.out.println("--- Job Comparison Elements: ---");
        elements.add(promptForJobComparisonElement("City of desire for work"));
        elements.add(promptForJobComparisonElement("City of residence of the candidate"));
        elements.add(promptForJobComparisonElement("Years of experience"));
        elements.add(promptForJobComparisonElement("Profession category of choice"));
        elements.add(promptForJobComparisonElement("Have a driver's license? (yes/no)"));
        elements.add(promptForJobComparisonElement("Ability to travel on business? (yes/no)"));

        return elements;
    }

    @Override
    public JobComparisonElement promptForJobComparisonElement(String description) {
        System.out.println(description + ": ");
        String value = scanner.next();

        JobComparisonElement element = new JobComparisonElement();
        element.setJobComparisonElementId(HelperMethods.generateRandomIdInt());
        element.setDescription(description);
        element.setValue(value);

        return element;
    }
}

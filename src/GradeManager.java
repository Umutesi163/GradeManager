import java.util.Arrays;

public class GradeManager {

    private int[] grades;
    private int count;

    public GradeManager(int size) {
        grades = new int[size];
        count = 0;
    }

    public void addGrade(int grade) throws InvalidGradeException {
        if (grade < 0 || grade > 100) {
            throw new InvalidGradeException("Grade must be between 0 and 100.");
        }

        try {
            grades[count++] = grade;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Grade list is full.");
        }
    }

    public double calculateAverage() {
        if (count == 0) {
            throw new IllegalArgumentException("No grades to calculate average.");
        }

        int sum = 0;
        for (int i = 0; i < count; i++) {
            sum += grades[i];
        }
        return (double) sum / count;
    }

    public int getHighestGrade() {
        int max = grades[0];
        for (int i = 1; i < count; i++) {
            if (grades[i] > max) max = grades[i];
        }
        return max;
    }

    public int getLowestGrade() {
        int min = grades[0];
        for (int i = 1; i < count; i++) {
            if (grades[i] < min) min = grades[i];
        }
        return min;
    }

    public void sortGrades() {
        Arrays.sort(grades, 0, count);
        System.out.println("Grades sorted.");
    }

    public boolean searchGrade(int grade) {
        for (int i = 0; i < count; i++) {
            if (grades[i] == grade) return true;
        }
        return false;
    }

    public void displayGrades() {
        System.out.print("Grades: ");
        for (int i = 0; i < count; i++) {
            System.out.print(grades[i] + " ");
        }
        System.out.println();
    }
}

public class Main {
    public static void main(String[] args) {

        GradeManager manager = new GradeManager(5);

        try {
            manager.addGrade(85);
            manager.addGrade(90);
            manager.addGrade(78);
            manager.addGrade(92);
            manager.addGrade(150); // invalid grade
        } catch (InvalidGradeException e) {
            System.out.println("Invalid input: " + e.getMessage());
        } finally {
            System.out.println("Grade entry process completed.");
        }

        manager.displayGrades();

        try {
            System.out.println("Average grade: " + manager.calculateAverage());
            System.out.println("Highest grade: " + manager.getHighestGrade());
            System.out.println("Lowest grade: " + manager.getLowestGrade());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        manager.sortGrades();
        manager.displayGrades();

        System.out.println("Searching for 90: " + manager.searchGrade(90));
    }
}

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new LinkedList();
        //students.add(new Student("Alla", 18));

        Optional<Student> firstStudent = students.stream().findFirst();
        System.out.println("First student in collection:\n" + firstStudent.orElse(new Student("none", 0)));
    }
}

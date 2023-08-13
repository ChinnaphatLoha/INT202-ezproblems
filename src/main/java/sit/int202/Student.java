package sit.int202;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double gpax;

    @Override
    public int compareTo(Student other) {
        int gpaxComparison = Double.compare(other.gpax, this.gpax);
        if (gpaxComparison != 0) {
            return gpaxComparison;
        }
        return this.name.compareTo(other.name);
    }

}

package sit.int202;

import lombok.*;

import java.util.Comparator;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

public class Student implements Comparable<Student> {
    private int id;
    private String name;
    private double gpax;

    @Override
    public int compareTo(Student other) {
        return this.id - other.id;
    }

    public static final Comparator<Student> SORT_BY_GPAX_DESC = (s1, s2) -> Comparator
            .comparingDouble(Student::getGpax)
            .reversed()
            .thenComparing(Student::getName)
            .compare(s1, s2);
}

package ITAcademy.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by .
 */
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "students")
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "courses_students", joinColumns = @JoinColumn(name = "S_ID"), inverseJoinColumns = @JoinColumn(name = "C_ID"))
    @Builder.Default
    private Set<Course> courses = new HashSet<>();


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "student_reviewTask", joinColumns = @JoinColumn(name = "S_id"), inverseJoinColumns = @JoinColumn(name = "RT_id"))
    @Builder.Default
    private Set<ReviewTask> reviewTasks = new HashSet<>();

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Review> reviews = new HashSet<>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void addReviewTask(ReviewTask reviewTask) {
        reviewTasks.add(reviewTask);
    }

    public void addReview(Review review) {
        reviews.add(review);
    }
}

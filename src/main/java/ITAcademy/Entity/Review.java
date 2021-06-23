package ITAcademy.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by .
 */
@Getter
@Setter
@Builder
@Entity
@Table(name = "reviews")
@NoArgsConstructor
@AllArgsConstructor
public class Review implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String review;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @JoinColumn(name = "teacher_id")
    private Long teacherId;

    @Override
    public String toString() {
        return "Review{" +
                " review='" + review + '\'' +
                ", teacherId=" + teacherId +
                '}';
    }
}

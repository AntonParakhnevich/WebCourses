package ITAcademy.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by .
 */
@Getter
@Setter
@Builder
@Entity
@Table(name = "review_Task")
@NoArgsConstructor
@AllArgsConstructor
public class ReviewTask implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private int mark;

    @JoinColumn(name = "teacher_id")
    private Long teacherId;

    @ManyToMany(mappedBy = "reviewTasks",cascade = CascadeType.ALL)
    @Builder.Default
    private Set<Student> students=new HashSet<>();

    @JoinColumn(name = "task_id")
    private Long taskId;

    @Override
    public String toString() {
        return "ReviewTask{" +
                " mark=" + mark +
                ", teacherId=" + teacherId +
                ", taskId=" + taskId +
                '}';
    }

    public void addStudent(Student student){
        students.add(student);
    }
}

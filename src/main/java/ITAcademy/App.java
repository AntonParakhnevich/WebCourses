package ITAcademy;

import ITAcademy.Entity.Course;
import ITAcademy.Entity.Review;
import ITAcademy.Entity.ReviewTask;
import ITAcademy.Entity.Student;
import ITAcademy.Entity.Task;
import ITAcademy.Entity.Teacher;
import ITAcademy.Util.HibernateUtil;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.List;

/**
 * Hello world!
 */
public class App {


    public static void main(String[] args) {
        Student student1 = Student.builder().firstName("anton").lastName("para").build();
        Student student2 = Student.builder().firstName("ivan").lastName("ivanov").build();
        Student student3 = Student.builder().firstName("petr").lastName("petrov").build();
        Student student4 = Student.builder().firstName("sasha").lastName("smirnov").build();

        Course course1 = Course.builder().name("math").build();
        Course course2 = Course.builder().name("english").build();

        Teacher teacher1 = Teacher.builder().name("Teacher1").build();
        Teacher teacher2 = Teacher.builder().name("Teacher2").build();
        Teacher teacher3 = Teacher.builder().name("Teacher3").build();

        Task task1 = Task.builder().name("task1").build();
        Task task2 = Task.builder().name("task2").build();
        Task task3 = Task.builder().name("task3").build();
        Task task4 = Task.builder().name("task4").build();

        student1.addCourse(course1);
        student2.addCourse(course1);
        course1.addStudent(student1);
        course1.addStudent(student2);
        course1.addTask(task1);
        course1.addTask(task2);
        course1.addTeacher(teacher1);
        course1.addTeacher(teacher2);
        teacher1.setCourse(course1);
        teacher2.setCourse(course1);

        student3.addCourse(course2);
        student4.addCourse(course2);
        course2.addStudent(student3);
        course2.addStudent(student4);
        course2.addTask(task2);
        course2.addTask(task3);
        course2.addTask(task4);
        course2.addTeacher(teacher3);
        teacher3.setCourse(course2);

//
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(student1);
        entityManager.persist(student2);
        entityManager.persist(student3);
        entityManager.persist(student4);
        entityManager.getTransaction().commit();

        ReviewTask reviewTask1 = ReviewTask.builder().mark(10).taskId(task1.getId()).teacherId(teacher1.getId()).build();
        ReviewTask reviewTask2 = ReviewTask.builder().mark(9).taskId(task2.getId()).teacherId(teacher1.getId()).build();
        ReviewTask reviewTask3 = ReviewTask.builder().mark(8).taskId(task3.getId()).teacherId(teacher1.getId()).build();
        ReviewTask reviewTask4 = ReviewTask.builder().mark(5).taskId(task1.getId()).teacherId(teacher1.getId()).build();

        Review review1 = Review.builder().review("good").teacherId(teacher1.getId()).build();
        Review review2 = Review.builder().review("bad").teacherId(teacher2.getId()).build();
        Review review3 = Review.builder().review("norm").teacherId(teacher3.getId()).build();
        Review review4 = Review.builder().review("best").teacherId(teacher1.getId()).build();

        student1.addReview(review1);
        student2.addReview(review2);
        student3.addReview(review3);
        student4.addReview(review4);

        review1.setStudent(student1);
        review2.setStudent(student2);
        review3.setStudent(student3);
        review4.setStudent(student4);
        student1.addReview(review1);
        student2.addReview(review2);
        student3.addReview(review3);
        student4.addReview(review4);

        student1.addReviewTask(reviewTask1);
        reviewTask1.addStudent(student1);
        student1.addReviewTask(reviewTask2);
        reviewTask2.addStudent(student1);

        student2.addReviewTask(reviewTask3);
        student2.addReviewTask(reviewTask1);
        reviewTask1.addStudent(student2);
        reviewTask3.addStudent(student2);
        student2.addReviewTask(reviewTask4);
        reviewTask4.addStudent(student2);


        entityManager.getTransaction().begin();
        entityManager.merge(student1);
        entityManager.merge(student2);
        entityManager.merge(student3);
        entityManager.merge(student4);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        List resultList = entityManager.createNativeQuery("SELECT * FROM students", Student.class).getResultList();
        System.out.println(resultList);
        entityManager.getTransaction().commit();

        HibernateUtil.close();
    }

    public static Student get(Serializable id){
        EntityManager entityManager = HibernateUtil.getEntityManager();
        entityManager.getTransaction().begin();
        Student student = entityManager.find(Student.class, id);
        entityManager.getTransaction().commit();
        return student;
    }
}

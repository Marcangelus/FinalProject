package model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Marc
 */
@Entity
@Table(name = "Courses")
public class Course implements Serializable {

    @Column(name = "courseId", length = 10)
    @Id
    private int courseId;
    @Column(name = "courseName", unique = false, nullable = false, length = 50)
    private String courseName;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "course")   // LAZY LOADING           EAGER 
    private Set<Marks> markss;

    public Set<Marks> getMarkss() {
        return markss;
    }

    public void setMarkss(Set<Marks> markss) {
        this.markss = markss;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

package model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Marc
 */
@Embeddable
public class MarksPK implements Serializable {

    /*  https://www.baeldung.com/hibernate-identifiers */
    private Integer student;
    private Integer course;

    public MarksPK() {
    }

    public int hashCode() {
        return (int) this.student.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MarksPK)) {
            return false;
        }
        MarksPK pk = (MarksPK) obj;
        return pk.course.equals(this.course) && pk.student.equals(this.student);
    }

    public Integer getStudent() {
        return student;
    }

    public void setStudent(Integer student) {
        this.student = student;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }
}

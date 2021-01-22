package model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;

/**
 * @author Marc
 */
@Entity
@Table(name = "Students")
public class Student implements Serializable//        extends Person
{

    @Column(name = "studentId", length = 10)
    @Id
    private int studentId;
    @Column(name = "firstName", unique = false, nullable = false, length = 30)
    private String firstName;
    @Column(name = "lastName", unique = false, nullable = false, length = 30)
    private String lastName;
    @Column(name = "diploma", unique = false, nullable = false, length = 30)
    private String diploma;
    @Column(name = "email", unique = false, nullable = false, length = 40)
    private String email;
//    @Column(name = "userId")
//     private int userId;

//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "student")   // LAZY LOADING           EAGER 
    private Set<Marks> markss;

    public Set<Marks> getMarkss() {
        return markss;
    }

    public void setMarkss(Set<Marks> markss) {
        this.markss = markss;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getDiploma() {
        return diploma;
    }

    public void setDiploma(String diploma) {
        this.diploma = diploma;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}

package model;

import java.io.Serializable;
import javax.persistence.*;
import javax.persistence.IdClass;

/* @author Marc */
@Entity
@IdClass(MarksPK.class)
@Table(name = "MARKS")
public class Marks implements Serializable {
    
    @Id
    private int student;
    @Id
    private int course;    
    @Column(name = "marks1", unique = false, nullable = false, length = 3, precision = 1)
    private double marks1;
    @Column(name = "marks2", unique = false, nullable = false, length = 3, precision = 1)
    private double marks2;

    public Marks() {
    }

    public int getStudent() {
        return student;
    }

    public void setStudent(int student) {
        this.student = student;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getMarks1() {
        return marks1;
    }

    public void setMarks1(double marks1) {
        this.marks1 = marks1;
    }

    public double getMarks2() {
        return marks2;
    }

    public void setMarks2(double marks2) {
        this.marks2 = marks2;
    }

    public String grade() {
        double average = (this.marks1 + this.marks2) / 2;
        String grade = "";
        if (average >= 90) {
            grade = "A";
        } else if (average >= 70 && average < 90) {
            grade = "B";
        } else if (average >= 60 && average < 70) {
            grade = "C";
        } else if (average < 60) {
            grade = "F";
        }
        return grade;
    }
}

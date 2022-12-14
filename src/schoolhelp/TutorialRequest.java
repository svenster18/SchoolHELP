/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolhelp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class TutorialRequest extends Request {
    private LocalDate proposedDate;
    private LocalTime proposedTime;
    private String studentLevel;
    private int numStudents;

    public LocalDate getProposedDate() {
        return proposedDate;
    }

    public void setProposedDate(LocalDate proposedDate) {
        this.proposedDate = proposedDate;
    }

    public LocalTime getProposedTime() {
        return proposedTime;
    }

    public void setProposedTime(LocalTime proposedTime) {
        this.proposedTime = proposedTime;
    }

    public String getStudentLevel() {
        return studentLevel;
    }

    public void setStudentLevel(String studentLevel) {
        this.studentLevel = studentLevel;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }
    
    
}

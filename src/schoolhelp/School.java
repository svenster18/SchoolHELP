/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolhelp;

import java.util.LinkedList;

/**
 *
 * @author risak
 */
public class School {
    private int schoolID;
    private String schoolName;
    private String address;
    private String city;
    private LinkedList<SchoolAdmin> schoolAdmins = new LinkedList<>();
    private LinkedList<Request> requests = new LinkedList<>();
    
    
    public int getSchoolID() {
        return schoolID;
    }

    public void setSchoolID(int schoolID) {
        this.schoolID = schoolID;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public LinkedList<SchoolAdmin> getSchoolAdmins() {
        return schoolAdmins;
    }

    public void setSchoolAdmins(LinkedList<SchoolAdmin> schoolAdmins) {
        this.schoolAdmins = schoolAdmins;
    }

    public LinkedList<Request> getRequests() {
        return requests;
    }

    public void setRequests(LinkedList<Request> requests) {
        this.requests = requests;
    }
}

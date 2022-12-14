/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolhelp;

import java.time.LocalDate;
import java.util.Date;
import java.util.LinkedList;

public class Request {
    private int requestID;
    private LocalDate requestDate = LocalDate.now();
    private String requestStatus = "NEW";
    private String description;
    private School school;
    private LinkedList<Offer> offers = new LinkedList<>();

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public LinkedList<Offer> getOffers() {
        return offers;
    }

    public void setOffers(LinkedList<Offer> offers) {
        this.offers = offers;
    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolhelp;

import java.time.LocalDate;
import java.util.LinkedList;

public class Volunteer extends User {
    private LocalDate dateOfBirth;
    private String occupation;
    private LinkedList<Offer> offers = new LinkedList<>();

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public LinkedList<Offer> getOffers() {
        return offers;
    }

    public void setOffers(LinkedList<Offer> offers) {
        this.offers = offers;
    }
}

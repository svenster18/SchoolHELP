/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolhelp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

public class SchoolHELP {

    private LinkedList<School> schools = new LinkedList<>();
    private LinkedList<User> users = new LinkedList<>();
    private int id = 0;
    private int requestId = 0;

    public void init() {
        User schoolHELPAdmin = new User();
        schoolHELPAdmin.setUsername("cliff");
        schoolHELPAdmin.setPassword("12345");
        schoolHELPAdmin.setFullname("Cliff Bryant");
        schoolHELPAdmin.setEmail("cliff@email.com");
        schoolHELPAdmin.setPhone("012718273");
        users.add(schoolHELPAdmin);
    }

    public User login(String username, String password) {
        try {
            User user = this.users.stream().filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password)).findAny().get();
            return user;
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public User loginAsVolunteer(String username) {
        try {
            User user = (User) this.users.stream().filter(u -> u.getUsername().equals(username)).findAny().get();
            return user;
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void registerAsVolunteer(Volunteer volunteer) {
        users.add(volunteer);
    }

    public void registerSchool(School school, SchoolAdmin schoolAdmin) {
        id++;
        school.setSchoolID(id);
        schoolAdmin.setSchool(school);
        try {
            this.schools.stream().filter(s -> s.getSchoolName().equals(school.getSchoolName())).findFirst().get().getSchoolAdmins().add(schoolAdmin);
        } catch (NoSuchElementException e) {
            school.getSchoolAdmins().add(schoolAdmin);
            schools.add(school);
        } finally {
            users.add(schoolAdmin);
        }
    }

    public void changePassword(User user, String password) {
        this.users.stream().filter(u -> u.getUsername().equals(user.getUsername())).findFirst().get().setPassword(password);
    }

    public void updateProfile(SchoolAdmin schoolAdmin) {
        this.users.removeIf(u -> u.getUsername().equals(schoolAdmin.getUsername()));
        this.users.add(schoolAdmin);
    }

    public boolean submitRequest(Request request, School school) {
        requestId++;
        request.setRequestID(requestId);
        request.setSchool(school);
        return this.schools.stream().filter(s -> s.getSchoolID() == school.getSchoolID()).findFirst().get().getRequests().add(request);
    }

    public List<Request> findRequests(String schoolName) {
        try {
            School school = this.schools.stream().filter(s -> s.getSchoolName().equals(schoolName)).findAny().get();
            return school.getRequests();
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public void acceptOffer(Offer offer) {
        this.schools.stream().filter(s -> s.getSchoolID() == offer.getRequest().getSchool().getSchoolID()).findFirst().get()
                .getRequests().stream().filter(r -> r.getRequestID() == offer.getRequest().getRequestID()).findFirst().get()
                .getOffers().stream().filter(o -> o.getRemarks().equals(offer.getRemarks())).findFirst().get()
                .setOfferStatus("ACCEPTED");
    }

    public void closeRequest(Request request) {
        this.schools.stream().filter(s -> s.getSchoolID() == request.getSchool().getSchoolID()).findFirst().get()
                .getRequests().stream().filter(r -> r.getRequestID() == request.getRequestID()).findFirst().get()
                .setRequestStatus("CLOSED");
    }

    public List<Request> findBySchool(String schoolName) {
        try {
            School school = this.schools.stream().filter(s -> s.getSchoolName().toLowerCase().contains(schoolName)).findAny().get();
            return school.getRequests().stream().filter(r -> r.getRequestStatus().equals("NEW")).collect(Collectors.toList());
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<Request> findByCity(String city) {
        LinkedList<Request> requests = new LinkedList<>();
        this.schools.stream().filter(s -> s.getCity().toLowerCase().contains(city)).forEach(school -> {
            try {
                requests.addAll(school.getRequests().stream().filter(r -> r.getRequestStatus().equals("NEW")).collect(Collectors.toList()));
            } catch (NoSuchElementException e) {
                
            }
        });

        return requests;
    }

    public List<Request> findByRequestDate(String requestDate) {
        LinkedList<Request> requests = new LinkedList<>();
        this.schools.stream().forEach(school -> {
            try {
                requests.addAll(school.getRequests().stream().filter(r -> r.getRequestStatus().equals("NEW") && r.getRequestDate().toString().toLowerCase().contains(requestDate)).collect(Collectors.toList()));
            } catch (NoSuchElementException e) {
                
            }
        });

        return requests;
    }
    
    public List<User> findAllUsers() {
        Collections.sort(users, (u1, u2) -> u1.getFullname().compareTo(u2.getFullname()));
        return users;
    }
    
    public List<Request> findAllRequests() {
        LinkedList<Request> requests = new LinkedList<>();
        this.schools.stream().forEach(school -> {
            try {
                requests.addAll(school.getRequests().stream().collect(Collectors.toList()));
            } catch (NoSuchElementException e) {
                
            }
        });
        Collections.sort(requests, (r1, r2) -> r1.getSchool().getSchoolName().compareTo(r2.getSchool().getSchoolName()));

        return requests;
    }

    public void submitOffer(Offer offer, String schoolName) {
        School school = this.schools.stream().filter(s -> s.getSchoolName().equals(schoolName)).findAny().get();
        school.getRequests().stream().filter(r -> r.getRequestID() == offer.getRequest().getRequestID()).findFirst().get().getOffers().add(offer);
    }
    
    public void save() {
        try {
            FileOutputStream fout = new FileOutputStream("users.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(users);
            out.flush();
            out.close();
            fout.close();
            FileOutputStream foutSchool = new FileOutputStream("schools.txt");
            ObjectOutputStream outSchool = new ObjectOutputStream(foutSchool);
            outSchool.writeObject(schools);
            outSchool.flush();
            outSchool.close();
            foutSchool.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    public void load() {
        try {
            FileInputStream fileIn = new FileInputStream("users.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            users = (LinkedList<User>) in.readObject();
            in.close();
            fileIn.close();
            FileInputStream fileInSchool = new FileInputStream("schools.txt");
            ObjectInputStream inSchool = new ObjectInputStream(fileInSchool);
            schools = (LinkedList<School>) inSchool.readObject();
            inSchool.close();
            fileInSchool.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

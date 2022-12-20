/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package schoolhelp;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class SchoolHELP {

    private final LinkedList<School> schools = new LinkedList<>();
    private final LinkedList<User> users = new LinkedList<>();
    private int id = 0;

    public void init() {
        User schoolHELPAdmin = new User();
        schoolHELPAdmin.setUsername("cliff");
        schoolHELPAdmin.setPassword("12345");
        schoolHELPAdmin.setFullname("Cliff Bryant");
        schoolHELPAdmin.setEmail("cliff@email.com");
        schoolHELPAdmin.setPhone("012718273");
        users.add(schoolHELPAdmin);
        School school = new School();
        school.setSchoolName("SMAN 1 Rancaekek");
        school.setAddress("Jl. Walini");
        school.setCity("Bandung");
        
        SchoolAdmin schoolAdmin = new SchoolAdmin();
        schoolAdmin.setUsername("rizki");
        schoolAdmin.setPassword("r12k14n4k50l3h");
        schoolAdmin.setFullname("Mohamad Rizki");
        schoolAdmin.setEmail("mohamadrizki8@gmail.com");
        schoolAdmin.setPhone("081316560190");
        schoolAdmin.setStaffID("3204281806000002");
        schoolAdmin.setPosition("IT Admin");
        registerSchool(school, schoolAdmin);
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
            School school = this.schools.stream().filter(s -> s.getSchoolName().equals(schoolName)).findAny().get();
            return school.getRequests().stream().filter(r -> r.getRequestStatus().equals("NEW")).collect(Collectors.toList());
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<Request> findByCity(String city) {
        try {
            School school = this.schools.stream().filter(s -> s.getCity().equals(city)).findAny().get();
            return school.getRequests().stream().filter(r -> r.getRequestStatus().equals("NEW")).collect(Collectors.toList());
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public List<Request> findByRequestDate(String requestDate) {
        LinkedList<Request> requests = new LinkedList<>();
        this.schools.stream().forEach(school -> {
            try {
                requests.addAll(school.getRequests().stream().filter(r -> r.getRequestStatus().equals("NEW") && r.getRequestDate().toString().equals(requestDate)).collect(Collectors.toList()));
            } catch (NoSuchElementException e) {
                
            }
        });

        return requests;
    }

    public void submitOffer(Offer offer, String schoolName) {
        School school = this.schools.stream().filter(s -> s.getSchoolName().equals(schoolName)).findAny().get();
        school.getRequests().stream().filter(r -> r.getRequestID() == offer.getRequest().getRequestID()).findFirst().get().getOffers().add(offer);
    }
}

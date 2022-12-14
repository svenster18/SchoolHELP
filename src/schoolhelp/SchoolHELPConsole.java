/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package schoolhelp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SchoolHELPConsole {

    private static final SchoolHELP schoolHELP = new SchoolHELP();
    public static User user;
    public static SchoolAdmin schoolAdmin;
    public static Volunteer volunteer;
    static int schoolID = 1, requestID = 1;
    static String[] resourceTypeArray = {"Mobile Device", "Personal Computer", "Networking Equipment"};
    private static final Scanner scanner = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        schoolHELP.init();
        int select;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Welcome in SchoolHELP");
            System.out.println("1. Login");
            System.out.println("2. Register as Volunteer");
            System.out.println("3. View Requests");
            System.out.println("4. Exit");
            select = Integer.parseInt(scanner.nextLine());
            switch (select) {
                case 1:
                    login();
                    break;
                case 2:
                    registerAsVolunteer();
                    break;
                case 3:
                    viewRequests();
                    break;
            }
        } while (select != 4);
        scanner.close();
    }

    public static void login() {
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Login");
            System.out.print("Username : ");
            String username = scanner.nextLine();
            System.out.print("Password : ");
            String password = scanner.nextLine();
            user = schoolHELP.login(username, password);
            if (user != null) {
                if (user instanceof SchoolAdmin) {
                    schoolAdmin = (SchoolAdmin) user;
                    menuSchoolAdministrator();
                } else {
                    menuSchoolHelpAdmin(user);
                }
            } else {
                System.out.println("Wrong username/password");
            }
            System.out.println();
        } while (user == null);
    }

    public static void registerAsVolunteer() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String username;
        String password;
        String fullname;
        String email;
        String phone;
        String occupation;
        String dateString;
        LocalDate dateOfBirth;
        System.out.println("Register as Volunteer");
        System.out.print("Username : ");
        username = scanner.nextLine();
        System.out.print("Password : ");
        password = scanner.nextLine();
        System.out.print("Fullname : ");
        fullname = scanner.nextLine();
        System.out.print("Email : ");
        email = scanner.nextLine();
        System.out.print("Phone : ");
        phone = scanner.nextLine();
        System.out.print("Occupation : ");
        occupation = scanner.nextLine();
        System.out.print("Date Of Birth (2022-02-22): ");
        dateString = scanner.nextLine();
        dateOfBirth = LocalDate.parse(dateString);
        Volunteer newVolunteer = new Volunteer();
        newVolunteer.setUsername(username);
        newVolunteer.setPassword(password);
        newVolunteer.setFullname(fullname);
        newVolunteer.setEmail(email);
        newVolunteer.setPhone(phone);
        newVolunteer.setOccupation(occupation);
        newVolunteer.setDateOfBirth(dateOfBirth);
        schoolHELP.registerAsVolunteer(newVolunteer);
    }

    public static void menuSchoolAdministrator() {
        int menuSchoolAdmin;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Welcome " + schoolAdmin.getFullname());
            System.out.println(schoolAdmin.getPosition());
            System.out.println("School ID : " + schoolAdmin.getSchool().getSchoolID());
            System.out.println(schoolAdmin.getSchool().getSchoolName());
            System.out.println("Menu");
            System.out.println("1. Submit Request ");
            System.out.println("2. Review Offers ");
            System.out.println("3. Change Password ");
            System.out.println("4. Update User Profile");
            System.out.println("5. Logout");
            menuSchoolAdmin = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (menuSchoolAdmin) {
                case 1: {
                    submitRequest();
                    break;
                }
                case 2: {
                    reviewOffers();
                    break;
                }
                case 3: {
                    changePassword();
                    break;
                }
                case 4: {
                    updateProfile();
                    break;
                }
            }
        } while (menuSchoolAdmin != 5);
    }

    public static void submitRequest() {
        int menuSchoolAdmin;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Welcome " + schoolAdmin.getFullname());
            System.out.println(schoolAdmin.getPosition());
            System.out.println("School ID : " + schoolAdmin.getSchool().getSchoolID());
            System.out.println(schoolAdmin.getSchool().getSchoolName());
            System.out.println("Submit Request");
            System.out.println("1. Tutorial Request ");
            System.out.println("2. Resource Request");
            System.out.println("3. Back");
            menuSchoolAdmin = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (menuSchoolAdmin) {
                case 1: {
                    submitTutorialRequest();
                    break;
                }
                case 2: {
                    submitResourceRequest();
                    break;
                }
            }
        } while (menuSchoolAdmin != 3);
    }

    public static void submitTutorialRequest() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String description, dateString, timeString, studentLevel;
        int numStudents;
        LocalDate proposedDate;
        LocalTime proposedTime;
        System.out.println("Submit Tutorial Request");
        System.out.print("Description : ");
        description = scanner.nextLine();
        System.out.print("Proposed Date (2022-02-20) : ");
        dateString = scanner.nextLine();
        proposedDate = LocalDate.parse(dateString);
        System.out.print("Proposed Time (06:30) : ");
        timeString = scanner.nextLine();
        proposedTime = LocalTime.parse(timeString);
        System.out.print("Student Level : ");
        studentLevel = scanner.nextLine();
        System.out.print("Number of Expected Students : ");
        numStudents = Integer.parseInt(scanner.nextLine());
        TutorialRequest tutorialRequest = new TutorialRequest();
        tutorialRequest.setRequestID(requestID);
        tutorialRequest.setDescription(description);
        tutorialRequest.setProposedDate(proposedDate);
        tutorialRequest.setProposedTime(proposedTime);
        tutorialRequest.setStudentLevel(studentLevel);
        tutorialRequest.setNumStudents(numStudents);
        tutorialRequest.setSchool(schoolAdmin.getSchool());
        if (schoolHELP.submitRequest(tutorialRequest, schoolAdmin.getSchool())) {
            System.out.println("Submit Success");
        }
        requestID++;
    }

    public static void submitResourceRequest() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        ResourceRequest resourceRequest = new ResourceRequest();
        resourceRequest.setRequestID(requestID);
        System.out.println("Submit Resource Request");
        System.out.println("Resource Type : ");
        System.out.println("1. Mobile Device");
        System.out.println("2. Personal Computer");
        System.out.println("3. Networking Equipment");
        resourceRequest.setResourceType(resourceTypeArray[Integer.parseInt(scanner.nextLine()) - 1]);
        System.out.print("Number Required : ");
        resourceRequest.setNumRequired(Integer.parseInt(scanner.nextLine()));
        resourceRequest.setSchool(schoolAdmin.getSchool());
        schoolHELP.submitRequest(resourceRequest, schoolAdmin.getSchool());
        requestID++;
    }

    public static void reviewOffers() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        List<Request> requests = schoolHELP.findRequests(schoolAdmin.getSchool().getSchoolName());
        Comparator<Request> comparator = Comparator.comparing(request -> request.getRequestStatus());
        comparator = comparator.thenComparing(Comparator.comparing(request -> request.getRequestDate()));
        requests = requests.stream().sorted(comparator.reversed()).collect(Collectors.toList());
        int i = 1;
        for (Request request : requests) {
            viewRequest(i, request);
            i++;
        }
        System.out.print("Select Request :");
        int selectRequest = Integer.parseInt(scanner.nextLine());
        int accept = -1;
        char another = 'n';
        List<Offer> offers;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            viewDetails(requests.get(selectRequest - 1));
            offers = requests.get(selectRequest - 1).getOffers();
            int j = 1;
            if (!offers.isEmpty()) {
                for (Offer offer : offers) {
                    System.out.print(j + ". ");
                    System.out.println("Offer Date : " + offer.getOfferDate());
                    System.out.println("   Remarks : " + offer.getRemarks());
                    System.out.println("");
                    j++;
                }
                System.out.print("Select Offer :");
                int selectOffer = Integer.parseInt(scanner.nextLine());
                Offer offer = offers.get(selectOffer - 1);
                viewOffer(offers.get(selectOffer - 1));
                System.out.println("1. Accept Offer");
                System.out.println("2. Back");
                accept = Integer.parseInt(scanner.nextLine());
                if (accept == 1) {
                    schoolHELP.acceptOffer(offer);
                    System.out.println("Request Accepted");
                    System.out.print("Accept Another Offer(y/n) : ");
                    another = scanner.nextLine().charAt(0);
                }
            }
        } while ((accept == '2' || another == 'y') && !offers.isEmpty());
        System.out.println("1. Close Request(y/n) : ");
        char close = scanner.nextLine().charAt(0);
        if (close == 'y') {
            schoolHELP.closeRequest(requests.get(selectRequest - 1));
            System.out.println("Request Closed");
        }
    }

    public static void viewOffer(Offer offer) {
        System.out.println("Offer Date           : " + offer.getOfferDate());
        System.out.println("Remarks              : " + offer.getRemarks());
        System.out.println("Volunteer Name       : " + volunteer.getFullname());
        Period period = Period.between(volunteer.getDateOfBirth(), LocalDate.now());
        System.out.println("Volunteer Age        : " + period.getYears());
        System.out.println("Volunteer Occupation : " + volunteer.getOccupation());

    }

    public static void menuSchoolHelpAdmin(User user) {
        int menuSchoolHelpAdmin;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Welcome " + user.getFullname());
            System.out.println("Menu ");
            System.out.println("1. Register School ");
            System.out.println("2. Logout");
            menuSchoolHelpAdmin = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (menuSchoolHelpAdmin) {
                case 1: {
                    registerSchool();
                    break;
                }
            }
        } while (menuSchoolHelpAdmin != 2);
    }

    public static void registerSchool() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String schoolName;
        String address;
        String city;
        System.out.println("Register School");
        System.out.print("School Name : ");
        schoolName = scanner.nextLine();
        System.out.print("School Address : ");
        address = scanner.nextLine();
        System.out.print("City : ");
        city = scanner.nextLine();
        School school = new School();
        school.setSchoolID(schoolID);
        school.setSchoolName(schoolName);
        school.setAddress(address);
        school.setCity(city);

        String username;
        String password;
        String fullname;
        String email;
        String phone;
        String staffID;
        String position;
        System.out.println("\nCreate Account");
        System.out.print("Username : ");
        username = scanner.nextLine();
        System.out.print("Password : ");
        password = scanner.nextLine();
        System.out.print("Fullname : ");
        fullname = scanner.nextLine();
        System.out.print("Email : ");
        email = scanner.nextLine();
        System.out.print("Phone : ");
        phone = scanner.nextLine();
        System.out.print("StaffID : ");
        staffID = scanner.nextLine();
        System.out.print("Position : ");
        position = scanner.nextLine();
        SchoolAdmin newschoolAdmin = new SchoolAdmin();
        newschoolAdmin.setUsername(username);
        newschoolAdmin.setPassword(password);
        newschoolAdmin.setFullname(fullname);
        newschoolAdmin.setEmail(email);
        newschoolAdmin.setPhone(phone);
        newschoolAdmin.setStaffID(staffID);
        newschoolAdmin.setPosition(position);
        schoolHELP.registerSchool(school, newschoolAdmin);
        schoolID++;

    }

    public static void changePassword() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Change Password");
        System.out.print("New Password : ");
        String password = scanner.nextLine();
        schoolHELP.changePassword(user, password);
    }

    public static void updateProfile() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        String fullname;
        String email;
        String phone;
        String staffID;
        String position;
        System.out.println("Update Profile");
        System.out.print("Fullname : ");
        fullname = scanner.nextLine();
        System.out.print("Email : ");
        email = scanner.nextLine();
        System.out.print("Phone : ");
        phone = scanner.nextLine();
        System.out.print("StaffID : ");
        staffID = scanner.nextLine();
        System.out.print("Position : ");
        position = scanner.nextLine();
        if (!fullname.isEmpty()) {
            schoolAdmin.setFullname(fullname);
        }
        if (!email.isEmpty()) {
            schoolAdmin.setEmail(email);
        }
        if (!phone.isEmpty()) {
            schoolAdmin.setPhone(phone);
        }
        if (!staffID.isEmpty()) {
            schoolAdmin.setStaffID(staffID);
        }
        if (!position.isEmpty()) {
            schoolAdmin.setPosition(position);
        }
        schoolHELP.updateProfile(schoolAdmin);
        schoolID++;
    }

    public static void viewRequests() {
        int menuView;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            List<Request> requests = null;
            System.out.println("View Requests by");
            System.out.println("1. School");
            System.out.println("2. City");
            System.out.println("3. Request Date");
            System.out.println("4. Back");
            menuView = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (menuView) {
                case 1: {
                    System.out.print("School Name : ");
                    String schoolName = scanner.nextLine();
                    requests = schoolHELP.findBySchool(schoolName);
                    break;
                }
                case 2: {
                    System.out.print("City : ");
                    String city = scanner.nextLine();
                    requests = schoolHELP.findByCity(city);
                    break;
                }
                case 3: {
                    System.out.print("Request Date (2022-02-20) : ");
                    String requestDate = scanner.nextLine();
                    requests = schoolHELP.findByRequestDate(requestDate);
                    break;
                }
            }
            if (requests != null) {
                if (!requests.isEmpty()) {
                    int i = 1;
                    for (Request request : requests) {
                        viewRequest(i, request);
                        i++;
                    }
                    int selectRequest = Integer.parseInt(scanner.nextLine());
                    viewDetails(requests.get(selectRequest - 1));
                    System.out.println("1. Submit Offer");
                    System.out.println("2. Back");
                    int menuDetails = Integer.parseInt(scanner.nextLine());
                    if (menuDetails == 1) {
                        loginAsVolunteer(requests.get(selectRequest - 1));
                    }
                } else {
                    System.out.println("Request Not Found");
                    scanner.nextLine();
                }
            }
        } while (menuView != 4);
    }

    public static void viewRequest(int i, Request request) {
        System.out.print(i + ". ");
        System.out.println("Request Date : " + request.getRequestDate());
        System.out.println("   Description : " + request.getDescription());
        System.out.println("   School Name : " + request.getSchool().getSchoolName());
        System.out.println("   City : " + request.getSchool().getCity());
        System.out.println();
    }

    public static void viewDetails(Request request) {
        if (request instanceof TutorialRequest) {
            TutorialRequest tutorialRequest = (TutorialRequest) request;
            System.out.println("Tutorial Date and Time : " + tutorialRequest.getProposedDate() + ", " + tutorialRequest.getProposedTime());
            System.out.println("Student Level : " + tutorialRequest.getStudentLevel());
            System.out.println("Number of Students : " + tutorialRequest.getNumStudents());
        } else if (request instanceof ResourceRequest) {
            ResourceRequest resourceRequest = (ResourceRequest) request;
            System.out.println("Resource Type : " + resourceRequest.getResourceType());
            System.out.println("Number Required : " + resourceRequest.getNumRequired());
        }
    }

    public static void loginAsVolunteer(Request request) {
        String username;
        String password;
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println("Login");
            System.out.print("Username : ");
            username = scanner.nextLine();
            System.out.print("Password : ");
            password = scanner.nextLine();
            user = schoolHELP.loginAsVolunteer(username);
            if (user != null) {
                if (user.getPassword().equals(password)) {
                    volunteer = (Volunteer) user;
                    submitOffer(request);
                } else {
                    System.out.println("Wrong password");
                }
            } else {
                user = new User();
                password = "Random";
                registerAsVolunteer();
            }
        } while (!user.getPassword().equals(password));
    }

    public static void submitOffer(Request request) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("Submit Offer");
        System.out.print("Remarks : ");
        String remarks = scanner.nextLine();
        Offer offer = new Offer();
        offer.setRemarks(remarks);
        offer.setVolunteer(volunteer);
        offer.setRequest(request);
        schoolHELP.submitOffer(offer, schoolAdmin.getSchool().getSchoolName());
    }

}

package Entities;

import Utilities.SignedInUser;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "hms_user")
public class HmsUser {
    @Id
    @Column(name = "username", nullable = false, length = 45)
    private String id;

    @Column(name = "password", nullable = false, length = 45)
    private String password;

    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;

    @Column(name = "last_name", length = 45)
    private String lastName;

    @Column(name = "cnic", nullable = false, length = 45)
    private String cnic;

    @Column(name = "phone_number", nullable = false, length = 45)
    private String phoneNumber;

    @Column(name = "email_address", nullable = false, length = 45)
    private String emailAddress;

    @Column(name = "is_doctor")
    private Boolean isDoctor;

    public static String logIn(String username, String password) {
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(HmsUser.class);

        SessionFactory sf = con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        List<HmsUser> UserList = session.createQuery("FROM HmsUser").getResultList();

        for(int i=0;i<UserList.size();i++)
        {
            System.out.println(UserList.get(i).getId());
            System.out.println(UserList.get(i).getPassword());
            if(username.equals(UserList.get(i).getId()) && password.equals(UserList.get(i).getPassword())) {
                if(UserList.get(i).getIsDoctor() == true){
                    return "isDoctor";
                }
                else{
                    return "isPatient";
                }
            }
        }
        return "none";
    }

    public static HmsUser retrieveUser(String username, String password) {
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(HmsUser.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        List<HmsUser> UserList = session.createQuery("FROM HmsUser ").getResultList();

        for(int i=0;i<UserList.size();i++)
        {
            System.out.println(UserList.get(i).getId());
            System.out.println(UserList.get(i).getPassword());
            if(username.equals(UserList.get(i).getId()) && password.equals(UserList.get(i).getPassword()))
            {
                return UserList.get(i);
            }
        }
        return null;
    }

    public static HmsUser retrieveUser(String username) {
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(HmsUser.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        List<HmsUser> UserList = session.createQuery("FROM HmsUser ").getResultList();

        for(int i=0;i<UserList.size();i++)
        {
            System.out.println(UserList.get(i).getId());
            System.out.println(UserList.get(i).getPassword());
            if(username.equals(UserList.get(i).getId()))
            {
                return UserList.get(i);
            }
        }
        return null;
    }

    public static HmsUser updateSignedInUser(String first_name, String last_name, String email_address, String password) {
        SignedInUser signedInUser = SignedInUser.getInstance();
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(HmsUser.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        HmsUser hmsUser = session.get(HmsUser.class,signedInUser.getUser().getId());
        hmsUser.setFirstName(first_name);
        hmsUser.setLastName(last_name);
        hmsUser.setEmailAddress(email_address);
        hmsUser.setPassword(password);
        session.update(hmsUser);
        return hmsUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Boolean getIsDoctor() {
        return isDoctor;
    }

    public void setIsDoctor(Boolean isDoctor) {
        this.isDoctor = isDoctor;
    }

    public void registerAUser(String username, String password, String email, String cnic, String firstName, String lastName, String phoneNumber, String confirmedPassword, boolean isDoctor) {

        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(HmsUser.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();

        HmsUser user= new HmsUser();

        user.setId(username);
        user.setPassword(password);
        user.setEmailAddress(email);
        user.setCnic(cnic);
        user.setPhoneNumber(phoneNumber);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setIsDoctor(isDoctor);
        session.save(user);
        trans.commit();

    }

    public ArrayList<String> retrieveDoctors() {
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(HmsUser.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        List<HmsUser> memberList = session.createQuery("FROM HmsUser").getResultList();
        ArrayList<String> doctors_list_string = new ArrayList<>();

        for(int i=0;i<memberList.size();i++)
        {
            if(memberList.get(i).getIsDoctor() == true){
                doctors_list_string.add(memberList.get(i).getId());
            }


        }
        return doctors_list_string;
    }

    public ArrayList<String> retrieveDoctorsNames() {
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(HmsUser.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();
        List<HmsUser> memberList = session.createQuery("FROM HmsUser").getResultList();
        ArrayList<String> doctors_list_string = new ArrayList<>();

        for(int i=0;i<memberList.size();i++)
        {
            if(memberList.get(i).getIsDoctor() == true){
                doctors_list_string.add(memberList.get(i).getFirstName());
            }


        }
        return doctors_list_string;
    }
}
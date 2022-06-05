package Entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;

@Entity
@Table(name = "hmsdoctor")
public class HmsDoctor {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "doctorid", nullable = false)
    private Integer id;

    @Column(name = "userid", nullable = false, length = 45)
    private String userid;

    @Column(name = "fname", nullable = false, length = 45)
    private String fname;

    @Column(name = "lname", nullable = false, length = 45)
    private String lname;

    @Column(name = "speciality", length = 45)
    private String speciality;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public void registerADoctor(String userID, String firstName, String lastName){
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(HmsUser.class);

        SessionFactory sf= con.buildSessionFactory();
        Session session= sf.openSession();
        Transaction trans= session.beginTransaction();

        HmsDoctor doctor = new HmsDoctor();

        doctor.setUserid(userID);
        doctor.setFname(firstName);
        doctor.setLname(lastName);
        session.save(doctor);
        trans.commit();
    }

}
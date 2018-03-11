package eu.maciejfijalkowski.lekarzWizytaPacjent.model;

import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;


@Entity
public class MedicalVisit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "dateAndTimeOfVisit", columnDefinition="DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date dateAndTimeOfVisit;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateAndTimeOfVisit() {
        return dateAndTimeOfVisit;
    }
    public void setDateAndTimeOfVisit(Date dateAndTimeOfVisit) {
        this.dateAndTimeOfVisit = dateAndTimeOfVisit;
    }

    @OneToOne
    private Doctor doctor;
    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    @OneToOne
    private Patient patient;
    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    @Override
    public String toString() {
        return "MedicalVisit{" +
                "id=" + id +
                ", dateOfVisit='" + dateAndTimeOfVisit + '\'' +
                ", doctor=" + doctor +
                ", patient=" + patient +
                '}';
    }
}

package eu.maciejfijalkowski.lekarzWizytaPacjent.model;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
public class MedicalVisit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dateOfVisit;
    private String timeOfVisit;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDateOfVisit() {
        return dateOfVisit;
    }
    public void setDateOfVisit(String dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }
    public String getTimeOfVisit() {
        return timeOfVisit;
    }
    public void setTimeOfVisit(String timeOfVisit) {
        this.timeOfVisit = timeOfVisit;
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
                ", dateOfVisit='" + dateOfVisit + '\'' +
                ", timeOfVisit='" + timeOfVisit + '\'' +
                ", doctor=" + doctor +
                ", patient=" + patient +
                '}';
    }
}

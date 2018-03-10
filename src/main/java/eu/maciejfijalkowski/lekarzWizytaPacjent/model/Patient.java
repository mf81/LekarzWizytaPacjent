package eu.maciejfijalkowski.lekarzWizytaPacjent.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameOfPatient;
    private String surnameOfPatient;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNameOfPatient() {
        return nameOfPatient;
    }
    public void setNameOfPatient(String nameOfPatient) {
        this.nameOfPatient = nameOfPatient;
    }
    public String getSurnameOfPatient() {
        return surnameOfPatient;
    }
    public void setSurnameOfPatient(String surnameOfPatient) {
        this.surnameOfPatient = surnameOfPatient;
    }

    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER, orphanRemoval = true)
    List<MedicalVisit> medicalVisitList = new ArrayList<>();

    public String getFullPatientName (){
        return nameOfPatient +" " + surnameOfPatient;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", nameOfPatient='" + nameOfPatient + '\'' +
                ", surnameOfPatient='" + surnameOfPatient + '\'' +
                ", medicalVisitList=" + medicalVisitList +
                '}';
    }
}

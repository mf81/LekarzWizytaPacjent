package eu.maciejfijalkowski.lekarzWizytaPacjent.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nameOfDoctor;
    private String surnameOfDoctor;
    private String specializacion;

    @OneToMany (mappedBy = "doctor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MedicalVisit> medicalVisit = new ArrayList<>();


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNameOfDoctor() {
        return nameOfDoctor;
    }
    public void setNameOfDoctor(String nameOfDoctor) {
        this.nameOfDoctor = nameOfDoctor;
    }
    public String getSurnameOfDoctor() {
        return surnameOfDoctor;
    }
    public void setSurnameOfDoctor(String surnameOfDoctor) {
        this.surnameOfDoctor = surnameOfDoctor;
    }
    public String getSpecializacion() {
        return specializacion;
    }
    public void setSpecializacion(String specializacion) {
        this.specializacion = specializacion;
    }

    public String getFullDoctorName(){
        return specializacion + ": " + nameOfDoctor + " " + surnameOfDoctor;
    }

    @Override
    public String toString() {
        return specializacion + ": " +nameOfDoctor + ' ' + surnameOfDoctor;
    }
}

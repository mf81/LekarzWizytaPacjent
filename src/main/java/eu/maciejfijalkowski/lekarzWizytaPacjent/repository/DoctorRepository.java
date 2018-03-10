package eu.maciejfijalkowski.lekarzWizytaPacjent.repository;

import eu.maciejfijalkowski.lekarzWizytaPacjent.model.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor,Long> {
}

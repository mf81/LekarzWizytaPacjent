package eu.maciejfijalkowski.lekarzWizytaPacjent.repository;

import eu.maciejfijalkowski.lekarzWizytaPacjent.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient,Long> {
}

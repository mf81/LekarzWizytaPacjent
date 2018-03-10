package eu.maciejfijalkowski.lekarzWizytaPacjent.repository;

import eu.maciejfijalkowski.lekarzWizytaPacjent.model.MedicalVisit;
import org.springframework.data.repository.CrudRepository;

public interface MedicalVisitRepository extends CrudRepository<MedicalVisit,Long> {
}

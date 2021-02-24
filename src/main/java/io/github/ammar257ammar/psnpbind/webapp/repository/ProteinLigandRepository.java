package io.github.ammar257ammar.psnpbind.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.ammar257ammar.psnpbind.webapp.domain.ProteinLigand;
import io.github.ammar257ammar.psnpbind.webapp.domain.ProteinLigandId;

@Repository
public interface ProteinLigandRepository extends JpaRepository<ProteinLigand, ProteinLigandId>{
	 
	ProteinLigand findOneById(ProteinLigandId vlId);
}

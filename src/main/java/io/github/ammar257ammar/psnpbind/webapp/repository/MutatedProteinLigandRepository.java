package io.github.ammar257ammar.psnpbind.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.ammar257ammar.psnpbind.webapp.domain.MutatedProteinLigand;
import io.github.ammar257ammar.psnpbind.webapp.domain.MutatedProteinLigandId;

@Repository
public interface MutatedProteinLigandRepository extends JpaRepository<MutatedProteinLigand, MutatedProteinLigandId>{
	 
	MutatedProteinLigand findOneById(MutatedProteinLigandId vlId);

	MutatedProteinLigand findOneByVariantLigandUuid(String variantLigandUuid);

}

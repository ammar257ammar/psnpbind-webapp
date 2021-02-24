package io.github.ammar257ammar.psnpbind.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.ammar257ammar.psnpbind.webapp.domain.Protein;

@Repository
public interface ProteinRepository extends JpaRepository<Protein, String>{
	 
	Protein findOneByPdbId(String pdbid);
	Protein findOneByProteinUuid(String proteinUuid);

}

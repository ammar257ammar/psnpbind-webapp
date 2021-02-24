package io.github.ammar257ammar.psnpbind.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.ammar257ammar.psnpbind.webapp.domain.Ligand;

@Repository
public interface LigandRepository extends JpaRepository<Ligand, String>{
	 
	Ligand findOneByChemblId(String chemblid);

	Ligand findOneByLigandUuid(String ligandUuid);

}

package io.github.ammar257ammar.psnpbind.webapp.service;

import java.util.List;

import io.github.ammar257ammar.psnpbind.webapp.domain.Ligand;

public interface ILigandService {
	
	List<Ligand> findAll();

    Ligand findOneByChemblId(String chemblid);

    Ligand findOneByLigandUuid(String ligandUuid);
}

package io.github.ammar257ammar.psnpbind.webapp.service;

import java.util.List;

import io.github.ammar257ammar.psnpbind.webapp.domain.Protein;

public interface IProteinService {
	
	List<Protein> findAll();

    Protein findOneByPdbId(String pdbid);

    Protein findOneByProteinUuid(String proteinUuid);

}

package io.github.ammar257ammar.psnpbind.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.ammar257ammar.psnpbind.webapp.domain.Protein;
import io.github.ammar257ammar.psnpbind.webapp.repository.ProteinRepository;

@Service
public class ProteinService implements IProteinService {

	@Autowired
    private ProteinRepository proteinRepository;


	@Override
    public List<Protein> findAll() {
        return (List<Protein>) proteinRepository.findAll();
    }
	
	@Override
    public Protein findOneByPdbId(String pdbid) {
        return (Protein) proteinRepository.findOneByPdbId(pdbid);
    }

	@Override
	public Protein findOneByProteinUuid(String proteinUuid) {
        return (Protein) proteinRepository.findOneByProteinUuid(proteinUuid);
	}
}

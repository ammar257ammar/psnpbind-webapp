package io.github.ammar257ammar.psnpbind.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.ammar257ammar.psnpbind.webapp.domain.Ligand;
import io.github.ammar257ammar.psnpbind.webapp.repository.LigandRepository;

@Service
public class LigandService implements ILigandService {

	@Autowired
    private LigandRepository ligandRepository;


	@Override
    public List<Ligand> findAll() {
        return (List<Ligand>) ligandRepository.findAll();
    }
	
	@Override
    public Ligand findOneByChemblId(String chemblid) {
        return (Ligand) ligandRepository.findOneByChemblId(chemblid);
    }

	@Override
	public Ligand findOneByLigandUuid(String ligandUuid) {
        return (Ligand) ligandRepository.findOneByLigandUuid(ligandUuid);
	}
    

}

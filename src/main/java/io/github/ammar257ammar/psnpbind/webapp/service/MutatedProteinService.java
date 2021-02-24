package io.github.ammar257ammar.psnpbind.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.ammar257ammar.psnpbind.webapp.domain.MutatedProtein;
import io.github.ammar257ammar.psnpbind.webapp.repository.MutatedProteinRepository;

@Service
public class MutatedProteinService implements IMutatedProteinService {

	@Autowired
    private MutatedProteinRepository proteinVariantRepository;


	@Override
    public List<MutatedProtein> findAll() {
        return (List<MutatedProtein>) proteinVariantRepository.findAll();
    }
	
	@Override
    public MutatedProtein findOneByVariantId(Long variantid) {
        return (MutatedProtein) proteinVariantRepository.findOneByVariantId(variantid);
    }

	@Override
	public MutatedProtein findOneByVariantUuid(Long variantUuid) {
        return (MutatedProtein) proteinVariantRepository.findOneByVariantUuid(variantUuid);
	}
}

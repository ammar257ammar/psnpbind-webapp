package io.github.ammar257ammar.psnpbind.webapp.service;

import java.util.List;

import io.github.ammar257ammar.psnpbind.webapp.domain.MutatedProtein;

public interface IMutatedProteinService {
	
	List<MutatedProtein> findAll();

    MutatedProtein findOneByVariantId(Long variantid);

    MutatedProtein findOneByVariantUuid(Long variantUuid);

}

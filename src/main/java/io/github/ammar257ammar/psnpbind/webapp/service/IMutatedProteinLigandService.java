package io.github.ammar257ammar.psnpbind.webapp.service;

import io.github.ammar257ammar.psnpbind.webapp.domain.MutatedProteinLigand;
import io.github.ammar257ammar.psnpbind.webapp.domain.MutatedProteinLigandId;

public interface IMutatedProteinLigandService {
	
	MutatedProteinLigand findOneById(MutatedProteinLigandId vlId);

	MutatedProteinLigand findOneByVariantLigandUuid(String variantLigandUuid);

}

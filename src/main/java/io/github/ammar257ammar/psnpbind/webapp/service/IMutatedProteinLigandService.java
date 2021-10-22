package io.github.ammar257ammar.psnpbind.webapp.service;

import java.util.List;

import io.github.ammar257ammar.psnpbind.webapp.domain.Ligand;
import io.github.ammar257ammar.psnpbind.webapp.domain.MutatedProtein;
import io.github.ammar257ammar.psnpbind.webapp.domain.MutatedProteinLigand;
import io.github.ammar257ammar.psnpbind.webapp.domain.MutatedProteinLigandId;

public interface IMutatedProteinLigandService {
	
	MutatedProteinLigand findOneById(MutatedProteinLigandId vlId);

	MutatedProteinLigand findOneByVariantLigandUuid(String variantLigandUuid);
	
	List<MutatedProteinLigand> findByVariantFolderLikeAndVlLigandAndVlVariantNot(String variantFolder, Ligand chemblId, MutatedProtein variantId);

}

package io.github.ammar257ammar.psnpbind.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.ammar257ammar.psnpbind.webapp.domain.Ligand;
import io.github.ammar257ammar.psnpbind.webapp.domain.MutatedProtein;
import io.github.ammar257ammar.psnpbind.webapp.domain.MutatedProteinLigand;
import io.github.ammar257ammar.psnpbind.webapp.domain.MutatedProteinLigandId;
import io.github.ammar257ammar.psnpbind.webapp.repository.MutatedProteinLigandRepository;

@Service
public class MutatedProteinLigandService
    implements IMutatedProteinLigandService {

  @Autowired
  private MutatedProteinLigandRepository mutatedProteinLigandRepository;

  @Override
  public MutatedProteinLigand findOneById(MutatedProteinLigandId vlId) {
    return (MutatedProteinLigand) mutatedProteinLigandRepository
        .findOneById(vlId);
  }

  @Override
  public MutatedProteinLigand findOneByVariantLigandUuid(
      String variantLigandUuid) {
    return (MutatedProteinLigand) mutatedProteinLigandRepository
        .findOneByVariantLigandUuid(variantLigandUuid);
  }

  @Override
  public List<MutatedProteinLigand> findByVariantFolderLikeAndVlLigandAndVlVariantNot(
      String variantFolder, Ligand chemblId, MutatedProtein variantId) {
    return mutatedProteinLigandRepository
        .findByVariantFolderLikeAndVlLigandAndVlVariantNot(variantFolder, chemblId, variantId);
  }
}

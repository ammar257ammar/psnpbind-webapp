package io.github.ammar257ammar.psnpbind.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.ammar257ammar.psnpbind.webapp.domain.MutatedProtein;

@Repository
public interface MutatedProteinRepository extends JpaRepository<MutatedProtein, Long>{
	 
	MutatedProtein findOneByVariantId(Long variantid);
	MutatedProtein findOneByVariantUuid(Long variantUuid);

}

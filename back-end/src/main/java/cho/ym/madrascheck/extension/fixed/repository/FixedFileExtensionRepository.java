package cho.ym.madrascheck.extension.fixed.repository;

import cho.ym.madrascheck.enums.FixedFileExtension;
import cho.ym.madrascheck.extension.fixed.repository.domain.FixedFileExtensionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface FixedFileExtensionRepository extends JpaRepository<FixedFileExtensionEntity, Long> {


    @Query("select FE.isChecked from FixedFileExtensionEntity FE where FE.extension = :extension")
    boolean isChecked(@Param("extension") FixedFileExtension extension);

    @Modifying
    @Transactional
    @Query("update FixedFileExtensionEntity FE set FE.isChecked = true where FE.extension = :extension")
    void check(@Param("extension") FixedFileExtension extension);

    @Modifying
    @Transactional
    @Query("update FixedFileExtensionEntity FE set FE.isChecked = false where FE.extension = :extension")
    void cancel(@Param("extension") FixedFileExtension extension);
}

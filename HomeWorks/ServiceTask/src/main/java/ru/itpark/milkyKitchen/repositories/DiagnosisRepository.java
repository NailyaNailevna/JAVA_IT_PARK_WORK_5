package ru.itpark.milkyKitchen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.milkyKitchen.models.DiagnosisEntity;

import java.util.List;
import java.util.Optional;

/**
 * Created by nailya.shakirova on 26.06.2018.
 */
public interface DiagnosisRepository extends JpaRepository<DiagnosisEntity, Integer> {

    @Query(nativeQuery = true, value = "SELECT md.id, md.code, md.name FROM public.md_diagnosis md where ?1::integer is null or md.id = ?1")
    List<DiagnosisEntity> findById(Integer id);

    @Query(nativeQuery = true, value = "SELECT * FROM public.md_diagnosis md where md.id = ?1")
    Optional<DiagnosisEntity> findOneById(Integer id);

     @Query(nativeQuery = true, value = "SELECT * FROM public.md_diagnosis md where (trim(upper(md.code)) in ('D50.8','D50.9','E43','E44.0','E45','E46','R75') or trim(upper(md.code)) like 'B20%')")
    public List<DiagnosisEntity> findAllMilky();

}

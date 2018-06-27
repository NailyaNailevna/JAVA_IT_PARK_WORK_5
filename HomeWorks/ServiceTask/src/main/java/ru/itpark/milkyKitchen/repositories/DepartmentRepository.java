package ru.itpark.milkyKitchen.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.milkyKitchen.dto.DepartmentDto;
import ru.itpark.milkyKitchen.models.DepartmentEntity;

import java.util.List;
import java.util.Optional;

/**
 * Created by nailya.shakirova on 25.06.2018.
 */
public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Integer> {

    @Query(nativeQuery = true, value = "SELECT d.id, d.code, d.name, d.org_id, d.kind_id, d.from_dt, d.to_dt from public.pim_department d where d.kind_id = 126 and d.org_id = 490")
//    ?1
    List<DepartmentEntity> findByClinicId();

    @Query(nativeQuery = true, value = "SELECT d.id from pim_department d where d.id = ?1")
    List<DepartmentEntity> findById(Integer id);

    @Query(nativeQuery = true, value = "SELECT * from pim_department d where d.id = ?1")
    Optional<DepartmentEntity> findOneById(Integer id);
}

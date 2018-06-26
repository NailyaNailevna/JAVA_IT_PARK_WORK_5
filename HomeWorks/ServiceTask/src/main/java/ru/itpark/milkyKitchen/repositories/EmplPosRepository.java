package ru.itpark.milkyKitchen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.milkyKitchen.models.IndividualEntity;

import java.util.List;

//import org.springframework.stereotype.Repository;

/**
 * Created by nailya.shakirova on 19.06.2018.
 */

//@Repository("ReceiptRepository")
public interface EmplPosRepository extends JpaRepository<IndividualEntity,Long>{

    @Query(nativeQuery = true, value = "SELECT pep.id FROM public.pim_employee_position pep where pep.id = ?1")
    List<IndividualEntity> findById(Integer id);

}

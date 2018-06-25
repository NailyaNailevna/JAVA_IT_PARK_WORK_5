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
public interface IndividualRepository extends JpaRepository<IndividualEntity,Long>{
    IndividualEntity findById(int id);

    @Query(nativeQuery = true, value = "SELECT i.id,  i.surname, i.name, i.patr_name, i.birth_dt FROM public.pim_individual i where urrep(concat(i.surname, ' ', i.name, ' ', i.patr_name)) like '%'||?1||'%' " )
    List<IndividualEntity> findAllByFIO();

    @Query(nativeQuery = true, value = "SELECT i.id, i.surname + ' ' + i.name + ' ' + i.patr_name FROM public.pim_individual i where i.id = ?1")
    List<IndividualEntity> findIndividualById(Integer id);

}

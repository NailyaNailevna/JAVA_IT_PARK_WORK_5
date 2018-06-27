package ru.itpark.milkyKitchen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.itpark.milkyKitchen.models.IndividualEntity;

import java.util.List;
import java.util.Optional;

//import org.springframework.stereotype.Repository;

/**
 * Created by nailya.shakirova on 19.06.2018.
 */

//@Repository("ReceiptRepository")
public interface IndividualRepository extends JpaRepository<IndividualEntity,Long>{

    @Query(nativeQuery = true, value = "SELECT * FROM public.pim_individual i where i.birth_dt >= cast('01.06.2015' as date) order by birth_dt")
    List<IndividualEntity> findAll();

    @Query(nativeQuery = true, value = "SELECT i.id, i.surname || ' ' || i.name || ' ' || i.patr_name, i.birth_dt FROM public.pim_individual i where i.id = ?1")
    List<IndividualEntity> findById(Integer id);

    @Query(nativeQuery = true, value = "SELECT * FROM public.pim_individual i where i.id = ?1")
    Optional<IndividualEntity> findOneById(Integer id);

    //            " and urrep(concat(i.surname, ' ', i.name, ' ', i.patr_name)) like '%'||?1||'%' " )
//    List<IndividualEntity> findAllByFIO(String fio);

}

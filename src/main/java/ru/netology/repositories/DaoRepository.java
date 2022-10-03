package ru.netology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.netology.entities.PersonEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface DaoRepository extends JpaRepository<PersonEntity, Long> {
    @Query("select p from PersonEntity p where p.cityOfLiving like :city")
    List<PersonEntity> findPersonsByCity(@Param("city") String city);

    @Query("select p from PersonEntity p where p.age < :age order by p.age desc")
    List<PersonEntity> findPersonsByAge(@Param("age")int age);

    @Query("select p from PersonEntity p where p.name like :name and p.surname like :surname")
    Optional<PersonEntity> findPersonsByNames(@Param("name") String name, @Param("surname") String surname);
}

package ru.netology.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.entities.PersonEntity;

import java.util.List;
import java.util.Optional;

@Repository
public interface DaoRepository extends JpaRepository<PersonEntity, Long> {
    List<PersonEntity> findByCityOfLiving(String city);

    List<PersonEntity> findByAgeLessThanOrderByAge(int age);

    Optional<PersonEntity> findByNameAndSurname(String name, String surname);
}

package ru.netology;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.entities.PersonEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DaoHibernateApplication implements CommandLineRunner {
    @PersistenceContext
    EntityManager em;
    public static void main(String[] args) {
        SpringApplication.run(DaoHibernateApplication.class, args);
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        List<PersonEntity> personEntityList = Arrays.asList(
                new PersonEntity().builder()
                        .name("John")
                        .surname("Wain")
                        .age(35)
                        .phoneNumber("+7-999-555-33-22")
                        .cityOfLiving("New-York")
                        .build(),
                new PersonEntity().builder()
                        .name("Mike")
                        .surname("Jordan")
                        .age(41)
                        .phoneNumber("+7-999-555-32-21")
                        .cityOfLiving("Moscow")
                        .build(),
                new PersonEntity().builder()
                        .name("Julie")
                        .surname("Rogers")
                        .age(25)
                        .phoneNumber("+7-999-555-42-54")
                        .cityOfLiving("Novosibirsk")
                        .build(),
                new PersonEntity().builder()
                        .name("Mark")
                        .surname("Antony")
                        .age(29)
                        .phoneNumber("+7-999-555-58-98")
                        .cityOfLiving("Moscow")
                        .build(),
                new PersonEntity().builder()
                        .name("John")
                        .surname("Smith")
                        .age(22)
                        .phoneNumber("+7-999-555-33-22")
                        .cityOfLiving("Tambov")
                        .build()
                );
        personEntityList.forEach(personEntity -> {
            em.persist(personEntity);
        });
    }
}

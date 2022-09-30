package ru.netology.repositories;

import org.springframework.stereotype.Repository;
import ru.netology.entities.PersonEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DaoRepository {
    @PersistenceContext
    EntityManager em;

    public List<PersonEntity> getPersonsByCity(String city) {
        Query query = em.createNativeQuery("select * from persons where city_of_living like :city")
                .setParameter("city", city);
        return query.getResultList();
    }
}

package ru.netology.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.entities.PersonEntity;
import ru.netology.repositories.DaoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persons")
public class DaoController {
    private final DaoRepository daoRepository;

    public DaoController(DaoRepository daoRepository) {
        this.daoRepository = daoRepository;
    }

    //localhost:8080/persons/by-city?city=moscow
    @GetMapping("/by-city")
    public ResponseEntity<List<PersonEntity>> getPersonsByCity(@RequestParam String city) {
        List<PersonEntity> personsByCity = daoRepository.findByCityOfLiving(city);
        return ResponseEntity.ok().body(personsByCity);
    }
    //localhost:8080/persons/by-age-under?age=30
    @GetMapping("/by-age-under")
    public ResponseEntity<List<PersonEntity>> getPersonsByAge(@RequestParam int age) {
        List<PersonEntity> personsByAgeUnder = daoRepository.findByAgeLessThanOrderByAge(age);
        return ResponseEntity.ok().body(personsByAgeUnder);
    }
    //localhost:8080/persons/by-name-surname?name=john&surname=smith
    @GetMapping("/by-name-surname")
    public ResponseEntity<Optional<PersonEntity>> getPersonsByNameAndSurname(@RequestParam String name, String surname) {
        Optional<PersonEntity> personsByNameAndSurname = daoRepository.findByNameAndSurname(name, surname);
        return ResponseEntity.ok().body(personsByNameAndSurname);
    }
}
package ru.netology.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.entities.PersonEntity;
import ru.netology.repositories.DaoRepository;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class DaoController {
    private final DaoRepository daoRepository;

    public DaoController(DaoRepository daoRepository) {
        this.daoRepository = daoRepository;
    }

    @GetMapping("/by-city")

    public ResponseEntity<List<PersonEntity>> getProduct(@RequestParam String city) {
        List<PersonEntity> names = daoRepository.getPersonsByCity(city);
        return ResponseEntity.ok().body(names);
    }
}
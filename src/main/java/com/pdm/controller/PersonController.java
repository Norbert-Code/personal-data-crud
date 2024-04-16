package com.pdm.controller;

import com.pdm.model.*;
import com.pdm.service.*;
import jakarta.validation.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.*;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

  @Autowired
  private PersonService personService;

  @GetMapping("/")
  public List<Person> listAll() {
    return personService.listAll();
  }

  @PostMapping("/")
  public ResponseEntity<Person> addPerson(@RequestBody @Valid Person person) {
    personService.save(person);
    return ResponseEntity.ok(person);
  }

  @PutMapping("/")
  ResponseEntity<Person> updatePerson(@Valid @RequestBody Person person) {
    personService.save(person);
    return ResponseEntity.ok(person);
  }

  @GetMapping("/{id}")
  public Person getPerson(@PathVariable Long id) {
    Person person = personService.get(id);
    if (person == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found");
    }
    return person;
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteGroup(@PathVariable Long id) {
    Person person = personService.get(id);
    if (person == null) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person not found");
    }
    personService.deleteById(id);
    return ResponseEntity.ok().build();
  }
}

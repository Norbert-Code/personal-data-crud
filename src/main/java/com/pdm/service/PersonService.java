package com.pdm.service;

import com.pdm.model.*;
import com.pdm.repository.*;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

@Service
public class PersonService {
  @Autowired
  private PersonRepository personRepository;

  public List<Person> listAll() {
    return personRepository.findAll();
  }

  public void save(Person person) {
    personRepository.save(person);
  }

  public Person get(Long id) {
    return personRepository.findById(id).orElse(null);
  }

  public Optional<Person> findById(Long personId) {
    return personRepository.findById(personId);
  }

  public void deleteById(Long id) {
    personRepository.deleteById(id);
  }
}

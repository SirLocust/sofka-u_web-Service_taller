package com.sirlocust.web_service.web_service.service;

import java.util.List;
import java.util.Optional;

import com.sirlocust.web_service.web_service.entity.Person;
import com.sirlocust.web_service.web_service.repository.RepositoryPerson;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ImpPersonService implements IPersonService {

  private RepositoryPerson repositoryPerson;

  @Override
  public List<Person> getPersonAll() {
    List<Person> personAllDb = (List<Person>) repositoryPerson.findAll();
    return personAllDb;
  }

  @Override
  public Person personById(Long id) {
    Optional<Person> personDb = repositoryPerson.findById(id);
    return personDb.orElse(null);
  }

  @Override
  public Person save(Person person) {
    Person personDb = repositoryPerson.save(person);
    return personDb;
  }

  @Override
  public Person delete(Long id) {
    Person personDb = this.personById(id);
    if (personDb == null) {
      return null;
    }
    return personDb;
  }

}

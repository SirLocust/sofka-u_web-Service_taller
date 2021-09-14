package com.sirlocust.web_service.web_service.service;

import java.util.List;
import java.util.Optional;

import com.sirlocust.web_service.web_service.entity.Person;

public interface IPersonService {

  public List<Person> getPersonAll();

  public Person personById(Long id);

  public Person save(Person person);

  public Person delete(Long id);

}

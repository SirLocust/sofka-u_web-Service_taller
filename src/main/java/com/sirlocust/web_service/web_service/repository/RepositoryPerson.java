package com.sirlocust.web_service.web_service.repository;

import com.sirlocust.web_service.web_service.entity.Person;

import org.springframework.data.repository.CrudRepository;

public interface RepositoryPerson extends CrudRepository<Person, Long> {

}

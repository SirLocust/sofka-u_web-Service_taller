package com.sirlocust.web_service.web_service.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sirlocust.web_service.web_service.entity.Person;
import com.sirlocust.web_service.web_service.service.IPersonService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class PersonController {
  private IPersonService personService;

  @GetMapping(value = "persons")
  public ResponseEntity<Map<String, Object>> listPersons() {
    List<Person> personsDb = this.personService.getPersonAll();
    Map<String, Object> body = new HashMap<>();
    body.put("data", personsDb);
    body.put("message", "Lista generada con exito");
    body.put("errors", null);
    return ResponseEntity.ok(body);
  }

  @GetMapping(value = "persons/{id}")
  public ResponseEntity<Map<String, Object>> ListPersonsById(@PathVariable() Long id) {
    Person personDb = this.personService.personById(id);
    Map<String, Object> body = new HashMap<>();
    body.put("data", personDb);
    if (personDb == null) {
      body.put("message", "Persona no encontrada");
      body.put("errors", "persona  no existe");
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }
    body.put("message", "Persona encontrada");
    body.put("errors", null);
    return ResponseEntity.status(HttpStatus.OK).body(body);

  }

  @PostMapping(value = "persons")
  public ResponseEntity<Map<String, Object>> createPerson(@RequestBody Person person) {
    Person personsDb = this.personService.save(person);
    Map<String, Object> body = new HashMap<>();
    body.put("data", personsDb.getId());
    body.put("message", "Persona creada con exito");
    body.put("errors", null);
    return ResponseEntity.status(HttpStatus.CREATED).body(body);
    ;
  }

  @DeleteMapping(value = "removePerson/{id}")
  public ResponseEntity<HttpStatus> removePerson(@PathVariable() int id) {
    if (servicePerson.delete(id)) {
      return new ResponseEntity<>(HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}

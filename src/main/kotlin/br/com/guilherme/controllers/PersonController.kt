package br.com.guilherme.controllers

import br.com.guilherme.model.Person
import br.com.guilherme.services.PersonService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/persons")
class PersonController {


    @Autowired
    private lateinit var personService: PersonService

    @GetMapping
    fun findAll() = personService.findAll()

    @GetMapping(value = ["/{id}"])
    fun findById(@PathVariable(value = "id") id: Long) = personService.findById(id)

    @PostMapping
    fun create(@RequestBody person: Person) = personService.create(person)

    @PutMapping(value = ["/{id}"])
    fun update(@RequestBody person: Person, @PathVariable(value = "id") id: Long) = personService.update(id ,person)

    @DeleteMapping(value = ["/{id}"])
    fun delete(@PathVariable(value = "id") id: Long): ResponseEntity<*> {
        personService.delete(id)
        return ResponseEntity.noContent().build<Any>()
    }
}
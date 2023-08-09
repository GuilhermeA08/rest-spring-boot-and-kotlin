package br.com.guilherme.services

import br.com.guilherme.exceptions.ResourceNotFoundException
import br.com.guilherme.model.Person
import br.com.guilherme.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var personRepository: PersonRepository

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): Person {
        logger.info("findById")

        return personRepository.findById(id)
            .orElseThrow { ResourceNotFoundException("Person not found") }
    }

    fun findAll(): List<Person> {
        logger.info("findById")

        return personRepository.findAll()
    }

    fun update(id: Long, person: Person): Person {
        logger.info("update")

        val entity = personRepository.findById(id)
            .orElseThrow { ResourceNotFoundException("Person not found") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        return  personRepository.save(entity)
    }


    fun delete(id: Long) {
        logger.info("delete")
        val person = personRepository.findById(id)
            .orElseThrow { ResourceNotFoundException("Person not found") }
        personRepository.delete(person)
    }

    fun create(person: Person): Person {
        logger.info("create")

        return personRepository.save(person)
    }
}
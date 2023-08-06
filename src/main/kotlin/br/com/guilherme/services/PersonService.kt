package br.com.guilherme.services

import br.com.guilherme.model.Person
import org.springframework.stereotype.Service
import java.util.concurrent.atomic.AtomicLong
import java.util.logging.Logger

@Service
class PersonService {

    private val counter = AtomicLong()

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): Person {
        logger.info("findById")

        return Person(
            id = counter.incrementAndGet(),
            firstName = "Guilherme",
            lastName = "Santos",
            address = "Rua do Test",
            gender = "Male"
        )
    }

    fun findAll(): List<Person> {
        logger.info("findById")

        val persons = mutableListOf<Person>()

        for (i in 0..7) {
            persons.add(
                Person(
                    id = counter.incrementAndGet(),
                    firstName = "Guilherme",
                    lastName = "Santos",
                    address = "Rua do Test",
                    gender = "Male"
                )
            )
        }

        return persons
    }

    fun update(person: Person): Person {
        logger.info("update")

        return person
    }

    fun delete(id: Long) {
        logger.info("delete")
    }

    fun create(person: Person): Person {
        logger.info("create")

        return person
    }
}
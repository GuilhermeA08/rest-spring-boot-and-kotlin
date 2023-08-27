package br.com.guilherme.services

import br.com.guilherme.data.vo.v1.PersonVO
import br.com.guilherme.data.vo.v2.PersonVO as PersonVOV2
import br.com.guilherme.exceptions.ResourceNotFoundException
import br.com.guilherme.mapper.DozerMapper
import br.com.guilherme.mapper.custom.PersonMapper
import br.com.guilherme.model.Person
import br.com.guilherme.repository.PersonRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class PersonService {

    @Autowired
    private lateinit var personRepository: PersonRepository

    @Autowired
    private  lateinit var personMapper: PersonMapper

    private val logger = Logger.getLogger(PersonService::class.java.name)

    fun findById(id: Long): PersonVO {
        logger.info("findById")

        return DozerMapper.parseObject( personRepository.findById(id)
            .orElseThrow { ResourceNotFoundException("Person not found") }
            , PersonVO::class.java)

    }

    fun findAll(): List<PersonVO> {
        logger.info("findById")

        return DozerMapper.parseListObjects( personRepository.findAll(), PersonVO::class.java)
    }

    fun update(id: Long, person: PersonVO): PersonVO {
        logger.info("update")

        val entity = personRepository.findById(id)
            .orElseThrow { ResourceNotFoundException("Person not found") }

        entity.firstName = person.firstName
        entity.lastName = person.lastName
        entity.address = person.address
        entity.gender = person.gender

        return DozerMapper.parseObject( personRepository.save(entity), PersonVO::class.java)
    }


    fun delete(id: Long) {
        logger.info("delete")
        val person = personRepository.findById(id)
            .orElseThrow { ResourceNotFoundException("Person not found") }
        personRepository.delete(person)
    }

    fun create(person: PersonVO): PersonVO {
        logger.info("create")

        val entity = DozerMapper.parseObject(person, Person::class.java)

        return DozerMapper.parseObject(personRepository.save(entity), PersonVO::class.java)
    }

    fun createV2(person: PersonVOV2): PersonVOV2 {
        logger.info("create")

        val entity = personMapper.mapVoToEntity(person)

        return personMapper.mapEntityToVO(personRepository.save(entity))
    }



}
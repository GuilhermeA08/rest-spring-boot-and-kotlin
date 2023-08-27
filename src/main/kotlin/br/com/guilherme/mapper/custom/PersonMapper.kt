package br.com.guilherme.mapper.custom

import br.com.guilherme.data.vo.v2.PersonVO
import br.com.guilherme.model.Person
import org.springframework.stereotype.Service
import java.util.*

@Service
class PersonMapper {

    fun mapEntityToVO(person: Person): PersonVO {
        val vo = PersonVO()
        vo.id = person.id
        vo.firstName = person.firstName
        vo.lastName = person.lastName
        vo.birthDay = Date()
        vo.address = person.address
        vo.gender = person.gender

        return  vo
    }

    fun mapVoToEntity(person: PersonVO): Person {
        val entity = Person()
        entity.id = person.id
        entity.firstName = person.firstName
        entity.lastName = person.lastName
        //ntity.birthDay = Date()
        entity.address = person.address
        entity.gender = person.gender

        return  entity
    }
}
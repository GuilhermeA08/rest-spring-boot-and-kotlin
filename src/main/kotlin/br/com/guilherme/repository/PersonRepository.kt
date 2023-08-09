package br.com.guilherme.repository

import br.com.guilherme.model.Person
import org.springframework.data.jpa.repository.JpaRepository

interface PersonRepository: JpaRepository<Person, Long?> {
}
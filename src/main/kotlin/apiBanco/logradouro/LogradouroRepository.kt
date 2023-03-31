package apiBanco.logradouro

import apiBanco.logradouro.Logradouro
import org.springframework.data.jpa.repository.JpaRepository

interface LogradouroRepository : JpaRepository<Logradouro, Long> {
}
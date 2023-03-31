package apiBanco.agencia

import org.springframework.data.jpa.repository.JpaRepository

interface AgenciaRepository : JpaRepository<Agencia, Long> {


}
package apiBanco.conta

import apiBanco.conta.Conta
import org.springframework.data.jpa.repository.JpaRepository

interface ContaRepository : JpaRepository<Conta, Long> {
}

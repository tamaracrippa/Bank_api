package apiBanco.banco

import apiBanco.banco.Banco
import org.springframework.data.jpa.repository.JpaRepository

interface BancoRepository : JpaRepository<Banco, Long> {
}
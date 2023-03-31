package apiBanco.endereco

import apiBanco.endereco.Endereco
import org.springframework.data.jpa.repository.JpaRepository

interface EnderecoRepository : JpaRepository<Endereco, Long> {
}
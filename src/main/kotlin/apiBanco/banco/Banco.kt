package apiBanco.banco

import javax.persistence.*

@Table
@Entity
data class Banco (
    @Id
    @GeneratedValue
    @Column(name = "id_banco")
    var codigoBanco: Long,

    var nome: String,
    var cnpj: Long
)
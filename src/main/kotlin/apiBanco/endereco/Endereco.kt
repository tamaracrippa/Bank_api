package apiBanco.endereco

import apiBanco.logradouro.Logradouro
import javax.persistence.*

@Entity
@Table
data class Endereco (
    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    var logradouro: Logradouro,

    var cidade: String = "",
    var estado: String = "",
    var cep: Long? = null,

    @Id
    @GeneratedValue
    @Column(name = "id_endereco")
    var idEndereco: Long
)
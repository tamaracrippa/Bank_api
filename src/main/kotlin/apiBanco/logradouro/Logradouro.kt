package apiBanco.logradouro

import javax.persistence.*

@Entity
@Table
data class Logradouro (
    var rua: String = "",
    var numero: Int? = null,
    var bairro: String = "",
    var complemento: String = "",

    @Id
    @GeneratedValue
    @Column(name = "id_logradouro")
    open var id: Long
)
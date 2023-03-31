package apiBanco.agencia

import apiBanco.banco.Banco
import apiBanco.endereco.Endereco
import javax.persistence.*

@Table
@Entity
data class Agencia (
    @Column(name = "id_agencia")
    @Id
    @GeneratedValue
    var codigoAgencia: Long,

    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    var endereco: Endereco,

    @ManyToOne(cascade = arrayOf(CascadeType.ALL))
    var banco: Banco,
)
package apiBanco.cliente

import apiBanco.agencia.Agencia
import apiBanco.banco.Banco
import apiBanco.endereco.Endereco
import apiBanco.conta.Conta
import javax.persistence.*

@Table
@Entity
data class Cliente(
    @Id
    @GeneratedValue
    @Column(name = "id_cliente")
    var codigoCliente: Long,

    var nome: String,

    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    var endereco: Endereco,

    var profissao: String,
    var sexo: String,
    var telefone: Long,
    var email: String,
    var cpf: Long,

    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    var agencia: Agencia
)
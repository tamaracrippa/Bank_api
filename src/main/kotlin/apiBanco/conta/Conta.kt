package apiBanco.conta

import apiBanco.agencia.Agencia
import apiBanco.cliente.Cliente
import javax.persistence.*

@Table
@Entity
data class Conta(
    @Id
    @GeneratedValue
    @Column(name = "id_conta")
    var codigoConta: Long,

    var nmConta: Int? = null,
    var digito: Int? = null,
    var tipo: String? = null,
    var saldo: Float = 0F,

    @OneToOne(cascade = arrayOf(CascadeType.ALL))
    var cliente: Cliente
    )



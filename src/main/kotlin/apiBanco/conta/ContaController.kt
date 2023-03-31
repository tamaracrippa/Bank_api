package apiBanco.conta

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/apiBanco/conta")

class ContaController (private val repository: ContaRepository) {

   @PostMapping
    fun create(@RequestBody Conta: Conta): Conta = repository.save(Conta)

    @GetMapping
    fun getAll(): List<Conta> = repository.findAll()

    @GetMapping("/{id}")
    fun getbyId(@PathVariable id: Long) : ResponseEntity<Conta> =
        repository.findById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody conta: Conta) : ResponseEntity<Conta> =
        repository.findById(id).map {
            val accountToUpdate = it.copy(
                codigoConta = conta.codigoConta,
                nmConta = conta.nmConta,
                digito = conta.digito,
                tipo = conta.tipo,
                saldo = conta.saldo,
                cliente = conta.cliente
            )
            ResponseEntity.ok(repository.save(accountToUpdate))
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Void> =
        repository.findById(id).map {
            repository.delete(it)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
}
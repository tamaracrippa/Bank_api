package apiBanco.cliente

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/apiBanco/cliente")
class ClienteController (private val repository: ClienteRepository) {

    @PostMapping
    fun create(@RequestBody cliente: Cliente): Cliente = repository.save(cliente)

    @GetMapping
    fun getAll(): List<Cliente> = repository.findAll()

    @GetMapping("/{id}")
    fun getbyId(@PathVariable id: Long) : ResponseEntity<Cliente> =
        repository.findById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody cliente: Cliente) : ResponseEntity<Cliente> =
        repository.findById(id).map {
            val clienteToUpdate = it.copy(
                nome = cliente.nome,
                endereco = cliente.endereco,
                profissao = cliente.profissao,
                sexo = cliente.sexo,
                telefone = cliente.telefone,
                email = cliente.email,
                cpf = cliente.cpf,
                agencia = cliente.agencia,
                )
            ResponseEntity.ok(repository.save(clienteToUpdate))
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Void> =
        repository.findById(id).map {
            repository.delete(it)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
}
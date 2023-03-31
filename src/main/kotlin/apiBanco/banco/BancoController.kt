package apiBanco.banco

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/apiBanco/banco")
class BancoController (private val repository: BancoRepository) {

    @PostMapping
    fun create(@RequestBody banco: Banco): Banco = repository.save(banco)

    @GetMapping
    fun getAll(): List<Banco> = repository.findAll()

    @GetMapping("/{id}")
    fun getbyId(@PathVariable id: Long) : ResponseEntity<Banco> =
        repository.findById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody banco: Banco) : ResponseEntity<Banco> =
        repository.findById(id).map {
            val bancoToUpdate = it.copy(
                codigoBanco  = banco.codigoBanco,
                nome = banco.nome,
                cnpj = banco.cnpj
                )
            ResponseEntity.ok(repository.save(bancoToUpdate))
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Void> =
        repository.findById(id).map {
            repository.delete(it)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
}
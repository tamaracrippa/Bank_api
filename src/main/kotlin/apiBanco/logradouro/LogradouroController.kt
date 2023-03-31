package apiBanco.logradouro

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/apiBanco/logradouro")
class LogradouroController (private val repository: LogradouroRepository) {

    @PostMapping
    fun create(@RequestBody logradouro: Logradouro): Logradouro = repository.save(logradouro)

    @GetMapping
    fun getAll(): List<Logradouro> = repository.findAll()

    @GetMapping("/{id}")
    fun getbyId(@PathVariable id: Long) : ResponseEntity<Logradouro> =
        repository.findById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody logradouro: Logradouro) : ResponseEntity<Logradouro> =
        repository.findById(id).map {
            val LogradouroToUpdate = it.copy(
                rua  = logradouro.rua,
                numero = logradouro.numero,
                bairro = logradouro.bairro,
                complemento = logradouro.complemento,
                )
            ResponseEntity.ok(repository.save(LogradouroToUpdate))
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Void> =
        repository.findById(id).map {
            repository.delete(it)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
}
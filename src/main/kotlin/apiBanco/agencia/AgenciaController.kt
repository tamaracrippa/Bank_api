package apiBanco.agencia

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/apiBanco/agencia")
class AgenciaController (private val repository: AgenciaRepository) {

    @PostMapping
    fun create(@RequestBody agencia: Agencia): Agencia = repository.save(agencia)

    @GetMapping
    fun getAll(): List<Agencia> = repository.findAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Agencia> =
        repository.findById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody agencia: Agencia): ResponseEntity<Agencia>  =
        repository.findById(id).map {
            val agenciaToUpdate = it.copy(
                codigoAgencia = agencia.codigoAgencia,
                endereco = agencia.endereco,
                banco = agencia.banco
            )
            ResponseEntity.ok(repository.save(agenciaToUpdate))
        }.orElse(ResponseEntity.notFound().build())


        @DeleteMapping("/{id}")
        fun delete(@PathVariable id: Long): ResponseEntity<Void> =
            repository.findById(id).map {
                repository.delete(it)
                ResponseEntity<Void>(HttpStatus.OK)
            }.orElse(ResponseEntity.notFound().build())
    }



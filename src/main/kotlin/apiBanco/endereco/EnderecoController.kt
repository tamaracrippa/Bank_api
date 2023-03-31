package apiBanco.endereco

import apiBanco.agencia.Agencia
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/apiBanco/endereco")
class EnderecoController (private val repository: EnderecoRepository) {

    @PostMapping
    fun create(@RequestBody endereco: Endereco): Endereco = repository.save(endereco)

    @GetMapping
    fun getAll(): List<Endereco> = repository.findAll()

    @GetMapping("/{id}")
    fun getbyId(@PathVariable id: Long) : Endereco {
       return repository.findById(id).get()
    }
    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody endereco: Endereco) : ResponseEntity<Endereco> =
     repository.findById(id).map {
            val EnderecoToUpdate = it.copy(
                logradouro  = endereco.logradouro,
                cidade = endereco.cidade,
                estado = endereco.estado,
                cep = endereco.cep,
                )
            ResponseEntity.ok(repository.save(EnderecoToUpdate))
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) : ResponseEntity<Void> =
        repository.findById(id).map {
            repository.delete(it)
            ResponseEntity<Void>(HttpStatus.OK)
        }.orElse(ResponseEntity.notFound().build())
}





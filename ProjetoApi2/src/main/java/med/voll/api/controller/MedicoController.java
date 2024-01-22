package med.voll.api.controller;

import jakarta.validation.Valid;// para dizer ao validador que esse paramentro e um DTO e que tem validaçoes a serrem feitas
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;// para ????
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;// essa e para entregar os itens em paginas na listagem
import org.springframework.data.web.PageableDefault;// para configurar como vai ser a paginação
import org.springframework.http.ResponseEntity;// esse para modificar a resposta do html "entidade"
import org.springframework.transaction.annotation.Transactional;//para marcar os metodos que fazer mudanças no SQL
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @Transactional
    @PostMapping
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroMedicos dados, UriComponentsBuilder uriBuilder){
        var medico = new Medico(dados);
        repository.save(medico);
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        return ResponseEntity.created(uri).body(new DadosDetalhamentoMedico(medico));
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    private ResponseEntity atualizar (@RequestBody @Valid DadosAtualizacaoMedicos dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }

    @DeleteMapping("/{id}")//para indicar a nova pagina chamada id, e tem que ter a marcação par indicar qie e o id de cima
    @Transactional
    public ResponseEntity excluir (@PathVariable Long id){
        //repository.deleteById(id); para fazer uma exução total
        var medico = repository.getReferenceById(id);
        medico.excluir();
        return ResponseEntity.noContent().build();//aqui e para devolver o codigo 204 e n o 200 o build e para contruir o noContetnt ???
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoMedico(medico));
    }
}

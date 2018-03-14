package br.com.luciano.moneyapi.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.luciano.moneyapi.model.Pessoa;
import br.com.luciano.moneyapi.repository.Pessoas;
import br.com.luciano.moneyapi.service.PessoaService;
/**
 * 
 * @author Luciano Lima
 *
 */
@RestController
@RequestMapping("/pessoas")
public class PessoaResource {

	@Autowired
	private Pessoas pessoas;
	
	@Autowired
	private PessoaService pessoaService;

	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PESSOA') and #oauth2.hasScope('read')")
	public List<Pessoa> pesquisar() {
		return this.pessoas.findAll();
	}

	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') and #oauth2.hasScope('write')")
	public ResponseEntity<Pessoa> inserir(@Valid @RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = this.pessoas.save(pessoa);

		return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequestUri()
				.path("/{id}").buildAndExpand(pessoaSalva.getId()).toUri()).body(pessoaSalva);
	}

	@GetMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_PESSOA') and #oauth2.hasScope('read')")
	public ResponseEntity<Pessoa> buscarPorId(@PathVariable Integer id) {
		Pessoa pessoa = this.pessoas.findOne(id);

		return pessoa != null ? ResponseEntity.ok(pessoa) : ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') and #oauth2.hasScope('write')")
	public ResponseEntity<Pessoa> editar(@PathVariable Integer id, @Valid @RequestBody Pessoa pessoa) {
		Pessoa pessoaSalva = this.pessoaService.editar(id, pessoa);
		
		return ResponseEntity.ok(pessoaSalva);
	}
	
	/**
	 * Atualização parcial da propriedade ativo
	 * @param id
	 * @param ativo
	 */
	@PutMapping("/{id}/ativo")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') and #oauth2.hasScope('write')")
	public void editarPropriedade(@PathVariable Integer id, @RequestBody Boolean ativo) {
		
		this.pessoaService.editarPropriedadeAtivo(id, ativo);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_PESSOA') and #oauth2.hasScope('write')")
	public void excluir(@PathVariable Integer id) {
		this.pessoas.delete(id);
	}
}
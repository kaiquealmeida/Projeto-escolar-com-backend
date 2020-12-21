package com.erick.escolar.resource;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.erick.escolar.domain.Turma;
import com.erick.escolar.dto.TurmaDTO;
import com.erick.escolar.services.TurmaService;

@RestController
@RequestMapping(value="/turma")
public class TurmaResource {
	
	@Autowired
	private TurmaService turma;
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(turma.listar());
	}
	
	@CrossOrigin
	@GetMapping(value="/{id}")
	public ResponseEntity<?> buscar(@PathVariable Integer id){
		TurmaDTO tdto = new TurmaDTO(turma.buscar(id));
		return ResponseEntity.ok(tdto);
	}
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity<Turma> inserir(@RequestBody TurmaDTO objDTO){
		Turma t1 = turma.fromDTO(objDTO);
		t1 = turma.inserir(t1);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(t1.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin
	@PutMapping(value="/{id}")
	public ResponseEntity<Void> alterar(@RequestBody Turma obj, @PathVariable Integer id){
		turma.alterar(obj);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@DeleteMapping(value="/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id){
		turma.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	
}

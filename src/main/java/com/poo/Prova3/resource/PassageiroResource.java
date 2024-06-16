package com.poo.Prova3.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poo.Prova3.model.Passageiro;
import com.poo.Prova3.service.PassageiroService;

@RestController
@RequestMapping ("/passageiro")
public class PassageiroResource {
	
	@Autowired
	PassageiroService service;
	
	@GetMapping
	public List<Passageiro> listaTodos(){
		return service.listaTodosPassageiros();
	}
	
	@GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorCodigo(@PathVariable Integer id) {
        try {
            Passageiro passageiro = service.buscaPorCodigo(id);
            if (passageiro == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Passageiro com ID " + id + " não encontrado.");
            }
            return ResponseEntity.ok(passageiro);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao buscar o passageiro.");
        }
    }
	
	@PostMapping
    public ResponseEntity<?> cadastra(@RequestBody Passageiro p) {
        try {
            if (p.getNome() == null || p.getRg() == null || p.getCpf() == null) {
                return ResponseEntity.badRequest().body("Todos os campos são obrigatórios para o cadastro do passageiro.");
            }
            service.inserePassageiro(p);
            return ResponseEntity.status(HttpStatus.CREATED).body("Passageiro Cadastrado com Sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao cadastrar o passageiro.");
        }
    }
	
	@DeleteMapping("/deletar/{id}")
    public ResponseEntity<?> deletarPassageiro(@PathVariable Integer id) {
        try {
            service.excluiPassageiro(id);
            return ResponseEntity.ok("Passageiro deletado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar passageiro: " + e.getMessage());
        }
    }
	
}
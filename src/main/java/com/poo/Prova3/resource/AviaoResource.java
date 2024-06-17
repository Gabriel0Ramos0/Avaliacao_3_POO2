package com.poo.Prova3.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poo.Prova3.model.Aviao;
import com.poo.Prova3.service.AviaoService;

@RestController
@RequestMapping ("/aviao")
public class AviaoResource {
	
	@Autowired
	AviaoService service;
	
	@GetMapping
	public List<Aviao> listarTodos(){
		return service.listarTodosAvioes();
	}
	
	@GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscarPorCodigo(@PathVariable Integer id) {
        try {
            Aviao aviao = service.buscaPorCodigo(id);
            if (aviao == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Avião com ID " + id + " não encontrado.");
            }
            return ResponseEntity.ok(aviao);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao buscar o avião.");
        }
    }
	
	@GetMapping("/modelo/{modelo}")
	public ResponseEntity<?> buscarPorModelo(@PathVariable String modelo) {
	    try {
	        Aviao aviao = service.buscaPorModelo(modelo);
	        if (aviao == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Avião com modelo " + modelo + " não encontrado.");
            }
	        return ResponseEntity.ok(aviao);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao buscar o avião pelo modelo.");
	    }
	}
	
	@PostMapping
	public ResponseEntity<?> cadastra(@RequestBody Aviao a) {
	    try {
	        if (a.getModelo() == null || a.getAnoFabricacao() == null || a.getCategoria() == null ||
	            a.getTipoVooAutorizado() == null || a.getSituacaoDificuldade() == null) {
	            return ResponseEntity.badRequest().body("Todos os campos são obrigatórios para o cadastro do avião.");
	        }
	        service.insereAviao(a);
	        return ResponseEntity.status(HttpStatus.CREATED).body("Avião Cadastrado com Sucesso");
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocorreu um erro ao cadastrar o avião.");
	    }
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<?> atualizarAviao(@RequestBody Aviao aviao) {
		try {
			if (aviao.getModelo() == null || aviao.getAnoFabricacao() == null || aviao.getCategoria() == null ||
					aviao.getTipoVooAutorizado() == null || aviao.getSituacaoDificuldade() == null) {
		            return ResponseEntity.badRequest().body("Todos os campos são obrigatórios para atualizar o avião.");
		        }
			service.alteraAviao(aviao);
			return ResponseEntity.ok("Avião Atualizado!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao atualizar aviao");
		}
	}
	
	@DeleteMapping("/deletar/{id}")
	public ResponseEntity<?> deletarAviao(@PathVariable Integer id) {
		try {
			service.excluiAviao(id);
			return ResponseEntity.ok("Deletado com sucesso");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao deletar aviao");
		}
	}
	
	
}
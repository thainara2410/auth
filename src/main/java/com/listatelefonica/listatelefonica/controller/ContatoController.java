package com.listatelefonica.listatelefonica.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.listatelefonica.listatelefonica.model.ContatoModel;
import com.listatelefonica.listatelefonica.repository.ContatoRepository;

@RestController
@RequestMapping("/api/listatelefonica/contatos")
public class ContatoController {

    @Autowired
    private ContatoRepository action;

    @CrossOrigin(origins = "*")
    @PostMapping("/salvar")
    public ContatoModel create(@RequestBody ContatoModel c){
        return action.save(c);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/exibir")
    public Iterable<ContatoModel> contatos(){
        return action.findAll();
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ContatoModel> update(@RequestBody ContatoModel novoContato, @PathVariable Long id) {
        Optional<ContatoModel> contatoOptional = action.findById(id);
        if (contatoOptional.isPresent()) {
            ContatoModel contatoExistente = contatoOptional.get();
            
            // Atualize os campos do contato existente com os dados do novoContato
            contatoExistente.setNome(novoContato.getNome());
            contatoExistente.setTelefone(novoContato.getTelefone());
            // Adicione aqui os outros campos que deseja atualizar
            
            ContatoModel contatoAtualizado = action.save(contatoExistente);
            return ResponseEntity.ok(contatoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/selecionar/{id}")
    public ResponseEntity<ContatoModel> contatoPorId(@PathVariable Long id) {
        Optional<ContatoModel> contatoOptional = action.findById(id);
        if (contatoOptional.isPresent()) {
            ContatoModel contato = contatoOptional.get();
            return ResponseEntity.ok(contato);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        Optional<ContatoModel> contatoOptional = action.findById(id);
        if (contatoOptional.isPresent()) {
            ContatoModel contato = contatoOptional.get();
            action.delete(contato);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    
}


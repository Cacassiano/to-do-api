package dev.cassiano.to_do_api.tarefas.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.cassiano.to_do_api.tarefas.dtos.TarefasDTO;
import dev.cassiano.to_do_api.tarefas.service.TarefasService;

@RestController
@RequestMapping("/tarefas") 
public class TarefasController {

    @Autowired
    private TarefasService service;

    @PostMapping("/{dono_id}/create")
    public ResponseEntity<String> createATask(@RequestBody TarefasDTO req, @PathVariable String dono_id) {
        if (req != null) {
            return service.createTarefa(dono_id, req);
        } 
        return ResponseEntity.unprocessableEntity().body("Requisicao inválida");
    }

    @DeleteMapping("/{dono_id}/delete")
    public ResponseEntity<String> deleteTask(@PathVariable String dono_id, @RequestBody TarefasDTO req) {
        if(req.title() != null) {
            return service.deleteTask(dono_id, req.title());
        }
        return ResponseEntity.unprocessableEntity().body("requisicao invalida");
    }

}

package com.example.rubrica.rubrica.controller;

import com.example.rubrica.rubrica.entity.Contatto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.rubrica.rubrica.service.ContattiService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class RubricaApiController {

    @Autowired
    ContattiService contattiService;

    @GetMapping("/contatti")
    List<Contatto> getContatti(){
        return contattiService.getContatti();
    }

    @GetMapping("/contatti/{id}")
    Contatto getContatto(@PathVariable Long id){
        return contattiService.getContatto(id);
    }

    @PostMapping("/contatti")
    Contatto addContatto(@RequestBody Contatto contatto){
        return contattiService.addContatto(contatto);
    }


    @PostMapping("/contatti/{id}")
    Contatto editContatto(@PathVariable Long id, @RequestBody Contatto contatto){
        contatto.setId(id);
        return contattiService.editContatto(contatto);
    }
        //Ciao io sono Umberto e sono molto bravo


}

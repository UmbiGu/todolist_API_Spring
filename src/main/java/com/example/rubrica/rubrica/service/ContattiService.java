package com.example.rubrica.rubrica.service;

import com.example.rubrica.rubrica.entity.Contatto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.rubrica.rubrica.repository.ContattiRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContattiService {

    @Autowired
    ContattiRepository contattiRepo;

    public List<Contatto> getContatti(){
        return contattiRepo.findAll();
    }

    public Contatto addContatto(Contatto contatto){
        return contattiRepo.save(contatto);
    }

    public Contatto editContatto(Contatto contatto){
        return contattiRepo.save(contatto);
    }

    public Contatto getContatto(Long id){
        Optional<Contatto> opt = contattiRepo.findById(id);
        return opt.orElse(null);
    }

}

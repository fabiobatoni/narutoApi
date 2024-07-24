package dev.fabiobatoni.ApiNaruto.service;

import dev.fabiobatoni.ApiNaruto.model.ninjas;
import dev.fabiobatoni.ApiNaruto.repository.ninjasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ninjasService {

    /*TODO: Refatorar a instancia*/
    @Autowired
    private ninjasRepository repository;

    // Criar um novo ninja
    public ninjas createNinja(ninjas ninja) {
        return repository.save(ninja);
    }

    // Mostrar ninjas criados
    public List<ninjas> getAllNinjas() {
        return repository.findAll();
    }

    // Mostrar ninja por ID
    public Optional<ninjas> findNinjaById(Long id) {
        return repository.findById(id);
    }

    // Deletar ninja
    public void deleteNinja(Long id) {
        repository.deleteById(id);
    }

    //Atualizar ninja
    public ninjas updateNinja(Long id, ninjas ninjas) {
       Optional<ninjas> oldNinja = repository.findById(id);

       if(oldNinja.isPresent()) {
           ninjas newNinja = oldNinja.get();

           newNinja.setNome(ninjas.getNome());
           newNinja.setElemento(ninjas.getElemento());
           newNinja.setIdade(ninjas.getIdade());
           newNinja.setAldeia(ninjas.getAldeia());
           newNinja.setImgUrl(ninjas.getImgUrl());

           return repository.save(newNinja);
       } else {
           throw new RuntimeException("Ninja nao encontrado com o id " + id + "Tente mais tarde");
       }
    }

}

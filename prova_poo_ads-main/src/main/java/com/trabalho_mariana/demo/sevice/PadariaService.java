package com.trabalho_mariana.demo.sevice;

import com.trabalho_mariana.demo.model.PadariaModel;
import com.trabalho_mariana.demo.repositories.PadariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PadariaService {

    @Autowired
    private PadariaRepository padariaRepository;

    //buscar todos os clientes
    public List<PadariaModel> findAll(){
        return padariaRepository.findAll();
    }

    //buscar por Id
    public PadariaModel buscarPorId(Long id){
        return padariaRepository.findById(id).get();
    }

    //criar cliente
    public PadariaModel criarCliente(PadariaModel padariaModel){
        return padariaRepository.save(padariaModel);
    }

    //deletar cliente
    public void deletarCliente(Long id){
        padariaRepository.deleteById(id);
    }

    //atualizar
    public PadariaModel atualizar(Long id, PadariaModel clienteNew){
        PadariaModel padariaModel = padariaRepository.findById(id).get();
        padariaModel.setNome(padariaModel.getNome());
        padariaModel.setEndereco(clienteNew.getEndereco());

        return padariaRepository.save(padariaModel);
    }

}

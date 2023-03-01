package com.pajates.sevillaFC.domain.useCases;

import com.pajates.sevillaFC.domain.ArbitroRepository;
import com.pajates.sevillaFC.domain.PartidoRepository;

public class DelArbitroUseCase {

    private ArbitroRepository arbitroRepository;

    public DelArbitroUseCase(ArbitroRepository arbitroRepository){
        this.arbitroRepository = arbitroRepository;
    }

    public void execute (Integer idArbitro){
        arbitroRepository.delete(idArbitro);
    }
}

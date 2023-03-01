package com.pajates.sevillaFC.domain.useCases;

import com.pajates.sevillaFC.domain.ArbitroRepository;
import com.pajates.sevillaFC.domain.models.Arbitro;

public class AddArbitroUseCase {

    private ArbitroRepository arbitroRepository;
    public AddArbitroUseCase (ArbitroRepository arbitroRepository){
        this.arbitroRepository = arbitroRepository;
    }

    public void execute (Arbitro arbitro){
        arbitroRepository.addArbitro(arbitro);
    }

}

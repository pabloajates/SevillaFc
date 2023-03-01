package com.pajates.sevillaFC.domain.useCases;

import com.pajates.sevillaFC.domain.PartidoRepository;
import com.pajates.sevillaFC.domain.models.Partido;

public class AddPartidoUseCase {

    private PartidoRepository partidoRepository;
    public AddPartidoUseCase (PartidoRepository partidoRepository){
        this.partidoRepository= partidoRepository;
    }

    public void execute (Partido partido){
        partidoRepository.addPartido(partido);
    }

}

package com.pajates.sevillaFC.domain.useCases;

import com.pajates.sevillaFC.domain.PartidoRepository;
import com.pajates.sevillaFC.domain.models.Partido;

import java.util.List;

public class GetPartidosUseCase {

    private PartidoRepository partidoRepository;
    public GetPartidosUseCase (PartidoRepository partidoRepository){
        this.partidoRepository = partidoRepository;
    }

    public List<Partido> execute (){
        return partidoRepository.listPartidos();
    }
}

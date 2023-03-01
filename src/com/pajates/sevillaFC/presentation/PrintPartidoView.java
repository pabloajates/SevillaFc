package com.pajates.sevillaFC.presentation;

import com.pajates.sevillaFC.data.PartidoDataRepository;
import com.pajates.sevillaFC.data.local.PartidoFileLocalDataSource;
import com.pajates.sevillaFC.domain.models.Partido;
import com.pajates.sevillaFC.domain.useCases.GetPartidosUseCase;

import java.util.List;

public class PrintPartidoView {

    public void print(){

        GetPartidosUseCase getPartidosUseCase = new GetPartidosUseCase(new PartidoDataRepository(PartidoFileLocalDataSource.getInstance()));
        List<Partido> partidos = getPartidosUseCase.execute();
        for(Partido partido : partidos){
            System.out.println(partido.toString());
        }

    }
}

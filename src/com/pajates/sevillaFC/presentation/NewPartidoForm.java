package com.pajates.sevillaFC.presentation;

import com.pajates.sevillaFC.data.ArbitroDataRepository;
import com.pajates.sevillaFC.data.EquipoDataRepository;
import com.pajates.sevillaFC.data.PartidoDataRepository;
import com.pajates.sevillaFC.data.local.ArbitroFileLocalDataSource;
import com.pajates.sevillaFC.data.local.EquipoFileLocalDataSource;
import com.pajates.sevillaFC.data.local.PartidoFileLocalDataSource;
import com.pajates.sevillaFC.domain.models.Arbitro;
import com.pajates.sevillaFC.domain.models.Equipo;
import com.pajates.sevillaFC.domain.models.Partido;
import com.pajates.sevillaFC.domain.useCases.AddPartidoUseCase;
import com.pajates.sevillaFC.domain.useCases.GetArbitroUseCase;
import com.pajates.sevillaFC.domain.useCases.GetEquipoUseCase;

public class NewPartidoForm {

    private Equipo findEquipo(Integer equipoId){
        GetEquipoUseCase getEquipoUseCase = new GetEquipoUseCase(new EquipoDataRepository(EquipoFileLocalDataSource.getInstance()));
        return getEquipoUseCase.execute(equipoId);
    }

    private Arbitro findArbitro(Integer arbitroId){
        GetArbitroUseCase getArbitroUseCase = new GetArbitroUseCase(new ArbitroDataRepository(ArbitroFileLocalDataSource.getInstance()));
        return getArbitroUseCase.execute(arbitroId);
    }

    private void savePartido(Partido partido){
        AddPartidoUseCase addPartidoUseCase = new AddPartidoUseCase((new PartidoDataRepository(PartidoFileLocalDataSource.getInstance())));
        addPartidoUseCase.execute(partido);
    }

    public void buildNewPartido(){
        Partido partido = new Partido();
        partido.setId(2);
        partido.setArbitro(findArbitro(1));
        partido.setEquipoVisitante(findEquipo(2));
        partido.setResultado("2-0");

        savePartido(partido);
    }
}

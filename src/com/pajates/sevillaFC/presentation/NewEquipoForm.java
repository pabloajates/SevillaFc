package com.pajates.sevillaFC.presentation;

import com.pajates.sevillaFC.data.EquipoDataRepository;
import com.pajates.sevillaFC.data.local.EquipoFileLocalDataSource;
import com.pajates.sevillaFC.domain.models.Equipo;
import com.pajates.sevillaFC.domain.useCases.AddEquipoUseCase;

public class NewEquipoForm {
    private Equipo buildEquipo(){

        Equipo equipo = new Equipo();
        equipo.setId(1);
        equipo.setNombre("Madrid");
        equipo.setCategoria("nose");
        equipo.setJugador(29);
        return equipo;
    }

    private void saveEquipo(Equipo equipo){

        AddEquipoUseCase addEquipoUseCase = new AddEquipoUseCase(new EquipoDataRepository(EquipoFileLocalDataSource.getInstance()));
        addEquipoUseCase.execute(equipo);

    }

    public void createNewArbitro(){

        Equipo equipo = buildEquipo();
        saveEquipo(equipo);
    }
}

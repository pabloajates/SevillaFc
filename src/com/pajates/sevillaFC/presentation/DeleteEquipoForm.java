package com.pajates.sevillaFC.presentation;

import com.pajates.sevillaFC.data.EquipoDataRepository;
import com.pajates.sevillaFC.data.local.EquipoFileLocalDataSource;
import com.pajates.sevillaFC.domain.useCases.DelEquipoUseCase;

public class DeleteEquipoForm {

    public void deleteEquipo(Integer idEquipo){
        DelEquipoUseCase delEquipoUseCase = new DelEquipoUseCase( new EquipoDataRepository(EquipoFileLocalDataSource.getInstance()));
        delEquipoUseCase.execute(idEquipo);
    }
}

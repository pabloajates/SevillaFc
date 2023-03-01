package com.pajates.sevillaFC.presentation;

import com.pajates.sevillaFC.data.ArbitroDataRepository;
import com.pajates.sevillaFC.data.local.ArbitroFileLocalDataSource;
import com.pajates.sevillaFC.domain.useCases.DelArbitroUseCase;

public class DeleteArbitroForm {

    public void deleteArbitro(Integer idArbitro){
        DelArbitroUseCase delArbitroUseCase = new DelArbitroUseCase( new ArbitroDataRepository(ArbitroFileLocalDataSource.getInstance()));
        delArbitroUseCase.execute(idArbitro);
    }
}

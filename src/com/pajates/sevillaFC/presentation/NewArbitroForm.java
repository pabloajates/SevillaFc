package com.pajates.sevillaFC.presentation;

import com.pajates.sevillaFC.data.ArbitroDataRepository;
import com.pajates.sevillaFC.data.local.ArbitroFileLocalDataSource;
import com.pajates.sevillaFC.domain.models.Arbitro;
import com.pajates.sevillaFC.domain.useCases.AddArbitroUseCase;

public class NewArbitroForm {

    private Arbitro buildArbitro(){

        Arbitro arbitro = new Arbitro();
        arbitro.setId(1);
        arbitro.setNombre("Manolo");
        arbitro.setApellidos("Perez");
        arbitro.setFechaNac("10/6/1998");
        arbitro.setCategoria("Alevin");

       return arbitro;
    }

    private void saveArbitro(Arbitro arbitro){

        AddArbitroUseCase addArbitroUseCase = new AddArbitroUseCase(new ArbitroDataRepository(ArbitroFileLocalDataSource.getInstance()));
        addArbitroUseCase.execute(arbitro);

    }

    public void createNewArbitro(){

        Arbitro arbitro = buildArbitro();
        saveArbitro(arbitro);
    }




}

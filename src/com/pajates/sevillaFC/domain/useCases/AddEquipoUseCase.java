package com.pajates.sevillaFC.domain.useCases;

import com.pajates.sevillaFC.domain.EquipoRepository;
import com.pajates.sevillaFC.domain.models.Equipo;

public class AddEquipoUseCase {

    private EquipoRepository equipoRepository;
    public AddEquipoUseCase (EquipoRepository equipoRepository){
        this.equipoRepository = equipoRepository;
    }

    public void execute (Equipo equipo){
        equipoRepository.addEquipo(equipo);
    }
}

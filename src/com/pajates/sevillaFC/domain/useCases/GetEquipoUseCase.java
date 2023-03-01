package com.pajates.sevillaFC.domain.useCases;

import com.pajates.sevillaFC.domain.EquipoRepository;
import com.pajates.sevillaFC.domain.PartidoRepository;
import com.pajates.sevillaFC.domain.models.Equipo;
import com.pajates.sevillaFC.domain.models.Partido;

public class GetEquipoUseCase {

    private EquipoRepository equipoRepository;

    public GetEquipoUseCase(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public Equipo execute(Integer id) {
        return equipoRepository.finById(id);
    }
}

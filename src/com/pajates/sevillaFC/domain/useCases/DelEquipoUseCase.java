package com.pajates.sevillaFC.domain.useCases;

import com.pajates.sevillaFC.domain.EquipoRepository;
import com.pajates.sevillaFC.domain.models.Equipo;

public class DelEquipoUseCase {

    private EquipoRepository equipoRepository;

    public DelEquipoUseCase(EquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    public void execute(Integer id) {
      equipoRepository.delEquipo(id);
    }
}

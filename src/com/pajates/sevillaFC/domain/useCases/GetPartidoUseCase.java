package com.pajates.sevillaFC.domain.useCases;

import com.pajates.sevillaFC.domain.PartidoRepository;
import com.pajates.sevillaFC.domain.models.Partido;

public class GetPartidoUseCase {

    private PartidoRepository partidoRepository;

    public GetPartidoUseCase(PartidoRepository partidoRepository) {
        this.partidoRepository = partidoRepository;
    }

    public Partido execute(Integer id) {
        return partidoRepository.findById(id);
    }
}

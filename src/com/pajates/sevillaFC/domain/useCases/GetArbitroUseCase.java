package com.pajates.sevillaFC.domain.useCases;

import com.pajates.sevillaFC.domain.ArbitroRepository;
import com.pajates.sevillaFC.domain.PartidoRepository;
import com.pajates.sevillaFC.domain.models.Arbitro;
import com.pajates.sevillaFC.domain.models.Partido;

public class GetArbitroUseCase {
    private ArbitroRepository arbitroRepository;

    public GetArbitroUseCase(ArbitroRepository arbitroRepository) {
        this.arbitroRepository = arbitroRepository;
    }

    public Arbitro execute(Integer id) {
        return arbitroRepository.findById(id);
    }
}

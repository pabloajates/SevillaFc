package com.pajates.sevillaFC.data;

import com.pajates.sevillaFC.data.local.ArbitroFileLocalDataSource;
import com.pajates.sevillaFC.domain.ArbitroRepository;
import com.pajates.sevillaFC.domain.models.Arbitro;

import java.util.List;

public class ArbitroDataRepository implements ArbitroRepository {

    private ArbitroFileLocalDataSource arbitroFileLocalDataSource = ArbitroFileLocalDataSource.getInstance();

    public ArbitroDataRepository(ArbitroFileLocalDataSource arbitroFileLocalDataSource) {
        this.arbitroFileLocalDataSource = arbitroFileLocalDataSource;
    }


    @Override
    public void addArbitro(Arbitro arbitro) {
        this.arbitroFileLocalDataSource.save(arbitro);
    }

    @Override
    public List<Arbitro> listArbitros() {
        return this.arbitroFileLocalDataSource.findAll();
    }

    @Override
    public Arbitro findById(Integer id) {
        return this.arbitroFileLocalDataSource.findById(id);
    }

    @Override
    public void delete(Integer id) {
        this.arbitroFileLocalDataSource.delete(id);
    }
}

package com.pajates.sevillaFC.data;

import com.pajates.sevillaFC.data.local.PartidoFileLocalDataSource;
import com.pajates.sevillaFC.domain.PartidoRepository;
import com.pajates.sevillaFC.domain.models.Partido;

import java.util.List;

public class PartidoDataRepository implements PartidoRepository {

    private PartidoFileLocalDataSource partidoFileLocalDataSource = PartidoFileLocalDataSource.getInstance();

    public PartidoDataRepository (PartidoFileLocalDataSource PartidoFileLocalDataSource){
        this.partidoFileLocalDataSource = partidoFileLocalDataSource;
    }

    @Override
    public void addPartido(Partido partido) {
        this.partidoFileLocalDataSource.save(partido);
    }

    @Override
    public List<Partido> listPartidos() {
        return this.partidoFileLocalDataSource.findAll();
    }


    @Override
    public Partido findById(Integer id) {
        return this.partidoFileLocalDataSource.findById(id);
    }

}

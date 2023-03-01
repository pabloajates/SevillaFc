package com.pajates.sevillaFC.data;

import com.pajates.sevillaFC.data.local.EquipoFileLocalDataSource;
import com.pajates.sevillaFC.domain.EquipoRepository;
import com.pajates.sevillaFC.domain.models.Equipo;

import java.util.List;

public class EquipoDataRepository implements EquipoRepository {

    private EquipoFileLocalDataSource equipoFileLocalDataSource = EquipoFileLocalDataSource.getInstance();

    public EquipoDataRepository(EquipoFileLocalDataSource EquipoFileLocalDataSource) {
        this.equipoFileLocalDataSource = equipoFileLocalDataSource;
    }

    @Override
    public void addEquipo(Equipo equipo) {
        this.equipoFileLocalDataSource.save(equipo);
    }

    @Override
    public List<Equipo> listEquipo() {
        return this.equipoFileLocalDataSource.findAll();
    }

    @Override
    public Equipo finById(Integer id) {
        return this.equipoFileLocalDataSource.findById(id);
    }

    @Override
    public void delEquipo(Integer id) {
        this.equipoFileLocalDataSource.delete(id);
    }
}
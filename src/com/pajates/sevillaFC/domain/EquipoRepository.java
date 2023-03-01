package com.pajates.sevillaFC.domain;

import com.pajates.sevillaFC.domain.models.Equipo;

import java.util.List;

public interface EquipoRepository {

    public void addEquipo (Equipo equipo);
    public List<Equipo> listEquipo();
    public Equipo finById (Integer id);

    public void delEquipo (Integer id);

}

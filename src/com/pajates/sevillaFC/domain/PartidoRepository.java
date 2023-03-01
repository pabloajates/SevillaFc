package com.pajates.sevillaFC.domain;

import com.pajates.sevillaFC.domain.models.Partido;

import java.util.List;

public interface PartidoRepository {

    public void addPartido (Partido partido);
    public List<Partido> listPartidos ();
    public Partido findById(Integer id);

}

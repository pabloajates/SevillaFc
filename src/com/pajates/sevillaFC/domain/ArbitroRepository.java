package com.pajates.sevillaFC.domain;

import com.pajates.sevillaFC.domain.models.Arbitro;

import java.util.List;

public interface ArbitroRepository {

    public void addArbitro (Arbitro arbitro);
    public List<Arbitro> listArbitros ();
    public Arbitro findById (Integer id);
    public void delete (Integer id);
}

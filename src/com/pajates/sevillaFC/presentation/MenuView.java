package com.pajates.sevillaFC.presentation;

public class MenuView {

    public void init(){
        createNewArbitro();
        createNewEquipo();
        createNewPartido();
        printPartidos();
    }

    public void createNewArbitro(){
        NewArbitroForm newArbitroForm = new NewArbitroForm();
        newArbitroForm.createNewArbitro();
    }

    public void deleteArbitro(){
        DeleteArbitroForm deleteArbitroForm = new DeleteArbitroForm();
        deleteArbitroForm.deleteArbitro(2);

    }

    public void createNewEquipo(){
        NewEquipoForm newEquipoForm = new NewEquipoForm();
        newEquipoForm.createNewArbitro();

    }

    public void createNewPartido(){
        NewPartidoForm newPartidoForm = new NewPartidoForm();
        newPartidoForm.buildNewPartido();
    }

    public void printPartidos(){
        PrintPartidoView printPartidoView = new PrintPartidoView();
        printPartidoView.print();
    }
}

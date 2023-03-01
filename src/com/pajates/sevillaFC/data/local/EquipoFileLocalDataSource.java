package com.pajates.sevillaFC.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pajates.sevillaFC.domain.models.Arbitro;
import com.pajates.sevillaFC.domain.models.Equipo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class EquipoFileLocalDataSource {

    private static EquipoFileLocalDataSource instance = null;
    private EquipoFileLocalDataSource(){};

    private String nameFile = "equipos.txt";

    private Gson gson = new Gson();

    private final Type typeEquipoList = new TypeToken<ArrayList<Equipo>>() {
    }.getType();

    //Metodo SAVE
    public void save(Equipo equipo) {
        List<Equipo> equipos = findAll();
        equipos.add(equipo);
        saveToFile(equipos);
    }

    public void saveList(List<Equipo> equipos) {
        saveToFile(equipos);
    }

    private void saveToFile(List<Equipo> equipos) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(equipos));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }

    //METODO FIND_BY_ID
    public Equipo findById(Integer id) {
        List<Equipo> equipos = findAll();
        for (Equipo equipo : equipos) {
            if (Objects.equals(equipo.getId(), id)) {
                return equipo;
            }
        }
        return null;
    }

    //METODO FIND_ALL
    public List<Equipo> findAll() {
        try {
            File myObj = new File(nameFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typeEquipoList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        }
        return new ArrayList<Equipo>();
    }

    public void delete(Integer equipoId) {
        List<Equipo> newEquiposList = new ArrayList<>();
        List<Equipo> equipos = findAll();
        for (Equipo equipo : equipos) {
            if (equipo.getId() != equipoId) {
                newEquiposList.add(equipo);
            }
        }
        saveList(newEquiposList);
    }

    public static EquipoFileLocalDataSource getInstance(){
        if (instance == null){
            instance = new EquipoFileLocalDataSource();
        }

        return instance;
    }
}

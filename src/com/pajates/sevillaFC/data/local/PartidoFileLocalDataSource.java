package com.pajates.sevillaFC.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pajates.sevillaFC.domain.models.Arbitro;
import com.pajates.sevillaFC.domain.models.Partido;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PartidoFileLocalDataSource {

    private static PartidoFileLocalDataSource instance = null;
    private PartidoFileLocalDataSource(){};

    private String nameFile = "partidos.txt";

    private Gson gson = new Gson();

    private final Type typePartidoList = new TypeToken<ArrayList<Partido>>() {
    }.getType();

    //Metodo SAVE
    public void save(Partido partido) {
        List<Partido> partidos = findAll();
        partidos.add(partido);
        saveToFile(partidos);
    }

    public void saveList(List<Partido> partidos) {
        saveToFile(partidos);
    }

    private void saveToFile(List<Partido> partidos) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(partidos));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }

    //METODO FIND_BY_ID
    public Partido findById(Integer id) {
        List<Partido> partidos = findAll();
        for (Partido partido : partidos) {
            if (Objects.equals(partido.getId(), id)) {
                return partido;
            }
        }
        return null;
    }

    //METODO FIND_ALL
    public List<Partido> findAll() {
        try {
            File myObj = new File(nameFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typePartidoList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        }
        return new ArrayList<Partido>();
    }

    public void delete(Integer partidoId) {
        List<Partido> newPartidosList = new ArrayList<>();
        List<Partido> partidos = findAll();
        for (Partido partido : partidos) {
            if (partido.getId() != partidoId) {
                newPartidosList.add(partido);
            }
        }
        saveList(newPartidosList);
    }


    public static PartidoFileLocalDataSource getInstance(){
        if (instance == null){
            instance = new PartidoFileLocalDataSource();
        }

        return instance;
    }
}


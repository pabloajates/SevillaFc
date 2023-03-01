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

public class ArbitroFileLocalDataSource {

    private static ArbitroFileLocalDataSource instance = null;
    private ArbitroFileLocalDataSource(){};

    private String nameFile = "arbitros.txt";

    private Gson gson = new Gson();

    private final Type typeArbitroList = new TypeToken<ArrayList<Arbitro>>() {
    }.getType();

    //Metodo SAVE
    public void save(Arbitro arbitro) {
        List<Arbitro> arbitros = findAll();
        arbitros.add(arbitro);
        saveToFile(arbitros);
    }

    public void saveList(List<Arbitro> arbitros) {
        saveToFile(arbitros);
    }

    private void saveToFile(List<Arbitro> arbitros) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(arbitros));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }

    //METODO FIND_BY_ID
    public Arbitro findById(Integer id) {
        List<Arbitro> arbitros = findAll();
        for (Arbitro arbitro : arbitros) {
            if (Objects.equals(arbitro.getId(), id)) {
                return arbitro;
            }
        }
        return null;
    }

    //METODO FIND_ALL
    public List<Arbitro> findAll() {
        try {
            File myObj = new File(nameFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typeArbitroList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        }
        return new ArrayList<Arbitro>();
    }

    public void delete(Integer arbitroId) {
        List<Arbitro> newArbitrosList = new ArrayList<>();
        List<Arbitro> arbitros = findAll();
        for (Arbitro arbitro : arbitros) {
            if (arbitro.getId() != arbitroId) {
                newArbitrosList.add(arbitro);
            }
        }
        saveList(newArbitrosList);
    }



    public static ArbitroFileLocalDataSource getInstance(){
        if (instance == null){
            instance = new ArbitroFileLocalDataSource();
        }

        return instance;
    }
}

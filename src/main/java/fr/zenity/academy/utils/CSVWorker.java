package fr.zenity.academy.utils;


import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CSVWorker {

    private File file;

    private CSVParser parser;

    public CSVWorker(String path){
        this(Paths.get(path).toFile());
    }

    public CSVWorker(File path){
        if(!path.isFile()) throw new RuntimeException("argument path ["+path.toString()+"] value is not a file !");
        this.file = path;
        init();
    }


    private void init(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(this.file.toString()));
            this.parser = CSVFormat.DEFAULT.withDelimiter(';').withHeader().parse(br);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public ArrayList<ArrayList<String>> getLine(int index){
        if(index<0) throw new IndexOutOfBoundsException();
        return null;
    }

    public ArrayList<String> getColumn(String name){
        ArrayList<String> listName = new ArrayList<String>();

        try{
            for(CSVRecord record : this.parser) {
                listName.add(record.get(name));
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return listName;
    }

}

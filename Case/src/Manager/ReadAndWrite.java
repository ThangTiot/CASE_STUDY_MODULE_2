package Manager;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWrite<E> {
    public ArrayList<E> read(String path){
        ArrayList<E> arrayList=new ArrayList<>();
        try {
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(path));
            arrayList = (ArrayList<E>) readFile.readObject();
            readFile.close();
        }catch (Exception e) {
            e.getMessage();
        }
        return arrayList;
    }

    public void write(String path, ArrayList<E> arrayList){
        try {
            ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(path));
            writeFile.writeObject(arrayList);
            writeFile.close();
        } catch (IOException e) {
            e.getMessage();
        }

    }
}

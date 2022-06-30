package Manager;

import java.io.*;
import java.util.ArrayList;

public class ReadAndWrite<E> {
    public ArrayList<E> read(String path){
        try {
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(path));
            ArrayList<E> arrayList = (ArrayList<E>) readFile.readObject();
            readFile.close();
            return arrayList;
        }catch (Exception e) {
            e.getMessage();
        }
        return new ArrayList<E>();
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

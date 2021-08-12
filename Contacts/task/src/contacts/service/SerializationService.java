package contacts.service;

import contacts.model.Contract;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationService {

    public void serialize(List<Contract> contractList, String fileName) {
            try {
                FileOutputStream fos = new FileOutputStream(fileName);
                BufferedOutputStream bos = new BufferedOutputStream(fos);
                ObjectOutputStream oos = new ObjectOutputStream(bos);
                oos.writeObject(contractList);
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    public List<Contract> deserialize(String fileName) {
        List<Contract> contractList = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            BufferedInputStream bis = new BufferedInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(bis);
            contractList = (ArrayList) ois.readObject();
            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return contractList;
    }
}

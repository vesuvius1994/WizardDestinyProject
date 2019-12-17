/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

/**
 *
 * @author ludovicorusso
 */
public class SerializzatoreCommand implements Serializable{
    
     public  void save(PersonalizableCommand p) throws IOException{
        OutputStream output = new FileOutputStream("src/Resources/personalizzablecommand.dat");
        ObjectOutputStream objOutput = new ObjectOutputStream(new BufferedOutputStream(output));
        objOutput.writeObject(p);
        objOutput.close();
    }
    
    public  PersonalizableCommand load() throws IOException, ClassNotFoundException{
        InputStream input = new FileInputStream("src/Resources/personalizzablecommand.dat");
        ObjectInputStream objInput = new ObjectInputStream(new BufferedInputStream(input));
        PersonalizableCommand p= (PersonalizableCommand)objInput.readObject();
        objInput.close();
        return p;
    }
}

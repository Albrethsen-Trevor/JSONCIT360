
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author trevoralbrethsen
 */
class User implements Serializable {
    String name;
    
    public User(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "User [name=" + name + "]";
    }
    
}
public class UserAccount {
    
    public static void main(String[] args) {
        
        User talbrethsen = new User("Trevor Albrethsen");
        
        try {
            
            readFile();
        } catch (IOException ex) {
            Logger.getLogger(UserAccount.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserAccount.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void readFile() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("User.bin"));
        
        User name = (User) objectInputStream.readObject();
        System.out.println(name);
        
    }
    
}

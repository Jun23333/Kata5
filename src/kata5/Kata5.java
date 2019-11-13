/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5;

/**
 *
 * @author Usuario
 */
public class Kata5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String URL = new String("jdbc:sqlite:C:\\Users\\Usuario\\Documents\\NetBeansProjects\\jun\\Kata5\\DB\\Prueba.db");
        DataBase db = new DataBase(URL);
        db.open();
        db.insert();
        db.selectAll();
        db.remove();
        db.close();
    }
    
}

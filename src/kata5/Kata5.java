/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5;

import java.io.File;
import java.util.List;
import model.Mail;
import view.MailReader;

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
        String file = new String("C:\\Users\\Usuario\\Documents\\NetBeansProjects\\jun\\Kata5\\EMAIL.txt");
        List<Mail> mailList = MailReader.read(file);
        
        db.open();
        db.selectAll();
        db.createTableMail("GMAIL");
        db.addToTable("GMAIL", mailList);
        db.close();
    }
    
}

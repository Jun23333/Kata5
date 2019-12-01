/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5;

import view.DataBase;
import java.util.List;
import model.*;
import view.*;

/**
 *
 * @author Usuario
 */
public class Kata5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String URL = new String("jdbc:sqlite:F:\\NetBeans Project\\Kata5\\DB\\Prueba.db");
        DataBase db = new DataBase(URL);
        String file = new String("F:\\NetBeans Project\\Kata5\\EMAIL.txt");
        List<Mail> mailList = MailReader.read(file);
        
        db.open();
        db.selectAllPeople();
        db.addMailTable("QMAIL");
        db.addMailToTable("QMAIL", mailList);
        db.close();
    }
    
}

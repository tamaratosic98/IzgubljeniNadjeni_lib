/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.nprog.domen;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author tamara
 */
public interface IOpstiDomenskiObjekat extends Serializable  {
    
    public String nazivTabele();
    
    public String alijas();
    
    public String join();//return "JOIN tabela on...
    
    public String selectWhere();//vraca where uslov za select
    //pretraga po nekim stvarima
    //if username nije null vrati where username='tom sto je dato'
    //ako je null vrati prazan string
    
    public List<IOpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException;//parsira resultset u list
    
    public String koloneInsert();//ako hocemo da zanemarimo neke vr
    
    public String vrednostPrimarniKljuc();//vraca sta je primary key
    
    public String vrednostiInsert();//sta ubacujemo
    
    public String vrednostiUpdate();
    
    public String vratiMax();
    //zahtev join sa rasom lokacijom
    
}

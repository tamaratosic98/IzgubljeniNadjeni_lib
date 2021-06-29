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
 * Interfejs koji predstavlja opsti domenski objekat.
 * @author tamara
 */
public interface IOpstiDomenskiObjekat extends Serializable  {
	/**
	 * Vraca naziv tabele iz baze.
	 *
	 * @return Naziv tabele kao String.
	 */
    
    public String nazivTabele();
    /**
     * Vraca alijas tabele.
     * 
     * @return  Alias kao String.
     */
    
    public String alijas();
    /**
     * Vraca join deo upita.
     * 
     * @return Join kao String.
     */
    
    public String join();
    /**
     * Vraca where uslov upita.
     * 
     * @return Where uslov kao String.
     */
    
    public String selectWhere();
    /**
     * Vraca listu domenskih objekata iz baze kao rezultat prethodno postavljenog upita.
     * 
     * @param rs Podaci iz baze kao ResultSet vrednost.
     * @return List<IOpstiDomenskiObjekat> kao List<IOpstiDomenskiObjekat>
     * @throws SQLException ako je rs null.
     */
    
    public List<IOpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException;
    /**
     * Vraca kolone u koje treba insertovati vrednosti.
     * 
     * @return Naziv kolona kao String.
     */
    
    public String koloneInsert();
    /**
     * Vraca vrednost primarnog kljuca tabele.
     * 
     * @return Primarni kljuc kao String
     */
    
    public String vrednostPrimarniKljuc();
    /**
     * Vraca vrednosti koje treba ubaciti u tabelu.
     * 
     * @return Vrednost za insert kao String.
     */
    
    public String vrednostiInsert();
    /**
     * Vraca vrednosti koje treba izmeniti u table.
     * 
     * @return Vrednosti za update kao String.
     */
    
    public String vrednostiUpdate();
    /**
     * Vraca vrednost najveceg primarnog kljuca iz tabele.
     * 
     * @return Vrednost najveceg primarnog kljuca.
     */
    
    public String vratiMax();
    
}

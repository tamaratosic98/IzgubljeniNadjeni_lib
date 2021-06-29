/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.nprog.domen;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa koja predstavlja rasu psa.
 * 
 * Rasa ima rasaId kao long i naziv i slikaURL kao String vrednosti.
 *
 * @author tamara
 * @version 1.0
 */
public class Rasa implements IOpstiDomenskiObjekat{
	/**
	 * Id rase kao long vrednost.
	 */
    private long rasaId=-1;
    /**
     * Naziv rase kao String vrednost.
     */
    private String naziv;
    /**
     * Slika rase kao String vrednost.
     */
    private String slikaURL;
    /**
     * Konstruktor koji inicijalizuje objekat i nista vise.
     */
    public Rasa() {
    }
    /**
     * Konstruktor koji inicijalizuje objekat i postavlja vrednosti rasaId, naziv i slikaURL na nove vrednosti.
     * 
     * @param rasaId Id rase kao long vrednost.
     * @param naziv Naziv rase kao String vrednost.
     * @param slikaURL Slika rase kao String vrednost.
     */
    public Rasa(long rasaId, String naziv, String slikaURL) {
        this.rasaId = rasaId;
        this.naziv = naziv;
        this.slikaURL = slikaURL;
    }

    /**
     * Vraca id rase.
     * 
     * @return Id rase kao long vrednost.
     */
    public long getRasaId() {
        return rasaId;
    }

    /**
     * Postavlja id rase na novu vrednost.
     * 
     * @param rasaId Id rase kao long vrednost.
     */
    public void setRasaId(long rasaId) {
        this.rasaId = rasaId;
    }

    /**
     * Vraca naziv rase.
     * 
     * @return Naziv rase kao String vrednost.
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Postavlja naziv rase na novu vrednost.
     * 
     * @param naziv Naziv rase kao String vrednost.
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    /**
     * Vraca sliku rase.
     * 
     * @return Slika rase kao String vrednost.
     */
    public String getSlikaURL() {
        return slikaURL;
    }

    /**
     * Postavlja sliku rase na novu vrednost.
     * 
     * @param slikaURL Slika rase kao String vrednost.
     */
    public void setSlikaURL(String slikaURL) {
        this.slikaURL = slikaURL;
    }

    @Override
    public String nazivTabele() {
        return " rasa ";
    }

    @Override
    public String alijas() {
         return " r ";
    }

    @Override
    public String join() {
         return " ";
    }

    @Override
    public String selectWhere() {
       return " ";
    }

    @Override
    public List<IOpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<IOpstiDomenskiObjekat> lista=new ArrayList<>();
        while(rs.next()){
            Rasa r = new Rasa(rs.getLong("rasaId"), rs.getString("nazivRase"), rs.getString("slikaURLRase"));
            lista.add(r);
        }
        return lista;
    }

    @Override
    public String koloneInsert() {
        return "(nazivRase, slikaURLRase)";
    }

    @Override
    public String vrednostPrimarniKljuc() {
        return " rasaId="+rasaId;
    }

    @Override
    public String vrednostiInsert() {
        return "'"+naziv+"','"+slikaURL+"'";
    }

    @Override
    public String vrednostiUpdate() {
          return " nazivRase='"+naziv+"', slikaURLRase='"+slikaURL+"'";
    }

    @Override
    public String vratiMax() {
        return " rasaId ";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Rasa other = (Rasa) obj;
        if (this.rasaId != other.rasaId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return naziv;
    }
    
    
}

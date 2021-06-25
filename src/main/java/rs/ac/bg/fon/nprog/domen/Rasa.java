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
 *
 * @author tamara
 */
public class Rasa implements IOpstiDomenskiObjekat{
    private long rasaId=-1;
    private String naziv;
    private String slikaURL;

    public Rasa() {
    }

    public Rasa(long rasaId, String naziv, String slikaURL) {
        this.rasaId = rasaId;
        this.naziv = naziv;
        this.slikaURL = slikaURL;
    }

    /**
     * @return the rasaId
     */
    public long getRasaId() {
        return rasaId;
    }

    /**
     * @param rasaId the rasaId to set
     */
    public void setRasaId(long rasaId) {
        this.rasaId = rasaId;
    }

    /**
     * @return the naziv
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * @param naziv the naziv to set
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    /**
     * @return the slikaURL
     */
    public String getSlikaURL() {
        return slikaURL;
    }

    /**
     * @param slikaURL the slikaURL to set
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

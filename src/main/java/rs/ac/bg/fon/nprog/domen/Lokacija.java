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
 * Klasa koja predstavlja lokaciju gde se nalazi pas ili gde je poslednji put vidjen.
 * 
 * Lokacija ima id kao long vrednost i naziv kao String vrednost.
 *
 * @author tamara
 * @version 1.0
 */
public class Lokacija implements IOpstiDomenskiObjekat{
	/**
	 * lokacijaId kao long vrednost.
	 */
    private long lokacijaId=-1;
    /**
     * Naziv lokacije kao String vrednost.
     */
    private String naziv;
    /**
     * Konstruktor koji inicijalizuje objekat i nista vise.
     */
    public Lokacija() {
    }
    /**
     * Konstruktor koji inicijalizuje objekat i postavlja vrednosti lokacjaId i naziv na nove vrednosti.
     * 
     * @param lokacijaId Id lokacije kao long vrednost.
     * @param naziv Naziv lokacije kao String vrednost.
     */

    public Lokacija(long lokacijaId, String naziv) {
        this.lokacijaId = lokacijaId;
        this.naziv = naziv;
    }
    
    /**
     * Vraca id lokacije.
     * 
     * @return Id lokacije kao long vrednost.
     */
    public long getLokacijaId() {
        return lokacijaId;
    }

    /**
     * Postavlja id lokacije na novu vrednost.
     * 
     * @param Id lokacije kao long vrednost.
     */
    public void setLokacijaId(long lokacijaId) {
        this.lokacijaId = lokacijaId;
    }

    /**
     * Vraca naziv lokacije
     * 
     * @return Naziv lokacije kao String vrednost.
     */
    public String getNaziv() {
        return naziv;
    }

    /**
     * Postavlja naziv lokacije na novu vrednost.
     * 
     * @param Naziv lokacije kao String vrednost.
     */
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @Override
    public String nazivTabele() {
       return " lokacija ";
    }

    @Override
    public String alijas() {
          return " l ";
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
            Lokacija l=new Lokacija(rs.getLong("lokacijaId"),rs.getString("nazivLokacije"));
            lista.add(l);
        }
        return lista;
    }

    @Override
    public String koloneInsert() {
      return " (lokacijaId, nazivLokacije) ";
    }
    
    @Override
    public String vrednostPrimarniKljuc() {
        return " lokacijaId="+lokacijaId;
    }

    @Override
    public String vrednostiInsert() {
       return " "+lokacijaId+", '"+naziv+"' ";
    }

    @Override
    public String vrednostiUpdate() {
        return " naziv='"+naziv+"' ";
    }

    @Override
    public String vratiMax() {
        return "lokacijaId";
    }

    @Override
    public String toString() {
        return naziv;
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
        final Lokacija other = (Lokacija) obj;
        if (this.lokacijaId != other.lokacijaId) {
            return false;
        }
        return true;
    }
    
    
}

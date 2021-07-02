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
 * Klasa koja predstavlja korisnika sistema za izgubljene i nadjene pse i implementira interfejs IOpstiDomenskiObjekat
 * 
 * Korisnik ima korisnikId kao long i ime, prezime, telefon, email i lozinku kao String vrednosti.
 * 
 * @author tamara
 * @version 1.0
 */
public class Korisnik implements IOpstiDomenskiObjekat{
	/**
	 * korisnikId kao long vrednost.
	 */
    private long korisnikId;
    /**
     * Ime korisnika kao String vrednost.
     */
    private String ime;
    /**
     * Prezime korisnika kao String vrednost.
     */
    private String prezime;
    /**
     * Telefon korisnika kao String vrednost.
     */
    private String telefon;
    /**
     * Email korisnika kao String vrednost.
     */
    private String email;
    /**
     * Lozinka korisnika kao String vrednost.
     */
    private String lozinka;
    /**
     * Konstruktor koji inicijalizuje objekat Korisnik i nista vise.
     */
    public Korisnik() {
        
    }
    /**
     * Konstruktor koji inicijalizuje objekat Korisnik i postavlja vrednosti za korisnikId, ime, prezime, telefon, email i lozinku.
     * 
     * @param korisnikId korisnikId kao long vrednost.
     * @param ime Ime korisnika kao String vrednost.
     * @param prezime Prezime korisnika kao String vrednost.
     * @param telefon Telefon korisnika kao String vrednost.
     * @param email Email korisnika kao String vrednost.
     * @param lozinka Lozinka korisnika kao String vrednost.
     */
    public Korisnik(long korisnikId, String ime, String prezime, String telefon, String email, String lozinka) {
        this.korisnikId = korisnikId;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.email = email;
        this.lozinka = lozinka;
    }
    @Override
    public String nazivTabele() {
        return " korisnik ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return " ";
    }

    @Override
    public String selectWhere() {
         if(!email.isEmpty() && !lozinka.isEmpty()){
            return " WHERE email='"+email+"' AND lozinka='"+lozinka+"' ";
        }
        return " WHERE korisnikID="+korisnikId+" ";
    }

    @Override
    public List<IOpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<IOpstiDomenskiObjekat> lista=new ArrayList<>();
        while(rs.next()){
            long korisnikId=rs.getLong("korisnikId");
            String ime=rs.getString("ime");
            String prezime=rs.getString("prezime");
            String email=rs.getString("email");
            String telefon=rs.getString("telefon");
            String lozinka=rs.getString("lozinka");
            Korisnik k=new Korisnik(korisnikId, ime, prezime, telefon, email, lozinka);
            lista.add(k);
        }
        return lista;
    }

    @Override
    public String koloneInsert() {
        return " (korisnikId, ime, prezime, telefon, email, lozinka) ";
    }

    @Override
    public String vrednostPrimarniKljuc() {
        return " korisnikId="+getKorisnikId();
    }

    @Override
    public String vrednostiInsert() {
        return " "+getKorisnikId()+", '"+getIme()+"', '"+getPrezime()+"', '"+getTelefon()+"', '"+getEmail()+"', '"+getLozinka()+"' ";
    }

    @Override
    public String vrednostiUpdate() {
         return " ime='"+getIme()+"', prezime='"+getPrezime()+"', telefon='"+getTelefon()+"', email='"+getEmail()+"', lozinka='"+getLozinka()+"' ";
    }

    @Override
    public String vratiMax() {
        return " korisnikId ";
    }

    /**
     * Vraca id korisnika.
     * 
     * @return korisnikId kao long vrednost.
     */
    public long getKorisnikId() {
        return korisnikId;
    }

    /**
     * Postavlja id korisnika na novu vrednost.
     * 
     * @param korisnikId korisnikId kao long vrednost.
     */
    public void setKorisnikId(long korisnikId) {
        this.korisnikId = korisnikId;
    }

    /**
     * Vraca ime korisnika.
     * 
     * @return Ime korisnika kao String vrednost.
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja ime korisnika na novu vrednost.
     * 
     * @param ime Ime korisnika kao String vrednost.
     */
    public void setIme(String ime) {
    	if(ime==null) {
    		throw new NullPointerException("Ime ne sme biti null.");
    	}
    	if(ime.isEmpty()) {
    		throw new RuntimeException("Ime ne sme biti prazan string.");
    	}
        this.ime = ime;
    }

    /**
     * Vraca prezime korisnika.
     * 
     * @return Prezime korisnika kao String vrednost.
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * Postavlja prezime korisnika na novu vrednost.
     * 
     * @param prezime Prezime korisnika kao String vrednost.
     */
    public void setPrezime(String prezime) {
    	if(prezime==null) {
    		throw new NullPointerException("Prezime ne sme biti null.");
    	}
    	if(prezime.isEmpty()) {
    		throw new RuntimeException("Prezime ne sme biti prazan string.");
    	}
        this.prezime = prezime;
    }

    /**
     * Vraca telefon korisnika.
     * 
     * @return Telefon korisnika kao String vrednost.
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * Postavlja telefon korisnika na novu vrednost.
     * 
     * @param telefon Telefon korisnika kao String vrednost.
     */
    public void setTelefon(String telefon) {
    	if(telefon==null) {
    		throw new NullPointerException("Telefon ne sme biti null.");
    	}
    	if(telefon.isEmpty()) {
    		throw new RuntimeException("Telefon ne sme biti prazan string.");
    	}
        this.telefon = telefon;
    }

    /**
     * Vraca email korisnika.
     * 
     * @return Email korisnika kao String vrednost.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Postavlja email korisnika na novu vrednost.
     * 
     * @param email Email korisnika kao String vrednost.
     */
    public void setEmail(String email) {
    	if(email==null) {
    		throw new NullPointerException("Email ne sme biti null.");
    	}
    	if(email.isEmpty()) {
    		throw new RuntimeException("Email ne sme biti prazan string.");
    	}
        this.email = email;
    }

    /**
     * Vraca lozinku korisnika.
     * 
     * @return Lozinka korisnika kao String vrednost.
     */
    public String getLozinka() {
    	
        return lozinka;
    }

    /**
     * Postavlja lozinku korisnika na novu vrednost.
     * 
     * @param lozinka Lozinka korisnika kao String vrednost.
     */
    public void setLozinka(String lozinka) {
    	if(lozinka==null) {
    		throw new NullPointerException("Lozinka ne sme biti null.");
    	}
    	if(lozinka.isEmpty()) {
    		throw new RuntimeException("Lozinka ne sme biti prazan string.");
    	}
        this.lozinka = lozinka;
    }

    @Override
    public String toString() {
        return "Korisnik{" + "korisnikId=" + korisnikId + ", ime=" + ime + ", prezime=" + prezime + ", telefon=" + telefon + ", email=" + email + ", lozinka=" + lozinka + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        final Korisnik other = (Korisnik) obj;
        if (this.korisnikId != other.korisnikId) {
            return false;
        }
        return true;
    }
    

    
}

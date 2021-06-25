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
public class Korisnik implements IOpstiDomenskiObjekat{
    private long korisnikId;
    private String ime;
    private String prezime;
    private String telefon;
    private String email;
    private String lozinka;
    
    public Korisnik() {
        
    }
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
        //email i lozinka razliciti od null
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
     * @return the korisnikId
     */
    public long getKorisnikId() {
        return korisnikId;
    }

    /**
     * @param korisnikId the korisnikId to set
     */
    public void setKorisnikId(long korisnikId) {
        this.korisnikId = korisnikId;
    }

    /**
     * @return the ime
     */
    public String getIme() {
        return ime;
    }

    /**
     * @param ime the ime to set
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * @return the prezime
     */
    public String getPrezime() {
        return prezime;
    }

    /**
     * @param prezime the prezime to set
     */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    /**
     * @return the telefon
     */
    public String getTelefon() {
        return telefon;
    }

    /**
     * @param telefon the telefon to set
     */
    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the lozinka
     */
    public String getLozinka() {
        return lozinka;
    }

    /**
     * @param lozinka the lozinka to set
     */
    public void setLozinka(String lozinka) {
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

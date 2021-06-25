/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.nprog.domen;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author tamara
 */
public class ZahtevZaTrazenjePsa implements IOpstiDomenskiObjekat{
    private long zahtevZaTrazenjePsaId=-1;
    private EnumPol pol;
    private String boja;
    private Date vremeNestanka;
    private String kontaktVlasnika;
    private ImageIcon slikaURL;
    private int starost;
    private String ime;
    private Rasa rasa;
    private Lokacija lokacija;
    
    
    private double x;
    private double y;
    private String opis;
    
    private Korisnik sacuvaoZahtev;

    public ZahtevZaTrazenjePsa() {
    }

    public ZahtevZaTrazenjePsa(long zahtevZaTrazenjePsaId,EnumPol pol, String boja, Date vremeNestanka, String kontaktVlasnika, ImageIcon slikaURL, int starost, String ime, Rasa rasa, Lokacija lokacija, double x, double y, String opis, Korisnik sacuvaoZahtev) {
        this.zahtevZaTrazenjePsaId=zahtevZaTrazenjePsaId;
        this.pol = pol;
        this.boja = boja;
        this.vremeNestanka = vremeNestanka;
        this.kontaktVlasnika = kontaktVlasnika;
        this.slikaURL = slikaURL;
        this.starost = starost;
        this.ime = ime;
        this.rasa = rasa;
        this.lokacija = lokacija;
        this.x = x;
        this.y = y;
        this.opis = opis;
        this.sacuvaoZahtev = sacuvaoZahtev;
    }

    
    
    
    /**
     * @return the zahtevZaTrazenjePsaId
     */
    public long getZahtevZaTrazenjePsaId() {
        return zahtevZaTrazenjePsaId;
    }

    /**
     * @param zahtevZaTrazenjePsaId the zahtevZaTrazenjePsaId to set
     */
    public void setZahtevZaTrazenjePsaId(long zahtevZaTrazenjePsaId) {
        this.zahtevZaTrazenjePsaId = zahtevZaTrazenjePsaId;
    }

    /**
     * @return the pol
     */
    public EnumPol getPol() {
        return pol;
    }

    /**
     * @param pol the pol to set
     */
    public void setPol(EnumPol pol) {
        this.pol = pol;
    }

    /**
     * @return the boja
     */
    public String getBoja() {
        return boja;
    }

    /**
     * @param boja the boja to set
     */
    public void setBoja(String boja) {
        this.boja = boja;
    }

    /**
     * @return the vremeNestanka
     */
    public Date getVremeNestanka() {
        return vremeNestanka;
    }

    /**
     * @param vremeNestanka the vremeNestanka to set
     */
    public void setVremeNestanka(Date vremeNestanka) {
        this.vremeNestanka = vremeNestanka;
    }

    /**
     * @return the kontaktVlasnika
     */
    public String getKontaktVlasnika() {
        return kontaktVlasnika;
    }

    /**
     * @param kontaktVlasnika the kontaktVlasnika to set
     */
    public void setKontaktVlasnika(String kontaktVlasnika) {
        this.kontaktVlasnika = kontaktVlasnika;
    }

    /**
     * @return the slikaURL
     */
    public ImageIcon getSlikaURL() {
        return slikaURL;
    }

    /**
     * @param slikaURL the slikaURL to set
     */
    public void setSlikaURL(ImageIcon slikaURL) {
        this.slikaURL = slikaURL;
    }

    /**
     * @return the starost
     */
    public int getStarost() {
        return starost;
    }

    /**
     * @param starost the starost to set
     */
    public void setStarost(int starost) {
        this.starost = starost;
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
     * @return the rasa
     */
    public Rasa getRasa() {
        return rasa;
    }

    /**
     * @param rasa the rasa to set
     */
    public void setRasa(Rasa rasa) {
        this.rasa = rasa;
    }

    /**
     * @return the lokacija
     */
    public Lokacija getLokacija() {
        return lokacija;
    }

    /**
     * @param lokacija the lokacija to set
     */
    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }

    @Override
    public String nazivTabele() {
        return " zahtev_za_trazenje_psa ";
    }

    @Override
    public String alijas() {
          return " za ";
    }

    @Override
    public String join() {
       return " JOIN rasa r ON za.rasaId=r.rasaId "
               + "JOIN lokacija l ON za.lokacijaId=l.lokacijaId"
               + " JOIN korisnik k ON za.korisnikId=k.korisnikId ";
    }

    @Override
    public String selectWhere() {
        if(getZahtevZaTrazenjePsaId()!=-1){
         return " WHERE zahtevZaTrazenjePsaId="+getZahtevZaTrazenjePsaId()+" ";
        }
        if(getLokacija()!=null && getRasa()==null && getSacuvaoZahtev()==null){
            return " WHERE za.lokacijaId = "+getLokacija().getLokacijaId()+" ";
        }
        if(getLokacija()==null && getRasa()!=null && getSacuvaoZahtev()==null){
            return " WHERE za.rasaId = "+getRasa().getRasaId()+" ";
        }
        if(getLokacija()==null && getRasa()==null && getSacuvaoZahtev()!=null){
            return " WHERE za.korisnikId = "+getSacuvaoZahtev().getKorisnikId()+" ";
        }
        if(getLokacija()!=null && getRasa()!=null && getSacuvaoZahtev()==null){
            return  " WHERE za.lokacijaId = "+getLokacija().getLokacijaId()
                    + " AND za.rasaId = "+getRasa().getRasaId()+" ";
        }
        if(getLokacija()==null && getRasa()!=null && getSacuvaoZahtev()!=null){
            return  " WHERE za.korisnikId = "+getSacuvaoZahtev().getKorisnikId()
                    + " AND za.rasaId = "+getRasa().getRasaId()+" ";
        }
        if(getLokacija()!=null && getRasa()==null && getSacuvaoZahtev()!=null){
            return  " WHERE za.korisnikId = "+getSacuvaoZahtev().getKorisnikId()
                    + " AND za.lokacijaId = "+getLokacija().getLokacijaId()+" ";
        }
        return " ";
    }

    @Override
    public List<IOpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
         List<IOpstiDomenskiObjekat> lista=new ArrayList<>();
        while(rs.next()){
            Lokacija l=new Lokacija(rs.getLong("lokacijaId"),rs.getString("nazivLokacije"));
            Rasa r = new Rasa(rs.getLong("rasaId"), rs.getString("nazivRase"), rs.getString("slikaURLRase"));
            Korisnik k = new Korisnik(rs.getLong("k.korisnikId"),rs.getString("k.ime"),rs.getString("k.prezime"), 
                                      rs.getString("k.telefon"), rs.getString("k.email"), rs.getString("k.lozinka"));    
            ZahtevZaTrazenjePsa zztp=new ZahtevZaTrazenjePsa(rs.getInt("zahtevZaTrazenjePsaId"), 
                                        EnumPol.valueOf(rs.getString("polIzgubljenog")), 
                                        rs.getString("bojaIzgubljenog"), 
                                        new Date(rs.getTimestamp("vremeNestanka").getTime()), 
                                        rs.getString("kontaktVlasnika"), 
                                        new ImageIcon(rs.getString("slikaURLIzgubljenog")),
                                        rs.getInt("starost"),
                                        rs.getString("ime"), r, l,
                                        rs.getDouble("xKoordinata"), rs.getDouble("yKoordinata"),
                                        rs.getString("opisLokacije"),k);
            lista.add(zztp);
        }
        return lista;
        
    }

    @Override
    public String koloneInsert() {
        return "(polIzgubljenog, bojaIzgubljenog, vremeNestanka, kontaktVlasnika, slikaURLIzgubljenog, starost, ime, rasaId, lokacijaId, xKoordinata, yKoordinata, opisLokacije, korisnikId) ";
    }

    @Override
    public String vrednostPrimarniKljuc() {
        return " zahtevZaTrazenjePsaId="+getZahtevZaTrazenjePsaId();
    }

    @Override
    public String vrednostiInsert() {
       return "'"+getPol()+"','"
               +getBoja()+"','"
               +new java.sql.Timestamp((getVremeNestanka()).getTime())+"','"
               +getKontaktVlasnika()+"','"
               +getSlikaURL().getDescription()+"',"
               +getStarost()+",'"
               +getIme()+"', "
               +getRasa().getRasaId()+", "
               +getLokacija().getLokacijaId()+", "
               +getX()+", "
               +getY()+", '"
               +getOpis()+"', "
               +getSacuvaoZahtev().getKorisnikId()+" ";
               
    }

    @Override
    public String vrednostiUpdate() {
        return " polIzgubljenog='"+getPol()+"', bojaIzgubljenog='"
               +getBoja()+"',vremeNestanka='"
               +new java.sql.Timestamp((getVremeNestanka()).getTime())+"', kontaktVlasnika='"
               +getKontaktVlasnika()+"', slikaURLIzgubljenog='"
               +getSlikaURL().getDescription()+"', starost="
               +getStarost()+", ime='"
               +getIme()+"', rasaId="
               +getRasa().getRasaId()+", lokacijaId="
               +getLokacija().getLokacijaId()+ ", xKoordinata="
               +getX()+", yKoordinata="+getY()+", opisLokacije='"+getOpis()+"', korisnikId="
               +getSacuvaoZahtev().getKorisnikId()+" ";
    }

    @Override
    public String vratiMax() {
        return " zahtevZaTrazenjePsaId ";
    } 

    @Override
    public String toString() {
        return getIme()+"/"+getPol() + "/" + getBoja() + "/"+ getLokacija().getNaziv()+"/"+getRasa().getNaziv();
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
        final ZahtevZaTrazenjePsa other = (ZahtevZaTrazenjePsa) obj;
        if (this.getZahtevZaTrazenjePsaId() != other.getZahtevZaTrazenjePsaId()) {
            return false;
        }
        return true;
    }

    /**
     * @return the x
     */
    public double getX() {
        return x;
    }

    /**
     * @param x the x to set
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * @return the y
     */
    public double getY() {
        return y;
    }

    /**
     * @param y the y to set
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return the opis
     */
    public String getOpis() {
        return opis;
    }

    /**
     * @param opis the opis to set
     */
    public void setOpis(String opis) {
        this.opis = opis;
    }

    /**
     * @return the sacuvaoZahtev
     */
    public Korisnik getSacuvaoZahtev() {
        return sacuvaoZahtev;
    }

    /**
     * @param sacuvaoZahtev the sacuvaoZahtev to set
     */
    public void setSacuvaoZahtev(Korisnik sacuvaoZahtev) {
        this.sacuvaoZahtev = sacuvaoZahtev;
    }
    
}

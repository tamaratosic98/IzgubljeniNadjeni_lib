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
public class PrijavaPronalaskaPsa implements IOpstiDomenskiObjekat {
    //PrijavaPronalaskaPsaID, pol, boja, vremePronalaska, kontaktNalazaca, slikaURL, rasaID, lokacijaID)
    private long prijavaPronalaskaPsaId=-1;
    private EnumPol pol;
    private String boja;
    private Date vremePronalaska;
    private String  kontaktNalazaca;
    private ImageIcon slikaURL;
    private Rasa rasa;
    private Lokacija lokacija;
    private double x;
    private double y;
    private String opis;
    
    private Korisnik sacuvaoPronalazak;
    public PrijavaPronalaskaPsa() {
    }

    public PrijavaPronalaskaPsa(long prijavaPronalaskaPsaId,EnumPol pol, String boja, Date vremePronalaska, String kontaktNalazaca, ImageIcon slikaURL, Rasa rasa, Lokacija lokacija, double x, double y, String opis, Korisnik sacuvaoPronalazak) {
        this.prijavaPronalaskaPsaId=prijavaPronalaskaPsaId;
        this.pol = pol;
        this.boja = boja;
        this.vremePronalaska = vremePronalaska;
        this.kontaktNalazaca = kontaktNalazaca;
        this.slikaURL = slikaURL;
        this.rasa = rasa;
        this.lokacija = lokacija;
        this.x = x;
        this.y = y;
        this.opis = opis;
        this.sacuvaoPronalazak = sacuvaoPronalazak;
    }

    
    

    /**
     * @return the prijavaPronalaskaPsaId
     */
    public long getPrijavaPronalaskaPsaId() {
        return prijavaPronalaskaPsaId;
    }

    /**
     * @param prijavaPronalaskaPsaId the prijavaPronalaskaPsaId to set
     */
    public void setPrijavaPronalaskaPsaId(long prijavaPronalaskaPsaId) {
        this.prijavaPronalaskaPsaId = prijavaPronalaskaPsaId;
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
     * @return the vremePronalaska
     */
    public Date getVremePronalaska() {
        return vremePronalaska;
    }

    /**
     * @param vremePronalaska the vremePronalaska to set
     */
    public void setVremePronalaska(Date vremePronalaska) {
        this.vremePronalaska = vremePronalaska;
    }

    /**
     * @return the kontaktNalazaca
     */
    public String getKontaktNalazaca() {
        return kontaktNalazaca;
    }

    /**
     * @param kontaktNalazaca the kontaktNalazaca to set
     */
    public void setKontaktNalazaca(String kontaktNalazaca) {
        this.kontaktNalazaca = kontaktNalazaca;
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
        return " prijava_pronalaska_psa ";
    }

    @Override
    public String alijas() {
        return " pr ";
    }

    @Override
    public String join() {
       return " JOIN rasa r ON pr.rasaId=r.rasaId "
               + "JOIN lokacija l ON l.lokacijaId=pr.lokacijaId "
               + "JOIN korisnik k ON k.korisnikId=pr.korisnikId ";
    }

    @Override
    public String selectWhere() {
        if(getPrijavaPronalaskaPsaId()!=-1){
            //tada hocemo taj konkretan da ucitamo
         return " WHERE prijavaPronalaskaPsaId="+getPrijavaPronalaskaPsaId()+" ";//ucitaj prijavu pronalaska psa
        }
        if(getLokacija()!=null && getRasa()==null && getSacuvaoPronalazak()==null){
            return " WHERE pr.lokacijaId = "+getLokacija().getLokacijaId()+" ";
        }
        if(getLokacija()==null && getRasa()!=null && getSacuvaoPronalazak()==null){
            return " WHERE pr.rasaId = "+getRasa().getRasaId()+" ";
        }
        if(getLokacija()==null && getRasa()==null && getSacuvaoPronalazak()!=null){
            return " WHERE pr.korisnikId = "+getSacuvaoPronalazak().getKorisnikId()+" ";
        }
        if(getLokacija()!=null && getRasa()!=null && getSacuvaoPronalazak()==null){
            return  " WHERE pr.lokacijaId = "+getLokacija().getLokacijaId()
                    + " AND pr.rasaId = "+getRasa().getRasaId()+" ";
        }
        if(getLokacija()==null && getRasa()!=null && getSacuvaoPronalazak()!=null){
            return  " WHERE pr.korisnikId = "+getSacuvaoPronalazak().getKorisnikId()
                    + " AND pr.rasaId = "+getRasa().getRasaId()+" ";
        }
        if(getLokacija()!=null && getRasa()==null && getSacuvaoPronalazak()!=null){
            return  " WHERE pr.korisnikId = "+getSacuvaoPronalazak().getKorisnikId()
                    + " AND pr.lokacijaId = "+getLokacija().getLokacijaId()+" ";
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
            PrijavaPronalaskaPsa ppp=new PrijavaPronalaskaPsa(rs.getInt("prijavaPronalaskaPsaId"), 
                                    EnumPol.valueOf(rs.getString("polPronadjenog")), 
                                    rs.getString("bojaPronadjenog"), 
                                    new Date(rs.getTimestamp("vremePronalaska").getTime()), 
                                    rs.getString("kontaktNalazaca"), 
                                    new ImageIcon(rs.getString("slikaURLPronadjenog")), r, l, 
                                    rs.getDouble("xKoordinata"), rs.getDouble("yKoordinata"),
                                    rs.getString("opisLokacije"),k);
            lista.add(ppp);
        }
        return lista;
        
    }

    @Override
    public String koloneInsert() {
      return "(prijavaPronalaskaPsaId, polPronadjenog, bojaPronadjenog, vremePronalaska, kontaktNalazaca, slikaURLPronadjenog, rasaId, lokacijaId, xKoordinata, yKoordinata, opisLokacije, korisnikId) ";
    }

    @Override
    public String vrednostPrimarniKljuc() {
         return " prijavaPronalaskaPsaId="+getPrijavaPronalaskaPsaId();
    }

    @Override
    public String vrednostiInsert() {
          return getPrijavaPronalaskaPsaId()+", '"+getPol()+"','"
               +getBoja()+"','"
               + new java.sql.Timestamp((getVremePronalaska()).getTime())+"','"
               +getKontaktNalazaca()+"','"
               +getSlikaURL().getDescription()+"',"
               +getRasa().getRasaId()+","
               +getLokacija().getLokacijaId()+", "
               +getX()+", "
               +getY()+", '"
               +getOpis()+"', "
               +getSacuvaoPronalazak().getKorisnikId()+" ";
    }

    @Override
    public String vrednostiUpdate() {
        return " polPronadjenog='"+getPol()+"', bojaPronadjenog='"
               +getBoja()+"', vremePronalaska='"
               + new java.sql.Timestamp((getVremePronalaska()).getTime())+"', kontaktNalazaca='"
               +getKontaktNalazaca()+"', slikaURLPronadjenog='"
               +getSlikaURL().getDescription()+"', rasaId="
               +getRasa().getRasaId()+", lokacijaId="
               +getLokacija().getLokacijaId()
               +", xKoordinata="+getX()
               +", yKoordinata="+getY()
               +", opisLokacije='"+getOpis()+"', korisnikId="
               +getSacuvaoPronalazak().getKorisnikId()+" ";
    }

    @Override
    public String vratiMax() {
       return " prijavaPronalaskaPsaId ";
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final PrijavaPronalaskaPsa other = (PrijavaPronalaskaPsa) obj;
        if (this.getPrijavaPronalaskaPsaId() != other.getPrijavaPronalaskaPsaId()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getPol() + "/" + getBoja() + "/"+ getLokacija().getNaziv()+"/"+getRasa().getNaziv();
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
     * @return the sacuvaoPronalazak
     */
    public Korisnik getSacuvaoPronalazak() {
        return sacuvaoPronalazak;
    }

    /**
     * @param sacuvaoPronalazak the sacuvaoPronalazak to set
     */
    public void setSacuvaoPronalazak(Korisnik sacuvaoPronalazak) {
        this.sacuvaoPronalazak = sacuvaoPronalazak;
    }
    
    
}

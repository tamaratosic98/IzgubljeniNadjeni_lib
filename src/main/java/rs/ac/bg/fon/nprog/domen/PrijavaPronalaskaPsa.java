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
 * Klasa koja predstavlja prijavu pronalaska psa.
 * 
 * Prijava pronalaska psa ima prijavaPronalaskaPsaId kao long vrednost, pol kao Enum vrednost, boju, kontakt nalazaca i opis kao String vrednost,
 * vremePronalaska kao Date, slikaURL kao ImageIcon, lokacija kao Lokacija, rasa kao Rasa, x i y kao double vrednosti i sacuvaoPronalazak kao Korisnik.
 * 
 * @author tamara
 * @version 1.0
 */
public class PrijavaPronalaskaPsa implements IOpstiDomenskiObjekat {
    /**
     * Id prijave pronalaska psa kao long vrednost.
     */
    private long prijavaPronalaskaPsaId=-1;
    /**
     * Pol pronadjenog psa kao Enum vrednost.
     */
    private EnumPol pol;
    /**
     * Boja pronadjenog psa kao String vrednost.
     */
    private String boja;
    /**
     * Vreme pronalaska psa kao Date.
     */
    private Date vremePronalaska;
    /**
     * Kontakt pronalazaca psa kao String vrednost.
     */
    private String  kontaktNalazaca;
    /**
     * Slika pronadjenog psa kao ImageIcon.
     */
    private ImageIcon slikaURL;
    /**
     * Rasa pronadjenog psa kao Rasa.
     */
    private Rasa rasa;
    /**
     * Lokacija pronadjenog psa kao Lokacija.
     */
    private Lokacija lokacija;
    /**
     * X koordinata lokacije pronadjenog psa kao double vrednost.
     */
    private double x;
    /** 
     * Y koordinata lokacije pronadjenog psa kao double vrednost.
     */
    private double y;
    /**
     * Opis pronadjenog psa kao String vrednost.
     */
    private String opis;
    /**
     * Korisnik koji je sacuvao prijavu kao Korisnik.
     */
    private Korisnik sacuvaoPronalazak;
    
    /**
     * Konstruktor koji inicijalizuje objekat i nista vise.
     */
    public PrijavaPronalaskaPsa() {
    }
    /**
     * 
     * @param prijavaPronalaskaPsaId Id prijave pronalaska psa kao long vrednost.
     * @param pol Pol pronadjenog psa kao Enum vrednost.
     * @param boja Boja pronadjenog psa kao String vrednost.
     * @param vremePronalaska Vreme pronalaska psa kao Date.
     * @param kontaktNalazaca Kontakt pronalazaca psa kao String vrednost.
     * @param slikaURL Slika pronadjenog psa kao ImageIcon.
     * @param rasa Rasa pronadjenog psa kao Rasa.
     * @param lokacija Lokacija pronadjenog psa kao Lokacija.
     * @param x X koordinata lokacije pronadjenog psa kao double vrednost.
     * @param y Y koordinata lokacije pronadjenog psa kao double vrednost.
     * @param opis Opis pronadjenog psa kao String vrednost.
     * @param sacuvaoPronalazak Korisnik koji je sacuvao prijavu kao Korisnik.
     */

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
     * Vraca id prijave pronalaska psa.
     * 
     * @return Id prijave pronalaska psa kao long vrednost.
     */
    public long getPrijavaPronalaskaPsaId() {
        return prijavaPronalaskaPsaId;
    }

    /**
     * Postavlja id prijave pronalaska psa na novu vrednost.
     * 
     * @param prijavaPronalaskaPsaId Id prijave pronalaska psa kao long vrednost.
     */
    public void setPrijavaPronalaskaPsaId(long prijavaPronalaskaPsaId) {
        this.prijavaPronalaskaPsaId = prijavaPronalaskaPsaId;
    }

    /**
     * Vraca pol pronadjenog psa.
     * 
     * @return Pol pronadjenog psa kao Enum vrednost.
     */
    public EnumPol getPol() {
        return pol;
    }

    /**
     * Postavlja pol pronadjenog psa na novu vrednost.
     * 
     * @param pol Pol pronadjenog psa kao Enum vrednost.
     */
    public void setPol(EnumPol pol) {
    	if(pol==null) {
    		throw new NullPointerException("Pol ne sme biti null.");
    	}
        this.pol = pol;
    }

    /**
     * Vraca boju pronadjenog psa.
     * 
     * @return Boja pronadjenog psa kao String vrednost.
     */
    public String getBoja() {
        return boja;
    }

    /**
     * Postavlja boju pronadjenog psa na novu vrednost.
     * 
     * @param boja Boja pronadjenog psa kao String vrednost.
     */
    public void setBoja(String boja) {
        this.boja = boja;
    }

    /**
     * Vraca vreme pronalaska psa.
     * 
     * @return Vreme pronalaska psa kao Date.
     */
    public Date getVremePronalaska() {
        return vremePronalaska;
    }

    /**
     * Postavlja vreme pronalaska psa na novu vrednost.
     * 
     * @param vremePronalaska Vreme pronalaska psa kao Date.
     */
    public void setVremePronalaska(Date vremePronalaska) {
    	if(vremePronalaska==null) {
    		throw new NullPointerException("Vreme pronalaska ne sme biti null.");
    	}
        this.vremePronalaska = vremePronalaska;
    }

    /**
     * Vraca kontakt pronalazaca psa.
     * 
     * @return Kontakt pronalazaca psa kao String vrednost.
     */
    public String getKontaktNalazaca() {
        return kontaktNalazaca;
    }

    /**
     * Postavlja kontakt pronalazaca na novu vrednost.
     * 
     * @param kontaktNalazaca Kontakt pronalazaca psa kao String vrednost.
     */
    public void setKontaktNalazaca(String kontaktNalazaca) {
    	if(kontaktNalazaca==null) {
    		throw new NullPointerException("Kontakt nalazaca ne sme biti null.");
    	}
        this.kontaktNalazaca = kontaktNalazaca;
    }

    /**
     * Vraca sliku pronadjenog psa.
     * 
     * @return Slika pronadjenog psa kao ImageIcon.
     */
    public ImageIcon getSlikaURL() {
        return slikaURL;
    }

    /**
     * Postavlja sliku pronadjenog psa na novu vrednost.
     * 
     * @param slikaURL Slika pronadjenog psa kao ImageIcon.
     */
    public void setSlikaURL(ImageIcon slikaURL) {
        this.slikaURL = slikaURL;
    }

    /**
     * Vraca rasu pronadjenog psa.
     * 
     * @return Rasa pronadjenog psa kao Rasa.
     */
    public Rasa getRasa() {
        return rasa;
    }

    /**
     * Postavlja rasu pronadjenog psa na novu vrednost.
     * 
     * @param rasa Rasa pronadjenog psa kao Rasa.
     */
    public void setRasa(Rasa rasa) {
    	if(rasa==null) {
    		throw new NullPointerException("Rasa ne sme biti null.");
    	}
        this.rasa = rasa;
    }

    /**
     * Vraca lokaciju pronadjenog psa.
     * 
     * @return Lokacija pronadjenog psa kao Lokacija.
     */
    public Lokacija getLokacija() {
        return lokacija;
    }

    /**
     * Postavlja lokaciju pronadjenog psa na novu vrednost.
     * 
     * @param lokacija Lokacija pronadjenog psa kao Lokacija.
     */
    public void setLokacija(Lokacija lokacija) {
    	if(lokacija==null) {
    		throw new NullPointerException("Lokacija ne sme biti null.");
    	}
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
     * Vraca x koordinatu lokacije pronadjenog psa.
     * 
     * @return X koordinata lokacije pronadjenog psa kao double vrednost.
     */
    public double getX() {
        return x;
    }

    /**
     * Postavlja x koordinatu lokacije pronadjenog psa na novu vrednost.
     * 
     * @param x X koordinata lokacije pronadjenog psa kao double vrednost.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Vraca y koordinatu lokacije pronadjnog psa.
     * 
     * @return Y koordinata lokacije pronadjenog psa kao double vrednost.
     */
    public double getY() {
        return y;
    }

    /**
     * Postavlja y koordinatu lokacije pronadjnog psa na novu vrednost.
     * 
     * @param y Y koordinata lokacije pronadjenog psa kao double vrednost.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Vraca opis pronadjenog psa.
     * 
     * @return Opis pronadjenog psa kao String vrednost.
     */
    public String getOpis() {
        return opis;
    }

    /**
     * Postavlja opis pronadjenog psa na novu vrednost.
     * 
     * @param opis Opis pronadjenog psa kao String vrednost.
     */
    public void setOpis(String opis) {
        this.opis = opis;
    }

    /**
     * Vraca korisnika koji je sacuvao prijavu.
     * 
     * @return Korisnik koji je sacuvao prijavu kao Korisnik.
     */
    public Korisnik getSacuvaoPronalazak() {
        return sacuvaoPronalazak;
    }

    /**
     * Postavlja korisnika koji je sacuvao prijavu na novu vrednost.
     * 
     * @param sacuvaoPronalazak Korisnik koji je sacuvao prijavu kao Korisnik.
     */
    public void setSacuvaoPronalazak(Korisnik sacuvaoPronalazak) {
        this.sacuvaoPronalazak = sacuvaoPronalazak;
    }
    
    
}

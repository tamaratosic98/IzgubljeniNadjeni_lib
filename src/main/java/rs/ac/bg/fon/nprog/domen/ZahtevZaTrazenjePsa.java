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
 * Klasa koja predstavlja zahtev za trazenje izgubljenog psa.
 * 
 * Zahtev za trazenje izgubljenog psa ima zahtevZaTrazenjePsaId kao long vrednost, pol kao Enum vrednost, boju, kontaktVlasnika, ime i opis kao String vrednost,
 * vremeNestanka kao Date, slikaURL kao ImageIcon, lokacija kao Lokacija, rasa kao Rasa, x i y kao double vrednosti, sacuvaoZahtev kao Korisnik i starost kao int vrednost.
 *
 * @author tamara
 */
public class ZahtevZaTrazenjePsa implements IOpstiDomenskiObjekat{
	/**
	 * Id zahteva za trazenje psa kao long vrednost.
	 */
    private long zahtevZaTrazenjePsaId=-1;
    /**
     * Pol izgubljenog psa kao Enum vrednost.
     */
    private EnumPol pol;
    /**
     * Boja izgubljenog psa kao String vrednost.
     */
    private String boja;
    /**
     * Vreme nestanka psa kao Date.
     */
    private Date vremeNestanka;
    /**
     * Kontakt vlasnika psa kao String vrednost.
     */
    private String kontaktVlasnika;
    /**
     * Slika izgubljenog psa kao ImageIcon.
     */
    private ImageIcon slikaURL;
    /**
     * Starost izgubljenog psa kao int vrednost.
     */
    private int starost;
    /**
     * Ime izgubljenog psa kao String vrednost.
     */
    private String ime;
    /**
     * Rasa izgubljenog psa kao Rasa.
     */
    private Rasa rasa;
    /**
     * Lokacija izgubljenog psa kao Lokacija.
     */
    private Lokacija lokacija;
    /**
     * X koordinata lokacije izgubljenog psa kao double vrednost.
     */
    private double x;
    /**
     * Y koordinata lokacije izgubljenog psa kao double vrednost.
     */
    private double y;
    /**
     * Opis izgubljenog psa kao String vrednost.
     */
    private String opis;
    /**
     * Korisnik koji je sacuvao zahtev kao Korisnik.
     */
    private Korisnik sacuvaoZahtev;
    /**
     * Konstruktor koji inicijalizuje objekat i nista vise.
     */
    public ZahtevZaTrazenjePsa() {
    }
    /**
     * 
     * @param zahtevZaTrazenjePsaId Id zahteva za trazenje psa kao long vrednost.
     * @param pol Pol izgubljenog psa kao Enum vrednost.
     * @param boja Boja izgubljenog psa kao String vrednost.
     * @param vremeNestanka Vreme nestanka psa kao Date.
     * @param kontaktVlasnika Kontakt vlasnika psa kao String vrednost.
     * @param slikaURL Slika izgubljenog psa kao ImageIcon.
     * @param starost Starost izgubljenog psa kao int vrednost.
     * @param ime Ime izgubljenog psa kao String vrednost.
     * @param rasa Rasa izgubljenog psa kao Rasa.
     * @param lokacija Lokacija izgubljenog psa kao Lokacija.
     * @param x X koordinata lokacije izgubljenog psa kao double vrednost.
     * @param y Y koordinata lokacije izgubljenog psa kao double vrednost.
     * @param opis Opis izgubljenog psa kao String vrednost.
     * @param sacuvaoZahtev Korisnik koji je sacuvao zahtev kao Korisnik.
     */
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
     * Vraca Id zahteva za trazenje psa.
     * 
     * @return Id zahteva za trazenje psa kao long vrednost.
     */
    public long getZahtevZaTrazenjePsaId() {
        return zahtevZaTrazenjePsaId;
    }

    /**
     * Postavlja Id zahteva za trazenje psa na novu vrednost.
     * 
     * @param zahtevZaTrazenjePsaId Id zahteva za trazenje psa kao long vrednost.
     */
    public void setZahtevZaTrazenjePsaId(long zahtevZaTrazenjePsaId) {
        this.zahtevZaTrazenjePsaId = zahtevZaTrazenjePsaId;
    }

    /**
     * Vraca pol izgubljenog psa.
     * 
     * @return Pol izgubljenog psa kao Enum vrednost.
     */
    public EnumPol getPol() {
    	
        return pol;
    }

    /**
     * Postavlja pol izgubljenog psa na novu vrednost.
     * 
     * @param pol Pol izgubljenog psa kao Enum vrednost.
     */
    public void setPol(EnumPol pol) {
    	if(pol==null) {
    		throw new NullPointerException("Pol ne sme biti null.");
    	}
        this.pol = pol;
    }

    /**
     * Vraca boju izgubljenog psa.
     * 
     * @return Boja izgubljenog psa kao String vrednost.
     */
    public String getBoja() {
        return boja;
    }

    /**
     * Postavlja boju izgubljenog psa na novu vrednost.
     * 
     * @param boja Boja izgubljenog psa kao String vrednost.
     */
    public void setBoja(String boja) {
        this.boja = boja;
    }

    /**
     * Vraca vreme nestanka psa.
     * 
     * @return Vreme nestanka psa kao Date.
     */
    public Date getVremeNestanka() {
        return vremeNestanka;
    }

    /**
     * Postavlja vreme nestanka psa na novu vrednost.
     * 
     * @param vremeNestanka Vreme nestanka psa kao Date.
     */
    public void setVremeNestanka(Date vremeNestanka) {
    	if(vremeNestanka==null) {
    		throw new NullPointerException("Vreme nestanka ne sme biti null.");
    	}
        this.vremeNestanka = vremeNestanka;
    }

    /**
     * Vraca kontakt vlasnika izgubljenog psa.
     * 
     * @return Kontakt vlasnika psa kao String vrednost.
     */
    public String getKontaktVlasnika() {
        return kontaktVlasnika;
    }

    /**
     * Postavlja kontakt vlasnika izgubljenog psa na novu vrednost.
     * 
     * @param kontaktVlasnika Kontakt vlasnika psa kao String vrednost.
     */
    public void setKontaktVlasnika(String kontaktVlasnika) {
    	if(kontaktVlasnika==null) {
    		throw new NullPointerException("Kontakt vlasnika ne sme biti null.");
    	}
        this.kontaktVlasnika = kontaktVlasnika;
    }

    /**
     * Vraca sliku izgubljenog psa.
     * 
     * @return Slika izgubljenog psa kao ImageIcon.
     */
    public ImageIcon getSlikaURL() {
        return slikaURL;
    }

    /**
     * Postavlja sliku izgubljenog psa na novu vrednost.
     * 
     * @param slikaURL Slika izgubljenog psa kao ImageIcon.
     */
    public void setSlikaURL(ImageIcon slikaURL) {
        this.slikaURL = slikaURL;
    }

    /**
     * Vraca starost izgubljenog psa.
     * 
     * @return Starost izgubljenog psa kao int vrednost.
     */
    public int getStarost() {
        return starost;
    }

    /**
     * Postavlja starost izgubljenog psa na novu vrednost.
     * 
     * @param starost Starost izgubljenog psa kao int vrednost.
     */
    public void setStarost(int starost) {
        this.starost = starost;
    }

    /**
     * Vraca ime izgubljenog psa.
     * 
     * @return Ime izgubljenog psa kao String vrednost.
     */
    public String getIme() {
        return ime;
    }

    /**
     * Postavlja ime izgubljenog psa na novu vrednost.
     * 
     * @param ime Ime izgubljenog psa kao String vrednost.
     */
    public void setIme(String ime) {
        this.ime = ime;
    }

    /**
     * Vraca rasu izgubljenog psa.
     * 
     * @return Rasa izgubljenog psa kao Rasa.
     */
    public Rasa getRasa() {
        return rasa;
    }

    /**
     * Postavlja rasu izgubljenog psa na novu vrednost.
     * 
     * @param rasa Rasa izgubljenog psa kao Rasa.
     */
    public void setRasa(Rasa rasa) {
    	if(rasa==null) {
    		throw new NullPointerException("Rasa ne sme biti null.");
    	}
        this.rasa = rasa;
    }

    /**
     * Vraca lokaciju izgubljenog psa.
     * 
     * @return Lokacija izgubljenog psa kao Lokacija.
     */
    public Lokacija getLokacija() {
    	
        return lokacija;
    }

    /**
     * Postavlja lokaciju izgubljeno psa na novu vrednost.
     * 
     * @param lokacija Lokacija izgubljenog psa kao Lokacija.
     */
    public void setLokacija(Lokacija lokacija) {
    	if(lokacija==null) {
    		throw new NullPointerException("Lokacija ne sme biti null.");
    	}
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
            Lokacija l=new Lokacija();
            l.setLokacijaId(rs.getLong("lokacijaId"));
            if(rs.getString("nazivLokacije")!=null) {
            	l.setNaziv(rs.getString("nazivLokacije"));
            }
            Rasa r = new Rasa();
            r.setRasaId(rs.getLong("rasaId"));
            if(rs.getString("nazivRase")!=null) {
            	r.setNaziv(rs.getString("nazivRase"));
            }
            
            r.setSlikaURL(rs.getString("slikaURLRase"));
            Korisnik k = new Korisnik(rs.getLong("k.korisnikId"),rs.getString("k.ime"),rs.getString("k.prezime"), 
                                      rs.getString("k.telefon"), rs.getString("k.email"), rs.getString("k.lozinka"));    
            ZahtevZaTrazenjePsa zztp=new ZahtevZaTrazenjePsa();
            zztp.setZahtevZaTrazenjePsaId(rs.getInt("zahtevZaTrazenjePsaId"));
            if(rs.getString("polIzgubljenog")!=null) {
            	zztp.setPol(EnumPol.valueOf(rs.getString("polIzgubljenog")));
            }
            zztp.setBoja(rs.getString("bojaIzgubljenog"));
            if(rs.getTimestamp("vremeNestanka")!=null) {
            	zztp.setVremeNestanka(new Date(rs.getTimestamp("vremeNestanka").getTime()));
            }
            if(rs.getString("kontaktVlasnika")!=null) {
            	zztp.setKontaktVlasnika(rs.getString("kontaktVlasnika"));
            }
            zztp.setSlikaURL(new ImageIcon(rs.getString("slikaURLIzgubljenog")));
            zztp.setStarost( rs.getInt("starost"));
            zztp.setIme( rs.getString("ime"));
            if(r!=null) {
            	zztp.setRasa(r);
            }
            if(l!=null) {
            	zztp.setLokacija(l);
            }
            zztp.setX(rs.getDouble("xKoordinata"));
            zztp.setY(rs.getDouble("yKoordinata"));
            zztp.setOpis(rs.getString("opisLokacije"));
            zztp.setSacuvaoZahtev(k);
            
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
    	if(this!=null && getSlikaURL()!=null && getRasa()!=null && getLokacija()!=null && getSacuvaoZahtev()!=null && getVremeNestanka()!=null && getPol()!=null) {
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
    	}else {
    		return "";
    	}
               
    }

    @Override
    public String vrednostiUpdate() {
    	if(this!=null && getSlikaURL()!=null && getRasa()!=null && getLokacija()!=null && getSacuvaoZahtev()!=null && getVremeNestanka()!=null && getPol()!=null) {
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
    	}else {
    		return "";
    	}
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
     * Vraca x koordinatu lokacije izgubljenog psa.
     * 
     * @return X koordinata lokacije izgubljenog psa kao double vrednost.
     */
    public double getX() {
        return x;
    }

    /**
     * Postavlja x koordinatu lokacije izgubljenog psa na novu vrednost.
     * 
     * @param x X koordinata lokacije izgubljenog psa kao double vrednost.
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Vraca y koordinatu lokacije izgubljenog psa.
     * 
     * @return Y koordinata lokacije izgubljenog psa kao double vrednost.
     */
    public double getY() {
        return y;
    }

    /**
     * Postavlja y koordinatu lokacije izgubljenog psa na novu vrednost.
     * 
     * @param y Y koordinata lokacije izgubljenog psa kao double vrednost.
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Vraca opis izgubljenog psa.
     * 
     * @return Opis izgubljenog psa kao String vrednost.
     */
    public String getOpis() {
        return opis;
    }

    /**
     * Postavlja opis izgubljenog psa na novu vrednost.
     * 
     * @param opis Opis izgubljenog psa kao String vrednost.
     */
    public void setOpis(String opis) {
        this.opis = opis;
    }

    /**
     * Vraca korisnika koji je sacuvao zahtev.
     * 
     * @return Korisnik koji je sacuvao zahtev kao Korisnik.
     */
    public Korisnik getSacuvaoZahtev() {
        return sacuvaoZahtev;
    }

    /**
     * Postavlja korisnika koji je sacuvao zahtev na novu vrednost.
     * 
     * @param sacuvaoZahtev Korisnik koji je sacuvao zahtev kao Korisnik.
     */
    public void setSacuvaoZahtev(Korisnik sacuvaoZahtev) {
        this.sacuvaoZahtev = sacuvaoZahtev;
    }
    
}

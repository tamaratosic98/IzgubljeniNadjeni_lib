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
import java.util.Objects;
import javax.swing.ImageIcon;

/**
 * Klasa koja predstavlja resen slucaj izgubljenog psa.
 * 
 * Pronalazak ima prijavaPronalaskaPsa kao PrijavaPronalaskaPsa, zahtevZaTrazenjePsa kao ZahtevZaTrazenjePsa,
 * datumResavanjaSlucaja kao Date i napomena kao String vrednost.
 *
 * @author tamara
 * @version 1.0
 */
public class Pronalazak implements IOpstiDomenskiObjekat {
	/**
	 * Prijava pronalaska psa kao PrijavaPronalaskaPsa.
	 */
    private PrijavaPronalaskaPsa prijavaPronalaskaPsa;
    /**
     * Zahtev za trazenje psa kao ZahtevZaTrazenjePsa.
     */
    private ZahtevZaTrazenjePsa zahtevZaTrazenjePsa;
    /**
     * Datum resavanja slucaja kao Date.
     */
    private Date datumResavanjaSlucaja;
    /**
     * Napomena kao String vrednost.
     */
    private String napomena;
    /**
     * Konstruktor koji inicijalizuje objekat i nista vise.
     */

    public Pronalazak() {
    }
    /**
     * Konstruktor koji inicijalizuje objekat i postavlja vrednosti prijavaPronalaskaPsa, zahtevZaTrazenjePsa, datumResavanjaSlucaja i napomena na nove vrednosti.
     * 
     * @param prijavaPronalaskaPsa Prijava pronalaska psa kao PrijavaPronalaskaPsa.
     * @param zahtevZaTrazenjePsa Zahtev za trazenje psa kao ZahtevZaTrazenjePsa.
     * @param datumResavanjaSlucaja Datum resavanja slucaja kao Date.
     * @param napomena Napomena kao String vrednost.
     */

    public Pronalazak(PrijavaPronalaskaPsa prijavaPronalaskaPsa, ZahtevZaTrazenjePsa zahtevZaTrazenjePsa, Date datumResavanjaSlucaja, String napomena) {
        this.prijavaPronalaskaPsa = prijavaPronalaskaPsa;
        this.zahtevZaTrazenjePsa = zahtevZaTrazenjePsa;
        this.datumResavanjaSlucaja = datumResavanjaSlucaja;
        this.napomena = napomena;
    }

    /**
     * Vraca prijavu pronalaska psa.
     * 
     * @return Prijava pronalaska psa kao PrijavaPronalaskaPsa.
     */
    public PrijavaPronalaskaPsa getPrijavaPronalaskaPsa() {
        return prijavaPronalaskaPsa;
    }

    /**
     * Postavlja prijavu pronalaska psa na novu vrednost.
     * 
     * @param prijavaPronalaskaPsa Prijava pronalaska psa kao PrijavaPronalaskaPsa.
     */
    public void setPrijavaPronalaskaPsa(PrijavaPronalaskaPsa prijavaPronalaskaPsa) {
    	if(prijavaPronalaskaPsa==null) {
    		throw new NullPointerException("Prijava ne sme biti null.");
    	}
        this.prijavaPronalaskaPsa = prijavaPronalaskaPsa;
    }

    /**
     * Vraca zahtev za trazenje psa.
     * 
     * @return Zahtev za trazenje psa kao ZahtevZaTrazenjePsa.
     */
    public ZahtevZaTrazenjePsa getZahtevZaTrazenjePsa() {
        return zahtevZaTrazenjePsa;
    }

    /**
     * Postavlja zahtev za trazenje psa na novu vrednost.
     * 
     * @param zahtevZaTrazenjePsa Zahtev za trazenje psa kao ZahtevZaTrazenjePsa.
     */
    public void setZahtevZaTrazenjePsa(ZahtevZaTrazenjePsa zahtevZaTrazenjePsa) {
    	if(zahtevZaTrazenjePsa==null) {
    		throw new NullPointerException("Zahtev ne sme biti null.");
    	}
        this.zahtevZaTrazenjePsa = zahtevZaTrazenjePsa;
    }

    /**
     * Vraca datum resavanja slucaja.
     * 
     * @return Datum resavanja slucaja kao Date.
     */
    public Date getDatumResavanjaSlucaja() {
        return datumResavanjaSlucaja;
    }

    /**
     * Postavlja datum resavanja slucaja na novu vrednost.
     * 
     * @param datumResavanjaSlucaja Datum resavanja slucaja kao Date.
     */
    public void setDatumResavanjaSlucaja(Date datumResavanjaSlucaja) {
        this.datumResavanjaSlucaja = datumResavanjaSlucaja;
    }

    /**
     * Vraca napomenu.
     * 
     * @return  Napomena kao String vrednost.
     */
    public String getNapomena() {
        return napomena;
    }

    /**
     * Postavlja napomenu na novu vrednost.
     * 
     * @param napomena  Napomena kao String vrednost.
     */
    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    @Override
    public String nazivTabele() {
        return " pronalazak ";
    }

    @Override
    public String alijas() {
          return " p ";
    }

    @Override
    public String join() {
          return "JOIN prijava_pronalaska_psa pr ON p.prijavaPronalaskaPsaId=pr.prijavaPronalaskaPsaId "+
                 " JOIN zahtev_za_trazenje_psa za ON p.zahtevZaTrazenjePsaId=za.zahtevZaTrazenjePsaId "+ 
                 " JOIN lokacija l ON l.lokacijaId=pr.lokacijaId JOIN lokacija l2 ON za.lokacijaId=l2.lokacijaId "+
                 " JOIN rasa r ON r.rasaId=pr.rasaId JOIN rasa r2 ON za.rasaId=r2.rasaId "+
                  " JOIN korisnik k ON k.korisnikId=pr.korisnikId JOIN korisnik k2 ON za.korisnikId=k2.korisnikId ";
          
  
    }
//za pretragu kad imamo one filtere na gui
    @Override
    public String selectWhere() {
        if(zahtevZaTrazenjePsa!=null && prijavaPronalaskaPsa!=null){
         return " WHERE p.zahtevZaTrazenjePsaId=" + zahtevZaTrazenjePsa.getZahtevZaTrazenjePsaId() + " AND p.prijavaPronalaskaPsaId=" + prijavaPronalaskaPsa.getPrijavaPronalaskaPsaId() + " ";
        }
        if(datumResavanjaSlucaja!=null){
            return " WHERE p.datumResavanjaSlucaja='"+new java.sql.Date(datumResavanjaSlucaja.getTime())+"' ";
        }
        return " ";
    }

    @Override
    public List<IOpstiDomenskiObjekat> ucitajListu(ResultSet rs) throws SQLException {
        List<IOpstiDomenskiObjekat> lista=new ArrayList<>();
        while(rs.next()){
        	Lokacija lpr=new Lokacija();
        	lpr.setLokacijaId(rs.getLong("l.lokacijaId"));
        	if(rs.getString("l.nazivLokacije")!=null) {
        		lpr.setNaziv(rs.getString("l.nazivLokacije"));
        	}
        	Rasa rpr=new Rasa();
        	rpr.setRasaId(rs.getLong("r.rasaId"));
        	rpr.setSlikaURL(rs.getString("r.slikaURLRase"));
        	if(rs.getString("r.nazivRase")!=null) {
        		rpr.setNaziv(rs.getString("r.nazivRase"));
        	}
            Lokacija lza=new Lokacija(rs.getLong("l2.lokacijaId"),rs.getString("l2.nazivLokacije"));
            Rasa rza = new Rasa(rs.getLong("r2.rasaId"), rs.getString("r2.nazivRase"), rs.getString("r2.slikaURLRase"));
            Korisnik kpr = new Korisnik(rs.getLong("k.korisnikId"),rs.getString("k.ime"),rs.getString("k.prezime"), 
                                      rs.getString("k.telefon"), rs.getString("k.email"), rs.getString("k.lozinka")); 
            Korisnik kza = new Korisnik(rs.getLong("k2.korisnikId"),rs.getString("k2.ime"),rs.getString("k2.prezime"), 
                                      rs.getString("k2.telefon"), rs.getString("k2.email"), rs.getString("k2.lozinka")); 
//            PrijavaPronalaskaPsa ppp=new PrijavaPronalaskaPsa(rs.getInt("pr.prijavaPronalaskaPsaId"), 
//                                        EnumPol.valueOf(rs.getString("pr.polPronadjenog")), 
//                                        rs.getString("pr.bojaPronadjenog"), 
//                                        new Date(rs.getTimestamp("pr.vremePronalaska").getTime()), 
//                                        rs.getString("pr.kontaktNalazaca"), 
//                                        new ImageIcon(rs.getString("pr.slikaURLPronadjenog")), rpr, lpr,
//                                        rs.getDouble("za.xKoordinata"),
//                                        rs.getDouble("za.yKoordinata"), rs.getString("za.opisLokacije"),kpr);
//            
            
            PrijavaPronalaskaPsa ppp=new PrijavaPronalaskaPsa();
            ppp.setPrijavaPronalaskaPsaId(rs.getInt("pr.prijavaPronalaskaPsaId"));
            if(rs.getString("pr.polPronadjenog")!=null) {
            	 ppp.setPol(EnumPol.valueOf(rs.getString("pr.polPronadjenog")));
            }
            ppp.setBoja(rs.getString("pr.bojaPronadjenog"));
            if(rs.getTimestamp("pr.vremePronalaska")!=null) {
            	ppp.setVremePronalaska(new Date(rs.getTimestamp("pr.vremePronalaska").getTime()));
            }
            if(rs.getString("pr.kontaktNalazaca")!=null) {
            	 ppp.setKontaktNalazaca(rs.getString("pr.kontaktNalazaca"));
            }
            ppp.setSlikaURL( new ImageIcon(rs.getString("pr.slikaURLPronadjenog")));
            if(rpr!=null) {
            	ppp.setRasa(rpr);
            }
            if(lpr!=null) {
            	ppp.setLokacija(lpr);
            }
            
            ppp.setX(rs.getDouble("pr.xKoordinata"));
            ppp.setY(rs.getDouble("pr.yKoordinata"));
            ppp.setOpis(rs.getString("pr.opisLokacije"));
            ppp.setSacuvaoPronalazak(kpr);
            
            
            
//            ZahtevZaTrazenjePsa zztp=new ZahtevZaTrazenjePsa(rs.getInt("za.zahtevZaTrazenjePsaId"), 
//                                        EnumPol.valueOf(rs.getString("za.polIzgubljenog")), 
//                                        rs.getString("za.bojaIzgubljenog"), 
//                                        new Date(rs.getTimestamp("za.vremeNestanka").getTime()), 
//                                        rs.getString("za.kontaktVlasnika"), 
//                                        new ImageIcon(rs.getString("za.slikaURLIzgubljenog")),
//                                        rs.getInt("za.starost"),
//                                        rs.getString("za.ime"), rza, lza, rs.getDouble("za.xKoordinata"),
//                                        rs.getDouble("za.yKoordinata"), rs.getString("za.opisLokacije"), kza);
            
            
            ZahtevZaTrazenjePsa zztp=new ZahtevZaTrazenjePsa();
            zztp.setZahtevZaTrazenjePsaId(rs.getInt("za.zahtevZaTrazenjePsaId"));
            if(rs.getString("za.polIzgubljenog")!=null) {
            	zztp.setPol(EnumPol.valueOf(rs.getString("za.polIzgubljenog")));
            }
            zztp.setBoja(rs.getString("za.bojaIzgubljenog"));
            if(rs.getTimestamp("za.vremeNestanka")!=null) {
            	zztp.setVremeNestanka(new Date(rs.getTimestamp("za.vremeNestanka").getTime()));
            }
            if(rs.getString("za.kontaktVlasnika")!=null) {
            	zztp.setKontaktVlasnika(rs.getString("za.kontaktVlasnika"));
            }
            zztp.setSlikaURL(new ImageIcon(rs.getString("za.slikaURLIzgubljenog")));
            zztp.setStarost( rs.getInt("za.starost"));
            zztp.setIme( rs.getString("za.ime"));
            if(rza!=null) {
            	zztp.setRasa(rza);
            }
            if(lza!=null) {
            	zztp.setLokacija(lza);
            }
            zztp.setX(rs.getDouble("za.xKoordinata"));
            zztp.setY(rs.getDouble("za.yKoordinata"));
            zztp.setOpis(rs.getString("za.opisLokacije"));
            zztp.setSacuvaoZahtev(kza);
            
            
            
            
            
            
            
            Pronalazak p = new Pronalazak();
            if(ppp!=null) {
            	p.setPrijavaPronalaskaPsa(ppp);
            }
            if(zztp!=null) {
            	p.setZahtevZaTrazenjePsa(zztp);
            }
            if(rs.getDate("datumResavanjaSlucaja")!=null) {
            	  p.setDatumResavanjaSlucaja(new Date(rs.getDate("datumResavanjaSlucaja").getTime()));
            }
            p.setNapomena(rs.getString("napomena"));
            lista.add(p);
            
        }
        return lista;
        
    }

    @Override
    public String koloneInsert() {
       return "(prijavaPronalaskaPsaId, zahtevZaTrazenjePsaId, datumResavanjaSlucaja, napomena)";
    }

    @Override
    public String vrednostPrimarniKljuc() {
    	if(prijavaPronalaskaPsa!=null && zahtevZaTrazenjePsa!=null) {
	        return " prijavaPronalaskaPsaId="+prijavaPronalaskaPsa.getPrijavaPronalaskaPsaId()+
	                " AND zahtevZaTrazenjePsaId="+zahtevZaTrazenjePsa.getZahtevZaTrazenjePsaId();
    	}else {
    		return "";
    	}
	}

    @Override
    public String vrednostiInsert() {
    	if(prijavaPronalaskaPsa!=null && zahtevZaTrazenjePsa!=null) {
	        return prijavaPronalaskaPsa.getPrijavaPronalaskaPsaId()+","
	                +zahtevZaTrazenjePsa.getZahtevZaTrazenjePsaId()+ ",'"
	                +new java.sql.Date(datumResavanjaSlucaja.getTime())
	                +"','"+napomena+"'";
    	}else {
    		return "";
    	}
    }

    @Override
    public String vrednostiUpdate() {
          //return " prijavaPronalaskaPsaId="+prijavaPronalaskaPsa.getPrijavaPronalaskaPsaId()+", zahtevZaTrazenjePsaId="+zahtevZaTrazenjePsa.getZahtevZaTrazenjePsaId()
    	if(prijavaPronalaskaPsa!=null && zahtevZaTrazenjePsa!=null) {
    		return  " datumResavanjaSlucaja='"+new java.sql.Date((datumResavanjaSlucaja).getTime())+"', napomena='"+napomena+"' ";
    	}else {
    		return "";
    	}
    }

    @Override
    public String vratiMax() {
        return " prijavaPronalaskaPsaId, zahtevZaTrazenjePsaId ";
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
        final Pronalazak other = (Pronalazak) obj;
        if (!Objects.equals(this.prijavaPronalaskaPsa, other.prijavaPronalaskaPsa)) {
            return false;
        }
        if (!Objects.equals(this.zahtevZaTrazenjePsa, other.zahtevZaTrazenjePsa)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pronalazak{" + "prijavaPronalaskaPsa=" + prijavaPronalaskaPsa + ", zahtevZaTrazenjePsa=" + zahtevZaTrazenjePsa + ", datumResavanjaSlucaja=" + datumResavanjaSlucaja + ", napomena=" + napomena + '}';
    }
    
    
}

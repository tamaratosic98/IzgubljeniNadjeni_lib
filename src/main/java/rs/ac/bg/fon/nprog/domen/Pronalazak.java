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
 *
 * @author tamara
 */
public class Pronalazak implements IOpstiDomenskiObjekat {
    private PrijavaPronalaskaPsa prijavaPronalaskaPsa;
    private ZahtevZaTrazenjePsa zahtevZaTrazenjePsa;
    private Date datumResavanjaSlucaja;
    private String napomena;

    public Pronalazak() {
    }

    public Pronalazak(PrijavaPronalaskaPsa prijavaPronalaskaPsa, ZahtevZaTrazenjePsa zahtevZaTrazenjePsa, Date datumResavanjaSlucaja, String napomena) {
        this.prijavaPronalaskaPsa = prijavaPronalaskaPsa;
        this.zahtevZaTrazenjePsa = zahtevZaTrazenjePsa;
        this.datumResavanjaSlucaja = datumResavanjaSlucaja;
        this.napomena = napomena;
    }

    /**
     * @return the prijavaPronalaskaPsa
     */
    public PrijavaPronalaskaPsa getPrijavaPronalaskaPsa() {
        return prijavaPronalaskaPsa;
    }

    /**
     * @param prijavaPronalaskaPsa the prijavaPronalaskaPsa to set
     */
    public void setPrijavaPronalaskaPsa(PrijavaPronalaskaPsa prijavaPronalaskaPsa) {
        this.prijavaPronalaskaPsa = prijavaPronalaskaPsa;
    }

    /**
     * @return the zahtevZaTrazenjePsa
     */
    public ZahtevZaTrazenjePsa getZahtevZaTrazenjePsa() {
        return zahtevZaTrazenjePsa;
    }

    /**
     * @param zahtevZaTrazenjePsa the zahtevZaTrazenjePsa to set
     */
    public void setZahtevZaTrazenjePsa(ZahtevZaTrazenjePsa zahtevZaTrazenjePsa) {
        this.zahtevZaTrazenjePsa = zahtevZaTrazenjePsa;
    }

    /**
     * @return the datumResavanjaSlucaja
     */
    public Date getDatumResavanjaSlucaja() {
        return datumResavanjaSlucaja;
    }

    /**
     * @param datumResavanjaSlucaja the datumResavanjaSlucaja to set
     */
    public void setDatumResavanjaSlucaja(Date datumResavanjaSlucaja) {
        this.datumResavanjaSlucaja = datumResavanjaSlucaja;
    }

    /**
     * @return the napomena
     */
    public String getNapomena() {
        return napomena;
    }

    /**
     * @param napomena the napomena to set
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
            Lokacija lpr=new Lokacija(rs.getLong("l.lokacijaId"),rs.getString("l.nazivLokacije"));
            Rasa rpr = new Rasa(rs.getLong("r.rasaId"), rs.getString("r.nazivRase"), rs.getString("r.slikaURLRase"));
            Lokacija lza=new Lokacija(rs.getLong("l2.lokacijaId"),rs.getString("l2.nazivLokacije"));
            Rasa rza = new Rasa(rs.getLong("r2.rasaId"), rs.getString("r2.nazivRase"), rs.getString("r2.slikaURLRase"));
            Korisnik kpr = new Korisnik(rs.getLong("k.korisnikId"),rs.getString("k.ime"),rs.getString("k.prezime"), 
                                      rs.getString("k.telefon"), rs.getString("k.email"), rs.getString("k.lozinka")); 
            Korisnik kza = new Korisnik(rs.getLong("k2.korisnikId"),rs.getString("k2.ime"),rs.getString("k2.prezime"), 
                                      rs.getString("k2.telefon"), rs.getString("k2.email"), rs.getString("k2.lozinka")); 
            PrijavaPronalaskaPsa ppp=new PrijavaPronalaskaPsa(rs.getInt("pr.prijavaPronalaskaPsaId"), 
                                        EnumPol.valueOf(rs.getString("pr.polPronadjenog")), 
                                        rs.getString("pr.bojaPronadjenog"), 
                                        new Date(rs.getTimestamp("pr.vremePronalaska").getTime()), 
                                        rs.getString("pr.kontaktNalazaca"), 
                                        new ImageIcon(rs.getString("pr.slikaURLPronadjenog")), rpr, lpr,
                                        rs.getDouble("za.xKoordinata"),
                                        rs.getDouble("za.yKoordinata"), rs.getString("za.opisLokacije"),kpr);
            ZahtevZaTrazenjePsa zztp=new ZahtevZaTrazenjePsa(rs.getInt("za.zahtevZaTrazenjePsaId"), 
                                        EnumPol.valueOf(rs.getString("za.polIzgubljenog")), 
                                        rs.getString("za.bojaIzgubljenog"), 
                                        new Date(rs.getTimestamp("za.vremeNestanka").getTime()), 
                                        rs.getString("za.kontaktVlasnika"), 
                                        new ImageIcon(rs.getString("za.slikaURLIzgubljenog")),
                                        rs.getInt("za.starost"),
                                        rs.getString("za.ime"), rza, lza, rs.getDouble("za.xKoordinata"),
                                        rs.getDouble("za.yKoordinata"), rs.getString("za.opisLokacije"), kza);
            Pronalazak p=new Pronalazak(ppp, zztp, new Date(rs.getDate("datumResavanjaSlucaja").getTime()), rs.getString("napomena"));
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
        return " prijavaPronalaskaPsaId="+prijavaPronalaskaPsa.getPrijavaPronalaskaPsaId()+
                " AND zahtevZaTrazenjePsaId="+zahtevZaTrazenjePsa.getZahtevZaTrazenjePsaId();
    }

    @Override
    public String vrednostiInsert() {
        return prijavaPronalaskaPsa.getPrijavaPronalaskaPsaId()+","
                +zahtevZaTrazenjePsa.getZahtevZaTrazenjePsaId()+ ",'"
                +new java.sql.Date(datumResavanjaSlucaja.getTime())
                +"','"+napomena+"'";
    }

    @Override
    public String vrednostiUpdate() {
          //return " prijavaPronalaskaPsaId="+prijavaPronalaskaPsa.getPrijavaPronalaskaPsaId()+", zahtevZaTrazenjePsaId="+zahtevZaTrazenjePsa.getZahtevZaTrazenjePsaId()
            return  " datumResavanjaSlucaja='"+new java.sql.Date((datumResavanjaSlucaja).getTime())+"', napomena='"+napomena+"' ";
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

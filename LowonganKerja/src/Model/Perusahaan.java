/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author user
 */
public class Perusahaan extends Orang {

    private List<Lowongan> daftarLowongan = new ArrayList<>();
    private String alamat;

    
    public boolean cekLowongan() {
        if (daftarLowongan.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public Perusahaan() {
    }

    public Perusahaan(String alamat, String nama, String email) {
        this.alamat = alamat;
        setNama(nama);
        setEmail(email);
    }
    
    public void setDaftarLowongan(List<Lowongan> daftarLowongan) {
        this.daftarLowongan = daftarLowongan;
    }
    
    public String[] getNamaLowongan() {
        String[] s = new String[daftarLowongan.size()];
        for (int i = 0; i < daftarLowongan.size(); i++) {
            s[i] = "Nama Lowongan " + daftarLowongan.get(i).getNama() + " Id Lowongan " + daftarLowongan.get(i).getIdLowongan();
        }
        return s;
    }

    public void createLowongan(String deadline, String nama) {
        daftarLowongan.add(new Lowongan(deadline, nama));
    }

//    public Lowongan getLowongan(int indexLowongan) {
//        return daftarLowongan.get(indexLowongan);
//    }

    public Lowongan getLowongan(int idLowongan) {
        for (int i = 0; i < daftarLowongan.size(); i++) {
            if (daftarLowongan.get(i).getIdLowongan()==(idLowongan)) {
                return daftarLowongan.get(i);
            }
        }
        return null;
    }
    
    public Lowongan getLowongan(String namaLowongan){
        for (int i = 0; i < daftarLowongan.size(); i++) {
            if (daftarLowongan.get(i).getNama().equals(namaLowongan)) {
                return daftarLowongan.get(i);
            }
        }
        return null;
    }
    public void removeLowongan(int idLowongan) {
        for (int i = 0; i < daftarLowongan.size(); i++) {
            if (daftarLowongan.get(i).getIdLowongan()==(idLowongan)) {
                daftarLowongan.remove(i);
            }
        }
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void Approval(int idBerkas, Lowongan l) {
        l.pindahBerkas(idBerkas);
    }

    public List<Lowongan> getDaftarLowongan() {
        return daftarLowongan;
    }

}

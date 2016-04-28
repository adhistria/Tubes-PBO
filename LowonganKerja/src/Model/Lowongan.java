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
 * @author adhis
 */
public class Lowongan{
    private List<BerkasLamaran> berkasMasuk=new ArrayList<>();
    private List<BerkasLamaran> berkasDiterima=new ArrayList<>();
    private int idLowongan;
    private String namaPerusahaan;
    private String deadline;
    private String nama;
    public Lowongan() {
    
    }

    public String getNamaPerusahaan() {
        return namaPerusahaan;
    }
    
    public Lowongan(int idLowongan,String deadline,String nama,String namaPerusahaan) {
        this.deadline = deadline;
        this.nama=nama;
        this.idLowongan=idLowongan;
        this.namaPerusahaan=namaPerusahaan;
    }

    public Lowongan(int idLowongan, String deadline, String nama) {
        this.idLowongan = idLowongan;
        this.deadline = deadline;
        this.nama = nama;
    }
 
    public Lowongan(String deadline,String nama) {
        this.deadline = deadline;
        this.nama=nama;
        this.idLowongan=-1;
    }

    public String[] getBerkasMasuk1(){
        String[] s=new String[berkasMasuk.size()];
        for(int i=0;i<berkasMasuk.size();i++){
            s[i]="Nama  : "+berkasMasuk.get(i).getNama()+"/n"
                    +"Id Berkas "+berkasMasuk.get(i).getIdBerkas()+"/n"
                    +"Email :"+berkasMasuk.get(i).getEmail();
        }
        return s;
    }
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
    
    
    public void addBerkas(BerkasLamaran b){
        berkasMasuk.add(b);
    }
    public void terimaBerkas(BerkasLamaran b){
        berkasDiterima.add(b);
    }
    public BerkasLamaran getBerkasDiterima(int index){
        return berkasDiterima.get(index);
    }
    
    public BerkasLamaran getBerkasMasuk(int idBerkas){
        for (int i = 0; i < berkasMasuk.size(); i++) {
            if(berkasMasuk.get(i).getIdBerkas()==idBerkas){
                return berkasMasuk.get(i);
            }
        }
        return null;
    }
    public void pindahBerkas(int idBerkas){
        terimaBerkas(getBerkasMasuk(idBerkas));    
        removeBerkas(idBerkas);
    }
    
    public void removeBerkas(int idBerkas){
        for (int i=0; i< berkasMasuk.size();i++){
            if(berkasMasuk.get(i).getIdBerkas()==idBerkas){
                System.out.println("Berkas yang dihapus"+berkasMasuk.get(i).getIdBerkas());
                berkasMasuk.remove(i);
            }
        }
    }
    
    public int getIdLowongan(){
        return idLowongan;
    }
    
    public String getDeadline() {
        return deadline;
    }
    
    public void setIdLowongan(int idLowongan) {
        this.idLowongan = idLowongan;
    }
    public List<BerkasLamaran> getBerkasMasuk() {
        return berkasMasuk;
    }
    
    public void setBerkasMasuk(List<BerkasLamaran> berkasMasuk) {
        this.berkasMasuk = berkasMasuk;
    }

    public BerkasLamaran getBerkas(int i){
        return berkasMasuk.get(i);
    }
}

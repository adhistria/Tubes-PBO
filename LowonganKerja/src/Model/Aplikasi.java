/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Database.Database;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Model.Pelamar;
/**
 *
 * @author adhis
 */
public class Aplikasi {
    private Database data; 
    private Perusahaan perusahaan;
    private Pelamar pelamar;
    
    
    public Aplikasi(){
        this.data=new Database();
        data.connect();
    }
    public Pelamar loginPelamar(String username,String password){
        Pelamar p=data.getPelamar(username, password);
        if(p!= null){
            return p; 
        }else{
            return null;
        }
    }
    public Perusahaan loginPerusahaan(String username,String password){
        Perusahaan p=data.getPerusahaan(username, password);
        if(p!= null){
            return p; 
        }else{
            return null;
        }
    }
    
    public void createBerkas(Pelamar p,BerkasLamaran b){
        data.saveBerkasLamaran(p,b);
    }
    
    public void createLowongan(Perusahaan p,Lowongan l){
        data.saveLowongan(l,p);
    }
    
    public void pindahBerkas(int idPelamar,int idLowongan){
        data.updateMelamar(idPelamar, idLowongan);
    }
    
    public void removeLowongan(Perusahaan p,int idLowongan){
        data.removeLowongan(p, idLowongan);
    }
    
    public void daftarKerja(Pelamar p,int idLowongan){
        data.melamar1(p, idLowongan);
    }
    
    public List<Lowongan> tampilLowongan(){
        List<Lowongan> low=new ArrayList<>();
        low=data.getLowongan();
        if(low!=null){
            return low;
        }else{
            return null;
        }
    }
    
    public List<Lowongan> tampilLowongan2(){
        List<Lowongan> low=new ArrayList<>();
        low=data.getLowongan2();
        if(low!=null){
            return low;
        }else{
            return null;
        }
    }
    
    public List<Lowongan> cariPerusahaan(String namaPerusahaan){
        List<Lowongan> low=new ArrayList<>();
        low=data.getLowongan(namaPerusahaan);
        if(low.size()==0){
            return null;
        }else{
            return low;
        }
    }
    
    public void RegistrasiPelamar (Pelamar p){
        data.savePelamar(p);
    }
    
    public void RegistrasiPerusahaan (Perusahaan p){
        data.savePerusahaan(p);
   }  
    
    public List<BerkasLamaran> getBerkas(int idLowongan){
        List<BerkasLamaran> berkas=new ArrayList<>();
        berkas=data.getBerkas(idLowongan);
        if(berkas.size()==0){
            return null;
        }else{
            return berkas;
        }
    }
    
    public BerkasLamaran getBerkasPelamar(Pelamar p){
        BerkasLamaran berkas;
        berkas=data.getBerkasPelamar(p);
        if(berkas!=null){
            return berkas;
        }else{
            return null;
        }
    }
    
    public List<Lowongan> getBerkasDiterima(Pelamar p){
        List<Lowongan> loker = new ArrayList<>();
        loker = data.getBerkasDiterima(p);
        if(loker!=null){
            return loker;
        }else{
            return null;
        }
    }
    public void updateBerkas(Pelamar p,String skill,String pengalaman){
        data.updateBerkas(p, skill,pengalaman);
    }
    
    public List<BerkasLamaran> getBerkasTerima(Perusahaan p){
        List<BerkasLamaran> berkas=new ArrayList<>();
        berkas=data.getBerkas2(p);
        if(berkas.size()==0){
            return null;
        }else{
            return berkas;
        }
    }
    
//    private Simpan data;
//    private List<Perusahaan> user;
//    private List<Pelamar> user2;    
//    public AplikasiConsole() {
//        this.data=new Simpan();
//        user2 =data.getPelamar();
//        user= data.getPerusahaan();
//    }
//
//    public List<Perusahaan> getUser() {
//        return user;
//    }
//    public String[] getNamaPerusahaan(){
//        String[] s=new String[user.size()];
//        if(user.size()>0){
//            for(int i=0;i<user.size();i++){
//                s[i]="Nama Perusahaan : "+user.get(i).getNama();
//            }
//            return s;
//        }else{
//            return null;
//        }
//          
//    }
//    public String[] getNamaLowongan(){
//        ArrayList<String> data=new ArrayList<>();
//        for(int i=0;i<user.size();i++){
//            if(!user.get(i).cekLowongan()){
//                for(int j=0;j<user.get(i).getDaftarLowongan().size();j++){
//                    String e="Nama Perusahaan "+user.get(i).getNama()+", Nama Lowongan : "+user.get(i).getLowongan(j).getNama()+"\n"+
//                            ", Id Lowongan "+user.get(i).getLowongan(j).getIdLowongan();
//                    data.add(e);
//               }
//            }
//        }
//        String[] s=new String[data.size()];
//        s = data.toArray(s);
//        return s;
//    }
//    public List<Pelamar> getUser2() {
//        return user2;
//    }
//    
//    public void addPelamar(Pelamar p){
//       user2.add(p);
//       data.simpanPelamar(user2);
//    }
//    public void addPerusahaan(Perusahaan p){
//       user.add(p);
//       data.simpanPerusahaan(user);
//    }
//    
//    public Pelamar getPelamar(String id){
//        for(int i=0;i<user.size();i++){
//            if(user2.get(i).getId().equals(id)){
//                return user2.get(i);
//            }
//        }
//        return null;
//    }
//    
//    public void deletePelamar(String id){
//        for(int i=0;i<user.size();i++){
//            if(user2.get(i).getId().equals(id)){
//                    user.remove(i);
//            }
//        }
//    }
//        
//    public void deletePerusahaan(String id){
//        for(int i=0;i<user.size();i++){
//            if(user.get(i).getId().equals(id)){
//                    user.remove(i);
//            }
//        }
//    }
//    
//    public Perusahaan getPerusahaan(String nama){
//        for(int i=0;i<user.size();i++){
//            if(user.get(i).getNama().equals(nama)){
//                    return user.get(i);
//            }
//        }
//        return null;
//    }
//    public List<Perusahaan> addLowongan(Perusahaan p,String deadline,String nama,String idLowongan){
//        for(int i=0;i<user.size();i++){
//           if(p==user.get(i)){
//               user.get(i).createLowongan(deadline, nama, idLowongan);
//           }
//       }
//       return user;
//    }
//    
//    public void addBerkas(Pelamar pelamar,String lulusan,String pengalaman,String skill){
//        pelamar.createBerkas(lulusan, skill, pengalaman);
//        data.simpanPelamar(user2);
//    }
//
//    public void daftarKerja(Perusahaan perusahaan,Pelamar pelamar,String idLowongan){
//        perusahaan.getLowongan(idLowongan).addBerkas(pelamar.getBerkas());
//        data.simpanPerusahaan(user);
//    }
//    
//    public Perusahaan menuLoginPerusahaan(String username, String password){
//        for(int i=0;i<user.size();i++){
//            if((user.get(i).getUsername().equals(username)) && (user.get(i).getPassword().equals(password))){
//              return user.get(i);
//            }
//        }
//        return null;
//    }
//    public Pelamar menuLoginPelamar(String username,String password){
//        for(int i=0;i<user2.size();i++){
//            if((user2.get(i).getUsername().equals(username)) &&(user2.get(i).getPassword().equals(password))){
//                return user2.get(i);
//            }
//        }
//        return null;
//    }
//    public Lowongan menuInfoLowongan(Perusahaan perusahaan,String idLowongan){
//        return perusahaan.getLowongan(idLowongan);
//    }
//
//    public void menuRemoveLowongan(Perusahaan perusahaan,String idLowongan){
//        perusahaan.removeLowongan(idLowongan);
//        data.simpanPerusahaan(user);
//    }
    
//tes    
}

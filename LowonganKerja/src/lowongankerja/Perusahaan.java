/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lowongankerja;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class Perusahaan extends Orang {
        private List<Lowongan> daftarLowongan = new ArrayList<>();
	private String alamat;

        public Perusahaan(String alamat,String nama, String email) {
            this.alamat = alamat;
            setNama(nama);
            setEmail(email);
        }
	
	public void createLowongan(String deadline, String nama, String idLowongan){
		daftarLowongan.add(new Lowongan(deadline, nama, idLowongan));
	}
	public Lowongan getLowongan(int indexLowongan){
		return daftarLowongan.get(indexLowongan);
	}
	public Lowongan getLowongan(String idLowongan){
		for (int i = 0; i < daftarLowongan.size(); i++){
			if (daftarLowongan.get(i).getIdLowongan().equals(idLowongan)){
				return daftarLowongan.get(i);
			}
		}
			return null;
	}
	public void removeLowongan(String idLowongan){
		for (int i = 0; i<daftarLowongan.size(); i++){
			if(daftarLowongan.get(i).getIdLowongan().equals(idLowongan)){
				daftarLowongan.remove(i);
			}
		}
	}
	public String getAlamat(){
		return alamat;
	}
	public void setAlamat(String alamat){
		this.alamat = alamat;
	}
}

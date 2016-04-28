/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ISMA
 */
public class Pelamar extends Orang{
    private BerkasLamaran berkas;
    private String pendidikan;

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }
    
    public void createBerkas (int idBerkas){
        berkas = new BerkasLamaran();
        berkas.setIdBerkas(idBerkas);
    }
    
    public void createBerkas(String skill,String pengalaman){
        berkas= new BerkasLamaran();
        berkas.setNama(getNama());
        berkas.setNoHp(getNoHp());
        berkas.setEmail(getEmail());
        berkas.setIdBerkas(getId());
        berkas.setPendidikan(getPendidikan());
        berkas.setPengalaman(pengalaman);
        berkas.setSkill(skill);
    }

    public BerkasLamaran getBerkas() {
        return berkas;
    }
    
}

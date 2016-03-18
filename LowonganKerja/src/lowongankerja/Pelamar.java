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
 * @author ISMA
 */
public class Pelamar extends Orang {
    private List<String> skill = new ArrayList<>();
    private BerkasLamaran berkas;
    private String pengalaman;
    private String lulusan;
    
    public void setSkill (String skill){
        this.skill.add(skill);
    }
	
	public String getSkill(int i){
        return skill.get(i);
    }
    
    public void setPengalaman (String pengalaman){
        this.pengalaman = pengalaman;
    }
	
    public String getPengalaman (){
        return pengalaman;
    }
    
    public void createBerkas (String idBerkas){
        berkas = new BerkasLamaran();
        berkas.setIdBerkas(idBerkas);
    }
}

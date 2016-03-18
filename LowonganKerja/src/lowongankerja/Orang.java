/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lowongankerja;

/**
 *
 * @author ISMA
 */
public class Orang {
    private String nama;
    private String email;
    private String noHp;
    
    public void setNama (String nama){
        this.nama = nama;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setEmail (String email){
        this.email = email;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setNoHp (String noHp){
        this.noHp = noHp;
    }
    
    public String getNoHp(){
        return noHp;
    }
}

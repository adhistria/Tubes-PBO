/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Model.BerkasLamaran;
import Model.Lowongan;
import Model.Pelamar;
import Model.Perusahaan;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author adhis
 */
public class Database {
    private String server="jdbc:mysql://127.0.0.1/mirahcantik";
    private String dbUser ="root";
    private String dbPasswd="";
    Statement statement;
    Connection connection;
    
    public void connect(){
        try{
            connection = DriverManager.getConnection(server, dbUser, dbPasswd);
            statement =  connection.createStatement();
        }catch(SQLException ex){
            System.out.println("Tidak konek");
        }
    }
    public void savePelamar(Pelamar p){
        try{
            String query="INSERT INTO PELAMAR(nama,username,password,email,noHp,Pendidikan) VALUES("+
                    "'"+p.getNama()+"',"+
                    "'"+p.getUsername()+"',"+
                    "'"+p.getPassword()+"',"+
                    "'"+p.getEmail()+"',"+
                    "'"+p.getNoHp()+"',"+
                    "'"+p.getPendidikan()+"')";
            statement.execute(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs=statement.getGeneratedKeys();
            int generatedId=-1;
            if(rs.next()){
                generatedId=rs.getInt(1);
            }
            p.setId(generatedId);
            JOptionPane.showMessageDialog(null, "Selamat, Anda Terdaftar");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Anda telah terdaftar sebelumnya");
            System.out.println("Semua data harus terisi"+ex.toString());
        }
    }
    public void savePerusahaan(Perusahaan p){
        try{
            String query="INSERT INTO PERUSAHAAN (nama,username,password,email,noHp,alamat) VALUES("+
                    "'"+p.getNama()+"',"+
                    "'"+p.getUsername()+"',"+
                    "'"+p.getPassword()+"',"+
                    "'"+p.getEmail()+"',"+
                    "'"+p.getNoHp()+"',"+
                    "'"+p.getAlamat()+"')";
            statement.execute(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs=statement.getGeneratedKeys();
            int generateId=-1;
            if(rs.next()){
                generateId=rs.getInt(1);
            }
            p.setId(generateId);
            JOptionPane.showMessageDialog(null, "Selamat, Anda Terdaftar");
        }catch(SQLException ex){
            System.out.println("Semua data harus terisi"+ex.toString());
            JOptionPane.showMessageDialog(null, "Anda telah terdaftar sebelumnya");
        }
    }
    public void saveLowongan(Lowongan l,Perusahaan p){
        try{
            String query="INSERT INTO LOWONGAN(idPerusahaan,deadline,namaLowongan) VALUES("+
                    "'"+p.getId()+"',"+
                    "'"+l.getDeadline()+"',"+
                    "'"+l.getNama()+"')";
            statement.execute(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs=statement.getGeneratedKeys();
            int generateId=-1;
            if(rs.next()){
                generateId=rs.getInt(1);
            }
            l.setIdLowongan(generateId);
        }catch(SQLException ex){
            System.out.println("Insert Data Gagal"+ex);
        }
    }
    public void saveBerkasLamaran(Pelamar p,BerkasLamaran b){
        try{
            String query="INSERT INTO BERKASLAMAR(idPelamar,nama,email,noHp,Pendidikan,skill,pengalaman) VALUES("+
                    "'"+p.getId()+"',"+
                    "'"+p.getNama()+"',"+
                    "'"+p.getEmail()+"',"+
                    "'"+p.getNoHp()+"',"+
                    "'"+p.getPendidikan()+"',"+
                    "'"+b.getSkill()+"',"+
                    "'"+b.getPengalaman()+"')";
            statement.execute(query,Statement.RETURN_GENERATED_KEYS);
            ResultSet rs=statement.getGeneratedKeys();
            int generateId=-1;
            if(rs.next()){
                generateId=rs.getInt(1);
            }
            b.setIdBerkas(generateId);
            JOptionPane.showMessageDialog(null, "Berkas berhasil dibuat");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Anda Telah Membuat Berkas Sebelumnya");
        }
    }
    public void melamar1(Pelamar p,int idLowongan){
        try{
            String status="Belum Diterima";
            String query="INSERT INTO MELAMAR (idPelamar,idLowongan,status) VALUES("+
                    "'"+p.getId()+"',"+
                    "'"+idLowongan+"',"+
                    "'"+status+"')";
            statement.execute(query);
            JOptionPane.showMessageDialog(null, "Anda berhasil mendaftar!");
        }catch(SQLException ex){
            System.out.println("salah"+ex);
             JOptionPane.showMessageDialog(null, "Anda telah mendaftar di Lowongan ini sebelumnya!");
        }
    }
    public void updateMelamar(int idPelamar,int idLowongan){
        try{
            String s="Berkas Diterima";
            String query="UPDATE MELAMAR SET STATUS= '"+
                    s+"'"+ "WHERE idPelamar = '"+idPelamar+"' AND "+
                    "idLowongan = '"+idLowongan+"'";
            statement.execute(query);
        }catch(SQLException ex){
            System.out.println("update data gagal"+ex);
        }
    }
    public Pelamar getPelamar(String username,String password){
        Pelamar p = null;
        try{
            String query="SELECT * FROM PELAMAR WHERE username= '"+username+"' "
                    +"AND password = '"+password+"'";
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                p=new Pelamar();
                p.setId(rs.getInt(1));
                p.setNama(rs.getString(2));
                p.setEmail(rs.getString(5));
                p.setNoHp(rs.getString(6));
                p.setPendidikan(rs.getString(7));
            }
            return p;
        }catch(SQLException ex){
            System.out.println("Login Gagal"+ex);
            return null;
        }
    }
    
     public Perusahaan getPerusahaan(String username,String password){
        Perusahaan p = null;
        try{
            String query="SELECT * FROM PERUSAHAAN WHERE username = '"+username+"' "
                    +"AND password = '"+password+"'";
            ResultSet rs=statement.executeQuery(query);
            while(rs.next()){
                p=new Perusahaan();
                p.setId(rs.getInt("idPerusahaan"));
                p.setNama(rs.getString("nama"));
                p.setEmail(rs.getString("email"));
                p.setNoHp(rs.getString("noHp"));
                p.setAlamat(rs.getString("alamat"));
            }
            return p;
        }catch(SQLException ex){
            System.out.println("Login Gagal"+ex);
            return null;
        }
    }
     
     public List<BerkasLamaran> getBerkas(int idLowongan){
         List<BerkasLamaran> berkas=new ArrayList<>();
         String status="Belum Diterima";
      try{
             String query="SELECT * FROM LOWONGAN NATURAL JOIN MELAMAR NATURAL JOIN PELAMAR NATURAL JOIN BERKASLAMAR WHERE "
                     + "idLowongan = '"+idLowongan+"'"
                     + "AND status = '"+status+"'";
             ResultSet rs=statement.executeQuery(query);
             while(rs.next()){
                 BerkasLamaran b =new BerkasLamaran();
                 b.setNama(rs.getString("nama"));
                 b.setEmail(rs.getString("email"));
                 b.setPengalaman(rs.getString("pengalaman"));
                 b.setPendidikan(rs.getString("pendidikan"));
                 b.setIdBerkas(rs.getInt("idPelamar"));
                 b.setNoHp(rs.getString("noHp"));
                 b.setSkill(rs.getString("skill"));
                 berkas.add(b);
             }
             return berkas;
         }catch(SQLException ex){
             System.out.println("Get data gagal"+ex);
             return null;
         }
     }
     public List<Lowongan> getBerkasDiterima(Pelamar p){
         List<Lowongan> lowongan=new ArrayList<>();
         String status="Berkas Diterima";
      try{
             String query="SELECT * FROM LOWONGAN NATURAL JOIN MELAMAR WHERE "
                     + "idPelamar = '"+p.getId()+"'"
                     + "AND status = '"+status+"'";
             ResultSet rs=statement.executeQuery(query);
             while(rs.next()){
                 Lowongan loker =new Lowongan(rs.getInt("idLowongan"), rs.getString("deadline"), rs.getString("namaLowongan"));
                 lowongan.add(loker);
             }
             return lowongan;
         }catch(SQLException ex){
             System.out.println("Get data gagal"+ex);
             return null;
         }
     }
     public List<Lowongan> getLowongan(){
         List<Lowongan> low=new ArrayList<>();
         try{
             String query="SELECT * FROM PERUSAHAAN NATURAL JOIN LOWONGAN";
             ResultSet rs=statement.executeQuery(query);
             while(rs.next()){
                 Lowongan l=new Lowongan(rs.getInt("idLowongan"), rs.getString("deadline"), rs.getString("namaLowongan"));
                 low.add(l);
             }
             return low;
         }catch(SQLException ex){
             System.out.println("Get data gagal");
             return null;
         }
     }
     
     public BerkasLamaran getBerkasPelamar(Pelamar p){
         BerkasLamaran berkas=null;
         try{
             String query="SELECT * FROM BERKASLAMAR WHERE "
                     + "idPelamar = '"+p.getId()+"'";
             ResultSet rs=statement.executeQuery(query);
             while(rs.next()){
                 berkas=new BerkasLamaran();
                 berkas.setNama(rs.getString("nama"));
                 berkas.setEmail(rs.getString("email"));
                 berkas.setPengalaman(rs.getString("pengalaman"));
                 berkas.setPendidikan(rs.getString("pendidikan"));
                 berkas.setIdBerkas(rs.getInt("idPelamar"));
                 berkas.setNoHp(rs.getString("noHp"));
                 berkas.setSkill(rs.getString("skill"));
             }
             return berkas;
         }catch(SQLException ex){
             return null;
         }
     }
     
     public List<Lowongan> getLowongan(String namaPerusahan){
         List<Lowongan> low=new ArrayList<>();
         try{
             String query="SELECT idLowongan,namaLowongan,deadline FROM PERUSAHAAN NATURAL JOIN LOWONGAN WHERE "
                     + "nama = '"+namaPerusahan+"'";
             ResultSet rs=statement.executeQuery(query);
             while(rs.next()){
                  Lowongan l=new Lowongan(rs.getInt("idLowongan"), rs.getString("deadline"), rs.getString("namaLowongan"));
                  low.add(l);
             }
             return low;
         }catch(SQLException ex){
             System.out.println("Get data gagal cuk"+ex);
             return null;
         }
     }
     public void removeLowongan(Perusahaan p,int idLowongan){
         try{
             String query="DELETE FROM Lowongan WHERE"
                     + " idLowongan = '"+idLowongan+"'"
                     + "AND idPerusahaan = '"+p.getId()+"'";
             statement.execute(query);
             p.removeLowongan(idLowongan);
              JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
         }catch(SQLException ex){
              JOptionPane.showMessageDialog(null, "Data tidak bisa di hapus!");
             System.out.println("Gagal DELETE"+ex);
         }
     }
     public void updateBerkas(Pelamar p, String skill,String pengalaman){
        try{
            String query="UPDATE BERKASLAMAR SET PENGALAMAN = '"+
                    pengalaman+"', SKILL = '"+skill+"'"+" WHERE idPelamar = '"+p.getId()+"'";
            statement.execute(query);
        }catch(SQLException ex){
            System.out.println("update data gagal"+ex);
        }
    }
//     public boolean cekDaftar(Pelamar p){
//         int id=0;
//         try{
//             String query="SELECT idPelamar FROM MELAMAR WHERE"
//                     + "idPelamar ='"+p.getId()+"'";
//             ResultSet rs=statement.executeQuery(query);
//             while(rs.next()){
//                 id++;
//             }
//         }catch(SQLException ex){
//             System.out.println("nggak ada cuk");
//         }
//         if(id!=0){
//             return true;
//         }else{
//             return false;
//         }
//     }
//tes
}
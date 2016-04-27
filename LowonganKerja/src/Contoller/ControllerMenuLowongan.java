/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contoller;

import Database.Database;
import View.menuLowongan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import Model.Aplikasi;
import Model.BerkasLamaran;
import Model.Lowongan;
import Model.Pelamar;
import Model.Perusahaan;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author adhis
 */
public class ControllerMenuLowongan extends MouseAdapter implements ActionListener{
    private Aplikasi model;
    private menuLowongan view;
    private Perusahaan p;
    private int selected;
    private int selected2;
    public ControllerMenuLowongan(Aplikasi model,Perusahaan p){
        this.model=model;
        this.p=p;
        view =new menuLowongan();
        if(model.cariPerusahaan(p.getNama())!=null){
            view.viewAll(model.cariPerusahaan(p.getNama()));
            view.viewAll2(model.cariPerusahaan(p.getNama()));
            p.setDaftarLowongan(model.cariPerusahaan(p.getNama()));
        }else
        {
            List <Lowongan> lowongan=new ArrayList<>();
            view.viewAll(lowongan);
            view.viewAll2(lowongan);
        }
        view.setVisible(true);
        view.addListener(this);
        view.addAdapter(this);
    }
    public void mouseClicked(MouseEvent e){
        if(e.getSource().equals(view.getTblLowongan())){
            selected=view.getSelected();
        }else if(e.getSource().equals(view.getTblHapus())){
            selected2=view.getSelected2();
        }
    }
    public void actionPerformed(ActionEvent ae){
        Object menulowongan = ae.getSource();
        
        if(menulowongan.equals(view.getAdd())){
        if(view.getNamaLowongan().equals("")||view.getDeadline().equals("")){
            JOptionPane.showMessageDialog(null, "Semua data haru diisi!");
        }else{
                String namaLowongan = view.getNamaLowongan();
                String deadline = view.getDeadline();
                p.createLowongan(deadline, namaLowongan);
                model.createLowongan(p, p.getLowongan(namaLowongan));
                JOptionPane.showMessageDialog(null, "Data berhasil!");
                view.viewAll(model.cariPerusahaan(p.getNama()));
                view.viewAll2(model.cariPerusahaan(p.getNama()));            
                view.setNamaLowongan("");
                view.setTanggal("");
            }
        } else if(menulowongan.equals(view.getBtnLihat())){
            if(model.cariPerusahaan(p.getNama())!=null){
                view.setVisible(false);
                new ControllerLihatPelamar(model,p,p.getDaftarLowongan().get(selected).getIdLowongan());
            }else{
                JOptionPane.showMessageDialog(null, "Belum Ada Bekas Masuk");
            }
        }else if(menulowongan.equals(view.getBtnHapus())){
            if(model.cariPerusahaan(p.getNama())!=null){
                model.removeLowongan(p, p.getDaftarLowongan().get(selected2).getIdLowongan());
                p.removeLowongan(p.getDaftarLowongan().get(selected2).getIdLowongan());
                if(model.cariPerusahaan(p.getNama())!=null){
                    p.setDaftarLowongan(model.cariPerusahaan(p.getNama()));
                    view.viewAll2(model.cariPerusahaan(p.getNama()));
                    view.viewAll(model.cariPerusahaan(p.getNama()));
                }else{
                    List <Lowongan> lowongan=new ArrayList<>();
                    view.viewAll(lowongan);
                    view.viewAll2(lowongan);
                }
            }else{
                JOptionPane.showMessageDialog(null, "Data Lowongan Tidak Ada");
            }
        }else if(menulowongan.equals((view.getBtnLogOut()))){
            new ControllerLogin(model);
            view.dispose();
        }else if(menulowongan.equals((view.getBtnLogOut1()))){
            new ControllerLogin(model);
            view.dispose();
        }else if(menulowongan.equals((view.getBtnLogOut2()))){
            new ControllerLogin(model);
            view.dispose();
        }
    }

}

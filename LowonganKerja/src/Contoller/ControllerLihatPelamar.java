/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contoller;

import View.lihatPelamar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Aplikasi;
import Model.BerkasLamaran;
import Model.Lowongan;
import Model.Perusahaan;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
class ControllerLihatPelamar extends MouseAdapter implements ActionListener{
        private Aplikasi model;
        private lihatPelamar view;
        private Perusahaan p;
        private int idLowongan;
        private int idPelamar;
        private Lowongan lowongan;
        
    public ControllerLihatPelamar(Aplikasi model, Perusahaan p,int idLowongan) {
        this.model = model;
        this.p=p;
        this.idLowongan=idLowongan;
        view = new lihatPelamar();
        view.setVisible(true);
        view.addListener(this);
        view.addAdapter(this);
        view.viewAll(model.getBerkas(idLowongan));
        p.getLowongan(idLowongan).setBerkasMasuk(model.getBerkas(idLowongan));
//        lowongan=p.getLowongan(idLowongan);
//        lowongan.setBerkasMasuk(model.getBerkas(idLowongan));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        System.out.println(""+p.getLowongan(idLowongan).getBerkas(idPelamar).getEmail());
        System.out.println(""+p.getLowongan(idLowongan).getBerkas(0).getIdBerkas());
        System.out.println(""+p.getLowongan(idLowongan).getBerkas(idPelamar).getIdBerkas());
        System.out.println(""+p.getLowongan(idLowongan).getBerkas(idPelamar).getNama());
        System.out.println(""+idLowongan);
        if(source.equals(view.getBtnTerima())){
            if(model.getBerkas(idLowongan).get(idPelamar).getIdBerkas()>0){
                p.getLowongan(idLowongan).pindahBerkas(p.getLowongan(idLowongan).getBerkas(idPelamar).getIdBerkas());
//                        pindahBerkas(lowongan.getBerkas(idPelamar).getIdBerkas());
                model.pindahBerkas(p.getLowongan(idLowongan).getBerkas(idPelamar).getIdBerkas(), idLowongan);
                JOptionPane.showMessageDialog(null, "Data telah diApprove!");
                view.dispose();
                view.viewAll(model.getBerkas(idLowongan));
                p.getLowongan(idLowongan).setBerkasMasuk(model.getBerkas(idLowongan));
            }else{
                JOptionPane.showMessageDialog(null, "Data Na");
            }
        } else if(source.equals(view.getBtnKembali())){
            new ControllerMenuLowongan(model,p);
            view.dispose();
        } else if(source.equals((view.getBtnLogOut()))){
            new ControllerLogin(model);
        }
    }
    public void MouseClicked(MouseEvent e){
        if(e.getSource().equals(view.getTblBerkas())){
            idPelamar=view.getSelected();
        }
    }    
}

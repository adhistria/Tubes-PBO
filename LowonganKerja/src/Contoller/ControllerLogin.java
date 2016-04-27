/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Contoller;

import Model.Aplikasi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Model.Orang;
import View.menuLogIn;
import javax.swing.JOptionPane;
import Model.Pelamar;
import Model.Perusahaan;
/**
 *
 * @author adhis
 */
public class ControllerLogin implements ActionListener {
        private Aplikasi model;
        private menuLogIn view;   
        
        public ControllerLogin(Aplikasi model){
            this.model=model;
            view= new menuLogIn();
            view.setVisible(true);
            view.addListener(this);
        }
//        public ControllerLogin(AplikasiConsole model,Orang o){
//            this.model=model;
//            view= new menuLogIn();
//            view.setVisible(true);
//            view.addListener(this);
//        }
        public void actionPerformed(ActionEvent e){
            Object source=e.getSource();
            if(source.equals(view.getBtnLogin())){
                if(view.getUsername().equals("")||view.getPassword().equals("")){
                    JOptionPane.showMessageDialog(null, "Semua data harus terisi");
                }else{
                    String username=view.getUsername();
                    String password=view.getPassword();
                    if(model.loginPelamar(username,password)!=null){
                        Pelamar p=model.loginPelamar(username, password);
                        new ControllerMenuCariPerusahaan(model,p);
                        view.dispose();
                    }else if(model.loginPerusahaan(username,password)!=null){
                        Perusahaan p=model.loginPerusahaan(username, password);
                        new ControllerMenuLowongan(model,p);
                        view.dispose();
                    }else{
                        JOptionPane.showMessageDialog(null, "Invalid Password/Username");
                    }
                }
            }else if(source.equals(view.getBtnRegistrasi())){
                new ControllerRegistrasi(model);
                view.dispose();
            }
        }
        
}

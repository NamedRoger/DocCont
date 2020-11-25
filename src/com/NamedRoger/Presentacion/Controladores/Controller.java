package src.com.NamedRoger.Presentacion.Controladores;

import src.com.NamedRoger.Dominio.Models.MetodUser;
import src.com.NamedRoger.Dominio.Models.Usuario;
import src.com.NamedRoger.Presentacion.Vistas.Inicio;
import src.com.NamedRoger.Presentacion.Vistas.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Controller implements ActionListener {

    private Login view;
    private MetodUser Models = new MetodUser();

    Inicio inicio=new Inicio();

    public void eventos( ){
        view.btn_enter.addActionListener(this);
        view.btn_exit.addActionListener(this);
        view.checkviewpass.addActionListener(this);
    }

    public Controller(Login vista){
        this.view=vista;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object evt = e.getSource();

        if (evt.equals(view.btn_enter)){

            char p [ ] = view.txt_pass.getPassword();
            String pass = new String(p);

            if (view.txt_user.getText().isEmpty() || pass.isEmpty()){

                JOptionPane.showMessageDialog(null,"Debe digitar usuario y contraseña",
                        "Error en la operacion", JOptionPane.ERROR_MESSAGE);

            }else{

                String user=view.txt_user.getText();
                ArrayList<Usuario> list;
                list = Models.login(user,pass);

                if (list.size()>0){

                    JOptionPane.showMessageDialog(null,"Bienvenido al sistema");
                    view.dispose();
                    inicio.setVisible(true);

                }else{
                    JOptionPane.showMessageDialog(null, "Acceso Denegado","Error", JOptionPane.ERROR_MESSAGE);

                }

            }

        }else if (evt.equals(view.btn_exit)){

            int confirmar = JOptionPane.showConfirmDialog(null,"Estas seguro de salir del sistema?");

            if (confirmar==JOptionPane.YES_OPTION){
                System.exit(0);
            }

        }else if (evt.equals(view.checkviewpass)){
            if (view.checkviewpass.isSelected()){
                view.txt_pass.setEchoChar((char)0);

            }else{
                view.txt_pass.setEchoChar('+');
            }
        }

    }
}

package src.com.NamedRoger.dominio.models;

import src.com.NamedRoger.infraestructura.interfaces.Modelo;

public class Usuario extends BaseModelo {
    private String userName;
    private String userNameNormalize;
    private String password;


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserNameNormalize(String userNameNormalize){
        this.userNameNormalize = userName.toUpperCase();
    }

    public String getUserNameNormalize(){
        return userNameNormalize;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }
}

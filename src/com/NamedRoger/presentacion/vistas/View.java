package src.com.NamedRoger.presentacion.vistas;

import java.util.Scanner;

public abstract class View {
    protected String title;
    protected Scanner scanner;

    public View(String title,Scanner scanner){
        this.title = title;
        this.scanner = scanner;
    }

    protected void apartado(){
        double diff = 40 -this.title.length();
        double half = (diff/2<(40/2))?(diff/2): (diff/2)-(this.title.length()/2);

        boolean writed = false;
        for(int i =0;i<diff;i++){
            if(i<half || writed){
                System.out.print("-");
            }else{
                System.out.print(this.title);
                writed = true;
            }
        }
        System.out.println("");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carreraslab2.pkg8;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.RandomAccess;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego Carcamo
 */
public class DirManager {

    File Carpeta;

    RandomAccessFile Corredores;

    public DirManager() {

        Carpeta = new File("Garage");

        Carpeta.mkdirs();

        Crear();

    }

    public void Crear() {

        try {
            Corredores = new RandomAccessFile("Garage/Corredores.rc", "rw");

        } catch (FileNotFoundException ex) {
            Logger.getLogger(DirManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public Color getColor(){
        
        try {
            int r=(int)Corredores.readDouble();
            
            int g= (int)Corredores.readDouble();
            
            int b=(int )Corredores.readDouble();
            
            
            
            return new Color(r, g, b);
        } catch (IOException ex) {
            Logger.getLogger(DirManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return Color.white;
    
    
    
    }
    public String getConductor(){
    
        try {
            return Corredores.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(DirManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "";
    
    
    }
    public int tipo(){
        
        
        try {
            return Corredores.readInt();
        } catch (IOException ex) {
            Logger.getLogger(DirManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 1;
        
    
    
    
    
    }

    public boolean Exist(int codigo) {

        try {
            
            Corredores.seek(0);

            while (Corredores.getFilePointer() < Corredores.length()) {

                

                int code=Corredores.readInt();
                Long pos=Corredores.getFilePointer();

                Corredores.readUTF();
                Corredores.readInt();
                //Colores se me olvido que eran lfoa
                Corredores.readDouble();
                Corredores.readDouble();
                Corredores.readDouble();
                
                if(code==codigo){
                    
                    Corredores.seek(pos);
                    return true;
                    
                
                }
                
                

            }

        } catch (IOException ex) {
            Logger.getLogger(DirManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;

    }

    public boolean AgregarCorredor(int codigo, String Conductor, int tipo, double r, double g, double b) throws IOException {
        
        
        
        if(!Exist(codigo)){
            
            Corredores.writeInt(codigo);
            Corredores.writeUTF(Conductor);
            Corredores.writeInt(tipo);//4
            Corredores.writeDouble(r);//8
            Corredores.writeDouble(g);//8
            Corredores.writeDouble(b);//8
            
            
            return true;
        
        
        
        
        
        }
        
        
        return false;

    }
    
    public ArrayList<String> Cargar() throws IOException {
        
        Corredores.seek(0);
        
        ArrayList<String>Lista= new ArrayList<>();
        
        while(Corredores.getFilePointer()<Corredores.length()){
        
            Lista.add(Corredores.readInt()+"");
            Corredores.readUTF();
            Corredores.skipBytes(28);
        
        
        }
        
        
        return Lista;
        
        
        
        
        

    }

}

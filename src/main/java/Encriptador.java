import java.io.*;
import java.util.ArrayList;

public class Encriptador {
    private String rutaEncrip = "UsuariosEncrip";

    public Encriptador(){
    }

    public String cifrar(String cadena, int clave){
        String ret = "";
        char[] chars = cadena.toCharArray();
        for (int i =0;i<chars.length;i++){
            char c= (char)(chars[i]^clave);
            ret = ret +c;
        }
        return ret;
    }

    public ArrayList<String> descifrarArchivo(int clave){
            GestorArchivos ga = new GestorArchivos(this.rutaEncrip);
            ArrayList<String> cifrado = ga.leerArchivo();
            String linea = null;
            ArrayList<String> usuarios = new ArrayList<>();
            for (int i = 0; i<cifrado.size();i++){
                linea = cifrado.get(i);
                String descifrado = cifrar(linea,clave);
                usuarios.add(descifrado);
            }
            return usuarios;
    }
}

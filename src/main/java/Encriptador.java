import java.io.*;
import java.util.ArrayList;

public class Encriptador {
    private String rutaUser = "Usuarios";
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

    public void cifrarArchivo(int clave){
        FileReader fr = null;
        try {
            File entradaf = new File(this.rutaUser);
            File salidaf = new File(this.rutaEncrip);
            fr = new FileReader(entradaf);
            FileWriter fw = new FileWriter(salidaf);
            BufferedWriter bw = new BufferedWriter(fw);
            BufferedReader br = new BufferedReader(fr);
            String linea = null;
            while ((linea = br.readLine()) != null){
                String cifrado = cifrar(linea,clave);
                bw.write(cifrado);
                bw.newLine();
                bw.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<String> descifrarArchivo(int clave){
        FileReader fr = null;
        try {
            File entradaf = new File(this.rutaEncrip);
            fr = new FileReader(entradaf);
            BufferedReader br = new BufferedReader(fr);
            String linea = null;
            ArrayList<String> usuarios = new ArrayList<>();
            while ((linea = br.readLine()) != null){
                String cifrado = cifrar(linea,clave);
                usuarios.add(cifrado);
            }
            return usuarios;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

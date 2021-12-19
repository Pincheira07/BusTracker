package GUIs;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

public class Mapa {
    private String latitud;
    private String longitud;

    public Mapa(String latitud, String longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
        generarMapa();
    }

    private void generarMapa() {
        JFrame test = new JFrame("Google Maps");

        try {
            String imageUrl = "https://maps.googleapis.com/maps/api/staticmap?center=" +
                    this.latitud +
                    "," +
                    this.longitud +
                    "&zoom=15&size=612x612&scale=2&markers=color:red|"+this.latitud+","+this.longitud+"&key=AIzaSyALTQxOa1TWN9E_RwR1DZaL22FAqDahX7w";
            String destinationFile = "image.jpg";

            // lee la imagen de google
            // y la guarda en un archivo local image.jpg
            //
            URL url = new URL(imageUrl);
            InputStream is = url.openStream();
            OutputStream os = new FileOutputStream(destinationFile);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1) {
                os.write(b, 0, length);
            }

            is.close();
            os.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        // crea un componente gui que carga la imagen.jpg
        //
        ImageIcon imageIcon = new ImageIcon((new ImageIcon("image.jpg"))
                .getImage().getScaledInstance(630, 600,
                        java.awt.Image.SCALE_SMOOTH));
        test.add(new JLabel(imageIcon));

        // Muestra la ventan
        test.setVisible(true);
        test.pack();
    }
}

package mx.unison;

/* Contar cuantos códigos postales corresponden a asentamientos rurales
y cantos a asentamientos rurales
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String archivo = "codigos_postales.csv";
        int contadorUrbanos = 0;
        int contadorRurales = 0;

        try (BufferedReader BR = new BufferedReader(new FileReader(archivo))) {
            String linea;

            // Leer la primera linea (encabezado) y descartarla
            BR.readLine();

            while ((linea = BR.readLine()) != null) {
                String[] campos = linea.split(",");
                String tipoAsentamiento = campos[2].trim();

                if (tipoAsentamiento.equalsIgnoreCase("Urbano")) {
                    contadorUrbanos++;
                }
                else
                    if (tipoAsentamiento.equalsIgnoreCase("Rural")) {
                    contadorRurales++;
                }
            }

            // Mostrar los resultados
            System.out.println("Cantidad de asentamientos urbanos: " + contadorUrbanos);
            System.out.println("Cantidad de asentamientos rurales: " + contadorRurales);

        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
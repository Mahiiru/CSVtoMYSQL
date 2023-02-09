package org.csvfiletomysql;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileManager {
    public void crearDirectorio(String ruta){
        Path directorio = Paths.get(ruta);
        if(Files.exists(directorio)){
            System.out.println("El directorio ya existe");
        }else{
            try{
                Files.createDirectories(directorio);
                System.out.println("El directorio fue creado exitosamente");
            }catch(IOException e){
                System.out.println("el directorio no puede ser creado");
            }
        }
    }

    public void crearArchivo(String ruta, String contenido){
        Path archivo = Paths.get(ruta);
        try{
            Files.write(archivo, contenido.getBytes());
            System.out.println("el archivo fue creado exitosamente");
        }catch(IOException e){
            System.out.println("el archivo no pudo ser creado");
        }
    }

    public String leerArchivo(String ruta){
        Path archivo = Paths.get(ruta);
        String contenido = "";
        try {
            contenido = new String(Files.readAllBytes(archivo));
        } catch (IOException e) {
            System.out.println("el archivo no pudo ser leido");

        }
        return contenido;
    }

    public void borrarArchivo(String ruta) {
        Path archivo = Paths.get(ruta);
        try {
            Files.delete(archivo);
            System.out.println("El archivo fue eliminado exitosamente");
        } catch (IOException e) {
            System.out.println("El archivo no pudo ser eliminado");
        }
    }

    public void copiarArchivo(String ruta, String newRuta){
        Path archivo = Paths.get(ruta);
        Path newArchivo = Paths.get(newRuta);
        try{
            Files.copy(archivo, newArchivo, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("El archivo fue copiado exitosamente");
        }catch(IOException e){
            System.out.println("El archivo no puso ser copiado");
        }

    }
}

package com.cursosdeti.apicursosdeti.utils;

import org.apache.commons.io.IOUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ConverterBase64EmZip {


    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = ConverterBase64EmZip.class.getClassLoader();

        InputStream inputStream = classLoader.getResourceAsStream("stringtoolong.txt");

        //FileInputStream fis = new FileInputStream("../../stringtoolong.txt");
        String base64Data = IOUtils.toString(inputStream, "UTF-8");

        // Decodificar a string base64
        byte[] decodedData = Base64.getDecoder().decode(base64Data);

        // Salvar o conteúdo em um arquivo ZIP
        try (FileOutputStream fos = new FileOutputStream("arquivo.zip");
             ZipOutputStream zos = new ZipOutputStream(fos)) {
            ZipEntry entry = new ZipEntry("arquivo2.zip"); // Nome do arquivo dentro do ZIP
            zos.putNextEntry(entry);
            zos.write(decodedData);
            zos.closeEntry();

            // O arquivo ZIP foi criado com sucesso
            System.out.println("Arquivo ZIP criado com sucesso.");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

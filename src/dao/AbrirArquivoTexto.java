/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author hiago
 */
public class AbrirArquivoTexto {
    public static String lerArquivo  (Path caminho) throws IOException{
        String dados = new String(Files.readAllBytes(caminho));        
        return dados;
    }    
}

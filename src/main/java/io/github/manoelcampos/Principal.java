package io.github.manoelcampos;

import io.github.manoelcampos.stringcompression.CompressionFactory;
import io.github.manoelcampos.stringcompression.CompressionStrategy;
import io.github.manoelcampos.stringcompression.CompressionType;

/*
 * Classe para implementar o uso dos compressores de texto após
 * a aplicação do(s) padrão(ões) de projeto que se enquadre(m) com o contexto apresentado no README.
 *
 * @author Yago de Lima França
*/
 public class Principal {
     private CompressionStrategy compressionStrategy;

     public void setCompressionAlgorithm(CompressionType algorithmName) {
         this.compressionStrategy = CompressionFactory.getCompressionAlgorithm(algorithmName);
     }

     public String compressData(String data) {
         return compressionStrategy.compress(data);
     }

     public String decompressData(String data) {
         return compressionStrategy.decompress(data);
     }

     public static void main(String[] args) {
         Principal principal = new Principal();
         principal.setCompressionAlgorithm(CompressionType.WORD_SUBSTITUTION);
         String compressedData = principal.compressData("casa sistema carro sistema casa controle casa casa controle bolsa casa bola rua bola casa bola casa casa carro casa bola bola");
         String decompressedData = principal.decompressData(compressedData);
         System.out.println("Compressed: " + compressedData);
         System.out.println("Decompressed: " + decompressedData);
     }
 }

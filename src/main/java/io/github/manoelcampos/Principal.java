package io.github.manoelcampos;

import io.github.manoelcampos.stringcompression.CompressionFactory;
import io.github.manoelcampos.stringcompression.CompressionStrategy;

/*
 * Classe para implementar o uso dos compressores de texto após
 * a aplicação do(s) padrão(ões) de projeto que se enquadre(m) com o contexto apresentado no README.
 *
 * @author Yago de Lima França
*/
 public class Principal {
     private CompressionStrategy compressionStrategy;

     public void setCompressionAlgorithm(String algorithmName) {
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
         principal.setCompressionAlgorithm("RLE");
         String compressedData = principal.compressData("aaaaaaaaaaaaaaaaabbbbbbababababacabaaaaaaaaaaaaaaaaccccccccccccccaaaaaaaaa");
         String decompressedData = principal.decompressData(compressedData);
         System.out.println("Compressed: " + compressedData);
         System.out.println("Decompressed: " + decompressedData);
     }
 }

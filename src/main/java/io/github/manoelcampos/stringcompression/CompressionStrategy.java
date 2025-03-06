package io.github.manoelcampos.stringcompression;
/**
 * Implementa uma estrategia com os passos comuns para qualquer Compression class
 *
 *
 * @author Yago de Lima França
 */
public interface CompressionStrategy {
    String compress(String data);
    String decompress(String data);
}

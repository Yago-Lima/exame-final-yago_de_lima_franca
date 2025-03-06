package io.github.manoelcampos.stringcompression;

public interface CompressionStrategy {
    String compress(String data);
    String decompress(String data);
}

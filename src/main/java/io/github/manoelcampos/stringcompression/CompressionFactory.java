package io.github.manoelcampos.stringcompression;
/**
 * Implementa uma simple factory permitindo escolher o algoritimo por nome.
 *
 *
 * @author Yago de Lima França
 */
public class CompressionFactory {

    public static CompressionStrategy getCompressionAlgorithm(String algorithmName) {
        switch (algorithmName) {
            case "RLE":
                return new RLECompression();
            case "WordSubstitution":
                return new WordSubstitutionCompression();
            default:
                throw new IllegalArgumentException("Unknown compression algorithm: " + algorithmName);
        }
    }
}

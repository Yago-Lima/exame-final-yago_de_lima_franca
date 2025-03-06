package io.github.manoelcampos.stringcompression;
/**
 * Implementa uma simple factory permitindo escolher o algoritimo por nome.
 *
 *
 * @author Yago de Lima França
 */
public final class CompressionFactory {
    private CompressionFactory() {
    }

    public static CompressionStrategy getCompressionAlgorithm(CompressionType algorithmName) {
        switch (algorithmName) {
            case CompressionType.RLE:
                return new RLECompression();
            case CompressionType.WORD_SUBSTITUTION:
                return new WordSubstitutionCompression();
            default:
                throw new IllegalArgumentException("Unknown compression algorithm: " + algorithmName);
        }
    }
}

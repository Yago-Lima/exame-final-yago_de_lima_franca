package io.github.manoelcampos.stringcompression;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testa as implementações dos compressores de texto {@link RLECompression} e {@link WordSubstitutionCompression}.
 * @author Manoel Campos
 */
class CompressionTest {
    /**
     * Testa a compressão e descompressão com {@link RLECompression}.
     */
    @Test
    void rleCompression() {
        final String text = "aaaaaaaaaaaaaaaaabbbbbbababababacabaaaaaaaaaaaaaaaaccccccccccccccaaaaaaaaa";
        final var compressor = new RLECompression();
        final String compressed = compressor.compress(text);
        final String decompressed = compressor.decompress(compressed);

        System.out.println("Algoritmo de Compressão Run-Length Encoding (RLE)");
        System.out.printf("Fonte         | Caracteres | Texto %n");
        System.out.printf("--------------| -----------|-------%n");
        System.out.printf("Original      | %10d | %s%n", text.length(), text);
        System.out.printf("Comprimido    | %10d | %s%n", compressed.length(), compressed);
        System.out.printf("Descomprimido | %10d | %s%n", decompressed.length(), decompressed);
        System.out.println();

        // Veririca se o texto descomprimido é igual ao texto original
        assertEquals(text, decompressed);
    }

    /**
     * Testa a compressão e descompressão com {@link WordSubstitutionCompression}.
     */
    @Test
    void wordSubstitutionCompression() {
        final String text = "casa sistema carro sistema casa controle casa casa controle bolsa casa bola rua bola casa bola casa casa carro casa bola bola";
        final var compressor = new WordSubstitutionCompression();
        compressor.setText(text);
        compressor.compressText();
        final String compressed = compressor.getText();

        compressor.decompressText();
        final String decompressed = compressor.getText();

        System.out.println("Algoritmo de Compressão Substituição de Palavras");
        System.out.printf("Fonte         | Caracteres | Texto %n");
        System.out.printf("--------------| -----------|-------%n");
        System.out.printf("Original      | %10d | %s%n", text.length(), text);
        System.out.printf("Comprimido    | %10d | %s%n", compressed.length(), compressed);
        System.out.printf("Descomprimido | %10d | %s%n", decompressed.length(), decompressed);
        System.out.println();

        // Veririca se o texto descomprimido é igual ao texto original
        assertEquals(text, decompressed);
    }
}

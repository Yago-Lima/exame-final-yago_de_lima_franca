package io.github.manoelcampos.stringcompression;

/**
 * Implementa algoritmo de compressão de texto Run-Length Encoding (RLE),
 * que substitui sequências repetidas de caracteres por um contador e o próprio caractere.
 *
 * @author Yago de Lima França
 */
public class RLECompression implements CompressionStrategy{
    @Override
    public String compress(final String text) {
        if(text.length() <= 1)
            return text;

        final var compressed = new StringBuilder();
        int count = 1;

        for (int i = 0; i < text.length(); i++) {
            if (i + 1 < text.length() && text.charAt(i) == text.charAt(i + 1)) {
                count++;
            } else {
                compressed.append(text.charAt(i)).append(count).append(',');
                count = 1;
            }
        }

        return compressed.toString();
    }

    @Override
    public String decompress(final String compressed) {
        if(compressed.length() <= 1)
            return compressed;

        final var decompressed = new StringBuilder();

        for (int i = 0; i < compressed.length(); ) {
            final int commaPos = compressed.indexOf(',', i);
            final char character = compressed.charAt(i);
            final int count = Integer.parseInt(compressed.substring(i+1, commaPos));
            try {
                decompressed.append(String.valueOf(character).repeat(count));
            } catch (Exception e) {
                System.err.printf("%s -> %c count %d%n", e.getMessage(), compressed.charAt(i + 1), count);
            }

            i = commaPos+1;
        }

        return decompressed.toString();
    }
}

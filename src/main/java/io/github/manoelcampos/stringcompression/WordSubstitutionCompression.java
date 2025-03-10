package io.github.manoelcampos.stringcompression;

import java.util.HashMap;

/**
 * Implementa algoritmo de compressão de texto Word Substitution,
 * que substitui palavras repetidas por um índice numa tabela.
 * @author Yago de Lima França
 */
public class WordSubstitutionCompression implements CompressionStrategy {

    @Override
    public String compress(String text) {
        final String[] words = text.split(" ");
        final var wordIndexMap = new HashMap<String, Integer>();
        final var compressed = new StringBuilder();
        int index = 0;

        for (final String word : words) {
            if (!wordIndexMap.containsKey(word)) {
                wordIndexMap.put(word, index++);
            }
            compressed.append(wordIndexMap.get(word)).append(" ");
        }
        return wordIndexMap + "|" + compressed.toString().trim();
    }

    @Override
    public String decompress(String text) {
        final String[] parts = text.split("\\|");
        final var dictionary = new HashMap<Integer, String>();

        final String dictPart = parts[0].replaceAll("[{}]", "");
        for (final String entry : dictPart.split(", ")) {
            final String[] keyValue = entry.split("=");
            dictionary.put(Integer.parseInt(keyValue[1]), keyValue[0]);
        }

        final var decompressed = new StringBuilder();
        for (final String index : parts[1].split(" ")) {
            decompressed.append(dictionary.get(Integer.parseInt(index))).append(" ");
        }

        return decompressed.toString().trim();
    }
}

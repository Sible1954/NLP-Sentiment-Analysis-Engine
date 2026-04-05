
package com.example.sentiment.processor;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class TextProcessor {

    private final Set<String> stopWords;

    public TextProcessor() {
        stopWords = new HashSet<>(Arrays.asList(
                "a", "an", "the", "is", "am", "are", "was", "were", "be", "been", "being",
                "and", "or", "but", "if", "then", "else", "when", "where", "why", "how",
                "for", "with", "without", "at", "by", "to", "from", "of", "on", "in", "out",
                "as", "so", "too", "very", "just", "only", "can", "will", "would", "should",
                "not", "no", "don't", "doesn't", "didn't", "won't", "can't", "couldn't"
        ));
        System.out.println("TextProcessor initialized.");
    }

    public List<String> tokenize(String text) {
        System.out.println("  - Tokenizing text...");
        return Arrays.stream(text.toLowerCase().split("\W+"))
                .filter(word -> !word.isEmpty())
                .collect(Collectors.toList());
    }

    public List<String> removeStopWords(List<String> tokens) {
        System.out.println("  - Removing stop words...");
        return tokens.stream()
                .filter(word -> !stopWords.contains(word))
                .collect(Collectors.toList());
    }

    public List<String> stem(List<String> tokens) {
        System.out.println("  - Performing stemming (placeholder)...");
        return tokens;
    }

    public List<String> lemmatize(List<String> tokens) {
        System.out.println("  - Performing lemmatization (placeholder)...");
        return tokens;
    }
}

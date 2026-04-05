
package com.example.sentiment;

public class SentimentAnalyzer {

    public String analyze(String text) {
        // Dummy sentiment analysis logic for demonstration
        if (text.toLowerCase().contains("fantastic") || text.toLowerCase().contains("great")) {
            return "Positive";
        } else if (text.toLowerCase().contains("bad") || text.toLowerCase().contains("terrible")) {
            return "Negative";
        } else {
            return "Neutral";
        }
    }

    public static void main(String[] args) {
        SentimentAnalyzer analyzer = new SentimentAnalyzer();
        String text1 = "This movie was absolutely fantastic!";
        String text2 = "I did not enjoy this product at all.";
        String text3 = "The weather is okay today.";

        System.out.println("Text: \"" + text1 + "\" -> Sentiment: " + analyzer.analyze(text1));
        System.out.println("Text: \"" + text2 + "\" -> Sentiment: " + analyzer.analyze(text2));
        System.out.println("Text: \"" + text3 + "\" -> Sentiment: " + analyzer.analyze(text3));
    }
}

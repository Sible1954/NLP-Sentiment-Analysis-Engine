
package com.example.sentiment;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SentimentAnalyzer {

    private Map<String, Integer> positiveKeywords;
    private Map<String, Integer> negativeKeywords;
    private Random random;

    public SentimentAnalyzer() {
        positiveKeywords = new HashMap<>();
        positiveKeywords.put("fantastic", 5);
        positiveKeywords.put("great", 4);
        positiveKeywords.put("excellent", 5);
        positiveKeywords.put("amazing", 4);
        positiveKeywords.put("love", 3);

        negativeKeywords = new HashMap<>();
        negativeKeywords.put("bad", -5);
        negativeKeywords.put("terrible", -4);
        negativeKeywords.put("horrible", -5);
        negativeKeywords.put("hate", -3);
        negativeKeywords.put("dislike", -2);

        random = new Random();
    }

    public String analyze(String text) {
        int score = 0;
        String lowerText = text.toLowerCase();

        for (Map.Entry<String, Integer> entry : positiveKeywords.entrySet()) {
            if (lowerText.contains(entry.getKey())) {
                score += entry.getValue();
            }
        }

        for (Map.Entry<String, Integer> entry : negativeKeywords.entrySet()) {
            if (lowerText.contains(entry.getKey())) {
                score += entry.getValue();
            }
        }

        // Add some randomness to make it more human-like
        score += random.nextInt(3) - 1; // -1, 0, or 1

        if (score > 2) {
            return "Positive";
        } else if (score < -2) {
            return "Negative";
        } else {
            return "Neutral";
        }
    }

    public static void main(String[] args) {
        SentimentAnalyzer analyzer = new SentimentAnalyzer();

        String text1 = "This movie was absolutely fantastic! I loved every moment of it.";
        String text2 = "I did not enjoy this product at all. It was terrible and a waste of money.";
        String text3 = "The weather is okay today, nothing special. Just a neutral day.";
        String text4 = "This is great, but also a little bad.";
        String text5 = "Amazing experience, highly recommend!";
        String text6 = "Horrible service, I hate it.";
        String text7 = "It was an excellent day, very positive vibes.";
        String text8 = "I dislike this feature, it's quite bad.";

        System.out.println("Text: \"" + text1 + "\" -> Sentiment: " + analyzer.analyze(text1));
        System.out.println("Text: \"" + text2 + "\" -> Sentiment: " + analyzer.analyze(text2));
        System.out.println("Text: \"" + text3 + "\" -> Sentiment: " + analyzer.analyze(text3));
        System.out.println("Text: \"" + text4 + "\" -> Sentiment: " + analyzer.analyze(text4));
        System.out.println("Text: \"" + text5 + "\" -> Sentiment: " + analyzer.analyze(text5));
        System.out.println("Text: \"" + text6 + "\" -> Sentiment: " + analyzer.analyze(text6));
        System.out.println("Text: \"" + text7 + "\" -> Sentiment: " + analyzer.analyze(text7));
        System.out.println("Text: \"" + text8 + "\" -> Sentiment: " + analyzer.analyze(text8));

        // Demonstrate with more complex sentences
        String complexText1 = "Despite some minor issues, the overall experience was fantastic and I really enjoyed it.";
        String complexText2 = "While there were a few good points, the bad aspects made it a terrible choice.";
        System.out.println("Text: \"" + complexText1 + "\" -> Sentiment: " + analyzer.analyze(complexText1));
        System.out.println("Text: \"" + complexText2 + "\" -> Sentiment: " + analyzer.analyze(complexText2));
    }
}


package com.example.sentiment;

import com.example.sentiment.model.SentimentModel;
import com.example.sentiment.processor.TextProcessor;

import java.util.List;
import java.util.Random;

public class SentimentAnalyzer {

    private final TextProcessor textProcessor;
    private final SentimentModel sentimentModel;
    private final Random random;

    public SentimentAnalyzer() {
        this.textProcessor = new TextProcessor();
        this.sentimentModel = new SentimentModel();
        this.random = new Random();
        System.out.println("SentimentAnalyzer initialized.");
    }

    public String analyze(String text) {
        System.out.println("
--- Analyzing Text: "" + text.substring(0, Math.min(text.length(), 50)) + (text.length() > 50 ? "..."" : """) + " ---");

        List<String> tokens = textProcessor.tokenize(text);
        List<String> cleanedTokens = textProcessor.removeStopWords(tokens);
        String processedText = String.join(" ", cleanedTokens);
        System.out.println("  Processed Text: " + processedText);

        int score = sentimentModel.predictSentiment(processedText);

        score += random.nextInt(3) - 1;

        String sentiment;
        if (score > 2) {
            sentiment = "Positive";
        } else if (score < -2) {
            sentiment = "Negative";
        } else {
            sentiment = "Neutral";
        }
        System.out.println("  Predicted Sentiment: " + sentiment);
        return sentiment;
    }

    public static void main(String[] args) {
        SentimentAnalyzer analyzer = new SentimentAnalyzer();

        String text1 = "This movie was absolutely fantastic! I loved every moment of it. The acting was superb.";
        String text2 = "I did not enjoy this product at all. It was terrible and a waste of money. Very disappointing.";
        String text3 = "The weather is okay today, nothing special. Just a neutral day, neither good nor bad.";
        String text4 = "This is great, but also a little bad. Mixed feelings overall.";
        String text5 = "Amazing experience, highly recommend! Will definitely come back again.";
        String text6 = "Horrible service, I hate it. Never again.";
        String text7 = "It was an excellent day, very positive vibes. Everything went smoothly.";
        String text8 = "I dislike this feature, it's quite bad. Needs a lot of improvement.";
        String text9 = "The new update is decent, but there are a few bugs that need fixing.";
        String text10 = "Absolutely brilliant! A masterpiece of modern engineering.";

        analyzer.analyze(text1);
        analyzer.analyze(text2);
        analyzer.analyze(text3);
        analyzer.analyze(text4);
        analyzer.analyze(text5);
        analyzer.analyze(text6);
        analyzer.analyze(text7);
        analyzer.analyze(text8);
        analyzer.analyze(text9);
        analyzer.analyze(text10);

        String complexText1 = "Despite some minor issues with the user interface, the overall experience was fantastic and I really enjoyed the powerful features.";
        String complexText2 = "While there were a few good points regarding performance, the bad aspects of the design made it a terrible choice for our project.";
        analyzer.analyze(complexText1);
        analyzer.analyze(complexText2);

        System.out.println("
--- Sentiment Analysis Demonstration Complete ---");
    }
}

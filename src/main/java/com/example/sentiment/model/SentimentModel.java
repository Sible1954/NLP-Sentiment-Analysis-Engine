
package com.example.sentiment.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SentimentModel {

    private final Map<String, Integer> wordScores;
    private final Random random;

    public SentimentModel() {
        wordScores = new HashMap<>();
        wordScores.put("fantastic", 5);
        wordScores.put("great", 4);
        wordScores.put("excellent", 5);
        wordScores.put("amazing", 4);
        wordScores.put("love", 3);
        wordScores.put("happy", 2);
        wordScores.put("good", 2);

        wordScores.put("bad", -5);
        wordScores.put("terrible", -4);
        wordScores.put("horrible", -5);
        wordScores.put("hate", -3);
        wordScores.put("dislike", -2);
        wordScores.put("sad", -2);
        wordScores.put("poor", -1);

        this.random = new Random();
        System.out.println("SentimentModel initialized.");
    }

    public int predictSentiment(String processedText) {
        System.out.println("  - Predicting sentiment with model...");
        int score = 0;
        String[] words = processedText.split(" ");

        for (String word : words) {
            score += wordScores.getOrDefault(word, 0);
        }

        score += random.nextInt(3) - 1;

        return score;
    }

    public boolean loadPretrainedModel(String modelPath) {
        System.out.println("  - Loading pre-trained model from " + modelPath + " (placeholder)...");
        return true;
    }
}

package com.asvladimirov.syntsc.service;

import com.asvladimirov.syntsc.dto.FixedSentenceSuggestion;

public interface SyntaxMistakesDeterminantService {

    FixedSentenceSuggestion findMistakesAndSuggestFixedSentences(String sentence);
    
}

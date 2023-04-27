package com.asvladimirov.syntsc.web.controller;

import com.asvladimirov.syntsc.dto.FixedSentenceSuggestion;
import com.asvladimirov.syntsc.service.SyntaxMistakesDeterminantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/syntax")
public class SyntscController {
    private final SyntaxMistakesDeterminantService determinantService;

    @GetMapping("/scan")
    public ResponseEntity<FixedSentenceSuggestion> scanAndSuggestFixedSentences(
            @RequestParam String sentence
    ) {
        return ResponseEntity.ok(determinantService.findMistakesAndSuggestFixedSentences(sentence));
    }
}

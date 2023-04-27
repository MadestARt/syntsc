package com.asvladimirov.syntsc.service.impl;

import com.asvladimirov.syntsc.dto.FixedSentenceSuggestion;
import com.asvladimirov.syntsc.integration.rest.YandexSpellerFeignClient;
import com.asvladimirov.syntsc.service.SentenceTextBuilderService;
import com.asvladimirov.syntsc.service.SyntaxMistakesDeterminantService;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class SyntaxMistakesDeterminantServiceImpl implements SyntaxMistakesDeterminantService {
    private final YandexSpellerFeignClient yandexSpellerFeignClient;
    private final SentenceTextBuilderService sentenceTextBuilderService;

    @Override
    public FixedSentenceSuggestion findMistakesAndSuggestFixedSentences(String sentence) {
        try {
            var spellerRequest = sentenceTextBuilderService.buildSpellerRequest(sentence);

            var spellerResponse = yandexSpellerFeignClient.checkText(spellerRequest);

            var fixedSentence = sentenceTextBuilderService.buildFinalSentence(spellerRequest, spellerResponse);
            return new FixedSentenceSuggestion(fixedSentence);
        } catch (FeignException exception) {
            log.error("Ошибка при интеграции с внешней системой {}",exception.getMessage());
            throw exception;
        }
    }
}

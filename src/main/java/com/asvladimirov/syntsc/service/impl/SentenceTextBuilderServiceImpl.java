package com.asvladimirov.syntsc.service.impl;

import com.asvladimirov.syntsc.config.ReplaceCharacterProperties;
import com.asvladimirov.syntsc.integration.api.CertainWordResponse;
import com.asvladimirov.syntsc.service.SentenceTextBuilderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SentenceTextBuilderServiceImpl implements SentenceTextBuilderService {
    private final ReplaceCharacterProperties replaceCharacterProperties;

    @Override
    public String buildSpellerRequest(String sentence) {
        return sentence.replace(replaceCharacterProperties.getSyntscDelimiter(), replaceCharacterProperties.getSpellerDelimiter());
    }

    @Override
    public String buildFinalSentence(String spellerRequest, List<CertainWordResponse> spellerResponse) {
        var fixedSentenceBuilder = new StringBuilder();
        var words = spellerRequest.split("\\+");
            int spellerResponseIndex = 0;
            int wordsIndex = 0;
            while (wordsIndex < words.length) {
                var certainWordResponse = spellerResponse.get(spellerResponseIndex);
                if (certainWordResponse.word().equals(words[wordsIndex])) {
                    fixedSentenceBuilder.append(certainWordResponse.s().get(0));
                    spellerResponseIndex++;
                } else {
                    fixedSentenceBuilder.append(words[wordsIndex]);
                }
                wordsIndex++;
                fixedSentenceBuilder.append(wordsIndex != words.length ? " " : "");
            }
            return fixedSentenceBuilder.toString();
    }
}

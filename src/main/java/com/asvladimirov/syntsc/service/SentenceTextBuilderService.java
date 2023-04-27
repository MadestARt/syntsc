package com.asvladimirov.syntsc.service;

import com.asvladimirov.syntsc.integration.api.CertainWordResponse;

import java.util.List;

public interface SentenceTextBuilderService {

    String buildSpellerRequest(String sentence);

    String buildFinalSentence(String spellerRequest, List<CertainWordResponse> spellerResponse);
}

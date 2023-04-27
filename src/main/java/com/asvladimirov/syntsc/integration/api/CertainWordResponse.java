package com.asvladimirov.syntsc.integration.api;

import java.util.List;

public record CertainWordResponse(
        int code,
        int pos,
        int row,
        int col,
        int len,
        String word,
        List<String> s
) {
}

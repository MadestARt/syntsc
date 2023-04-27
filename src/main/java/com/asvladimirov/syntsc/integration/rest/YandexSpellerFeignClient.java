package com.asvladimirov.syntsc.integration.rest;

import com.asvladimirov.syntsc.integration.api.CertainWordResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "yandexSpeller",url = "${feign.clients.yandexSpeller.url}")
public interface YandexSpellerFeignClient {

    @GetMapping(value = "/checkText")
    List<CertainWordResponse> checkText(
            @RequestParam String text
    );
}

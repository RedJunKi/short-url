package com.shortUrl.demo.domain;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/")
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/register")
    @ResponseBody
    public String makeShortUrl(@RequestBody String originalUrl) {
        return urlService.makeShortURl(originalUrl);
    }

    @GetMapping("/{shortUrl}")
    public String redirectToOriginalUrl(@PathVariable String shortUrl) {
        String originalUrl = urlService.findOriginalUrlByShortUrl(shortUrl);

        if (!originalUrl.startsWith("http://") && !originalUrl.startsWith("https://")) {
            originalUrl = "http://" + originalUrl;
        }

        return "redirect:" + originalUrl;
    }
}

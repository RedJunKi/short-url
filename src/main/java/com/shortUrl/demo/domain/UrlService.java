package com.shortUrl.demo.domain;

import com.shortUrl.demo.util.Base62Encoder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class UrlService {

    private final UrlRepository urlRepository;

    public String makeShortURl(String originalUrl) {
        Optional<Url> findUrl = urlRepository.findByOriginalUrl(originalUrl);

        if (findUrl.isPresent()) {
            Url url = findUrl.get();
            return url.getShortUrl();
        }

        Url url = new Url(originalUrl);

        url = urlRepository.save(url);

        return url.getShortUrl();
    }

    public String findOriginalUrlByShortUrl(String shortUrl) {
        Optional<Url> findUrl = urlRepository.findByShortUrl(shortUrl);

        if (findUrl.isEmpty()) {
            throw new IllegalArgumentException("해당 URL을 찾을 수 없음");
        }

        Url url = findUrl.get();
        url.addCallCount();

        return url.getOriginalUrl();
    }
}

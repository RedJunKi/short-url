package com.shortUrl.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UrlRepository extends JpaRepository<Url, Long> {
    Optional<Url> findByOriginalUrl(String originalUrl);
    Optional<Url> findByShortUrl(String shortUrl);

}

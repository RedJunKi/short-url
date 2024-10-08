package com.shortUrl.demo.domain;

import com.shortUrl.demo.util.Base62Encoder;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String originalUrl;
    private String shortUrl;
    private int callCount;

    public Url(String originalUrl) {
        this.originalUrl = originalUrl;
        callCount = 1;
    }

    public void addCallCount() {
        callCount++;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public Long getId() {
        return id;
    }

    @PostPersist
    public void recodeShortUrl() {
        this.shortUrl = Base62Encoder.encode(this.id);
    }

    public String getOriginalUrl() {
        return originalUrl;
    }
}

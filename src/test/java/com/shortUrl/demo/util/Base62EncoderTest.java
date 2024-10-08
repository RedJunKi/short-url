package com.shortUrl.demo.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Base62EncoderTest {

    @Test
    void Base62인코딩_테스트() {
        String encode = Base62Encoder.encode(100L);

        Assertions.assertThat(encode).isEqualTo("000001C");
    }

}
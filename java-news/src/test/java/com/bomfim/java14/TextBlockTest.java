package com.bomfim.java14;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TextBlockTest {

    @Test
    void shouldCompareTextBlockAndString() {
        String html = "<html>\n" +
                "    <body>\n" +
                "        <p>Hello, world</p>\n" +
                "    </body>\n" +
                "</html>\n";
        assertThat(new TextBlock().getHtmlBlockText()).isEqualTo(html);
    }

    @Test
    void shouldCompareTextBlockAndStringWithStrip() {
        String html = "SELECT * FROM TABLE;\n" +
                "UNION ALL\n" +
                "SELECT * FROM TABLE_B;\n";
        assertThat(new TextBlock().getSqlBlockText()).isEqualTo(html);
    }
}
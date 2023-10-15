package com.bomfim.java14;

/**
 * <a href="https://openjdk.org/jeps/368">JEP 368: Text Blocks (Second Preview)</a>
 */
public class TextBlock {

    public String getHtmlBlockText() {
        return """
                <html>
                    <body>
                        <p>Hello, world</p>
                    </body>
                </html>
                """;
    }

    public String getSqlBlockText() {
        return """
                SELECT * FROM TABLE;
                UNION ALL
                SELECT * FROM TABLE_B;
                """;
    }

}

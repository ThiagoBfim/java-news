package com.bomfim.improvements;

public class StringPoem {

    /**
     * Using String concatenation
     *
     * @param author author from the poem.
     * @return poem.
     */
    public String writePoem(String author) {
        return "Over hill, over dale,\n" +
                "Thorough bush, thorough brier,\n" +
                "Over park, over pale,\n" +
                "Thorough flood, thorough fire!\n" +
                "I do wander everywhere,\n" +
                "Swifter than the moon's sphere;\n" +
                "And I serve the Fairy Queen,\n" +
                "To dew her orbs upon the green;\n" +
                "The cowslips tall her pensioners be;\n" +
                "In their gold coats spots you see;\n" +
                "Those be rubies, fairy favours;\n" +
                "In those freckles live their savours;\n" +
                "I must go seek some dewdrops here,\n" +
                "And hang a pearl in every cowslip's ear."
                + " - " + author;
    }

    /**
     * Using StringBuilder concatenation
     *
     * @param author author from the poem.
     * @return poem.
     */
    public String writePoemBuilder(String author) {
        return new StringBuilder()
                .append("Over hill, over dale,\n")
                .append("Thorough bush, thorough brier,\n")
                .append("Over park, over pale,\n")
                .append("Thorough flood, thorough fire!\n")
                .append("I do wander everywhere,\n")
                .append("Swifter than the moon's sphere;\n")
                .append("And I serve the Fairy Queen,\n")
                .append("To dew her orbs upon the green;\n")
                .append("The cowslips tall her pensioners be;\n")
                .append("In their gold coats spots you see;\n")
                .append("Those be rubies, fairy favours;\n")
                .append("In those freckles live their savours;\n")
                .append("I must go seek some dewdrops here,\n")
                .append("And hang a pearl in every cowslip's ear.")
                .append(" - ")
                .append(author)
                .toString();
    }

    /**
     * Using Text Blocks: JEP 378: Text Blocks
     * From java 15
     *
     * @param author author from the poem.
     * @return poem.
     */
    public String writePoemTextBlock(String author) {
        return """
                Over hill, over dale,
                Thorough bush, thorough brier,
                Over park, over pale,
                Thorough flood, thorough fire!
                I do wander everywhere,
                Swifter than the moon's sphere;
                And I serve the Fairy Queen,
                To dew her orbs upon the green;
                The cowslips tall her pensioners be;
                In their gold coats spots you see;
                Those be rubies, fairy favours;
                In those freckles live their savours;
                I must go seek some dewdrops here,
                And hang a pearl in every cowslip's ear.
                """
                .concat(" - ")
                .concat(author);
    }

    /**
     * Using String template: JEP 430: String Templates (Preview)
     * From Java 21
     *
     * @param author author from the poem.
     * @return poem.
     */
    public String writePoemStringTemplate(String author) {
        return STR."""
                Over hill, over dale,
                Thorough bush, thorough brier,
                Over park, over pale,
                Thorough flood, thorough fire!
                I do wander everywhere,
                Swifter than the moon's sphere;
                And I serve the Fairy Queen,
                To dew her orbs upon the green;
                The cowslips tall her pensioners be;
                In their gold coats spots you see;
                Those be rubies, fairy favours;
                In those freckles live their savours;
                I must go seek some dewdrops here,
                And hang a pearl in every cowslip's ear.
                - \{author}
                """;
    }

}

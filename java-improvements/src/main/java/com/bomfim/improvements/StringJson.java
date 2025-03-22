package com.bomfim.improvements;

import com.bomfim.improvements.RecordPokemon.PokemonRecord;

public class StringJson {

    /**
     * Using String concatenation
     *
     * @param pokemon pokemon to display in Json
     * @return json.
     */
    public String writeJson(PokemonRecord pokemon) {
        return "{\n" +
               "  \"id\": " + pokemon.id() + ",\n" +
               "  \"name\": \"" + pokemon.name() + "\",\n" +
               "  \"type\": [\n" +
               "    \"" + String.join("\",\"", pokemon.type()) +
               "\"\n" +
               "  ],\n" +
               "  \"species\": \"" + pokemon.species() + "\",\n" +
               "}\n";
    }

    /**
     * Using StringBuilder concatenation
     *
     * @param pokemon pokemon to display in Json
     * @return json.
     */
    public String writeJsonBuilder(PokemonRecord pokemon) {
        return new StringBuilder()
                .append("{\n")
                .append("  \"id\": ").append(pokemon.id())
                .append(",\n")
                .append("  \"name\": \"").append(pokemon.name())
                .append("\",\n  \"type\": [\n    \"")
                .append(String.join("\",\"", pokemon.type()))
                .append("\"\n  ],\n")
                .append("  \"species\": \"")
                .append(pokemon.species())
                .append("\",\n}\n").toString();
    }

    /**
     * Using Text Blocks: JEP 378: Text Blocks
     * From java 15
     *
     * @param pokemon pokemon to display in Json
     * @return json.
     */
    public String writeJsonTextBlock(PokemonRecord pokemon) {
        return """
                {
                  "id": %s,
                  "name": "%s",
                  "type": [
                    "%s"
                  ],
                  "species": "%s",
                }
                """
                .formatted(pokemon.id(), pokemon.name(),
                        String.join("\",\"", pokemon.type()),
                        pokemon.species());
    }

//    /**
//     * Using String template: JEP 430: String Templates (Preview)
//     * From Java 21
//     *
//     * @param pokemon pokemon to display in Json
//     * @return json.
//     */
//    public String writePokemonStringTemplate(PokemonRecord pokemon) {
//        return STR. """
//                {
//                  "id": \{ pokemon.id() },
//                  "name": "\{ pokemon.name() }",
//                  "type": [
//                    "\{ String.join("\",\"", pokemon.type()) }"
//                  ],
//                  "species": "\{ pokemon.species() }",
//                }
//                """ ;
//    }

}

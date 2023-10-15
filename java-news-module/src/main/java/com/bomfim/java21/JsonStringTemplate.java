package com.bomfim.java21;

import java.util.List;

public class JsonStringTemplate {

    /**
     * Using String template: JEP 430: String Templates (Preview)
     * From Java 21
     *
     * @param pokemon pokemon to display in Json
     * @return json.
     */
    public String writePokemonStringTemplate(PokemonRecord pokemon) {
        return STR. """
                {
                  "id": \{ pokemon.id() },
                  "name": "\{ pokemon.name() }",
                  "type": [
                    "\{ String.join("\",\"", pokemon.type()) }"
                  ],
                  "species": "\{ pokemon.species() }",
                }
                """ ;
    }

    public record PokemonRecord(Integer id, String name, List<String> type, String species) {
    }
}

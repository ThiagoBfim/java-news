package com.bomfim.improvements;

import java.util.List;

public class RecordPokemon {

    public static final class Pokemon {
        private final Integer id;
        private final String name;
        private final List<String> type;
        private final String species;

        public Pokemon(Integer id, String name, List<String> type, String species) {
            this.id = id;
            this.name = name;
            this.type = type;
            this.species = species;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public List<String> getType() {
            return type;
        }

        public String getSpecies() {
            return species;
        }
    }

    /**
     * Pokemon Using Record - JEP 395: Records
     * From Java 16
     *
     * @param id
     * @param name
     * @param type
     * @param species
     */
    public record PokemonRecord(Integer id, String name, List<String> type, String species) {
    }


}

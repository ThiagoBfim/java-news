package com.bomfim.improvements;


public class Pokeball {

    private Pokemon pokemon;

    public Pokeball(Pokemon pokemon) {
        this.pokemon = pokemon;
        /*Expensive call*/
    }

    public static class Ultraball extends Pokeball {

        public Ultraball(String name, Integer level) {
            if (level > 80) {
                throw new RuntimeException("The level of Pokémon is too high for this Pokeball.");
            }
            super(new Pokemon(name, level));
        }

    }

    public static class UltraballOld extends Pokeball {

        public UltraballOld(String name, Integer level) {
            super(validatePokemon(name, level));
        }

        private static Pokemon validatePokemon(String name, Integer level) {
            if (level > 80) {
                throw new RuntimeException("The level of Pokémon is too high for this Pokeball.");
            }
            return new Pokemon(name, level);
        }

    }

    public record Pokemon(String name, Integer level) {
    }
}

package com.bomfim.java22;

/**
 * <a href="https://openjdk.org/jeps/447">JEP 447: Statements before super(...) (Preview)</a>
 */
public class StatementBeforeSuper {


    public Animal createAnimal(String name) {
        return new Pet(name);
    }

    class Animal {
        private final String name;

        Animal(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    class Pet extends Animal {
        private final String customName;

        Pet(String customName) {
            String name;
            if (customName.startsWith("Bella") || customName.startsWith("Ollie")) {
                name = "Dog";
            } else {
                name = "Cat";
            }
            super(name);
            this.customName = customName;
        }
    }
}

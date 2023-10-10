package com.bomfim.strings;

public class AnimalSwitchPattern {

    /**
     * Sealed classes: JEP 409: Sealed Classes
     * From Java 17
     */
    public abstract static sealed class Animal permits Toucan, Lion {
        public abstract String getFood();
    }

    public static final class Toucan extends Animal {

        public void fly() {
            System.out.println("Flying");
        }

        @Override
        public String getFood() {
            return "fruit";
        }
    }

    public static final class Lion extends Animal {

        public void hunt() {
            System.out.println("Hunting");
        }

        public void climbTree() {
            System.out.println("Climbing Tree");
        }

        @Override
        public String getFood() {
            return "Meat";
        }
    }

//    public static final class Shark extends Animal {
//
//        public void swim() {
//            System.out.println("Swimming");
//        }
//
//
//        @Override
//        public String getFood() {
//            return "Fish";
//        }
//    }

    /**
     * Using Pattern Matching for switch - JEP 441: Pattern Matching for switch
     * From java 21
     *
     * @param animal animal to do the action.
     */
    public void doAction(Animal animal) {
        switch (animal) {
            case null -> {}
            case Lion lion -> {
                lion.hunt();
                lion.climbTree();
            }
            case Toucan toucan -> toucan.fly();
        }
    }

    /**
     * Wrong Way
     *
     * @param animal animal to do the action.
     */
    public String eatWrong(Animal animal) {
        return switch (animal) {
            case null -> null;
            case Lion lion -> lion.getFood();
            case Toucan toucan -> toucan.getFood();
        };
    }

}

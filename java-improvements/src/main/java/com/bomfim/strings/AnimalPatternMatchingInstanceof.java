package com.bomfim.strings;

public class AnimalPatternMatchingInstanceof {

    public abstract static class Animal {

        public abstract String getFood();
    }

    public static class Toucan extends Animal {

        public void fly() {
            System.out.println("Flying");
        }

        @Override
        public String getFood() {
            return "Fruit";
        }
    }

    public static class Lion extends Animal {

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

    /**
     * Wrong way, in this case it iS better to use polymorphism
     *
     * @param animal animal to eat.
     * @return
     */
    public String eatWrong(Animal animal) {
        if (animal instanceof Toucan) {
            Toucan toucan = (Toucan) animal;
            return toucan.getFood();
        }
        if (animal instanceof Lion) {
            Lion lion = (Lion) animal;
            return lion.getFood();
        }
        return null;
    }

    /**
     * Write way, using polymorphism
     *
     * @param animal animal to eat.
     */
    public String eat(Animal animal) {
        return animal.getFood();
    }

    public void doActionOld(Animal animal) {
        if (animal instanceof Toucan) {
            Toucan toucan = (Toucan) animal;
            toucan.fly();
        }
        if (animal instanceof Lion) {
            Lion lion = (Lion) animal;
            lion.hunt();
            lion.climbTree();
        }
    }

    /**
     * Using Pattern Matching for instanceof - JEP 394: Pattern Matching for instanceof
     * From Java 16
     *
     * @param animal animal to do the action.
     */
    public void doAction(Animal animal) {
        if (animal instanceof Toucan toucan) {
            toucan.fly();
        }
        if (animal instanceof Lion lion) {
            lion.hunt();
            lion.climbTree();
        }
    }

}

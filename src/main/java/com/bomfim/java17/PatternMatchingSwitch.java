package com.bomfim.java17;

import com.bomfim.java15.SealedClass;

/**
 * <a href="https://openjdk.org/jeps/406">JEP 406: Pattern Matching for switch (Preview)</a>
 */
public class PatternMatchingSwitch {


    public double calculateArea(SealedClass.Shape shape){
        return switch (shape) {
            case SealedClass.Circle c -> {
                c.printCircleInfo();
                yield  c.calculateArea();
            }
            case SealedClass.Rectangle r -> {
                r.printRectangleInfo();
                yield  r.calculateArea();
            }
            case SealedClass.Square s ->  {
                s.printSquareInfo();
                yield  s.calculateArea();
            }
        };
    }
}

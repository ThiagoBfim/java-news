package com.bomfim.java14;

import java.util.Collection;

/**
 * <a href="https://openjdk.org/jeps/305">JEP 305: Pattern Matching for instanceof (Preview)</a>
 */
public class PatternMatching {

    int getLength(Object obj){
        if (obj instanceof String str) {
            return str.length();
        }
        if (obj instanceof Number numb) {
            return numb.intValue();
        }
        if (obj instanceof Collection collection) {
            return collection.size();
        }
        return 0;
    }


}

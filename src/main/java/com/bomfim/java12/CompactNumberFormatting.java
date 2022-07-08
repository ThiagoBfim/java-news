package com.bomfim.java12;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * <a href="https://www.baeldung.com/java-12-new-features#compactNumbers">Compact Number Formatting</a>
 */
public class CompactNumberFormatting {

    public String compactNumberLong(Long value){
        NumberFormat formatLong = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.LONG);
        formatLong.setMaximumFractionDigits(2);
        return formatLong.format(value);
    }
    public String compactNumberShort(Long value){
        NumberFormat formatShort = NumberFormat.getCompactNumberInstance(new Locale("en", "US"), NumberFormat.Style.SHORT);
        formatShort.setMaximumFractionDigits(2);
        return formatShort.format(value);
    }


}

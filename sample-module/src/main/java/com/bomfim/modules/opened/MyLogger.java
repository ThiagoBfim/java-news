package com.bomfim.modules.opened;

import com.bomfim.modules.InternalSystem;

public class MyLogger {

    public static void logError(String text){
        new InternalSystem().sysOut(text);
    }
}

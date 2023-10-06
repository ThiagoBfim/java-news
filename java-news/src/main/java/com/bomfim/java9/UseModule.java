package com.bomfim.java9;

import com.bomfim.modules.opened.MyLogger;

/**
 * <a href="https://www.oracle.com/pt/corporate/features/understanding-java-9-modules.html">Java 9 Modules</a>
 * <a href="https://www.baeldung.com/java-9-modularity">Java 9 Modularity</a>
 *
 */
public class UseModule {

    public static void callModule() {
        MyLogger.logError("Hello World");
        // new com.bomfim.modules.InternalSystem(); Do not have access
    }


}

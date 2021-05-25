package org.junit.runner;

import java.util.ArrayList;
import java.util.List;
public class JUnitCommandLineParseResult {
    public final List<String> a = new ArrayList();
    public final List<Class<?>> b = new ArrayList();
    public final List<Throwable> c = new ArrayList();

    public static class CommandLineParserError extends Exception {
        private static final long serialVersionUID = 1;

        public CommandLineParserError(String str) {
            super(str);
        }
    }
}

package org.junit.runner;
public final class FilterFactoryParams {
    public final Description a;
    public final String b;

    public FilterFactoryParams(Description description, String str) {
        if (str == null || description == null) {
            throw null;
        }
        this.a = description;
        this.b = str;
    }

    public String getArgs() {
        return this.b;
    }

    public Description getTopLevelDescription() {
        return this.a;
    }
}

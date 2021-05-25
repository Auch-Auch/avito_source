package com.facebook.internal.logging;

import java.io.Serializable;
public class LogEvent implements Serializable {
    private static final long serialVersionUID = 1;
    public String a;
    public LogCategory b;

    public LogEvent(String str, LogCategory logCategory) {
        this.a = str;
        this.b = logCategory;
    }

    public String getEventName() {
        return this.a;
    }

    public LogCategory getLogCategory() {
        return this.b;
    }

    public String upperCaseEventName() {
        String upperCase = this.a.toUpperCase();
        this.a = upperCase;
        return upperCase;
    }
}

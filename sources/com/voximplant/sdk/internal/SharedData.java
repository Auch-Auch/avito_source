package com.voximplant.sdk.internal;

import java.util.concurrent.Executor;
public class SharedData {
    public static String a;
    public static Executor b;

    public static Executor getCallbackExecutor() {
        return b;
    }

    public static String getUser() {
        return a;
    }
}

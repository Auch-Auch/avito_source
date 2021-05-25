package com.avito.security;

import ru.ok.android.sdk.OkListener;
public class k {
    public static void a(Throwable th, Throwable th2) {
        j1.b(th, "$this$addSuppressed");
        j1.b(th2, OkListener.KEY_EXCEPTION);
        if (th != th2) {
            s0.a.a(th, th2);
        }
    }
}

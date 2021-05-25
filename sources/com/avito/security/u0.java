package com.avito.security;

import ru.ok.android.sdk.OkListener;
public class u0 extends r0 {
    @Override // com.avito.security.r0
    public void a(Throwable th, Throwable th2) {
        j1.b(th, "cause");
        j1.b(th2, OkListener.KEY_EXCEPTION);
        th.addSuppressed(th2);
    }
}

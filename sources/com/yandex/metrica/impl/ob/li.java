package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.us;
public class li implements nh<StackTraceElement, us.d> {
    @NonNull
    /* renamed from: a */
    public us.d b(@NonNull StackTraceElement stackTraceElement) {
        us.d dVar = new us.d();
        dVar.b = stackTraceElement.getClassName();
        dVar.c = (String) abw.b(stackTraceElement.getFileName(), "");
        dVar.d = stackTraceElement.getLineNumber();
        dVar.e = stackTraceElement.getMethodName();
        dVar.f = stackTraceElement.isNativeMethod();
        return dVar;
    }

    @NonNull
    public StackTraceElement a(@NonNull us.d dVar) {
        throw new UnsupportedOperationException();
    }
}

package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.Nullable;
import java.util.List;
public class ld {
    @Nullable
    public final String a;
    @Nullable
    public final Throwable b;
    @Nullable
    public final ky c;
    @Nullable
    public final List<StackTraceElement> d;
    @Nullable
    public final String e;
    @Nullable
    public final Boolean f;

    public ld(@Nullable Throwable th, @Nullable ky kyVar, @Nullable List<StackTraceElement> list, @Nullable String str, @Nullable Boolean bool) {
        this.b = th;
        if (th == null) {
            this.a = "";
        } else {
            this.a = th.getClass().getName();
        }
        this.c = kyVar;
        this.d = list;
        this.e = str;
        this.f = bool;
    }

    @Nullable
    @Deprecated
    public Throwable a() {
        return this.b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Throwable th = this.b;
        if (th != null) {
            StackTraceElement[] b2 = dl.b(th);
            for (StackTraceElement stackTraceElement : b2) {
                StringBuilder L = a.L("at ");
                L.append(stackTraceElement.getClassName());
                L.append(".");
                L.append(stackTraceElement.getMethodName());
                L.append("(");
                L.append(stackTraceElement.getFileName());
                L.append(":");
                L.append(stackTraceElement.getLineNumber());
                L.append(")\n");
                sb.append(L.toString());
            }
        }
        StringBuilder L2 = a.L("UnhandledException{errorName='");
        a.k1(L2, this.a, '\'', ", exception=");
        L2.append(this.b);
        L2.append("\n");
        L2.append(sb.toString());
        L2.append('}');
        return L2.toString();
    }
}

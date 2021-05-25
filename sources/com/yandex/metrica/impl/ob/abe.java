package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.Locale;
public abstract class abe extends aat {
    private static String a = "";
    @NonNull
    private final String b;

    public abe(@Nullable String str) {
        super(false);
        this.b = String.format("[%s] ", dl.b(str));
    }

    public static void a(Context context) {
        a = String.format("[%s] : ", context.getPackageName());
    }

    @Override // com.yandex.metrica.impl.ob.aat
    public String d(String str, Object[] objArr) {
        return String.format(Locale.US, str, objArr);
    }

    @Override // com.yandex.metrica.impl.ob.aat
    @NonNull
    public String g() {
        return a.c3(dh.b(a, ""), dh.b(this.b, ""));
    }
}

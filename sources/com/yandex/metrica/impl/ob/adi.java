package com.yandex.metrica.impl.ob;

import a2.b.a.a.a;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public class adi {
    private final adl a;
    private final adl b;
    private final ade c;
    @NonNull
    private final abl d;
    private final String e;

    public adi(int i, int i2, int i3, @NonNull String str, @NonNull abl abl) {
        this(new ade(i), new adl(i2, a.c3(str, "map key"), abl), new adl(i3, a.c3(str, "map value"), abl), str, abl);
    }

    public adl a() {
        return this.a;
    }

    public adl b() {
        return this.b;
    }

    public ade c() {
        return this.c;
    }

    @VisibleForTesting
    public adi(@NonNull ade ade, @NonNull adl adl, @NonNull adl adl2, @NonNull String str, @NonNull abl abl) {
        this.c = ade;
        this.a = adl;
        this.b = adl2;
        this.e = str;
        this.d = abl;
    }

    public void a(@NonNull String str) {
        if (this.d.c()) {
            this.d.b("The %s has reached the limit of %d items. Item with key %s will be ignored", this.e, Integer.valueOf(this.c.a()), str);
        }
    }
}

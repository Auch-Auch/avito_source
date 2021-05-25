package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
public class adj {
    @NonNull
    private final adi a;
    @NonNull
    private final adh b;

    public adj(@NonNull abl abl, @NonNull String str) {
        this(new adi(30, 50, 4000, str, abl), new adh(4500, str, abl));
    }

    public boolean a(@Nullable abj abj, @NonNull String str, @Nullable String str2) {
        if (abj == null) {
            return false;
        }
        String a3 = this.a.a().a(str);
        String a4 = this.a.b().a(str2);
        if (abj.containsKey(a3)) {
            String str3 = (String) abj.get(a3);
            if (a4 == null || !a4.equals(str3)) {
                return a(abj, a3, a4, str3);
            }
            return false;
        } else if (a4 != null) {
            return a(abj, a3, a4, null);
        } else {
            return false;
        }
    }

    @VisibleForTesting
    public adj(@NonNull adi adi, @NonNull adh adh) {
        this.a = adi;
        this.b = adh;
    }

    public synchronized boolean a(@NonNull abj abj, @NonNull String str, @Nullable String str2, @Nullable String str3) {
        if (abj.size() >= this.a.c().a()) {
            if (this.a.c().a() != abj.size() || !abj.containsKey(str)) {
                this.a.a(str);
                return false;
            }
        }
        if (!this.b.a(abj, str, str2)) {
            abj.put(str, str2);
            return true;
        }
        this.b.a(str);
        return false;
    }
}

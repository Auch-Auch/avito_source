package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
public class adh {
    private final String a;
    private final int b;
    @NonNull
    private final abl c;

    public adh(int i, @NonNull String str, @NonNull abl abl) {
        this.b = i;
        this.a = str;
        this.c = abl;
    }

    public boolean a(@NonNull abj abj, @NonNull String str, @Nullable String str2) {
        int a3 = abj.a();
        if (str2 != null) {
            a3 += str2.length();
        }
        if (abj.containsKey(str)) {
            String str3 = (String) abj.get(str);
            if (str3 != null) {
                a3 -= str3.length();
            }
        } else {
            a3 += str.length();
        }
        return a3 > this.b;
    }

    public void a(@NonNull String str) {
        if (this.c.c()) {
            this.c.b("The %s has reached the total size limit that equals %d symbols. Item with key %s will be ignored", this.a, Integer.valueOf(this.b), str);
        }
    }
}

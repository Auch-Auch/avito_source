package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.uu;
public class rx {
    @NonNull
    private final pr a;
    @NonNull
    private final rw b;

    public rx(@NonNull pr prVar, @NonNull rw rwVar) {
        this.a = prVar;
        this.b = rwVar;
    }

    @Nullable
    public uu.b.C0342b a(long j, @Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            rb a3 = this.a.a(j, str);
            if (a3 != null) {
                return this.b.a(a3);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}

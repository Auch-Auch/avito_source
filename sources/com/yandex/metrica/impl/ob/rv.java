package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.uu;
public class rv {
    @NonNull
    private final pr a;
    @NonNull
    private final ru b;

    public rv(@NonNull pr prVar, @NonNull ru ruVar) {
        this.a = prVar;
        this.b = ruVar;
    }

    @Nullable
    public uu.b.a a(long j, @Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            qk b2 = this.a.b(j, str);
            if (b2 != null) {
                return this.b.a(b2);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}

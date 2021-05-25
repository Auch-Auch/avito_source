package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.io.UnsupportedEncodingException;
public class pr {
    @NonNull
    private Context a;

    public pr(@NonNull Context context) {
        this.a = context;
    }

    @Nullable
    public String a(@NonNull rb rbVar) {
        String a3 = rq.a(rbVar);
        if (a3 != null) {
            return a(a3);
        }
        return null;
    }

    @Nullable
    public qk b(long j, @NonNull String str) {
        String b = b(str);
        if (b == null) {
            return null;
        }
        return rq.b(j, b);
    }

    @Nullable
    public rb a(long j, @NonNull String str) {
        String b = b(str);
        if (b == null) {
            return null;
        }
        return rq.a(j, b);
    }

    @Nullable
    public String b(@NonNull String str) {
        try {
            return abo.b(this.a, str);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }

    @Nullable
    public String a(@NonNull qk qkVar) {
        String a3 = rq.a(qkVar);
        if (a3 == null) {
            return null;
        }
        return a(a3);
    }

    @Nullable
    public String a(@NonNull String str) {
        try {
            return abo.a(this.a, str);
        } catch (UnsupportedEncodingException unused) {
            return null;
        }
    }
}

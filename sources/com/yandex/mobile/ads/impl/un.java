package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import com.yandex.mobile.ads.impl.tb;
import java.io.UnsupportedEncodingException;
public abstract class un<R, T> extends tc<R, T> {
    private un(String str, tb.a<T> aVar, Context context, R r, hw<R, T> hwVar) {
        super(context, 0, str, aVar, r, hwVar);
    }

    @Override // com.yandex.mobile.ads.impl.tc
    public final sa<T> a(@NonNull rx rxVar, int i) {
        String str;
        try {
            str = new String(rxVar.b, sp.a(rxVar.c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(rxVar.b);
        }
        try {
            return c(a(str));
        } catch (Exception e) {
            return a(e);
        }
    }

    public abstract T a(String str) throws Exception;

    public sa<T> c(T t) {
        return sa.a(t, null);
    }

    public un(String str, tb.a<T> aVar, Context context, R r, hw<R, T> hwVar, byte b) {
        this(str, aVar, context, r, hwVar);
    }

    public sa<T> a(Exception exc) {
        return sa.a(new tx(exc));
    }
}

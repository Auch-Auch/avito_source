package com.yandex.mobile.ads.impl;

import com.yandex.mobile.ads.impl.sa;
import java.io.UnsupportedEncodingException;
public final class sw extends ry<String> {
    private final sa.b<String> a;

    public sw(String str, sa.b<String> bVar, sa.a aVar) {
        super(0, str, aVar);
        this.a = bVar;
    }

    @Override // com.yandex.mobile.ads.impl.ry
    public final sa<String> a(rx rxVar) {
        String str;
        try {
            str = new String(rxVar.b, sp.a(rxVar.c));
        } catch (UnsupportedEncodingException unused) {
            str = new String(rxVar.b);
        }
        return sa.a(str, sp.a(rxVar));
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.yandex.mobile.ads.impl.ry
    public final /* synthetic */ void b(String str) {
        this.a.a(str);
    }
}

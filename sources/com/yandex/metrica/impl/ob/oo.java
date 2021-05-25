package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.uz;
import com.yandex.metrica.impl.ob.vb;
import com.yandex.metrica.impl.ob.vc;
import com.yandex.metrica.impl.ob.vd;
import com.yandex.metrica.impl.ob.ve;
public class oo {
    private acc a;

    public oo() {
        this(new acc());
    }

    public mw<ve.a> a() {
        return new mu(new nb(), new acd("AES/CBC/PKCS5Padding", this.a.a(), this.a.b()));
    }

    @NonNull
    public mw<vb.a> b() {
        return new mu(new mv(), new acd("AES/CBC/PKCS5Padding", this.a.a(), this.a.b()));
    }

    @NonNull
    public mw<uz.a> c() {
        return new mu(new ms(), new acd("AES/CBC/PKCS5Padding", this.a.a(), this.a.b()));
    }

    @NonNull
    public mw<vd.a> d() {
        return new mu(new na(), new acd("AES/CBC/PKCS5Padding", this.a.a(), this.a.b()));
    }

    public mw<vc.a> e() {
        return new mu(new mz(), new acd("AES/CBC/PKCS5Padding", this.a.a(), this.a.b()));
    }

    @VisibleForTesting
    public oo(acc acc) {
        this.a = acc;
    }
}

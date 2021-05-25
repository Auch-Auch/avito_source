package com.my.target;

import androidx.annotation.NonNull;
import com.my.target.ek;
import com.my.target.hq;
public class el implements ek, hq.a {
    @NonNull
    public final cb a;
    @NonNull
    public final ek.a b;
    public int c;

    public el(@NonNull cb cbVar, @NonNull ek.a aVar) {
        this.a = cbVar;
        this.b = aVar;
    }

    public static ek a(@NonNull cb cbVar, ek.a aVar) {
        return new el(cbVar, aVar);
    }

    @Override // com.my.target.ek
    public void a(@NonNull hq hqVar) {
        hqVar.setBanner(null);
        hqVar.setListener(null);
    }

    @Override // com.my.target.ek
    public void a(@NonNull hq hqVar, int i) {
        this.c = i;
        this.b.b(this.a);
        hqVar.setBanner(this.a);
        hqVar.setListener(this);
    }

    @Override // com.my.target.hq.a
    public void x(boolean z) {
        this.b.a(this.a, z, this.c);
    }
}

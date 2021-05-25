package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import com.yandex.metrica.impl.ob.wl;
import java.io.IOException;
public abstract class cb<T extends wl> extends ce<T> {
    @NonNull
    private final acn j;
    @NonNull
    private final aay k;
    @NonNull
    private final abt l;

    public cb(@NonNull T t) {
        this(new af(), new acg(), new aay(), new abs(), t);
    }

    public abstract void G();

    public abstract void H();

    @Override // com.yandex.metrica.impl.ob.ca
    public void a(byte[] bArr) {
        super.a(bArr);
    }

    @Override // com.yandex.metrica.impl.ob.ce, com.yandex.metrica.impl.ob.ca
    public boolean b() {
        boolean b = super.b();
        if (b) {
            G();
        } else if (p()) {
            H();
        }
        return b;
    }

    public boolean c(@NonNull byte[] bArr) {
        byte[] a;
        try {
            byte[] a3 = this.k.a(bArr);
            if (a3 == null || (a = this.j.a(a3)) == null) {
                return false;
            }
            a(a);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public void d() {
        super.d();
        a(this.l.a());
    }

    @Override // com.yandex.metrica.impl.ob.ca
    public boolean p() {
        return k() == 400;
    }

    public cb(@NonNull bz bzVar, @NonNull acn acn, @NonNull aay aay, @NonNull abt abt, @NonNull T t) {
        super(bzVar, t);
        this.j = acn;
        this.k = aay;
        this.l = abt;
        t.a(acn);
    }
}

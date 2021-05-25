package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
public class zk extends za {
    private int a;
    private za b;

    public zk(@NonNull Context context, @NonNull act act) {
        this(context.getApplicationContext(), new ado(), act);
    }

    @Override // com.yandex.metrica.impl.ob.zh
    public synchronized void a() {
        int i = this.a + 1;
        this.a = i;
        if (i == 1) {
            this.b.a();
        }
    }

    @Override // com.yandex.metrica.impl.ob.zh
    public synchronized void b() {
        int i = this.a - 1;
        this.a = i;
        if (i == 0) {
            this.b.b();
        }
    }

    @VisibleForTesting
    public zk(Context context, @NonNull ado ado, @NonNull act act) {
        if (ado.b(context, "android.hardware.telephony")) {
            this.b = new ze(context, act);
        } else {
            this.b = new zf();
        }
    }

    @Override // com.yandex.metrica.impl.ob.za
    public synchronized void a(zn znVar) {
        this.b.a(znVar);
    }

    @Override // com.yandex.metrica.impl.ob.za
    public synchronized void a(zc zcVar) {
        this.b.a(zcVar);
    }

    @Override // com.yandex.metrica.impl.ob.za
    public void a(boolean z) {
        this.b.a(z);
    }

    @Override // com.yandex.metrica.impl.ob.za
    public void a(@NonNull yb ybVar) {
        this.b.a(ybVar);
    }
}

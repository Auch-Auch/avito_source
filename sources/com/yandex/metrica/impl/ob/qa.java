package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.location.LocationListener;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.gpllibrary.a;
import com.yandex.metrica.gpllibrary.b;
public class qa extends qx implements pz {
    @NonNull
    private final b f;
    @Nullable
    private volatile a.b g;

    public qa(@NonNull Context context, @NonNull rj rjVar, @NonNull Looper looper, @NonNull so soVar) {
        this(context, rjVar, looper, soVar, new cf());
    }

    @Override // com.yandex.metrica.impl.ob.qx
    public boolean a() {
        a.b bVar = this.g;
        if (bVar == null || !this.c.a(this.b)) {
            return false;
        }
        try {
            this.f.a(bVar);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.yandex.metrica.impl.ob.qx
    public void b() {
        try {
            this.f.b();
        } catch (Throwable unused) {
        }
    }

    @Override // com.yandex.metrica.impl.ob.qx
    public void c() {
        if (this.c.a(this.b)) {
            try {
                this.f.a();
            } catch (Throwable unused) {
            }
        }
    }

    private qa(@NonNull Context context, @NonNull rj rjVar, @NonNull Looper looper, @NonNull so soVar, @NonNull cf cfVar) {
        this(context, looper, new qt(rjVar), cfVar.d(soVar));
    }

    @NonNull
    private static b a(@NonNull Context context, @NonNull LocationListener locationListener, @NonNull Looper looper) {
        if (cx.b("com.google.android.gms.location.LocationRequest")) {
            try {
                return new a(context, locationListener, looper, qx.a);
            } catch (Throwable unused) {
            }
        }
        return new pp();
    }

    @VisibleForTesting
    public qa(@NonNull Context context, @NonNull Looper looper, @NonNull LocationListener locationListener, @NonNull sp spVar) {
        this(context, looper, locationListener, spVar, a(context, locationListener, looper));
    }

    @VisibleForTesting
    public qa(@NonNull Context context, @NonNull Looper looper, @NonNull LocationListener locationListener, @NonNull sp spVar, @NonNull b bVar) {
        super(context, locationListener, spVar, looper);
        this.f = bVar;
    }

    @Override // com.yandex.metrica.impl.ob.pz
    public void a(@Nullable py pyVar) {
        pw pwVar;
        if (pyVar == null || (pwVar = pyVar.b) == null) {
            this.g = null;
        } else {
            this.g = pwVar.a;
        }
    }
}

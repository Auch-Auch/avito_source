package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.us;
import java.util.Arrays;
public class lk implements nh<Throwable, us.f> {
    @NonNull
    private lh a = new lh();

    @NonNull
    /* renamed from: a */
    public us.f b(@NonNull Throwable th) {
        return a(th, 1, 0);
    }

    @NonNull
    private us.f a(@NonNull Throwable th, int i, int i2) {
        us.f fVar = new us.f();
        fVar.b = th.getClass().getName();
        fVar.c = (String) abw.b(th.getMessage(), "");
        fVar.d = this.a.b(Arrays.asList(dl.b(th)));
        if (th.getCause() != null && i2 < i) {
            fVar.e = a(th.getCause(), 30, i2 + 1);
        }
        if (!dl.a(19) || i2 >= i) {
            fVar.f = new us.f[0];
        } else {
            a(fVar, th.getSuppressed(), i2);
        }
        return fVar;
    }

    @NonNull
    public Throwable a(@NonNull us.f fVar) {
        throw new UnsupportedOperationException();
    }

    @TargetApi(19)
    private void a(@NonNull us.f fVar, @Nullable Throwable[] thArr, int i) {
        int i2 = 0;
        if (thArr == null) {
            fVar.f = new us.f[0];
            return;
        }
        fVar.f = new us.f[thArr.length];
        int length = thArr.length;
        int i3 = 0;
        while (i2 < length) {
            fVar.f[i3] = a(thArr[i2], 1, i + 1);
            i2++;
            i3++;
        }
    }
}

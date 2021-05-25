package com.yandex.mobile.ads.nativeads;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.y;
import java.lang.ref.WeakReference;
public final class b implements y.a {
    @NonNull
    private final y a;
    @NonNull
    private final WeakReference<r> b;

    public b(@NonNull r rVar) {
        this.b = new WeakReference<>(rVar);
        y yVar = new y(new Handler(Looper.getMainLooper()));
        this.a = yVar;
        yVar.a(this);
    }

    @Override // com.yandex.mobile.ads.impl.y.a
    public final void a(int i, @Nullable Bundle bundle) {
        r rVar = this.b.get();
        if (rVar != null) {
            switch (i) {
                case 6:
                    rVar.e();
                    return;
                case 7:
                    rVar.d();
                    return;
                case 8:
                    rVar.b();
                    return;
                case 9:
                    rVar.a();
                    return;
                default:
                    return;
            }
        }
    }

    @NonNull
    public final y a() {
        return this.a;
    }
}

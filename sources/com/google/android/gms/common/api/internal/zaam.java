package com.google.android.gms.common.api.internal;

import androidx.annotation.BinderThread;
import com.google.android.gms.signin.internal.zad;
import com.google.android.gms.signin.internal.zam;
import java.lang.ref.WeakReference;
public final class zaam extends zad {
    private final WeakReference<zaad> zaa;

    public zaam(zaad zaad) {
        this.zaa = new WeakReference<>(zaad);
    }

    @Override // com.google.android.gms.signin.internal.zad, com.google.android.gms.signin.internal.zac
    @BinderThread
    public final void zaa(zam zam) {
        zaad zaad = this.zaa.get();
        if (zaad != null) {
            zaad.zaa.zaa(new zaal(this, zaad, zaad, zam));
        }
    }
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.concurrent.atomic.AtomicBoolean;
public final class zzbpx implements zzo {
    private final zzbtu zzfqj;
    private AtomicBoolean zzfqk = new AtomicBoolean(false);

    public zzbpx(zzbtu zzbtu) {
        this.zzfqj = zzbtu;
    }

    public final boolean isClosed() {
        return this.zzfqk.get();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onPause() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void onResume() {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzui() {
        this.zzfqk.set(true);
        this.zzfqj.onAdClosed();
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final void zzuj() {
        this.zzfqj.onAdOpened();
    }
}

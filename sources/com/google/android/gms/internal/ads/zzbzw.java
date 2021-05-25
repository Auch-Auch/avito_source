package com.google.android.gms.internal.ads;

import android.view.View;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
public class zzbzw {
    @Nullable
    private final zzbfq zzdgc;
    private final zzcaz zzfuz;

    public zzbzw(zzcaz zzcaz) {
        this(zzcaz, null);
    }

    @Nullable
    public final zzbfq zzahe() {
        return this.zzdgc;
    }

    public final zzcaz zzakm() {
        return this.zzfuz;
    }

    @Nullable
    public final View zzakn() {
        zzbfq zzbfq = this.zzdgc;
        if (zzbfq != null) {
            return zzbfq.getWebView();
        }
        return null;
    }

    @Nullable
    public final View zzako() {
        zzbfq zzbfq = this.zzdgc;
        if (zzbfq == null) {
            return null;
        }
        return zzbfq.getWebView();
    }

    public Set<zzbys<zzbsu>> zzb(zzbru zzbru) {
        return Collections.singleton(zzbys.zzb(zzbru, zzbbi.zzedz));
    }

    public Set<zzbys<zzbyh>> zzc(zzbru zzbru) {
        return Collections.singleton(zzbys.zzb(zzbru, zzbbi.zzedz));
    }

    public zzbzw(zzcaz zzcaz, @Nullable zzbfq zzbfq) {
        this.zzfuz = zzcaz;
        this.zzdgc = zzbfq;
    }

    public final zzbys<zzbwm> zzb(Executor executor) {
        return new zzbys<>(new zzbwm(this.zzdgc) { // from class: com.google.android.gms.internal.ads.zzbzy
            private final zzbfq zzepi;

            {
                this.zzepi = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbwm
            public final void zzaia() {
                zzbfq zzbfq = this.zzepi;
                if (zzbfq.zzaba() != null) {
                    zzbfq.zzaba().close();
                }
            }
        }, executor);
    }
}

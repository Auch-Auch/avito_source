package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdup;
import java.util.List;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
public abstract class zzduu<V, C> extends zzdup<V, C> {
    private List<zzduw<V>> zzhpk;

    public zzduu(zzdtf<? extends zzdvt<? extends V>> zzdtf, boolean z) {
        super(zzdtf, true, true);
        List<zzduw<V>> list;
        if (zzdtf.isEmpty()) {
            list = zzdtg.zzawt();
        } else {
            list = zzdto.zzep(zzdtf.size());
        }
        for (int i = 0; i < zzdtf.size(); i++) {
            list.add(null);
        }
        this.zzhpk = list;
    }

    @Override // com.google.android.gms.internal.ads.zzdup
    public final void zza(zzdup.zza zza) {
        super.zza(zza);
        this.zzhpk = null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.android.gms.internal.ads.zzduu<V, C> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzdup
    public final void zzaxe() {
        List<zzduw<V>> list = this.zzhpk;
        if (list != null) {
            set(zzj(list));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdup
    public final void zzb(int i, @NullableDecl V v) {
        List<zzduw<V>> list = this.zzhpk;
        if (list != null) {
            list.set(i, new zzduw<>(v));
        }
    }

    public abstract C zzj(List<zzduw<V>> list);
}

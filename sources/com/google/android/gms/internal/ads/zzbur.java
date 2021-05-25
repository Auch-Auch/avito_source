package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.Set;
public final class zzbur extends zzbxe<zzo> implements zzo {
    public zzbur(Set<zzbys<zzo>> set) {
        super(set);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onPause() {
        zza(zzbut.zzfst);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void onResume() {
        zza(zzbus.zzfst);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void zzui() {
        zza(zzbuq.zzfst);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzo
    public final synchronized void zzuj() {
        zza(zzbuv.zzfst);
    }
}

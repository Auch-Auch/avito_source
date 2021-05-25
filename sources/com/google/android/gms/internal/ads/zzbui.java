package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;
public final class zzbui extends zzbxe<AdMetadataListener> implements zzagl {
    private Bundle zzfsz = new Bundle();

    public zzbui(Set<zzbys<AdMetadataListener>> set) {
        super(set);
    }

    public final synchronized Bundle getAdMetadata() {
        return new Bundle(this.zzfsz);
    }

    @Override // com.google.android.gms.internal.ads.zzagl
    public final synchronized void zza(String str, Bundle bundle) {
        this.zzfsz.putAll(bundle);
        zza(zzbul.zzfst);
    }
}

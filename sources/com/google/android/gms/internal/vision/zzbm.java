package com.google.android.gms.internal.vision;

import android.util.Base64;
import java.io.IOException;
public final class zzbm extends zzbi<T> {
    private final /* synthetic */ zzbp zzgs;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbm(zzbo zzbo, String str, Object obj, boolean z, zzbp zzbp) {
        super(zzbo, str, obj, true, null);
        this.zzgs = zzbp;
    }

    @Override // com.google.android.gms.internal.vision.zzbi
    public final T zza(Object obj) {
        if (obj instanceof String) {
            try {
                return (T) this.zzgs.zzb(Base64.decode((String) obj, 3));
            } catch (IOException | IllegalArgumentException unused) {
            }
        }
        String zzag = super.zzag();
        String valueOf = String.valueOf(obj);
        String.valueOf(zzag).length();
        valueOf.length();
        return null;
    }
}

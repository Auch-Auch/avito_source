package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
public abstract class zzdwz<PrimitiveT, KeyT> {
    private final Class<PrimitiveT> zzhqt;

    public zzdwz(Class<PrimitiveT> cls) {
        this.zzhqt = cls;
    }

    public abstract PrimitiveT zzag(KeyT keyt) throws GeneralSecurityException;

    public final Class<PrimitiveT> zzaxp() {
        return this.zzhqt;
    }
}

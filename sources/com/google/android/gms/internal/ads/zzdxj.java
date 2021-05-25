package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzehz;
public abstract class zzdxj<KeyProtoT extends zzehz, PublicKeyProtoT extends zzehz> extends zzdwx<KeyProtoT> {
    private final Class<PublicKeyProtoT> zzhrg;

    @SafeVarargs
    public zzdxj(Class<KeyProtoT> cls, Class<PublicKeyProtoT> cls2, zzdwz<?, KeyProtoT>... zzdwzArr) {
        super(cls, zzdwzArr);
        this.zzhrg = cls2;
    }
}

package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import com.google.android.gms.internal.ads.zzebt;
import com.google.android.gms.internal.ads.zzehz;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
public abstract class zzdwx<KeyProtoT extends zzehz> {
    private final Class<KeyProtoT> zzhqt;
    private final Map<Class<?>, zzdwz<?, KeyProtoT>> zzhqu;
    private final Class<?> zzhqv;

    @SafeVarargs
    public zzdwx(Class<KeyProtoT> cls, zzdwz<?, KeyProtoT>... zzdwzArr) {
        this.zzhqt = cls;
        HashMap hashMap = new HashMap();
        for (zzdwz<?, KeyProtoT> zzdwz : zzdwzArr) {
            if (hashMap.containsKey(zzdwz.zzaxp())) {
                String valueOf = String.valueOf(zzdwz.zzaxp().getCanonicalName());
                throw new IllegalArgumentException(valueOf.length() != 0 ? "KeyTypeManager constructed with duplicate factories for primitive ".concat(valueOf) : new String("KeyTypeManager constructed with duplicate factories for primitive "));
            } else {
                hashMap.put(zzdwz.zzaxp(), zzdwz);
            }
        }
        if (zzdwzArr.length > 0) {
            this.zzhqv = zzdwzArr[0].zzaxp();
        } else {
            this.zzhqv = Void.class;
        }
        this.zzhqu = Collections.unmodifiableMap(hashMap);
    }

    public abstract String getKeyType();

    public final <P> P zza(KeyProtoT keyprotot, Class<P> cls) throws GeneralSecurityException {
        zzdwz<?, KeyProtoT> zzdwz = this.zzhqu.get(cls);
        if (zzdwz != null) {
            return (P) zzdwz.zzag(keyprotot);
        }
        String canonicalName = cls.getCanonicalName();
        throw new IllegalArgumentException(a.s2(a.q0(canonicalName, 41), "Requested primitive class ", canonicalName, " not supported."));
    }

    public final Class<KeyProtoT> zzaxr() {
        return this.zzhqt;
    }

    public abstract zzebt.zza zzaxs();

    public final Set<Class<?>> zzaxt() {
        return this.zzhqu.keySet();
    }

    public final Class<?> zzaxu() {
        return this.zzhqv;
    }

    public zzdxa<?, KeyProtoT> zzaxv() {
        throw new UnsupportedOperationException("Creating keys is not supported.");
    }

    public abstract void zzc(KeyProtoT keyprotot) throws GeneralSecurityException;

    public abstract KeyProtoT zzp(zzeff zzeff) throws zzegz;
}

package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzecb;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
public final class zzdxf<P> {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private final Class<P> zzhqs;
    private ConcurrentMap<String, List<zzdxi<P>>> zzhqz = new ConcurrentHashMap();
    private zzdxi<P> zzhra;

    private zzdxf(Class<P> cls) {
        this.zzhqs = cls;
    }

    public static <P> zzdxf<P> zza(Class<P> cls) {
        return new zzdxf<>(cls);
    }

    public final Class<P> zzaxp() {
        return this.zzhqs;
    }

    public final zzdxi<P> zzaxy() {
        return this.zzhra;
    }

    public final void zza(zzdxi<P> zzdxi) {
        if (zzdxi == null) {
            throw new IllegalArgumentException("the primary entry must be non-null");
        } else if (zzdxi.zzaya() == zzebu.ENABLED) {
            List<zzdxi<P>> list = this.zzhqz.get(new String(zzdxi.zzayc(), UTF_8));
            if (list == null) {
                list = Collections.emptyList();
            }
            if (!list.isEmpty()) {
                this.zzhra = zzdxi;
                return;
            }
            throw new IllegalArgumentException("the primary entry cannot be set to an entry which is not held by this primitive set");
        } else {
            throw new IllegalArgumentException("the primary entry has to be ENABLED");
        }
    }

    public final zzdxi<P> zza(P p, zzecb.zzb zzb) throws GeneralSecurityException {
        byte[] bArr;
        if (zzb.zzaya() == zzebu.ENABLED) {
            int i = zzdwr.zzhqp[zzb.zzayb().ordinal()];
            if (i == 1 || i == 2) {
                bArr = ByteBuffer.allocate(5).put((byte) 0).putInt(zzb.zzbbr()).array();
            } else if (i == 3) {
                bArr = ByteBuffer.allocate(5).put((byte) 1).putInt(zzb.zzbbr()).array();
            } else if (i == 4) {
                bArr = zzdws.zzhqq;
            } else {
                throw new GeneralSecurityException("unknown output prefix type");
            }
            zzdxi<P> zzdxi = new zzdxi<>(p, bArr, zzb.zzaya(), zzb.zzayb(), zzb.zzbbr());
            ArrayList arrayList = new ArrayList();
            arrayList.add(zzdxi);
            String str = new String(zzdxi.zzayc(), UTF_8);
            List<zzdxi<P>> put = this.zzhqz.put(str, Collections.unmodifiableList(arrayList));
            if (put != null) {
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(put);
                arrayList2.add(zzdxi);
                this.zzhqz.put(str, Collections.unmodifiableList(arrayList2));
            }
            return zzdxi;
        }
        throw new GeneralSecurityException("only ENABLED key is allowed");
    }
}

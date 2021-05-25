package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegp;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
public class zzegc {
    private static volatile boolean zzick = false;
    private static boolean zzicl = true;
    private static volatile zzegc zzicm;
    private static volatile zzegc zzicn;
    private static final zzegc zzico = new zzegc(true);
    private final Map<zza, zzegp.zzf<?, ?>> zzicp;

    public static final class zza {
        private final int number;
        private final Object object;

        public zza(Object obj, int i) {
            this.object = obj;
            this.number = i;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.object == zza.object && this.number == zza.number) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }
    }

    public zzegc() {
        this.zzicp = new HashMap();
    }

    public static zzegc zzbex() {
        zzegc zzegc = zzicm;
        if (zzegc == null) {
            synchronized (zzegc.class) {
                zzegc = zzicm;
                if (zzegc == null) {
                    zzegc = zzico;
                    zzicm = zzegc;
                }
            }
        }
        return zzegc;
    }

    public static zzegc zzbey() {
        zzegc zzegc = zzicn;
        if (zzegc != null) {
            return zzegc;
        }
        synchronized (zzegc.class) {
            zzegc zzegc2 = zzicn;
            if (zzegc2 != null) {
                return zzegc2;
            }
            zzegc zzc = zzegn.zzc(zzegc.class);
            zzicn = zzc;
            return zzc;
        }
    }

    public final <ContainingType extends zzehz> zzegp.zzf<ContainingType, ?> zza(ContainingType containingtype, int i) {
        return (zzegp.zzf<ContainingType, ?>) this.zzicp.get(new zza(containingtype, i));
    }

    private zzegc(boolean z) {
        this.zzicp = Collections.emptyMap();
    }
}

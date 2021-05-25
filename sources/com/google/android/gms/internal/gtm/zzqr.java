package com.google.android.gms.internal.gtm;

import com.google.android.gms.internal.gtm.zzrc;
import java.io.IOException;
import java.util.Map;
public final class zzqr extends zzqq<Object> {
    @Override // com.google.android.gms.internal.gtm.zzqq
    public final <UT, UB> UB zza(zzsy zzsy, Object obj, zzqp zzqp, zzqt<Object> zzqt, UB ub, zztr<UT, UB> zztr) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.gtm.zzqq
    public final int zzb(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.gtm.zzqq
    public final boolean zze(zzsk zzsk) {
        return zzsk instanceof zzrc.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzqq
    public final zzqt<Object> zzr(Object obj) {
        return ((zzrc.zzc) obj).zzbaq;
    }

    @Override // com.google.android.gms.internal.gtm.zzqq
    public final zzqt<Object> zzs(Object obj) {
        zzrc.zzc zzc = (zzrc.zzc) obj;
        if (zzc.zzbaq.isImmutable()) {
            zzc.zzbaq = (zzqt) zzc.zzbaq.clone();
        }
        return zzc.zzbaq;
    }

    @Override // com.google.android.gms.internal.gtm.zzqq
    public final void zzt(Object obj) {
        zzr(obj).zzmi();
    }

    @Override // com.google.android.gms.internal.gtm.zzqq
    public final void zza(zzum zzum, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.gtm.zzqq
    public final Object zza(zzqp zzqp, zzsk zzsk, int i) {
        return zzqp.zza(zzsk, i);
    }

    @Override // com.google.android.gms.internal.gtm.zzqq
    public final void zza(zzsy zzsy, Object obj, zzqp zzqp, zzqt<Object> zzqt) throws IOException {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.gtm.zzqq
    public final void zza(zzps zzps, Object obj, zzqp zzqp, zzqt<Object> zzqt) throws IOException {
        throw new NoSuchMethodError();
    }
}

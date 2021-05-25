package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.measurement.internal.zzhf;
public final class zzbj extends zzag.zzb {
    private final /* synthetic */ zzhf zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbj(zzag zzag, zzhf zzhf) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = zzhf;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    public final void zza() throws RemoteException {
        for (int i = 0; i < this.zzd.zzf.size(); i++) {
            if (this.zzc.equals(((Pair) this.zzd.zzf.get(i)).first)) {
                String unused = this.zzd.zzc;
                return;
            }
        }
        zzag.zzd zzd2 = new zzag.zzd(this.zzc);
        this.zzd.zzf.add(new Pair(this.zzc, zzd2));
        this.zzd.zzm.registerOnMeasurementEventListener(zzd2);
    }
}

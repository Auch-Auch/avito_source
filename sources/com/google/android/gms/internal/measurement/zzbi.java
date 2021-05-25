package com.google.android.gms.internal.measurement;

import android.os.RemoteException;
import android.util.Pair;
import com.google.android.gms.internal.measurement.zzag;
import com.google.android.gms.measurement.internal.zzhf;
public final class zzbi extends zzag.zzb {
    private final /* synthetic */ zzhf zzc;
    private final /* synthetic */ zzag zzd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbi(zzag zzag, zzhf zzhf) {
        super(zzag);
        this.zzd = zzag;
        this.zzc = zzhf;
    }

    @Override // com.google.android.gms.internal.measurement.zzag.zzb
    public final void zza() throws RemoteException {
        Pair pair;
        int i = 0;
        while (true) {
            if (i >= this.zzd.zzf.size()) {
                pair = null;
                break;
            } else if (this.zzc.equals(((Pair) this.zzd.zzf.get(i)).first)) {
                pair = (Pair) this.zzd.zzf.get(i);
                break;
            } else {
                i++;
            }
        }
        if (pair == null) {
            String unused = this.zzd.zzc;
            return;
        }
        this.zzd.zzm.unregisterOnMeasurementEventListener((zzab) pair.second);
        this.zzd.zzf.remove(pair);
    }
}

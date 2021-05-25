package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzp;
import java.io.InputStream;
public final class zzcol extends zzcoj {
    public zzcol(Context context) {
        this.zzgie = new zzarx(context, zzp.zzld().zzyf(), this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzgic) {
                this.zzgic = true;
                try {
                    this.zzgie.zzvb().zzb(this.zzgid, new zzcom(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdih.setException(new zzcpa(zzdmd.zzhco));
                } catch (Throwable th) {
                    zzp.zzkt().zza(th, "RemoteSignalsClientTask.onConnected");
                    this.zzdih.setException(new zzcpa(zzdmd.zzhco));
                }
            }
        }
    }

    public final zzdvt<InputStream> zzj(zzasp zzasp) {
        synchronized (this.mLock) {
            if (this.zzgib) {
                return this.zzdih;
            }
            this.zzgib = true;
            this.zzgid = zzasp;
            this.zzgie.checkAvailabilityAndConnect();
            this.zzdih.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcoo
                private final zzcol zzgih;

                {
                    this.zzgih = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgih.zzapl();
                }
            }, zzbbi.zzedz);
            return this.zzdih;
        }
    }
}

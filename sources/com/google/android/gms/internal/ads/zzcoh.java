package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;
public final class zzcoh extends zzcoj {
    public zzcoh(Context context) {
        this.zzgie = new zzarx(context, zzp.zzld().zzyf(), this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzgic) {
                this.zzgic = true;
                try {
                    this.zzgie.zzvb().zza(this.zzgid, new zzcom(this));
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdih.setException(new zzcpa(zzdmd.zzhco));
                } catch (Throwable th) {
                    zzp.zzkt().zza(th, "RemoteAdRequestClientTask.onConnected");
                    this.zzdih.setException(new zzcpa(zzdmd.zzhco));
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcoj, com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        zzbbd.zzef("Cannot connect to remote service, fallback to local instance.");
        this.zzdih.setException(new zzcpa(zzdmd.zzhco));
    }

    public final zzdvt<InputStream> zzi(zzasp zzasp) {
        synchronized (this.mLock) {
            if (this.zzgib) {
                return this.zzdih;
            }
            this.zzgib = true;
            this.zzgid = zzasp;
            this.zzgie.checkAvailabilityAndConnect();
            this.zzdih.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcok
                private final zzcoh zzgif;

                {
                    this.zzgif = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgif.zzapl();
                }
            }, zzbbi.zzedz);
            return this.zzdih;
        }
    }
}

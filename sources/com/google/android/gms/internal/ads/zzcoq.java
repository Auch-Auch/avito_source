package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.ConnectionResult;
import java.io.InputStream;
public final class zzcoq extends zzcoj {
    private String zzgij;
    private int zzgik = zzcor.zzgil;

    public zzcoq(Context context) {
        this.zzgie = new zzarx(context, zzp.zzld().zzyf(), this, this);
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.mLock) {
            if (!this.zzgic) {
                this.zzgic = true;
                try {
                    int i = this.zzgik;
                    if (i == zzcor.zzgim) {
                        this.zzgie.zzvb().zzc(this.zzgid, new zzcom(this));
                    } else if (i == zzcor.zzgin) {
                        this.zzgie.zzvb().zza(this.zzgij, new zzcom(this));
                    } else {
                        this.zzdih.setException(new zzcpa(zzdmd.zzhco));
                    }
                } catch (RemoteException | IllegalArgumentException unused) {
                    this.zzdih.setException(new zzcpa(zzdmd.zzhco));
                } catch (Throwable th) {
                    zzp.zzkt().zza(th, "RemoteUrlAndCacheKeyClientTask.onConnected");
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

    public final zzdvt<InputStream> zzgm(String str) {
        synchronized (this.mLock) {
            int i = this.zzgik;
            if (i != zzcor.zzgil && i != zzcor.zzgin) {
                return zzdvl.immediateFailedFuture(new zzcpa(zzdmd.zzhcp));
            } else if (this.zzgib) {
                return this.zzdih;
            } else {
                this.zzgik = zzcor.zzgin;
                this.zzgib = true;
                this.zzgij = str;
                this.zzgie.checkAvailabilityAndConnect();
                this.zzdih.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcos
                    private final zzcoq zzgii;

                    {
                        this.zzgii = r1;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzgii.zzapl();
                    }
                }, zzbbi.zzedz);
                return this.zzdih;
            }
        }
    }

    public final zzdvt<InputStream> zzk(zzasp zzasp) {
        synchronized (this.mLock) {
            int i = this.zzgik;
            if (i != zzcor.zzgil && i != zzcor.zzgim) {
                return zzdvl.immediateFailedFuture(new zzcpa(zzdmd.zzhcp));
            } else if (this.zzgib) {
                return this.zzdih;
            } else {
                this.zzgik = zzcor.zzgim;
                this.zzgib = true;
                this.zzgid = zzasp;
                this.zzgie.checkAvailabilityAndConnect();
                this.zzdih.addListener(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcop
                    private final zzcoq zzgii;

                    {
                        this.zzgii = r1;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.zzgii.zzapl();
                    }
                }, zzbbi.zzedz);
                return this.zzdih;
            }
        }
    }
}

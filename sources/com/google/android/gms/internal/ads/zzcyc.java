package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzbsg;
import com.google.android.gms.internal.ads.zzbxj;
import javax.annotation.concurrent.GuardedBy;
public final class zzcyc implements zzcxy<zzbpd> {
    private final zzbii zzgmy;
    private final Context zzgpr;
    @GuardedBy("this")
    private final zzdlp zzgps;
    private final zzcxw zzgrc;
    @Nullable
    @GuardedBy("this")
    private zzbpo zzgrd;

    public zzcyc(zzbii zzbii, Context context, zzcxw zzcxw, zzdlp zzdlp) {
        this.zzgmy = zzbii;
        this.zzgpr = context;
        this.zzgrc = zzcxw;
        this.zzgps = zzdlp;
    }

    @Override // com.google.android.gms.internal.ads.zzcxy
    public final boolean isLoading() {
        zzbpo zzbpo = this.zzgrd;
        return zzbpo != null && zzbpo.isLoading();
    }

    @Override // com.google.android.gms.internal.ads.zzcxy
    public final boolean zza(zzvc zzvc, String str, zzcxx zzcxx, zzcya<? super zzbpd> zzcya) throws RemoteException {
        zzcbn zzcbn;
        zzp.zzkp();
        if (zzayh.zzbe(this.zzgpr) && zzvc.zzchi == null) {
            zzbbd.zzfc("Failed to load the ad because app ID is missing.");
            this.zzgmy.zzadj().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcyb
                private final zzcyc zzgrb;

                {
                    this.zzgrb = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgrb.zzaqn();
                }
            });
            return false;
        } else if (str == null) {
            zzbbd.zzfc("Ad unit ID should not be null for NativeAdLoader.");
            this.zzgmy.zzadj().execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcye
                private final zzcyc zzgrb;

                {
                    this.zzgrb = r1;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgrb.zzaqm();
                }
            });
            return false;
        } else {
            zzdly.zze(this.zzgpr, zzvc.zzcgy);
            zzdln zzasu = this.zzgps.zzh(zzvc).zzec(zzcxx instanceof zzcxz ? ((zzcxz) zzcxx).zzgra : 1).zzasu();
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcxt)).booleanValue()) {
                zzcbn = this.zzgmy.zzadu().zza(new zzbsg.zza().zzcd(this.zzgpr).zza(zzasu).zzajj()).zza(new zzbxj.zza().zzake()).zza(this.zzgrc.zzaqf()).zzaek();
            } else {
                zzcbn = this.zzgmy.zzadu().zza(new zzbsg.zza().zzcd(this.zzgpr).zza(zzasu).zzajj()).zza(new zzbxj.zza().zza(this.zzgrc.zzaqi(), this.zzgmy.zzadj()).zza(this.zzgrc.zzaqj(), this.zzgmy.zzadj()).zza(this.zzgrc.zzaqk(), this.zzgmy.zzadj()).zza(this.zzgrc.zzaql(), this.zzgmy.zzadj()).zza(this.zzgrc.zzaqh(), this.zzgmy.zzadj()).zza(zzasu.zzhca, this.zzgmy.zzadj()).zzake()).zza(this.zzgrc.zzaqf()).zzaek();
            }
            this.zzgmy.zzadz().zzed(1);
            zzbpo zzbpo = new zzbpo(this.zzgmy.zzadl(), this.zzgmy.zzadk(), zzcbn.zzafc().zzaiv());
            this.zzgrd = zzbpo;
            zzbpo.zza(new zzcyd(this, zzcya, zzcbn));
            return true;
        }
    }

    public final /* synthetic */ void zzaqm() {
        this.zzgrc.zzaqj().zzg(zzdmb.zza(zzdmd.zzhct, null, null));
    }

    public final /* synthetic */ void zzaqn() {
        this.zzgrc.zzaqj().zzg(zzdmb.zza(zzdmd.zzhcr, null, null));
    }
}

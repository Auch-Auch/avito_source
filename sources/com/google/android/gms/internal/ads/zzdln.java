package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import java.util.ArrayList;
public final class zzdln {
    public final zzvj zzbpb;
    public final zzadm zzdla;
    @Nullable
    public final zzair zzdrn;
    public final int zzgra;
    public final boolean zzgso;
    @Nullable
    public final zzxi zzhbs;
    @Nullable
    public final zzaac zzhbt;
    public final zzvc zzhbu;
    public final String zzhbv;
    public final ArrayList<String> zzhbw;
    public final ArrayList<String> zzhbx;
    public final zzvm zzhby;
    public final PublisherAdViewOptions zzhbz;
    public final zzxc zzhca;
    public final zzdla zzhcb;

    private zzdln(zzdlp zzdlp) {
        zzaac zzaac;
        zzadm zzadm;
        this.zzbpb = zzdlp.zza(zzdlp);
        this.zzhbv = zzdlp.zzb(zzdlp);
        this.zzhbs = zzdlp.zzc(zzdlp);
        this.zzhbu = new zzvc(zzdlp.zzm(zzdlp).versionCode, zzdlp.zzm(zzdlp).zzcgv, zzdlp.zzm(zzdlp).extras, zzdlp.zzm(zzdlp).zzcgw, zzdlp.zzm(zzdlp).zzcgx, zzdlp.zzm(zzdlp).zzcgy, zzdlp.zzm(zzdlp).zzadj, zzdlp.zzm(zzdlp).zzbnu || zzdlp.zzn(zzdlp), zzdlp.zzm(zzdlp).zzcgz, zzdlp.zzm(zzdlp).zzcha, zzdlp.zzm(zzdlp).zznb, zzdlp.zzm(zzdlp).zzchb, zzdlp.zzm(zzdlp).zzchc, zzdlp.zzm(zzdlp).zzchd, zzdlp.zzm(zzdlp).zzche, zzdlp.zzm(zzdlp).zzchf, zzdlp.zzm(zzdlp).zzchg, zzdlp.zzm(zzdlp).zzchh, zzdlp.zzm(zzdlp).zzchi, zzdlp.zzm(zzdlp).zzadk, zzdlp.zzm(zzdlp).zzadl, zzdlp.zzm(zzdlp).zzchj);
        if (zzdlp.zzo(zzdlp) != null) {
            zzaac = zzdlp.zzo(zzdlp);
        } else {
            zzaac = zzdlp.zzp(zzdlp) != null ? zzdlp.zzp(zzdlp).zzdct : null;
        }
        this.zzhbt = zzaac;
        this.zzhbw = zzdlp.zzd(zzdlp);
        this.zzhbx = zzdlp.zze(zzdlp);
        if (zzdlp.zzd(zzdlp) == null) {
            zzadm = null;
        } else if (zzdlp.zzp(zzdlp) == null) {
            zzadm = new zzadm(new NativeAdOptions.Builder().build());
        } else {
            zzadm = zzdlp.zzp(zzdlp);
        }
        this.zzdla = zzadm;
        this.zzhby = zzdlp.zzf(zzdlp);
        this.zzgra = zzdlp.zzg(zzdlp);
        this.zzhbz = zzdlp.zzh(zzdlp);
        this.zzhca = zzdlp.zzi(zzdlp);
        this.zzdrn = zzdlp.zzj(zzdlp);
        this.zzhcb = new zzdla(zzdlp.zzk(zzdlp));
        this.zzgso = zzdlp.zzl(zzdlp);
    }

    public final zzafq zzasp() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzhbz;
        if (publisherAdViewOptions == null) {
            return null;
        }
        return publisherAdViewOptions.zzju();
    }
}

package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
public final class zzdlp {
    private boolean zzbnu;
    private zzvj zzbpb;
    private zzadm zzdla;
    private zzair zzdrn;
    private int zzgra = 1;
    private boolean zzgso = false;
    private zzxi zzhbs;
    private zzaac zzhbt;
    private zzvc zzhbu;
    private String zzhbv;
    private ArrayList<String> zzhbw;
    private ArrayList<String> zzhbx;
    private zzvm zzhby;
    private PublisherAdViewOptions zzhbz;
    @Nullable
    private zzxc zzhca;
    private zzdlc zzhcc = new zzdlc();

    public final zzvc zzasr() {
        return this.zzhbu;
    }

    public final String zzass() {
        return this.zzhbv;
    }

    public final zzdlc zzast() {
        return this.zzhcc;
    }

    public final zzdln zzasu() {
        Preconditions.checkNotNull(this.zzhbv, "ad unit must not be null");
        Preconditions.checkNotNull(this.zzbpb, "ad size must not be null");
        Preconditions.checkNotNull(this.zzhbu, "ad request must not be null");
        return new zzdln(this);
    }

    public final boolean zzasv() {
        return this.zzgso;
    }

    public final zzdlp zzb(zzadm zzadm) {
        this.zzdla = zzadm;
        return this;
    }

    public final zzdlp zzbo(boolean z) {
        this.zzgso = z;
        return this;
    }

    public final zzdlp zzbp(boolean z) {
        this.zzbnu = z;
        return this;
    }

    public final zzdlp zzc(zzxi zzxi) {
        this.zzhbs = zzxi;
        return this;
    }

    public final zzdlp zzd(ArrayList<String> arrayList) {
        this.zzhbx = arrayList;
        return this;
    }

    public final zzdlp zze(zzvj zzvj) {
        this.zzbpb = zzvj;
        return this;
    }

    public final zzdlp zzec(int i) {
        this.zzgra = i;
        return this;
    }

    public final zzdlp zzgt(String str) {
        this.zzhbv = str;
        return this;
    }

    public final zzdlp zzh(zzvc zzvc) {
        this.zzhbu = zzvc;
        return this;
    }

    public final zzvj zzke() {
        return this.zzbpb;
    }

    public final zzdlp zzb(zzvm zzvm) {
        this.zzhby = zzvm;
        return this;
    }

    public final zzdlp zzc(zzaac zzaac) {
        this.zzhbt = zzaac;
        return this;
    }

    public final zzdlp zzb(zzair zzair) {
        this.zzdrn = zzair;
        this.zzhbt = new zzaac(false, true, false);
        return this;
    }

    public final zzdlp zzc(ArrayList<String> arrayList) {
        this.zzhbw = arrayList;
        return this;
    }

    public final zzdlp zzc(zzdln zzdln) {
        this.zzhcc.zza(zzdln.zzhcb);
        this.zzhbu = zzdln.zzhbu;
        this.zzbpb = zzdln.zzbpb;
        this.zzhbs = zzdln.zzhbs;
        this.zzhbv = zzdln.zzhbv;
        this.zzhbt = zzdln.zzhbt;
        this.zzhbw = zzdln.zzhbw;
        this.zzhbx = zzdln.zzhbx;
        this.zzdla = zzdln.zzdla;
        this.zzhby = zzdln.zzhby;
        zzdlp zzb = zzb(zzdln.zzhbz);
        zzb.zzgso = zzdln.zzgso;
        return zzb;
    }

    public final zzdlp zzb(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzhbz = publisherAdViewOptions;
        if (publisherAdViewOptions != null) {
            this.zzbnu = publisherAdViewOptions.getManualImpressionsEnabled();
            this.zzhca = publisherAdViewOptions.zzjt();
        }
        return this;
    }
}

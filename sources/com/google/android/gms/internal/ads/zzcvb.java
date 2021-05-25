package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.zzi;
import com.google.android.gms.ads.internal.zzp;
public final class zzcvb implements zzcaz {
    private final zzbbg zzbop;
    private final zzdkx zzfpf;
    private final zzdln zzfqn;
    private final zzcih zzfzy;
    private final zzdvt<zzchw> zzgmk;
    private final zzbfq zzgnu;
    private final Context zzvr;

    private zzcvb(Context context, zzcih zzcih, zzdln zzdln, zzbbg zzbbg, zzdkx zzdkx, zzdvt<zzchw> zzdvt, zzbfq zzbfq) {
        this.zzvr = context;
        this.zzfzy = zzcih;
        this.zzfqn = zzdln;
        this.zzbop = zzbbg;
        this.zzfpf = zzdkx;
        this.zzgmk = zzdvt;
        this.zzgnu = zzbfq;
    }

    @Override // com.google.android.gms.internal.ads.zzcaz
    public final void zza(boolean z, Context context) {
        zzbfq zzbfq;
        zzbfq zzbfq2;
        zzchw zzchw = (zzchw) zzdvl.zzb(this.zzgmk);
        try {
            zzdkx zzdkx = this.zzfpf;
            if (!this.zzgnu.zzabt()) {
                zzbfq2 = this.zzgnu;
            } else {
                if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcnw)).booleanValue()) {
                    zzbfq2 = this.zzgnu;
                } else {
                    zzbfq zzc = this.zzfzy.zzc(this.zzfqn.zzbpb);
                    zzahq.zza(zzc, zzchw.zzagi());
                    zzcix zzcix = new zzcix();
                    zzcix.zzc(this.zzvr, zzc.getView());
                    zzchw.zzafo().zzb(zzc, true);
                    zzc.zzabe().zza(new zzbhf(zzcix, zzc) { // from class: com.google.android.gms.internal.ads.zzcve
                        private final zzbfq zzgak;
                        private final zzcix zzgmi;

                        {
                            this.zzgmi = r1;
                            this.zzgak = r2;
                        }

                        @Override // com.google.android.gms.internal.ads.zzbhf
                        public final void zzak(boolean z2) {
                            zzcix zzcix2 = this.zzgmi;
                            zzbfq zzbfq3 = this.zzgak;
                            zzcix2.zzanp();
                            zzbfq3.zzaay();
                            zzbfq3.zzabe().zzacd();
                        }
                    });
                    zzc.zzabe().zza(zzcvd.zzq(zzc));
                    zzdlb zzdlb = zzdkx.zzhao;
                    zzc.zzb(zzdlb.zzdos, zzdlb.zzdou, null);
                    zzbfq = zzc;
                    zzbfq.zzax(true);
                    zzp.zzkp();
                    boolean zzbc = zzayh.zzbc(this.zzvr);
                    zzdkx zzdkx2 = this.zzfpf;
                    zzi zzi = new zzi(false, zzbc, false, 0.0f, -1, z, zzdkx2.zzfnp, zzdkx2.zzboz);
                    zzp.zzko();
                    zzcap zzagd = zzchw.zzagd();
                    zzdkx zzdkx3 = this.zzfpf;
                    int i = zzdkx3.zzhaw;
                    zzbbg zzbbg = this.zzbop;
                    String str = zzdkx3.zzdrx;
                    zzdlb zzdlb2 = zzdkx3.zzhao;
                    zzn.zza(context, new AdOverlayInfoParcel((zzut) null, zzagd, (zzt) null, zzbfq, i, zzbbg, str, zzi, zzdlb2.zzdos, zzdlb2.zzdou), true);
                }
            }
            zzbfq = zzbfq2;
            zzbfq.zzax(true);
            zzp.zzkp();
            boolean zzbc = zzayh.zzbc(this.zzvr);
            zzdkx zzdkx2 = this.zzfpf;
            zzi zzi = new zzi(false, zzbc, false, 0.0f, -1, z, zzdkx2.zzfnp, zzdkx2.zzboz);
            zzp.zzko();
            zzcap zzagd = zzchw.zzagd();
            zzdkx zzdkx3 = this.zzfpf;
            int i = zzdkx3.zzhaw;
            zzbbg zzbbg = this.zzbop;
            String str = zzdkx3.zzdrx;
            zzdlb zzdlb2 = zzdkx3.zzhao;
            zzn.zza(context, new AdOverlayInfoParcel((zzut) null, zzagd, (zzt) null, zzbfq, i, zzbbg, str, zzi, zzdlb2.zzdos, zzdlb2.zzdou), true);
        } catch (zzbgc e) {
            zzbbd.zzc("", e);
        }
    }
}

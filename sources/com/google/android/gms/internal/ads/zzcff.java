package com.google.android.gms.internal.ads;

import a2.b.a.a.a;
import android.text.TextUtils;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.ads.internal.zzp;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONObject;
public final class zzcff {
    private final zzdvw zzgay;
    private final zzcfj zzgaz;
    private final zzcft zzgba;

    public zzcff(zzdvw zzdvw, zzcfj zzcfj, zzcft zzcft) {
        this.zzgay = zzdvw;
        this.zzgaz = zzcfj;
        this.zzgba = zzcft;
    }

    public final zzdvt<zzccv> zza(zzdlj zzdlj, zzdkx zzdkx, JSONObject jSONObject) {
        zzdvt zzb;
        zzdvt zze = this.zzgay.zze(new Callable(this, zzdlj, zzdkx, jSONObject) { // from class: com.google.android.gms.internal.ads.zzcfi
            private final zzdkx zzfoo;
            private final zzcff zzgbb;
            private final zzdlj zzgbj;
            private final JSONObject zzgbk;

            {
                this.zzgbb = r1;
                this.zzgbj = r2;
                this.zzfoo = r3;
                this.zzgbk = r4;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdlj zzdlj2 = this.zzgbj;
                zzdkx zzdkx2 = this.zzfoo;
                JSONObject jSONObject2 = this.zzgbk;
                zzccv zzccv = new zzccv();
                zzccv.zzdy(jSONObject2.optInt("template_id", -1));
                zzccv.zzga(jSONObject2.optString("custom_template_id"));
                JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
                zzccv.zzgb(optJSONObject != null ? optJSONObject.optString("omid_partner_name") : null);
                zzdln zzdln = zzdlj2.zzhbp.zzfqn;
                if (zzdln.zzhbw.contains(Integer.toString(zzccv.zzaln()))) {
                    if (zzccv.zzaln() == 3) {
                        if (zzccv.getCustomTemplateId() == null) {
                            throw new zzcuh(zzdmd.zzhco, "No custom template id for custom template ad response.");
                        } else if (!zzdln.zzhbx.contains(zzccv.getCustomTemplateId())) {
                            throw new zzcuh(zzdmd.zzhco, "Unexpected custom template id in the response.");
                        }
                    }
                    zzccv.setStarRating(jSONObject2.optDouble("rating", -1.0d));
                    String optString = jSONObject2.optString("headline", null);
                    if (zzdkx2.zzduo) {
                        zzp.zzkp();
                        String zzxr = zzayh.zzxr();
                        optString = a.s2(a.q0(optString, a.q0(zzxr, 3)), zzxr, " : ", optString);
                    }
                    zzccv.zzn("headline", optString);
                    zzccv.zzn(SDKConstants.PARAM_A2U_BODY, jSONObject2.optString(SDKConstants.PARAM_A2U_BODY, null));
                    zzccv.zzn("call_to_action", jSONObject2.optString("call_to_action", null));
                    zzccv.zzn("store", jSONObject2.optString("store", null));
                    zzccv.zzn("price", jSONObject2.optString("price", null));
                    zzccv.zzn("advertiser", jSONObject2.optString("advertiser", null));
                    return zzccv;
                }
                throw new zzcuh(zzdmd.zzhco, a.m2(32, "Invalid template ID: ", zzccv.zzaln()));
            }
        });
        zzdvt<List<zzadi>> zzd = this.zzgaz.zzd(jSONObject, "images");
        zzdvt<zzadi> zzc = this.zzgaz.zzc(jSONObject, "secondary_image");
        zzdvt<zzadi> zzc2 = this.zzgaz.zzc(jSONObject, "app_icon");
        zzdvt<zzadd> zze2 = this.zzgaz.zze(jSONObject, "attribution");
        zzdvt<zzbfq> zzm = this.zzgaz.zzm(jSONObject);
        zzcfj zzcfj = this.zzgaz;
        if (!jSONObject.optBoolean("enable_omid")) {
            zzb = zzdvl.zzaf(null);
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zzb = zzdvl.zzaf(null);
            } else {
                String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zzb = zzdvl.zzaf(null);
                } else {
                    zzb = zzdvl.zzb(zzdvl.zzaf(null), new zzduv(zzcfj, optString) { // from class: com.google.android.gms.internal.ads.zzcfn
                        private final String zzdft;
                        private final zzcfj zzgbr;

                        {
                            this.zzgbr = r1;
                            this.zzdft = r2;
                        }

                        @Override // com.google.android.gms.internal.ads.zzduv
                        public final zzdvt zzf(Object obj) {
                            return this.zzgbr.zzb(this.zzdft, obj);
                        }
                    }, zzbbi.zzedy);
                }
            }
        }
        zzdvt<List<zzcfy>> zzg = this.zzgba.zzg(jSONObject, "custom_assets");
        return zzdvl.zza(zze, zzd, zzc, zzc2, zze2, zzm, zzb, zzg).zza(new Callable(this, zze, zzd, zzc2, zzc, zze2, jSONObject, zzm, zzb, zzg) { // from class: com.google.android.gms.internal.ads.zzcfh
            private final zzdvt zzfqe;
            private final zzdvt zzfsi;
            private final zzcff zzgbb;
            private final zzdvt zzgbc;
            private final zzdvt zzgbd;
            private final zzdvt zzgbe;
            private final JSONObject zzgbf;
            private final zzdvt zzgbg;
            private final zzdvt zzgbh;
            private final zzdvt zzgbi;

            {
                this.zzgbb = r1;
                this.zzfsi = r2;
                this.zzfqe = r3;
                this.zzgbc = r4;
                this.zzgbd = r5;
                this.zzgbe = r6;
                this.zzgbf = r7;
                this.zzgbg = r8;
                this.zzgbh = r9;
                this.zzgbi = r10;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                zzdvt zzdvt = this.zzfsi;
                zzdvt zzdvt2 = this.zzfqe;
                zzdvt zzdvt3 = this.zzgbc;
                zzdvt zzdvt4 = this.zzgbd;
                zzdvt zzdvt5 = this.zzgbe;
                JSONObject jSONObject2 = this.zzgbf;
                zzdvt zzdvt6 = this.zzgbg;
                zzdvt zzdvt7 = this.zzgbh;
                zzdvt zzdvt8 = this.zzgbi;
                zzccv zzccv = (zzccv) zzdvt.get();
                zzccv.setImages((List) zzdvt2.get());
                zzccv.zza((zzadw) zzdvt3.get());
                zzccv.zzb((zzadw) zzdvt4.get());
                zzccv.zza((zzado) zzdvt5.get());
                zzccv.zzh(zzcfj.zzj(jSONObject2));
                zzccv.zza(zzcfj.zzk(jSONObject2));
                zzbfq zzbfq = (zzbfq) zzdvt6.get();
                if (zzbfq != null) {
                    zzccv.zzi(zzbfq);
                    zzccv.zzac(zzbfq.getView());
                    zzccv.zzb(zzbfq.zzzo());
                }
                zzbfq zzbfq2 = (zzbfq) zzdvt7.get();
                if (zzbfq2 != null) {
                    zzccv.zzj(zzbfq2);
                }
                for (zzcfy zzcfy : (List) zzdvt8.get()) {
                    int i = zzcfy.type;
                    if (i == 1) {
                        zzccv.zzn(zzcfy.zzcn, zzcfy.zzgbw);
                    } else if (i == 2) {
                        zzccv.zza(zzcfy.zzcn, zzcfy.zzgbx);
                    }
                }
                return zzccv;
            }
        }, this.zzgay);
    }
}

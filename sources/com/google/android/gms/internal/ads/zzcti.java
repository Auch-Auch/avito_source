package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;
import ru.avito.messenger.internal.jsonrpc.CommonKt;
public final class zzcti implements zzctf<zzcco> {
    private final zzdvw zzgay;
    private final zzcbn zzgmp;
    private final zzcff zzgmq;
    private final zzdma<zzchc> zzgmr;

    public zzcti(zzcbn zzcbn, zzdvw zzdvw, zzcff zzcff, zzdma<zzchc> zzdma) {
        this.zzgmp = zzcbn;
        this.zzgay = zzdvw;
        this.zzgmq = zzcff;
        this.zzgmr = zzdma;
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final boolean zza(zzdlj zzdlj, zzdkx zzdkx) {
        zzdlb zzdlb = zzdkx.zzhao;
        return (zzdlb == null || zzdlb.zzfvr == null) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzcre
    public final zzdvt<List<zzdvt<zzcco>>> zzb(zzdlj zzdlj, zzdkx zzdkx) {
        return zzdvl.zzb(zzdvl.zzb(this.zzgmr.zzasz(), new zzduv(this, zzdkx) { // from class: com.google.android.gms.internal.ads.zzcth
            private final zzdkx zzgmf;
            private final zzcti zzgmo;

            {
                this.zzgmo = r1;
                this.zzgmf = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzgmo.zza(this.zzgmf, (zzchc) obj);
            }
        }, this.zzgay), new zzduv(this, zzdlj, zzdkx) { // from class: com.google.android.gms.internal.ads.zzctk
            private final zzdkx zzfoo;
            private final zzdlj zzgbj;
            private final zzcti zzgmo;

            {
                this.zzgmo = r1;
                this.zzgbj = r2;
                this.zzfoo = r3;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzgmo.zza(this.zzgbj, this.zzfoo, (JSONArray) obj);
            }
        }, this.zzgay);
    }

    public final /* synthetic */ zzcco zza(zzdvt zzdvt, zzdvt zzdvt2, zzdlj zzdlj, zzdkx zzdkx, JSONObject jSONObject) throws Exception {
        zzccv zzccv = (zzccv) zzdvt.get();
        zzchc zzchc = (zzchc) zzdvt2.get();
        zzccx zza = this.zzgmp.zza(new zzbpt(zzdlj, zzdkx, null), new zzcdh(zzccv), new zzccc(jSONObject, zzchc));
        zza.zzaeu().zzanf();
        zza.zzaev().zzb(zzchc);
        zza.zzaew().zzl(zzccv.zzals());
        return zza.zzaet();
    }

    private final zzdvt<zzcco> zzb(zzdlj zzdlj, zzdkx zzdkx, JSONObject jSONObject) {
        zzdvt<zzchc> zzasz = this.zzgmr.zzasz();
        zzdvt<zzccv> zza = this.zzgmq.zza(zzdlj, zzdkx, jSONObject);
        return zzdvl.zzb(zzasz, zza).zza(new Callable(this, zza, zzasz, zzdlj, zzdkx, jSONObject) { // from class: com.google.android.gms.internal.ads.zzctl
            private final zzdvt zzfqe;
            private final zzdvt zzfsi;
            private final zzdlj zzgmh;
            private final zzcti zzgmo;
            private final zzdkx zzgmt;
            private final JSONObject zzgmu;

            {
                this.zzgmo = r1;
                this.zzfsi = r2;
                this.zzfqe = r3;
                this.zzgmh = r4;
                this.zzgmt = r5;
                this.zzgmu = r6;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zzgmo.zza(this.zzfsi, this.zzfqe, this.zzgmh, this.zzgmt, this.zzgmu);
            }
        }, this.zzgay);
    }

    public final /* synthetic */ zzdvt zza(zzchc zzchc, JSONObject jSONObject) throws Exception {
        this.zzgmr.zzd(zzdvl.zzaf(zzchc));
        if (jSONObject.optBoolean("success")) {
            return zzdvl.zzaf(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzalj("process json failed");
    }

    public final /* synthetic */ zzdvt zza(zzdlj zzdlj, zzdkx zzdkx, JSONArray jSONArray) throws Exception {
        if (jSONArray.length() == 0) {
            return zzdvl.immediateFailedFuture(new zzcmt(zzdmd.zzhcq));
        }
        if (zzdlj.zzhbp.zzfqn.zzgra <= 1) {
            return zzdvl.zzb(zzb(zzdlj, zzdkx, jSONArray.getJSONObject(0)), zzctm.zzdwg, this.zzgay);
        }
        int length = jSONArray.length();
        this.zzgmr.zzed(Math.min(length, zzdlj.zzhbp.zzfqn.zzgra));
        ArrayList arrayList = new ArrayList(zzdlj.zzhbp.zzfqn.zzgra);
        for (int i = 0; i < zzdlj.zzhbp.zzfqn.zzgra; i++) {
            if (i < length) {
                arrayList.add(zzb(zzdlj, zzdkx, jSONArray.getJSONObject(i)));
            } else {
                arrayList.add(zzdvl.immediateFailedFuture(new zzcmt(zzdmd.zzhcq)));
            }
        }
        return zzdvl.zzaf(arrayList);
    }

    public final /* synthetic */ zzdvt zza(zzdkx zzdkx, zzchc zzchc) throws Exception {
        JSONObject zza = zzbab.zza("isNonagon", Boolean.TRUE);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(CommonKt.EXTRA_RESPONSE, zzdkx.zzhao.zzfvr);
        jSONObject.put("sdk_params", zza);
        return zzdvl.zzb(zzchc.zzc("google.afma.nativeAds.preProcessJson", jSONObject), new zzduv(this, zzchc) { // from class: com.google.android.gms.internal.ads.zzctj
            private final zzcti zzgmo;
            private final zzchc zzgms;

            {
                this.zzgmo = r1;
                this.zzgms = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzgmo.zza(this.zzgms, (JSONObject) obj);
            }
        }, this.zzgay);
    }
}

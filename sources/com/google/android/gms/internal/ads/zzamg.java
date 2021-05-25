package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import org.json.JSONObject;
public final class zzamg<I, O> implements zzduv<I, O> {
    private final zzalo<O> zzdhy;
    private final zzaln<I> zzdhz;
    private final String zzdia;
    private final zzdvt<zzali> zzdif;

    public zzamg(zzdvt<zzali> zzdvt, String str, zzaln<I> zzaln, zzalo<O> zzalo) {
        this.zzdif = zzdvt;
        this.zzdia = str;
        this.zzdhz = zzaln;
        this.zzdhy = zzalo;
    }

    public final /* synthetic */ zzdvt zza(Object obj, zzali zzali) throws Exception {
        zzbbq zzbbq = new zzbbq();
        zzp.zzkp();
        String zzxo = zzayh.zzxo();
        zzagp.zzdem.zza(zzxo, new zzami(this, zzbbq));
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", zzxo);
        jSONObject.put("args", this.zzdhz.zzj(obj));
        zzali.zza(this.zzdia, jSONObject);
        return zzbbq;
    }

    @Override // com.google.android.gms.internal.ads.zzduv
    public final zzdvt<O> zzf(I i) throws Exception {
        return zzdvl.zzb(this.zzdif, new zzduv(this, i) { // from class: com.google.android.gms.internal.ads.zzamf
            private final zzamg zzdii;
            private final Object zzdij;

            {
                this.zzdii = r1;
                this.zzdij = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzduv
            public final zzdvt zzf(Object obj) {
                return this.zzdii.zza(this.zzdij, (zzali) obj);
            }
        }, zzbbi.zzedz);
    }
}

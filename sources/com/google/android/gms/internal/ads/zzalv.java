package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;
@ParametersAreNonnullByDefault
public final class zzalv<I, O> implements zzalm<I, O> {
    private final zzakk zzdhx;
    private final zzalo<O> zzdhy;
    private final zzaln<I> zzdhz;
    private final String zzdia;

    public zzalv(zzakk zzakk, String str, zzaln<I> zzaln, zzalo<O> zzalo) {
        this.zzdhx = zzakk;
        this.zzdia = str;
        this.zzdhz = zzaln;
        this.zzdhy = zzalo;
    }

    /* access modifiers changed from: private */
    public final void zza(zzakx zzakx, zzali zzali, I i, zzbbq<O> zzbbq) {
        try {
            zzp.zzkp();
            String zzxo = zzayh.zzxo();
            zzagp.zzdem.zza(zzxo, new zzama(this, zzakx, zzbbq));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", zzxo);
            jSONObject.put("args", this.zzdhz.zzj(i));
            zzali.zza(this.zzdia, jSONObject);
        } catch (Exception e) {
            zzbbq.setException(e);
            zzbbd.zzc("Unable to invokeJavascript", e);
            zzakx.release();
        } catch (Throwable th) {
            zzakx.release();
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzduv
    public final zzdvt<O> zzf(@Nullable I i) throws Exception {
        return zzi(i);
    }

    @Override // com.google.android.gms.internal.ads.zzalm
    public final zzdvt<O> zzi(I i) {
        zzbbq zzbbq = new zzbbq();
        zzakx zzb = this.zzdhx.zzb((zzeg) null);
        zzb.zza(new zzaly(this, zzb, i, zzbbq), new zzalx(this, zzbbq, zzb));
        return zzbbq;
    }
}

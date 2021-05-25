package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzami implements zzahn {
    private final zzbbq<O> zzdih;
    private final /* synthetic */ zzamg zzdik;

    public zzami(zzamg zzamg, zzbbq<O> zzbbq) {
        this.zzdik = zzamg;
        this.zzdih = zzbbq;
    }

    @Override // com.google.android.gms.internal.ads.zzahn
    public final void onFailure(@Nullable String str) {
        if (str == null) {
            try {
                this.zzdih.setException(new zzalj());
            } catch (IllegalStateException unused) {
            }
        } else {
            this.zzdih.setException(new zzalj(str));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahn
    public final void zzc(JSONObject jSONObject) {
        try {
            this.zzdih.set((O) this.zzdik.zzdhy.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzdih.setException(e);
        }
    }
}

package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzama implements zzahn {
    private final /* synthetic */ zzalv zzdid;
    private final zzakx zzdig;
    private final zzbbq<O> zzdih;

    public zzama(zzalv zzalv, zzakx zzakx, zzbbq<O> zzbbq) {
        this.zzdid = zzalv;
        this.zzdig = zzakx;
        this.zzdih = zzbbq;
    }

    @Override // com.google.android.gms.internal.ads.zzahn
    public final void onFailure(@Nullable String str) {
        if (str == null) {
            try {
                this.zzdih.setException(new zzalj());
            } catch (IllegalStateException unused) {
                this.zzdig.release();
                return;
            } catch (Throwable th) {
                this.zzdig.release();
                throw th;
            }
        } else {
            this.zzdih.setException(new zzalj(str));
        }
        this.zzdig.release();
    }

    @Override // com.google.android.gms.internal.ads.zzahn
    public final void zzc(JSONObject jSONObject) {
        try {
            this.zzdih.set((O) this.zzdid.zzdhy.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzdih.setException(e);
        } finally {
            this.zzdig.release();
        }
    }
}

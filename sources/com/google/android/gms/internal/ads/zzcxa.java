package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzcxa extends zzape {
    private final String zzdfe;
    private final zzapa zzgpn;
    private zzbbq<JSONObject> zzgpo;
    private final JSONObject zzgpp;
    @GuardedBy("this")
    private boolean zzgpq = false;

    public zzcxa(String str, zzapa zzapa, zzbbq<JSONObject> zzbbq) {
        JSONObject jSONObject = new JSONObject();
        this.zzgpp = jSONObject;
        this.zzgpo = zzbbq;
        this.zzdfe = str;
        this.zzgpn = zzapa;
        try {
            jSONObject.put("adapter_version", zzapa.zztw().toString());
            jSONObject.put("sdk_version", zzapa.zztx().toString());
            jSONObject.put("name", str);
        } catch (RemoteException | NullPointerException | JSONException unused) {
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapb
    public final synchronized void onFailure(String str) throws RemoteException {
        if (!this.zzgpq) {
            try {
                this.zzgpp.put("signal_error", str);
            } catch (JSONException unused) {
            }
            this.zzgpo.set(this.zzgpp);
            this.zzgpq = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzapb
    public final synchronized void zzds(String str) throws RemoteException {
        if (!this.zzgpq) {
            if (str == null) {
                onFailure("Adapter returned null signals");
                return;
            }
            try {
                this.zzgpp.put("signals", str);
            } catch (JSONException unused) {
            }
            this.zzgpo.set(this.zzgpp);
            this.zzgpq = true;
        }
    }
}

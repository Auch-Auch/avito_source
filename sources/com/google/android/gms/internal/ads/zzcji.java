package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.mediation.AdUrlAdapter;
import com.google.ads.mediation.admob.AdMobAdapter;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzcji {
    private final zzcjd zzgdx;
    private final AtomicReference<zzamu> zzgdy = new AtomicReference<>();

    public zzcji(zzcjd zzcjd) {
        this.zzgdx = zzcjd;
    }

    private final zzamu zzant() throws RemoteException {
        zzamu zzamu = this.zzgdy.get();
        if (zzamu != null) {
            return zzamu;
        }
        zzbbd.zzfe("Unexpected call to adapter creator.");
        throw new RemoteException();
    }

    private final zzamv zze(String str, JSONObject jSONObject) throws RemoteException {
        zzamu zzant = zzant();
        if ("com.google.ads.mediation.customevent.CustomEventAdapter".equals(str) || "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str)) {
            try {
                if (zzant.zzdj(jSONObject.getString("class_name"))) {
                    return zzant.zzdi("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
                }
                return zzant.zzdi("com.google.ads.mediation.customevent.CustomEventAdapter");
            } catch (JSONException e) {
                zzbbd.zzc("Invalid custom event.", e);
            }
        }
        return zzant.zzdi(str);
    }

    public final boolean zzans() {
        return this.zzgdy.get() != null;
    }

    public final void zzb(zzamu zzamu) {
        this.zzgdy.compareAndSet(null, zzamu);
    }

    public final zzdlx zzd(String str, JSONObject jSONObject) throws zzdlr {
        zzamv zzamv;
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(str)) {
                zzamv = new zzanq(new AdMobAdapter());
            } else if ("com.google.ads.mediation.AdUrlAdapter".equals(str)) {
                zzamv = new zzanq(new AdUrlAdapter());
            } else if ("com.google.ads.mediation.admob.AdMobCustomTabsAdapter".equals(str)) {
                zzamv = new zzanq(new zzapq());
            } else {
                zzamv = zze(str, jSONObject);
            }
            zzdlx zzdlx = new zzdlx(zzamv);
            this.zzgdx.zza(str, zzdlx);
            return zzdlx;
        } catch (Throwable th) {
            throw new zzdlr(th);
        }
    }

    public final zzapa zzdm(String str) throws RemoteException {
        zzapa zzdm = zzant().zzdm(str);
        this.zzgdx.zza(str, zzdm);
        return zzdm;
    }
}

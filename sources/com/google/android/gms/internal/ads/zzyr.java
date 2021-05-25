package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
public final class zzyr {
    private int zzadj = -1;
    private int zzadk = -1;
    private String zzadl;
    private boolean zzbnu = false;
    private int zzcgw = -1;
    private String zzcgz;
    private String zzchb;
    private final Bundle zzchd = new Bundle();
    private String zzchf;
    private boolean zzchh;
    private final List<String> zzchj = new ArrayList();
    private final Bundle zzcjc = new Bundle();
    private AdInfo zzcjh;
    private final HashSet<String> zzcjp = new HashSet<>();
    private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzcjq = new HashMap<>();
    private final HashSet<String> zzcjr = new HashSet<>();
    private final HashSet<String> zzcjs = new HashSet<>();
    private Date zzmx;
    private Location zznb;

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbnu = z;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.util.HashMap<java.lang.Class<? extends com.google.android.gms.ads.mediation.NetworkExtras>, com.google.android.gms.ads.mediation.NetworkExtras> */
    /* JADX WARN: Multi-variable type inference failed */
    @Deprecated
    public final void zza(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
        } else {
            this.zzcjq.put(networkExtras.getClass(), networkExtras);
        }
    }

    @Deprecated
    public final void zzaa(boolean z) {
        this.zzchh = z;
    }

    public final void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
        if (this.zzcjc.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.zzcjc.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        this.zzcjc.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
    }

    public final void zzc(List<String> list) {
        this.zzchj.clear();
        for (String str : list) {
            if (TextUtils.isEmpty(str)) {
                zzbbd.zzfe("neighboring content URL should not be null or empty");
            } else {
                this.zzchj.add(str);
            }
        }
    }

    public final void zzcj(String str) {
        this.zzcjp.add(str);
    }

    public final void zzck(String str) {
        this.zzcjr.add(str);
    }

    public final void zzcl(String str) {
        this.zzcjr.remove(str);
    }

    public final void zzcm(String str) {
        this.zzchb = str;
    }

    public final void zzcn(String str) {
        this.zzcgz = str;
    }

    public final void zzco(String str) {
        this.zzchf = str;
    }

    public final void zzcp(String str) {
        this.zzcjs.add(str);
    }

    @Deprecated
    public final void zzcq(String str) {
        if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
            this.zzadl = str;
        }
    }

    @Deprecated
    public final void zzda(int i) {
        this.zzcgw = i;
    }

    @Deprecated
    public final void zzdb(int i) {
        if (i == -1 || i == 0 || i == 1) {
            this.zzadk = i;
        }
    }

    public final void zze(String str, String str2) {
        this.zzchd.putString(str, str2);
    }

    @Deprecated
    public final void zzz(boolean z) {
        this.zzadj = z ? 1 : 0;
    }

    public final void zza(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
        this.zzcjc.putBundle(cls.getName(), bundle);
    }

    @Deprecated
    public final void zza(Date date) {
        this.zzmx = date;
    }

    public final void zza(Location location) {
        this.zznb = location;
    }

    public final void zza(AdInfo adInfo) {
        this.zzcjh = adInfo;
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzekj;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
@ParametersAreNonnullByDefault
public final class zzavl implements zzavu {
    private static List<Future<Void>> zzdvs = Collections.synchronizedList(new ArrayList());
    private final Object lock = new Object();
    private final zzavt zzdsm;
    @GuardedBy("lock")
    private final zzekj.zzb.zza zzdvt;
    @GuardedBy("lock")
    private final LinkedHashMap<String, zzekj.zzb.zzh.C0202zzb> zzdvu;
    @GuardedBy("lock")
    private final List<String> zzdvv = new ArrayList();
    @GuardedBy("lock")
    private final List<String> zzdvw = new ArrayList();
    private final zzavw zzdvx;
    @VisibleForTesting
    private boolean zzdvy;
    private final zzavz zzdvz;
    private HashSet<String> zzdwa = new HashSet<>();
    private boolean zzdwb = false;
    private boolean zzdwc = false;
    private boolean zzdwd = false;
    private final Context zzvr;

    public zzavl(Context context, zzbbg zzbbg, zzavt zzavt, String str, zzavw zzavw) {
        Preconditions.checkNotNull(zzavt, "SafeBrowsing config is not present.");
        this.zzvr = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzdvu = new LinkedHashMap<>();
        this.zzdvx = zzavw;
        this.zzdsm = zzavt;
        for (String str2 : zzavt.zzdwl) {
            this.zzdwa.add(str2.toLowerCase(Locale.ENGLISH));
        }
        this.zzdwa.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzekj.zzb.zza zzbiq = zzekj.zzb.zzbiq();
        zzbiq.zza(zzekj.zzb.zzg.OCTAGON_AD);
        zzbiq.zzhy(str);
        zzbiq.zzhz(str);
        zzekj.zzb.C0198zzb.zza zzbis = zzekj.zzb.C0198zzb.zzbis();
        String str3 = this.zzdsm.zzdwh;
        if (str3 != null) {
            zzbis.zzic(str3);
        }
        zzbiq.zza((zzekj.zzb.C0198zzb) ((zzegp) zzbis.zzbfx()));
        zzekj.zzb.zzi.zza zzbx = zzekj.zzb.zzi.zzbjg().zzbx(Wrappers.packageManager(this.zzvr).isCallerInstantApp());
        String str4 = zzbbg.zzbra;
        if (str4 != null) {
            zzbx.zzij(str4);
        }
        long apkVersion = (long) GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzvr);
        if (apkVersion > 0) {
            zzbx.zzfu(apkVersion);
        }
        zzbiq.zza((zzekj.zzb.zzi) ((zzegp) zzbx.zzbfx()));
        this.zzdvt = zzbiq;
        this.zzdvz = new zzavz(this.zzvr, this.zzdsm.zzdwo, this);
    }

    @Nullable
    private final zzekj.zzb.zzh.C0202zzb zzed(String str) {
        zzekj.zzb.zzh.C0202zzb zzb;
        synchronized (this.lock) {
            zzb = this.zzdvu.get(str);
        }
        return zzb;
    }

    public static final /* synthetic */ Void zzee(String str) {
        return null;
    }

    @VisibleForTesting
    private final zzdvt<Void> zzvr() {
        zzdvt<Void> zzb;
        boolean z = this.zzdvy;
        if (!((z && this.zzdsm.zzdwn) || (this.zzdwd && this.zzdsm.zzdwm) || (!z && this.zzdsm.zzdwk))) {
            return zzdvl.zzaf(null);
        }
        synchronized (this.lock) {
            for (zzekj.zzb.zzh.C0202zzb zzb2 : this.zzdvu.values()) {
                this.zzdvt.zza((zzekj.zzb.zzh) ((zzegp) zzb2.zzbfx()));
            }
            this.zzdvt.zzm(this.zzdvv);
            this.zzdvt.zzn(this.zzdvw);
            if (zzavv.isEnabled()) {
                String url = this.zzdvt.getUrl();
                String zzbin = this.zzdvt.zzbin();
                StringBuilder sb = new StringBuilder(String.valueOf(url).length() + 53 + String.valueOf(zzbin).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(url);
                sb.append("\n  clickUrl: ");
                sb.append(zzbin);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                for (zzekj.zzb.zzh zzh : this.zzdvt.zzbim()) {
                    sb2.append("    [");
                    sb2.append(zzh.zzbjd());
                    sb2.append("] ");
                    sb2.append(zzh.getUrl());
                }
                zzavv.zzef(sb2.toString());
            }
            zzdvt<String> zza = new zzazt(this.zzvr).zza(1, this.zzdsm.zzdwi, null, ((zzekj.zzb) ((zzegp) this.zzdvt.zzbfx())).toByteArray());
            if (zzavv.isEnabled()) {
                zza.addListener(zzavm.zzdwe, zzbbi.zzedu);
            }
            zzb = zzdvl.zzb(zza, zzavp.zzdwg, zzbbi.zzedz);
        }
        return zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zza(String str, Map<String, String> map, int i) {
        synchronized (this.lock) {
            if (i == 3) {
                this.zzdwd = true;
            }
            if (this.zzdvu.containsKey(str)) {
                if (i == 3) {
                    this.zzdvu.get(str).zzb(zzekj.zzb.zzh.zza.zzhw(i));
                }
                return;
            }
            zzekj.zzb.zzh.C0202zzb zzbje = zzekj.zzb.zzh.zzbje();
            zzekj.zzb.zzh.zza zzhw = zzekj.zzb.zzh.zza.zzhw(i);
            if (zzhw != null) {
                zzbje.zzb(zzhw);
            }
            zzbje.zzhx(this.zzdvu.size());
            zzbje.zzih(str);
            zzekj.zzb.zzd.zza zzbiw = zzekj.zzb.zzd.zzbiw();
            if (this.zzdwa.size() > 0 && map != null) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey() != null ? entry.getKey() : "";
                    String value = entry.getValue() != null ? entry.getValue() : "";
                    if (this.zzdwa.contains(key.toLowerCase(Locale.ENGLISH))) {
                        zzbiw.zza((zzekj.zzb.zzc) ((zzegp) zzekj.zzb.zzc.zzbiu().zzan(zzeff.zzhu(key)).zzao(zzeff.zzhu(value)).zzbfx()));
                    }
                }
            }
            zzbje.zzb((zzekj.zzb.zzd) ((zzegp) zzbiw.zzbfx()));
            this.zzdvu.put(str, zzbje);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzea(String str) {
        synchronized (this.lock) {
            if (str == null) {
                this.zzdvt.zzbio();
            } else {
                this.zzdvt.zzia(str);
            }
        }
    }

    public final void zzeb(String str) {
        synchronized (this.lock) {
            this.zzdvv.add(str);
        }
    }

    public final void zzec(String str) {
        synchronized (this.lock) {
            this.zzdvw.add(str);
        }
    }

    public final /* synthetic */ zzdvt zzi(Map map) throws Exception {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.lock) {
                            int length = optJSONArray.length();
                            zzekj.zzb.zzh.C0202zzb zzed = zzed(str);
                            if (zzed == null) {
                                String valueOf = String.valueOf(str);
                                zzavv.zzef(valueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(valueOf) : new String("Cannot find the corresponding resource object for "));
                            } else {
                                boolean z = false;
                                for (int i = 0; i < length; i++) {
                                    zzed.zzii(optJSONArray.getJSONObject(i).getString("threat_type"));
                                }
                                boolean z2 = this.zzdvy;
                                if (length > 0) {
                                    z = true;
                                }
                                this.zzdvy = z | z2;
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                if (zzacu.zzdbp.get().booleanValue()) {
                    zzbbd.zzb("Failed to get SafeBrowsing metadata", e);
                }
                return zzdvl.immediateFailedFuture(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zzdvy) {
            synchronized (this.lock) {
                this.zzdvt.zza(zzekj.zzb.zzg.OCTAGON_AD_SB_MATCH);
            }
        }
        return zzvr();
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzl(View view) {
        if (this.zzdsm.zzdwj && !this.zzdwc) {
            zzp.zzkp();
            Bitmap zzn = zzayh.zzn(view);
            if (zzn == null) {
                zzavv.zzef("Failed to capture the webview bitmap.");
                return;
            }
            this.zzdwc = true;
            zzayh.zzc(new Runnable(this, zzn) { // from class: com.google.android.gms.internal.ads.zzavk
                private final zzavl zzdvq;
                private final Bitmap zzdvr;

                {
                    this.zzdvq = r1;
                    this.zzdvr = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzdvq.zza(this.zzdvr);
                }
            });
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final zzavt zzvn() {
        return this.zzdsm;
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final boolean zzvo() {
        return PlatformVersion.isAtLeastKitKat() && this.zzdsm.zzdwj && !this.zzdwc;
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzvp() {
        this.zzdwb = true;
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final void zzvq() {
        synchronized (this.lock) {
            zzdvt<Map<String, String>> zza = this.zzdvx.zza(this.zzvr, this.zzdvu.keySet());
            zzavn zzavn = new zzduv(this) { // from class: com.google.android.gms.internal.ads.zzavn
                private final zzavl zzdvq;

                {
                    this.zzdvq = r1;
                }

                @Override // com.google.android.gms.internal.ads.zzduv
                public final zzdvt zzf(Object obj) {
                    return this.zzdvq.zzi((Map) obj);
                }
            };
            zzdvw zzdvw2 = zzbbi.zzedz;
            zzdvt zzb = zzdvl.zzb(zza, zzavn, zzdvw2);
            zzdvt zza2 = zzdvl.zza(zzb, 10, TimeUnit.SECONDS, zzbbi.zzedx);
            zzdvl.zza(zzb, new zzavo(this, zza2), zzdvw2);
            zzdvs.add(zza2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavu
    public final String[] zza(String[] strArr) {
        return (String[]) this.zzdvz.zzb(strArr).toArray(new String[0]);
    }

    public final /* synthetic */ void zza(Bitmap bitmap) {
        zzefo zzbdm = zzeff.zzbdm();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzbdm);
        synchronized (this.lock) {
            this.zzdvt.zza((zzekj.zzb.zzf) ((zzegp) zzekj.zzb.zzf.zzbjb().zzaq(zzbdm.zzbda()).zzie("image/png").zza(zzekj.zzb.zzf.EnumC0201zzb.TYPE_CREATIVE).zzbfx()));
        }
    }
}

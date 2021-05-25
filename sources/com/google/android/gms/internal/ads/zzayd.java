package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.adjust.sdk.AdjustConfig;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzayd implements zzaya {
    private final Object lock = new Object();
    @Nullable
    @GuardedBy("lock")
    private SharedPreferences zzcld;
    @GuardedBy("lock")
    private boolean zzdqd = true;
    @GuardedBy("lock")
    private boolean zzdqq = false;
    @GuardedBy("lock")
    private String zzdqt = "";
    @GuardedBy("lock")
    private boolean zzdsc = true;
    @GuardedBy("lock")
    private boolean zzdso = true;
    private boolean zzdzm;
    private final List<Runnable> zzdzn = new ArrayList();
    private zzdvt<?> zzdzo;
    @Nullable
    @GuardedBy("lock")
    private zzrk zzdzp = null;
    @Nullable
    @GuardedBy("lock")
    private SharedPreferences.Editor zzdzq;
    @GuardedBy("lock")
    private boolean zzdzr = false;
    @Nullable
    @GuardedBy("lock")
    private String zzdzs;
    @Nullable
    @GuardedBy("lock")
    private String zzdzt;
    @GuardedBy("lock")
    private long zzdzu = 0;
    @GuardedBy("lock")
    private long zzdzv = 0;
    @GuardedBy("lock")
    private long zzdzw = 0;
    @GuardedBy("lock")
    private int zzdzx = -1;
    @GuardedBy("lock")
    private int zzdzy = 0;
    @GuardedBy("lock")
    private Set<String> zzdzz = Collections.emptySet();
    @GuardedBy("lock")
    private JSONObject zzeaa = new JSONObject();
    @GuardedBy("lock")
    private String zzeab = null;
    @GuardedBy("lock")
    private int zzeac = -1;

    private final void zzc(Bundle bundle) {
        zzbbi.zzedu.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzayf
            private final zzayd zzdzl;

            {
                this.zzdzl = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdzl.zzwx();
            }
        });
    }

    private final void zzxl() {
        zzdvt<?> zzdvt = this.zzdzo;
        if (zzdvt != null && !zzdvt.isDone()) {
            try {
                this.zzdzo.get(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                zzbbd.zzd("Interrupted while waiting for preferences loaded.", e);
            } catch (CancellationException | ExecutionException | TimeoutException e2) {
                zzbbd.zzc("Fail to initialize AdSharedPreferenceManager.", e2);
            }
        }
    }

    private final Bundle zzxm() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("listener_registration_bundle", true);
        synchronized (this.lock) {
            bundle.putBoolean("use_https", this.zzdqd);
            bundle.putBoolean("content_url_opted_out", this.zzdsc);
            bundle.putBoolean("content_vertical_opted_out", this.zzdso);
            bundle.putBoolean("auto_collect_location", this.zzdqq);
            bundle.putInt("version_code", this.zzdzy);
            bundle.putStringArray("never_pool_slots", (String[]) this.zzdzz.toArray(new String[0]));
            bundle.putString("app_settings_json", this.zzdqt);
            bundle.putLong("app_settings_last_update_ms", this.zzdzu);
            bundle.putLong("app_last_background_time_ms", this.zzdzv);
            bundle.putInt("request_in_session_count", this.zzdzx);
            bundle.putLong("first_ad_req_time_ms", this.zzdzw);
            bundle.putString("native_advanced_settings", this.zzeaa.toString());
            bundle.putString("display_cutout", this.zzeab);
            bundle.putInt("app_measurement_npa", this.zzeac);
            String str = this.zzdzs;
            if (str != null) {
                bundle.putString("content_url_hashes", str);
            }
            String str2 = this.zzdzt;
            if (str2 != null) {
                bundle.putString("content_vertical_hashes", str2);
            }
        }
        return bundle;
    }

    public final void zza(Context context, String str, boolean z) {
        String str2;
        synchronized (this.lock) {
            if (this.zzcld != null) {
                return;
            }
        }
        if (str == null) {
            str2 = AdjustConfig.AD_REVENUE_ADMOB;
        } else {
            str2 = str.length() != 0 ? "admob__".concat(str) : new String("admob__");
        }
        this.zzdzo = zzbbi.zzedu.zzf(new Runnable(this, context, str2) { // from class: com.google.android.gms.internal.ads.zzayc
            private final Context zzcjx;
            private final String zzdin;
            private final zzayd zzdzl;

            {
                this.zzdzl = r1;
                this.zzcjx = r2;
                this.zzdin = r3;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzdzl.zzq(this.zzcjx, this.zzdin);
            }
        });
        this.zzdzm = z;
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final void zzao(boolean z) {
        zzxl();
        synchronized (this.lock) {
            if (this.zzdsc != z) {
                this.zzdsc = z;
                SharedPreferences.Editor editor = this.zzdzq;
                if (editor != null) {
                    editor.putBoolean("content_url_opted_out", z);
                    this.zzdzq.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("content_url_opted_out", this.zzdsc);
                bundle.putBoolean("content_vertical_opted_out", this.zzdso);
                zzc(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final void zzap(boolean z) {
        zzxl();
        synchronized (this.lock) {
            if (this.zzdso != z) {
                this.zzdso = z;
                SharedPreferences.Editor editor = this.zzdzq;
                if (editor != null) {
                    editor.putBoolean("content_vertical_opted_out", z);
                    this.zzdzq.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("content_url_opted_out", this.zzdsc);
                bundle.putBoolean("content_vertical_opted_out", this.zzdso);
                zzc(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final void zzaq(boolean z) {
        zzxl();
        synchronized (this.lock) {
            if (this.zzdqq != z) {
                this.zzdqq = z;
                SharedPreferences.Editor editor = this.zzdzq;
                if (editor != null) {
                    editor.putBoolean("auto_collect_location", z);
                    this.zzdzq.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean("auto_collect_location", z);
                zzc(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final void zzb(Runnable runnable) {
        this.zzdzn.add(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final void zzdf(int i) {
        zzxl();
        synchronized (this.lock) {
            if (this.zzdzy != i) {
                this.zzdzy = i;
                SharedPreferences.Editor editor = this.zzdzq;
                if (editor != null) {
                    editor.putInt("version_code", i);
                    this.zzdzq.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("version_code", i);
                zzc(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final void zzdg(int i) {
        zzxl();
        synchronized (this.lock) {
            if (this.zzdzx != i) {
                this.zzdzx = i;
                SharedPreferences.Editor editor = this.zzdzq;
                if (editor != null) {
                    editor.putInt("request_in_session_count", i);
                    this.zzdzq.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putInt("request_in_session_count", i);
                zzc(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final void zzej(@Nullable String str) {
        zzxl();
        synchronized (this.lock) {
            if (str != null) {
                if (!str.equals(this.zzdzs)) {
                    this.zzdzs = str;
                    SharedPreferences.Editor editor = this.zzdzq;
                    if (editor != null) {
                        editor.putString("content_url_hashes", str);
                        this.zzdzq.apply();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("content_url_hashes", str);
                    zzc(bundle);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final void zzek(@Nullable String str) {
        zzxl();
        synchronized (this.lock) {
            if (str != null) {
                if (!str.equals(this.zzdzt)) {
                    this.zzdzt = str;
                    SharedPreferences.Editor editor = this.zzdzq;
                    if (editor != null) {
                        editor.putString("content_vertical_hashes", str);
                        this.zzdzq.apply();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("content_vertical_hashes", str);
                    zzc(bundle);
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final void zzel(String str) {
        zzxl();
        synchronized (this.lock) {
            long currentTimeMillis = zzp.zzkw().currentTimeMillis();
            this.zzdzu = currentTimeMillis;
            if (str != null) {
                if (!str.equals(this.zzdqt)) {
                    this.zzdqt = str;
                    SharedPreferences.Editor editor = this.zzdzq;
                    if (editor != null) {
                        editor.putString("app_settings_json", str);
                        this.zzdzq.putLong("app_settings_last_update_ms", currentTimeMillis);
                        this.zzdzq.apply();
                    }
                    Bundle bundle = new Bundle();
                    bundle.putString("app_settings_json", str);
                    bundle.putLong("app_settings_last_update_ms", currentTimeMillis);
                    zzc(bundle);
                    for (Runnable runnable : this.zzdzn) {
                        runnable.run();
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final void zzem(String str) {
        zzxl();
        synchronized (this.lock) {
            if (!TextUtils.equals(this.zzeab, str)) {
                this.zzeab = str;
                SharedPreferences.Editor editor = this.zzdzq;
                if (editor != null) {
                    editor.putString("display_cutout", str);
                    this.zzdzq.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putString("display_cutout", str);
                zzc(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final void zzez(long j) {
        zzxl();
        synchronized (this.lock) {
            if (this.zzdzv != j) {
                this.zzdzv = j;
                SharedPreferences.Editor editor = this.zzdzq;
                if (editor != null) {
                    editor.putLong("app_last_background_time_ms", j);
                    this.zzdzq.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putLong("app_last_background_time_ms", j);
                zzc(bundle);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final void zzfa(long j) {
        zzxl();
        synchronized (this.lock) {
            if (this.zzdzw != j) {
                this.zzdzw = j;
                SharedPreferences.Editor editor = this.zzdzq;
                if (editor != null) {
                    editor.putLong("first_ad_req_time_ms", j);
                    this.zzdzq.apply();
                }
                Bundle bundle = new Bundle();
                bundle.putLong("first_ad_req_time_ms", j);
                zzc(bundle);
            }
        }
    }

    public final /* synthetic */ void zzq(Context context, String str) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        synchronized (this.lock) {
            this.zzcld = sharedPreferences;
            this.zzdzq = edit;
            if (PlatformVersion.isAtLeastM() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                z = true;
            }
            this.zzdzr = z;
            this.zzdqd = this.zzcld.getBoolean("use_https", this.zzdqd);
            this.zzdsc = this.zzcld.getBoolean("content_url_opted_out", this.zzdsc);
            this.zzdzs = this.zzcld.getString("content_url_hashes", this.zzdzs);
            this.zzdqq = this.zzcld.getBoolean("auto_collect_location", this.zzdqq);
            this.zzdso = this.zzcld.getBoolean("content_vertical_opted_out", this.zzdso);
            this.zzdzt = this.zzcld.getString("content_vertical_hashes", this.zzdzt);
            this.zzdzy = this.zzcld.getInt("version_code", this.zzdzy);
            this.zzdqt = this.zzcld.getString("app_settings_json", this.zzdqt);
            this.zzdzu = this.zzcld.getLong("app_settings_last_update_ms", this.zzdzu);
            this.zzdzv = this.zzcld.getLong("app_last_background_time_ms", this.zzdzv);
            this.zzdzx = this.zzcld.getInt("request_in_session_count", this.zzdzx);
            this.zzdzw = this.zzcld.getLong("first_ad_req_time_ms", this.zzdzw);
            this.zzdzz = this.zzcld.getStringSet("never_pool_slots", this.zzdzz);
            this.zzeab = this.zzcld.getString("display_cutout", this.zzeab);
            this.zzeac = this.zzcld.getInt("app_measurement_npa", this.zzeac);
            try {
                this.zzeaa = new JSONObject(this.zzcld.getString("native_advanced_settings", "{}"));
            } catch (JSONException e) {
                zzbbd.zzd("Could not convert native advanced settings to json object", e);
            }
            zzc(zzxm());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    @Nullable
    public final zzrk zzwx() {
        if (!this.zzdzm) {
            return null;
        }
        if ((zzwy() && zzxa()) || !zzaci.zzczx.get().booleanValue()) {
            return null;
        }
        synchronized (this.lock) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.zzdzp == null) {
                this.zzdzp = new zzrk();
            }
            this.zzdzp.zzmg();
            zzbbd.zzfd("start fetching content...");
            return this.zzdzp;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final boolean zzwy() {
        boolean z;
        zzxl();
        synchronized (this.lock) {
            z = this.zzdsc;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    @Nullable
    public final String zzwz() {
        String str;
        zzxl();
        synchronized (this.lock) {
            str = this.zzdzs;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final boolean zzxa() {
        boolean z;
        zzxl();
        synchronized (this.lock) {
            z = this.zzdso;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    @Nullable
    public final String zzxb() {
        String str;
        zzxl();
        synchronized (this.lock) {
            str = this.zzdzt;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final boolean zzxc() {
        boolean z;
        zzxl();
        synchronized (this.lock) {
            z = this.zzdqq;
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final int zzxd() {
        int i;
        zzxl();
        synchronized (this.lock) {
            i = this.zzdzy;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final zzaxl zzxe() {
        zzaxl zzaxl;
        zzxl();
        synchronized (this.lock) {
            zzaxl = new zzaxl(this.zzdqt, this.zzdzu);
        }
        return zzaxl;
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final long zzxf() {
        long j;
        zzxl();
        synchronized (this.lock) {
            j = this.zzdzv;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final int zzxg() {
        int i;
        zzxl();
        synchronized (this.lock) {
            i = this.zzdzx;
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final long zzxh() {
        long j;
        zzxl();
        synchronized (this.lock) {
            j = this.zzdzw;
        }
        return j;
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final JSONObject zzxi() {
        JSONObject jSONObject;
        zzxl();
        synchronized (this.lock) {
            jSONObject = this.zzeaa;
        }
        return jSONObject;
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final void zzxj() {
        zzxl();
        synchronized (this.lock) {
            this.zzeaa = new JSONObject();
            SharedPreferences.Editor editor = this.zzdzq;
            if (editor != null) {
                editor.remove("native_advanced_settings");
                this.zzdzq.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", "{}");
            zzc(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final String zzxk() {
        String str;
        zzxl();
        synchronized (this.lock) {
            str = this.zzeab;
        }
        return str;
    }

    @Override // com.google.android.gms.internal.ads.zzaya
    public final void zza(String str, String str2, boolean z) {
        zzxl();
        synchronized (this.lock) {
            JSONArray optJSONArray = this.zzeaa.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            int i = 0;
            while (true) {
                if (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        if (!str2.equals(optJSONObject.optString("template_id"))) {
                            i++;
                        } else if (!z || !optJSONObject.optBoolean("uses_media_view", false)) {
                            length = i;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", zzp.zzkw().currentTimeMillis());
                optJSONArray.put(length, jSONObject);
                this.zzeaa.put(str, optJSONArray);
            } catch (JSONException e) {
                zzbbd.zzd("Could not update native advanced settings", e);
            }
            SharedPreferences.Editor editor = this.zzdzq;
            if (editor != null) {
                editor.putString("native_advanced_settings", this.zzeaa.toString());
                this.zzdzq.apply();
            }
            Bundle bundle = new Bundle();
            bundle.putString("native_advanced_settings", this.zzeaa.toString());
            zzc(bundle);
        }
    }
}

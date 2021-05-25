package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzamp {
    public final List<zzamq> zzdiq;
    private final long zzdir;
    private final List<String> zzdis;
    private final List<String> zzdit;
    private final List<String> zzdiu;
    private final List<String> zzdiv;
    private final List<String> zzdiw;
    private final boolean zzdix;
    private final String zzdiy;
    private final long zzdiz;
    private final String zzdja;
    private final int zzdjb;
    private final int zzdjc;
    private final long zzdjd;
    private final boolean zzdje;
    private final boolean zzdjf;
    private final boolean zzdjg;
    private final boolean zzdjh;
    private int zzdji;
    private int zzdjj;
    private boolean zzdjk;

    public zzamp(JSONObject jSONObject) throws JSONException {
        if (zzbbd.isLoggable(2)) {
            String valueOf = String.valueOf(jSONObject.toString(2));
            zzaxy.zzei(valueOf.length() != 0 ? "Mediation Response JSON: ".concat(valueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                zzamq zzamq = new zzamq(jSONArray.getJSONObject(i2));
                boolean z = true;
                if ("banner".equalsIgnoreCase(zzamq.zzdkg)) {
                    this.zzdjk = true;
                }
                arrayList.add(zzamq);
                if (i < 0) {
                    Iterator<String> it = zzamq.zzdjn.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        i = i2;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        this.zzdji = i;
        this.zzdjj = jSONArray.length();
        this.zzdiq = Collections.unmodifiableList(arrayList);
        this.zzdiy = jSONObject.optString("qdata");
        this.zzdjc = jSONObject.optInt("fs_model_type", -1);
        long j = -1;
        this.zzdjd = jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.zzdir = optJSONObject.optLong("ad_network_timeout_millis", -1);
            zzp.zzlh();
            this.zzdis = zzams.zza(optJSONObject, "click_urls");
            zzp.zzlh();
            this.zzdit = zzams.zza(optJSONObject, "imp_urls");
            zzp.zzlh();
            this.zzdiu = zzams.zza(optJSONObject, "downloaded_imp_urls");
            zzp.zzlh();
            this.zzdiv = zzams.zza(optJSONObject, "nofill_urls");
            zzp.zzlh();
            this.zzdiw = zzams.zza(optJSONObject, "remote_ping_urls");
            this.zzdix = optJSONObject.optBoolean("render_in_browser", false);
            long optLong = optJSONObject.optLong("refresh", -1);
            this.zzdiz = optLong > 0 ? 1000 * optLong : j;
            zzaue zza = zzaue.zza(optJSONObject.optJSONArray("rewards"));
            if (zza == null) {
                this.zzdja = null;
                this.zzdjb = 0;
            } else {
                this.zzdja = zza.type;
                this.zzdjb = zza.zzdva;
            }
            this.zzdje = optJSONObject.optBoolean("use_displayed_impression", false);
            this.zzdjf = optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            this.zzdjg = optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            this.zzdjh = optJSONObject.optBoolean("allow_custom_click_gesture", false);
            return;
        }
        this.zzdir = -1;
        this.zzdis = null;
        this.zzdit = null;
        this.zzdiu = null;
        this.zzdiv = null;
        this.zzdiw = null;
        this.zzdiz = -1;
        this.zzdja = null;
        this.zzdjb = 0;
        this.zzdje = false;
        this.zzdix = false;
        this.zzdjf = false;
        this.zzdjg = false;
        this.zzdjh = false;
    }
}

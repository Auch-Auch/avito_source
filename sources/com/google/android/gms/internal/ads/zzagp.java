package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.avito.android.remote.auth.AuthSource;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzagp {
    public static final zzahf<zzbfq> zzddx = zzags.zzdeq;
    public static final zzahf<zzbfq> zzddy = zzagr.zzdeq;
    public static final zzahf<zzbfq> zzddz = zzagu.zzdeq;
    public static final zzahf<zzbfq> zzdea = zzagt.zzdeq;
    public static final zzahf<zzbfq> zzdeb = new zzagy();
    public static final zzahf<zzbfq> zzdec = new zzagx();
    public static final zzahf<zzbfq> zzded = zzagw.zzdeq;
    public static final zzahf<Object> zzdee = new zzaha();
    public static final zzahf<zzbfq> zzdef = new zzagz();
    public static final zzahf<zzbfq> zzdeg = zzagv.zzdeq;
    public static final zzahf<zzbfq> zzdeh = new zzahc();
    public static final zzahf<zzbfq> zzdei = new zzahb();
    public static final zzahf<zzbde> zzdej = new zzbeo();
    public static final zzahf<zzbde> zzdek = new zzber();
    public static final zzahf<zzbfq> zzdel = new zzagq();
    public static final zzahl zzdem = new zzahl();
    public static final zzahf<zzbfq> zzden = new zzahe();
    public static final zzahf<zzbfq> zzdeo = new zzahd();
    public static final zzahf<zzbfq> zzdep = new zzahg();

    public static final /* synthetic */ void zza(zzbhb zzbhb, Map map) {
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzeg zzabh = zzbhb.zzabh();
            if (zzabh != null) {
                zzabh.zzca().zza(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException unused) {
            zzbbd.zzfe("Could not parse touch parameters from gmsg.");
        }
    }

    public static final /* synthetic */ void zzb(zzbgt zzbgt, Map map) {
        PackageManager packageManager = zzbgt.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString("u");
                        String optString3 = jSONObject2.optString("i");
                        String optString4 = jSONObject2.optString(AuthSource.OPEN_CHANNEL_LIST);
                        String optString5 = jSONObject2.optString("p");
                        String optString6 = jSONObject2.optString("c");
                        String optString7 = jSONObject2.optString("intent_url");
                        Intent intent = null;
                        if (!TextUtils.isEmpty(optString7)) {
                            try {
                                intent = Intent.parseUri(optString7, 0);
                            } catch (URISyntaxException e) {
                                String valueOf = String.valueOf(optString7);
                                zzbbd.zzc(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e);
                            }
                        }
                        boolean z = true;
                        if (intent == null) {
                            intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                        }
                        if (packageManager.resolveActivity(intent, 65536) == null) {
                            z = false;
                        }
                        try {
                            jSONObject.put(optString, z);
                        } catch (JSONException e2) {
                            zzbbd.zzc("Error constructing openable urls response.", e2);
                        }
                    } catch (JSONException e3) {
                        zzbbd.zzc("Error parsing the intent data.", e3);
                    }
                }
                ((zzajk) zzbgt).zzb("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzajk) zzbgt).zzb("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzajk) zzbgt).zzb("openableIntents", new JSONObject());
        }
    }

    public static final /* synthetic */ void zzc(zzbgt zzbgt, Map map) {
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzcxw)).booleanValue()) {
            zzbbd.zzfe("canOpenAppGmsgHandler disabled.");
            return;
        }
        String str = (String) map.get("package_name");
        if (TextUtils.isEmpty(str)) {
            zzbbd.zzfe("Package name missing in canOpenApp GMSG.");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, Boolean.valueOf(zzbgt.getContext().getPackageManager().getLaunchIntentForPackage(str) != null));
        ((zzajk) zzbgt).zza("openableApp", hashMap);
    }

    public static final /* synthetic */ void zzd(zzbgt zzbgt, Map map) {
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            zzbbd.zzfe("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzbgt.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) == null) {
                z = false;
            }
            hashMap.put(str2, Boolean.valueOf(z));
        }
        ((zzajk) zzbgt).zza("openableURLs", hashMap);
    }

    public static final /* synthetic */ void zza(zzbgt zzbgt, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzbbd.zzfe("URL missing from httpTrack GMSG.");
        } else {
            new zzbag(zzbgt.getContext(), ((zzbha) zzbgt).zzzt().zzbra, str).zzwv();
        }
    }

    public static final /* synthetic */ void zza(zzajk zzajk, Map map) {
        String str = (String) map.get("u");
        if (str == null) {
            zzbbd.zzfe("URL missing from click GMSG.");
            return;
        }
        Uri parse = Uri.parse(str);
        try {
            zzeg zzabh = ((zzbhb) zzajk).zzabh();
            if (zzabh != null && zzabh.zzb(parse)) {
                parse = zzabh.zza(parse, ((zzbgt) zzajk).getContext(), ((zzbhd) zzajk).getView(), ((zzbgt) zzajk).zzzq());
            }
        } catch (zzef unused) {
            zzbbd.zzfe(str.length() != 0 ? "Unable to append parameter to URL: ".concat(str) : new String("Unable to append parameter to URL: "));
        }
        zzbgt zzbgt = (zzbgt) zzajk;
        new zzbag(zzbgt.getContext(), ((zzbha) zzajk).zzzt().zzbra, zzawq.zzb(parse, zzbgt.getContext())).zzwv();
    }
}

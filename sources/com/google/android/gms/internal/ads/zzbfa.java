package com.google.android.gms.internal.ads;

import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzbfa implements zzahf<zzbde> {
    private static Integer zzb(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + String.valueOf(str).length() + 39);
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzbbd.zzfe(sb.toString());
            return null;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahf
    public final /* synthetic */ void zza(zzbde zzbde, Map map) {
        zzbev zzbev;
        zzbde zzbde2 = zzbde;
        if (zzbbd.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject);
            StringBuilder sb = new StringBuilder(valueOf.length() + 15);
            sb.append("Precache GMSG: ");
            sb.append(valueOf);
            zzbbd.zzef(sb.toString());
        }
        zzp.zzll();
        if (!map.containsKey("abort")) {
            String str = (String) map.get("src");
            if (str != null) {
                String[] strArr = {str};
                String str2 = (String) map.get("demuxed");
                if (str2 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str2);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i = 0; i < jSONArray.length(); i++) {
                            strArr2[i] = jSONArray.getString(i);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused) {
                        zzbbd.zzfe(str2.length() != 0 ? "Malformed demuxed URL list for precache: ".concat(str2) : new String("Malformed demuxed URL list for precache: "));
                        strArr = null;
                    }
                }
                if (strArr == null) {
                    strArr = new String[]{str};
                }
                if (zzbes.zzd(zzbde2) != null) {
                    zzbbd.zzfe("Precache task is already running.");
                    return;
                } else if (zzbde2.zzzr() == null) {
                    zzbbd.zzfe("Precache requires a dependency provider.");
                    return;
                } else {
                    zzbdf zzbdf = new zzbdf((String) map.get("flags"));
                    Integer zzb = zzb(map, ScreenPublicConstsKt.CONTENT_TYPE_PLAYER);
                    if (zzb == null) {
                        zzb = 0;
                    }
                    zzbev = zzbde2.zzzr().zzboe.zza(zzbde2, zzb.intValue(), null, zzbdf);
                    new zzbeq(zzbde2, zzbev, str, strArr).zzwv();
                }
            } else {
                zzbeq zzd = zzbes.zzd(zzbde2);
                if (zzd != null) {
                    zzbev = zzd.zzekp;
                } else {
                    zzbbd.zzfe("Precache must specify a source.");
                    return;
                }
            }
            Integer zzb2 = zzb(map, "minBufferMs");
            if (zzb2 != null) {
                zzbev.zzdl(zzb2.intValue());
            }
            Integer zzb3 = zzb(map, "maxBufferMs");
            if (zzb3 != null) {
                zzbev.zzdm(zzb3.intValue());
            }
            Integer zzb4 = zzb(map, "bufferForPlaybackMs");
            if (zzb4 != null) {
                zzbev.zzdn(zzb4.intValue());
            }
            Integer zzb5 = zzb(map, "bufferForPlaybackAfterRebufferMs");
            if (zzb5 != null) {
                zzbev.zzdo(zzb5.intValue());
            }
        } else if (!zzbes.zzc(zzbde2)) {
            zzbbd.zzfe("Precache abort but no precache task running.");
        }
    }
}

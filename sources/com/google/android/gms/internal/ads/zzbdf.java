package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;
public final class zzbdf {
    public final boolean zzehu;
    public final int zzehv;
    public final int zzehw;
    public final int zzehx;
    private final String zzehy;
    public final int zzehz;
    public final int zzeia;
    public final int zzeib;
    public final int zzeic;
    public final boolean zzeid;
    public final int zzeie;

    public zzbdf(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zzehu = zza(jSONObject, "aggressive_media_codec_release", zzaat.zzcmj);
        this.zzehv = zzb(jSONObject, "byte_buffer_precache_limit", zzaat.zzclr);
        this.zzehw = zzb(jSONObject, "exo_cache_buffer_size", zzaat.zzcly);
        this.zzehx = zzb(jSONObject, "exo_connect_timeout_millis", zzaat.zzcln);
        this.zzehy = zzc(jSONObject, "exo_player_version", zzaat.zzclm);
        this.zzehz = zzb(jSONObject, "exo_read_timeout_millis", zzaat.zzclo);
        this.zzeia = zzb(jSONObject, "load_check_interval_bytes", zzaat.zzclp);
        this.zzeib = zzb(jSONObject, "player_precache_limit", zzaat.zzclq);
        this.zzeic = zzb(jSONObject, "socket_receive_buffer_size", zzaat.zzcls);
        this.zzeid = zza(jSONObject, "use_cache_data_source", zzaat.zzcsq);
        this.zzeie = zzb(jSONObject, "min_retry_count", zzaat.zzclu);
    }

    private static boolean zza(JSONObject jSONObject, String str, zzaai<Boolean> zzaai) {
        return zza(jSONObject, str, ((Boolean) zzwe.zzpu().zzd(zzaai)).booleanValue());
    }

    private static int zzb(JSONObject jSONObject, String str, zzaai<Integer> zzaai) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return ((Integer) zzwe.zzpu().zzd(zzaai)).intValue();
    }

    private static String zzc(JSONObject jSONObject, String str, zzaai<String> zzaai) {
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException unused) {
            }
        }
        return (String) zzwe.zzpu().zzd(zzaai);
    }

    private static boolean zza(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
            }
        }
        return z;
    }
}

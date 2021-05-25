package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.vk.sdk.api.VKApiConst;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzbeo implements zzahf<zzbde> {
    private boolean zzekn;

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            zzwe.zzpq();
            return zzbat.zzc(context, Integer.parseInt(str2));
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder(str2.length() + String.valueOf(str).length() + 34);
            sb.append("Could not parse ");
            sb.append(str);
            sb.append(" in a video GMSG: ");
            sb.append(str2);
            zzbbd.zzfe(sb.toString());
            return i;
        }
    }

    private static void zza(zzbcr zzbcr, Map<String, String> map) {
        String str = map.get("minBufferMs");
        String str2 = map.get("maxBufferMs");
        String str3 = map.get("bufferForPlaybackMs");
        String str4 = map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzbcr.zzdl(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzbbd.zzfe(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", str, str2));
                return;
            }
        }
        if (str2 != null) {
            zzbcr.zzdm(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzbcr.zzdn(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzbcr.zzdo(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzbcr.zzdp(Integer.parseInt(str5));
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahf
    public final /* synthetic */ void zza(zzbde zzbde, Map map) {
        int i;
        zzbde zzbde2 = zzbde;
        String str = (String) map.get("action");
        if (str == null) {
            zzbbd.zzfe("Action missing from video GMSG.");
            return;
        }
        if (zzbbd.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObject2 = jSONObject.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(jSONObject2).length() + str.length() + 13);
            sb.append("Video GMSG: ");
            sb.append(str);
            sb.append(" ");
            sb.append(jSONObject2);
            zzbbd.zzef(sb.toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzbbd.zzfe("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzbde2.setBackgroundColor(Color.parseColor(str2));
            } catch (IllegalArgumentException unused) {
                zzbbd.zzfe("Invalid color parameter in video GMSG.");
            }
        } else {
            if ("decoderProps".equals(str)) {
                String str3 = (String) map.get("mimeTypes");
                if (str3 == null) {
                    zzbbd.zzfe("No MIME types specified for decoder properties inspection.");
                    zzbcr.zza(zzbde2, "missingMimeTypes");
                    return;
                }
                HashMap hashMap = new HashMap();
                String[] split = str3.split(",");
                for (String str4 : split) {
                    hashMap.put(str4, zzbar.zzew(str4.trim()));
                }
                zzbcr.zza(zzbde2, hashMap);
                return;
            }
            zzbcx zzzn = zzbde2.zzzn();
            if (zzzn == null) {
                zzbbd.zzfe("Could not get underlay container for a video GMSG.");
                return;
            }
            boolean equals = AppSettingsData.STATUS_NEW.equals(str);
            boolean equals2 = VKApiConst.POSITION.equals(str);
            if (equals || equals2) {
                Context context = zzbde2.getContext();
                int zza = zza(context, map, "x", 0);
                int zza2 = zza(context, map, "y", 0);
                int zza3 = zza(context, map, "w", -1);
                int zza4 = zza(context, map, "h", -1);
                int min = Math.min(zza3, zzbde2.zzzv() - zza);
                int min2 = Math.min(zza4, zzbde2.zzzu() - zza2);
                try {
                    i = Integer.parseInt((String) map.get(ScreenPublicConstsKt.CONTENT_TYPE_PLAYER));
                } catch (NumberFormatException unused2) {
                    i = 0;
                }
                boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
                if (!equals || zzzn.zzzj() != null) {
                    zzzn.zze(zza, zza2, min, min2);
                    return;
                }
                zzzn.zza(zza, zza2, min, min2, i, parseBoolean, new zzbdf((String) map.get("flags")));
                zzbcr zzzj = zzzn.zzzj();
                if (zzzj != null) {
                    zza(zzzj, (Map<String, String>) map);
                    return;
                }
                return;
            }
            zzbgk zzzo = zzbde2.zzzo();
            if (zzzo != null) {
                if ("timeupdate".equals(str)) {
                    String str5 = (String) map.get("currentTime");
                    if (str5 == null) {
                        zzbbd.zzfe("currentTime parameter missing from timeupdate video GMSG.");
                        return;
                    }
                    try {
                        zzzo.zze(Float.parseFloat(str5));
                        return;
                    } catch (NumberFormatException unused3) {
                        zzbbd.zzfe(str5.length() != 0 ? "Could not parse currentTime parameter from timeupdate video GMSG: ".concat(str5) : new String("Could not parse currentTime parameter from timeupdate video GMSG: "));
                        return;
                    }
                } else if ("skip".equals(str)) {
                    zzzo.zzacs();
                    return;
                }
            }
            zzbcr zzzj2 = zzzn.zzzj();
            if (zzzj2 == null) {
                zzbcr.zzb(zzbde2);
            } else if ("click".equals(str)) {
                Context context2 = zzbde2.getContext();
                int zza5 = zza(context2, map, "x", 0);
                int zza6 = zza(context2, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zza5, (float) zza6, 0);
                zzzj2.zze(obtain);
                obtain.recycle();
            } else if ("currentTime".equals(str)) {
                String str6 = (String) map.get("time");
                if (str6 == null) {
                    zzbbd.zzfe("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    zzzj2.seekTo((int) (Float.parseFloat(str6) * 1000.0f));
                } catch (NumberFormatException unused4) {
                    zzbbd.zzfe(str6.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(str6) : new String("Could not parse time parameter from currentTime video GMSG: "));
                }
            } else if ("hide".equals(str)) {
                zzzj2.setVisibility(4);
            } else if ("load".equals(str)) {
                zzzj2.zzhw();
            } else if ("loadControl".equals(str)) {
                zza(zzzj2, (Map<String, String>) map);
            } else if ("muted".equals(str)) {
                if (Boolean.parseBoolean((String) map.get("muted"))) {
                    zzzj2.zzzd();
                } else {
                    zzzj2.zzze();
                }
            } else if (Tracker.Events.CREATIVE_PAUSE.equals(str)) {
                zzzj2.pause();
            } else if ("play".equals(str)) {
                zzzj2.play();
            } else if ("show".equals(str)) {
                zzzj2.setVisibility(0);
            } else if ("src".equals(str)) {
                String str7 = (String) map.get("src");
                String[] strArr = {str7};
                String str8 = (String) map.get("demuxed");
                if (str8 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str8);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            strArr2[i2] = jSONArray.getString(i2);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused5) {
                        zzbbd.zzfe(str8.length() != 0 ? "Malformed demuxed URL list for playback: ".concat(str8) : new String("Malformed demuxed URL list for playback: "));
                        strArr = new String[]{str7};
                    }
                }
                zzzj2.zzc(str7, strArr);
            } else if ("touchMove".equals(str)) {
                Context context3 = zzbde2.getContext();
                zzzj2.zza((float) zza(context3, map, "dx", 0), (float) zza(context3, map, "dy", 0));
                if (!this.zzekn) {
                    zzbde2.zzuw();
                    this.zzekn = true;
                }
            } else if ("volume".equals(str)) {
                String str9 = (String) map.get("volume");
                if (str9 == null) {
                    zzbbd.zzfe("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    zzzj2.setVolume(Float.parseFloat(str9));
                } catch (NumberFormatException unused6) {
                    zzbbd.zzfe(str9.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(str9) : new String("Could not parse volume parameter from volume video GMSG: "));
                }
            } else if ("watermark".equals(str)) {
                zzzj2.zzzf();
            } else {
                zzbbd.zzfe(str.length() != 0 ? "Unknown video action: ".concat(str) : new String("Unknown video action: "));
            }
        }
    }
}

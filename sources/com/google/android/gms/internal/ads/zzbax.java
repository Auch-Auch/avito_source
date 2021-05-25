package com.google.android.gms.internal.ads;

import android.content.Context;
import android.provider.Settings;
import android.util.JsonWriter;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import java.io.IOException;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
public final class zzbax {
    @GuardedBy("lock")
    private static boolean enabled = false;
    private static Object lock = new Object();
    private static Clock zzbpw = DefaultClock.getInstance();
    @GuardedBy("lock")
    private static boolean zzedk = false;
    private static final Set<String> zzedl = new HashSet(Arrays.asList(new String[0]));
    private final List<String> zzedm;

    public zzbax() {
        this(null);
    }

    public static boolean isEnabled() {
        boolean z;
        synchronized (lock) {
            z = zzedk && enabled;
        }
        return z;
    }

    public static void zzar(boolean z) {
        synchronized (lock) {
            zzedk = true;
            enabled = z;
        }
    }

    private final void zzb(String str, String str2, @Nullable Map<String, ?> map, @Nullable byte[] bArr) {
        zza("onNetworkRequest", new zzbba(str, str2, map, bArr) { // from class: com.google.android.gms.internal.ads.zzbaw
            private final String zzdft;
            private final Map zzdfy;
            private final String zzdgb;
            private final byte[] zzedj;

            {
                this.zzdgb = r1;
                this.zzdft = r2;
                this.zzdfy = r3;
                this.zzedj = r4;
            }

            @Override // com.google.android.gms.internal.ads.zzbba
            public final void zzb(JsonWriter jsonWriter) {
                zzbax.zza(this.zzdgb, this.zzdft, this.zzdfy, this.zzedj, jsonWriter);
            }
        });
    }

    public static boolean zzbs(Context context) {
        if (!zzacj.zzdac.get().booleanValue()) {
            return false;
        }
        try {
            if (Settings.Global.getInt(context.getContentResolver(), "development_settings_enabled", 0) != 0) {
                return true;
            }
            return false;
        } catch (Exception e) {
            zzbbd.zzd("Fail to determine debug setting.", e);
            return false;
        }
    }

    private final void zzfa(@Nullable String str) {
        zza("onNetworkRequestError", new zzbba(str) { // from class: com.google.android.gms.internal.ads.zzbbb
            private final String zzdgb;

            {
                this.zzdgb = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbba
            public final void zzb(JsonWriter jsonWriter) {
                zzbax.zza(this.zzdgb, jsonWriter);
            }
        });
    }

    private static synchronized void zzfb(String str) {
        synchronized (zzbax.class) {
            zzbbd.zzfd("GMA Debug BEGIN");
            int i = 0;
            while (i < str.length()) {
                int i2 = i + 4000;
                String valueOf = String.valueOf(str.substring(i, Math.min(i2, str.length())));
                zzbbd.zzfd(valueOf.length() != 0 ? "GMA Debug CONTENT ".concat(valueOf) : new String("GMA Debug CONTENT "));
                i = i2;
            }
            zzbbd.zzfd("GMA Debug FINISH");
        }
    }

    public static void zzyp() {
        synchronized (lock) {
            zzedk = false;
            enabled = false;
            zzbbd.zzfe("Ad debug logging enablement is out of date.");
        }
    }

    public static boolean zzyq() {
        boolean z;
        synchronized (lock) {
            z = zzedk;
        }
        return z;
    }

    public final void zza(HttpURLConnection httpURLConnection, @Nullable byte[] bArr) {
        HashMap hashMap;
        if (isEnabled()) {
            if (httpURLConnection.getRequestProperties() == null) {
                hashMap = null;
            } else {
                hashMap = new HashMap(httpURLConnection.getRequestProperties());
            }
            zzb(new String(httpURLConnection.getURL().toString()), new String(httpURLConnection.getRequestMethod()), hashMap, bArr);
        }
    }

    public final void zzez(@Nullable String str) {
        if (isEnabled() && str != null) {
            zzi(str.getBytes());
        }
    }

    public final void zzi(byte[] bArr) {
        zza("onNetworkResponseBody", new zzbba(bArr) { // from class: com.google.android.gms.internal.ads.zzbay
            private final byte[] zzedn;

            {
                this.zzedn = r1;
            }

            @Override // com.google.android.gms.internal.ads.zzbba
            public final void zzb(JsonWriter jsonWriter) {
                zzbax.zza(this.zzedn, jsonWriter);
            }
        });
    }

    /* JADX DEBUG: Can't convert new array creation: APUT found in different block: 0x0031: APUT  (r0v1 java.lang.String[]), (0 ??[int, short, byte, char]), (r5v6 java.lang.String) */
    public zzbax(@Nullable String str) {
        List<String> list;
        if (!isEnabled()) {
            list = new ArrayList<>();
        } else {
            String[] strArr = new String[1];
            String valueOf = String.valueOf(UUID.randomUUID().toString());
            strArr[0] = valueOf.length() != 0 ? "network_request_".concat(valueOf) : new String("network_request_");
            list = Arrays.asList(strArr);
        }
        this.zzedm = list;
    }

    private final void zzb(@Nullable Map<String, ?> map, int i) {
        zza("onNetworkResponse", new zzbba(i, map) { // from class: com.google.android.gms.internal.ads.zzbaz
            private final int zzedo;
            private final Map zzedp;

            {
                this.zzedo = r1;
                this.zzedp = r2;
            }

            @Override // com.google.android.gms.internal.ads.zzbba
            public final void zzb(JsonWriter jsonWriter) {
                zzbax.zza(this.zzedo, this.zzedp, jsonWriter);
            }
        });
    }

    public final void zza(String str, String str2, @Nullable Map<String, ?> map, @Nullable byte[] bArr) {
        if (isEnabled()) {
            zzb(str, str2, map, bArr);
        }
    }

    public final void zza(HttpURLConnection httpURLConnection, int i) {
        if (isEnabled()) {
            String str = null;
            zzb(httpURLConnection.getHeaderFields() == null ? null : new HashMap(httpURLConnection.getHeaderFields()), i);
            if (i < 200 || i >= 300) {
                try {
                    str = httpURLConnection.getResponseMessage();
                } catch (IOException e) {
                    String valueOf = String.valueOf(e.getMessage());
                    zzbbd.zzfe(valueOf.length() != 0 ? "Can not get error message from error HttpURLConnection\n".concat(valueOf) : new String("Can not get error message from error HttpURLConnection\n"));
                }
                zzfa(str);
            }
        }
    }

    public final void zza(@Nullable Map<String, ?> map, int i) {
        if (isEnabled()) {
            zzb(map, i);
            if (i < 200 || i >= 300) {
                zzfa(null);
            }
        }
    }

    private static void zza(JsonWriter jsonWriter, @Nullable Map<String, ?> map) throws IOException {
        if (map != null) {
            jsonWriter.name("headers").beginArray();
            Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, ?> next = it.next();
                String key = next.getKey();
                if (!zzedl.contains(key)) {
                    if (!(next.getValue() instanceof List)) {
                        if (!(next.getValue() instanceof String)) {
                            zzbbd.zzfc("Connection headers should be either Map<String, String> or Map<String, List<String>>");
                            break;
                        }
                        jsonWriter.beginObject();
                        jsonWriter.name("name").value(key);
                        jsonWriter.name("value").value((String) next.getValue());
                        jsonWriter.endObject();
                    } else {
                        for (String str : (List) next.getValue()) {
                            jsonWriter.beginObject();
                            jsonWriter.name("name").value(key);
                            jsonWriter.name("value").value(str);
                            jsonWriter.endObject();
                        }
                    }
                }
            }
            jsonWriter.endArray();
        }
    }

    private final void zza(String str, zzbba zzbba) {
        StringWriter stringWriter = new StringWriter();
        JsonWriter jsonWriter = new JsonWriter(stringWriter);
        try {
            jsonWriter.beginObject();
            jsonWriter.name("timestamp").value(zzbpw.currentTimeMillis());
            jsonWriter.name("event").value(str);
            jsonWriter.name("components").beginArray();
            for (String str2 : this.zzedm) {
                jsonWriter.value(str2);
            }
            jsonWriter.endArray();
            zzbba.zzb(jsonWriter);
            jsonWriter.endObject();
            jsonWriter.flush();
            jsonWriter.close();
        } catch (IOException e) {
            zzbbd.zzc("unable to log", e);
        }
        zzfb(stringWriter.toString());
    }

    public static final /* synthetic */ void zza(String str, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        if (str != null) {
            jsonWriter.name(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION).value(str);
        }
        jsonWriter.endObject();
    }

    public static final /* synthetic */ void zza(byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        int length = bArr.length;
        String encode = Base64Utils.encode(bArr);
        if (length < 10000) {
            jsonWriter.name(SDKConstants.PARAM_A2U_BODY).value(encode);
        } else {
            String zzex = zzbat.zzex(encode);
            if (zzex != null) {
                jsonWriter.name("bodydigest").value(zzex);
            }
        }
        jsonWriter.name("bodylength").value((long) length);
        jsonWriter.endObject();
    }

    public static final /* synthetic */ void zza(int i, Map map, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name("code").value((long) i);
        jsonWriter.endObject();
        zza(jsonWriter, map);
        jsonWriter.endObject();
    }

    public static final /* synthetic */ void zza(String str, String str2, Map map, byte[] bArr, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("params").beginObject();
        jsonWriter.name("firstline").beginObject();
        jsonWriter.name(ShareConstants.MEDIA_URI).value(str);
        jsonWriter.name("verb").value(str2);
        jsonWriter.endObject();
        zza(jsonWriter, map);
        if (bArr != null) {
            jsonWriter.name(SDKConstants.PARAM_A2U_BODY).value(Base64Utils.encode(bArr));
        }
        jsonWriter.endObject();
    }
}

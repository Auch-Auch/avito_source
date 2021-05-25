package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonWriter;
import androidx.annotation.Nullable;
import java.io.IOException;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzdlb implements zzbac {
    @Nullable
    public final String zzdos;
    @Nullable
    public final String zzdou;
    public final JSONObject zzfvr;
    private final JSONObject zzhbg;

    public zzdlb(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        JSONObject zzc = zzbab.zzc(jsonReader);
        this.zzhbg = zzc;
        this.zzdou = zzc.optString("ad_html", null);
        this.zzdos = zzc.optString("ad_base_url", null);
        this.zzfvr = zzc.optJSONObject("ad_json");
    }

    @Override // com.google.android.gms.internal.ads.zzbac
    public final void zza(JsonWriter jsonWriter) throws IOException {
        zzbab.zza(jsonWriter, this.zzhbg);
    }
}

package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.ads.internal.zzp;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
public final class zzczg {
    public final String zzgsb;
    public String zzgsc;
    public Bundle zzgsd = new Bundle();

    public zzczg(JsonReader jsonReader) throws IllegalStateException, IOException, JSONException, NumberFormatException {
        Map<String, String> hashMap = new HashMap<>();
        jsonReader.beginObject();
        String str = "";
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName = nextName == null ? "" : nextName;
            if (nextName.equals("params")) {
                str = jsonReader.nextString();
            } else if (!nextName.equals("signal_dictionary")) {
                jsonReader.skipValue();
            } else {
                hashMap = zzbab.zzb(jsonReader);
            }
        }
        this.zzgsb = str;
        jsonReader.endObject();
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            if (!(entry.getKey() == null || entry.getValue() == null)) {
                this.zzgsd.putString(entry.getKey(), entry.getValue());
            }
        }
    }

    public final zzczg zzo(Bundle bundle) {
        try {
            this.zzgsc = zzp.zzkp().zzd(bundle).toString();
        } catch (JSONException unused) {
            this.zzgsc = "{}";
        }
        return this;
    }
}

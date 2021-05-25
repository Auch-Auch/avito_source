package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;
public abstract class zzaai<T> {
    private final int zzcku;
    private final T zzckv;
    private final String zzcn;

    private zzaai(int i, String str, T t) {
        this.zzcku = i;
        this.zzcn = str;
        this.zzckv = t;
        zzwe.zzpt().zza(this);
    }

    public static zzaai<Boolean> zza(int i, String str, Boolean bool) {
        return new zzaah(i, str, bool);
    }

    public static zzaai<Long> zzb(int i, String str, long j) {
        return new zzaaj(1, str, Long.valueOf(j));
    }

    public final String getKey() {
        return this.zzcn;
    }

    public final int getSource() {
        return this.zzcku;
    }

    public abstract T zza(SharedPreferences sharedPreferences);

    public abstract T zza(Bundle bundle);

    public abstract void zza(SharedPreferences.Editor editor, T t);

    public abstract T zzb(JSONObject jSONObject);

    public final T zzrc() {
        return this.zzckv;
    }

    public static zzaai<Integer> zza(int i, String str, int i2) {
        return new zzaak(1, str, Integer.valueOf(i2));
    }

    public static zzaai<String> zzb(int i, String str) {
        zzaai<String> zza = zza(1, str, (String) null);
        zzwe.zzpt().zzc(zza);
        return zza;
    }

    public static zzaai<Float> zza(int i, String str, float f) {
        return new zzaam(1, str, Float.valueOf(0.0f));
    }

    public static zzaai<String> zza(int i, String str, String str2) {
        return new zzaal(1, str, str2);
    }

    public /* synthetic */ zzaai(int i, String str, Object obj, zzaah zzaah) {
        this(i, str, obj);
    }
}

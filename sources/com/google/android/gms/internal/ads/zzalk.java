package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
public final class zzalk implements zzajs, zzalh {
    private final zzali zzdhm;
    private final HashSet<AbstractMap.SimpleEntry<String, zzahf<? super zzali>>> zzdhn = new HashSet<>();

    public zzalk(zzali zzali) {
        this.zzdhm = zzali;
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void zza(String str, zzahf<? super zzali> zzahf) {
        this.zzdhm.zza(str, zzahf);
        this.zzdhn.add(new AbstractMap.SimpleEntry<>(str, zzahf));
    }

    @Override // com.google.android.gms.internal.ads.zzajk
    public final void zza(String str, Map map) {
        zzajr.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzakh
    public final void zza(String str, JSONObject jSONObject) {
        zzajr.zza(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzali
    public final void zzb(String str, zzahf<? super zzali> zzahf) {
        this.zzdhm.zzb(str, zzahf);
        this.zzdhn.remove(new AbstractMap.SimpleEntry(str, zzahf));
    }

    @Override // com.google.android.gms.internal.ads.zzajs, com.google.android.gms.internal.ads.zzajk
    public final void zzb(String str, JSONObject jSONObject) {
        zzajr.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzajs, com.google.android.gms.internal.ads.zzakh
    public final void zzdc(String str) {
        this.zzdhm.zzdc(str);
    }

    @Override // com.google.android.gms.internal.ads.zzajs
    public final void zzj(String str, String str2) {
        zzajr.zza(this, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzalh
    public final void zztk() {
        Iterator<AbstractMap.SimpleEntry<String, zzahf<? super zzali>>> it = this.zzdhn.iterator();
        while (it.hasNext()) {
            AbstractMap.SimpleEntry<String, zzahf<? super zzali>> next = it.next();
            String valueOf = String.valueOf(next.getValue().toString());
            zzaxy.zzei(valueOf.length() != 0 ? "Unregistering eventhandler: ".concat(valueOf) : new String("Unregistering eventhandler: "));
            this.zzdhm.zzb(next.getKey(), next.getValue());
        }
        this.zzdhn.clear();
    }
}

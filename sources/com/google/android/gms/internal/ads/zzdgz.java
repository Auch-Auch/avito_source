package com.google.android.gms.internal.ads;

import java.util.HashSet;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONObject;
public final class zzdgz implements zzelo<zzdem<JSONObject>> {
    public static zzdem<JSONObject> zza(zzaxc zzaxc, Object obj, zzdfh zzdfh, zzdge zzdge, zzeli<zzdfb> zzeli, zzeli<zzdfl> zzeli2, zzeli<zzdfp> zzeli3, zzeli<zzdfv> zzeli4, zzeli<zzdga> zzeli5, zzeli<zzdgj> zzeli6, zzeli<zzdgn> zzeli7, zzeli<zzdhb> zzeli8, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        HashSet hashSet = new HashSet();
        hashSet.add((zzdfw) obj);
        hashSet.add(zzdfh);
        hashSet.add(zzdge);
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcux)).booleanValue()) {
            hashSet.add(zzeli.get());
        }
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcuy)).booleanValue()) {
            hashSet.add(zzeli2.get());
        }
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcuz)).booleanValue()) {
            hashSet.add(zzeli3.get());
        }
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcva)).booleanValue()) {
            hashSet.add(zzeli4.get());
        }
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcve)).booleanValue()) {
            hashSet.add(new zzdcy(zzeli6.get(), ((Long) zzwe.zzpu().zzd(zzaat.zzcsa)).longValue(), scheduledExecutorService));
        }
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcvg)).booleanValue()) {
            hashSet.add(zzeli7.get());
        }
        if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcvh)).booleanValue()) {
            hashSet.add(zzeli8.get());
        }
        return (zzdem) zzelu.zza(new zzdem(executor, hashSet), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelx
    public final /* synthetic */ Object get() {
        throw new NoSuchMethodError();
    }
}

package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.zzp;
import com.vk.sdk.api.VKApiConst;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
public final class zzcln {
    private final Executor executor;
    private final String packageName;
    private final String zzbra;
    private final String zzcya = zzach.zzczu.get();
    private final zzbbh zzeck;
    private final Map<String, String> zzgff;
    private final boolean zzgfm;
    private final Context zzvr;

    public zzcln(Executor executor2, zzbbh zzbbh, Context context, zzbbg zzbbg) {
        HashMap hashMap = new HashMap();
        this.zzgff = hashMap;
        this.executor = executor2;
        this.zzeck = zzbbh;
        this.zzvr = context;
        String packageName2 = context.getPackageName();
        this.packageName = packageName2;
        this.zzgfm = ((double) zzwe.zzpx().nextFloat()) <= zzach.zzczt.get().doubleValue();
        String str = zzbbg.zzbra;
        this.zzbra = str;
        hashMap.put("s", "gmob_sdk");
        hashMap.put(VKApiConst.VERSION, ExifInterface.GPS_MEASUREMENT_3D);
        hashMap.put("os", Build.VERSION.RELEASE);
        hashMap.put("api_v", Build.VERSION.SDK);
        zzp.zzkp();
        hashMap.put("device", zzayh.zzxp());
        hashMap.put("app", packageName2);
        zzp.zzkp();
        hashMap.put("is_lite_sdk", zzayh.zzaz(context) ? "1" : "0");
        hashMap.put("e", TextUtils.join(",", zzaat.zzre()));
        hashMap.put("sdkVersion", str);
    }

    public final Map<String, String> zzaos() {
        return new HashMap(this.zzgff);
    }

    public final ConcurrentHashMap<String, String> zzaot() {
        return new ConcurrentHashMap<>(this.zzgff);
    }

    public final /* synthetic */ void zzgi(String str) {
        this.zzeck.zzes(str);
    }

    public final void zzn(Map<String, String> map) {
        Uri.Builder buildUpon = Uri.parse(this.zzcya).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        String uri = buildUpon.build().toString();
        if (this.zzgfm) {
            this.executor.execute(new Runnable(this, uri) { // from class: com.google.android.gms.internal.ads.zzclq
                private final String zzdft;
                private final zzcln zzgfp;

                {
                    this.zzgfp = r1;
                    this.zzdft = r2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.zzgfp.zzgi(this.zzdft);
                }
            });
        }
        zzaxy.zzei(uri);
    }
}

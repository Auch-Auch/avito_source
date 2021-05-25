package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
public final class zzbae {
    private Map<Integer, Bitmap> zzecg = new ConcurrentHashMap();
    private AtomicInteger zzech = new AtomicInteger(0);

    public final Bitmap zza(Integer num) {
        return this.zzecg.get(num);
    }
}

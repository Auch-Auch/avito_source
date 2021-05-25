package com.bumptech.glide.load.engine.prefill;

import a2.d.a.d.b.w.a;
import a2.d.a.d.b.w.b;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.PreFillType;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
public final class BitmapPreFiller {
    public final MemoryCache a;
    public final BitmapPool b;
    public final DecodeFormat c;
    public final Handler d = new Handler(Looper.getMainLooper());
    public a e;

    public BitmapPreFiller(MemoryCache memoryCache, BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this.a = memoryCache;
        this.b = bitmapPool;
        this.c = decodeFormat;
    }

    public void preFill(PreFillType.Builder... builderArr) {
        Bitmap.Config config;
        a aVar = this.e;
        if (aVar != null) {
            aVar.h = true;
        }
        int length = builderArr.length;
        PreFillType[] preFillTypeArr = new PreFillType[length];
        for (int i = 0; i < builderArr.length; i++) {
            PreFillType.Builder builder = builderArr[i];
            if (builder.c == null) {
                if (this.c == DecodeFormat.PREFER_ARGB_8888) {
                    config = Bitmap.Config.ARGB_8888;
                } else {
                    config = Bitmap.Config.RGB_565;
                }
                builder.setConfig(config);
            }
            preFillTypeArr[i] = new PreFillType(builder.a, builder.b, builder.c, builder.d);
        }
        long maxSize = this.b.getMaxSize() + (this.a.getMaxSize() - this.a.getCurrentSize());
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            i2 += preFillTypeArr[i3].d;
        }
        float f = ((float) maxSize) / ((float) i2);
        HashMap hashMap = new HashMap();
        for (int i4 = 0; i4 < length; i4++) {
            PreFillType preFillType = preFillTypeArr[i4];
            hashMap.put(preFillType, Integer.valueOf(Math.round(((float) preFillType.d) * f) / Util.getBitmapByteSize(preFillType.a, preFillType.b, preFillType.c)));
        }
        a aVar2 = new a(this.b, this.a, new b(hashMap));
        this.e = aVar2;
        this.d.post(aVar2);
    }
}

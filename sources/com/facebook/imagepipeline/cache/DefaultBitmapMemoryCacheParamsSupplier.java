package com.facebook.imagepipeline.cache;

import android.app.ActivityManager;
import com.facebook.common.internal.Supplier;
import java.util.concurrent.TimeUnit;
public class DefaultBitmapMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {
    public static final long b = TimeUnit.MINUTES.toMillis(5);
    public final ActivityManager a;

    public DefaultBitmapMemoryCacheParamsSupplier(ActivityManager activityManager) {
        this.a = activityManager;
    }

    @Override // com.facebook.common.internal.Supplier
    public MemoryCacheParams get() {
        int min = Math.min(this.a.getMemoryClass() * 1048576, Integer.MAX_VALUE);
        return new MemoryCacheParams(min < 33554432 ? 4194304 : min < 67108864 ? 6291456 : min / 4, 256, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, b);
    }
}

package com.avito.android.delivery.utils;

import kotlin.Metadata;
import kotlin.jvm.JvmName;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u001a\u001d\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"", "lat", "", "zoom", "metersPerPx", "(DF)F", "delivery_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "Map")
public final class Map {
    public static final float metersPerPx(double d, float f) {
        return (float) ((Math.cos((d * 3.141592653589793d) / ((double) 180)) * 156543.03392d) / Math.pow(2.0d, (double) f));
    }
}

package com.avito.android.avito_map;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/avito/android/avito_map/AvitoMapZoomLevel;", "", "", AuthSource.SEND_ABUSE, "F", "getMinValue", "()F", "minValue", AuthSource.BOOKING_ORDER, "getMaxValue", "maxValue", "<init>", "(FF)V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoMapZoomLevel {
    public final float a;
    public final float b;

    public AvitoMapZoomLevel(float f, float f2) {
        this.a = f;
        this.b = f2;
    }

    public final float getMaxValue() {
        return this.b;
    }

    public final float getMinValue() {
        return this.a;
    }
}

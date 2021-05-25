package com.avito.android.delivery.map.common;

import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B5\u0012\b\b\u0002\u0010\r\u001a\u00020\b\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b\u001a\u0010\u001bR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0019\u001a\u0004\u0018\u00010\u00148\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/avito/android/delivery/map/common/CameraUpdateEvent;", "", "Lcom/avito/android/avito_map/AvitoMapPoint;", "c", "Lcom/avito/android/avito_map/AvitoMapPoint;", "getPoint", "()Lcom/avito/android/avito_map/AvitoMapPoint;", "point", "", AuthSource.SEND_ABUSE, "Z", "getAnimate", "()Z", "animate", "Lcom/avito/android/avito_map/AvitoMapBounds;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/avito_map/AvitoMapBounds;", "getBounds", "()Lcom/avito/android/avito_map/AvitoMapBounds;", "bounds", "", "d", "Ljava/lang/Float;", "getZoomLevel", "()Ljava/lang/Float;", "zoomLevel", "<init>", "(ZLcom/avito/android/avito_map/AvitoMapBounds;Lcom/avito/android/avito_map/AvitoMapPoint;Ljava/lang/Float;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class CameraUpdateEvent {
    public final boolean a;
    @Nullable
    public final AvitoMapBounds b;
    @Nullable
    public final AvitoMapPoint c;
    @Nullable
    public final Float d;

    public CameraUpdateEvent() {
        this(false, null, null, null, 15, null);
    }

    public CameraUpdateEvent(boolean z, @Nullable AvitoMapBounds avitoMapBounds, @Nullable AvitoMapPoint avitoMapPoint, @Nullable Float f) {
        this.a = z;
        this.b = avitoMapBounds;
        this.c = avitoMapPoint;
        this.d = f;
    }

    public final boolean getAnimate() {
        return this.a;
    }

    @Nullable
    public final AvitoMapBounds getBounds() {
        return this.b;
    }

    @Nullable
    public final AvitoMapPoint getPoint() {
        return this.c;
    }

    @Nullable
    public final Float getZoomLevel() {
        return this.d;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CameraUpdateEvent(boolean z, AvitoMapBounds avitoMapBounds, AvitoMapPoint avitoMapPoint, Float f, int i, j jVar) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : avitoMapBounds, (i & 4) != 0 ? null : avitoMapPoint, (i & 8) != 0 ? null : f);
    }
}

package com.avito.android.delivery.map.common;

import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u001c\u001a\u00020\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u001c\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010!\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/delivery/map/common/CameraCoordinatesEvent;", "", "Lcom/avito/android/avito_map/AvitoMapPoint;", "c", "Lcom/avito/android/avito_map/AvitoMapPoint;", "getTopLeft", "()Lcom/avito/android/avito_map/AvitoMapPoint;", "topLeft", "", "f", "Ljava/lang/Float;", "getClusterRadius", "()Ljava/lang/Float;", "clusterRadius", "d", "getBottomRight", "bottomRight", "Lcom/avito/android/avito_map/AvitoMapBounds;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/avito_map/AvitoMapBounds;", "getProjection", "()Lcom/avito/android/avito_map/AvitoMapBounds;", "projection", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", AuthSource.SEND_ABUSE, "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "getCameraPosition", "()Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "cameraPosition", "e", "F", "getRadius", "()F", "radius", "<init>", "(Lcom/avito/android/avito_map/AvitoMapCameraPosition;Lcom/avito/android/avito_map/AvitoMapBounds;Lcom/avito/android/avito_map/AvitoMapPoint;Lcom/avito/android/avito_map/AvitoMapPoint;FLjava/lang/Float;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class CameraCoordinatesEvent {
    @NotNull
    public final AvitoMapCameraPosition a;
    @NotNull
    public final AvitoMapBounds b;
    @NotNull
    public final AvitoMapPoint c;
    @NotNull
    public final AvitoMapPoint d;
    public final float e;
    @Nullable
    public final Float f;

    public CameraCoordinatesEvent(@NotNull AvitoMapCameraPosition avitoMapCameraPosition, @NotNull AvitoMapBounds avitoMapBounds, @NotNull AvitoMapPoint avitoMapPoint, @NotNull AvitoMapPoint avitoMapPoint2, float f2, @Nullable Float f3) {
        Intrinsics.checkNotNullParameter(avitoMapCameraPosition, "cameraPosition");
        Intrinsics.checkNotNullParameter(avitoMapBounds, "projection");
        Intrinsics.checkNotNullParameter(avitoMapPoint, "topLeft");
        Intrinsics.checkNotNullParameter(avitoMapPoint2, "bottomRight");
        this.a = avitoMapCameraPosition;
        this.b = avitoMapBounds;
        this.c = avitoMapPoint;
        this.d = avitoMapPoint2;
        this.e = f2;
        this.f = f3;
    }

    @NotNull
    public final AvitoMapPoint getBottomRight() {
        return this.d;
    }

    @NotNull
    public final AvitoMapCameraPosition getCameraPosition() {
        return this.a;
    }

    @Nullable
    public final Float getClusterRadius() {
        return this.f;
    }

    @NotNull
    public final AvitoMapBounds getProjection() {
        return this.b;
    }

    public final float getRadius() {
        return this.e;
    }

    @NotNull
    public final AvitoMapPoint getTopLeft() {
        return this.c;
    }
}

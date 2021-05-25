package com.avito.android.avito_map;

import a2.g.r.g;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0006\n\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0019\u001a\u00020\u0006\u0012\u0006\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b \u0010!J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0011\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u000eR\u0019\u0010\u0019\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u000e\u001a\u0004\b\u0018\u0010\u0010R\u0016\u0010\u001b\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0014R\u0016\u0010\u001d\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u0014R\u0016\u0010\u001f\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u0014¨\u0006\""}, d2 = {"Lcom/avito/android/avito_map/AvitoMapBoundsBuilder;", "", "Lcom/avito/android/avito_map/AvitoMapPoint;", "point", "addPoint", "(Lcom/avito/android/avito_map/AvitoMapPoint;)Lcom/avito/android/avito_map/AvitoMapBoundsBuilder;", "", "offset", "addOffset", "(I)Lcom/avito/android/avito_map/AvitoMapBoundsBuilder;", "Lcom/avito/android/avito_map/AvitoMapBounds;", "build", "()Lcom/avito/android/avito_map/AvitoMapBounds;", g.a, "I", "getHeight", "()I", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "", AuthSource.SEND_ABUSE, "D", "maxLat", "e", "f", "getWidth", ViewHierarchyConstants.DIMENSION_WIDTH_KEY, "c", "minLat", AuthSource.BOOKING_ORDER, "maxLng", "d", "minLng", "<init>", "(II)V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoMapBoundsBuilder {
    public double a = -90.0d;
    public double b = -180.0d;
    public double c = 90.0d;
    public double d = 180.0d;
    public int e = 30;
    public final int f;
    public final int g;

    public AvitoMapBoundsBuilder(int i, int i2) {
        this.f = i;
        this.g = i2;
    }

    @NotNull
    public final AvitoMapBoundsBuilder addOffset(int i) {
        this.e = i;
        return this;
    }

    @NotNull
    public final AvitoMapBoundsBuilder addPoint(@NotNull AvitoMapPoint avitoMapPoint) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "point");
        if (this.c > avitoMapPoint.getLatitude()) {
            this.c = avitoMapPoint.getLatitude();
        }
        if (this.d > avitoMapPoint.getLongitude()) {
            this.d = avitoMapPoint.getLongitude();
        }
        if (this.a < avitoMapPoint.getLatitude()) {
            this.a = avitoMapPoint.getLatitude();
        }
        if (this.b < avitoMapPoint.getLongitude()) {
            this.b = avitoMapPoint.getLongitude();
        }
        return this;
    }

    @Nullable
    public final AvitoMapBounds build() {
        int i;
        double d2 = this.a;
        double d3 = this.c;
        double d4 = d2 - d3;
        double d5 = this.b;
        double d6 = this.d;
        double d7 = d5 - d6;
        int i2 = this.f;
        if (i2 == 0 || (i = this.g) == 0) {
            return null;
        }
        int i3 = this.e;
        double d8 = d4 * ((double) (((float) i3) / ((float) i)));
        this.c = d3 - d8;
        this.a = d2 + d8;
        double d9 = d7 * ((double) (((float) i3) / ((float) i2)));
        this.d = d6 - d9;
        this.b = d5 + d9;
        return new AvitoMapBounds(new AvitoMapPoint(this.a, this.d), new AvitoMapPoint(this.c, this.b));
    }

    public final int getHeight() {
        return this.g;
    }

    public final int getWidth() {
        return this.f;
    }
}

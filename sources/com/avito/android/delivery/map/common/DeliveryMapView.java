package com.avito.android.delivery.map.common;

import a2.b.a.a.a;
import android.graphics.Point;
import androidx.lifecycle.LiveData;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.remote.auth.AuthSource;
import com.bumptech.glide.Registry;
import io.reactivex.rxjava3.core.Observable;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0002,-J\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H&¢\u0006\u0004\b\u000b\u0010\tJ\u000f\u0010\f\u001a\u00020\u0007H&¢\u0006\u0004\b\f\u0010\tJ\u000f\u0010\r\u001a\u00020\u0007H&¢\u0006\u0004\b\r\u0010\tJ\u0017\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u00198&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001d0\u00198&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001bR\u001c\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u0018\u0010(\u001a\u0004\u0018\u00010%8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u001c\u0010+\u001a\b\u0012\u0004\u0012\u00020)0\u00198&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b*\u0010\u001b¨\u0006."}, d2 = {"Lcom/avito/android/delivery/map/common/DeliveryMapView;", "", "Landroid/graphics/Point;", "point", "Lcom/avito/android/avito_map/AvitoMapPoint;", "fromScreenLocation", "(Landroid/graphics/Point;)Lcom/avito/android/avito_map/AvitoMapPoint;", "", "initPlatformMap", "()V", "onMapResume", "onMapPause", "onMapDestroy", "onMapLowMemory", "Lcom/avito/android/delivery/map/common/DeliveryMapView$State;", "state", "render", "(Lcom/avito/android/delivery/map/common/DeliveryMapView$State;)V", "getCenter", "()Lcom/avito/android/avito_map/AvitoMapPoint;", "center", "", "getMapViewHeight", "()I", "mapViewHeight", "Lio/reactivex/rxjava3/core/Observable;", "getFindMeClicks", "()Lio/reactivex/rxjava3/core/Observable;", "findMeClicks", "", "getMarkersClicks", "markersClicks", "Landroidx/lifecycle/LiveData;", "", "getMapIsReadyChanges", "()Landroidx/lifecycle/LiveData;", "mapIsReadyChanges", "Lcom/avito/android/avito_map/AvitoMapBounds;", "getVisibleRegion", "()Lcom/avito/android/avito_map/AvitoMapBounds;", "visibleRegion", "Lcom/avito/android/delivery/map/common/CameraCoordinatesEvent;", "getCameraCoordinatesObservable", "cameraCoordinatesObservable", "Marker", "State", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface DeliveryMapView {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u00002\u00020\u0001:\u00012B/\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0006\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\u0006\u0010\u0016\u001a\u00020\u000f¢\u0006\u0004\b0\u00101J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JB\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\t2\b\b\u0002\u0010\u0015\u001a\u00020\f2\b\b\u0002\u0010\u0016\u001a\u00020\u000fHÆ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0004J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u001f\u001a\u00020\u001e2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001f\u0010 R\u0019\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010\u0011R\u0019\u0010\u0012\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010\u0004R\u0019\u0010\u0013\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b)\u0010\bR\u0019\u0010\u0015\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b,\u0010\u000eR\u0019\u0010\u0014\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b/\u0010\u000b¨\u00063"}, d2 = {"Lcom/avito/android/delivery/map/common/DeliveryMapView$Marker;", "", "", "getMapIconUniqueId", "()Ljava/lang/String;", "component1", "Lcom/avito/android/avito_map/AvitoMapPoint;", "component2", "()Lcom/avito/android/avito_map/AvitoMapPoint;", "Lcom/avito/android/delivery/map/common/DeliveryMapView$Marker$Bitmap;", "component3", "()Lcom/avito/android/delivery/map/common/DeliveryMapView$Marker$Bitmap;", "Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "component4", "()Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "", "component5", "()F", "id", "latLng", "bitmap", "anchor", "zIndex", "copy", "(Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapPoint;Lcom/avito/android/delivery/map/common/DeliveryMapView$Marker$Bitmap;Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;F)Lcom/avito/android/delivery/map/common/DeliveryMapView$Marker;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "e", "F", "getZIndex", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getId", AuthSource.BOOKING_ORDER, "Lcom/avito/android/avito_map/AvitoMapPoint;", "getLatLng", "d", "Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "getAnchor", "c", "Lcom/avito/android/delivery/map/common/DeliveryMapView$Marker$Bitmap;", "getBitmap", "<init>", "(Ljava/lang/String;Lcom/avito/android/avito_map/AvitoMapPoint;Lcom/avito/android/delivery/map/common/DeliveryMapView$Marker$Bitmap;Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;F)V", Registry.BUCKET_BITMAP, "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Marker {
        @NotNull
        public final String a;
        @NotNull
        public final AvitoMapPoint b;
        @NotNull
        public final Bitmap c;
        @NotNull
        public final AvitoMapMarker.Anchor d;
        public final float e;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0016\u001a\u00020\u0011\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u0017¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\r\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0016\u001a\u00020\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u001e\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/delivery/map/common/DeliveryMapView$Marker$Bitmap;", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", AuthSource.BOOKING_ORDER, "Z", "getHasLabel", "()Z", "hasLabel", "c", "getSelected", "selected", "Landroid/graphics/Bitmap;", AuthSource.SEND_ABUSE, "Landroid/graphics/Bitmap;", "getValue", "()Landroid/graphics/Bitmap;", "value", "", "d", "Ljava/lang/String;", "getMapIconUniqueId", "()Ljava/lang/String;", "setMapIconUniqueId", "(Ljava/lang/String;)V", "mapIconUniqueId", "<init>", "(Landroid/graphics/Bitmap;ZZLjava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
        public static final class Bitmap {
            @NotNull
            public final android.graphics.Bitmap a;
            public final boolean b;
            public final boolean c;
            @NotNull
            public String d;

            public Bitmap(@NotNull android.graphics.Bitmap bitmap, boolean z, boolean z2, @NotNull String str) {
                Intrinsics.checkNotNullParameter(bitmap, "value");
                Intrinsics.checkNotNullParameter(str, "mapIconUniqueId");
                this.a = bitmap;
                this.b = z;
                this.c = z2;
                this.d = str;
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof Bitmap)) {
                    return false;
                }
                Bitmap bitmap = (Bitmap) obj;
                if (this.b == bitmap.b && this.c == bitmap.c) {
                    return true;
                }
                return false;
            }

            public final boolean getHasLabel() {
                return this.b;
            }

            @NotNull
            public final String getMapIconUniqueId() {
                return this.d;
            }

            public final boolean getSelected() {
                return this.c;
            }

            @NotNull
            public final android.graphics.Bitmap getValue() {
                return this.a;
            }

            public int hashCode() {
                return (a.a(this.b) * 31) + a.a(this.c);
            }

            public final void setMapIconUniqueId(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.d = str;
            }

            /* JADX INFO: this call moved to the top of the method (can break code semantics) */
            public /* synthetic */ Bitmap(android.graphics.Bitmap bitmap, boolean z, boolean z2, String str, int i, j jVar) {
                this(bitmap, (i & 2) != 0 ? false : z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? "" : str);
            }
        }

        public Marker(@NotNull String str, @NotNull AvitoMapPoint avitoMapPoint, @NotNull Bitmap bitmap, @NotNull AvitoMapMarker.Anchor anchor, float f) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(avitoMapPoint, "latLng");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Intrinsics.checkNotNullParameter(anchor, "anchor");
            this.a = str;
            this.b = avitoMapPoint;
            this.c = bitmap;
            this.d = anchor;
            this.e = f;
        }

        public static /* synthetic */ Marker copy$default(Marker marker, String str, AvitoMapPoint avitoMapPoint, Bitmap bitmap, AvitoMapMarker.Anchor anchor, float f, int i, Object obj) {
            if ((i & 1) != 0) {
                str = marker.a;
            }
            if ((i & 2) != 0) {
                avitoMapPoint = marker.b;
            }
            if ((i & 4) != 0) {
                bitmap = marker.c;
            }
            if ((i & 8) != 0) {
                anchor = marker.d;
            }
            if ((i & 16) != 0) {
                f = marker.e;
            }
            return marker.copy(str, avitoMapPoint, bitmap, anchor, f);
        }

        @NotNull
        public final String component1() {
            return this.a;
        }

        @NotNull
        public final AvitoMapPoint component2() {
            return this.b;
        }

        @NotNull
        public final Bitmap component3() {
            return this.c;
        }

        @NotNull
        public final AvitoMapMarker.Anchor component4() {
            return this.d;
        }

        public final float component5() {
            return this.e;
        }

        @NotNull
        public final Marker copy(@NotNull String str, @NotNull AvitoMapPoint avitoMapPoint, @NotNull Bitmap bitmap, @NotNull AvitoMapMarker.Anchor anchor, float f) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(avitoMapPoint, "latLng");
            Intrinsics.checkNotNullParameter(bitmap, "bitmap");
            Intrinsics.checkNotNullParameter(anchor, "anchor");
            return new Marker(str, avitoMapPoint, bitmap, anchor, f);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Marker)) {
                return false;
            }
            Marker marker = (Marker) obj;
            return Intrinsics.areEqual(this.a, marker.a) && Intrinsics.areEqual(this.b, marker.b) && Intrinsics.areEqual(this.c, marker.c) && Intrinsics.areEqual(this.d, marker.d) && Float.compare(this.e, marker.e) == 0;
        }

        @NotNull
        public final AvitoMapMarker.Anchor getAnchor() {
            return this.d;
        }

        @NotNull
        public final Bitmap getBitmap() {
            return this.c;
        }

        @NotNull
        public final String getId() {
            return this.a;
        }

        @NotNull
        public final AvitoMapPoint getLatLng() {
            return this.b;
        }

        @NotNull
        public final String getMapIconUniqueId() {
            return this.c.getMapIconUniqueId();
        }

        public final float getZIndex() {
            return this.e;
        }

        public int hashCode() {
            String str = this.a;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            AvitoMapPoint avitoMapPoint = this.b;
            int hashCode2 = (hashCode + (avitoMapPoint != null ? avitoMapPoint.hashCode() : 0)) * 31;
            Bitmap bitmap = this.c;
            int hashCode3 = (hashCode2 + (bitmap != null ? bitmap.hashCode() : 0)) * 31;
            AvitoMapMarker.Anchor anchor = this.d;
            if (anchor != null) {
                i = anchor.hashCode();
            }
            return Float.floatToIntBits(this.e) + ((hashCode3 + i) * 31);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Marker(id=");
            L.append(this.a);
            L.append(", latLng=");
            L.append(this.b);
            L.append(", bitmap=");
            L.append(this.c);
            L.append(", anchor=");
            L.append(this.d);
            L.append(", zIndex=");
            L.append(this.e);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\b\b\u0018\u00002\u00020\u0001B+\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b#\u0010$J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0018\u001a\u00020\t2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\u001b\u0010\r\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u000bR\u001f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0005¨\u0006%"}, d2 = {"Lcom/avito/android/delivery/map/common/DeliveryMapView$State;", "", "", "Lcom/avito/android/delivery/map/common/DeliveryMapView$Marker;", "component1", "()Ljava/util/Set;", "Lcom/avito/android/delivery/map/common/CameraUpdateEvent;", "component2", "()Lcom/avito/android/delivery/map/common/CameraUpdateEvent;", "", "component3", "()Ljava/lang/Boolean;", ScreenPublicConstsKt.CONTENT_TYPE_MARKERS, "camera", "showProgress", "copy", "(Ljava/util/Set;Lcom/avito/android/delivery/map/common/CameraUpdateEvent;Ljava/lang/Boolean;)Lcom/avito/android/delivery/map/common/DeliveryMapView$State;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Lcom/avito/android/delivery/map/common/CameraUpdateEvent;", "getCamera", "c", "Ljava/lang/Boolean;", "getShowProgress", AuthSource.SEND_ABUSE, "Ljava/util/Set;", "getMarkers", "<init>", "(Ljava/util/Set;Lcom/avito/android/delivery/map/common/CameraUpdateEvent;Ljava/lang/Boolean;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class State {
        @NotNull
        public final Set<Marker> a;
        @Nullable
        public final CameraUpdateEvent b;
        @Nullable
        public final Boolean c;

        public State(@NotNull Set<Marker> set, @Nullable CameraUpdateEvent cameraUpdateEvent, @Nullable Boolean bool) {
            Intrinsics.checkNotNullParameter(set, ScreenPublicConstsKt.CONTENT_TYPE_MARKERS);
            this.a = set;
            this.b = cameraUpdateEvent;
            this.c = bool;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.delivery.map.common.DeliveryMapView$State */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ State copy$default(State state, Set set, CameraUpdateEvent cameraUpdateEvent, Boolean bool, int i, Object obj) {
            if ((i & 1) != 0) {
                set = state.a;
            }
            if ((i & 2) != 0) {
                cameraUpdateEvent = state.b;
            }
            if ((i & 4) != 0) {
                bool = state.c;
            }
            return state.copy(set, cameraUpdateEvent, bool);
        }

        @NotNull
        public final Set<Marker> component1() {
            return this.a;
        }

        @Nullable
        public final CameraUpdateEvent component2() {
            return this.b;
        }

        @Nullable
        public final Boolean component3() {
            return this.c;
        }

        @NotNull
        public final State copy(@NotNull Set<Marker> set, @Nullable CameraUpdateEvent cameraUpdateEvent, @Nullable Boolean bool) {
            Intrinsics.checkNotNullParameter(set, ScreenPublicConstsKt.CONTENT_TYPE_MARKERS);
            return new State(set, cameraUpdateEvent, bool);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof State)) {
                return false;
            }
            State state = (State) obj;
            return Intrinsics.areEqual(this.a, state.a) && Intrinsics.areEqual(this.b, state.b) && Intrinsics.areEqual(this.c, state.c);
        }

        @Nullable
        public final CameraUpdateEvent getCamera() {
            return this.b;
        }

        @NotNull
        public final Set<Marker> getMarkers() {
            return this.a;
        }

        @Nullable
        public final Boolean getShowProgress() {
            return this.c;
        }

        public int hashCode() {
            Set<Marker> set = this.a;
            int i = 0;
            int hashCode = (set != null ? set.hashCode() : 0) * 31;
            CameraUpdateEvent cameraUpdateEvent = this.b;
            int hashCode2 = (hashCode + (cameraUpdateEvent != null ? cameraUpdateEvent.hashCode() : 0)) * 31;
            Boolean bool = this.c;
            if (bool != null) {
                i = bool.hashCode();
            }
            return hashCode2 + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("State(markers=");
            L.append(this.a);
            L.append(", camera=");
            L.append(this.b);
            L.append(", showProgress=");
            return a.o(L, this.c, ")");
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ State(Set set, CameraUpdateEvent cameraUpdateEvent, Boolean bool, int i, j jVar) {
            this(set, cameraUpdateEvent, (i & 4) != 0 ? null : bool);
        }
    }

    @Nullable
    AvitoMapPoint fromScreenLocation(@NotNull Point point);

    @NotNull
    Observable<CameraCoordinatesEvent> getCameraCoordinatesObservable();

    @Nullable
    AvitoMapPoint getCenter();

    @NotNull
    Observable<Unit> getFindMeClicks();

    @NotNull
    LiveData<Boolean> getMapIsReadyChanges();

    int getMapViewHeight();

    @NotNull
    Observable<String> getMarkersClicks();

    @Nullable
    AvitoMapBounds getVisibleRegion();

    void initPlatformMap();

    void onMapDestroy();

    void onMapLowMemory();

    void onMapPause();

    void onMapResume();

    void render(@NotNull State state);
}

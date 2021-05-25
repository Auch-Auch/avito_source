package com.avito.android.avito_map.yandex;

import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapPoint;
import com.yandex.mapkit.geometry.BoundingBox;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.VisibleRegion;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u001a\u0011\u0010\u0002\u001a\u00020\u0001*\u00020\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u0011\u0010\u0004\u001a\u00020\u0000*\u00020\u0001¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u0011\u0010\b\u001a\u00020\u0007*\u00020\u0006¢\u0006\u0004\b\b\u0010\t\u001a\u0011\u0010\f\u001a\u00020\u000b*\u00020\n¢\u0006\u0004\b\f\u0010\r\u001a\u0011\u0010\u000f\u001a\u00020\u0006*\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010\u001a\u0011\u0010\u0013\u001a\u00020\u0012*\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014\"\u0016\u0010\u0016\u001a\u00020\u00158\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017\"\u0016\u0010\u0018\u001a\u00020\u00128\u0000@\u0000XT¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001a"}, d2 = {"Lcom/avito/android/avito_map/AvitoMapPoint;", "Lcom/yandex/mapkit/geometry/Point;", "toPoint", "(Lcom/avito/android/avito_map/AvitoMapPoint;)Lcom/yandex/mapkit/geometry/Point;", "toAvitoMapPoint", "(Lcom/yandex/mapkit/geometry/Point;)Lcom/avito/android/avito_map/AvitoMapPoint;", "Lcom/avito/android/avito_map/AvitoMapBounds;", "Lcom/yandex/mapkit/geometry/BoundingBox;", "toBoundingBox", "(Lcom/avito/android/avito_map/AvitoMapBounds;)Lcom/yandex/mapkit/geometry/BoundingBox;", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "Lcom/yandex/mapkit/map/CameraPosition;", "toYandexCameraPosition", "(Lcom/avito/android/avito_map/AvitoMapCameraPosition;)Lcom/yandex/mapkit/map/CameraPosition;", "Lcom/yandex/mapkit/map/VisibleRegion;", "toAvitoMapBounds", "(Lcom/yandex/mapkit/map/VisibleRegion;)Lcom/avito/android/avito_map/AvitoMapBounds;", "Lcom/avito/android/avito_map/AvitoMap$AnimationLength;", "", "toYandexMapAnimationLength", "(Lcom/avito/android/avito_map/AvitoMap$AnimationLength;)F", "", "YANDEX_MAP_API_KEY", "Ljava/lang/String;", "NO_ANIMATION", "F", "avito-map_release"}, k = 2, mv = {1, 4, 2})
public final class AvitoYandexMapKt {
    public static final float NO_ANIMATION = 0.0f;
    @NotNull
    public static final String YANDEX_MAP_API_KEY = "ccfa5968-83db-4864-b661-2717d7e7225d";

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            AvitoMap.AnimationLength.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[1] = 1;
            iArr[0] = 2;
            iArr[2] = 3;
        }
    }

    @NotNull
    public static final AvitoMapBounds toAvitoMapBounds(@NotNull VisibleRegion visibleRegion) {
        Intrinsics.checkNotNullParameter(visibleRegion, "$this$toAvitoMapBounds");
        Point topLeft = visibleRegion.getTopLeft();
        Intrinsics.checkNotNullExpressionValue(topLeft, "this.topLeft");
        double latitude = topLeft.getLatitude();
        Point topLeft2 = visibleRegion.getTopLeft();
        Intrinsics.checkNotNullExpressionValue(topLeft2, "this.topLeft");
        AvitoMapPoint avitoMapPoint = new AvitoMapPoint(latitude, topLeft2.getLongitude());
        Point bottomRight = visibleRegion.getBottomRight();
        Intrinsics.checkNotNullExpressionValue(bottomRight, "this.bottomRight");
        double latitude2 = bottomRight.getLatitude();
        Point bottomRight2 = visibleRegion.getBottomRight();
        Intrinsics.checkNotNullExpressionValue(bottomRight2, "this.bottomRight");
        return new AvitoMapBounds(avitoMapPoint, new AvitoMapPoint(latitude2, bottomRight2.getLongitude()));
    }

    @NotNull
    public static final AvitoMapPoint toAvitoMapPoint(@NotNull Point point) {
        Intrinsics.checkNotNullParameter(point, "$this$toAvitoMapPoint");
        return new AvitoMapPoint(point.getLatitude(), point.getLongitude());
    }

    @NotNull
    public static final BoundingBox toBoundingBox(@NotNull AvitoMapBounds avitoMapBounds) {
        Intrinsics.checkNotNullParameter(avitoMapBounds, "$this$toBoundingBox");
        return new BoundingBox(new Point(avitoMapBounds.getBottomRight().getLatitude(), avitoMapBounds.getTopLeft().getLongitude()), new Point(avitoMapBounds.getTopLeft().getLatitude(), avitoMapBounds.getBottomRight().getLongitude()));
    }

    @NotNull
    public static final Point toPoint(@NotNull AvitoMapPoint avitoMapPoint) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "$this$toPoint");
        return new Point(avitoMapPoint.getLatitude(), avitoMapPoint.getLongitude());
    }

    @NotNull
    public static final CameraPosition toYandexCameraPosition(@NotNull AvitoMapCameraPosition avitoMapCameraPosition) {
        Intrinsics.checkNotNullParameter(avitoMapCameraPosition, "$this$toYandexCameraPosition");
        Point point = toPoint(avitoMapCameraPosition.getMapPoint());
        float zoomLevel = avitoMapCameraPosition.getZoomLevel();
        float tilt = avitoMapCameraPosition.getTilt();
        Float azimuth = avitoMapCameraPosition.getAzimuth();
        return new CameraPosition(point, zoomLevel, tilt, azimuth != null ? azimuth.floatValue() : 0.0f);
    }

    public static final float toYandexMapAnimationLength(@NotNull AvitoMap.AnimationLength animationLength) {
        Intrinsics.checkNotNullParameter(animationLength, "$this$toYandexMapAnimationLength");
        int ordinal = animationLength.ordinal();
        if (ordinal == 0) {
            return 0.15f;
        }
        if (ordinal == 1) {
            return 0.5f;
        }
        if (ordinal == 2) {
            return 1.0f;
        }
        throw new NoWhenBranchMatchedException();
    }
}

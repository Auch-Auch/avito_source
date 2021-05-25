package com.avito.android.avito_map.yandex;

import android.graphics.Bitmap;
import android.graphics.PointF;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.IconStyle;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.runtime.image.ImageProvider;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010'\u001a\u00020\"¢\u0006\u0004\b(\u0010)J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J/\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0005\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0011\u0010\u001a\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001cH\u0016¢\u0006\u0004\b \u0010!R\u0019\u0010'\u001a\u00020\"8\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/avito_map/yandex/YandexAvitoMapMarker;", "Lcom/avito/android/avito_map/AvitoMapMarker;", "Landroid/graphics/Bitmap;", "icon", "", "changeIcon", "(Landroid/graphics/Bitmap;)V", "", "imageId", "", "zIndex", "Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "anchor", "(Landroid/graphics/Bitmap;Ljava/lang/String;FLcom/avito/android/avito_map/AvitoMapMarker$Anchor;)V", "", "visible", "setVisibility", "(Z)V", "isVisible", "()Z", "setZIndex", "(F)V", "", "data", "setData", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "getPosition", "()Lcom/avito/android/avito_map/AvitoMapPoint;", VKApiConst.POSITION, "setPosition", "(Lcom/avito/android/avito_map/AvitoMapPoint;)V", "Lcom/yandex/mapkit/map/PlacemarkMapObject;", AuthSource.SEND_ABUSE, "Lcom/yandex/mapkit/map/PlacemarkMapObject;", "getPlaceMark", "()Lcom/yandex/mapkit/map/PlacemarkMapObject;", "placeMark", "<init>", "(Lcom/yandex/mapkit/map/PlacemarkMapObject;)V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public final class YandexAvitoMapMarker implements AvitoMapMarker {
    @NotNull
    public final PlacemarkMapObject a;

    public YandexAvitoMapMarker(@NotNull PlacemarkMapObject placemarkMapObject) {
        Intrinsics.checkNotNullParameter(placemarkMapObject, "placeMark");
        this.a = placemarkMapObject;
    }

    @Override // com.avito.android.avito_map.AvitoMapMarker
    public void changeIcon(@Nullable Bitmap bitmap) {
        this.a.setIcon(ImageProvider.fromBitmap(bitmap));
    }

    @Override // com.avito.android.avito_map.AvitoMapMarker
    @Nullable
    public Object getData() {
        return this.a.getUserData();
    }

    @NotNull
    public final PlacemarkMapObject getPlaceMark() {
        return this.a;
    }

    @Override // com.avito.android.avito_map.AvitoMapMarker
    @NotNull
    public AvitoMapPoint getPosition() {
        Point geometry = this.a.getGeometry();
        Intrinsics.checkNotNullExpressionValue(geometry, "placeMark.geometry");
        double latitude = geometry.getLatitude();
        Point geometry2 = this.a.getGeometry();
        Intrinsics.checkNotNullExpressionValue(geometry2, "placeMark.geometry");
        return new AvitoMapPoint(latitude, geometry2.getLongitude());
    }

    @Override // com.avito.android.avito_map.AvitoMapMarker
    public boolean isVisible() {
        return this.a.isVisible();
    }

    @Override // com.avito.android.avito_map.AvitoMapMarker
    public void setData(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "data");
        this.a.setUserData(obj);
    }

    @Override // com.avito.android.avito_map.AvitoMapMarker
    public void setPosition(@NotNull AvitoMapPoint avitoMapPoint) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, VKApiConst.POSITION);
        if (this.a.isValid()) {
            this.a.setGeometry(new Point(avitoMapPoint.getLatitude(), avitoMapPoint.getLongitude()));
        }
    }

    @Override // com.avito.android.avito_map.AvitoMapMarker
    public void setVisibility(boolean z) {
        this.a.setVisible(z);
    }

    @Override // com.avito.android.avito_map.AvitoMapMarker
    public void setZIndex(float f) {
        this.a.setZIndex(f);
    }

    @Override // com.avito.android.avito_map.AvitoMapMarker
    public void changeIcon(@NotNull Bitmap bitmap, @NotNull String str, float f, @NotNull AvitoMapMarker.Anchor anchor) {
        Intrinsics.checkNotNullParameter(bitmap, "icon");
        Intrinsics.checkNotNullParameter(str, "imageId");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        this.a.setIcon(new YandexAvitoMapImageProvider(bitmap, str));
        PlacemarkMapObject placemarkMapObject = this.a;
        IconStyle iconStyle = new IconStyle();
        iconStyle.setZIndex(Float.valueOf(f));
        iconStyle.setAnchor(new PointF(anchor.getX(), anchor.getY()));
        Unit unit = Unit.INSTANCE;
        placemarkMapObject.setIconStyle(iconStyle);
    }
}

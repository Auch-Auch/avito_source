package com.avito.android.avito_map;

import android.graphics.Bitmap;
import androidx.annotation.DrawableRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.map.R;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001:\u0002!\"J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0001H&¢\u0006\u0004\b\n\u0010\u000bJ\u0011\u0010\f\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J/\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0016H&¢\u0006\u0004\b\u0010\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H&¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0019H&¢\u0006\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/avito/android/avito_map/AvitoMapMarker;", "", "Lcom/avito/android/avito_map/AvitoMapPoint;", "getPosition", "()Lcom/avito/android/avito_map/AvitoMapPoint;", VKApiConst.POSITION, "", "setPosition", "(Lcom/avito/android/avito_map/AvitoMapPoint;)V", "data", "setData", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Landroid/graphics/Bitmap;", "icon", "changeIcon", "(Landroid/graphics/Bitmap;)V", "", "imageId", "", "zIndex", "Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "anchor", "(Landroid/graphics/Bitmap;Ljava/lang/String;FLcom/avito/android/avito_map/AvitoMapMarker$Anchor;)V", "", "visible", "setVisibility", "(Z)V", "setZIndex", "(F)V", "isVisible", "()Z", "Anchor", "Type", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public interface AvitoMapMarker {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u0007\n\u0002\b\r\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\n\u001a\u00020\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\n\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006j\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "", "", AuthSource.SEND_ABUSE, "F", "getX", "()F", "x", AuthSource.BOOKING_ORDER, "getY", "y", "<init>", "(Ljava/lang/String;IFF)V", "CENTER", "BOTTOM_CENTER", "avito-map_release"}, k = 1, mv = {1, 4, 2})
    public enum Anchor {
        CENTER(0.5f, 0.5f),
        BOTTOM_CENTER(0.5f, 1.0f);
        
        public final float a;
        public final float b;

        /* access modifiers changed from: public */
        Anchor(float f, float f2) {
            this.a = f;
            this.b = f2;
        }

        public final float getX() {
            return this.a;
        }

        public final float getY() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0013\b\u0002\u0012\b\b\u0001\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/avito/android/avito_map/AvitoMapMarker$Type;", "", "", AuthSource.SEND_ABUSE, "I", "getDrawableRes", "()I", "drawableRes", "<init>", "(Ljava/lang/String;II)V", "MARKER_MY_LOCATION", "MARKER_MY_LOCATION_RED", "MARKER_PIN_DEFAULT", "MARKER_PIN_DEFAULT_RED", "MARKER_AMENITY_KINDERGARTEN", "MARKER_AMENITY_SCHOOL", "MARKER_AMENITY_HOSPITAL", "MARKER_AMENITY_SHOPS", "MARKER_AMENITY_SPORT", "avito-map_release"}, k = 1, mv = {1, 4, 2})
    public enum Type {
        MARKER_MY_LOCATION(R.drawable.ic_marker_my_location),
        MARKER_MY_LOCATION_RED(R.drawable.ic_explore_item_map_my_pin_red),
        MARKER_PIN_DEFAULT(R.drawable.ic_marker_pin_default),
        MARKER_PIN_DEFAULT_RED(R.drawable.ic_map_marker_selected),
        MARKER_AMENITY_KINDERGARTEN(R.drawable.kindergarten_16),
        MARKER_AMENITY_SCHOOL(R.drawable.school_16),
        MARKER_AMENITY_HOSPITAL(R.drawable.hospital_16),
        MARKER_AMENITY_SHOPS(R.drawable.shop_16),
        MARKER_AMENITY_SPORT(R.drawable.sport_16);
        
        public final int a;

        /* access modifiers changed from: public */
        Type(@DrawableRes int i) {
            this.a = i;
        }

        public final int getDrawableRes() {
            return this.a;
        }
    }

    void changeIcon(@Nullable Bitmap bitmap);

    void changeIcon(@NotNull Bitmap bitmap, @NotNull String str, float f, @NotNull Anchor anchor);

    @Nullable
    Object getData();

    @NotNull
    AvitoMapPoint getPosition();

    boolean isVisible();

    void setData(@NotNull Object obj);

    void setPosition(@NotNull AvitoMapPoint avitoMapPoint);

    void setVisibility(boolean z);

    void setZIndex(float f);
}

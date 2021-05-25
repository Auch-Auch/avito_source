package com.avito.android.avito_map;

import android.graphics.Bitmap;
import android.graphics.Point;
import androidx.annotation.DrawableRes;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.util.preferences.GeoContract;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Æ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f\bf\u0018\u00002\u00020\u0001:\u0006vwxyz{J\u001b\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ+\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u0010\u0010\u0011J1\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u0010\u0010\u0015J\u001f\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u0010\u0010\u0018J+\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\r2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\u001a\u001a\u00020\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ1\u0010 \u001a\u00020\u000f2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b \u0010!J+\u0010$\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u00162\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u0003H&¢\u0006\u0004\b$\u0010%J7\u0010+\u001a\u00020*2\u0006\u0010\n\u001a\u00020\t2\b\b\u0001\u0010&\u001a\u00020\u00032\b\b\u0002\u0010(\u001a\u00020'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b+\u0010,J\u0017\u0010+\u001a\u00020*2\u0006\u0010.\u001a\u00020-H&¢\u0006\u0004\b+\u0010/J7\u0010+\u001a\u00020*2\u0006\u0010\n\u001a\u00020\t2\b\b\u0002\u00101\u001a\u0002002\b\b\u0002\u0010(\u001a\u00020'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b+\u00102JM\u00107\u001a\b\u0012\u0004\u0012\u00020*0\u001d2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\t0\u001d2\b\u00105\u001a\u0004\u0018\u0001042\b\b\u0002\u0010(\u001a\u00020'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\r2\b\b\u0002\u00106\u001a\u00020\u000bH&¢\u0006\u0004\b7\u00108J?\u0010+\u001a\u00020*2\u0006\u0010\n\u001a\u00020\t2\b\u00105\u001a\u0004\u0018\u0001042\b\b\u0002\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010\r2\b\b\u0002\u00106\u001a\u00020\u000bH&¢\u0006\u0004\b+\u00109JK\u0010+\u001a\u00020*2\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00122\u0006\u00105\u001a\u0002042\b\b\u0002\u0010(\u001a\u00020'2\u0006\u0010)\u001a\u00020\r2\u0006\u0010;\u001a\u00020:2\b\b\u0002\u0010<\u001a\u00020\u000bH&¢\u0006\u0004\b+\u0010=J!\u0010?\u001a\u00020\u000f2\u0006\u0010>\u001a\u00020*2\b\b\u0002\u0010<\u001a\u00020\u000bH&¢\u0006\u0004\b?\u0010@J\u000f\u0010B\u001a\u00020AH&¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020\u0016H&¢\u0006\u0004\bD\u0010EJ\u0019\u0010H\u001a\u0004\u0018\u00010\t2\u0006\u0010G\u001a\u00020FH&¢\u0006\u0004\bH\u0010IJ\u0019\u0010K\u001a\u0004\u0018\u00010F2\u0006\u0010J\u001a\u00020\tH&¢\u0006\u0004\bK\u0010LJ\u000f\u0010N\u001a\u00020MH&¢\u0006\u0004\bN\u0010OJ\u0019\u0010R\u001a\u00020\u000f2\b\u0010Q\u001a\u0004\u0018\u00010PH&¢\u0006\u0004\bR\u0010SJ\u0019\u0010U\u001a\u00020\u000f2\b\u0010Q\u001a\u0004\u0018\u00010TH&¢\u0006\u0004\bU\u0010VJ\u0019\u0010X\u001a\u00020\u000f2\b\u0010Q\u001a\u0004\u0018\u00010WH&¢\u0006\u0004\bX\u0010YJ\u0019\u0010[\u001a\u00020\u000f2\b\u0010Q\u001a\u0004\u0018\u00010ZH&¢\u0006\u0004\b[\u0010\\J\u0019\u0010^\u001a\u00020\u000f2\b\u0010Q\u001a\u0004\u0018\u00010]H&¢\u0006\u0004\b^\u0010_J\u000f\u0010`\u001a\u00020\u000fH&¢\u0006\u0004\b`\u0010aJ\u000f\u0010b\u001a\u00020\u000fH&¢\u0006\u0004\bb\u0010aJ\u0017\u0010d\u001a\u00020\u000f2\u0006\u0010c\u001a\u00020AH&¢\u0006\u0004\bd\u0010eJ\u000f\u0010f\u001a\u00020\u000fH&¢\u0006\u0004\bf\u0010aJ\u000f\u0010g\u001a\u00020\u000fH&¢\u0006\u0004\bg\u0010aJ\u0017\u0010i\u001a\u00020\u000f2\u0006\u0010h\u001a\u00020\rH&¢\u0006\u0004\bi\u0010jJ\u0017\u0010k\u001a\u00020\u000f2\u0006\u0010h\u001a\u00020\rH&¢\u0006\u0004\bk\u0010jJ\u0019\u0010m\u001a\u00020\u000f2\b\b\u0002\u0010l\u001a\u00020\u000bH&¢\u0006\u0004\bm\u0010nJ/\u0010s\u001a\u00020\u000f2\u0006\u0010o\u001a\u00020\u00032\u0006\u0010p\u001a\u00020\u00032\u0006\u0010q\u001a\u00020\u00032\u0006\u0010r\u001a\u00020\u0003H&¢\u0006\u0004\bs\u0010tJ\u000f\u0010u\u001a\u00020\u000fH&¢\u0006\u0004\bu\u0010a¨\u0006|"}, d2 = {"Lcom/avito/android/avito_map/AvitoMap;", "", "Lkotlin/Pair;", "", "getSize", "()Lkotlin/Pair;", "Lcom/avito/android/avito_map/AvitoMapUiSettings;", "getUiSettings", "()Lcom/avito/android/avito_map/AvitoMapUiSettings;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "avitoMapPoint", "", "animate", "", "zoomLevel", "", "moveTo", "(Lcom/avito/android/avito_map/AvitoMapPoint;ZLjava/lang/Float;)V", "", GeoContract.LATITUDE, GeoContract.LONGITUDE, "(DDZLjava/lang/Float;)V", "Lcom/avito/android/avito_map/AvitoMapBounds;", "avitoMapBounds", "(Lcom/avito/android/avito_map/AvitoMapBounds;Z)V", "Lcom/avito/android/avito_map/AvitoMap$AnimationLength;", "animationLength", "zoomTo", "(FZLcom/avito/android/avito_map/AvitoMap$AnimationLength;)V", "", "points", "zoomPadding", "moveToPointsWithPadding", "(Ljava/util/List;Ljava/lang/Integer;Z)V", "bounds", "boundsPadding", "moveToBounds", "(Lcom/avito/android/avito_map/AvitoMapBounds;ZI)V", "id", "Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "anchor", "zIndex", "Lcom/avito/android/avito_map/AvitoMapMarker;", "addMarker", "(Lcom/avito/android/avito_map/AvitoMapPoint;ILcom/avito/android/avito_map/AvitoMapMarker$Anchor;Ljava/lang/Float;)Lcom/avito/android/avito_map/AvitoMapMarker;", "Lcom/avito/android/avito_map/AvitoMapMarkerOptions;", "options", "(Lcom/avito/android/avito_map/AvitoMapMarkerOptions;)Lcom/avito/android/avito_map/AvitoMapMarker;", "Lcom/avito/android/avito_map/AvitoMapMarker$Type;", "type", "(Lcom/avito/android/avito_map/AvitoMapPoint;Lcom/avito/android/avito_map/AvitoMapMarker$Type;Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;Ljava/lang/Float;)Lcom/avito/android/avito_map/AvitoMapMarker;", "avitoMapPoints", "Landroid/graphics/Bitmap;", "bitmap", "isVisible", "addSameMarkers", "(Ljava/util/List;Landroid/graphics/Bitmap;Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;Ljava/lang/Float;Z)Ljava/util/List;", "(Lcom/avito/android/avito_map/AvitoMapPoint;Landroid/graphics/Bitmap;Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;Ljava/lang/Float;Z)Lcom/avito/android/avito_map/AvitoMapMarker;", "", "imageId", "withAnimation", "(DDLandroid/graphics/Bitmap;Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;FLjava/lang/String;Z)Lcom/avito/android/avito_map/AvitoMapMarker;", "marker", "removeMarker", "(Lcom/avito/android/avito_map/AvitoMapMarker;Z)V", "Lcom/avito/android/avito_map/AvitoMapTarget;", "getMapTarget", "()Lcom/avito/android/avito_map/AvitoMapTarget;", "getMapBounds", "()Lcom/avito/android/avito_map/AvitoMapBounds;", "Landroid/graphics/Point;", "point", "fromScreenLocation", "(Landroid/graphics/Point;)Lcom/avito/android/avito_map/AvitoMapPoint;", "latLng", "toScreenLocation", "(Lcom/avito/android/avito_map/AvitoMapPoint;)Landroid/graphics/Point;", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "getMapCameraPosition", "()Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "Lcom/avito/android/avito_map/AvitoMap$MapMoveStartListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addMoveStartListener", "(Lcom/avito/android/avito_map/AvitoMap$MapMoveStartListener;)V", "Lcom/avito/android/avito_map/AvitoMap$MapMoveEndListener;", "addMoveEndListener", "(Lcom/avito/android/avito_map/AvitoMap$MapMoveEndListener;)V", "Lcom/avito/android/avito_map/AvitoMap$MapClickListener;", "addMapClickListener", "(Lcom/avito/android/avito_map/AvitoMap$MapClickListener;)V", "Lcom/avito/android/avito_map/AvitoMap$MarkerClickListener;", "addMarkerClickListener", "(Lcom/avito/android/avito_map/AvitoMap$MarkerClickListener;)V", "Lcom/avito/android/avito_map/AvitoMap$MarkerExactClickListener;", "addMarkerExactClickListener", "(Lcom/avito/android/avito_map/AvitoMap$MarkerExactClickListener;)V", "clearMoveStartListeners", "()V", "clearMoveEndListeners", "target", "restoreTarget", "(Lcom/avito/android/avito_map/AvitoMapTarget;)V", "onStart", "onStop", "zoomPreference", "setMaxZoomPreference", "(F)V", "setMinZoomPreference", "distinct", "distinctSameMoveEvent", "(Z)V", "top", "right", "bottom", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "setPadding", "(IIII)V", "onLowMemory", "AnimationLength", "MapClickListener", "MapMoveEndListener", "MapMoveStartListener", "MarkerClickListener", "MarkerExactClickListener", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public interface AvitoMap {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/avito_map/AvitoMap$AnimationLength;", "", "<init>", "(Ljava/lang/String;I)V", "FAST", MessengerShareContentUtility.PREVIEW_DEFAULT, "LONG", "avito-map_release"}, k = 1, mv = {1, 4, 2})
    public enum AnimationLength {
        FAST,
        DEFAULT,
        LONG
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/avito_map/AvitoMap$MapClickListener;", "", "Lcom/avito/android/avito_map/AvitoMapTarget;", "mapTarget", "", "onMapClicked", "(Lcom/avito/android/avito_map/AvitoMapTarget;)V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
    public interface MapClickListener {
        void onMapClicked(@NotNull AvitoMapTarget avitoMapTarget);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/avito_map/AvitoMap$MapMoveEndListener;", "", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "mapCameraPosition", "", "onMapSettled", "(Lcom/avito/android/avito_map/AvitoMapCameraPosition;)V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
    public interface MapMoveEndListener {
        void onMapSettled(@NotNull AvitoMapCameraPosition avitoMapCameraPosition);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/avito_map/AvitoMap$MapMoveStartListener;", "", "Lcom/avito/android/avito_map/AvitoMapMoveReason;", "reason", "", "onMapMoveStarted", "(Lcom/avito/android/avito_map/AvitoMapMoveReason;)V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
    public interface MapMoveStartListener {
        void onMapMoveStarted(@NotNull AvitoMapMoveReason avitoMapMoveReason);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/avito_map/AvitoMap$MarkerClickListener;", "", "data", "", "onMarkerClicked", "(Ljava/lang/Object;)V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
    public interface MarkerClickListener {
        void onMarkerClicked(@Nullable Object obj);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/avito_map/AvitoMap$MarkerExactClickListener;", "", "Lcom/avito/android/avito_map/AvitoMapMarker;", "marker", "", "onMarkerClicked", "(Lcom/avito/android/avito_map/AvitoMapMarker;)Z", "avito-map_release"}, k = 1, mv = {1, 4, 2})
    public interface MarkerExactClickListener {
        boolean onMarkerClicked(@Nullable AvitoMapMarker avitoMapMarker);
    }

    void addMapClickListener(@Nullable MapClickListener mapClickListener);

    @NotNull
    AvitoMapMarker addMarker(double d, double d2, @NotNull Bitmap bitmap, @NotNull AvitoMapMarker.Anchor anchor, float f, @NotNull String str, boolean z);

    @NotNull
    AvitoMapMarker addMarker(@NotNull AvitoMapMarkerOptions avitoMapMarkerOptions);

    @NotNull
    AvitoMapMarker addMarker(@NotNull AvitoMapPoint avitoMapPoint, @DrawableRes int i, @NotNull AvitoMapMarker.Anchor anchor, @Nullable Float f);

    @NotNull
    AvitoMapMarker addMarker(@NotNull AvitoMapPoint avitoMapPoint, @Nullable Bitmap bitmap, @NotNull AvitoMapMarker.Anchor anchor, @Nullable Float f, boolean z);

    @NotNull
    AvitoMapMarker addMarker(@NotNull AvitoMapPoint avitoMapPoint, @NotNull AvitoMapMarker.Type type, @NotNull AvitoMapMarker.Anchor anchor, @Nullable Float f);

    void addMarkerClickListener(@Nullable MarkerClickListener markerClickListener);

    void addMarkerExactClickListener(@Nullable MarkerExactClickListener markerExactClickListener);

    void addMoveEndListener(@Nullable MapMoveEndListener mapMoveEndListener);

    void addMoveStartListener(@Nullable MapMoveStartListener mapMoveStartListener);

    @NotNull
    List<AvitoMapMarker> addSameMarkers(@NotNull List<AvitoMapPoint> list, @Nullable Bitmap bitmap, @NotNull AvitoMapMarker.Anchor anchor, @Nullable Float f, boolean z);

    void clearMoveEndListeners();

    void clearMoveStartListeners();

    void distinctSameMoveEvent(boolean z);

    @Nullable
    AvitoMapPoint fromScreenLocation(@NotNull Point point);

    @NotNull
    AvitoMapBounds getMapBounds();

    @NotNull
    AvitoMapCameraPosition getMapCameraPosition();

    @NotNull
    AvitoMapTarget getMapTarget();

    @NotNull
    Pair<Integer, Integer> getSize();

    @NotNull
    AvitoMapUiSettings getUiSettings();

    void moveTo(double d, double d2, boolean z, @Nullable Float f);

    void moveTo(@NotNull AvitoMapBounds avitoMapBounds, boolean z);

    void moveTo(@NotNull AvitoMapPoint avitoMapPoint, boolean z, @Nullable Float f);

    void moveToBounds(@NotNull AvitoMapBounds avitoMapBounds, boolean z, int i);

    void moveToPointsWithPadding(@NotNull List<AvitoMapPoint> list, @Nullable Integer num, boolean z);

    void onLowMemory();

    void onStart();

    void onStop();

    void removeMarker(@NotNull AvitoMapMarker avitoMapMarker, boolean z);

    void restoreTarget(@NotNull AvitoMapTarget avitoMapTarget);

    void setMaxZoomPreference(float f);

    void setMinZoomPreference(float f);

    void setPadding(int i, int i2, int i3, int i4);

    @Nullable
    Point toScreenLocation(@NotNull AvitoMapPoint avitoMapPoint);

    void zoomTo(float f, boolean z, @NotNull AnimationLength animationLength);

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ AvitoMapMarker addMarker$default(AvitoMap avitoMap, AvitoMapPoint avitoMapPoint, int i, AvitoMapMarker.Anchor anchor, Float f, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    anchor = AvitoMapMarker.Anchor.CENTER;
                }
                if ((i2 & 8) != 0) {
                    f = Float.valueOf(0.0f);
                }
                return avitoMap.addMarker(avitoMapPoint, i, anchor, f);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addMarker");
        }

        public static /* synthetic */ List addSameMarkers$default(AvitoMap avitoMap, List list, Bitmap bitmap, AvitoMapMarker.Anchor anchor, Float f, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    anchor = AvitoMapMarker.Anchor.CENTER;
                }
                if ((i & 8) != 0) {
                    f = Float.valueOf(0.0f);
                }
                return avitoMap.addSameMarkers(list, bitmap, anchor, f, (i & 16) != 0 ? true : z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSameMarkers");
        }

        public static /* synthetic */ void distinctSameMoveEvent$default(AvitoMap avitoMap, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    z = false;
                }
                avitoMap.distinctSameMoveEvent(z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: distinctSameMoveEvent");
        }

        public static /* synthetic */ void moveTo$default(AvitoMap avitoMap, AvitoMapPoint avitoMapPoint, boolean z, Float f, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    f = null;
                }
                avitoMap.moveTo(avitoMapPoint, z, f);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveTo");
        }

        public static /* synthetic */ void moveToBounds$default(AvitoMap avitoMap, AvitoMapBounds avitoMapBounds, boolean z, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    z = true;
                }
                if ((i2 & 4) != 0) {
                    i = 0;
                }
                avitoMap.moveToBounds(avitoMapBounds, z, i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveToBounds");
        }

        public static /* synthetic */ void moveToPointsWithPadding$default(AvitoMap avitoMap, List list, Integer num, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = true;
                }
                avitoMap.moveToPointsWithPadding(list, num, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveToPointsWithPadding");
        }

        public static /* synthetic */ void removeMarker$default(AvitoMap avitoMap, AvitoMapMarker avitoMapMarker, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                avitoMap.removeMarker(avitoMapMarker, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: removeMarker");
        }

        public static /* synthetic */ void zoomTo$default(AvitoMap avitoMap, float f, boolean z, AnimationLength animationLength, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z = false;
                }
                if ((i & 4) != 0) {
                    animationLength = AnimationLength.DEFAULT;
                }
                avitoMap.zoomTo(f, z, animationLength);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: zoomTo");
        }

        public static /* synthetic */ AvitoMapMarker addMarker$default(AvitoMap avitoMap, AvitoMapPoint avitoMapPoint, AvitoMapMarker.Type type, AvitoMapMarker.Anchor anchor, Float f, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    type = AvitoMapMarker.Type.MARKER_PIN_DEFAULT;
                }
                if ((i & 4) != 0) {
                    anchor = AvitoMapMarker.Anchor.CENTER;
                }
                if ((i & 8) != 0) {
                    f = Float.valueOf(0.0f);
                }
                return avitoMap.addMarker(avitoMapPoint, type, anchor, f);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addMarker");
        }

        public static /* synthetic */ AvitoMapMarker addMarker$default(AvitoMap avitoMap, AvitoMapPoint avitoMapPoint, Bitmap bitmap, AvitoMapMarker.Anchor anchor, Float f, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    anchor = AvitoMapMarker.Anchor.CENTER;
                }
                return avitoMap.addMarker(avitoMapPoint, bitmap, anchor, f, (i & 16) != 0 ? true : z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addMarker");
        }

        public static /* synthetic */ AvitoMapMarker addMarker$default(AvitoMap avitoMap, double d, double d2, Bitmap bitmap, AvitoMapMarker.Anchor anchor, float f, String str, boolean z, int i, Object obj) {
            if (obj == null) {
                return avitoMap.addMarker(d, d2, bitmap, (i & 8) != 0 ? AvitoMapMarker.Anchor.CENTER : anchor, f, str, (i & 64) != 0 ? false : z);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addMarker");
        }
    }
}

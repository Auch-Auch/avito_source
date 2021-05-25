package com.avito.android.avito_map.yandex;

import a2.g.r.g;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapBoundsBuilder;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapMarkerOptions;
import com.avito.android.avito_map.AvitoMapMoveReason;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.AvitoMapTarget;
import com.avito.android.avito_map.AvitoMapUiSettings;
import com.avito.android.lib.design.avito.R;
import com.avito.android.lib.util.DarkThemeManagerKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.preferences.GeoContract;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.MapKitFactory;
import com.yandex.mapkit.ScreenPoint;
import com.yandex.mapkit.geometry.BoundingBox;
import com.yandex.mapkit.geometry.Point;
import com.yandex.mapkit.map.Callback;
import com.yandex.mapkit.map.CameraListener;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.CameraUpdateSource;
import com.yandex.mapkit.map.IconStyle;
import com.yandex.mapkit.map.InputListener;
import com.yandex.mapkit.map.Map;
import com.yandex.mapkit.map.MapObject;
import com.yandex.mapkit.map.MapObjectCollection;
import com.yandex.mapkit.map.MapObjectTapListener;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.mapkit.map.VisibleRegion;
import com.yandex.mapkit.mapview.MapView;
import com.yandex.runtime.image.ImageProvider;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0013\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b¥\u0001\u0010¦\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u001b\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J)\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J1\u0010\u0017\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0017\u0010\u001cJ\u001f\u0010\u0017\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0017\u0010\u001fJ/\u0010#\u001a\u00020\t2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00130 2\b\u0010\"\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0015\u001a\u00020\u0007H\u0016¢\u0006\u0004\b#\u0010$J1\u0010*\u001a\u00020)2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010%\u001a\u00020\r2\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b*\u0010+J\u0017\u0010*\u001a\u00020)2\u0006\u0010-\u001a\u00020,H\u0016¢\u0006\u0004\b*\u0010.J1\u0010*\u001a\u00020)2\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u00100\u001a\u00020/2\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b*\u00101JG\u00106\u001a\b\u0012\u0004\u0012\u00020)0 2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00130 2\b\u00104\u001a\u0004\u0018\u0001032\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u00022\u0006\u00105\u001a\u00020\u0007H\u0016¢\u0006\u0004\b6\u00107J;\u0010*\u001a\u00020)2\u0006\u0010\u0014\u001a\u00020\u00132\b\u00104\u001a\u0004\u0018\u0001032\u0006\u0010'\u001a\u00020&2\b\u0010(\u001a\u0004\u0018\u00010\u00022\u0006\u00105\u001a\u00020\u0007H\u0016¢\u0006\u0004\b*\u00108JG\u0010*\u001a\u00020)2\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u00104\u001a\u0002032\u0006\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u00022\u0006\u0010:\u001a\u0002092\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b*\u0010;J\u001f\u0010=\u001a\u00020\t2\u0006\u0010<\u001a\u00020)2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b=\u0010>J\u000f\u0010@\u001a\u00020?H\u0016¢\u0006\u0004\b@\u0010AJ'\u0010D\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010C\u001a\u00020BH\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\u001dH\u0016¢\u0006\u0004\bF\u0010GJ\u0019\u0010J\u001a\u0004\u0018\u00010\u00132\u0006\u0010I\u001a\u00020HH\u0016¢\u0006\u0004\bJ\u0010KJ\u0019\u0010M\u001a\u0004\u0018\u00010H2\u0006\u0010L\u001a\u00020\u0013H\u0016¢\u0006\u0004\bM\u0010NJ\u000f\u0010P\u001a\u00020OH\u0016¢\u0006\u0004\bP\u0010QJ\u0019\u0010T\u001a\u00020\t2\b\u0010S\u001a\u0004\u0018\u00010RH\u0016¢\u0006\u0004\bT\u0010UJ\u0019\u0010W\u001a\u00020\t2\b\u0010S\u001a\u0004\u0018\u00010VH\u0016¢\u0006\u0004\bW\u0010XJ\u0019\u0010Z\u001a\u00020\t2\b\u0010S\u001a\u0004\u0018\u00010YH\u0016¢\u0006\u0004\bZ\u0010[J\u0019\u0010]\u001a\u00020\t2\b\u0010S\u001a\u0004\u0018\u00010\\H\u0016¢\u0006\u0004\b]\u0010^J\u0019\u0010`\u001a\u00020\t2\b\u0010S\u001a\u0004\u0018\u00010_H\u0016¢\u0006\u0004\b`\u0010aJ\u000f\u0010b\u001a\u00020\tH\u0016¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020\tH\u0016¢\u0006\u0004\bd\u0010cJ\u0017\u0010f\u001a\u00020\t2\u0006\u0010e\u001a\u00020?H\u0016¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020\tH\u0016¢\u0006\u0004\bh\u0010cJ\u000f\u0010i\u001a\u00020\tH\u0016¢\u0006\u0004\bi\u0010cJ\u0017\u0010k\u001a\u00020\t2\u0006\u0010j\u001a\u00020\u0002H\u0016¢\u0006\u0004\bk\u0010lJ\u0017\u0010m\u001a\u00020\t2\u0006\u0010j\u001a\u00020\u0002H\u0016¢\u0006\u0004\bm\u0010lJ\u0017\u0010o\u001a\u00020\t2\u0006\u0010n\u001a\u00020\u0007H\u0016¢\u0006\u0004\bo\u0010pJ/\u0010u\u001a\u00020\t2\u0006\u0010q\u001a\u00020\r2\u0006\u0010r\u001a\u00020\r2\u0006\u0010s\u001a\u00020\r2\u0006\u0010t\u001a\u00020\rH\u0016¢\u0006\u0004\bu\u0010vJ'\u0010y\u001a\u00020\t2\u0006\u0010w\u001a\u00020\u001d2\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010x\u001a\u00020\rH\u0016¢\u0006\u0004\by\u0010zJ\u000f\u0010{\u001a\u00020\tH\u0016¢\u0006\u0004\b{\u0010cR\u001c\u0010\u001a\b\u0012\u0004\u0012\u00020R0|8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b}\u0010~R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\\0|8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010~R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020Y0|8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0001\u0010~R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0003\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\n\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001e\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u00020V0|8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b \u0001\u0010~R\u0018\u0010o\u001a\u00020\u00078\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b¢\u0001\u0010\u0001R\u001e\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020_0|8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b£\u0001\u0010~¨\u0006§\u0001"}, d2 = {"Lcom/avito/android/avito_map/yandex/AvitoYandexMap;", "Lcom/avito/android/avito_map/AvitoMap;", "", AuthSource.SEND_ABUSE, "()F", "Lcom/yandex/mapkit/map/CameraPosition;", "cameraPosition", "", "withAnimation", "", AuthSource.BOOKING_ORDER, "(Lcom/yandex/mapkit/map/CameraPosition;Z)V", "Lkotlin/Pair;", "", "getSize", "()Lkotlin/Pair;", "Lcom/avito/android/avito_map/AvitoMapUiSettings;", "getUiSettings", "()Lcom/avito/android/avito_map/AvitoMapUiSettings;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "avitoMapPoint", "animate", "zoomLevel", "moveTo", "(Lcom/avito/android/avito_map/AvitoMapPoint;ZLjava/lang/Float;)V", "", GeoContract.LATITUDE, GeoContract.LONGITUDE, "(DDZLjava/lang/Float;)V", "Lcom/avito/android/avito_map/AvitoMapBounds;", "avitoMapBounds", "(Lcom/avito/android/avito_map/AvitoMapBounds;Z)V", "", "points", "zoomPadding", "moveToPointsWithPadding", "(Ljava/util/List;Ljava/lang/Integer;Z)V", "id", "Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "anchor", "zIndex", "Lcom/avito/android/avito_map/AvitoMapMarker;", "addMarker", "(Lcom/avito/android/avito_map/AvitoMapPoint;ILcom/avito/android/avito_map/AvitoMapMarker$Anchor;Ljava/lang/Float;)Lcom/avito/android/avito_map/AvitoMapMarker;", "Lcom/avito/android/avito_map/AvitoMapMarkerOptions;", "options", "(Lcom/avito/android/avito_map/AvitoMapMarkerOptions;)Lcom/avito/android/avito_map/AvitoMapMarker;", "Lcom/avito/android/avito_map/AvitoMapMarker$Type;", "type", "(Lcom/avito/android/avito_map/AvitoMapPoint;Lcom/avito/android/avito_map/AvitoMapMarker$Type;Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;Ljava/lang/Float;)Lcom/avito/android/avito_map/AvitoMapMarker;", "avitoMapPoints", "Landroid/graphics/Bitmap;", "bitmap", "isVisible", "addSameMarkers", "(Ljava/util/List;Landroid/graphics/Bitmap;Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;Ljava/lang/Float;Z)Ljava/util/List;", "(Lcom/avito/android/avito_map/AvitoMapPoint;Landroid/graphics/Bitmap;Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;Ljava/lang/Float;Z)Lcom/avito/android/avito_map/AvitoMapMarker;", "", "imageId", "(DDLandroid/graphics/Bitmap;Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;FLjava/lang/String;Z)Lcom/avito/android/avito_map/AvitoMapMarker;", "marker", "removeMarker", "(Lcom/avito/android/avito_map/AvitoMapMarker;Z)V", "Lcom/avito/android/avito_map/AvitoMapTarget;", "getMapTarget", "()Lcom/avito/android/avito_map/AvitoMapTarget;", "Lcom/avito/android/avito_map/AvitoMap$AnimationLength;", "animationLength", "zoomTo", "(FZLcom/avito/android/avito_map/AvitoMap$AnimationLength;)V", "getMapBounds", "()Lcom/avito/android/avito_map/AvitoMapBounds;", "Landroid/graphics/Point;", "point", "fromScreenLocation", "(Landroid/graphics/Point;)Lcom/avito/android/avito_map/AvitoMapPoint;", "latLng", "toScreenLocation", "(Lcom/avito/android/avito_map/AvitoMapPoint;)Landroid/graphics/Point;", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "getMapCameraPosition", "()Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "Lcom/avito/android/avito_map/AvitoMap$MapMoveStartListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addMoveStartListener", "(Lcom/avito/android/avito_map/AvitoMap$MapMoveStartListener;)V", "Lcom/avito/android/avito_map/AvitoMap$MapMoveEndListener;", "addMoveEndListener", "(Lcom/avito/android/avito_map/AvitoMap$MapMoveEndListener;)V", "Lcom/avito/android/avito_map/AvitoMap$MapClickListener;", "addMapClickListener", "(Lcom/avito/android/avito_map/AvitoMap$MapClickListener;)V", "Lcom/avito/android/avito_map/AvitoMap$MarkerClickListener;", "addMarkerClickListener", "(Lcom/avito/android/avito_map/AvitoMap$MarkerClickListener;)V", "Lcom/avito/android/avito_map/AvitoMap$MarkerExactClickListener;", "addMarkerExactClickListener", "(Lcom/avito/android/avito_map/AvitoMap$MarkerExactClickListener;)V", "clearMoveEndListeners", "()V", "clearMoveStartListeners", "target", "restoreTarget", "(Lcom/avito/android/avito_map/AvitoMapTarget;)V", "onStart", "onStop", "zoomPreference", "setMaxZoomPreference", "(F)V", "setMinZoomPreference", "distinct", "distinctSameMoveEvent", "(Z)V", "top", "right", "bottom", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "setPadding", "(IIII)V", "bounds", "boundsPadding", "moveToBounds", "(Lcom/avito/android/avito_map/AvitoMapBounds;ZI)V", "onLowMemory", "", "c", "Ljava/util/List;", "mapMoveStartListeners", "f", "markerClickListeners", "Lcom/yandex/mapkit/mapview/MapView;", "n", "Lcom/yandex/mapkit/mapview/MapView;", "mapView", "e", "mapClickListeners", "Lcom/yandex/mapkit/map/MapObjectTapListener;", "l", "Lcom/yandex/mapkit/map/MapObjectTapListener;", "tapListener", "Lcom/yandex/mapkit/map/InputListener;", "i", "Lcom/yandex/mapkit/map/InputListener;", "inputTapListener", AuthSource.OPEN_CHANNEL_LIST, "Lcom/yandex/mapkit/map/CameraPosition;", "lastCameraPosition", "Lcom/yandex/mapkit/map/MapObjectCollection;", "Lcom/yandex/mapkit/map/MapObjectCollection;", "mapObjects", "Lcom/yandex/mapkit/map/CameraListener;", "h", "Lcom/yandex/mapkit/map/CameraListener;", "cameraListener", "Z", "cameraStartedMoving", "Lcom/yandex/mapkit/Animation;", "j", "Lcom/yandex/mapkit/Animation;", "animation", "d", "mapMoveEndListeners", "k", g.a, "markerExactClickListeners", "<init>", "(Lcom/yandex/mapkit/mapview/MapView;)V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoYandexMap implements AvitoMap {
    public MapObjectCollection a;
    public boolean b = true;
    public final List<AvitoMap.MapMoveStartListener> c = new ArrayList();
    public final List<AvitoMap.MapMoveEndListener> d = new ArrayList();
    public final List<AvitoMap.MapClickListener> e = new ArrayList();
    public final List<AvitoMap.MarkerClickListener> f = new ArrayList();
    public final List<AvitoMap.MarkerExactClickListener> g = new ArrayList();
    public final CameraListener h;
    public final InputListener i;
    public final Animation j = new Animation(Animation.Type.SMOOTH, 0.125f);
    public boolean k;
    public final MapObjectTapListener l = new d(this);
    public CameraPosition m;
    public final MapView n;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            CameraUpdateSource.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            CameraUpdateSource cameraUpdateSource = CameraUpdateSource.GESTURES;
            iArr[0] = 1;
            CameraUpdateSource cameraUpdateSource2 = CameraUpdateSource.APPLICATION;
            iArr[1] = 2;
        }
    }

    public static final class a implements CameraListener {
        public final /* synthetic */ AvitoYandexMap a;

        public a(AvitoYandexMap avitoYandexMap) {
            this.a = avitoYandexMap;
        }

        @Override // com.yandex.mapkit.map.CameraListener
        public final void onCameraPositionChanged(@NotNull Map map, @NotNull CameraPosition cameraPosition, @NotNull CameraUpdateSource cameraUpdateSource, boolean z) {
            AvitoMapMoveReason avitoMapMoveReason;
            Intrinsics.checkNotNullParameter(map, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(cameraPosition, "cameraPosition");
            Intrinsics.checkNotNullParameter(cameraUpdateSource, "cameraUpdateSource");
            if (this.a.b) {
                if (this.a.k) {
                    Point target = cameraPosition.getTarget();
                    Intrinsics.checkNotNullExpressionValue(target, "cameraPosition.target");
                    CameraPosition cameraPosition2 = this.a.m;
                    Point target2 = cameraPosition2 != null ? cameraPosition2.getTarget() : null;
                    if (target2 != null && ((target.getLatitude() == target2.getLatitude() && target.getLongitude() == target2.getLongitude()) || (Math.abs(target.getLatitude() - target2.getLatitude()) < 1.0E-7d && Math.abs(target.getLongitude() - target2.getLongitude()) < 1.0E-7d))) {
                        float zoom = cameraPosition.getZoom();
                        CameraPosition cameraPosition3 = this.a.m;
                        if (cameraPosition3 != null && zoom == cameraPosition3.getZoom()) {
                            return;
                        }
                    }
                }
                this.a.b = false;
                int ordinal = cameraUpdateSource.ordinal();
                if (ordinal == 0) {
                    avitoMapMoveReason = AvitoMapMoveReason.GESTURE;
                } else if (ordinal == 1) {
                    avitoMapMoveReason = AvitoMapMoveReason.DEVELOPER_ANIMATION;
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                for (AvitoMap.MapMoveStartListener mapMoveStartListener : this.a.c) {
                    mapMoveStartListener.onMapMoveStarted(avitoMapMoveReason);
                }
            }
            if (z) {
                this.a.b = true;
                for (AvitoMap.MapMoveEndListener mapMoveEndListener : this.a.d) {
                    mapMoveEndListener.onMapSettled(this.a.getMapCameraPosition());
                }
                this.a.m = cameraPosition;
            }
        }
    }

    public static final class b implements Callback {
        public static final b a = new b();

        @Override // com.yandex.mapkit.map.Callback
        public final void onTaskFinished() {
        }
    }

    public static final class c implements Callback {
        public final /* synthetic */ PlacemarkMapObject a;
        public final /* synthetic */ AvitoYandexMap b;

        public c(PlacemarkMapObject placemarkMapObject, AvitoYandexMap avitoYandexMap, boolean z) {
            this.a = placemarkMapObject;
            this.b = avitoYandexMap;
        }

        @Override // com.yandex.mapkit.map.Callback
        public final void onTaskFinished() {
            this.a.setVisible(false, this.b.j, null);
            this.b.a.remove(this.a);
        }
    }

    public static final class d implements MapObjectTapListener {
        public final /* synthetic */ AvitoYandexMap a;

        public d(AvitoYandexMap avitoYandexMap) {
            this.a = avitoYandexMap;
        }

        @Override // com.yandex.mapkit.map.MapObjectTapListener
        public final boolean onMapObjectTap(@NotNull MapObject mapObject, @NotNull Point point) {
            Intrinsics.checkNotNullParameter(mapObject, "mapObject");
            Intrinsics.checkNotNullParameter(point, "<anonymous parameter 1>");
            for (AvitoMap.MarkerClickListener markerClickListener : this.a.f) {
                markerClickListener.onMarkerClicked(mapObject.getUserData());
            }
            for (AvitoMap.MarkerExactClickListener markerExactClickListener : this.a.g) {
                Object userData = mapObject.getUserData();
                Objects.requireNonNull(userData, "null cannot be cast to non-null type com.avito.android.avito_map.yandex.YandexAvitoMapMarker");
                markerExactClickListener.onMarkerClicked((YandexAvitoMapMarker) userData);
            }
            return true;
        }
    }

    public static final class e implements Map.CameraCallback {
        public static final e a = new e();

        @Override // com.yandex.mapkit.map.Map.CameraCallback
        public final void onMoveFinished(boolean z) {
        }
    }

    public AvitoYandexMap(@NotNull MapView mapView) {
        Intrinsics.checkNotNullParameter(mapView, "mapView");
        this.n = mapView;
        Map map = mapView.getMap();
        Intrinsics.checkNotNullExpressionValue(map, "mapView.map");
        MapObjectCollection addCollection = map.getMapObjects().addCollection();
        Intrinsics.checkNotNullExpressionValue(addCollection, "mapView.map.mapObjects.addCollection()");
        this.a = addCollection;
        Context context = mapView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "mapView.context");
        getUiSettings().isDarkModeEnabled(DarkThemeManagerKt.isDarkTheme(context));
        a aVar = new a(this);
        this.h = aVar;
        AnonymousClass2 r1 = new InputListener(this) { // from class: com.avito.android.avito_map.yandex.AvitoYandexMap.2
            public final /* synthetic */ AvitoYandexMap a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // com.yandex.mapkit.map.InputListener
            public void onMapLongTap(@NotNull Map map2, @NotNull Point point) {
                Intrinsics.checkNotNullParameter(map2, "map");
                Intrinsics.checkNotNullParameter(point, "point");
            }

            @Override // com.yandex.mapkit.map.InputListener
            public void onMapTap(@NotNull Map map2, @NotNull Point point) {
                Intrinsics.checkNotNullParameter(map2, "map");
                Intrinsics.checkNotNullParameter(point, "point");
                AvitoMapTarget avitoMapTarget = new AvitoMapTarget(new AvitoMapPoint(point.getLatitude(), point.getLongitude()), this.a.getMapTarget().getZoomLevel());
                for (AvitoMap.MapClickListener mapClickListener : this.a.e) {
                    mapClickListener.onMapClicked(avitoMapTarget);
                }
            }
        };
        this.i = r1;
        mapView.getMap().addCameraListener(aVar);
        mapView.getMap().addInputListener(r1);
    }

    public final float a() {
        Map map = this.n.getMap();
        Intrinsics.checkNotNullExpressionValue(map, "mapView.map");
        CameraPosition cameraPosition = map.getCameraPosition();
        Intrinsics.checkNotNullExpressionValue(cameraPosition, "mapView.map.cameraPosition");
        return cameraPosition.getZoom();
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void addMapClickListener(@Nullable AvitoMap.MapClickListener mapClickListener) {
        if (mapClickListener != null) {
            this.e.add(mapClickListener);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public AvitoMapMarker addMarker(@NotNull AvitoMapPoint avitoMapPoint, int i2, @NotNull AvitoMapMarker.Anchor anchor, @Nullable Float f2) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "avitoMapPoint");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(this.n.getContext(), R.style.Theme_DesignSystem_Avito);
        MapObjectCollection mapObjectCollection = this.a;
        Point point = AvitoYandexMapKt.toPoint(avitoMapPoint);
        Drawable drawable = contextThemeWrapper.getDrawable(i2);
        PlacemarkMapObject addPlacemark = mapObjectCollection.addPlacemark(point, ImageProvider.fromBitmap(drawable != null ? DrawablesKt.getBitmap(drawable) : null, true, String.valueOf(i2)));
        addPlacemark.addTapListener(this.l);
        IconStyle iconStyle = new IconStyle();
        iconStyle.setAnchor(new PointF(anchor.getX(), anchor.getY()));
        if (f2 != null) {
            iconStyle.setZIndex(Float.valueOf(f2.floatValue()));
        }
        addPlacemark.setIconStyle(iconStyle);
        Intrinsics.checkNotNullExpressionValue(addPlacemark, "mapObjects.addPlacemark(…          )\n            }");
        return new YandexAvitoMapMarker(addPlacemark);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void addMarkerClickListener(@Nullable AvitoMap.MarkerClickListener markerClickListener) {
        if (markerClickListener != null) {
            this.f.add(markerClickListener);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void addMarkerExactClickListener(@Nullable AvitoMap.MarkerExactClickListener markerExactClickListener) {
        if (markerExactClickListener != null) {
            this.g.add(markerExactClickListener);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void addMoveEndListener(@Nullable AvitoMap.MapMoveEndListener mapMoveEndListener) {
        if (mapMoveEndListener != null) {
            this.d.add(mapMoveEndListener);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void addMoveStartListener(@Nullable AvitoMap.MapMoveStartListener mapMoveStartListener) {
        if (mapMoveStartListener != null) {
            this.c.add(mapMoveStartListener);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public List<AvitoMapMarker> addSameMarkers(@NotNull List<AvitoMapPoint> list, @Nullable Bitmap bitmap, @NotNull AvitoMapMarker.Anchor anchor, @Nullable Float f2, boolean z) {
        Intrinsics.checkNotNullParameter(list, "avitoMapPoints");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(addMarker(it.next(), bitmap, anchor, f2, z));
        }
        return arrayList;
    }

    public final void b(CameraPosition cameraPosition, boolean z) {
        this.n.getMap().move(cameraPosition, new Animation(Animation.Type.SMOOTH, z ? 0.5f : 0.0f), null);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void clearMoveEndListeners() {
        this.d.clear();
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void clearMoveStartListeners() {
        this.c.clear();
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void distinctSameMoveEvent(boolean z) {
        this.k = z;
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @Nullable
    public AvitoMapPoint fromScreenLocation(@NotNull android.graphics.Point point) {
        Intrinsics.checkNotNullParameter(point, "point");
        Point screenToWorld = this.n.getMapWindow().screenToWorld(new ScreenPoint((float) point.x, (float) point.y));
        if (screenToWorld != null) {
            return AvitoYandexMapKt.toAvitoMapPoint(screenToWorld);
        }
        return null;
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public AvitoMapBounds getMapBounds() {
        Map map = this.n.getMap();
        Intrinsics.checkNotNullExpressionValue(map, "mapView.map");
        VisibleRegion visibleRegion = map.getVisibleRegion();
        Intrinsics.checkNotNullExpressionValue(visibleRegion, "mapView.map.visibleRegion");
        return AvitoYandexMapKt.toAvitoMapBounds(visibleRegion);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public AvitoMapCameraPosition getMapCameraPosition() {
        Map map = this.n.getMap();
        Intrinsics.checkNotNullExpressionValue(map, "mapView.map");
        CameraPosition cameraPosition = map.getCameraPosition();
        Point target = cameraPosition.getTarget();
        Intrinsics.checkNotNullExpressionValue(target, "target");
        return new AvitoMapCameraPosition(AvitoYandexMapKt.toAvitoMapPoint(target), cameraPosition.getZoom(), cameraPosition.getTilt(), Float.valueOf(cameraPosition.getAzimuth()), getMapBounds());
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public AvitoMapTarget getMapTarget() {
        Map map = this.n.getMap();
        Intrinsics.checkNotNullExpressionValue(map, "mapView.map");
        CameraPosition cameraPosition = map.getCameraPosition();
        Intrinsics.checkNotNullExpressionValue(cameraPosition, "mapView.map.cameraPosition");
        Point target = cameraPosition.getTarget();
        Intrinsics.checkNotNullExpressionValue(target, "mapView.map.cameraPosition.target");
        AvitoMapPoint avitoMapPoint = AvitoYandexMapKt.toAvitoMapPoint(target);
        Map map2 = this.n.getMap();
        Intrinsics.checkNotNullExpressionValue(map2, "mapView.map");
        CameraPosition cameraPosition2 = map2.getCameraPosition();
        Intrinsics.checkNotNullExpressionValue(cameraPosition2, "mapView.map.cameraPosition");
        return new AvitoMapTarget(avitoMapPoint, cameraPosition2.getZoom());
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public Pair<Integer, Integer> getSize() {
        return new Pair<>(Integer.valueOf(this.n.width()), Integer.valueOf(this.n.height()));
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public AvitoMapUiSettings getUiSettings() {
        Map map = this.n.getMap();
        Intrinsics.checkNotNullExpressionValue(map, "mapView.map");
        return new YandexAvitoMapUiSettings(map);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void moveTo(@NotNull AvitoMapPoint avitoMapPoint, boolean z, @Nullable Float f2) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "avitoMapPoint");
        Point point = AvitoYandexMapKt.toPoint(avitoMapPoint);
        float floatValue = f2 != null ? f2.floatValue() : a();
        Map map = this.n.getMap();
        Intrinsics.checkNotNullExpressionValue(map, "mapView.map");
        CameraPosition cameraPosition = map.getCameraPosition();
        Intrinsics.checkNotNullExpressionValue(cameraPosition, "mapView.map.cameraPosition");
        float azimuth = cameraPosition.getAzimuth();
        Map map2 = this.n.getMap();
        Intrinsics.checkNotNullExpressionValue(map2, "mapView.map");
        CameraPosition cameraPosition2 = map2.getCameraPosition();
        Intrinsics.checkNotNullExpressionValue(cameraPosition2, "mapView.map.cameraPosition");
        b(new CameraPosition(point, floatValue, azimuth, cameraPosition2.getTilt()), z);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void moveToBounds(@NotNull AvitoMapBounds avitoMapBounds, boolean z, int i2) {
        Intrinsics.checkNotNullParameter(avitoMapBounds, "bounds");
        CameraPosition cameraPosition = this.n.getMap().cameraPosition(AvitoYandexMapKt.toBoundingBox(avitoMapBounds));
        Intrinsics.checkNotNullExpressionValue(cameraPosition, "mapView.map.cameraPosition(bounds.toBoundingBox())");
        this.n.getMap().move(cameraPosition, new Animation(Animation.Type.SMOOTH, z ? 0.5f : 0.0f), null);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void moveToPointsWithPadding(@NotNull List<AvitoMapPoint> list, @Nullable Integer num, boolean z) {
        Intrinsics.checkNotNullParameter(list, "points");
        AvitoMapBoundsBuilder avitoMapBoundsBuilder = new AvitoMapBoundsBuilder(this.n.width(), this.n.height());
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            avitoMapBoundsBuilder.addPoint(it.next());
        }
        if (num != null) {
            avitoMapBoundsBuilder.addOffset(num.intValue());
        }
        AvitoMapBounds build = avitoMapBoundsBuilder.build();
        BoundingBox boundingBox = build != null ? AvitoYandexMapKt.toBoundingBox(build) : null;
        if (boundingBox != null) {
            CameraPosition cameraPosition = this.n.getMap().cameraPosition(boundingBox);
            Intrinsics.checkNotNullExpressionValue(cameraPosition, "mapView.map.cameraPosition(boundingBox)");
            this.n.getMap().move(cameraPosition, new Animation(Animation.Type.SMOOTH, z ? 0.5f : 0.0f), null);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void onLowMemory() {
        this.n.onMemoryWarning();
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void onStart() {
        this.n.onStart();
        MapKitFactory.getInstance().onStart();
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void onStop() {
        this.n.onStop();
        MapKitFactory.getInstance().onStop();
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void removeMarker(@NotNull AvitoMapMarker avitoMapMarker, boolean z) {
        PlacemarkMapObject placeMark;
        Intrinsics.checkNotNullParameter(avitoMapMarker, "marker");
        if (!(avitoMapMarker instanceof YandexAvitoMapMarker)) {
            avitoMapMarker = null;
        }
        YandexAvitoMapMarker yandexAvitoMapMarker = (YandexAvitoMapMarker) avitoMapMarker;
        if (yandexAvitoMapMarker != null && (placeMark = yandexAvitoMapMarker.getPlaceMark()) != null) {
            if (z) {
                placeMark.setVisible(false, this.j, new c(placeMark, this, z));
            } else {
                this.a.remove(placeMark);
            }
        }
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void restoreTarget(@NotNull AvitoMapTarget avitoMapTarget) {
        Intrinsics.checkNotNullParameter(avitoMapTarget, "target");
        moveTo(avitoMapTarget.getPoint(), false, Float.valueOf(avitoMapTarget.getZoomLevel()));
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void setMaxZoomPreference(float f2) {
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void setMinZoomPreference(float f2) {
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void setPadding(int i2, int i3, int i4, int i5) {
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @Nullable
    public android.graphics.Point toScreenLocation(@NotNull AvitoMapPoint avitoMapPoint) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "latLng");
        ScreenPoint worldToScreen = this.n.getMapWindow().worldToScreen(new Point(avitoMapPoint.getLatitude(), avitoMapPoint.getLongitude()));
        if (worldToScreen == null) {
            return null;
        }
        Intrinsics.checkNotNullExpressionValue(worldToScreen, "mapView.mapWindow.worldT…ongitude)) ?: return null");
        return new android.graphics.Point((int) worldToScreen.getX(), (int) worldToScreen.getY());
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void zoomTo(float f2, boolean z, @NotNull AvitoMap.AnimationLength animationLength) {
        Intrinsics.checkNotNullParameter(animationLength, "animationLength");
        float yandexMapAnimationLength = AvitoYandexMapKt.toYandexMapAnimationLength(animationLength);
        Animation.Type type = Animation.Type.SMOOTH;
        if (!z) {
            yandexMapAnimationLength = 0.0f;
        }
        this.n.getMap().move(AvitoYandexMapKt.toYandexCameraPosition(AvitoMapCameraPosition.copy$default(getMapCameraPosition(), null, f2, 0.0f, null, null, 29, null)), new Animation(type, yandexMapAnimationLength), e.a);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void moveTo(double d2, double d3, boolean z, @Nullable Float f2) {
        Point point = new Point(d2, d3);
        float floatValue = f2 != null ? f2.floatValue() : a();
        Map map = this.n.getMap();
        Intrinsics.checkNotNullExpressionValue(map, "mapView.map");
        CameraPosition cameraPosition = map.getCameraPosition();
        Intrinsics.checkNotNullExpressionValue(cameraPosition, "mapView.map.cameraPosition");
        float azimuth = cameraPosition.getAzimuth();
        Map map2 = this.n.getMap();
        Intrinsics.checkNotNullExpressionValue(map2, "mapView.map");
        CameraPosition cameraPosition2 = map2.getCameraPosition();
        Intrinsics.checkNotNullExpressionValue(cameraPosition2, "mapView.map.cameraPosition");
        b(new CameraPosition(point, floatValue, azimuth, cameraPosition2.getTilt()), z);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public AvitoMapMarker addMarker(@NotNull AvitoMapMarkerOptions avitoMapMarkerOptions) {
        Intrinsics.checkNotNullParameter(avitoMapMarkerOptions, "options");
        PlacemarkMapObject addPlacemark = this.a.addPlacemark(AvitoYandexMapKt.toPoint(avitoMapMarkerOptions.getPosition()), ImageProvider.fromBitmap(avitoMapMarkerOptions.getIcon()));
        addPlacemark.addTapListener(this.l);
        IconStyle iconStyle = new IconStyle();
        iconStyle.setAnchor(new PointF(avitoMapMarkerOptions.getAnchor().getX(), avitoMapMarkerOptions.getAnchor().getY()));
        Float zIndex = iconStyle.getZIndex();
        if (zIndex != null) {
            iconStyle.setZIndex(zIndex);
        }
        addPlacemark.setIconStyle(iconStyle);
        Intrinsics.checkNotNullExpressionValue(addPlacemark, "mapObjects.addPlacemark(…          )\n            }");
        YandexAvitoMapMarker yandexAvitoMapMarker = new YandexAvitoMapMarker(addPlacemark);
        yandexAvitoMapMarker.setData(yandexAvitoMapMarker);
        return yandexAvitoMapMarker;
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void moveTo(@NotNull AvitoMapBounds avitoMapBounds, boolean z) {
        Intrinsics.checkNotNullParameter(avitoMapBounds, "avitoMapBounds");
        CameraPosition cameraPosition = this.n.getMap().cameraPosition(AvitoYandexMapKt.toBoundingBox(avitoMapBounds));
        Intrinsics.checkNotNullExpressionValue(cameraPosition, "mapView.map.cameraPositi…apBounds.toBoundingBox())");
        b(cameraPosition, z);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public AvitoMapMarker addMarker(@NotNull AvitoMapPoint avitoMapPoint, @NotNull AvitoMapMarker.Type type, @NotNull AvitoMapMarker.Anchor anchor, @Nullable Float f2) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "avitoMapPoint");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        return addMarker(avitoMapPoint, type.getDrawableRes(), anchor, f2);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public AvitoMapMarker addMarker(@NotNull AvitoMapPoint avitoMapPoint, @Nullable Bitmap bitmap, @NotNull AvitoMapMarker.Anchor anchor, @Nullable Float f2, boolean z) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "avitoMapPoint");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        PlacemarkMapObject addPlacemark = this.a.addPlacemark(AvitoYandexMapKt.toPoint(avitoMapPoint), ImageProvider.fromBitmap(bitmap));
        addPlacemark.addTapListener(this.l);
        IconStyle iconStyle = new IconStyle();
        iconStyle.setAnchor(new PointF(anchor.getX(), anchor.getY()));
        if (f2 != null) {
            iconStyle.setZIndex(Float.valueOf(f2.floatValue()));
        }
        addPlacemark.setIconStyle(iconStyle);
        Intrinsics.checkNotNullExpressionValue(addPlacemark, "this");
        addPlacemark.setVisible(z);
        Intrinsics.checkNotNullExpressionValue(addPlacemark, "mapObjects.addPlacemark(…= isVisible\n            }");
        return new YandexAvitoMapMarker(addPlacemark);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public AvitoMapMarker addMarker(double d2, double d3, @NotNull Bitmap bitmap, @NotNull AvitoMapMarker.Anchor anchor, float f2, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(str, "imageId");
        PlacemarkMapObject addPlacemark = this.a.addPlacemark(new Point(d2, d3), new YandexAvitoMapImageProvider(bitmap, str));
        if (z) {
            addPlacemark.setVisible(false);
            addPlacemark.setVisible(true, this.j, b.a);
        }
        addPlacemark.addTapListener(this.l);
        IconStyle iconStyle = new IconStyle();
        iconStyle.setAnchor(new PointF(anchor.getX(), anchor.getY()));
        iconStyle.setZIndex(Float.valueOf(f2));
        addPlacemark.setIconStyle(iconStyle);
        Intrinsics.checkNotNullExpressionValue(addPlacemark, "mapObjects.addPlacemark(…          )\n            }");
        return new YandexAvitoMapMarker(addPlacemark);
    }
}

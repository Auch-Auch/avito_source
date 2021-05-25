package com.avito.android.avito_map.google;

import a2.g.r.g;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapMarkerOptions;
import com.avito.android.avito_map.AvitoMapMoveReason;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.AvitoMapTarget;
import com.avito.android.avito_map.AvitoMapUiSettings;
import com.avito.android.lib.util.DarkThemeManagerKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.GeoContract;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000æ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010}\u001a\u00020z\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J1\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u001aJ\u001f\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0015\u0010\u001dJ'\u0010 \u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J1\u0010'\u001a\u00020&2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\n2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b'\u0010(J\u0017\u0010'\u001a\u00020&2\u0006\u0010*\u001a\u00020)H\u0016¢\u0006\u0004\b'\u0010+J1\u0010'\u001a\u00020&2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010-\u001a\u00020,2\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b'\u0010.JG\u00104\u001a\b\u0012\u0004\u0012\u00020&0/2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u00100/2\b\u00102\u001a\u0004\u0018\u0001012\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u00132\u0006\u00103\u001a\u00020\u0004H\u0016¢\u0006\u0004\b4\u00105J;\u0010'\u001a\u00020&2\u0006\u0010\u0011\u001a\u00020\u00102\b\u00102\u001a\u0004\u0018\u0001012\u0006\u0010$\u001a\u00020#2\b\u0010%\u001a\u0004\u0018\u00010\u00132\u0006\u00103\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u00106JG\u0010'\u001a\u00020&2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u00102\u001a\u0002012\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u00132\u0006\u00108\u001a\u0002072\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u00109J\u001f\u0010;\u001a\u00020\u00062\u0006\u0010:\u001a\u00020&2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b;\u0010<J/\u0010?\u001a\u00020\u00062\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00100/2\b\u0010>\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b?\u0010@J'\u0010C\u001a\u00020\u00062\u0006\u0010A\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010B\u001a\u00020\nH\u0016¢\u0006\u0004\bC\u0010DJ\u000f\u0010F\u001a\u00020EH\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u001bH\u0016¢\u0006\u0004\bH\u0010IJ\u0019\u0010L\u001a\u0004\u0018\u00010\u00102\u0006\u0010K\u001a\u00020JH\u0016¢\u0006\u0004\bL\u0010MJ\u0017\u0010O\u001a\u00020J2\u0006\u0010N\u001a\u00020\u0010H\u0016¢\u0006\u0004\bO\u0010PJ\u000f\u0010R\u001a\u00020QH\u0016¢\u0006\u0004\bR\u0010SJ\u0019\u0010V\u001a\u00020\u00062\b\u0010U\u001a\u0004\u0018\u00010TH\u0016¢\u0006\u0004\bV\u0010WJ\u0019\u0010Y\u001a\u00020\u00062\b\u0010U\u001a\u0004\u0018\u00010XH\u0016¢\u0006\u0004\bY\u0010ZJ\u0019\u0010\\\u001a\u00020\u00062\b\u0010U\u001a\u0004\u0018\u00010[H\u0016¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020\u0006H\u0016¢\u0006\u0004\b^\u0010_J\u000f\u0010`\u001a\u00020\u0006H\u0016¢\u0006\u0004\b`\u0010_J\u0017\u0010b\u001a\u00020\u00062\u0006\u0010a\u001a\u00020EH\u0016¢\u0006\u0004\bb\u0010cJ\u000f\u0010d\u001a\u00020\u0006H\u0016¢\u0006\u0004\bd\u0010_J\u000f\u0010e\u001a\u00020\u0006H\u0016¢\u0006\u0004\be\u0010_J\u0019\u0010g\u001a\u00020\u00062\b\u0010U\u001a\u0004\u0018\u00010fH\u0016¢\u0006\u0004\bg\u0010hJ\u0019\u0010j\u001a\u00020\u00062\b\u0010U\u001a\u0004\u0018\u00010iH\u0016¢\u0006\u0004\bj\u0010kJ\u0017\u0010m\u001a\u00020\u00062\u0006\u0010l\u001a\u00020\u0013H\u0016¢\u0006\u0004\bm\u0010nJ\u0017\u0010o\u001a\u00020\u00062\u0006\u0010l\u001a\u00020\u0013H\u0016¢\u0006\u0004\bo\u0010nJ\u0017\u0010q\u001a\u00020\u00062\u0006\u0010p\u001a\u00020\u0004H\u0016¢\u0006\u0004\bq\u0010rJ/\u0010w\u001a\u00020\u00062\u0006\u0010s\u001a\u00020\n2\u0006\u0010t\u001a\u00020\n2\u0006\u0010u\u001a\u00020\n2\u0006\u0010v\u001a\u00020\nH\u0016¢\u0006\u0004\bw\u0010xJ\u000f\u0010y\u001a\u00020\u0006H\u0016¢\u0006\u0004\by\u0010_R\u0016\u0010}\u001a\u00020z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b{\u0010|R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020[0~8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0010\u0001R\u001f\u0010\u0001\u001a\u00030\u00018\u0006@\u0006¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020i0~8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020f0~8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020T0~8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020X0~8\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u0007\u0010\u0001¨\u0006\u0001"}, d2 = {"Lcom/avito/android/avito_map/google/AvitoGoogleMap;", "Lcom/avito/android/avito_map/AvitoMap;", "Lcom/google/android/gms/maps/CameraUpdate;", "updateFactory", "", "withAnimation", "", AuthSource.SEND_ABUSE, "(Lcom/google/android/gms/maps/CameraUpdate;Z)V", "Lkotlin/Pair;", "", "getSize", "()Lkotlin/Pair;", "Lcom/avito/android/avito_map/AvitoMapUiSettings;", "getUiSettings", "()Lcom/avito/android/avito_map/AvitoMapUiSettings;", "Lcom/avito/android/avito_map/AvitoMapPoint;", "avitoMapPoint", "animate", "", "zoomLevel", "moveTo", "(Lcom/avito/android/avito_map/AvitoMapPoint;ZLjava/lang/Float;)V", "", GeoContract.LATITUDE, GeoContract.LONGITUDE, "(DDZLjava/lang/Float;)V", "Lcom/avito/android/avito_map/AvitoMapBounds;", "avitoMapBounds", "(Lcom/avito/android/avito_map/AvitoMapBounds;Z)V", "Lcom/avito/android/avito_map/AvitoMap$AnimationLength;", "animationLength", "zoomTo", "(FZLcom/avito/android/avito_map/AvitoMap$AnimationLength;)V", "id", "Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;", "anchor", "zIndex", "Lcom/avito/android/avito_map/AvitoMapMarker;", "addMarker", "(Lcom/avito/android/avito_map/AvitoMapPoint;ILcom/avito/android/avito_map/AvitoMapMarker$Anchor;Ljava/lang/Float;)Lcom/avito/android/avito_map/AvitoMapMarker;", "Lcom/avito/android/avito_map/AvitoMapMarkerOptions;", "options", "(Lcom/avito/android/avito_map/AvitoMapMarkerOptions;)Lcom/avito/android/avito_map/AvitoMapMarker;", "Lcom/avito/android/avito_map/AvitoMapMarker$Type;", "type", "(Lcom/avito/android/avito_map/AvitoMapPoint;Lcom/avito/android/avito_map/AvitoMapMarker$Type;Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;Ljava/lang/Float;)Lcom/avito/android/avito_map/AvitoMapMarker;", "", "avitoMapPoints", "Landroid/graphics/Bitmap;", "bitmap", "isVisible", "addSameMarkers", "(Ljava/util/List;Landroid/graphics/Bitmap;Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;Ljava/lang/Float;Z)Ljava/util/List;", "(Lcom/avito/android/avito_map/AvitoMapPoint;Landroid/graphics/Bitmap;Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;Ljava/lang/Float;Z)Lcom/avito/android/avito_map/AvitoMapMarker;", "", "imageId", "(DDLandroid/graphics/Bitmap;Lcom/avito/android/avito_map/AvitoMapMarker$Anchor;FLjava/lang/String;Z)Lcom/avito/android/avito_map/AvitoMapMarker;", "marker", "removeMarker", "(Lcom/avito/android/avito_map/AvitoMapMarker;Z)V", "points", "zoomPadding", "moveToPointsWithPadding", "(Ljava/util/List;Ljava/lang/Integer;Z)V", "bounds", "boundsPadding", "moveToBounds", "(Lcom/avito/android/avito_map/AvitoMapBounds;ZI)V", "Lcom/avito/android/avito_map/AvitoMapTarget;", "getMapTarget", "()Lcom/avito/android/avito_map/AvitoMapTarget;", "getMapBounds", "()Lcom/avito/android/avito_map/AvitoMapBounds;", "Landroid/graphics/Point;", "point", "fromScreenLocation", "(Landroid/graphics/Point;)Lcom/avito/android/avito_map/AvitoMapPoint;", "latLng", "toScreenLocation", "(Lcom/avito/android/avito_map/AvitoMapPoint;)Landroid/graphics/Point;", "Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "getMapCameraPosition", "()Lcom/avito/android/avito_map/AvitoMapCameraPosition;", "Lcom/avito/android/avito_map/AvitoMap$MapMoveEndListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "addMoveEndListener", "(Lcom/avito/android/avito_map/AvitoMap$MapMoveEndListener;)V", "Lcom/avito/android/avito_map/AvitoMap$MapMoveStartListener;", "addMoveStartListener", "(Lcom/avito/android/avito_map/AvitoMap$MapMoveStartListener;)V", "Lcom/avito/android/avito_map/AvitoMap$MapClickListener;", "addMapClickListener", "(Lcom/avito/android/avito_map/AvitoMap$MapClickListener;)V", "clearMoveEndListeners", "()V", "clearMoveStartListeners", "target", "restoreTarget", "(Lcom/avito/android/avito_map/AvitoMapTarget;)V", "onStart", "onStop", "Lcom/avito/android/avito_map/AvitoMap$MarkerClickListener;", "addMarkerClickListener", "(Lcom/avito/android/avito_map/AvitoMap$MarkerClickListener;)V", "Lcom/avito/android/avito_map/AvitoMap$MarkerExactClickListener;", "addMarkerExactClickListener", "(Lcom/avito/android/avito_map/AvitoMap$MarkerExactClickListener;)V", "zoomPreference", "setMaxZoomPreference", "(F)V", "setMinZoomPreference", "distinct", "distinctSameMoveEvent", "(Z)V", "top", "right", "bottom", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "setPadding", "(IIII)V", "onLowMemory", "Lcom/google/android/gms/maps/GoogleMap;", "f", "Lcom/google/android/gms/maps/GoogleMap;", "map", "", "c", "Ljava/util/List;", "mapClickListeners", "Landroid/content/Context;", g.a, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context", "e", "markerExactClickListeners", "d", "markerClickListeners", AuthSource.BOOKING_ORDER, "mapMoveEndListeners", "mapMoveStartListeners", "<init>", "(Lcom/google/android/gms/maps/GoogleMap;Landroid/content/Context;)V", "avito-map_release"}, k = 1, mv = {1, 4, 2})
public final class AvitoGoogleMap implements AvitoMap {
    public final List<AvitoMap.MapMoveStartListener> a = new ArrayList();
    public final List<AvitoMap.MapMoveEndListener> b = new ArrayList();
    public final List<AvitoMap.MapClickListener> c = new ArrayList();
    public final List<AvitoMap.MarkerClickListener> d = new ArrayList();
    public final List<AvitoMap.MarkerExactClickListener> e = new ArrayList();
    public final GoogleMap f;
    @NotNull
    public final Context g;

    public static final class a implements GoogleMap.OnCameraIdleListener {
        public final /* synthetic */ AvitoGoogleMap a;

        public a(AvitoGoogleMap avitoGoogleMap) {
            this.a = avitoGoogleMap;
        }

        @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
        public final void onCameraIdle() {
            AvitoMapCameraPosition mapCameraPosition = this.a.getMapCameraPosition();
            for (AvitoMap.MapMoveEndListener mapMoveEndListener : this.a.b) {
                mapMoveEndListener.onMapSettled(mapCameraPosition);
            }
        }
    }

    public static final class b implements GoogleMap.OnCameraMoveStartedListener {
        public final /* synthetic */ AvitoGoogleMap a;

        public b(AvitoGoogleMap avitoGoogleMap) {
            this.a = avitoGoogleMap;
        }

        @Override // com.google.android.gms.maps.GoogleMap.OnCameraMoveStartedListener
        public final void onCameraMoveStarted(int i) {
            AvitoMapMoveReason avitoMapMoveReason;
            if (i == 1) {
                avitoMapMoveReason = AvitoMapMoveReason.GESTURE;
            } else if (i == 2) {
                avitoMapMoveReason = AvitoMapMoveReason.API_ANIMATION;
            } else if (i != 3) {
                avitoMapMoveReason = AvitoMapMoveReason.UNKNOWN;
            } else {
                avitoMapMoveReason = AvitoMapMoveReason.DEVELOPER_ANIMATION;
            }
            for (AvitoMap.MapMoveStartListener mapMoveStartListener : this.a.a) {
                mapMoveStartListener.onMapMoveStarted(avitoMapMoveReason);
            }
        }
    }

    public static final class c implements GoogleMap.OnMapClickListener {
        public final /* synthetic */ AvitoGoogleMap a;

        public c(AvitoGoogleMap avitoGoogleMap) {
            this.a = avitoGoogleMap;
        }

        @Override // com.google.android.gms.maps.GoogleMap.OnMapClickListener
        public final void onMapClick(LatLng latLng) {
            for (AvitoMap.MapClickListener mapClickListener : this.a.c) {
                mapClickListener.onMapClicked(new AvitoMapTarget(new AvitoMapPoint(latLng.latitude, latLng.longitude), this.a.getMapTarget().getZoomLevel()));
            }
        }
    }

    public static final class d implements GoogleMap.OnMarkerClickListener {
        public final /* synthetic */ AvitoGoogleMap a;

        public d(AvitoGoogleMap avitoGoogleMap) {
            this.a = avitoGoogleMap;
        }

        @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
        public final boolean onMarkerClick(Marker marker) {
            Intrinsics.checkNotNullExpressionValue(marker, "marker");
            Object tag = marker.getTag();
            if (tag != null) {
                Intrinsics.checkNotNullExpressionValue(tag, "marker.tag ?: return@setOnMarkerClickListener true");
                for (AvitoMap.MarkerClickListener markerClickListener : this.a.d) {
                    markerClickListener.onMarkerClicked(tag);
                }
                if (!(tag instanceof GoogleAvitoMapMarker)) {
                    tag = null;
                }
                GoogleAvitoMapMarker googleAvitoMapMarker = (GoogleAvitoMapMarker) tag;
                for (AvitoMap.MarkerExactClickListener markerExactClickListener : this.a.e) {
                    markerExactClickListener.onMarkerClicked(googleAvitoMapMarker);
                }
            }
            return true;
        }
    }

    public AvitoGoogleMap(@NotNull GoogleMap googleMap, @NotNull Context context) {
        Intrinsics.checkNotNullParameter(googleMap, "map");
        Intrinsics.checkNotNullParameter(context, "context");
        this.f = googleMap;
        this.g = context;
        getUiSettings().isDarkModeEnabled(DarkThemeManagerKt.isDarkTheme(context));
        googleMap.setOnCameraIdleListener(new a(this));
        googleMap.setOnCameraMoveStartedListener(new b(this));
        googleMap.setOnMapClickListener(new c(this));
        googleMap.setOnMarkerClickListener(new d(this));
    }

    public final void a(CameraUpdate cameraUpdate, boolean z) {
        if (z) {
            this.f.animateCamera(cameraUpdate);
        } else {
            this.f.moveCamera(cameraUpdate);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void addMapClickListener(@Nullable AvitoMap.MapClickListener mapClickListener) {
        if (mapClickListener != null) {
            this.c.add(mapClickListener);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public AvitoMapMarker addMarker(@NotNull AvitoMapPoint avitoMapPoint, int i, @NotNull AvitoMapMarker.Anchor anchor, @Nullable Float f2) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "avitoMapPoint");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.icon(BitmapDescriptorFactory.fromResource(i));
        markerOptions.position(new LatLng(avitoMapPoint.getLatitude(), avitoMapPoint.getLongitude()));
        Marker addMarker = this.f.addMarker(markerOptions);
        addMarker.setAnchor(anchor.getX(), anchor.getY());
        if (f2 != null) {
            f2.floatValue();
            addMarker.setZIndex(f2.floatValue());
        }
        Intrinsics.checkNotNullExpressionValue(addMarker, "map.addMarker(markerOpti…x(zIndex) }\n            }");
        GoogleAvitoMapMarker googleAvitoMapMarker = new GoogleAvitoMapMarker(addMarker);
        googleAvitoMapMarker.setData(googleAvitoMapMarker);
        return googleAvitoMapMarker;
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void addMarkerClickListener(@Nullable AvitoMap.MarkerClickListener markerClickListener) {
        if (markerClickListener != null) {
            this.d.add(markerClickListener);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void addMarkerExactClickListener(@Nullable AvitoMap.MarkerExactClickListener markerExactClickListener) {
        if (markerExactClickListener != null) {
            this.e.add(markerExactClickListener);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void addMoveEndListener(@Nullable AvitoMap.MapMoveEndListener mapMoveEndListener) {
        if (mapMoveEndListener != null) {
            this.b.add(mapMoveEndListener);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void addMoveStartListener(@Nullable AvitoMap.MapMoveStartListener mapMoveStartListener) {
        if (mapMoveStartListener != null) {
            this.a.add(mapMoveStartListener);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public List<AvitoMapMarker> addSameMarkers(@NotNull List<AvitoMapPoint> list, @Nullable Bitmap bitmap, @NotNull AvitoMapMarker.Anchor anchor, @Nullable Float f2, boolean z) {
        Intrinsics.checkNotNullParameter(list, "avitoMapPoints");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(addMarker(list.get(i), bitmap, anchor, f2, z));
        }
        return arrayList;
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void clearMoveEndListeners() {
        this.b.clear();
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void clearMoveStartListeners() {
        this.a.clear();
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void distinctSameMoveEvent(boolean z) {
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @Nullable
    public AvitoMapPoint fromScreenLocation(@NotNull Point point) {
        Intrinsics.checkNotNullParameter(point, "point");
        LatLng fromScreenLocation = this.f.getProjection().fromScreenLocation(point);
        Intrinsics.checkNotNullExpressionValue(fromScreenLocation, "map.projection.fromScreenLocation(point)");
        return AvitoGoogleMapKt.toAvitoMapPoint(fromScreenLocation);
    }

    @NotNull
    public final Context getContext() {
        return this.g;
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public AvitoMapBounds getMapBounds() {
        Projection projection = this.f.getProjection();
        Intrinsics.checkNotNullExpressionValue(projection, "map.projection");
        LatLngBounds latLngBounds = projection.getVisibleRegion().latLngBounds;
        Intrinsics.checkNotNullExpressionValue(latLngBounds, "map.projection.visibleRegion.latLngBounds");
        return AvitoGoogleMapKt.toAvitoMapBounds(latLngBounds);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public AvitoMapCameraPosition getMapCameraPosition() {
        return new AvitoMapCameraPosition(getMapTarget().getPoint(), getMapTarget().getZoomLevel(), this.f.getCameraPosition().tilt, null, getMapBounds(), 8, null);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public AvitoMapTarget getMapTarget() {
        CameraPosition cameraPosition = this.f.getCameraPosition();
        LatLng latLng = cameraPosition.target;
        Intrinsics.checkNotNullExpressionValue(latLng, "target");
        return new AvitoMapTarget(AvitoGoogleMapKt.toAvitoMapPoint(latLng), cameraPosition.zoom);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public Pair<Integer, Integer> getSize() {
        Projection projection = this.f.getProjection();
        Projection projection2 = this.f.getProjection();
        Intrinsics.checkNotNullExpressionValue(projection2, "map.projection");
        int i = projection.toScreenLocation(projection2.getVisibleRegion().nearRight).x;
        Projection projection3 = this.f.getProjection();
        Projection projection4 = this.f.getProjection();
        Intrinsics.checkNotNullExpressionValue(projection4, "map.projection");
        int i2 = i - projection3.toScreenLocation(projection4.getVisibleRegion().nearLeft).x;
        Projection projection5 = this.f.getProjection();
        Projection projection6 = this.f.getProjection();
        Intrinsics.checkNotNullExpressionValue(projection6, "map.projection");
        int i3 = projection5.toScreenLocation(projection6.getVisibleRegion().nearRight).y;
        Projection projection7 = this.f.getProjection();
        Projection projection8 = this.f.getProjection();
        Intrinsics.checkNotNullExpressionValue(projection8, "map.projection");
        return new Pair<>(Integer.valueOf(i2), Integer.valueOf(i3 - projection7.toScreenLocation(projection8.getVisibleRegion().farRight).y));
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public AvitoMapUiSettings getUiSettings() {
        return new GoogleAvitoMapUiSettings(this.f, this.g);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void moveTo(@NotNull AvitoMapPoint avitoMapPoint, boolean z, @Nullable Float f2) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "avitoMapPoint");
        CameraUpdate newLatLngZoom = CameraUpdateFactory.newLatLngZoom(avitoMapPoint.toLatLng(), f2 != null ? f2.floatValue() : this.f.getCameraPosition().zoom);
        Intrinsics.checkNotNullExpressionValue(newLatLngZoom, "updateFactory");
        a(newLatLngZoom, z);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void moveToBounds(@NotNull AvitoMapBounds avitoMapBounds, boolean z, int i) {
        Intrinsics.checkNotNullParameter(avitoMapBounds, "bounds");
        CameraUpdate newLatLngBounds = CameraUpdateFactory.newLatLngBounds(AvitoGoogleMapKt.toLatLngBounds(avitoMapBounds), i);
        if (z) {
            this.f.animateCamera(newLatLngBounds);
        } else {
            this.f.moveCamera(newLatLngBounds);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void moveToPointsWithPadding(@NotNull List<AvitoMapPoint> list, @Nullable Integer num, boolean z) {
        Intrinsics.checkNotNullParameter(list, "points");
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            builder.include(it.next().toLatLng());
        }
        CameraUpdate newLatLngBounds = CameraUpdateFactory.newLatLngBounds(builder.build(), num != null ? num.intValue() : 0);
        if (z) {
            this.f.animateCamera(newLatLngBounds);
        } else {
            this.f.moveCamera(newLatLngBounds);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void onLowMemory() {
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void onStart() {
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void onStop() {
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void removeMarker(@NotNull AvitoMapMarker avitoMapMarker, boolean z) {
        Marker marker;
        Intrinsics.checkNotNullParameter(avitoMapMarker, "marker");
        if (!(avitoMapMarker instanceof GoogleAvitoMapMarker)) {
            avitoMapMarker = null;
        }
        GoogleAvitoMapMarker googleAvitoMapMarker = (GoogleAvitoMapMarker) avitoMapMarker;
        if (googleAvitoMapMarker != null && (marker = googleAvitoMapMarker.getMarker()) != null) {
            marker.remove();
        }
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void restoreTarget(@NotNull AvitoMapTarget avitoMapTarget) {
        Intrinsics.checkNotNullParameter(avitoMapTarget, "target");
        moveTo(avitoMapTarget.getPoint(), false, Float.valueOf(avitoMapTarget.getZoomLevel()));
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void setMaxZoomPreference(float f2) {
        this.f.setMaxZoomPreference(f2);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void setMinZoomPreference(float f2) {
        this.f.setMinZoomPreference(f2);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void setPadding(int i, int i2, int i3, int i4) {
        this.f.setPadding(i, i2, i3, i4);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public Point toScreenLocation(@NotNull AvitoMapPoint avitoMapPoint) {
        Intrinsics.checkNotNullParameter(avitoMapPoint, "latLng");
        Point screenLocation = this.f.getProjection().toScreenLocation(avitoMapPoint.toLatLng());
        Intrinsics.checkNotNullExpressionValue(screenLocation, "map.projection.toScreenLocation(latLng.toLatLng())");
        return screenLocation;
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void zoomTo(float f2, boolean z, @NotNull AvitoMap.AnimationLength animationLength) {
        Intrinsics.checkNotNullParameter(animationLength, "animationLength");
        CameraUpdate newLatLngZoom = CameraUpdateFactory.newLatLngZoom(getMapTarget().getPoint().toLatLng(), f2);
        if (z) {
            this.f.animateCamera(newLatLngZoom);
        } else {
            this.f.moveCamera(newLatLngZoom);
        }
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void moveTo(double d2, double d3, boolean z, @Nullable Float f2) {
        CameraUpdate newLatLngZoom = CameraUpdateFactory.newLatLngZoom(new LatLng(d2, d3), f2 != null ? f2.floatValue() : this.f.getCameraPosition().zoom);
        Intrinsics.checkNotNullExpressionValue(newLatLngZoom, "updateFactory");
        a(newLatLngZoom, z);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    public void moveTo(@NotNull AvitoMapBounds avitoMapBounds, boolean z) {
        Intrinsics.checkNotNullParameter(avitoMapBounds, "avitoMapBounds");
        CameraUpdate newLatLngBounds = CameraUpdateFactory.newLatLngBounds(AvitoGoogleMapKt.toLatLngBounds(avitoMapBounds), 0);
        Intrinsics.checkNotNullExpressionValue(newLatLngBounds, "updateFactory");
        a(newLatLngBounds, z);
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public AvitoMapMarker addMarker(@NotNull AvitoMapMarkerOptions avitoMapMarkerOptions) {
        Intrinsics.checkNotNullParameter(avitoMapMarkerOptions, "options");
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(avitoMapMarkerOptions.getIcon()));
        markerOptions.position(avitoMapMarkerOptions.getPosition().toLatLng());
        Marker addMarker = this.f.addMarker(markerOptions);
        addMarker.setAnchor(avitoMapMarkerOptions.getAnchor().getX(), avitoMapMarkerOptions.getAnchor().getY());
        Intrinsics.checkNotNullExpressionValue(addMarker, "map.addMarker(markerOpti…s.anchor.y)\n            }");
        GoogleAvitoMapMarker googleAvitoMapMarker = new GoogleAvitoMapMarker(addMarker);
        googleAvitoMapMarker.setData(googleAvitoMapMarker);
        return googleAvitoMapMarker;
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
        if (bitmap == null) {
            return AvitoMap.DefaultImpls.addMarker$default(this, avitoMapPoint, AvitoMapMarker.Type.MARKER_PIN_DEFAULT, AvitoMapMarker.Anchor.BOTTOM_CENTER, (Float) null, 8, (Object) null);
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
        markerOptions.position(new LatLng(avitoMapPoint.getLatitude(), avitoMapPoint.getLongitude()));
        Marker addMarker = this.f.addMarker(markerOptions);
        addMarker.setAnchor(anchor.getX(), anchor.getY());
        if (f2 != null) {
            f2.floatValue();
            addMarker.setZIndex(f2.floatValue());
        }
        addMarker.setVisible(z);
        Intrinsics.checkNotNullExpressionValue(addMarker, "map.addMarker(markerOpti…(isVisible)\n            }");
        GoogleAvitoMapMarker googleAvitoMapMarker = new GoogleAvitoMapMarker(addMarker);
        googleAvitoMapMarker.setData(googleAvitoMapMarker);
        return googleAvitoMapMarker;
    }

    @Override // com.avito.android.avito_map.AvitoMap
    @NotNull
    public AvitoMapMarker addMarker(double d2, double d3, @NotNull Bitmap bitmap, @NotNull AvitoMapMarker.Anchor anchor, float f2, @NotNull String str, boolean z) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        Intrinsics.checkNotNullParameter(anchor, "anchor");
        Intrinsics.checkNotNullParameter(str, "imageId");
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.icon(BitmapDescriptorFactory.fromBitmap(bitmap));
        markerOptions.position(new LatLng(d2, d3));
        Marker addMarker = this.f.addMarker(markerOptions);
        addMarker.setAnchor(anchor.getX(), anchor.getY());
        addMarker.setZIndex(f2);
        Intrinsics.checkNotNullExpressionValue(addMarker, "map.addMarker(markerOpti…dex(zIndex)\n            }");
        GoogleAvitoMapMarker googleAvitoMapMarker = new GoogleAvitoMapMarker(addMarker);
        googleAvitoMapMarker.setData(googleAvitoMapMarker);
        return googleAvitoMapMarker;
    }
}

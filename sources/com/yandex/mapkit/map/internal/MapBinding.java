package com.yandex.mapkit.map.internal;

import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.mapkit.Animation;
import com.yandex.mapkit.ZoomRange;
import com.yandex.mapkit.geometry.BoundingBox;
import com.yandex.mapkit.geometry.geo.Projection;
import com.yandex.mapkit.glyphs.GlyphUrlProvider;
import com.yandex.mapkit.indoor.IndoorStateListener;
import com.yandex.mapkit.layers.GeoObjectTapListener;
import com.yandex.mapkit.layers.Layer;
import com.yandex.mapkit.layers.LayerOptions;
import com.yandex.mapkit.layers.TileFormat;
import com.yandex.mapkit.logo.Logo;
import com.yandex.mapkit.map.CameraListener;
import com.yandex.mapkit.map.CameraPosition;
import com.yandex.mapkit.map.DebugInfo;
import com.yandex.mapkit.map.IconSet;
import com.yandex.mapkit.map.InertiaMoveListener;
import com.yandex.mapkit.map.InputListener;
import com.yandex.mapkit.map.Map;
import com.yandex.mapkit.map.MapLoadedListener;
import com.yandex.mapkit.map.MapObjectCollection;
import com.yandex.mapkit.map.MapType;
import com.yandex.mapkit.map.SublayerManager;
import com.yandex.mapkit.map.VisibleRegion;
import com.yandex.mapkit.resource_url_provider.ResourceUrlProvider;
import com.yandex.mapkit.tiles.TileProvider;
import com.yandex.mapkit.tiles.UrlProvider;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.subscription.Subscription;
import java.util.List;
public class MapBinding implements Map {
    private Subscription<CameraListener> cameraListenerSubscription = new Subscription<CameraListener>() { // from class: com.yandex.mapkit.map.internal.MapBinding.5
        public NativeObject createNativeListener(CameraListener cameraListener) {
            return MapBinding.createCameraListener(cameraListener);
        }
    };
    private Subscription<GeoObjectTapListener> geoObjectTapListenerSubscription = new Subscription<GeoObjectTapListener>() { // from class: com.yandex.mapkit.map.internal.MapBinding.4
        public NativeObject createNativeListener(GeoObjectTapListener geoObjectTapListener) {
            return MapBinding.createGeoObjectTapListener(geoObjectTapListener);
        }
    };
    private Subscription<GlyphUrlProvider> glyphUrlProviderSubscription = new Subscription<GlyphUrlProvider>() { // from class: com.yandex.mapkit.map.internal.MapBinding.2
        public NativeObject createNativeListener(GlyphUrlProvider glyphUrlProvider) {
            return MapBinding.createGlyphUrlProvider(glyphUrlProvider);
        }
    };
    private Subscription<IndoorStateListener> indoorStateListenerSubscription = new Subscription<IndoorStateListener>() { // from class: com.yandex.mapkit.map.internal.MapBinding.3
        public NativeObject createNativeListener(IndoorStateListener indoorStateListener) {
            return MapBinding.createIndoorStateListener(indoorStateListener);
        }
    };
    private Subscription<InertiaMoveListener> inertiaMoveListenerSubscription = new Subscription<InertiaMoveListener>() { // from class: com.yandex.mapkit.map.internal.MapBinding.6
        public NativeObject createNativeListener(InertiaMoveListener inertiaMoveListener) {
            return MapBinding.createInertiaMoveListener(inertiaMoveListener);
        }
    };
    private Subscription<InputListener> inputListenerSubscription = new Subscription<InputListener>() { // from class: com.yandex.mapkit.map.internal.MapBinding.7
        public NativeObject createNativeListener(InputListener inputListener) {
            return MapBinding.createInputListener(inputListener);
        }
    };
    private Subscription<MapLoadedListener> mapLoadedListenerSubscription = new Subscription<MapLoadedListener>() { // from class: com.yandex.mapkit.map.internal.MapBinding.8
        public NativeObject createNativeListener(MapLoadedListener mapLoadedListener) {
            return MapBinding.createMapLoadedListener(mapLoadedListener);
        }
    };
    private final NativeObject nativeObject;
    private Subscription<Projection> projectionSubscription = new Subscription<Projection>() { // from class: com.yandex.mapkit.map.internal.MapBinding.1
        public NativeObject createNativeListener(Projection projection) {
            return MapBinding.createProjection(projection);
        }
    };
    private Subscription<ResourceUrlProvider> resourceUrlProviderSubscription = new Subscription<ResourceUrlProvider>() { // from class: com.yandex.mapkit.map.internal.MapBinding.9
        public NativeObject createNativeListener(ResourceUrlProvider resourceUrlProvider) {
            return MapBinding.createResourceUrlProvider(resourceUrlProvider);
        }
    };
    private Subscription<TileProvider> tileProviderSubscription = new Subscription<TileProvider>() { // from class: com.yandex.mapkit.map.internal.MapBinding.10
        public NativeObject createNativeListener(TileProvider tileProvider) {
            return MapBinding.createTileProvider(tileProvider);
        }
    };
    private Subscription<UrlProvider> urlProviderSubscription = new Subscription<UrlProvider>() { // from class: com.yandex.mapkit.map.internal.MapBinding.11
        public NativeObject createNativeListener(UrlProvider urlProvider) {
            return MapBinding.createUrlProvider(urlProvider);
        }
    };

    public MapBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    /* access modifiers changed from: private */
    public static native NativeObject createCameraListener(CameraListener cameraListener);

    /* access modifiers changed from: private */
    public static native NativeObject createGeoObjectTapListener(GeoObjectTapListener geoObjectTapListener);

    /* access modifiers changed from: private */
    public static native NativeObject createGlyphUrlProvider(GlyphUrlProvider glyphUrlProvider);

    /* access modifiers changed from: private */
    public static native NativeObject createIndoorStateListener(IndoorStateListener indoorStateListener);

    /* access modifiers changed from: private */
    public static native NativeObject createInertiaMoveListener(InertiaMoveListener inertiaMoveListener);

    /* access modifiers changed from: private */
    public static native NativeObject createInputListener(InputListener inputListener);

    /* access modifiers changed from: private */
    public static native NativeObject createMapLoadedListener(MapLoadedListener mapLoadedListener);

    /* access modifiers changed from: private */
    public static native NativeObject createProjection(Projection projection);

    /* access modifiers changed from: private */
    public static native NativeObject createResourceUrlProvider(ResourceUrlProvider resourceUrlProvider);

    /* access modifiers changed from: private */
    public static native NativeObject createTileProvider(TileProvider tileProvider);

    /* access modifiers changed from: private */
    public static native NativeObject createUrlProvider(UrlProvider urlProvider);

    @Override // com.yandex.mapkit.map.Map
    public native void addCameraListener(@NonNull CameraListener cameraListener);

    @Override // com.yandex.mapkit.map.Map
    @NonNull
    public native Layer addGeoJSONLayer(@NonNull String str, @NonNull String str2, @NonNull LayerOptions layerOptions, @NonNull TileProvider tileProvider, @NonNull ResourceUrlProvider resourceUrlProvider, @NonNull Projection projection, @NonNull List<ZoomRange> list);

    @Override // com.yandex.mapkit.map.Map
    @NonNull
    public native Layer addGeoJSONLayer(@NonNull String str, @NonNull String str2, @NonNull LayerOptions layerOptions, @NonNull UrlProvider urlProvider, @NonNull ResourceUrlProvider resourceUrlProvider, @NonNull Projection projection, @NonNull List<ZoomRange> list);

    @Override // com.yandex.mapkit.map.Map
    public native void addIndoorStateListener(@NonNull IndoorStateListener indoorStateListener);

    @Override // com.yandex.mapkit.map.Map
    public native void addInertiaMoveListener(@NonNull InertiaMoveListener inertiaMoveListener);

    @Override // com.yandex.mapkit.map.Map
    public native void addInputListener(@NonNull InputListener inputListener);

    @Override // com.yandex.mapkit.map.Map
    @NonNull
    public native Layer addLayer(@NonNull String str, @NonNull String str2, @NonNull LayerOptions layerOptions, @NonNull TileProvider tileProvider, @NonNull ResourceUrlProvider resourceUrlProvider, @NonNull Projection projection);

    @Override // com.yandex.mapkit.map.Map
    @NonNull
    public native Layer addLayer(@NonNull String str, @NonNull String str2, @NonNull LayerOptions layerOptions, @NonNull UrlProvider urlProvider, @NonNull ResourceUrlProvider resourceUrlProvider, @NonNull Projection projection);

    @Override // com.yandex.mapkit.map.Map
    @NonNull
    public native Layer addLayer(@NonNull String str, @NonNull String str2, @NonNull LayerOptions layerOptions, @NonNull UrlProvider urlProvider, @NonNull ResourceUrlProvider resourceUrlProvider, @NonNull ResourceUrlProvider resourceUrlProvider2, @NonNull GlyphUrlProvider glyphUrlProvider, @NonNull Projection projection, @NonNull List<ZoomRange> list);

    @Override // com.yandex.mapkit.map.Map
    @NonNull
    public native Layer addLayer(@NonNull String str, @NonNull String str2, @NonNull TileFormat tileFormat, @NonNull LayerOptions layerOptions, @NonNull UrlProvider urlProvider, @NonNull ResourceUrlProvider resourceUrlProvider, @NonNull ResourceUrlProvider resourceUrlProvider2, @NonNull ResourceUrlProvider resourceUrlProvider3, @NonNull GlyphUrlProvider glyphUrlProvider, @NonNull Projection projection, @NonNull List<ZoomRange> list);

    @Override // com.yandex.mapkit.map.Map
    @NonNull
    public native MapObjectCollection addMapObjectLayer(@NonNull String str);

    @Override // com.yandex.mapkit.map.Map
    public native void addTapListener(@NonNull GeoObjectTapListener geoObjectTapListener);

    @Override // com.yandex.mapkit.map.Map
    public native void addYandexLayerId(@NonNull String str);

    @Override // com.yandex.mapkit.map.Map
    @NonNull
    public native CameraPosition cameraPosition(@NonNull BoundingBox boundingBox);

    @Override // com.yandex.mapkit.map.Map
    public native void deselectGeoObject();

    @Override // com.yandex.mapkit.map.Map
    @NonNull
    public native CameraPosition getCameraPosition();

    @Override // com.yandex.mapkit.map.Map
    @NonNull
    public native DebugInfo getDebugInfo();

    @Override // com.yandex.mapkit.map.Map
    @NonNull
    public native IconSet getLayerIconSet();

    @Override // com.yandex.mapkit.map.Map
    @NonNull
    public native Logo getLogo();

    @Override // com.yandex.mapkit.map.Map
    @NonNull
    public native MapObjectCollection getMapObjects();

    @Override // com.yandex.mapkit.map.Map
    @NonNull
    public native MapType getMapType();

    @Override // com.yandex.mapkit.map.Map
    public native float getMaxZoom();

    @Override // com.yandex.mapkit.map.Map
    public native float getMinZoom();

    @Override // com.yandex.mapkit.map.Map
    @NonNull
    public native SublayerManager getSublayerManager();

    @Override // com.yandex.mapkit.map.Map
    @NonNull
    public native VisibleRegion getVisibleRegion();

    @Override // com.yandex.mapkit.map.Map
    public native boolean isDebugInfoEnabled();

    @Override // com.yandex.mapkit.map.Map
    public native boolean isFastTapEnabled();

    @Override // com.yandex.mapkit.map.Map
    public native boolean isIndoorEnabled();

    @Override // com.yandex.mapkit.map.Map
    public native boolean isLiteModeEnabled();

    @Override // com.yandex.mapkit.map.Map
    public native boolean isModelsEnabled();

    @Override // com.yandex.mapkit.map.Map
    public native boolean isNightModeEnabled();

    @Override // com.yandex.mapkit.map.Map
    public native boolean isRotateGesturesEnabled();

    @Override // com.yandex.mapkit.map.Map
    public native boolean isScrollGesturesEnabled();

    @Override // com.yandex.mapkit.map.Map
    public native boolean isTappableAreaRenderingEnabled();

    @Override // com.yandex.mapkit.map.Map
    public native boolean isTiltGesturesEnabled();

    @Override // com.yandex.mapkit.map.Map
    public native boolean isValid();

    @Override // com.yandex.mapkit.map.Map
    public native boolean isZoomGesturesEnabled();

    @Override // com.yandex.mapkit.map.Map
    public native void move(@NonNull CameraPosition cameraPosition);

    @Override // com.yandex.mapkit.map.Map
    public native void move(@NonNull CameraPosition cameraPosition, @NonNull Animation animation, @Nullable Map.CameraCallback cameraCallback);

    @Override // com.yandex.mapkit.map.Map
    public native void removeCameraListener(@NonNull CameraListener cameraListener);

    @Override // com.yandex.mapkit.map.Map
    public native void removeIndoorStateListener(@NonNull IndoorStateListener indoorStateListener);

    @Override // com.yandex.mapkit.map.Map
    public native void removeInertiaMoveListener(@NonNull InertiaMoveListener inertiaMoveListener);

    @Override // com.yandex.mapkit.map.Map
    public native void removeInputListener(@NonNull InputListener inputListener);

    @Override // com.yandex.mapkit.map.Map
    public native void removeTapListener(@NonNull GeoObjectTapListener geoObjectTapListener);

    @Override // com.yandex.mapkit.map.Map
    public native void resetMapStyles();

    @Override // com.yandex.mapkit.map.Map
    public native void selectGeoObject(@NonNull String str, @NonNull String str2);

    @Override // com.yandex.mapkit.map.Map
    public native void set2DMode(boolean z);

    @Override // com.yandex.mapkit.map.Map
    public native void setDebugInfoEnabled(boolean z);

    @Override // com.yandex.mapkit.map.Map
    public native void setFastTapEnabled(boolean z);

    @Override // com.yandex.mapkit.map.Map
    public native void setIndoorEnabled(boolean z);

    @Override // com.yandex.mapkit.map.Map
    public native void setLiteModeEnabled(boolean z);

    @Override // com.yandex.mapkit.map.Map
    public native void setMapLoadedListener(@Nullable MapLoadedListener mapLoadedListener);

    @Override // com.yandex.mapkit.map.Map
    public native boolean setMapStyle(int i, @NonNull String str);

    @Override // com.yandex.mapkit.map.Map
    public native boolean setMapStyle(@NonNull String str);

    @Override // com.yandex.mapkit.map.Map
    public native void setMapType(@NonNull MapType mapType);

    @Override // com.yandex.mapkit.map.Map
    public native void setModelsEnabled(boolean z);

    @Override // com.yandex.mapkit.map.Map
    public native void setNightModeEnabled(boolean z);

    @Override // com.yandex.mapkit.map.Map
    public native void setRotateGesturesEnabled(boolean z);

    @Override // com.yandex.mapkit.map.Map
    public native void setScrollGesturesEnabled(boolean z);

    @Override // com.yandex.mapkit.map.Map
    public native void setTappableAreaRenderingEnabled(boolean z);

    @Override // com.yandex.mapkit.map.Map
    public native void setTiltFunction(@NonNull List<PointF> list);

    @Override // com.yandex.mapkit.map.Map
    public native void setTiltGesturesEnabled(boolean z);

    @Override // com.yandex.mapkit.map.Map
    public native void setZoomGesturesEnabled(boolean z);

    @Override // com.yandex.mapkit.map.Map
    public native void startTileLoadMetricsCapture();

    @Override // com.yandex.mapkit.map.Map
    @NonNull
    public native String stopTileLoadMetricsCapture();

    @Override // com.yandex.mapkit.map.Map
    @NonNull
    public native VisibleRegion visibleRegion(@NonNull CameraPosition cameraPosition);
}

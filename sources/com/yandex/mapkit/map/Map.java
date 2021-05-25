package com.yandex.mapkit.map;

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
import com.yandex.mapkit.resource_url_provider.ResourceUrlProvider;
import com.yandex.mapkit.tiles.TileProvider;
import com.yandex.mapkit.tiles.UrlProvider;
import java.util.List;
public interface Map {

    public interface CameraCallback {
        void onMoveFinished(boolean z);
    }

    void addCameraListener(@NonNull CameraListener cameraListener);

    @NonNull
    Layer addGeoJSONLayer(@NonNull String str, @NonNull String str2, @NonNull LayerOptions layerOptions, @NonNull TileProvider tileProvider, @NonNull ResourceUrlProvider resourceUrlProvider, @NonNull Projection projection, @NonNull List<ZoomRange> list);

    @NonNull
    Layer addGeoJSONLayer(@NonNull String str, @NonNull String str2, @NonNull LayerOptions layerOptions, @NonNull UrlProvider urlProvider, @NonNull ResourceUrlProvider resourceUrlProvider, @NonNull Projection projection, @NonNull List<ZoomRange> list);

    void addIndoorStateListener(@NonNull IndoorStateListener indoorStateListener);

    void addInertiaMoveListener(@NonNull InertiaMoveListener inertiaMoveListener);

    void addInputListener(@NonNull InputListener inputListener);

    @NonNull
    Layer addLayer(@NonNull String str, @NonNull String str2, @NonNull LayerOptions layerOptions, @NonNull TileProvider tileProvider, @NonNull ResourceUrlProvider resourceUrlProvider, @NonNull Projection projection);

    @NonNull
    Layer addLayer(@NonNull String str, @NonNull String str2, @NonNull LayerOptions layerOptions, @NonNull UrlProvider urlProvider, @NonNull ResourceUrlProvider resourceUrlProvider, @NonNull Projection projection);

    @NonNull
    Layer addLayer(@NonNull String str, @NonNull String str2, @NonNull LayerOptions layerOptions, @NonNull UrlProvider urlProvider, @NonNull ResourceUrlProvider resourceUrlProvider, @NonNull ResourceUrlProvider resourceUrlProvider2, @NonNull GlyphUrlProvider glyphUrlProvider, @NonNull Projection projection, @NonNull List<ZoomRange> list);

    @NonNull
    Layer addLayer(@NonNull String str, @NonNull String str2, @NonNull TileFormat tileFormat, @NonNull LayerOptions layerOptions, @NonNull UrlProvider urlProvider, @NonNull ResourceUrlProvider resourceUrlProvider, @NonNull ResourceUrlProvider resourceUrlProvider2, @NonNull ResourceUrlProvider resourceUrlProvider3, @NonNull GlyphUrlProvider glyphUrlProvider, @NonNull Projection projection, @NonNull List<ZoomRange> list);

    @NonNull
    MapObjectCollection addMapObjectLayer(@NonNull String str);

    void addTapListener(@NonNull GeoObjectTapListener geoObjectTapListener);

    void addYandexLayerId(@NonNull String str);

    @NonNull
    CameraPosition cameraPosition(@NonNull BoundingBox boundingBox);

    void deselectGeoObject();

    @NonNull
    CameraPosition getCameraPosition();

    @NonNull
    DebugInfo getDebugInfo();

    @NonNull
    IconSet getLayerIconSet();

    @NonNull
    Logo getLogo();

    @NonNull
    MapObjectCollection getMapObjects();

    @NonNull
    MapType getMapType();

    float getMaxZoom();

    float getMinZoom();

    @NonNull
    SublayerManager getSublayerManager();

    @NonNull
    VisibleRegion getVisibleRegion();

    boolean isDebugInfoEnabled();

    boolean isFastTapEnabled();

    boolean isIndoorEnabled();

    boolean isLiteModeEnabled();

    boolean isModelsEnabled();

    boolean isNightModeEnabled();

    boolean isRotateGesturesEnabled();

    boolean isScrollGesturesEnabled();

    boolean isTappableAreaRenderingEnabled();

    boolean isTiltGesturesEnabled();

    boolean isValid();

    boolean isZoomGesturesEnabled();

    void move(@NonNull CameraPosition cameraPosition);

    void move(@NonNull CameraPosition cameraPosition, @NonNull Animation animation, @Nullable CameraCallback cameraCallback);

    void removeCameraListener(@NonNull CameraListener cameraListener);

    void removeIndoorStateListener(@NonNull IndoorStateListener indoorStateListener);

    void removeInertiaMoveListener(@NonNull InertiaMoveListener inertiaMoveListener);

    void removeInputListener(@NonNull InputListener inputListener);

    void removeTapListener(@NonNull GeoObjectTapListener geoObjectTapListener);

    void resetMapStyles();

    void selectGeoObject(@NonNull String str, @NonNull String str2);

    void set2DMode(boolean z);

    void setDebugInfoEnabled(boolean z);

    void setFastTapEnabled(boolean z);

    void setIndoorEnabled(boolean z);

    void setLiteModeEnabled(boolean z);

    void setMapLoadedListener(@Nullable MapLoadedListener mapLoadedListener);

    boolean setMapStyle(int i, @NonNull String str);

    boolean setMapStyle(@NonNull String str);

    void setMapType(@NonNull MapType mapType);

    void setModelsEnabled(boolean z);

    void setNightModeEnabled(boolean z);

    void setRotateGesturesEnabled(boolean z);

    void setScrollGesturesEnabled(boolean z);

    void setTappableAreaRenderingEnabled(boolean z);

    void setTiltFunction(@NonNull List<PointF> list);

    void setTiltGesturesEnabled(boolean z);

    void setZoomGesturesEnabled(boolean z);

    void startTileLoadMetricsCapture();

    @NonNull
    String stopTileLoadMetricsCapture();

    @NonNull
    VisibleRegion visibleRegion(@NonNull CameraPosition cameraPosition);
}

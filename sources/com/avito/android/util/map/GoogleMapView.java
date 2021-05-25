package com.avito.android.util.map;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\u0004J!\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0004¨\u0006\u0010"}, d2 = {"Lcom/avito/android/util/map/GoogleMapView;", "", "", "onResume", "()V", "onPause", "onDestroy", "onLowMemory", "Lcom/google/android/gms/maps/model/LatLng;", "coordinates", "", "iconResId", "Lcom/google/android/gms/maps/model/Marker;", "placeMarkerOnMap", "(Lcom/google/android/gms/maps/model/LatLng;I)Lcom/google/android/gms/maps/model/Marker;", "clearMap", "map_release"}, k = 1, mv = {1, 4, 2})
public interface GoogleMapView {
    void clearMap();

    void onDestroy();

    void onLowMemory();

    void onPause();

    void onResume();

    @Nullable
    Marker placeMarkerOnMap(@NotNull LatLng latLng, int i);
}

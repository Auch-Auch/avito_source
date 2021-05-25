package com.avito.android.util.map;

import com.avito.android.remote.auth.AuthSource;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b9\u0010\u0004J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0004J\u000f\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0004J!\u0010\f\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\nH\u0004¢\u0006\u0004\b\f\u0010\rJ\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0004¢\u0006\u0004\b\f\u0010\u0010J!\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0004JG\u0010\u001c\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u00172\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\nH\u0004¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010,\u001a\u0004\u0018\u00010\b8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u00102\u001a\u00020-8$@$X¤\u000e¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\"\u0010\u000b\u001a\u00020\n8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006:"}, d2 = {"Lcom/avito/android/util/map/AbstractGoogleMapView;", "Lcom/avito/android/util/map/GoogleMapView;", "", "onResume", "()V", "onPause", "onDestroy", "onLowMemory", "Lcom/google/android/gms/maps/model/LatLng;", "coordinates", "", "zoom", "onRestoreCoordinates", "(Lcom/google/android/gms/maps/model/LatLng;F)V", "topRight", "bottomLeft", "(Lcom/google/android/gms/maps/model/LatLng;Lcom/google/android/gms/maps/model/LatLng;)V", "", "iconResId", "Lcom/google/android/gms/maps/model/Marker;", "placeMarkerOnMap", "(Lcom/google/android/gms/maps/model/LatLng;I)Lcom/google/android/gms/maps/model/Marker;", "clearMap", "", "animate", "setDefaultZoom", "closer", "newZoom", "moveCameraInternal", "(Lcom/google/android/gms/maps/model/LatLng;ZZLjava/lang/Float;Ljava/lang/Float;)V", "Lcom/google/android/gms/maps/GoogleMap;", AuthSource.SEND_ABUSE, "Lcom/google/android/gms/maps/GoogleMap;", "getMap", "()Lcom/google/android/gms/maps/GoogleMap;", "setMap", "(Lcom/google/android/gms/maps/GoogleMap;)V", "map", AuthSource.BOOKING_ORDER, "Lcom/google/android/gms/maps/model/LatLng;", "getCameraCenterCoordinates", "()Lcom/google/android/gms/maps/model/LatLng;", "setCameraCenterCoordinates", "(Lcom/google/android/gms/maps/model/LatLng;)V", "cameraCenterCoordinates", "Lcom/google/android/gms/maps/MapView;", "getMapView", "()Lcom/google/android/gms/maps/MapView;", "setMapView", "(Lcom/google/android/gms/maps/MapView;)V", "mapView", "c", "F", "getZoom", "()F", "setZoom", "(F)V", "<init>", "map_release"}, k = 1, mv = {1, 4, 2})
public abstract class AbstractGoogleMapView implements GoogleMapView {
    @Nullable
    public GoogleMap a;
    @Nullable
    public LatLng b;
    public float c = 12.0f;

    public static final class a implements OnMapReadyCallback {
        public final /* synthetic */ LatLng a;
        public final /* synthetic */ LatLng b;
        public final /* synthetic */ int c;

        public a(LatLng latLng, LatLng latLng2, int i) {
            this.a = latLng;
            this.b = latLng2;
            this.c = i;
        }

        @Override // com.google.android.gms.maps.OnMapReadyCallback
        public final void onMapReady(GoogleMap googleMap) {
            googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds(this.a, this.b), this.c));
        }
    }

    public static /* synthetic */ void moveCameraInternal$default(AbstractGoogleMapView abstractGoogleMapView, LatLng latLng, boolean z, boolean z2, Float f, Float f2, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                latLng = null;
            }
            if ((i & 2) != 0) {
                z = true;
            }
            if ((i & 4) != 0) {
                z2 = false;
            }
            if ((i & 8) != 0) {
                f = null;
            }
            if ((i & 16) != 0) {
                f2 = null;
            }
            abstractGoogleMapView.moveCameraInternal(latLng, z, z2, f, f2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: moveCameraInternal");
    }

    @Override // com.avito.android.util.map.GoogleMapView
    public void clearMap() {
        GoogleMap googleMap = this.a;
        if (googleMap != null) {
            googleMap.clear();
        }
    }

    @Nullable
    public final LatLng getCameraCenterCoordinates() {
        return this.b;
    }

    @Nullable
    public final GoogleMap getMap() {
        return this.a;
    }

    @NotNull
    public abstract MapView getMapView();

    public final float getZoom() {
        return this.c;
    }

    public final void moveCameraInternal(@Nullable LatLng latLng, boolean z, boolean z2, @Nullable Float f, @Nullable Float f2) {
        GoogleMap googleMap = this.a;
        if (googleMap != null) {
            if (latLng == null) {
                latLng = this.b;
            }
            if (latLng != null) {
                if (z2) {
                    this.c = 12.0f;
                } else if (f != null) {
                    this.c = f.floatValue() + this.c;
                } else if (f2 != null) {
                    this.c = f2.floatValue();
                }
                CameraUpdate newLatLngZoom = CameraUpdateFactory.newLatLngZoom(latLng, this.c);
                if (z) {
                    googleMap.animateCamera(newLatLngZoom);
                } else {
                    googleMap.moveCamera(newLatLngZoom);
                }
            }
        }
    }

    @Override // com.avito.android.util.map.GoogleMapView
    public void onDestroy() {
        getMapView().onDestroy();
    }

    @Override // com.avito.android.util.map.GoogleMapView
    public void onLowMemory() {
        getMapView().onLowMemory();
    }

    @Override // com.avito.android.util.map.GoogleMapView
    public void onPause() {
        getMapView().onPause();
    }

    public final void onRestoreCoordinates(@Nullable LatLng latLng, float f) {
        this.b = latLng;
        if (f > ((float) 0)) {
            this.c = f;
        }
        moveCameraInternal$default(this, latLng, false, false, null, null, 28, null);
    }

    @Override // com.avito.android.util.map.GoogleMapView
    public void onResume() {
        getMapView().onResume();
    }

    @Override // com.avito.android.util.map.GoogleMapView
    @Nullable
    public Marker placeMarkerOnMap(@NotNull LatLng latLng, int i) {
        Intrinsics.checkNotNullParameter(latLng, "coordinates");
        GoogleMap googleMap = this.a;
        if (googleMap != null) {
            return googleMap.addMarker(new MarkerOptions().position(new LatLng(latLng.latitude, latLng.longitude)).icon(BitmapDescriptorFactory.fromResource(i)));
        }
        return null;
    }

    public final void setCameraCenterCoordinates(@Nullable LatLng latLng) {
        this.b = latLng;
    }

    public final void setMap(@Nullable GoogleMap googleMap) {
        this.a = googleMap;
    }

    public abstract void setMapView(@NotNull MapView mapView);

    public final void setZoom(float f) {
        this.c = f;
    }

    public final void onRestoreCoordinates(@NotNull LatLng latLng, @NotNull LatLng latLng2) {
        Intrinsics.checkNotNullParameter(latLng, "topRight");
        Intrinsics.checkNotNullParameter(latLng2, "bottomLeft");
        getMapView().getMapAsync(new a(latLng, latLng2, getMapView().getResources().getDimensionPixelSize(R.dimen.lat_lng_bounds_padding)));
    }
}

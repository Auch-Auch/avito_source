package com.google.maps.android;

import a2.b.a.a.a;
import android.view.View;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class MarkerManager implements GoogleMap.OnInfoWindowClickListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnMarkerDragListener, GoogleMap.InfoWindowAdapter {
    public final GoogleMap a;
    public final Map<String, Collection> b = new HashMap();
    public final Map<Marker, Collection> c = new HashMap();

    public class Collection {
        public final Set<Marker> a = new HashSet();
        public GoogleMap.OnInfoWindowClickListener b;
        public GoogleMap.OnMarkerClickListener c;
        public GoogleMap.OnMarkerDragListener d;
        public GoogleMap.InfoWindowAdapter e;

        public Collection() {
        }

        public Marker addMarker(MarkerOptions markerOptions) {
            Marker addMarker = MarkerManager.this.a.addMarker(markerOptions);
            this.a.add(addMarker);
            MarkerManager.this.c.put(addMarker, this);
            return addMarker;
        }

        public void clear() {
            for (Marker marker : this.a) {
                marker.remove();
                MarkerManager.this.c.remove(marker);
            }
            this.a.clear();
        }

        public java.util.Collection<Marker> getMarkers() {
            return Collections.unmodifiableCollection(this.a);
        }

        public boolean remove(Marker marker) {
            if (!this.a.remove(marker)) {
                return false;
            }
            MarkerManager.this.c.remove(marker);
            marker.remove();
            return true;
        }

        public void setOnInfoWindowAdapter(GoogleMap.InfoWindowAdapter infoWindowAdapter) {
            this.e = infoWindowAdapter;
        }

        public void setOnInfoWindowClickListener(GoogleMap.OnInfoWindowClickListener onInfoWindowClickListener) {
            this.b = onInfoWindowClickListener;
        }

        public void setOnMarkerClickListener(GoogleMap.OnMarkerClickListener onMarkerClickListener) {
            this.c = onMarkerClickListener;
        }

        public void setOnMarkerDragListener(GoogleMap.OnMarkerDragListener onMarkerDragListener) {
            this.d = onMarkerDragListener;
        }
    }

    public MarkerManager(GoogleMap googleMap) {
        this.a = googleMap;
    }

    public Collection getCollection(String str) {
        return this.b.get(str);
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public View getInfoContents(Marker marker) {
        GoogleMap.InfoWindowAdapter infoWindowAdapter;
        Collection collection = this.c.get(marker);
        if (collection == null || (infoWindowAdapter = collection.e) == null) {
            return null;
        }
        return infoWindowAdapter.getInfoContents(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
    public View getInfoWindow(Marker marker) {
        GoogleMap.InfoWindowAdapter infoWindowAdapter;
        Collection collection = this.c.get(marker);
        if (collection == null || (infoWindowAdapter = collection.e) == null) {
            return null;
        }
        return infoWindowAdapter.getInfoWindow(marker);
    }

    public Collection newCollection() {
        return new Collection();
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
    public void onInfoWindowClick(Marker marker) {
        GoogleMap.OnInfoWindowClickListener onInfoWindowClickListener;
        Collection collection = this.c.get(marker);
        if (collection != null && (onInfoWindowClickListener = collection.b) != null) {
            onInfoWindowClickListener.onInfoWindowClick(marker);
        }
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        GoogleMap.OnMarkerClickListener onMarkerClickListener;
        Collection collection = this.c.get(marker);
        if (collection == null || (onMarkerClickListener = collection.c) == null) {
            return false;
        }
        return onMarkerClickListener.onMarkerClick(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDrag(Marker marker) {
        GoogleMap.OnMarkerDragListener onMarkerDragListener;
        Collection collection = this.c.get(marker);
        if (collection != null && (onMarkerDragListener = collection.d) != null) {
            onMarkerDragListener.onMarkerDrag(marker);
        }
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDragEnd(Marker marker) {
        GoogleMap.OnMarkerDragListener onMarkerDragListener;
        Collection collection = this.c.get(marker);
        if (collection != null && (onMarkerDragListener = collection.d) != null) {
            onMarkerDragListener.onMarkerDragEnd(marker);
        }
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerDragListener
    public void onMarkerDragStart(Marker marker) {
        GoogleMap.OnMarkerDragListener onMarkerDragListener;
        Collection collection = this.c.get(marker);
        if (collection != null && (onMarkerDragListener = collection.d) != null) {
            onMarkerDragListener.onMarkerDragStart(marker);
        }
    }

    public boolean remove(Marker marker) {
        Collection collection = this.c.get(marker);
        return collection != null && collection.remove(marker);
    }

    public Collection newCollection(String str) {
        if (this.b.get(str) == null) {
            Collection collection = new Collection();
            this.b.put(str, collection);
            return collection;
        }
        throw new IllegalArgumentException(a.c3("collection id is not unique: ", str));
    }
}

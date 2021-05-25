package com.avito.android.avito_map.clustering;

import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapMarkerOptions;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
public class MarkerManager implements AvitoMap.MarkerExactClickListener {
    public final AvitoMap a;
    public final Map<AvitoMapMarker, Collection> b = new HashMap();

    public class Collection {
        public final Set<AvitoMapMarker> a = new HashSet();
        public AvitoMap.MarkerExactClickListener b;

        public Collection() {
        }

        public AvitoMapMarker addMarker(AvitoMapMarkerOptions avitoMapMarkerOptions) {
            AvitoMapMarker addMarker = MarkerManager.this.a.addMarker(avitoMapMarkerOptions);
            this.a.add(addMarker);
            MarkerManager.this.b.put(addMarker, this);
            return addMarker;
        }

        public void clear() {
            for (AvitoMapMarker avitoMapMarker : this.a) {
                MarkerManager.this.a.removeMarker(avitoMapMarker, false);
                MarkerManager.this.b.remove(avitoMapMarker);
            }
            this.a.clear();
        }

        public java.util.Collection<AvitoMapMarker> getMarkers() {
            return Collections.unmodifiableCollection(this.a);
        }

        public boolean remove(AvitoMapMarker avitoMapMarker) {
            if (!this.a.remove(avitoMapMarker)) {
                return false;
            }
            MarkerManager.this.b.remove(avitoMapMarker);
            MarkerManager.this.a.removeMarker(avitoMapMarker, false);
            return true;
        }

        public void setOnMarkerClickListener(AvitoMap.MarkerExactClickListener markerExactClickListener) {
            this.b = markerExactClickListener;
        }
    }

    public MarkerManager(AvitoMap avitoMap) {
        this.a = avitoMap;
    }

    @Override // com.avito.android.avito_map.AvitoMap.MarkerExactClickListener
    public boolean onMarkerClicked(AvitoMapMarker avitoMapMarker) {
        AvitoMap.MarkerExactClickListener markerExactClickListener;
        Collection collection = this.b.get(avitoMapMarker);
        return (collection == null || (markerExactClickListener = collection.b) == null || !markerExactClickListener.onMarkerClicked(avitoMapMarker)) ? false : true;
    }

    public boolean remove(AvitoMapMarker avitoMapMarker) {
        Collection collection = this.b.get(avitoMapMarker);
        return collection != null && collection.remove(avitoMapMarker);
    }
}

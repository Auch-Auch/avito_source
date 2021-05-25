package com.google.maps.android.data.geojson;

import com.google.android.gms.maps.GoogleMap;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Renderer;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
public class GeoJsonRenderer extends Renderer implements Observer {
    public GeoJsonRenderer(GoogleMap googleMap, HashMap<GeoJsonFeature, Object> hashMap) {
        super(googleMap, hashMap);
    }

    public void addFeature(GeoJsonFeature geoJsonFeature) {
        super.addFeature((Feature) geoJsonFeature);
        if (isLayerOnMap()) {
            geoJsonFeature.addObserver(this);
        }
    }

    public void addLayerToMap() {
        if (!isLayerOnMap()) {
            setLayerVisibility(true);
            Iterator<Feature> it = super.getFeatures().iterator();
            while (it.hasNext()) {
                addFeature((GeoJsonFeature) it.next());
            }
        }
    }

    public final void c(GeoJsonFeature geoJsonFeature, GoogleMap googleMap) {
        Renderer.removeFromMap(getAllFeatures().get(geoJsonFeature));
        putFeatures(geoJsonFeature, null);
        if (googleMap != null && geoJsonFeature.hasGeometry()) {
            putFeatures(geoJsonFeature, addGeoJsonFeatureToMap(geoJsonFeature, geoJsonFeature.getGeometry()));
        }
    }

    public void removeFeature(GeoJsonFeature geoJsonFeature) {
        super.removeFeature((Feature) geoJsonFeature);
        if (super.getFeatures().contains(geoJsonFeature)) {
            geoJsonFeature.deleteObserver(this);
        }
    }

    public void removeLayerFromMap() {
        if (isLayerOnMap()) {
            for (Feature feature : super.getFeatures()) {
                Renderer.removeFromMap(super.getAllFeatures().get(feature));
                feature.deleteObserver(this);
            }
            setLayerVisibility(false);
        }
    }

    @Override // com.google.maps.android.data.Renderer
    public void setMap(GoogleMap googleMap) {
        super.setMap(googleMap);
        Iterator<Feature> it = super.getFeatures().iterator();
        while (it.hasNext()) {
            c((GeoJsonFeature) it.next(), googleMap);
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (observable instanceof GeoJsonFeature) {
            GeoJsonFeature geoJsonFeature = (GeoJsonFeature) observable;
            boolean z = getAllFeatures().get(geoJsonFeature) != null;
            if (z && geoJsonFeature.hasGeometry()) {
                c(geoJsonFeature, getMap());
            } else if (z && !geoJsonFeature.hasGeometry()) {
                Renderer.removeFromMap(getAllFeatures().get(geoJsonFeature));
                putFeatures(geoJsonFeature, null);
            } else if (!z && geoJsonFeature.hasGeometry()) {
                addFeature(geoJsonFeature);
            }
        }
    }
}

package com.google.maps.android.data;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.Polyline;
import com.google.maps.android.data.geojson.GeoJsonLineStringStyle;
import com.google.maps.android.data.geojson.GeoJsonPointStyle;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;
import com.google.maps.android.data.geojson.GeoJsonRenderer;
import com.google.maps.android.data.kml.KmlContainer;
import com.google.maps.android.data.kml.KmlGroundOverlay;
import com.google.maps.android.data.kml.KmlRenderer;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParserException;
public abstract class Layer {
    public Renderer a;

    public interface OnFeatureClickListener {
        void onFeatureClick(Feature feature);
    }

    public class a implements GoogleMap.OnPolygonClickListener {
        public final /* synthetic */ OnFeatureClickListener a;

        public a(OnFeatureClickListener onFeatureClickListener) {
            this.a = onFeatureClickListener;
        }

        @Override // com.google.android.gms.maps.GoogleMap.OnPolygonClickListener
        public void onPolygonClick(Polygon polygon) {
            if (Layer.this.getFeature(polygon) != null) {
                this.a.onFeatureClick(Layer.this.getFeature(polygon));
            } else if (Layer.this.getContainerFeature(polygon) != null) {
                this.a.onFeatureClick(Layer.this.getContainerFeature(polygon));
            } else {
                OnFeatureClickListener onFeatureClickListener = this.a;
                Layer layer = Layer.this;
                onFeatureClickListener.onFeatureClick(layer.getFeature(Layer.a(layer, polygon)));
            }
        }
    }

    public class b implements GoogleMap.OnMarkerClickListener {
        public final /* synthetic */ OnFeatureClickListener a;

        public b(OnFeatureClickListener onFeatureClickListener) {
            this.a = onFeatureClickListener;
        }

        @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
        public boolean onMarkerClick(Marker marker) {
            if (Layer.this.getFeature(marker) != null) {
                this.a.onFeatureClick(Layer.this.getFeature(marker));
                return false;
            } else if (Layer.this.getContainerFeature(marker) != null) {
                this.a.onFeatureClick(Layer.this.getContainerFeature(marker));
                return false;
            } else {
                OnFeatureClickListener onFeatureClickListener = this.a;
                Layer layer = Layer.this;
                onFeatureClickListener.onFeatureClick(layer.getFeature(Layer.a(layer, marker)));
                return false;
            }
        }
    }

    public class c implements GoogleMap.OnPolylineClickListener {
        public final /* synthetic */ OnFeatureClickListener a;

        public c(OnFeatureClickListener onFeatureClickListener) {
            this.a = onFeatureClickListener;
        }

        @Override // com.google.android.gms.maps.GoogleMap.OnPolylineClickListener
        public void onPolylineClick(Polyline polyline) {
            if (Layer.this.getFeature(polyline) != null) {
                this.a.onFeatureClick(Layer.this.getFeature(polyline));
            } else if (Layer.this.getContainerFeature(polyline) != null) {
                this.a.onFeatureClick(Layer.this.getContainerFeature(polyline));
            } else {
                OnFeatureClickListener onFeatureClickListener = this.a;
                Layer layer = Layer.this;
                onFeatureClickListener.onFeatureClick(layer.getFeature(Layer.a(layer, polyline)));
            }
        }
    }

    public static ArrayList a(Layer layer, Object obj) {
        for (Object obj2 : layer.a.getValues()) {
            if (obj2.getClass().getSimpleName().equals("ArrayList")) {
                ArrayList arrayList = (ArrayList) obj2;
                if (arrayList.contains(obj)) {
                    return arrayList;
                }
            }
        }
        return null;
    }

    public void addFeature(Feature feature) {
        this.a.addFeature(feature);
    }

    public void addGeoJsonToMap() {
        Renderer renderer = this.a;
        if (renderer instanceof GeoJsonRenderer) {
            ((GeoJsonRenderer) renderer).addLayerToMap();
            return;
        }
        throw new UnsupportedOperationException("Stored renderer is not a GeoJsonRenderer");
    }

    public void addKMLToMap() throws IOException, XmlPullParserException {
        Renderer renderer = this.a;
        if (renderer instanceof KmlRenderer) {
            ((KmlRenderer) renderer).addLayerToMap();
            return;
        }
        throw new UnsupportedOperationException("Stored renderer is not a KmlRenderer");
    }

    public Feature getContainerFeature(Object obj) {
        return this.a.getContainerFeature(obj);
    }

    public Iterable<KmlContainer> getContainers() {
        Renderer renderer = this.a;
        if (renderer instanceof KmlRenderer) {
            return ((KmlRenderer) renderer).getNestedContainers();
        }
        return null;
    }

    public GeoJsonLineStringStyle getDefaultLineStringStyle() {
        return this.a.getDefaultLineStringStyle();
    }

    public GeoJsonPointStyle getDefaultPointStyle() {
        return this.a.getDefaultPointStyle();
    }

    public GeoJsonPolygonStyle getDefaultPolygonStyle() {
        return this.a.getDefaultPolygonStyle();
    }

    public Feature getFeature(Object obj) {
        return this.a.getFeature(obj);
    }

    public Iterable<? extends Feature> getFeatures() {
        return this.a.getFeatures();
    }

    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        Renderer renderer = this.a;
        if (renderer instanceof KmlRenderer) {
            return ((KmlRenderer) renderer).getGroundOverlays();
        }
        return null;
    }

    public GoogleMap getMap() {
        return this.a.getMap();
    }

    public boolean hasContainers() {
        Renderer renderer = this.a;
        if (renderer instanceof KmlRenderer) {
            return ((KmlRenderer) renderer).hasNestedContainers();
        }
        return false;
    }

    public boolean hasFeatures() {
        return this.a.hasFeatures();
    }

    public boolean isLayerOnMap() {
        return this.a.isLayerOnMap();
    }

    public void removeFeature(Feature feature) {
        this.a.removeFeature(feature);
    }

    public void removeLayerFromMap() {
        Renderer renderer = this.a;
        if (renderer instanceof GeoJsonRenderer) {
            ((GeoJsonRenderer) renderer).removeLayerFromMap();
        } else if (renderer instanceof KmlRenderer) {
            ((KmlRenderer) renderer).removeLayerFromMap();
        }
    }

    public void setMap(GoogleMap googleMap) {
        this.a.setMap(googleMap);
    }

    public void setOnFeatureClickListener(OnFeatureClickListener onFeatureClickListener) {
        GoogleMap map = getMap();
        map.setOnPolygonClickListener(new a(onFeatureClickListener));
        map.setOnMarkerClickListener(new b(onFeatureClickListener));
        map.setOnPolylineClickListener(new c(onFeatureClickListener));
    }

    public void storeRenderer(Renderer renderer) {
        this.a = renderer;
    }
}

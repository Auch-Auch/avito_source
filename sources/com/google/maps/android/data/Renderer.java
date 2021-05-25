package com.google.maps.android.data;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.R;
import com.google.maps.android.data.geojson.BiMultiMap;
import com.google.maps.android.data.geojson.GeoJsonFeature;
import com.google.maps.android.data.geojson.GeoJsonGeometryCollection;
import com.google.maps.android.data.geojson.GeoJsonLineString;
import com.google.maps.android.data.geojson.GeoJsonLineStringStyle;
import com.google.maps.android.data.geojson.GeoJsonMultiLineString;
import com.google.maps.android.data.geojson.GeoJsonMultiPoint;
import com.google.maps.android.data.geojson.GeoJsonMultiPolygon;
import com.google.maps.android.data.geojson.GeoJsonPoint;
import com.google.maps.android.data.geojson.GeoJsonPointStyle;
import com.google.maps.android.data.geojson.GeoJsonPolygon;
import com.google.maps.android.data.geojson.GeoJsonPolygonStyle;
import com.google.maps.android.data.kml.KmlContainer;
import com.google.maps.android.data.kml.KmlGroundOverlay;
import com.google.maps.android.data.kml.KmlPlacemark;
import com.google.maps.android.data.kml.KmlPolygon;
import com.google.maps.android.data.kml.KmlStyle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
public class Renderer {
    public GoogleMap a;
    public final BiMultiMap<Feature> b;
    public HashMap<String, KmlStyle> c;
    public HashMap<String, KmlStyle> d;
    public HashMap<String, String> e;
    public BiMultiMap<Feature> f;
    public HashMap<KmlGroundOverlay, GroundOverlay> g;
    public final ArrayList<String> h;
    public final LruCache<String, Bitmap> i;
    public boolean j;
    public Context k;
    public ArrayList<KmlContainer> l;
    public final GeoJsonPointStyle m;
    public final GeoJsonLineStringStyle n;
    public final GeoJsonPolygonStyle o;

    public class a implements GoogleMap.InfoWindowAdapter {
        public a() {
        }

        @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
        public View getInfoContents(Marker marker) {
            View inflate = LayoutInflater.from(Renderer.this.k).inflate(R.layout.amu_info_window, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.window);
            if (marker.getSnippet() != null) {
                textView.setText(Html.fromHtml(marker.getTitle() + "<br>" + marker.getSnippet()));
            } else {
                textView.setText(Html.fromHtml(marker.getTitle()));
            }
            return inflate;
        }

        @Override // com.google.android.gms.maps.GoogleMap.InfoWindowAdapter
        public View getInfoWindow(Marker marker) {
            return null;
        }
    }

    public Renderer(GoogleMap googleMap, Context context) {
        this.b = new BiMultiMap<>();
        this.a = googleMap;
        this.k = context;
        this.j = false;
        this.i = new LruCache<>(50);
        this.h = new ArrayList<>();
        this.d = new HashMap<>();
        this.m = null;
        this.n = null;
        this.o = null;
        this.f = new BiMultiMap<>();
    }

    public static boolean getPlacemarkVisibility(Feature feature) {
        return !feature.hasProperty(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY) || Integer.parseInt(feature.getProperty(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY)) != 0;
    }

    public static void removeFeatures(HashMap<Feature, Object> hashMap) {
        for (Object obj : hashMap.values()) {
            if (obj instanceof Marker) {
                ((Marker) obj).remove();
            } else if (obj instanceof Polyline) {
                ((Polyline) obj).remove();
            } else if (obj instanceof Polygon) {
                ((Polygon) obj).remove();
            }
        }
    }

    public static void removeFromMap(Object obj) {
        if (obj instanceof Marker) {
            ((Marker) obj).remove();
        } else if (obj instanceof Polyline) {
            ((Polyline) obj).remove();
        } else if (obj instanceof Polygon) {
            ((Polygon) obj).remove();
        } else if (obj instanceof ArrayList) {
            Iterator it = ((ArrayList) obj).iterator();
            while (it.hasNext()) {
                removeFromMap(it.next());
            }
        }
    }

    public final void a(String str, MarkerOptions markerOptions) {
        if (this.i.get(str) != null) {
            markerOptions.icon(BitmapDescriptorFactory.fromBitmap((Bitmap) this.i.get(str)));
        } else if (!this.h.contains(str)) {
            this.h.add(str);
        }
    }

    public void addFeature(Feature feature) {
        Object obj;
        if (feature instanceof GeoJsonFeature) {
            GeoJsonFeature geoJsonFeature = (GeoJsonFeature) feature;
            if (geoJsonFeature.getPointStyle() == null) {
                geoJsonFeature.setPointStyle(this.m);
            }
            if (geoJsonFeature.getLineStringStyle() == null) {
                geoJsonFeature.setLineStringStyle(this.n);
            }
            if (geoJsonFeature.getPolygonStyle() == null) {
                geoJsonFeature.setPolygonStyle(this.o);
            }
        }
        if (this.j) {
            if (this.b.containsKey(feature)) {
                removeFromMap(this.b.get(feature));
            }
            if (feature.hasGeometry()) {
                if (feature instanceof KmlPlacemark) {
                    KmlPlacemark kmlPlacemark = (KmlPlacemark) feature;
                    obj = addKmlPlacemarkToMap(kmlPlacemark, feature.getGeometry(), getPlacemarkStyle(feature.getId()), kmlPlacemark.getInlineStyle(), getPlacemarkVisibility(feature));
                } else {
                    obj = addGeoJsonFeatureToMap(feature, feature.getGeometry());
                }
                this.b.put((BiMultiMap<Feature>) feature, obj);
            }
        }
        obj = null;
        this.b.put((BiMultiMap<Feature>) feature, obj);
    }

    public Object addGeoJsonFeatureToMap(Feature feature, Geometry geometry) {
        String geometryType = geometry.getGeometryType();
        geometryType.hashCode();
        char c2 = 65535;
        switch (geometryType.hashCode()) {
            case -2116761119:
                if (geometryType.equals("MultiPolygon")) {
                    c2 = 0;
                    break;
                }
                break;
            case -1065891849:
                if (geometryType.equals("MultiPoint")) {
                    c2 = 1;
                    break;
                }
                break;
            case -627102946:
                if (geometryType.equals("MultiLineString")) {
                    c2 = 2;
                    break;
                }
                break;
            case 77292912:
                if (geometryType.equals("Point")) {
                    c2 = 3;
                    break;
                }
                break;
            case 1267133722:
                if (geometryType.equals(KmlPolygon.GEOMETRY_TYPE)) {
                    c2 = 4;
                    break;
                }
                break;
            case 1806700869:
                if (geometryType.equals("LineString")) {
                    c2 = 5;
                    break;
                }
                break;
            case 1950410960:
                if (geometryType.equals("GeometryCollection")) {
                    c2 = 6;
                    break;
                }
                break;
        }
        MarkerOptions markerOptions = null;
        PolylineOptions polylineOptions = null;
        PolygonOptions polygonOptions = null;
        switch (c2) {
            case 0:
                GeoJsonPolygonStyle polygonStyle = ((GeoJsonFeature) feature).getPolygonStyle();
                ArrayList arrayList = new ArrayList();
                for (GeoJsonPolygon geoJsonPolygon : ((GeoJsonMultiPolygon) geometry).getPolygons()) {
                    arrayList.add(addPolygonToMap(polygonStyle.toPolygonOptions(), geoJsonPolygon));
                }
                return arrayList;
            case 1:
                GeoJsonPointStyle pointStyle = ((GeoJsonFeature) feature).getPointStyle();
                ArrayList arrayList2 = new ArrayList();
                for (GeoJsonPoint geoJsonPoint : ((GeoJsonMultiPoint) geometry).getPoints()) {
                    arrayList2.add(addPointToMap(pointStyle.toMarkerOptions(), geoJsonPoint));
                }
                return arrayList2;
            case 2:
                GeoJsonLineStringStyle lineStringStyle = ((GeoJsonFeature) feature).getLineStringStyle();
                ArrayList arrayList3 = new ArrayList();
                for (GeoJsonLineString geoJsonLineString : ((GeoJsonMultiLineString) geometry).getLineStrings()) {
                    arrayList3.add(addLineStringToMap(lineStringStyle.toPolylineOptions(), geoJsonLineString));
                }
                return arrayList3;
            case 3:
                if (feature instanceof GeoJsonFeature) {
                    markerOptions = ((GeoJsonFeature) feature).getMarkerOptions();
                } else if (feature instanceof KmlPlacemark) {
                    markerOptions = ((KmlPlacemark) feature).getMarkerOptions();
                }
                return addPointToMap(markerOptions, (GeoJsonPoint) geometry);
            case 4:
                if (feature instanceof GeoJsonFeature) {
                    polygonOptions = ((GeoJsonFeature) feature).getPolygonOptions();
                } else if (feature instanceof KmlPlacemark) {
                    polygonOptions = ((KmlPlacemark) feature).getPolygonOptions();
                }
                return addPolygonToMap(polygonOptions, (DataPolygon) geometry);
            case 5:
                if (feature instanceof GeoJsonFeature) {
                    polylineOptions = ((GeoJsonFeature) feature).getPolylineOptions();
                } else if (feature instanceof KmlPlacemark) {
                    polylineOptions = ((KmlPlacemark) feature).getPolylineOptions();
                }
                return addLineStringToMap(polylineOptions, (GeoJsonLineString) geometry);
            case 6:
                GeoJsonFeature geoJsonFeature = (GeoJsonFeature) feature;
                List<Geometry> geometries = ((GeoJsonGeometryCollection) geometry).getGeometries();
                ArrayList arrayList4 = new ArrayList();
                for (Geometry geometry2 : geometries) {
                    arrayList4.add(addGeoJsonFeatureToMap(geoJsonFeature, geometry2));
                }
                return arrayList4;
            default:
                return null;
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (r0.equals("Point") == false) goto L_0x0023;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object addKmlPlacemarkToMap(com.google.maps.android.data.kml.KmlPlacemark r9, com.google.maps.android.data.Geometry r10, com.google.maps.android.data.kml.KmlStyle r11, com.google.maps.android.data.kml.KmlStyle r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 582
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.data.Renderer.addKmlPlacemarkToMap(com.google.maps.android.data.kml.KmlPlacemark, com.google.maps.android.data.Geometry, com.google.maps.android.data.kml.KmlStyle, com.google.maps.android.data.kml.KmlStyle, boolean):java.lang.Object");
    }

    public Polyline addLineStringToMap(PolylineOptions polylineOptions, LineString lineString) {
        polylineOptions.addAll(lineString.getGeometryObject());
        Polyline addPolyline = this.a.addPolyline(polylineOptions);
        addPolyline.setClickable(true);
        return addPolyline;
    }

    public Marker addPointToMap(MarkerOptions markerOptions, Point point) {
        markerOptions.position(point.getGeometryObject());
        return this.a.addMarker(markerOptions);
    }

    public Polygon addPolygonToMap(PolygonOptions polygonOptions, DataPolygon dataPolygon) {
        polygonOptions.addAll(dataPolygon.getOuterBoundaryCoordinates());
        for (List<LatLng> list : dataPolygon.getInnerBoundaryCoordinates()) {
            polygonOptions.addHole(list);
        }
        Polygon addPolygon = this.a.addPolygon(polygonOptions);
        addPolygon.setClickable(true);
        return addPolygon;
    }

    public void assignStyleMap(HashMap<String, String> hashMap, HashMap<String, KmlStyle> hashMap2) {
        for (String str : hashMap.keySet()) {
            String str2 = hashMap.get(str);
            if (hashMap2.containsKey(str2)) {
                hashMap2.put(str, hashMap2.get(str2));
            }
        }
    }

    public GroundOverlay attachGroundOverlay(GroundOverlayOptions groundOverlayOptions) {
        return this.a.addGroundOverlay(groundOverlayOptions);
    }

    public final void b() {
        this.a.setInfoWindowAdapter(new a());
    }

    public void clearStylesRenderer() {
        this.d.clear();
    }

    public HashMap<? extends Feature, Object> getAllFeatures() {
        return this.b;
    }

    public Feature getContainerFeature(Object obj) {
        BiMultiMap<Feature> biMultiMap = this.f;
        if (biMultiMap != null) {
            return biMultiMap.getKey(obj);
        }
        return null;
    }

    public ArrayList<KmlContainer> getContainerList() {
        return this.l;
    }

    public GeoJsonLineStringStyle getDefaultLineStringStyle() {
        return this.n;
    }

    public GeoJsonPointStyle getDefaultPointStyle() {
        return this.m;
    }

    public GeoJsonPolygonStyle getDefaultPolygonStyle() {
        return this.o;
    }

    public Feature getFeature(Object obj) {
        return this.b.getKey(obj);
    }

    public Set<Feature> getFeatures() {
        return this.b.keySet();
    }

    public HashMap<KmlGroundOverlay, GroundOverlay> getGroundOverlayMap() {
        return this.g;
    }

    public LruCache<String, Bitmap> getImagesCache() {
        return this.i;
    }

    public GoogleMap getMap() {
        return this.a;
    }

    public ArrayList<String> getMarkerIconUrls() {
        return this.h;
    }

    public KmlStyle getPlacemarkStyle(String str) {
        return this.d.get(str) != null ? this.d.get(str) : this.d.get(null);
    }

    public HashMap<String, String> getStyleMaps() {
        return this.e;
    }

    public HashMap<String, KmlStyle> getStylesRenderer() {
        return this.d;
    }

    public Collection<Object> getValues() {
        return this.b.values();
    }

    public boolean hasFeatures() {
        return this.b.size() > 0;
    }

    public boolean isLayerOnMap() {
        return this.j;
    }

    public void putContainerFeature(Object obj, Feature feature) {
        this.f.put((BiMultiMap<Feature>) feature, obj);
    }

    public void putFeatures(Feature feature, Object obj) {
        this.b.put((BiMultiMap<Feature>) feature, obj);
    }

    public void putImagesCache(String str, Bitmap bitmap) {
        this.i.put(str, bitmap);
    }

    public void putStyles() {
        this.d.putAll(this.c);
    }

    public void removeFeature(Feature feature) {
        if (this.b.containsKey(feature)) {
            removeFromMap(this.b.remove(feature));
        }
    }

    public void setLayerVisibility(boolean z) {
        this.j = z;
    }

    public void setMap(GoogleMap googleMap) {
        this.a = googleMap;
    }

    public void storeData(HashMap<String, KmlStyle> hashMap, HashMap<String, String> hashMap2, HashMap<KmlPlacemark, Object> hashMap3, ArrayList<KmlContainer> arrayList, HashMap<KmlGroundOverlay, GroundOverlay> hashMap4) {
        this.c = hashMap;
        this.e = hashMap2;
        this.b.putAll(hashMap3);
        this.l = arrayList;
        this.g = hashMap4;
    }

    public void putStyles(HashMap<String, KmlStyle> hashMap) {
        this.d.putAll(hashMap);
    }

    public Renderer(GoogleMap googleMap, HashMap<? extends Feature, Object> hashMap) {
        BiMultiMap<Feature> biMultiMap = new BiMultiMap<>();
        this.b = biMultiMap;
        this.a = googleMap;
        biMultiMap.putAll(hashMap);
        this.j = false;
        this.h = null;
        this.m = new GeoJsonPointStyle();
        this.n = new GeoJsonLineStringStyle();
        this.o = new GeoJsonPolygonStyle();
        this.i = null;
        this.f = null;
    }
}

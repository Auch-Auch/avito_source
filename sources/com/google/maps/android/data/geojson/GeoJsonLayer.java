package com.google.maps.android.data.geojson;

import a2.j.g.a.a.a.a;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Layer;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;
public class GeoJsonLayer extends Layer {
    public LatLngBounds b;

    public interface GeoJsonOnFeatureClickListener extends Layer.OnFeatureClickListener {
    }

    public GeoJsonLayer(GoogleMap googleMap, JSONObject jSONObject) {
        if (jSONObject != null) {
            this.b = null;
            a aVar = new a(jSONObject);
            this.b = aVar.c;
            HashMap hashMap = new HashMap();
            Iterator<GeoJsonFeature> it = aVar.b.iterator();
            while (it.hasNext()) {
                hashMap.put(it.next(), null);
            }
            storeRenderer(new GeoJsonRenderer(googleMap, hashMap));
            return;
        }
        throw new IllegalArgumentException("GeoJSON file cannot be null");
    }

    public void addFeature(GeoJsonFeature geoJsonFeature) {
        if (geoJsonFeature != null) {
            super.addFeature((Feature) geoJsonFeature);
            return;
        }
        throw new IllegalArgumentException("Feature cannot be null");
    }

    public void addLayerToMap() {
        super.addGeoJsonToMap();
    }

    public LatLngBounds getBoundingBox() {
        return this.b;
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.Iterable<? extends com.google.maps.android.data.Feature>, java.lang.Iterable<com.google.maps.android.data.geojson.GeoJsonFeature> */
    @Override // com.google.maps.android.data.Layer
    public Iterable<GeoJsonFeature> getFeatures() {
        return super.getFeatures();
    }

    public void removeFeature(GeoJsonFeature geoJsonFeature) {
        if (geoJsonFeature != null) {
            super.removeFeature((Feature) geoJsonFeature);
            return;
        }
        throw new IllegalArgumentException("Feature cannot be null");
    }

    public String toString() {
        return "Collection{\n Bounding box=" + this.b + "\n}\n";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public GeoJsonLayer(com.google.android.gms.maps.GoogleMap r3, int r4, android.content.Context r5) throws java.io.IOException, org.json.JSONException {
        /*
            r2 = this;
            android.content.res.Resources r5 = r5.getResources()
            java.io.InputStream r4 = r5.openRawResource(r4)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.io.BufferedReader r0 = new java.io.BufferedReader
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            r1.<init>(r4)
            r0.<init>(r1)
        L_0x0017:
            java.lang.String r4 = r0.readLine()
            if (r4 == 0) goto L_0x0021
            r5.append(r4)
            goto L_0x0017
        L_0x0021:
            r0.close()
            org.json.JSONObject r4 = new org.json.JSONObject
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            r2.<init>(r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.maps.android.data.geojson.GeoJsonLayer.<init>(com.google.android.gms.maps.GoogleMap, int, android.content.Context):void");
    }
}

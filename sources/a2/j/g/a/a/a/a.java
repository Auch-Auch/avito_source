package a2.j.g.a.a.a;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.maps.android.data.Geometry;
import com.google.maps.android.data.geojson.GeoJsonFeature;
import com.google.maps.android.data.geojson.GeoJsonGeometryCollection;
import com.google.maps.android.data.geojson.GeoJsonLineString;
import com.google.maps.android.data.geojson.GeoJsonMultiLineString;
import com.google.maps.android.data.geojson.GeoJsonMultiPoint;
import com.google.maps.android.data.geojson.GeoJsonMultiPolygon;
import com.google.maps.android.data.geojson.GeoJsonPoint;
import com.google.maps.android.data.geojson.GeoJsonPolygon;
import com.google.maps.android.data.kml.KmlPolygon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public class a {
    public final JSONObject a;
    public final ArrayList<GeoJsonFeature> b;
    public LatLngBounds c = null;

    public a(JSONObject jSONObject) {
        this.a = jSONObject;
        ArrayList<GeoJsonFeature> arrayList = new ArrayList<>();
        this.b = arrayList;
        GeoJsonFeature geoJsonFeature = null;
        try {
            String string = jSONObject.getString("type");
            if (string.equals("Feature")) {
                GeoJsonFeature f = f(jSONObject);
                if (f != null) {
                    arrayList.add(f);
                }
            } else if (string.equals("FeatureCollection")) {
                arrayList.addAll(g(jSONObject));
            } else if (string.matches("Point|MultiPoint|LineString|MultiLineString|Polygon|MultiPolygon|GeometryCollection")) {
                Geometry h = h(jSONObject);
                geoJsonFeature = h != null ? new GeoJsonFeature(h, null, new HashMap(), null) : geoJsonFeature;
                if (geoJsonFeature != null) {
                    arrayList.add(geoJsonFeature);
                }
            }
        } catch (JSONException unused) {
        }
    }

    public static Geometry a(String str, JSONArray jSONArray) throws JSONException {
        if (str.equals("Point")) {
            return b(jSONArray);
        }
        int i = 0;
        if (str.equals("MultiPoint")) {
            ArrayList arrayList = new ArrayList();
            while (i < jSONArray.length()) {
                arrayList.add(b(jSONArray.getJSONArray(i)));
                i++;
            }
            return new GeoJsonMultiPoint(arrayList);
        } else if (str.equals("LineString")) {
            return new GeoJsonLineString(e(jSONArray));
        } else {
            if (str.equals("MultiLineString")) {
                ArrayList arrayList2 = new ArrayList();
                while (i < jSONArray.length()) {
                    arrayList2.add(new GeoJsonLineString(e(jSONArray.getJSONArray(i))));
                    i++;
                }
                return new GeoJsonMultiLineString(arrayList2);
            } else if (str.equals(KmlPolygon.GEOMETRY_TYPE)) {
                return c(jSONArray);
            } else {
                if (str.equals("MultiPolygon")) {
                    ArrayList arrayList3 = new ArrayList();
                    while (i < jSONArray.length()) {
                        arrayList3.add(c(jSONArray.getJSONArray(i)));
                        i++;
                    }
                    return new GeoJsonMultiPolygon(arrayList3);
                } else if (!str.equals("GeometryCollection")) {
                    return null;
                } else {
                    ArrayList arrayList4 = new ArrayList();
                    while (i < jSONArray.length()) {
                        Geometry h = h(jSONArray.getJSONObject(i));
                        if (h != null) {
                            arrayList4.add(h);
                        }
                        i++;
                    }
                    return new GeoJsonGeometryCollection(arrayList4);
                }
            }
        }
    }

    public static GeoJsonPoint b(JSONArray jSONArray) throws JSONException {
        return new GeoJsonPoint(new LatLng(jSONArray.getDouble(1), jSONArray.getDouble(0)));
    }

    public static GeoJsonPolygon c(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(e(jSONArray.getJSONArray(i)));
        }
        return new GeoJsonPolygon(arrayList);
    }

    public static LatLngBounds d(JSONArray jSONArray) throws JSONException {
        return new LatLngBounds(new LatLng(jSONArray.getDouble(1), jSONArray.getDouble(0)), new LatLng(jSONArray.getDouble(3), jSONArray.getDouble(2)));
    }

    public static ArrayList<LatLng> e(JSONArray jSONArray) throws JSONException {
        ArrayList<LatLng> arrayList = new ArrayList<>();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONArray jSONArray2 = jSONArray.getJSONArray(i);
            arrayList.add(new LatLng(jSONArray2.getDouble(1), jSONArray2.getDouble(0)));
        }
        return arrayList;
    }

    public static GeoJsonFeature f(JSONObject jSONObject) {
        HashMap hashMap = new HashMap();
        try {
            String string = jSONObject.has("id") ? jSONObject.getString("id") : null;
            LatLngBounds d = jSONObject.has("bbox") ? d(jSONObject.getJSONArray("bbox")) : null;
            Geometry h = (!jSONObject.has("geometry") || jSONObject.isNull("geometry")) ? null : h(jSONObject.getJSONObject("geometry"));
            if (jSONObject.has("properties") && !jSONObject.isNull("properties")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("properties");
                hashMap = new HashMap();
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject2.isNull(next) ? null : jSONObject2.getString(next));
                }
            }
            return new GeoJsonFeature(h, string, hashMap, d);
        } catch (JSONException unused) {
            jSONObject.toString();
            return null;
        }
    }

    public static Geometry h(JSONObject jSONObject) {
        JSONArray jSONArray;
        try {
            String string = jSONObject.getString("type");
            if (string.equals("GeometryCollection")) {
                jSONArray = jSONObject.getJSONArray("geometries");
            } else if (!string.matches("Point|MultiPoint|LineString|MultiLineString|Polygon|MultiPolygon|GeometryCollection")) {
                return null;
            } else {
                jSONArray = jSONObject.getJSONArray("coordinates");
            }
            return a(string, jSONArray);
        } catch (JSONException unused) {
            return null;
        }
    }

    public final ArrayList<GeoJsonFeature> g(JSONObject jSONObject) {
        GeoJsonFeature f;
        ArrayList<GeoJsonFeature> arrayList = new ArrayList<>();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("features");
            if (jSONObject.has("bbox")) {
                this.c = d(jSONObject.getJSONArray("bbox"));
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    if (jSONObject2.getString("type").equals("Feature") && (f = f(jSONObject2)) != null) {
                        arrayList.add(f);
                    }
                } catch (JSONException unused) {
                }
            }
        } catch (JSONException unused2) {
        }
        return arrayList;
    }
}

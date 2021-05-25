package com.google.maps.android.data.kml;

import a2.j.g.a.a.b.a;
import android.content.Context;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.maps.android.data.Layer;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
public class KmlLayer extends Layer {
    public KmlLayer(GoogleMap googleMap, int i, Context context) throws XmlPullParserException, IOException {
        this(googleMap, context.getResources().openRawResource(i), context);
    }

    public void addLayerToMap() throws IOException, XmlPullParserException {
        super.addKMLToMap();
    }

    @Override // com.google.maps.android.data.Layer
    public Iterable<KmlContainer> getContainers() {
        return super.getContainers();
    }

    @Override // com.google.maps.android.data.Layer
    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        return super.getGroundOverlays();
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: java.lang.Iterable<? extends com.google.maps.android.data.Feature>, java.lang.Iterable<com.google.maps.android.data.kml.KmlPlacemark> */
    public Iterable<KmlPlacemark> getPlacemarks() {
        return getFeatures();
    }

    @Override // com.google.maps.android.data.Layer
    public boolean hasContainers() {
        return super.hasContainers();
    }

    public boolean hasPlacemarks() {
        return hasFeatures();
    }

    public KmlLayer(GoogleMap googleMap, InputStream inputStream, Context context) throws XmlPullParserException, IOException {
        if (inputStream != null) {
            KmlRenderer kmlRenderer = new KmlRenderer(googleMap, context);
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setNamespaceAware(true);
            XmlPullParser newPullParser = newInstance.newPullParser();
            newPullParser.setInput(inputStream, null);
            HashMap<KmlPlacemark, Object> hashMap = new HashMap<>();
            ArrayList<KmlContainer> arrayList = new ArrayList<>();
            HashMap<String, KmlStyle> hashMap2 = new HashMap<>();
            HashMap<String, String> hashMap3 = new HashMap<>();
            HashMap<KmlGroundOverlay, GroundOverlay> hashMap4 = new HashMap<>();
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2) {
                    if (newPullParser.getName().matches("altitude|altitudeModeGroup|altitudeMode|begin|bottomFov|cookie|displayName|displayMode|displayMode|end|expires|extrude|flyToView|gridOrigin|httpQuery|leftFov|linkDescription|linkName|linkSnippet|listItemType|maxSnippetLines|maxSessionLength|message|minAltitude|minFadeExtent|minLodPixels|minRefreshPeriod|maxAltitude|maxFadeExtent|maxLodPixels|maxHeight|maxWidth|near|NetworkLink|NetworkLinkControl|overlayXY|range|refreshMode|refreshInterval|refreshVisibility|rightFov|roll|rotationXY|screenXY|shape|sourceHref|state|targetHref|tessellate|tileSize|topFov|viewBoundScale|viewFormat|viewRefreshMode|viewRefreshTime|when")) {
                        a.a(newPullParser);
                    }
                    if (newPullParser.getName().matches("Folder|Document")) {
                        arrayList.add(AppCompatDelegateImpl.i.j(newPullParser));
                    }
                    if (newPullParser.getName().equals("Style")) {
                        KmlStyle Y = AppCompatDelegateImpl.i.Y(newPullParser);
                        hashMap2.put(Y.g, Y);
                    }
                    if (newPullParser.getName().equals("StyleMap")) {
                        hashMap3.putAll(AppCompatDelegateImpl.i.Z(newPullParser));
                    }
                    if (newPullParser.getName().equals("Placemark")) {
                        hashMap.put(AppCompatDelegateImpl.i.X(newPullParser), null);
                    }
                    if (newPullParser.getName().equals("GroundOverlay")) {
                        hashMap4.put(AppCompatDelegateImpl.i.W(newPullParser), null);
                    }
                }
            }
            hashMap2.put(null, new KmlStyle());
            inputStream.close();
            kmlRenderer.storeData(hashMap2, hashMap3, hashMap, arrayList, hashMap4);
            storeRenderer(kmlRenderer);
            return;
        }
        throw new IllegalArgumentException("KML InputStream cannot be null");
    }
}

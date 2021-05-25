package com.google.maps.android.data.kml;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlay;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.data.Feature;
import com.google.maps.android.data.Geometry;
import com.google.maps.android.data.Renderer;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
public class KmlRenderer extends Renderer {
    public final ArrayList<String> p = new ArrayList<>();
    public boolean q = false;
    public boolean r = false;
    public HashMap<KmlGroundOverlay, GroundOverlay> s;
    public ArrayList<KmlContainer> t;

    public class a extends AsyncTask<String, Void, Bitmap> {
        public final String a;

        public a(String str) {
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(String[] strArr) {
            try {
                return BitmapFactory.decodeStream((InputStream) new URL(this.a).getContent());
            } catch (MalformedURLException unused) {
                return BitmapFactory.decodeFile(this.a);
            } catch (IOException unused2) {
                return null;
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                KmlRenderer.this.putImagesCache(this.a, bitmap2);
                if (KmlRenderer.this.isLayerOnMap()) {
                    KmlRenderer kmlRenderer = KmlRenderer.this;
                    kmlRenderer.f(this.a, kmlRenderer.s, true);
                    KmlRenderer kmlRenderer2 = KmlRenderer.this;
                    kmlRenderer2.e(this.a, kmlRenderer2.t, true);
                }
            }
        }
    }

    public class b extends AsyncTask<String, Void, Bitmap> {
        public final String a;

        public b(String str) {
            this.a = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // android.os.AsyncTask
        public Bitmap doInBackground(String[] strArr) {
            try {
                return BitmapFactory.decodeStream((InputStream) new URL(this.a).getContent());
            } catch (MalformedURLException unused) {
                return BitmapFactory.decodeFile(this.a);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r3v4, resolved type: com.google.maps.android.data.kml.KmlRenderer */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.AsyncTask
        public void onPostExecute(Bitmap bitmap) {
            Bitmap bitmap2 = bitmap;
            if (bitmap2 != null) {
                KmlRenderer.this.putImagesCache(this.a, bitmap2);
                if (KmlRenderer.this.isLayerOnMap()) {
                    KmlRenderer kmlRenderer = KmlRenderer.this;
                    kmlRenderer.i(this.a, kmlRenderer.getAllFeatures());
                    KmlRenderer kmlRenderer2 = KmlRenderer.this;
                    kmlRenderer2.c(this.a, kmlRenderer2.t);
                }
            }
        }
    }

    public KmlRenderer(GoogleMap googleMap, Context context) {
        super(googleMap, context);
    }

    public static boolean j(KmlContainer kmlContainer, boolean z) {
        boolean z2 = !kmlContainer.hasProperty(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY) || Integer.parseInt(kmlContainer.getProperty(ViewHierarchyConstants.DIMENSION_VISIBILITY_KEY)) != 0;
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    public void addLayerToMap() {
        setLayerVisibility(true);
        this.s = getGroundOverlayMap();
        this.t = getContainerList();
        putStyles();
        assignStyleMap(getStyleMaps(), getStylesRenderer());
        h(this.s, this.t);
        d(this.t, true);
        for (Feature feature : getAllFeatures().keySet()) {
            addFeature(feature);
        }
        if (!this.r) {
            this.r = true;
            Iterator<String> it = this.p.iterator();
            while (it.hasNext()) {
                new a(it.next()).execute(new String[0]);
                it.remove();
            }
        }
        if (!this.q) {
            this.q = true;
            Iterator<String> it2 = getMarkerIconUrls().iterator();
            while (it2.hasNext()) {
                new b(it2.next()).execute(new String[0]);
                it2.remove();
            }
        }
    }

    public final void c(String str, Iterable<KmlContainer> iterable) {
        for (KmlContainer kmlContainer : iterable) {
            i(str, kmlContainer.b);
            if (kmlContainer.hasContainers()) {
                c(str, kmlContainer.getContainers());
            }
        }
    }

    public final void d(Iterable<KmlContainer> iterable, boolean z) {
        for (KmlContainer kmlContainer : iterable) {
            boolean j = j(kmlContainer, z);
            HashMap<String, KmlStyle> hashMap = kmlContainer.f;
            if (hashMap != null) {
                putStyles(hashMap);
            }
            HashMap<String, String> hashMap2 = kmlContainer.e;
            if (hashMap2 != null) {
                super.assignStyleMap(hashMap2, getStylesRenderer());
            }
            for (KmlPlacemark kmlPlacemark : kmlContainer.getPlacemarks()) {
                boolean z2 = j && Renderer.getPlacemarkVisibility(kmlPlacemark);
                if (kmlPlacemark.getGeometry() != null) {
                    String id = kmlPlacemark.getId();
                    Geometry geometry = kmlPlacemark.getGeometry();
                    KmlStyle placemarkStyle = getPlacemarkStyle(id);
                    KmlPlacemark kmlPlacemark2 = kmlPlacemark;
                    Object addKmlPlacemarkToMap = addKmlPlacemarkToMap(kmlPlacemark2, geometry, placemarkStyle, kmlPlacemark2.getInlineStyle(), z2);
                    kmlContainer.b.put(kmlPlacemark2, addKmlPlacemarkToMap);
                    putContainerFeature(addKmlPlacemarkToMap, kmlPlacemark);
                }
            }
            if (kmlContainer.hasContainers()) {
                d(kmlContainer.getContainers(), j);
            }
        }
    }

    public final void e(String str, Iterable<KmlContainer> iterable, boolean z) {
        for (KmlContainer kmlContainer : iterable) {
            boolean j = j(kmlContainer, z);
            f(str, kmlContainer.d, j);
            if (kmlContainer.hasContainers()) {
                e(str, kmlContainer.getContainers(), j);
            }
        }
    }

    public final void f(String str, HashMap<KmlGroundOverlay, GroundOverlay> hashMap, boolean z) {
        BitmapDescriptor fromBitmap = BitmapDescriptorFactory.fromBitmap((Bitmap) getImagesCache().get(str));
        for (KmlGroundOverlay kmlGroundOverlay : hashMap.keySet()) {
            if (kmlGroundOverlay.getImageUrl().equals(str)) {
                GroundOverlay attachGroundOverlay = attachGroundOverlay(kmlGroundOverlay.b.image(fromBitmap));
                if (!z) {
                    attachGroundOverlay.setVisible(false);
                }
                hashMap.put(kmlGroundOverlay, attachGroundOverlay);
            }
        }
    }

    public final void g(HashMap<KmlGroundOverlay, GroundOverlay> hashMap) {
        for (KmlGroundOverlay kmlGroundOverlay : hashMap.keySet()) {
            String imageUrl = kmlGroundOverlay.getImageUrl();
            if (!(imageUrl == null || kmlGroundOverlay.getLatLngBox() == null)) {
                if (getImagesCache().get(imageUrl) != null) {
                    f(imageUrl, this.s, true);
                } else if (!this.p.contains(imageUrl)) {
                    this.p.add(imageUrl);
                }
            }
        }
    }

    public Iterable<KmlGroundOverlay> getGroundOverlays() {
        return this.s.keySet();
    }

    public Iterable<KmlContainer> getNestedContainers() {
        return this.t;
    }

    public final void h(HashMap<KmlGroundOverlay, GroundOverlay> hashMap, Iterable<KmlContainer> iterable) {
        g(hashMap);
        for (KmlContainer kmlContainer : iterable) {
            h(kmlContainer.d, kmlContainer.getContainers());
        }
    }

    public boolean hasNestedContainers() {
        return this.t.size() > 0;
    }

    public final void i(String str, HashMap<KmlPlacemark, Object> hashMap) {
        for (KmlPlacemark kmlPlacemark : hashMap.keySet()) {
            KmlStyle kmlStyle = getStylesRenderer().get(kmlPlacemark.getId());
            KmlPlacemark kmlPlacemark2 = kmlPlacemark;
            KmlStyle inlineStyle = kmlPlacemark2.getInlineStyle();
            if ("Point".equals(kmlPlacemark.getGeometry().getGeometryType())) {
                boolean z = true;
                boolean z2 = inlineStyle != null && str.equals(inlineStyle.getIconUrl());
                if (kmlStyle == null || !str.equals(kmlStyle.getIconUrl())) {
                    z = false;
                }
                if (z2) {
                    m(inlineStyle, hashMap, kmlPlacemark2);
                } else if (z) {
                    m(kmlStyle, hashMap, kmlPlacemark2);
                }
            }
        }
    }

    public final void k(Iterable<KmlContainer> iterable) {
        for (KmlContainer kmlContainer : iterable) {
            Renderer.removeFeatures(kmlContainer.b);
            l(kmlContainer.d);
            k(kmlContainer.getContainers());
        }
    }

    public final void l(HashMap<KmlGroundOverlay, GroundOverlay> hashMap) {
        for (GroundOverlay groundOverlay : hashMap.values()) {
            groundOverlay.remove();
        }
    }

    public final void m(KmlStyle kmlStyle, HashMap<KmlPlacemark, Object> hashMap, KmlPlacemark kmlPlacemark) {
        double d = kmlStyle.f;
        Bitmap bitmap = (Bitmap) getImagesCache().get(kmlStyle.getIconUrl());
        Double valueOf = Double.valueOf(d);
        ((Marker) hashMap.get(kmlPlacemark)).setIcon(BitmapDescriptorFactory.fromBitmap(Bitmap.createScaledBitmap(bitmap, (int) (valueOf.doubleValue() * ((double) bitmap.getWidth())), (int) (valueOf.doubleValue() * ((double) bitmap.getHeight())), false)));
    }

    public void removeLayerFromMap() {
        Renderer.removeFeatures(getAllFeatures());
        l(this.s);
        if (hasNestedContainers()) {
            k(getNestedContainers());
        }
        setLayerVisibility(false);
        clearStylesRenderer();
    }

    @Override // com.google.maps.android.data.Renderer
    public void setMap(GoogleMap googleMap) {
        removeLayerFromMap();
        super.setMap(googleMap);
        addLayerToMap();
    }
}

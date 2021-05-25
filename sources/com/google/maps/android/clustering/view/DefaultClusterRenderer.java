package com.google.maps.android.clustering.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.util.SparseArray;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.MarkerManager;
import com.google.maps.android.R;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.geometry.Point;
import com.google.maps.android.projection.SphericalMercatorProjection;
import com.google.maps.android.ui.IconGenerator;
import com.google.maps.android.ui.SquareTextView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class DefaultClusterRenderer<T extends ClusterItem> implements ClusterRenderer<T> {
    public static final int[] t = {10, 20, 50, 100, 200, 500, 1000};
    public static final TimeInterpolator u = new DecelerateInterpolator();
    public final GoogleMap a;
    public final IconGenerator b;
    public final ClusterManager<T> c;
    public final float d;
    public boolean e;
    public ShapeDrawable f;
    public Set<i> g = Collections.newSetFromMap(new ConcurrentHashMap());
    public SparseArray<BitmapDescriptor> h = new SparseArray<>();
    public g<T> i = new g<>(null);
    public int j = 4;
    public Set<? extends Cluster<T>> k;
    public Map<Marker, Cluster<T>> l = new HashMap();
    public Map<Cluster<T>, Marker> m = new HashMap();
    public float n;
    public final DefaultClusterRenderer<T>.k o = new k(null);
    public ClusterManager.OnClusterClickListener<T> p;
    public ClusterManager.OnClusterInfoWindowClickListener<T> q;
    public ClusterManager.OnClusterItemClickListener<T> r;
    public ClusterManager.OnClusterItemInfoWindowClickListener<T> s;

    public class a implements GoogleMap.OnMarkerClickListener {
        public a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.maps.android.clustering.ClusterManager$OnClusterItemClickListener<T extends com.google.maps.android.clustering.ClusterItem> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
        public boolean onMarkerClick(Marker marker) {
            DefaultClusterRenderer defaultClusterRenderer = DefaultClusterRenderer.this;
            ClusterManager.OnClusterItemClickListener<T> onClusterItemClickListener = defaultClusterRenderer.r;
            return onClusterItemClickListener != 0 && onClusterItemClickListener.onClusterItemClick(defaultClusterRenderer.i.b.get(marker));
        }
    }

    public class b implements GoogleMap.OnInfoWindowClickListener {
        public b() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.google.maps.android.clustering.ClusterManager$OnClusterItemInfoWindowClickListener<T extends com.google.maps.android.clustering.ClusterItem> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
        public void onInfoWindowClick(Marker marker) {
            DefaultClusterRenderer defaultClusterRenderer = DefaultClusterRenderer.this;
            ClusterManager.OnClusterItemInfoWindowClickListener<T> onClusterItemInfoWindowClickListener = defaultClusterRenderer.s;
            if (onClusterItemInfoWindowClickListener != 0) {
                onClusterItemInfoWindowClickListener.onClusterItemInfoWindowClick(defaultClusterRenderer.i.b.get(marker));
            }
        }
    }

    public class c implements GoogleMap.OnMarkerClickListener {
        public c() {
        }

        @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
        public boolean onMarkerClick(Marker marker) {
            DefaultClusterRenderer defaultClusterRenderer = DefaultClusterRenderer.this;
            ClusterManager.OnClusterClickListener<T> onClusterClickListener = defaultClusterRenderer.p;
            return onClusterClickListener != null && onClusterClickListener.onClusterClick(defaultClusterRenderer.l.get(marker));
        }
    }

    public class d implements GoogleMap.OnInfoWindowClickListener {
        public d() {
        }

        @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
        public void onInfoWindowClick(Marker marker) {
            DefaultClusterRenderer defaultClusterRenderer = DefaultClusterRenderer.this;
            ClusterManager.OnClusterInfoWindowClickListener<T> onClusterInfoWindowClickListener = defaultClusterRenderer.q;
            if (onClusterInfoWindowClickListener != null) {
                onClusterInfoWindowClickListener.onClusterInfoWindowClick(defaultClusterRenderer.l.get(marker));
            }
        }
    }

    @TargetApi(12)
    public class e extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
        public final i a;
        public final Marker b;
        public final LatLng c;
        public final LatLng d;
        public boolean e;
        public MarkerManager f;

        public e(i iVar, LatLng latLng, LatLng latLng2, a aVar) {
            this.a = iVar;
            this.b = iVar.a;
            this.c = latLng;
            this.d = latLng2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.e) {
                DefaultClusterRenderer.this.m.remove(DefaultClusterRenderer.this.l.get(this.b));
                g<T> gVar = DefaultClusterRenderer.this.i;
                Marker marker = this.b;
                T t = gVar.b.get(marker);
                gVar.b.remove(marker);
                gVar.a.remove(t);
                DefaultClusterRenderer.this.l.remove(this.b);
                this.f.remove(this.b);
            }
            this.a.b = this.d;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float animatedFraction = valueAnimator.getAnimatedFraction();
            LatLng latLng = this.d;
            double d2 = latLng.latitude;
            LatLng latLng2 = this.c;
            double d3 = latLng2.latitude;
            double d4 = (double) animatedFraction;
            double d5 = ((d2 - d3) * d4) + d3;
            double d6 = latLng.longitude - latLng2.longitude;
            if (Math.abs(d6) > 180.0d) {
                d6 -= Math.signum(d6) * 360.0d;
            }
            this.b.setPosition(new LatLng(d5, (d6 * d4) + this.c.longitude));
        }
    }

    public class f {
        public final Cluster<T> a;
        public final Set<i> b;
        public final LatLng c;

        public f(Cluster<T> cluster, Set<i> set, LatLng latLng) {
            this.a = cluster;
            this.b = set;
            this.c = latLng;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.google.maps.android.clustering.view.DefaultClusterRenderer */
        /* JADX DEBUG: Multi-variable search result rejected for r8v1, resolved type: com.google.maps.android.clustering.view.DefaultClusterRenderer */
        /* JADX DEBUG: Multi-variable search result rejected for r2v5, resolved type: com.google.maps.android.clustering.view.DefaultClusterRenderer */
        /* JADX DEBUG: Multi-variable search result rejected for r2v10, resolved type: java.util.Map<com.google.android.gms.maps.model.Marker, com.google.maps.android.clustering.Cluster<T extends com.google.maps.android.clustering.ClusterItem>> */
        /* JADX DEBUG: Multi-variable search result rejected for r2v12, resolved type: java.util.Map<com.google.maps.android.clustering.Cluster<T extends com.google.maps.android.clustering.ClusterItem>, com.google.android.gms.maps.model.Marker> */
        /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.google.maps.android.clustering.view.DefaultClusterRenderer */
        /* JADX DEBUG: Multi-variable search result rejected for r4v4, resolved type: com.google.maps.android.clustering.view.DefaultClusterRenderer */
        /* JADX WARN: Multi-variable type inference failed */
        public static void a(f fVar, h hVar) {
            i iVar;
            i iVar2;
            if (!DefaultClusterRenderer.this.shouldRenderAsCluster(fVar.a)) {
                for (T t : fVar.a.getItems()) {
                    Marker marker = DefaultClusterRenderer.this.i.a.get(t);
                    if (marker == null) {
                        MarkerOptions markerOptions = new MarkerOptions();
                        LatLng latLng = fVar.c;
                        if (latLng != null) {
                            markerOptions.position(latLng);
                        } else {
                            markerOptions.position(t.getPosition());
                        }
                        if (t.getTitle() != null && t.getSnippet() != null) {
                            markerOptions.title(t.getTitle());
                            markerOptions.snippet(t.getSnippet());
                        } else if (t.getSnippet() != null) {
                            markerOptions.title(t.getSnippet());
                        } else if (t.getTitle() != null) {
                            markerOptions.title(t.getTitle());
                        }
                        DefaultClusterRenderer.this.onBeforeClusterItemRendered(t, markerOptions);
                        marker = DefaultClusterRenderer.this.c.getMarkerCollection().addMarker(markerOptions);
                        iVar2 = new i(marker, null);
                        g<T> gVar = DefaultClusterRenderer.this.i;
                        gVar.a.put(t, marker);
                        gVar.b.put(marker, t);
                        LatLng latLng2 = fVar.c;
                        if (latLng2 != null) {
                            hVar.b(iVar2, latLng2, t.getPosition());
                        }
                    } else {
                        iVar2 = new i(marker, null);
                    }
                    DefaultClusterRenderer.this.onClusterItemRendered(t, marker);
                    fVar.b.add(iVar2);
                }
                return;
            }
            Marker marker2 = DefaultClusterRenderer.this.m.get(fVar.a);
            if (marker2 == null) {
                MarkerOptions markerOptions2 = new MarkerOptions();
                LatLng latLng3 = fVar.c;
                if (latLng3 == null) {
                    latLng3 = fVar.a.getPosition();
                }
                MarkerOptions position = markerOptions2.position(latLng3);
                DefaultClusterRenderer.this.onBeforeClusterRendered(fVar.a, position);
                marker2 = DefaultClusterRenderer.this.c.getClusterMarkerCollection().addMarker(position);
                DefaultClusterRenderer.this.l.put(marker2, fVar.a);
                DefaultClusterRenderer.this.m.put(fVar.a, marker2);
                iVar = new i(marker2, null);
                LatLng latLng4 = fVar.c;
                if (latLng4 != null) {
                    hVar.b(iVar, latLng4, fVar.a.getPosition());
                }
            } else {
                iVar = new i(marker2, null);
            }
            DefaultClusterRenderer.this.onClusterRendered(fVar.a, marker2);
            fVar.b.add(iVar);
        }
    }

    public static class g<T> {
        public Map<T, Marker> a = new HashMap();
        public Map<Marker, T> b = new HashMap();

        public g(a aVar) {
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class h extends Handler implements MessageQueue.IdleHandler {
        public final Lock a;
        public final Condition b;
        public Queue<DefaultClusterRenderer<T>.f> c = new LinkedList();
        public Queue<DefaultClusterRenderer<T>.f> d = new LinkedList();
        public Queue<Marker> e = new LinkedList();
        public Queue<Marker> f = new LinkedList();
        public Queue<DefaultClusterRenderer<T>.e> g = new LinkedList();
        public boolean h;

        public h(a aVar) {
            super(Looper.getMainLooper());
            ReentrantLock reentrantLock = new ReentrantLock();
            this.a = reentrantLock;
            this.b = reentrantLock.newCondition();
        }

        public void a(boolean z, DefaultClusterRenderer<T>.f fVar) {
            this.a.lock();
            sendEmptyMessage(0);
            if (z) {
                this.d.add(fVar);
            } else {
                this.c.add(fVar);
            }
            this.a.unlock();
        }

        public void b(i iVar, LatLng latLng, LatLng latLng2) {
            this.a.lock();
            this.g.add(new e(iVar, latLng, latLng2, null));
            this.a.unlock();
        }

        public boolean c() {
            try {
                this.a.lock();
                return !this.c.isEmpty() || !this.d.isEmpty() || !this.f.isEmpty() || !this.e.isEmpty() || !this.g.isEmpty();
            } finally {
                this.a.unlock();
            }
        }

        @TargetApi(11)
        public final void d() {
            if (!this.f.isEmpty()) {
                f(this.f.poll());
            } else if (!this.g.isEmpty()) {
                DefaultClusterRenderer<T>.e poll = this.g.poll();
                Objects.requireNonNull(poll);
                ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
                ofFloat.setInterpolator(DefaultClusterRenderer.u);
                ofFloat.addUpdateListener(poll);
                ofFloat.addListener(poll);
                ofFloat.start();
            } else if (!this.d.isEmpty()) {
                f.a(this.d.poll(), this);
            } else if (!this.c.isEmpty()) {
                f.a(this.c.poll(), this);
            } else if (!this.e.isEmpty()) {
                f(this.e.poll());
            }
        }

        public void e(boolean z, Marker marker) {
            this.a.lock();
            sendEmptyMessage(0);
            if (z) {
                this.f.add(marker);
            } else {
                this.e.add(marker);
            }
            this.a.unlock();
        }

        public final void f(Marker marker) {
            DefaultClusterRenderer.this.m.remove(DefaultClusterRenderer.this.l.get(marker));
            g<T> gVar = DefaultClusterRenderer.this.i;
            T t = gVar.b.get(marker);
            gVar.b.remove(marker);
            gVar.a.remove(t);
            DefaultClusterRenderer.this.l.remove(marker);
            DefaultClusterRenderer.this.c.getMarkerManager().remove(marker);
        }

        public void g() {
            while (c()) {
                sendEmptyMessage(0);
                this.a.lock();
                try {
                    if (c()) {
                        this.b.await();
                    }
                    this.a.unlock();
                } catch (InterruptedException e2) {
                    throw new RuntimeException(e2);
                } catch (Throwable th) {
                    this.a.unlock();
                    throw th;
                }
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (!this.h) {
                Looper.myQueue().addIdleHandler(this);
                this.h = true;
            }
            removeMessages(0);
            this.a.lock();
            for (int i2 = 0; i2 < 10; i2++) {
                try {
                    d();
                } catch (Throwable th) {
                    this.a.unlock();
                    throw th;
                }
            }
            if (!c()) {
                this.h = false;
                Looper.myQueue().removeIdleHandler(this);
                this.b.signalAll();
            } else {
                sendEmptyMessageDelayed(0, 10);
            }
            this.a.unlock();
        }

        @Override // android.os.MessageQueue.IdleHandler
        public boolean queueIdle() {
            sendEmptyMessage(0);
            return true;
        }
    }

    public static class i {
        public final Marker a;
        public LatLng b;

        public i(Marker marker, a aVar) {
            this.a = marker;
            this.b = marker.getPosition();
        }

        public boolean equals(Object obj) {
            if (obj instanceof i) {
                return this.a.equals(((i) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public class j implements Runnable {
        public final Set<? extends Cluster<T>> a;
        public Runnable b;
        public Projection c;
        public SphericalMercatorProjection d;
        public float e;

        public j(Set set, a aVar) {
            this.a = set;
        }

        /* JADX DEBUG: Type inference failed for r3v3. Raw type applied. Possible types: java.util.Set<? extends com.google.maps.android.clustering.Cluster<T>>, java.util.Set<? extends com.google.maps.android.clustering.Cluster<T extends com.google.maps.android.clustering.ClusterItem>> */
        @Override // java.lang.Runnable
        @SuppressLint({"NewApi"})
        public void run() {
            ArrayList arrayList;
            if (this.a.equals(DefaultClusterRenderer.this.k)) {
                this.b.run();
                return;
            }
            h hVar = new h(null);
            float f2 = this.e;
            DefaultClusterRenderer defaultClusterRenderer = DefaultClusterRenderer.this;
            float f3 = defaultClusterRenderer.n;
            boolean z = f2 > f3;
            float f4 = f2 - f3;
            Set<i> set = defaultClusterRenderer.g;
            LatLngBounds latLngBounds = this.c.getVisibleRegion().latLngBounds;
            if (DefaultClusterRenderer.this.k != null) {
                int[] iArr = DefaultClusterRenderer.t;
                arrayList = new ArrayList();
                for (Cluster<T> cluster : DefaultClusterRenderer.this.k) {
                    if (DefaultClusterRenderer.this.shouldRenderAsCluster(cluster) && latLngBounds.contains(cluster.getPosition())) {
                        arrayList.add(this.d.toPoint(cluster.getPosition()));
                    }
                }
            } else {
                arrayList = null;
            }
            Set<i> newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
            Iterator<? extends Cluster<T>> it = this.a.iterator();
            while (it.hasNext()) {
                Cluster cluster2 = (Cluster) it.next();
                boolean contains = latLngBounds.contains(cluster2.getPosition());
                if (!z || !contains) {
                    hVar.a(contains, new f(cluster2, newSetFromMap, null));
                } else {
                    int[] iArr2 = DefaultClusterRenderer.t;
                    Point a3 = DefaultClusterRenderer.a(arrayList, this.d.toPoint(cluster2.getPosition()));
                    if (a3 == null || !DefaultClusterRenderer.this.e) {
                        hVar.a(true, new f(cluster2, newSetFromMap, null));
                    } else {
                        hVar.a(true, new f(cluster2, newSetFromMap, this.d.toLatLng(a3)));
                    }
                }
            }
            hVar.g();
            set.removeAll(newSetFromMap);
            int[] iArr3 = DefaultClusterRenderer.t;
            ArrayList arrayList2 = new ArrayList();
            Iterator<? extends Cluster<T>> it2 = this.a.iterator();
            while (it2.hasNext()) {
                Cluster<T> cluster3 = (Cluster) it2.next();
                if (DefaultClusterRenderer.this.shouldRenderAsCluster(cluster3) && latLngBounds.contains(cluster3.getPosition())) {
                    arrayList2.add(this.d.toPoint(cluster3.getPosition()));
                }
            }
            for (i iVar : set) {
                boolean contains2 = latLngBounds.contains(iVar.b);
                if (z || f4 <= -3.0f || !contains2) {
                    hVar.e(contains2, iVar.a);
                } else {
                    int[] iArr4 = DefaultClusterRenderer.t;
                    Point a4 = DefaultClusterRenderer.a(arrayList2, this.d.toPoint(iVar.b));
                    if (a4 == null || !DefaultClusterRenderer.this.e) {
                        hVar.e(true, iVar.a);
                    } else {
                        LatLng latLng = this.d.toLatLng(a4);
                        LatLng latLng2 = iVar.b;
                        hVar.a.lock();
                        DefaultClusterRenderer<T>.e eVar = new e(iVar, latLng2, latLng, null);
                        eVar.f = DefaultClusterRenderer.this.c.getMarkerManager();
                        eVar.e = true;
                        hVar.g.add(eVar);
                        hVar.a.unlock();
                    }
                }
            }
            hVar.g();
            DefaultClusterRenderer defaultClusterRenderer2 = DefaultClusterRenderer.this;
            defaultClusterRenderer2.g = newSetFromMap;
            defaultClusterRenderer2.k = (Set<? extends Cluster<T>>) this.a;
            defaultClusterRenderer2.n = f2;
            this.b.run();
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class k extends Handler {
        public boolean a = false;
        public DefaultClusterRenderer<T>.j b = null;

        public class a implements Runnable {
            public a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                k.this.sendEmptyMessage(1);
            }
        }

        public k(a aVar) {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            DefaultClusterRenderer<T>.j jVar;
            if (message.what == 1) {
                this.a = false;
                if (this.b != null) {
                    sendEmptyMessage(0);
                    return;
                }
                return;
            }
            removeMessages(0);
            if (!this.a && this.b != null) {
                Projection projection = DefaultClusterRenderer.this.a.getProjection();
                synchronized (this) {
                    jVar = this.b;
                    this.b = null;
                    this.a = true;
                }
                jVar.b = new a();
                jVar.c = projection;
                float f = DefaultClusterRenderer.this.a.getCameraPosition().zoom;
                jVar.e = f;
                jVar.d = new SphericalMercatorProjection(Math.pow(2.0d, (double) Math.min(f, DefaultClusterRenderer.this.n)) * 256.0d);
                new Thread(jVar).start();
            }
        }
    }

    public DefaultClusterRenderer(Context context, GoogleMap googleMap, ClusterManager<T> clusterManager) {
        this.a = googleMap;
        this.e = true;
        float f2 = context.getResources().getDisplayMetrics().density;
        this.d = f2;
        IconGenerator iconGenerator = new IconGenerator(context);
        this.b = iconGenerator;
        SquareTextView squareTextView = new SquareTextView(context);
        squareTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        squareTextView.setId(R.id.amu_text);
        int i2 = (int) (12.0f * f2);
        squareTextView.setPadding(i2, i2, i2, i2);
        iconGenerator.setContentView(squareTextView);
        iconGenerator.setTextAppearance(R.style.amu_ClusterIcon_TextAppearance);
        this.f = new ShapeDrawable(new OvalShape());
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(-2130706433);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, this.f});
        int i3 = (int) (f2 * 3.0f);
        layerDrawable.setLayerInset(1, i3, i3, i3, i3);
        iconGenerator.setBackground(layerDrawable);
        this.c = clusterManager;
    }

    public static Point a(List list, Point point) {
        Point point2 = null;
        if (list != null && !list.isEmpty()) {
            double d2 = 10000.0d;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Point point3 = (Point) it.next();
                double d3 = point3.x - point.x;
                double d4 = point3.y - point.y;
                double d5 = (d3 * d3) + (d4 * d4);
                if (d5 < d2) {
                    point2 = point3;
                    d2 = d5;
                }
            }
        }
        return point2;
    }

    public int getBucket(Cluster<T> cluster) {
        int size = cluster.getSize();
        int i2 = 0;
        if (size <= t[0]) {
            return size;
        }
        while (true) {
            int[] iArr = t;
            if (i2 >= iArr.length - 1) {
                return iArr[iArr.length - 1];
            }
            int i3 = i2 + 1;
            if (size < iArr[i3]) {
                return iArr[i2];
            }
            i2 = i3;
        }
    }

    public Cluster<T> getCluster(Marker marker) {
        return this.l.get(marker);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.google.maps.android.clustering.ClusterItem, T extends com.google.maps.android.clustering.ClusterItem] */
    public T getClusterItem(Marker marker) {
        return this.i.b.get(marker);
    }

    public String getClusterText(int i2) {
        if (i2 < t[0]) {
            return String.valueOf(i2);
        }
        return String.valueOf(i2) + "+";
    }

    public int getColor(int i2) {
        float min = 300.0f - Math.min((float) i2, 300.0f);
        return Color.HSVToColor(new float[]{((min * min) / 90000.0f) * 220.0f, 1.0f, 0.6f});
    }

    public Marker getMarker(T t2) {
        return this.i.a.get(t2);
    }

    public int getMinClusterSize() {
        return this.j;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void onAdd() {
        this.c.getMarkerCollection().setOnMarkerClickListener(new a());
        this.c.getMarkerCollection().setOnInfoWindowClickListener(new b());
        this.c.getClusterMarkerCollection().setOnMarkerClickListener(new c());
        this.c.getClusterMarkerCollection().setOnInfoWindowClickListener(new d());
    }

    public void onBeforeClusterItemRendered(T t2, MarkerOptions markerOptions) {
    }

    public void onBeforeClusterRendered(Cluster<T> cluster, MarkerOptions markerOptions) {
        int bucket = getBucket(cluster);
        BitmapDescriptor bitmapDescriptor = this.h.get(bucket);
        if (bitmapDescriptor == null) {
            this.f.getPaint().setColor(getColor(bucket));
            bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(this.b.makeIcon(getClusterText(bucket)));
            this.h.put(bucket, bitmapDescriptor);
        }
        markerOptions.icon(bitmapDescriptor);
    }

    public void onClusterItemRendered(T t2, Marker marker) {
    }

    public void onClusterRendered(Cluster<T> cluster, Marker marker) {
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void onClustersChanged(Set<? extends Cluster<T>> set) {
        DefaultClusterRenderer<T>.k kVar = this.o;
        synchronized (kVar) {
            kVar.b = new j(set, null);
        }
        kVar.sendEmptyMessage(0);
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void onRemove() {
        this.c.getMarkerCollection().setOnMarkerClickListener(null);
        this.c.getMarkerCollection().setOnInfoWindowClickListener(null);
        this.c.getClusterMarkerCollection().setOnMarkerClickListener(null);
        this.c.getClusterMarkerCollection().setOnInfoWindowClickListener(null);
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setAnimation(boolean z) {
        this.e = z;
    }

    public void setMinClusterSize(int i2) {
        this.j = i2;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setOnClusterClickListener(ClusterManager.OnClusterClickListener<T> onClusterClickListener) {
        this.p = onClusterClickListener;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setOnClusterInfoWindowClickListener(ClusterManager.OnClusterInfoWindowClickListener<T> onClusterInfoWindowClickListener) {
        this.q = onClusterInfoWindowClickListener;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setOnClusterItemClickListener(ClusterManager.OnClusterItemClickListener<T> onClusterItemClickListener) {
        this.r = onClusterItemClickListener;
    }

    @Override // com.google.maps.android.clustering.view.ClusterRenderer
    public void setOnClusterItemInfoWindowClickListener(ClusterManager.OnClusterItemInfoWindowClickListener<T> onClusterItemInfoWindowClickListener) {
        this.s = onClusterItemInfoWindowClickListener;
    }

    public boolean shouldRenderAsCluster(Cluster<T> cluster) {
        return cluster.getSize() > this.j;
    }

    public Marker getMarker(Cluster<T> cluster) {
        return this.m.get(cluster);
    }
}

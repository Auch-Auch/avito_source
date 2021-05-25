package com.avito.android.avito_map.clustering.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
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
import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapBounds;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.AvitoMapMarkerOptions;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.avito_map.clustering.Cluster;
import com.avito.android.avito_map.clustering.ClusterItem;
import com.avito.android.avito_map.clustering.ClusterManager;
import com.google.maps.android.R;
import com.google.maps.android.ui.IconGenerator;
import com.google.maps.android.ui.SquareTextView;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class DefaultClusterRenderer<T extends ClusterItem> implements ClusterRenderer<T> {
    public static final int[] p = {10, 20, 50, 100, 200, 500, 1000};
    public final AvitoMap a;
    public final IconGenerator b;
    public final ClusterManager<T> c;
    public final float d;
    public ShapeDrawable e;
    public Set<f> f = Collections.newSetFromMap(new ConcurrentHashMap());
    public SparseArray<Bitmap> g = new SparseArray<>();
    public d<T> h = new d<>(null);
    public int i = 4;
    public Set<? extends Cluster<T>> j;
    public Map<AvitoMapMarker, Cluster<T>> k = new HashMap();
    public Map<Cluster<T>, AvitoMapMarker> l = new HashMap();
    public final DefaultClusterRenderer<T>.h m = new h(null);
    public ClusterManager.OnClusterClickListener<T> n;
    public ClusterManager.OnClusterItemClickListener<T> o;

    public class a implements AvitoMap.MarkerExactClickListener {
        public a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.avito.android.avito_map.clustering.ClusterManager$OnClusterItemClickListener<T extends com.avito.android.avito_map.clustering.ClusterItem> */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.avito.android.avito_map.AvitoMap.MarkerExactClickListener
        public boolean onMarkerClicked(AvitoMapMarker avitoMapMarker) {
            DefaultClusterRenderer defaultClusterRenderer = DefaultClusterRenderer.this;
            ClusterManager.OnClusterItemClickListener<T> onClusterItemClickListener = defaultClusterRenderer.o;
            return onClusterItemClickListener != 0 && onClusterItemClickListener.onClusterItemClick(defaultClusterRenderer.h.b.get(avitoMapMarker));
        }
    }

    public class b implements AvitoMap.MarkerExactClickListener {
        public b() {
        }

        @Override // com.avito.android.avito_map.AvitoMap.MarkerExactClickListener
        public boolean onMarkerClicked(AvitoMapMarker avitoMapMarker) {
            DefaultClusterRenderer defaultClusterRenderer = DefaultClusterRenderer.this;
            ClusterManager.OnClusterClickListener<T> onClusterClickListener = defaultClusterRenderer.n;
            return onClusterClickListener != null && onClusterClickListener.onClusterClick(defaultClusterRenderer.k.get(avitoMapMarker));
        }
    }

    public class c {
        public final Cluster<T> a;
        public final Set<f> b;

        public c(Cluster<T> cluster, Set<f> set) {
            this.a = cluster;
            this.b = set;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v1, resolved type: com.avito.android.avito_map.clustering.view.DefaultClusterRenderer */
        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.avito.android.avito_map.clustering.view.DefaultClusterRenderer */
        /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.avito.android.avito_map.clustering.view.DefaultClusterRenderer */
        /* JADX DEBUG: Multi-variable search result rejected for r1v10, resolved type: java.util.Map<com.avito.android.avito_map.AvitoMapMarker, com.avito.android.avito_map.clustering.Cluster<T extends com.avito.android.avito_map.clustering.ClusterItem>> */
        /* JADX DEBUG: Multi-variable search result rejected for r1v12, resolved type: java.util.Map<com.avito.android.avito_map.clustering.Cluster<T extends com.avito.android.avito_map.clustering.ClusterItem>, com.avito.android.avito_map.AvitoMapMarker> */
        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.avito.android.avito_map.clustering.view.DefaultClusterRenderer */
        /* JADX DEBUG: Multi-variable search result rejected for r2v13, resolved type: com.avito.android.avito_map.clustering.view.DefaultClusterRenderer */
        /* JADX WARN: Multi-variable type inference failed */
        public static void a(c cVar, e eVar) {
            f fVar;
            f fVar2;
            if (!DefaultClusterRenderer.this.shouldRenderAsCluster(cVar.a)) {
                for (T t : cVar.a.getItems()) {
                    AvitoMapMarker avitoMapMarker = DefaultClusterRenderer.this.h.a.get(t);
                    if (avitoMapMarker == null) {
                        AvitoMapMarkerOptions avitoMapMarkerOptions = new AvitoMapMarkerOptions(t.getPosition(), AvitoMapMarker.Anchor.BOTTOM_CENTER);
                        if (t.getTitle() != null && t.getSnippet() != null) {
                            avitoMapMarkerOptions.setTitle(t.getTitle());
                            avitoMapMarkerOptions.setSnippet(t.getSnippet());
                        } else if (t.getSnippet() != null) {
                            avitoMapMarkerOptions.setTitle(t.getSnippet());
                        } else if (t.getTitle() != null) {
                            avitoMapMarkerOptions.setTitle(t.getTitle());
                        }
                        DefaultClusterRenderer.this.onBeforeClusterItemRendered(t, avitoMapMarkerOptions);
                        avitoMapMarker = DefaultClusterRenderer.this.c.getMarkerCollection().addMarker(avitoMapMarkerOptions);
                        fVar2 = new f(avitoMapMarker, null);
                        d<T> dVar = DefaultClusterRenderer.this.h;
                        dVar.a.put(t, avitoMapMarker);
                        dVar.b.put(avitoMapMarker, t);
                    } else {
                        fVar2 = new f(avitoMapMarker, null);
                    }
                    DefaultClusterRenderer.this.onClusterItemRendered(t, avitoMapMarker);
                    cVar.b.add(fVar2);
                }
                return;
            }
            AvitoMapMarker avitoMapMarker2 = DefaultClusterRenderer.this.l.get(cVar.a);
            if (avitoMapMarker2 == null) {
                AvitoMapMarkerOptions avitoMapMarkerOptions2 = new AvitoMapMarkerOptions(cVar.a.getPosition(), AvitoMapMarker.Anchor.CENTER);
                DefaultClusterRenderer.this.onBeforeClusterRendered(cVar.a, avitoMapMarkerOptions2);
                avitoMapMarker2 = DefaultClusterRenderer.this.c.getClusterMarkerCollection().addMarker(avitoMapMarkerOptions2);
                DefaultClusterRenderer.this.k.put(avitoMapMarker2, cVar.a);
                DefaultClusterRenderer.this.l.put(cVar.a, avitoMapMarker2);
                fVar = new f(avitoMapMarker2, null);
            } else {
                fVar = new f(avitoMapMarker2, null);
            }
            DefaultClusterRenderer.this.onClusterRendered(cVar.a, avitoMapMarker2);
            cVar.b.add(fVar);
        }
    }

    public static class d<T> {
        public Map<T, AvitoMapMarker> a = new HashMap();
        public Map<AvitoMapMarker, T> b = new HashMap();

        public d(a aVar) {
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class e extends Handler implements MessageQueue.IdleHandler {
        public final Lock a;
        public final Condition b;
        public Queue<DefaultClusterRenderer<T>.c> c = new LinkedList();
        public Queue<DefaultClusterRenderer<T>.c> d = new LinkedList();
        public Queue<AvitoMapMarker> e = new LinkedList();
        public Queue<AvitoMapMarker> f = new LinkedList();
        public boolean g;

        public e(a aVar) {
            super(Looper.getMainLooper());
            ReentrantLock reentrantLock = new ReentrantLock();
            this.a = reentrantLock;
            this.b = reentrantLock.newCondition();
        }

        public boolean a() {
            try {
                this.a.lock();
                return !this.c.isEmpty() || !this.d.isEmpty() || !this.f.isEmpty() || !this.e.isEmpty();
            } finally {
                this.a.unlock();
            }
        }

        @TargetApi(11)
        public final void b() {
            if (!this.f.isEmpty()) {
                c(this.f.poll());
            } else if (!this.d.isEmpty()) {
                c.a(this.d.poll(), this);
            } else if (!this.c.isEmpty()) {
                c.a(this.c.poll(), this);
            } else if (!this.e.isEmpty()) {
                c(this.e.poll());
            }
        }

        public final void c(AvitoMapMarker avitoMapMarker) {
            DefaultClusterRenderer.this.l.remove(DefaultClusterRenderer.this.k.get(avitoMapMarker));
            d<T> dVar = DefaultClusterRenderer.this.h;
            T t = dVar.b.get(avitoMapMarker);
            dVar.b.remove(avitoMapMarker);
            dVar.a.remove(t);
            DefaultClusterRenderer.this.k.remove(avitoMapMarker);
            DefaultClusterRenderer.this.c.getMarkerManager().remove(avitoMapMarker);
        }

        public void d() {
            while (a()) {
                sendEmptyMessage(0);
                this.a.lock();
                try {
                    if (a()) {
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
            if (!this.g) {
                Looper.myQueue().addIdleHandler(this);
                this.g = true;
            }
            removeMessages(0);
            this.a.lock();
            for (int i = 0; i < 10; i++) {
                try {
                    b();
                } catch (Throwable th) {
                    this.a.unlock();
                    throw th;
                }
            }
            if (!a()) {
                this.g = false;
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

    public static class f {
        public final AvitoMapMarker a;
        public AvitoMapPoint b;

        public f(AvitoMapMarker avitoMapMarker, a aVar) {
            this.a = avitoMapMarker;
            this.b = avitoMapMarker.getPosition();
        }

        public boolean equals(Object obj) {
            if (obj instanceof f) {
                return this.a.equals(((f) obj).a);
            }
            return false;
        }

        public int hashCode() {
            return this.a.hashCode();
        }
    }

    public class g implements Runnable {
        public final Set<? extends Cluster<T>> a;
        public Runnable b;
        public AvitoMapBounds c;
        public float d;

        public g(Set set, a aVar) {
            this.a = set;
        }

        /* JADX DEBUG: Type inference failed for r1v6. Raw type applied. Possible types: java.util.Set<? extends com.avito.android.avito_map.clustering.Cluster<T>>, java.util.Set<? extends com.avito.android.avito_map.clustering.Cluster<T extends com.avito.android.avito_map.clustering.ClusterItem>> */
        @Override // java.lang.Runnable
        @SuppressLint({"NewApi"})
        public void run() {
            if (this.a.equals(DefaultClusterRenderer.this.j)) {
                this.b.run();
                return;
            }
            e eVar = new e(null);
            Set<f> set = DefaultClusterRenderer.this.f;
            AvitoMapBounds avitoMapBounds = this.c;
            Set<f> newSetFromMap = Collections.newSetFromMap(new ConcurrentHashMap());
            Iterator<? extends Cluster<T>> it = this.a.iterator();
            while (it.hasNext()) {
                DefaultClusterRenderer<T>.c cVar = new c((Cluster) it.next(), newSetFromMap);
                eVar.a.lock();
                eVar.sendEmptyMessage(0);
                eVar.d.add(cVar);
                eVar.a.unlock();
            }
            eVar.d();
            set.removeAll(newSetFromMap);
            for (f fVar : set) {
                boolean contains = avitoMapBounds.contains(fVar.b);
                AvitoMapMarker avitoMapMarker = fVar.a;
                eVar.a.lock();
                eVar.sendEmptyMessage(0);
                if (contains) {
                    eVar.f.add(avitoMapMarker);
                } else {
                    eVar.e.add(avitoMapMarker);
                }
                eVar.a.unlock();
            }
            eVar.d();
            DefaultClusterRenderer defaultClusterRenderer = DefaultClusterRenderer.this;
            defaultClusterRenderer.f = newSetFromMap;
            defaultClusterRenderer.j = (Set<? extends Cluster<T>>) this.a;
            Objects.requireNonNull(defaultClusterRenderer);
            this.b.run();
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class h extends Handler {
        public boolean a = false;
        public DefaultClusterRenderer<T>.g b = null;

        public h(a aVar) {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            DefaultClusterRenderer<T>.g gVar;
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
                AvitoMapBounds mapBounds = DefaultClusterRenderer.this.a.getMapBounds();
                synchronized (this) {
                    gVar = this.b;
                    this.b = null;
                    this.a = true;
                }
                gVar.b = new a2.a.a.p.a.a.a(this);
                gVar.c = mapBounds;
                gVar.d = DefaultClusterRenderer.this.a.getMapCameraPosition().getZoomLevel();
                new Thread(gVar).start();
            }
        }
    }

    public DefaultClusterRenderer(Context context, AvitoMap avitoMap, ClusterManager<T> clusterManager) {
        this.a = avitoMap;
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
        this.e = new ShapeDrawable(new OvalShape());
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        shapeDrawable.getPaint().setColor(-2130706433);
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{shapeDrawable, this.e});
        int i3 = (int) (f2 * 3.0f);
        layerDrawable.setLayerInset(1, i3, i3, i3, i3);
        iconGenerator.setBackground(layerDrawable);
        this.c = clusterManager;
    }

    public int getBucket(Cluster<T> cluster) {
        int size = cluster.getSize();
        int i2 = 0;
        if (size <= p[0]) {
            return size;
        }
        while (true) {
            int[] iArr = p;
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

    public String getClusterText(int i2) {
        if (i2 < p[0]) {
            return String.valueOf(i2);
        }
        return String.valueOf(i2) + "+";
    }

    @SuppressLint({"CustomColorsKotlin"})
    public int getColor(int i2) {
        float min = 300.0f - Math.min((float) i2, 300.0f);
        return Color.HSVToColor(new float[]{((min * min) / 90000.0f) * 220.0f, 1.0f, 0.6f});
    }

    public AvitoMapMarker getMarker(T t) {
        return this.h.a.get(t);
    }

    public int getMinClusterSize() {
        return this.i;
    }

    @Override // com.avito.android.avito_map.clustering.view.ClusterRenderer
    public void onAdd() {
        this.c.getMarkerCollection().setOnMarkerClickListener(new a());
        this.c.getClusterMarkerCollection().setOnMarkerClickListener(new b());
    }

    public void onBeforeClusterItemRendered(T t, AvitoMapMarkerOptions avitoMapMarkerOptions) {
    }

    public void onBeforeClusterRendered(Cluster<T> cluster, AvitoMapMarkerOptions avitoMapMarkerOptions) {
        int bucket = getBucket(cluster);
        Bitmap bitmap = this.g.get(bucket);
        if (bitmap == null) {
            this.e.getPaint().setColor(getColor(bucket));
            bitmap = this.b.makeIcon(getClusterText(bucket));
            this.g.put(bucket, bitmap);
        }
        avitoMapMarkerOptions.setIcon(bitmap);
    }

    public void onClusterItemRendered(T t, AvitoMapMarker avitoMapMarker) {
    }

    public void onClusterRendered(Cluster<T> cluster, AvitoMapMarker avitoMapMarker) {
    }

    @Override // com.avito.android.avito_map.clustering.view.ClusterRenderer
    public void onClustersChanged(Set<? extends Cluster<T>> set) {
        DefaultClusterRenderer<T>.h hVar = this.m;
        synchronized (hVar) {
            hVar.b = new g(set, null);
        }
        hVar.sendEmptyMessage(0);
    }

    @Override // com.avito.android.avito_map.clustering.view.ClusterRenderer
    public void onRemove() {
        this.c.getMarkerCollection().setOnMarkerClickListener(null);
        this.c.getClusterMarkerCollection().setOnMarkerClickListener(null);
    }

    public void setMinClusterSize(int i2) {
        this.i = i2;
    }

    @Override // com.avito.android.avito_map.clustering.view.ClusterRenderer
    public void setOnClusterClickListener(ClusterManager.OnClusterClickListener<T> onClusterClickListener) {
        this.n = onClusterClickListener;
    }

    @Override // com.avito.android.avito_map.clustering.view.ClusterRenderer
    public void setOnClusterItemClickListener(ClusterManager.OnClusterItemClickListener<T> onClusterItemClickListener) {
        this.o = onClusterItemClickListener;
    }

    public boolean shouldRenderAsCluster(Cluster<T> cluster) {
        return cluster.getSize() > this.i;
    }
}

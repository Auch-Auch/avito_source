package com.google.maps.android.clustering;

import android.content.Context;
import android.os.AsyncTask;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Marker;
import com.google.maps.android.MarkerManager;
import com.google.maps.android.clustering.ClusterItem;
import com.google.maps.android.clustering.algo.Algorithm;
import com.google.maps.android.clustering.algo.NonHierarchicalDistanceBasedAlgorithm;
import com.google.maps.android.clustering.algo.PreCachingAlgorithmDecorator;
import com.google.maps.android.clustering.view.ClusterRenderer;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
public class ClusterManager<T extends ClusterItem> implements GoogleMap.OnCameraIdleListener, GoogleMap.OnMarkerClickListener, GoogleMap.OnInfoWindowClickListener {
    public final MarkerManager a;
    public final MarkerManager.Collection b;
    public final MarkerManager.Collection c;
    public Algorithm<T> d;
    public final ReadWriteLock e;
    public ClusterRenderer<T> f;
    public GoogleMap g;
    public CameraPosition h;
    public ClusterManager<T>.b i;
    public final ReadWriteLock j;
    public OnClusterItemClickListener<T> k;
    public OnClusterInfoWindowClickListener<T> l;
    public OnClusterItemInfoWindowClickListener<T> m;
    public OnClusterClickListener<T> n;

    public interface OnClusterClickListener<T extends ClusterItem> {
        boolean onClusterClick(Cluster<T> cluster);
    }

    public interface OnClusterInfoWindowClickListener<T extends ClusterItem> {
        void onClusterInfoWindowClick(Cluster<T> cluster);
    }

    public interface OnClusterItemClickListener<T extends ClusterItem> {
        boolean onClusterItemClick(T t);
    }

    public interface OnClusterItemInfoWindowClickListener<T extends ClusterItem> {
        void onClusterItemInfoWindowClick(T t);
    }

    public class b extends AsyncTask<Float, Void, Set<? extends Cluster<T>>> {
        public b(a aVar) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // android.os.AsyncTask
        public Object doInBackground(Float[] fArr) {
            Float[] fArr2 = fArr;
            ClusterManager.this.e.readLock().lock();
            try {
                return ClusterManager.this.d.getClusters((double) fArr2[0].floatValue());
            } finally {
                ClusterManager.this.e.readLock().unlock();
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Object obj) {
            ClusterManager.this.f.onClustersChanged((Set) obj);
        }
    }

    public ClusterManager(Context context, GoogleMap googleMap) {
        this(context, googleMap, new MarkerManager(googleMap));
    }

    public void addItem(T t) {
        this.e.writeLock().lock();
        try {
            this.d.addItem(t);
        } finally {
            this.e.writeLock().unlock();
        }
    }

    public void addItems(Collection<T> collection) {
        this.e.writeLock().lock();
        try {
            this.d.addItems(collection);
        } finally {
            this.e.writeLock().unlock();
        }
    }

    public void clearItems() {
        this.e.writeLock().lock();
        try {
            this.d.clearItems();
        } finally {
            this.e.writeLock().unlock();
        }
    }

    public void cluster() {
        this.j.writeLock().lock();
        try {
            this.i.cancel(true);
            ClusterManager<T>.b bVar = new b(null);
            this.i = bVar;
            bVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, Float.valueOf(this.g.getCameraPosition().zoom));
        } finally {
            this.j.writeLock().unlock();
        }
    }

    public Algorithm<T> getAlgorithm() {
        return this.d;
    }

    public MarkerManager.Collection getClusterMarkerCollection() {
        return this.c;
    }

    public MarkerManager.Collection getMarkerCollection() {
        return this.b;
    }

    public MarkerManager getMarkerManager() {
        return this.a;
    }

    public ClusterRenderer<T> getRenderer() {
        return this.f;
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnCameraIdleListener
    public void onCameraIdle() {
        ClusterRenderer<T> clusterRenderer = this.f;
        if (clusterRenderer instanceof GoogleMap.OnCameraIdleListener) {
            ((GoogleMap.OnCameraIdleListener) clusterRenderer).onCameraIdle();
        }
        CameraPosition cameraPosition = this.g.getCameraPosition();
        CameraPosition cameraPosition2 = this.h;
        if (cameraPosition2 == null || cameraPosition2.zoom != cameraPosition.zoom) {
            this.h = this.g.getCameraPosition();
            cluster();
        }
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener
    public void onInfoWindowClick(Marker marker) {
        getMarkerManager().onInfoWindowClick(marker);
    }

    @Override // com.google.android.gms.maps.GoogleMap.OnMarkerClickListener
    public boolean onMarkerClick(Marker marker) {
        return getMarkerManager().onMarkerClick(marker);
    }

    public void removeItem(T t) {
        this.e.writeLock().lock();
        try {
            this.d.removeItem(t);
        } finally {
            this.e.writeLock().unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public void setAlgorithm(Algorithm<T> algorithm) {
        this.e.writeLock().lock();
        try {
            Algorithm<T> algorithm2 = this.d;
            if (algorithm2 != null) {
                algorithm.addItems(algorithm2.getItems());
            }
            this.d = new PreCachingAlgorithmDecorator(algorithm);
            this.e.writeLock().unlock();
            cluster();
        } catch (Throwable th) {
            this.e.writeLock().unlock();
            throw th;
        }
    }

    public void setAnimation(boolean z) {
        this.f.setAnimation(z);
    }

    public void setOnClusterClickListener(OnClusterClickListener<T> onClusterClickListener) {
        this.n = onClusterClickListener;
        this.f.setOnClusterClickListener(onClusterClickListener);
    }

    public void setOnClusterInfoWindowClickListener(OnClusterInfoWindowClickListener<T> onClusterInfoWindowClickListener) {
        this.l = onClusterInfoWindowClickListener;
        this.f.setOnClusterInfoWindowClickListener(onClusterInfoWindowClickListener);
    }

    public void setOnClusterItemClickListener(OnClusterItemClickListener<T> onClusterItemClickListener) {
        this.k = onClusterItemClickListener;
        this.f.setOnClusterItemClickListener(onClusterItemClickListener);
    }

    public void setOnClusterItemInfoWindowClickListener(OnClusterItemInfoWindowClickListener<T> onClusterItemInfoWindowClickListener) {
        this.m = onClusterItemInfoWindowClickListener;
        this.f.setOnClusterItemInfoWindowClickListener(onClusterItemInfoWindowClickListener);
    }

    public void setRenderer(ClusterRenderer<T> clusterRenderer) {
        this.f.setOnClusterClickListener(null);
        this.f.setOnClusterItemClickListener(null);
        this.c.clear();
        this.b.clear();
        this.f.onRemove();
        this.f = clusterRenderer;
        clusterRenderer.onAdd();
        this.f.setOnClusterClickListener(this.n);
        this.f.setOnClusterInfoWindowClickListener(this.l);
        this.f.setOnClusterItemClickListener(this.k);
        this.f.setOnClusterItemInfoWindowClickListener(this.m);
        cluster();
    }

    public ClusterManager(Context context, GoogleMap googleMap, MarkerManager markerManager) {
        this.e = new ReentrantReadWriteLock();
        this.j = new ReentrantReadWriteLock();
        this.g = googleMap;
        this.a = markerManager;
        this.c = markerManager.newCollection();
        this.b = markerManager.newCollection();
        this.f = new DefaultClusterRenderer(context, googleMap, this);
        this.d = new PreCachingAlgorithmDecorator(new NonHierarchicalDistanceBasedAlgorithm());
        this.i = new b(null);
        this.f.onAdd();
    }
}

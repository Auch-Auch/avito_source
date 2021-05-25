package com.avito.android.avito_map.clustering;

import android.content.Context;
import android.os.AsyncTask;
import com.avito.android.avito_map.AvitoMap;
import com.avito.android.avito_map.AvitoMapCameraPosition;
import com.avito.android.avito_map.AvitoMapMarker;
import com.avito.android.avito_map.clustering.ClusterItem;
import com.avito.android.avito_map.clustering.MarkerManager;
import com.avito.android.avito_map.clustering.algo.NonHierarchicalDistanceBasedAlgorithm;
import com.avito.android.avito_map.clustering.algo.PreCachingAlgorithmDecorator;
import com.avito.android.avito_map.clustering.algo.ScreenBasedAlgorithm;
import com.avito.android.avito_map.clustering.algo.ScreenBasedAlgorithmAdapter;
import com.avito.android.avito_map.clustering.view.ClusterRenderer;
import com.avito.android.avito_map.clustering.view.DefaultClusterRenderer;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jetbrains.annotations.NotNull;
public class ClusterManager<T extends ClusterItem> implements AvitoMap.MarkerExactClickListener, AvitoMap.MapMoveEndListener {
    public final MarkerManager a;
    public final MarkerManager.Collection b;
    public final MarkerManager.Collection c;
    public ScreenBasedAlgorithm<T> d;
    public ClusterRenderer<T> e;
    public AvitoMap f;
    public AvitoMapCameraPosition g;
    public ClusterManager<T>.b h;
    public final ReadWriteLock i = new ReentrantReadWriteLock();
    public OnClusterItemClickListener<T> j;
    public OnClusterClickListener<T> k;

    public interface OnClusterClickListener<T extends ClusterItem> {
        boolean onClusterClick(Cluster<T> cluster);
    }

    public interface OnClusterItemClickListener<T extends ClusterItem> {
        boolean onClusterItemClick(T t);
    }

    public class b extends AsyncTask<Float, Void, Set<? extends Cluster<T>>> {
        public b(a aVar) {
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
        @Override // android.os.AsyncTask
        public Object doInBackground(Float[] fArr) {
            Float[] fArr2 = fArr;
            ClusterManager.this.d.lock();
            try {
                return ClusterManager.this.d.getClusters(fArr2[0].floatValue());
            } finally {
                ClusterManager.this.d.unlock();
            }
        }

        @Override // android.os.AsyncTask
        public void onPostExecute(Object obj) {
            ClusterManager.this.e.onClustersChanged((Set) obj);
        }
    }

    public ClusterManager(Context context, AvitoMap avitoMap) {
        MarkerManager markerManager = new MarkerManager(avitoMap);
        this.f = avitoMap;
        this.a = markerManager;
        this.c = new MarkerManager.Collection();
        this.b = new MarkerManager.Collection();
        this.e = new DefaultClusterRenderer(context, avitoMap, this);
        this.d = new ScreenBasedAlgorithmAdapter(new PreCachingAlgorithmDecorator(new NonHierarchicalDistanceBasedAlgorithm()));
        this.h = new b(null);
        this.e.onAdd();
    }

    public void addItems(Collection<T> collection) {
        this.d.lock();
        try {
            this.d.addItems(collection);
        } finally {
            this.d.unlock();
        }
    }

    public void clearItems() {
        this.d.lock();
        try {
            this.d.clearItems();
        } finally {
            this.d.unlock();
        }
    }

    public void cluster() {
        this.i.writeLock().lock();
        try {
            this.h.cancel(true);
            ClusterManager<T>.b bVar = new b(null);
            this.h = bVar;
            bVar.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, Float.valueOf(this.f.getMapCameraPosition().getZoomLevel()));
        } finally {
            this.i.writeLock().unlock();
        }
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
        return this.e;
    }

    @Override // com.avito.android.avito_map.AvitoMap.MapMoveEndListener
    public void onMapSettled(@NotNull AvitoMapCameraPosition avitoMapCameraPosition) {
        ClusterRenderer<T> clusterRenderer = this.e;
        if (clusterRenderer instanceof AvitoMap.MapMoveEndListener) {
            ((AvitoMap.MapMoveEndListener) clusterRenderer).onMapSettled(avitoMapCameraPosition);
        }
        this.d.onCameraChange(this.f.getMapCameraPosition());
        if (this.d.shouldReClusterOnMapMovement()) {
            cluster();
            return;
        }
        AvitoMapCameraPosition avitoMapCameraPosition2 = this.g;
        if (avitoMapCameraPosition2 == null || avitoMapCameraPosition2.getZoomLevel() != this.f.getMapCameraPosition().getZoomLevel()) {
            this.g = this.f.getMapCameraPosition();
            cluster();
        }
    }

    @Override // com.avito.android.avito_map.AvitoMap.MarkerExactClickListener
    public boolean onMarkerClicked(AvitoMapMarker avitoMapMarker) {
        return getMarkerManager().onMarkerClicked(avitoMapMarker);
    }

    public void setOnClusterClickListener(OnClusterClickListener<T> onClusterClickListener) {
        this.k = onClusterClickListener;
        this.e.setOnClusterClickListener(onClusterClickListener);
    }

    public void setOnClusterItemClickListener(OnClusterItemClickListener<T> onClusterItemClickListener) {
        this.j = onClusterItemClickListener;
        this.e.setOnClusterItemClickListener(onClusterItemClickListener);
    }

    public void setRenderer(ClusterRenderer<T> clusterRenderer) {
        this.e.setOnClusterClickListener(null);
        this.e.setOnClusterItemClickListener(null);
        this.c.clear();
        this.b.clear();
        this.e.onRemove();
        this.e = clusterRenderer;
        clusterRenderer.onAdd();
        this.e.setOnClusterClickListener(this.k);
        this.e.setOnClusterItemClickListener(this.j);
        cluster();
    }
}

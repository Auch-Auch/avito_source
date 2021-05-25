package com.yandex.mapkit.map.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.map.Cluster;
import com.yandex.mapkit.map.ClusterTapListener;
import com.yandex.mapkit.map.PlacemarkMapObject;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.subscription.Subscription;
import java.util.List;
public class ClusterBinding implements Cluster {
    private Subscription<ClusterTapListener> clusterTapListenerSubscription = new Subscription<ClusterTapListener>() { // from class: com.yandex.mapkit.map.internal.ClusterBinding.1
        public NativeObject createNativeListener(ClusterTapListener clusterTapListener) {
            return ClusterBinding.createClusterTapListener(clusterTapListener);
        }
    };
    private final NativeObject nativeObject;

    public ClusterBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    /* access modifiers changed from: private */
    public static native NativeObject createClusterTapListener(ClusterTapListener clusterTapListener);

    @Override // com.yandex.mapkit.map.Cluster
    public native void addClusterTapListener(@NonNull ClusterTapListener clusterTapListener);

    @Override // com.yandex.mapkit.map.Cluster
    @NonNull
    public native PlacemarkMapObject getAppearance();

    @Override // com.yandex.mapkit.map.Cluster
    @NonNull
    public native List<PlacemarkMapObject> getPlacemarks();

    @Override // com.yandex.mapkit.map.Cluster
    public native int getSize();

    @Override // com.yandex.mapkit.map.Cluster
    public native boolean isValid();

    @Override // com.yandex.mapkit.map.Cluster
    public native void removeClusterTapListener(@NonNull ClusterTapListener clusterTapListener);
}

package com.yandex.mapkit.offline_cache.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.offline_cache.DataMoveListener;
import com.yandex.mapkit.offline_cache.OfflineCacheManager;
import com.yandex.mapkit.offline_cache.Region;
import com.yandex.mapkit.offline_cache.RegionListUpdatesListener;
import com.yandex.mapkit.offline_cache.RegionListener;
import com.yandex.mapkit.offline_cache.RegionState;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.subscription.Subscription;
import java.util.List;
public class OfflineCacheManagerBinding implements OfflineCacheManager {
    private Subscription<DataMoveListener> dataMoveListenerSubscription = new Subscription<DataMoveListener>() { // from class: com.yandex.mapkit.offline_cache.internal.OfflineCacheManagerBinding.1
        public NativeObject createNativeListener(DataMoveListener dataMoveListener) {
            return OfflineCacheManagerBinding.createDataMoveListener(dataMoveListener);
        }
    };
    private Subscription<OfflineCacheManager.ErrorListener> errorListenerSubscription = new Subscription<OfflineCacheManager.ErrorListener>() { // from class: com.yandex.mapkit.offline_cache.internal.OfflineCacheManagerBinding.2
        public NativeObject createNativeListener(OfflineCacheManager.ErrorListener errorListener) {
            return OfflineCacheManagerBinding.createErrorListener(errorListener);
        }
    };
    private final NativeObject nativeObject;
    private Subscription<RegionListUpdatesListener> regionListUpdatesListenerSubscription = new Subscription<RegionListUpdatesListener>() { // from class: com.yandex.mapkit.offline_cache.internal.OfflineCacheManagerBinding.3
        public NativeObject createNativeListener(RegionListUpdatesListener regionListUpdatesListener) {
            return OfflineCacheManagerBinding.createRegionListUpdatesListener(regionListUpdatesListener);
        }
    };
    private Subscription<RegionListener> regionListenerSubscription = new Subscription<RegionListener>() { // from class: com.yandex.mapkit.offline_cache.internal.OfflineCacheManagerBinding.4
        public NativeObject createNativeListener(RegionListener regionListener) {
            return OfflineCacheManagerBinding.createRegionListener(regionListener);
        }
    };

    public OfflineCacheManagerBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    /* access modifiers changed from: private */
    public static native NativeObject createDataMoveListener(DataMoveListener dataMoveListener);

    /* access modifiers changed from: private */
    public static native NativeObject createErrorListener(OfflineCacheManager.ErrorListener errorListener);

    /* access modifiers changed from: private */
    public static native NativeObject createRegionListUpdatesListener(RegionListUpdatesListener regionListUpdatesListener);

    /* access modifiers changed from: private */
    public static native NativeObject createRegionListener(RegionListener regionListener);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native void addErrorListener(@NonNull OfflineCacheManager.ErrorListener errorListener);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native void addRegionListUpdatesListener(@NonNull RegionListUpdatesListener regionListUpdatesListener);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native void addRegionListener(@NonNull RegionListener regionListener);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native void allowUseCellularNetwork(boolean z);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native void clear(@NonNull OfflineCacheManager.ClearListener clearListener);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native void computeCacheSize(@NonNull OfflineCacheManager.SizeListener sizeListener);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native void drop(int i);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native void enableAutoUpdate(boolean z);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    @NonNull
    public native List<String> getCities(int i);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native float getProgress(int i);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    @NonNull
    public native RegionState getState(int i);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native boolean isLegacyPath(int i);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native boolean isValid();

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native boolean mayBeOutOfAvailableSpace(int i);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native void moveData(@NonNull String str, @NonNull DataMoveListener dataMoveListener);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native void pauseDownload(int i);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    @NonNull
    public native List<Region> regions();

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native void removeErrorListener(@NonNull OfflineCacheManager.ErrorListener errorListener);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native void removeRegionListUpdatesListener(@NonNull RegionListUpdatesListener regionListUpdatesListener);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native void removeRegionListener(@NonNull RegionListener regionListener);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native void requestPath(@NonNull OfflineCacheManager.PathGetterListener pathGetterListener);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native void setCachePath(@NonNull String str);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native void simulateUpdate();

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native void startDownload(int i);

    @Override // com.yandex.mapkit.offline_cache.OfflineCacheManager
    public native void stopDownload(int i);
}

package com.yandex.mapkit.offline_cache;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.runtime.Error;
import java.util.List;
public interface OfflineCacheManager {

    public interface ClearListener {
        void onClearCompleted();
    }

    public interface ErrorListener {
        void onError(@NonNull Error error);

        void onRegionError(@NonNull Error error, int i);
    }

    public interface PathGetterListener {
        void onPathReceived(@NonNull String str);
    }

    public interface SizeListener {
        void onSizeComputed(@Nullable Long l);
    }

    void addErrorListener(@NonNull ErrorListener errorListener);

    void addRegionListUpdatesListener(@NonNull RegionListUpdatesListener regionListUpdatesListener);

    void addRegionListener(@NonNull RegionListener regionListener);

    void allowUseCellularNetwork(boolean z);

    void clear(@NonNull ClearListener clearListener);

    void computeCacheSize(@NonNull SizeListener sizeListener);

    void drop(int i);

    void enableAutoUpdate(boolean z);

    @NonNull
    List<String> getCities(int i);

    float getProgress(int i);

    @NonNull
    RegionState getState(int i);

    boolean isLegacyPath(int i);

    boolean isValid();

    boolean mayBeOutOfAvailableSpace(int i);

    void moveData(@NonNull String str, @NonNull DataMoveListener dataMoveListener);

    void pauseDownload(int i);

    @NonNull
    List<Region> regions();

    void removeErrorListener(@NonNull ErrorListener errorListener);

    void removeRegionListUpdatesListener(@NonNull RegionListUpdatesListener regionListUpdatesListener);

    void removeRegionListener(@NonNull RegionListener regionListener);

    void requestPath(@NonNull PathGetterListener pathGetterListener);

    void setCachePath(@NonNull String str);

    void simulateUpdate();

    void startDownload(int i);

    void stopDownload(int i);
}

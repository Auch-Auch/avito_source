package com.yandex.mapkit.storage;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.yandex.runtime.Error;
public interface StorageManager {

    public interface ClearListener {
        void onClearCompleted();
    }

    public interface PathGetterListener {
        void onPathReceiveError(@NonNull Error error);

        void onPathReceived(@NonNull String str);
    }

    public interface SizeListener {
        void onError(@NonNull Error error);

        void onSuccess(@Nullable Long l);
    }

    public interface StorageMoveListener {
        void onMoveCompleted();

        void onMoveError(@NonNull Error error);

        void onMoveProgress(int i);
    }

    void addStorageErrorListener(@NonNull StorageErrorListener storageErrorListener);

    void clear(@NonNull ClearListener clearListener);

    void computeSize(@NonNull SizeListener sizeListener);

    boolean isValid();

    void maxTileStorageSize(@NonNull SizeListener sizeListener);

    void moveData(@NonNull String str, @NonNull StorageMoveListener storageMoveListener);

    void removeStorageErrorListener(@NonNull StorageErrorListener storageErrorListener);

    void requestPath(@NonNull PathGetterListener pathGetterListener);

    void resetMaxTileStorageSize(@NonNull SizeListener sizeListener);

    void setMaxTileStorageSize(long j, @NonNull SizeListener sizeListener);
}

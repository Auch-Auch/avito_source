package com.yandex.mapkit.storage.internal;

import androidx.annotation.NonNull;
import com.yandex.mapkit.storage.StorageErrorListener;
import com.yandex.mapkit.storage.StorageManager;
import com.yandex.runtime.NativeObject;
import com.yandex.runtime.subscription.Subscription;
public class StorageManagerBinding implements StorageManager {
    private final NativeObject nativeObject;
    private Subscription<StorageErrorListener> storageErrorListenerSubscription = new Subscription<StorageErrorListener>() { // from class: com.yandex.mapkit.storage.internal.StorageManagerBinding.1
        public NativeObject createNativeListener(StorageErrorListener storageErrorListener) {
            return StorageManagerBinding.createStorageErrorListener(storageErrorListener);
        }
    };
    private Subscription<StorageManager.StorageMoveListener> storageMoveListenerSubscription = new Subscription<StorageManager.StorageMoveListener>() { // from class: com.yandex.mapkit.storage.internal.StorageManagerBinding.2
        public NativeObject createNativeListener(StorageManager.StorageMoveListener storageMoveListener) {
            return StorageManagerBinding.createStorageMoveListener(storageMoveListener);
        }
    };

    public StorageManagerBinding(NativeObject nativeObject2) {
        this.nativeObject = nativeObject2;
    }

    /* access modifiers changed from: private */
    public static native NativeObject createStorageErrorListener(StorageErrorListener storageErrorListener);

    /* access modifiers changed from: private */
    public static native NativeObject createStorageMoveListener(StorageManager.StorageMoveListener storageMoveListener);

    @Override // com.yandex.mapkit.storage.StorageManager
    public native void addStorageErrorListener(@NonNull StorageErrorListener storageErrorListener);

    @Override // com.yandex.mapkit.storage.StorageManager
    public native void clear(@NonNull StorageManager.ClearListener clearListener);

    @Override // com.yandex.mapkit.storage.StorageManager
    public native void computeSize(@NonNull StorageManager.SizeListener sizeListener);

    @Override // com.yandex.mapkit.storage.StorageManager
    public native boolean isValid();

    @Override // com.yandex.mapkit.storage.StorageManager
    public native void maxTileStorageSize(@NonNull StorageManager.SizeListener sizeListener);

    @Override // com.yandex.mapkit.storage.StorageManager
    public native void moveData(@NonNull String str, @NonNull StorageManager.StorageMoveListener storageMoveListener);

    @Override // com.yandex.mapkit.storage.StorageManager
    public native void removeStorageErrorListener(@NonNull StorageErrorListener storageErrorListener);

    @Override // com.yandex.mapkit.storage.StorageManager
    public native void requestPath(@NonNull StorageManager.PathGetterListener pathGetterListener);

    @Override // com.yandex.mapkit.storage.StorageManager
    public native void resetMaxTileStorageSize(@NonNull StorageManager.SizeListener sizeListener);

    @Override // com.yandex.mapkit.storage.StorageManager
    public native void setMaxTileStorageSize(long j, @NonNull StorageManager.SizeListener sizeListener);
}

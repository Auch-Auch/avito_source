package com.yandex.mapkit.storage;

import androidx.annotation.NonNull;
import com.yandex.runtime.LocalError;
public interface StorageErrorListener {
    void onStorageError(@NonNull LocalError localError);
}

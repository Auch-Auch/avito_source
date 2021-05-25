package com.google.mlkit.common.sdkinternal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.mlkit.common.MlKitException;
import com.google.mlkit.common.sdkinternal.MLTaskInput;
@KeepForSdk
public abstract class MLTask<T, S extends MLTaskInput> extends ModelResource {
    @KeepForSdk
    @WorkerThread
    public abstract T run(S s) throws MlKitException;
}

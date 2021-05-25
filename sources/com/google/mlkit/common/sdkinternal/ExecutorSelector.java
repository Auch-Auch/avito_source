package com.google.mlkit.common.sdkinternal;

import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.inject.Provider;
import java.util.concurrent.Executor;
@KeepForSdk
public class ExecutorSelector {
    public final Provider<? extends Executor> a;

    public ExecutorSelector(Provider<? extends Executor> provider) {
        this.a = provider;
    }

    @KeepForSdk
    public Executor getExecutorToUse(@Nullable Executor executor) {
        return executor != null ? executor : (Executor) this.a.get();
    }
}

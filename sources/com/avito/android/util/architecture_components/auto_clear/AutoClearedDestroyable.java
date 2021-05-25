package com.avito.android.util.architecture_components.auto_clear;

import com.avito.android.util.architecture_components.auto_clear.LifecycleDestroyable;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u0007¢\u0006\u0004\b\u0007\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, d2 = {"Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedDestroyable;", "Lcom/avito/android/util/architecture_components/auto_clear/LifecycleDestroyable;", "T", "Lcom/avito/android/util/architecture_components/auto_clear/AutoClearedValue;", "", "onDestroy", "()V", "<init>", "android_release"}, k = 1, mv = {1, 4, 2})
public final class AutoClearedDestroyable<T extends LifecycleDestroyable> extends AutoClearedValue<T> {
    @Override // com.avito.android.util.architecture_components.auto_clear.AutoClearedValue
    public void onDestroy() {
        LifecycleDestroyable lifecycleDestroyable = (LifecycleDestroyable) getValue();
        if (lifecycleDestroyable != null) {
            lifecycleDestroyable.destroy();
        }
        super.onDestroy();
    }
}

package com.avito.android.enabler;

import com.avito.android.enabler.model.RemoteToggles;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\u000e\u001a\u00020\t8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0010\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/enabler/CachedTogglesStorage;", "Lcom/avito/android/enabler/TogglesStorage;", "Lcom/avito/android/enabler/model/RemoteToggles;", "remoteToggles", "", "store", "(Lcom/avito/android/enabler/model/RemoteToggles;)V", "", "key", "", "getFeatureValue", "(Ljava/lang/String;)Ljava/lang/Boolean;", "getHasCacheForCurrentVersion", "()Z", "hasCacheForCurrentVersion", "", "currentVersionCode", "I", "Lcom/avito/android/enabler/PersistentTogglesCache;", "cache", "Lcom/avito/android/enabler/PersistentTogglesCache;", "<init>", "(Lcom/avito/android/enabler/PersistentTogglesCache;I)V", "features-enabler_release"}, k = 1, mv = {1, 4, 2})
public final class CachedTogglesStorage implements TogglesStorage {
    private final PersistentTogglesCache cache;
    private final int currentVersionCode;

    public CachedTogglesStorage(@NotNull PersistentTogglesCache persistentTogglesCache, int i) {
        Intrinsics.checkNotNullParameter(persistentTogglesCache, "cache");
        this.cache = persistentTogglesCache;
        this.currentVersionCode = i;
        if (persistentTogglesCache.getSavedVersion() < i) {
            persistentTogglesCache.drop();
        }
    }

    @Override // com.avito.android.enabler.TogglesStorage
    public boolean getHasCacheForCurrentVersion() {
        return this.cache.getSavedVersion() == this.currentVersionCode;
    }

    @Override // com.avito.android.enabler.TogglesStorage
    public void store(@NotNull RemoteToggles remoteToggles) {
        Intrinsics.checkNotNullParameter(remoteToggles, "remoteToggles");
        this.cache.saveToggles(remoteToggles);
        this.cache.setSavedVersion(this.currentVersionCode);
    }

    @Override // com.avito.android.enabler.TogglesStorage
    @Nullable
    public Boolean getFeatureValue(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.cache.getToggle(str);
    }
}

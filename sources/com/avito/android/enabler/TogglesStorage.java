package com.avito.android.enabler;

import com.avito.android.enabler.model.RemoteToggles;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/avito/android/enabler/TogglesStorage;", "", "Lcom/avito/android/enabler/model/RemoteToggles;", "remoteToggles", "", "store", "(Lcom/avito/android/enabler/model/RemoteToggles;)V", "", "key", "getFeatureValue", "(Ljava/lang/String;)Ljava/lang/Object;", "", "getHasCacheForCurrentVersion", "()Z", "hasCacheForCurrentVersion", "features-enabler_release"}, k = 1, mv = {1, 4, 2})
public interface TogglesStorage {
    @Nullable
    Object getFeatureValue(@NotNull String str);

    boolean getHasCacheForCurrentVersion();

    void store(@NotNull RemoteToggles remoteToggles);
}

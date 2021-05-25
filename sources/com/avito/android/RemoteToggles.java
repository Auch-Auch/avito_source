package com.avito.android;

import com.avito.android.toggle.Feature;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005¨\u0006\u000b"}, d2 = {"Lcom/avito/android/RemoteToggles;", "", "Lcom/avito/android/toggle/Feature;", "", "getRemoteTogglesFunctionalTestMonitor", "()Lcom/avito/android/toggle/Feature;", "remoteTogglesFunctionalTestMonitor", "getRemoteTogglesMonitor", "remoteTogglesMonitor", "getRemoteToggles", "remoteToggles", "features_release"}, k = 1, mv = {1, 4, 2})
public interface RemoteToggles {
    @NotNull
    Feature<Boolean> getRemoteToggles();

    @NotNull
    Feature<Boolean> getRemoteTogglesFunctionalTestMonitor();

    @NotNull
    Feature<Boolean> getRemoteTogglesMonitor();
}

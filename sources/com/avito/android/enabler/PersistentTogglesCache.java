package com.avito.android.enabler;

import com.avito.android.enabler.model.RemoteToggles;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/avito/android/enabler/PersistentTogglesCache;", "", "Lcom/avito/android/enabler/model/RemoteToggles;", "remoteToggles", "", "saveToggles", "(Lcom/avito/android/enabler/model/RemoteToggles;)V", "", "key", "", "getToggle", "(Ljava/lang/String;)Ljava/lang/Boolean;", "drop", "()V", "", "getSavedVersion", "()I", "setSavedVersion", "(I)V", "savedVersion", "features-enabler_release"}, k = 1, mv = {1, 4, 2})
public interface PersistentTogglesCache {
    void drop();

    int getSavedVersion();

    @Nullable
    Boolean getToggle(@NotNull String str);

    void saveToggles(@NotNull RemoteToggles remoteToggles);

    void setSavedVersion(int i);
}

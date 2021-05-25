package com.avito.android.analytics.inhouse_transport;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078&@&X¦\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/avito/android/analytics/inhouse_transport/InHouseAnalyticsSettingsStorage;", "", "", "fileName", "", "saveStorageFileName", "(Ljava/lang/String;)V", "", "isDirty", "()Z", "setDirty", "(Z)V", "getStorageFileName", "()Ljava/lang/String;", "storageFileName", "analytics-transport_release"}, k = 1, mv = {1, 4, 2})
public interface InHouseAnalyticsSettingsStorage {
    @Nullable
    String getStorageFileName();

    boolean isDirty();

    void saveStorageFileName(@NotNull String str);

    void setDirty(boolean z);
}

package com.yandex.mapkit.experiments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
public interface UiExperimentsManager {
    @Nullable
    Map<String, String> getParameters();

    @Nullable
    String getValue(@NonNull String str);

    boolean isValid();

    void setValue(@NonNull String str, @NonNull String str2, @Nullable String str3);

    void subscribe(@NonNull UiExperimentsListener uiExperimentsListener);

    void unsubscribe(@NonNull UiExperimentsListener uiExperimentsListener);
}

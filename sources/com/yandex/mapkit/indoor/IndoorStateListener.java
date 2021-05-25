package com.yandex.mapkit.indoor;

import androidx.annotation.NonNull;
public interface IndoorStateListener {
    void onActiveLevelChanged(@NonNull String str);

    void onActivePlanFocused(@NonNull IndoorPlan indoorPlan);

    void onActivePlanLeft();
}

package com.yandex.mapkit.indoor;

import androidx.annotation.NonNull;
import java.util.List;
public interface IndoorPlan {
    @NonNull
    String getActiveLevelId();

    @NonNull
    List<IndoorLevel> getLevels();

    void setActiveLevelId(@NonNull String str);
}

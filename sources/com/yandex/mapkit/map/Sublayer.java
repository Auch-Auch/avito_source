package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import com.yandex.mapkit.ConflictResolutionMode;
public interface Sublayer {
    @NonNull
    SublayerFeatureType getFeatureType();

    @NonNull
    SublayerFeatureFilter getFilter();

    @NonNull
    String getLayerId();

    @NonNull
    ConflictResolutionMode getModeAgainstLabels();

    @NonNull
    ConflictResolutionMode getModeAgainstPlacemarks();

    boolean isValid();

    boolean isVisible();

    void setFeatureType(@NonNull SublayerFeatureType sublayerFeatureType);

    void setLayerId(@NonNull String str);

    void setModeAgainstLabels(@NonNull ConflictResolutionMode conflictResolutionMode);

    void setModeAgainstPlacemarks(@NonNull ConflictResolutionMode conflictResolutionMode);

    void setVisible(boolean z);
}

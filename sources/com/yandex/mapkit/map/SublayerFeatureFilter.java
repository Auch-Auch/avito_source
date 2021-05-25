package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import java.util.List;
public interface SublayerFeatureFilter {
    @NonNull
    List<String> getTags();

    @NonNull
    SublayerFeatureFilterType getType();

    boolean isValid();

    void setTags(@NonNull List<String> list);

    void setType(@NonNull SublayerFeatureFilterType sublayerFeatureFilterType);
}

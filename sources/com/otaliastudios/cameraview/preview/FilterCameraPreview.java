package com.otaliastudios.cameraview.preview;

import androidx.annotation.NonNull;
import com.otaliastudios.cameraview.filter.Filter;
public interface FilterCameraPreview {
    @NonNull
    Filter getCurrentFilter();

    void setFilter(@NonNull Filter filter);
}

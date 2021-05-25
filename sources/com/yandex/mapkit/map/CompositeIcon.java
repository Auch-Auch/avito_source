package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import com.yandex.runtime.image.ImageProvider;
public interface CompositeIcon {
    boolean isValid();

    void removeAll();

    void removeIcon(@NonNull String str);

    void setIcon(@NonNull String str, @NonNull ImageProvider imageProvider, @NonNull IconStyle iconStyle);

    void setIcon(@NonNull String str, @NonNull ImageProvider imageProvider, @NonNull IconStyle iconStyle, @NonNull Callback callback);

    void setIconStyle(@NonNull String str, @NonNull IconStyle iconStyle);
}

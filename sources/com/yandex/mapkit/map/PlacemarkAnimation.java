package com.yandex.mapkit.map;

import androidx.annotation.NonNull;
import com.yandex.runtime.image.AnimatedImageProvider;
import com.yandex.runtime.model.AnimatedModelProvider;
public interface PlacemarkAnimation {
    boolean isReversed();

    boolean isValid();

    void pause();

    void play();

    void play(@NonNull Callback callback);

    void resume();

    void setIcon(@NonNull AnimatedImageProvider animatedImageProvider, @NonNull IconStyle iconStyle);

    void setIcon(@NonNull AnimatedImageProvider animatedImageProvider, @NonNull IconStyle iconStyle, @NonNull Callback callback);

    void setIconStyle(@NonNull IconStyle iconStyle);

    void setModel(@NonNull AnimatedModelProvider animatedModelProvider, @NonNull ModelStyle modelStyle);

    void setModel(@NonNull AnimatedModelProvider animatedModelProvider, @NonNull ModelStyle modelStyle, @NonNull Callback callback);

    void setModelStyle(@NonNull ModelStyle modelStyle);

    void setReversed(boolean z);

    void stop();
}

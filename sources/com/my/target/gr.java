package com.my.target;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.eg;
public interface gr extends gs {
    void D(int i);

    void G(boolean z);

    void H(boolean z);

    void a(@NonNull ce ceVar);

    void destroy();

    void ej();

    void finish();

    @NonNull
    gv getPromoMediaView();

    boolean isPaused();

    boolean isPlaying();

    void pause();

    void resume();

    void setMediaListener(@Nullable eg.a aVar);

    void setTimeChanged(float f);

    void stop(boolean z);
}

package com.yandex.mapkit.coverage;

import androidx.annotation.NonNull;
import com.yandex.runtime.Error;
public interface IsCoveredSession {

    public interface IsCoveredListener {
        void onCoveredError(@NonNull Error error);

        void onCoveredResponse(boolean z);
    }

    void cancel();

    void retry(@NonNull IsCoveredListener isCoveredListener);
}

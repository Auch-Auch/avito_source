package com.yandex.mapkit.coverage;

import androidx.annotation.NonNull;
import com.yandex.runtime.Error;
import java.util.List;
public interface RegionsSession {

    public interface RegionsListener {
        void onRegionsError(@NonNull Error error);

        void onRegionsResponse(@NonNull List<Region> list);
    }

    void cancel();

    void retry(@NonNull RegionsListener regionsListener);
}

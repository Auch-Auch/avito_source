package com.yandex.mobile.ads.video.models.ad;

import android.support.annotation.NonNull;
import java.util.Collection;
import java.util.List;
import java.util.Map;
public class CreativeConfigurator {
    @NonNull
    private final Creative mCreative;

    public CreativeConfigurator(@NonNull Creative creative) {
        this.mCreative = creative;
    }

    public void addIcons(@NonNull Collection<Icon> collection) {
        this.mCreative.addIcons(collection);
    }

    public void addTrackingEvents(@NonNull Map<String, List<String>> map) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            for (String str : entry.getValue()) {
                this.mCreative.addTrackingEvent(entry.getKey(), str);
            }
        }
    }
}

package com.yandex.mobile.ads.video.models.ad;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.tv;
import java.util.List;
import java.util.Map;
public class VideoAdConfigurator {
    @NonNull
    private final VideoAd mVideoAd;

    public VideoAdConfigurator(@NonNull VideoAd videoAd) {
        this.mVideoAd = videoAd;
    }

    public void addTrackingEvents(@NonNull Map<String, List<String>> map) {
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            for (String str : entry.getValue()) {
                this.mVideoAd.addTrackingEvent(entry.getKey(), str);
            }
        }
    }

    public void setWrapperConfiguration(@Nullable tv tvVar) {
        this.mVideoAd.setWrapperConfiguration(tvVar);
    }
}

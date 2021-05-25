package com.yandex.mobile.ads.video.tracking;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.tq;
import com.yandex.mobile.ads.video.VideoAdError;
import com.yandex.mobile.ads.video.models.ad.Creative;
import com.yandex.mobile.ads.video.models.ad.VideoAd;
import com.yandex.mobile.ads.video.models.vmap.AdBreak;
import java.util.List;
import java.util.Map;
public class Tracker {
    @Nullable
    private final Context a;
    @Nullable
    private ErrorListener b;

    public interface ErrorListener {
        void onTrackingError(VideoAdError videoAdError);
    }

    public static class Events {
        public static final String AD_BREAK_END = "breakEnd";
        public static final String AD_BREAK_ERROR = "error";
        public static final String AD_BREAK_START = "breakStart";
        public static final String AD_IMPRESSION = "impression";
        public static final String CREATIVE_CLICK_TRACKING = "clickTracking";
        public static final String CREATIVE_CLOSE = "close";
        public static final String CREATIVE_COLLAPSE = "collapse";
        public static final String CREATIVE_COMPLETE = "complete";
        public static final String CREATIVE_EXPAND = "expand";
        public static final String CREATIVE_FIRST_QUARTILE = "firstQuartile";
        public static final String CREATIVE_FULLSCREEN = "fullscreen";
        public static final String CREATIVE_MIDPOINT = "midpoint";
        public static final String CREATIVE_MUTE = "mute";
        public static final String CREATIVE_PAUSE = "pause";
        public static final String CREATIVE_RESUME = "resume";
        public static final String CREATIVE_START = "start";
        public static final String CREATIVE_THIRD_QUARTILE = "thirdQuartile";
        public static final String CREATIVE_UNMUTE = "unmute";
        public static final String CREATIVE_VIEW = "creativeView";
    }

    public Tracker() {
        this.a = null;
    }

    private void a(@NonNull String str, @NonNull Map<String, List<String>> map) {
        List<String> list = map.get(str);
        if (list != null) {
            for (String str2 : list) {
                tq.a(this.a).a(str2, this.b);
            }
            return;
        }
        ErrorListener errorListener = this.b;
        if (errorListener != null) {
            errorListener.onTrackingError(VideoAdError.createInternalError(String.format("For %s there are no events.", str)));
        }
    }

    public void setErrorListener(ErrorListener errorListener) {
        this.b = errorListener;
    }

    public void trackAdBreakEvent(@NonNull AdBreak adBreak, @NonNull String str) {
        a(str, adBreak.getTrackingEvents());
    }

    public void trackAdEvent(VideoAd videoAd, String str) {
        a(str, videoAd.getTrackingEvents());
    }

    public void trackCreativeEvent(Creative creative, String str) {
        a(str, creative.getTrackingEvents());
    }

    public Tracker(@NonNull Context context) {
        this.a = context.getApplicationContext();
    }
}

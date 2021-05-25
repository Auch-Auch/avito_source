package com.google.android.exoplayer2.source.ads;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
public interface AdsLoader {

    public interface AdViewProvider {
        List<OverlayInfo> getAdOverlayInfos();

        @Deprecated
        View[] getAdOverlayViews();

        @Nullable
        ViewGroup getAdViewGroup();
    }

    public interface EventListener {
        void onAdClicked();

        void onAdLoadError(AdsMediaSource.AdLoadException adLoadException, DataSpec dataSpec);

        void onAdPlaybackState(AdPlaybackState adPlaybackState);

        void onAdTapped();
    }

    public static final class OverlayInfo {
        public static final int PURPOSE_CLOSE_AD = 1;
        public static final int PURPOSE_CONTROLS = 0;
        public static final int PURPOSE_NOT_VISIBLE = 3;
        public static final int PURPOSE_OTHER = 2;
        public final int purpose;
        @Nullable
        public final String reasonDetail;
        public final View view;

        @Documented
        @Retention(RetentionPolicy.SOURCE)
        public @interface Purpose {
        }

        public OverlayInfo(View view2, int i) {
            this(view2, i, null);
        }

        public OverlayInfo(View view2, int i, @Nullable String str) {
            this.view = view2;
            this.purpose = i;
            this.reasonDetail = str;
        }
    }

    void handlePrepareComplete(int i, int i2);

    void handlePrepareError(int i, int i2, IOException iOException);

    void release();

    void setAdTagDataSpec(DataSpec dataSpec);

    void setPlayer(@Nullable Player player);

    void setSupportedContentTypes(int... iArr);

    void start(EventListener eventListener, AdViewProvider adViewProvider);

    void stop();
}

package com.my.target.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ae;
import com.my.target.ap;
import com.my.target.av;
import com.my.target.ba;
import com.my.target.ca;
import com.my.target.cl;
import com.my.target.cq;
import com.yandex.mobile.ads.video.tracking.Tracker;
public final class InterstitialAd extends BaseInterstitialAd {
    @Nullable
    public InterstitialAdListener listener;

    public interface InterstitialAdListener {
        void onClick(@NonNull InterstitialAd interstitialAd);

        void onDismiss(@NonNull InterstitialAd interstitialAd);

        void onDisplay(@NonNull InterstitialAd interstitialAd);

        void onLoad(@NonNull InterstitialAd interstitialAd);

        void onNoAd(@NonNull String str, @NonNull InterstitialAd interstitialAd);

        void onVideoCompleted(@NonNull InterstitialAd interstitialAd);
    }

    public class b implements ap.a {
        public b(a aVar) {
        }

        @Override // com.my.target.ap.a
        public void onClick() {
            InterstitialAd interstitialAd = InterstitialAd.this;
            InterstitialAdListener interstitialAdListener = interstitialAd.listener;
            if (interstitialAdListener != null) {
                interstitialAdListener.onClick(interstitialAd);
            }
        }

        @Override // com.my.target.ap.a
        public void onDismiss() {
            InterstitialAd interstitialAd = InterstitialAd.this;
            InterstitialAdListener interstitialAdListener = interstitialAd.listener;
            if (interstitialAdListener != null) {
                interstitialAdListener.onDismiss(interstitialAd);
            }
        }

        @Override // com.my.target.ap.a
        public void onDisplay() {
            InterstitialAd interstitialAd = InterstitialAd.this;
            InterstitialAdListener interstitialAdListener = interstitialAd.listener;
            if (interstitialAdListener != null) {
                interstitialAdListener.onDisplay(interstitialAd);
            }
        }

        @Override // com.my.target.ap.a
        public void onLoad() {
            InterstitialAd interstitialAd = InterstitialAd.this;
            InterstitialAdListener interstitialAdListener = interstitialAd.listener;
            if (interstitialAdListener != null) {
                interstitialAdListener.onLoad(interstitialAd);
            }
        }

        @Override // com.my.target.ap.a
        public void onNoAd(@NonNull String str) {
            InterstitialAd interstitialAd = InterstitialAd.this;
            InterstitialAdListener interstitialAdListener = interstitialAd.listener;
            if (interstitialAdListener != null) {
                interstitialAdListener.onNoAd(str, interstitialAd);
            }
        }

        @Override // com.my.target.ap.a
        public void onVideoCompleted() {
            InterstitialAd interstitialAd = InterstitialAd.this;
            InterstitialAdListener interstitialAdListener = interstitialAd.listener;
            if (interstitialAdListener != null) {
                interstitialAdListener.onVideoCompleted(interstitialAd);
            }
        }
    }

    public InterstitialAd(int i, @NonNull Context context) {
        super(i, Tracker.Events.CREATIVE_FULLSCREEN, context);
        ae.c("InterstitialAd created. Version: 5.12.2");
    }

    @Override // com.my.target.ads.BaseInterstitialAd
    public void a(@Nullable cq cqVar, @Nullable String str) {
        cl clVar;
        ca caVar;
        if (this.listener != null) {
            if (cqVar != null) {
                caVar = cqVar.bX();
                clVar = cqVar.bQ();
            } else {
                caVar = null;
                clVar = null;
            }
            if (caVar != null) {
                av a3 = av.a(caVar, cqVar, this.d, new b(null));
                this.c = a3;
                if (a3 != null) {
                    this.listener.onLoad(this);
                } else {
                    this.listener.onNoAd("no ad", this);
                }
            } else if (clVar != null) {
                ba a4 = ba.a(clVar, this.adConfig, new b(null));
                this.c = a4;
                a4.s(this.b);
            } else {
                InterstitialAdListener interstitialAdListener = this.listener;
                if (str == null) {
                    str = "no ad";
                }
                interstitialAdListener.onNoAd(str, this);
            }
        }
    }

    @Override // com.my.target.ads.BaseInterstitialAd
    public void destroy() {
        super.destroy();
        this.listener = null;
    }

    @Nullable
    public InterstitialAdListener getListener() {
        return this.listener;
    }

    public void setListener(@Nullable InterstitialAdListener interstitialAdListener) {
        this.listener = interstitialAdListener;
    }
}

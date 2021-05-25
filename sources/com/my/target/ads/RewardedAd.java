package com.my.target.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ae;
import com.my.target.ap;
import com.my.target.av;
import com.my.target.bd;
import com.my.target.ca;
import com.my.target.cl;
import com.my.target.cq;
public final class RewardedAd extends BaseInterstitialAd {
    @Nullable
    public RewardedAdListener listener;

    public interface RewardedAdListener {
        void onClick(@NonNull RewardedAd rewardedAd);

        void onDismiss(@NonNull RewardedAd rewardedAd);

        void onDisplay(@NonNull RewardedAd rewardedAd);

        void onLoad(@NonNull RewardedAd rewardedAd);

        void onNoAd(@NonNull String str, @NonNull RewardedAd rewardedAd);

        void onReward(@NonNull Reward reward, @NonNull RewardedAd rewardedAd);
    }

    public class b implements ap.a {
        public b(a aVar) {
        }

        @Override // com.my.target.ap.a
        public void onClick() {
            RewardedAd rewardedAd = RewardedAd.this;
            RewardedAdListener rewardedAdListener = rewardedAd.listener;
            if (rewardedAdListener != null) {
                rewardedAdListener.onClick(rewardedAd);
            }
        }

        @Override // com.my.target.ap.a
        public void onDismiss() {
            RewardedAd rewardedAd = RewardedAd.this;
            RewardedAdListener rewardedAdListener = rewardedAd.listener;
            if (rewardedAdListener != null) {
                rewardedAdListener.onDismiss(rewardedAd);
            }
        }

        @Override // com.my.target.ap.a
        public void onDisplay() {
            RewardedAd rewardedAd = RewardedAd.this;
            RewardedAdListener rewardedAdListener = rewardedAd.listener;
            if (rewardedAdListener != null) {
                rewardedAdListener.onDisplay(rewardedAd);
            }
        }

        @Override // com.my.target.ap.a
        public void onLoad() {
            RewardedAd rewardedAd = RewardedAd.this;
            RewardedAdListener rewardedAdListener = rewardedAd.listener;
            if (rewardedAdListener != null) {
                rewardedAdListener.onLoad(rewardedAd);
            }
        }

        @Override // com.my.target.ap.a
        public void onNoAd(@NonNull String str) {
            RewardedAd rewardedAd = RewardedAd.this;
            RewardedAdListener rewardedAdListener = rewardedAd.listener;
            if (rewardedAdListener != null) {
                rewardedAdListener.onNoAd(str, rewardedAd);
            }
        }

        @Override // com.my.target.ap.a
        public void onVideoCompleted() {
        }
    }

    public class c implements ap.b {
        public c(a aVar) {
        }

        @Override // com.my.target.ap.b
        public void onReward(@NonNull Reward reward) {
            RewardedAd rewardedAd = RewardedAd.this;
            RewardedAdListener rewardedAdListener = rewardedAd.listener;
            if (rewardedAdListener != null) {
                rewardedAdListener.onReward(reward, rewardedAd);
            }
        }
    }

    public RewardedAd(int i, @NonNull Context context) {
        super(i, "rewarded", context);
        ae.c("RewardedAd created. Version: 5.12.2");
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
                    a3.a(new c(null));
                    this.listener.onLoad(this);
                    return;
                }
                this.listener.onNoAd("no ad", this);
            } else if (clVar != null) {
                bd b2 = bd.b(clVar, this.adConfig, new b(null));
                b2.a(new c(null));
                this.c = b2;
                b2.s(this.b);
            } else {
                RewardedAdListener rewardedAdListener = this.listener;
                if (str == null) {
                    str = "no ad";
                }
                rewardedAdListener.onNoAd(str, this);
            }
        }
    }

    @Override // com.my.target.ads.BaseInterstitialAd
    public void destroy() {
        super.destroy();
        this.listener = null;
    }

    @Nullable
    public RewardedAdListener getListener() {
        return this.listener;
    }

    public void setListener(@Nullable RewardedAdListener rewardedAdListener) {
        this.listener = rewardedAdListener;
    }
}

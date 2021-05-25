package com.my.target.mediation;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ads.Reward;
import com.my.target.ads.RewardedAd;
import com.my.target.ae;
import com.my.target.common.CustomParams;
import com.my.target.cq;
import com.my.target.mediation.MediationRewardedAdAdapter;
import java.util.Map;
public final class MyTargetRewardedAdAdapter implements MediationRewardedAdAdapter {
    @Nullable
    public cq a;
    @Nullable
    public RewardedAd b;

    public class a implements RewardedAd.RewardedAdListener {
        @NonNull
        public final MediationRewardedAdAdapter.MediationRewardedAdListener a;

        public a(MediationRewardedAdAdapter.MediationRewardedAdListener mediationRewardedAdListener) {
            this.a = mediationRewardedAdListener;
        }

        @Override // com.my.target.ads.RewardedAd.RewardedAdListener
        public void onClick(@NonNull RewardedAd rewardedAd) {
            ae.a("MyTargetRewardedAdAdapter: ad clicked");
            this.a.onClick(MyTargetRewardedAdAdapter.this);
        }

        @Override // com.my.target.ads.RewardedAd.RewardedAdListener
        public void onDismiss(@NonNull RewardedAd rewardedAd) {
            ae.a("MyTargetRewardedAdAdapter: ad dismissed");
            this.a.onDismiss(MyTargetRewardedAdAdapter.this);
        }

        @Override // com.my.target.ads.RewardedAd.RewardedAdListener
        public void onDisplay(@NonNull RewardedAd rewardedAd) {
            ae.a("MyTargetRewardedAdAdapter: ad displayed");
            this.a.onDisplay(MyTargetRewardedAdAdapter.this);
        }

        @Override // com.my.target.ads.RewardedAd.RewardedAdListener
        public void onLoad(@NonNull RewardedAd rewardedAd) {
            ae.a("MyTargetRewardedAdAdapter: ad loaded");
            this.a.onLoad(MyTargetRewardedAdAdapter.this);
        }

        @Override // com.my.target.ads.RewardedAd.RewardedAdListener
        public void onNoAd(@NonNull String str, @NonNull RewardedAd rewardedAd) {
            ae.a("MyTargetRewardedAdAdapter: no ad (" + str + ")");
            this.a.onNoAd(str, MyTargetRewardedAdAdapter.this);
        }

        @Override // com.my.target.ads.RewardedAd.RewardedAdListener
        public void onReward(@NonNull Reward reward, @NonNull RewardedAd rewardedAd) {
            StringBuilder L = a2.b.a.a.a.L("MyTargetRewardedAdAdapter: onReward: ");
            L.append(reward.type);
            ae.a(L.toString());
            this.a.onReward(reward, MyTargetRewardedAdAdapter.this);
        }
    }

    @Override // com.my.target.mediation.MediationAdapter
    public void destroy() {
        RewardedAd rewardedAd = this.b;
        if (rewardedAd != null) {
            rewardedAd.setListener(null);
            this.b.destroy();
            this.b = null;
        }
    }

    @Override // com.my.target.mediation.MediationRewardedAdAdapter
    public void dismiss() {
        RewardedAd rewardedAd = this.b;
        if (rewardedAd != null) {
            rewardedAd.dismiss();
        }
    }

    @Override // com.my.target.mediation.MediationRewardedAdAdapter
    public void load(@NonNull MediationAdConfig mediationAdConfig, @NonNull MediationRewardedAdAdapter.MediationRewardedAdListener mediationRewardedAdListener, @NonNull Context context) {
        String placementId = mediationAdConfig.getPlacementId();
        try {
            int parseInt = Integer.parseInt(placementId);
            RewardedAd rewardedAd = new RewardedAd(parseInt, context);
            this.b = rewardedAd;
            rewardedAd.setMediationEnabled(false);
            this.b.setListener(new a(mediationRewardedAdListener));
            CustomParams customParams = this.b.getCustomParams();
            customParams.setAge(mediationAdConfig.getAge());
            customParams.setGender(mediationAdConfig.getGender());
            for (Map.Entry<String, String> entry : mediationAdConfig.getServerParams().entrySet()) {
                customParams.setCustomParam(entry.getKey(), entry.getValue());
            }
            String payload = mediationAdConfig.getPayload();
            if (this.a != null) {
                ae.a("MyTargetRewardedAdAdapter: got banner from mediation response");
                this.b.handleSection(this.a);
            } else if (TextUtils.isEmpty(payload)) {
                ae.a("MyTargetRewardedAdAdapter: load id " + parseInt);
                this.b.load();
            } else {
                ae.a("MyTargetRewardedAdAdapter: load id " + parseInt + " from BID " + payload);
                this.b.loadFromBid(payload);
            }
        } catch (Throwable unused) {
            String e3 = a2.b.a.a.a.e3("failed to request ad, unable to convert slotId ", placementId, " to int");
            ae.b("MyTargetRewardedAdAdapter error: " + e3);
            mediationRewardedAdListener.onNoAd(e3, this);
        }
    }

    public void setSection(@Nullable cq cqVar) {
        this.a = cqVar;
    }

    @Override // com.my.target.mediation.MediationRewardedAdAdapter
    public void show(@NonNull Context context) {
        RewardedAd rewardedAd = this.b;
        if (rewardedAd != null) {
            rewardedAd.show();
        }
    }
}

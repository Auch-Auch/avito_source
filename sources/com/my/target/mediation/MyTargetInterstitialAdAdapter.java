package com.my.target.mediation;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ads.InterstitialAd;
import com.my.target.ae;
import com.my.target.common.CustomParams;
import com.my.target.cq;
import com.my.target.mediation.MediationInterstitialAdAdapter;
import java.util.Map;
public final class MyTargetInterstitialAdAdapter implements MediationInterstitialAdAdapter {
    @Nullable
    public cq a;
    @Nullable
    public InterstitialAd b;

    public class a implements InterstitialAd.InterstitialAdListener {
        @NonNull
        public final MediationInterstitialAdAdapter.MediationInterstitialAdListener a;

        public a(MediationInterstitialAdAdapter.MediationInterstitialAdListener mediationInterstitialAdListener) {
            this.a = mediationInterstitialAdListener;
        }

        @Override // com.my.target.ads.InterstitialAd.InterstitialAdListener
        public void onClick(@NonNull InterstitialAd interstitialAd) {
            ae.a("MyTargetInterstitialAdAdapter: ad clicked");
            this.a.onClick(MyTargetInterstitialAdAdapter.this);
        }

        @Override // com.my.target.ads.InterstitialAd.InterstitialAdListener
        public void onDismiss(@NonNull InterstitialAd interstitialAd) {
            ae.a("MyTargetInterstitialAdAdapter: ad dismissed");
            this.a.onDismiss(MyTargetInterstitialAdAdapter.this);
        }

        @Override // com.my.target.ads.InterstitialAd.InterstitialAdListener
        public void onDisplay(@NonNull InterstitialAd interstitialAd) {
            ae.a("MyTargetInterstitialAdAdapter: ad displayed");
            this.a.onDisplay(MyTargetInterstitialAdAdapter.this);
        }

        @Override // com.my.target.ads.InterstitialAd.InterstitialAdListener
        public void onLoad(@NonNull InterstitialAd interstitialAd) {
            ae.a("MyTargetInterstitialAdAdapter: ad loaded");
            this.a.onLoad(MyTargetInterstitialAdAdapter.this);
        }

        @Override // com.my.target.ads.InterstitialAd.InterstitialAdListener
        public void onNoAd(@NonNull String str, @NonNull InterstitialAd interstitialAd) {
            ae.a("MyTargetInterstitialAdAdapter: no ad (" + str + ")");
            this.a.onNoAd(str, MyTargetInterstitialAdAdapter.this);
        }

        @Override // com.my.target.ads.InterstitialAd.InterstitialAdListener
        public void onVideoCompleted(@NonNull InterstitialAd interstitialAd) {
            ae.a("MyTargetInterstitialAdAdapter: video completed");
            this.a.onVideoCompleted(MyTargetInterstitialAdAdapter.this);
        }
    }

    @Override // com.my.target.mediation.MediationAdapter
    public void destroy() {
        InterstitialAd interstitialAd = this.b;
        if (interstitialAd != null) {
            interstitialAd.setListener(null);
            this.b.destroy();
            this.b = null;
        }
    }

    @Override // com.my.target.mediation.MediationInterstitialAdAdapter
    public void dismiss() {
        InterstitialAd interstitialAd = this.b;
        if (interstitialAd != null) {
            interstitialAd.dismiss();
        }
    }

    @Override // com.my.target.mediation.MediationInterstitialAdAdapter
    public void load(@NonNull MediationAdConfig mediationAdConfig, @NonNull MediationInterstitialAdAdapter.MediationInterstitialAdListener mediationInterstitialAdListener, @NonNull Context context) {
        String placementId = mediationAdConfig.getPlacementId();
        try {
            int parseInt = Integer.parseInt(placementId);
            InterstitialAd interstitialAd = new InterstitialAd(parseInt, context);
            this.b = interstitialAd;
            interstitialAd.setMediationEnabled(false);
            this.b.setListener(new a(mediationInterstitialAdListener));
            CustomParams customParams = this.b.getCustomParams();
            customParams.setAge(mediationAdConfig.getAge());
            customParams.setGender(mediationAdConfig.getGender());
            for (Map.Entry<String, String> entry : mediationAdConfig.getServerParams().entrySet()) {
                customParams.setCustomParam(entry.getKey(), entry.getValue());
            }
            String payload = mediationAdConfig.getPayload();
            if (this.a != null) {
                ae.a("MyTargetInterstitialAdAdapter: got banner from mediation response");
                this.b.handleSection(this.a);
            } else if (TextUtils.isEmpty(payload)) {
                ae.a("MyTargetInterstitialAdAdapter: load id " + parseInt);
                this.b.load();
            } else {
                ae.a("MyTargetInterstitialAdAdapter: load id " + parseInt + " from BID " + payload);
                this.b.loadFromBid(payload);
            }
        } catch (Throwable unused) {
            String e3 = a2.b.a.a.a.e3("failed to request ad, unable to convert slotId ", placementId, " to int");
            ae.b("MyTargetInterstitialAdAdapter error: " + e3);
            mediationInterstitialAdListener.onNoAd(e3, this);
        }
    }

    public void setSection(@Nullable cq cqVar) {
        this.a = cqVar;
    }

    @Override // com.my.target.mediation.MediationInterstitialAdAdapter
    public void show(@NonNull Context context) {
        InterstitialAd interstitialAd = this.b;
        if (interstitialAd != null) {
            interstitialAd.show();
        }
    }
}

package com.my.target.mediation;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ae;
import com.my.target.common.CustomParams;
import com.my.target.cs;
import com.my.target.mediation.MediationNativeBannerAdAdapter;
import com.my.target.nativeads.NativeBannerAd;
import com.my.target.nativeads.banners.NativeBanner;
import java.util.List;
import java.util.Map;
public final class MyTargetNativeBannerAdAdapter implements MediationNativeBannerAdAdapter {
    @Nullable
    public cs a;
    @Nullable
    public NativeBannerAd b;

    public class a implements NativeBannerAd.NativeBannerAdListener {
        @NonNull
        public final MediationNativeBannerAdAdapter.MediationNativeBannerAdListener a;

        public a(MediationNativeBannerAdAdapter.MediationNativeBannerAdListener mediationNativeBannerAdListener) {
            this.a = mediationNativeBannerAdListener;
        }

        @Override // com.my.target.nativeads.NativeBannerAd.NativeBannerAdListener
        public void onClick(@NonNull NativeBannerAd nativeBannerAd) {
            ae.a("MyTargetNativeBannerAdAdapter: ad clicked");
            this.a.onClick(MyTargetNativeBannerAdAdapter.this);
        }

        @Override // com.my.target.nativeads.NativeBannerAd.NativeBannerAdListener
        public void onLoad(@NonNull NativeBanner nativeBanner, @NonNull NativeBannerAd nativeBannerAd) {
            ae.a("MyTargetNativeBannerAdAdapter: ad loaded");
            this.a.onLoad(nativeBanner, MyTargetNativeBannerAdAdapter.this);
        }

        @Override // com.my.target.nativeads.NativeBannerAd.NativeBannerAdListener
        public void onNoAd(@NonNull String str, @NonNull NativeBannerAd nativeBannerAd) {
            ae.a("MyTargetNativeBannerAdAdapter: no ad (" + str + ")");
            this.a.onNoAd(str, MyTargetNativeBannerAdAdapter.this);
        }

        @Override // com.my.target.nativeads.NativeBannerAd.NativeBannerAdListener
        public void onShow(@NonNull NativeBannerAd nativeBannerAd) {
            ae.a("MyTargetNativeBannerAdAdapter: ad shown");
            this.a.onShow(MyTargetNativeBannerAdAdapter.this);
        }
    }

    @Override // com.my.target.mediation.MediationAdapter
    public void destroy() {
        NativeBannerAd nativeBannerAd = this.b;
        if (nativeBannerAd != null) {
            nativeBannerAd.unregisterView();
            this.b.setListener(null);
            this.b = null;
        }
    }

    @Override // com.my.target.mediation.MediationNativeBannerAdAdapter
    @Nullable
    public View getIconView(@NonNull Context context) {
        return null;
    }

    @Override // com.my.target.mediation.MediationNativeBannerAdAdapter
    public void load(@NonNull MediationNativeBannerAdConfig mediationNativeBannerAdConfig, @NonNull MediationNativeBannerAdAdapter.MediationNativeBannerAdListener mediationNativeBannerAdListener, @NonNull Context context) {
        String placementId = mediationNativeBannerAdConfig.getPlacementId();
        try {
            int parseInt = Integer.parseInt(placementId);
            NativeBannerAd nativeBannerAd = new NativeBannerAd(parseInt, context);
            this.b = nativeBannerAd;
            nativeBannerAd.setMediationEnabled(false);
            this.b.setListener(new a(mediationNativeBannerAdListener));
            this.b.setCachePolicy(mediationNativeBannerAdConfig.getCachePolicy());
            CustomParams customParams = this.b.getCustomParams();
            customParams.setAge(mediationNativeBannerAdConfig.getAge());
            customParams.setGender(mediationNativeBannerAdConfig.getGender());
            for (Map.Entry<String, String> entry : mediationNativeBannerAdConfig.getServerParams().entrySet()) {
                customParams.setCustomParam(entry.getKey(), entry.getValue());
            }
            String payload = mediationNativeBannerAdConfig.getPayload();
            if (this.a != null) {
                ae.a("MyTargetNativeBannerAdAdapter: got banner from mediation response");
                this.b.handleSection(this.a);
            } else if (TextUtils.isEmpty(payload)) {
                ae.a("MyTargetNativeBannerAdAdapter: load id " + parseInt);
                this.b.load();
            } else {
                ae.a("MyTargetNativeBannerAdAdapter: load id " + parseInt + " from BID " + payload);
                this.b.loadFromBid(payload);
            }
        } catch (Throwable unused) {
            String e3 = a2.b.a.a.a.e3("failed to request ad, unable to convert slotId ", placementId, " to int");
            ae.b("MyTargetNativeBannerAdAdapter error: " + e3);
            mediationNativeBannerAdListener.onNoAd(e3, this);
        }
    }

    @Override // com.my.target.mediation.MediationNativeBannerAdAdapter
    public void registerView(@NonNull View view, @Nullable List<View> list, int i) {
        NativeBannerAd nativeBannerAd = this.b;
        if (nativeBannerAd != null) {
            nativeBannerAd.setAdChoicesPlacement(i);
            this.b.registerView(view, list);
        }
    }

    public void setSection(@Nullable cs csVar) {
        this.a = csVar;
    }

    @Override // com.my.target.mediation.MediationNativeBannerAdAdapter
    public void unregisterView() {
        NativeBannerAd nativeBannerAd = this.b;
        if (nativeBannerAd != null) {
            nativeBannerAd.unregisterView();
        }
    }
}

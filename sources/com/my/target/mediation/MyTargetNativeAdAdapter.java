package com.my.target.mediation;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ae;
import com.my.target.common.CustomParams;
import com.my.target.cs;
import com.my.target.mediation.MediationNativeAdAdapter;
import com.my.target.nativeads.NativeAd;
import com.my.target.nativeads.banners.NativePromoBanner;
import java.util.List;
import java.util.Map;
public final class MyTargetNativeAdAdapter implements MediationNativeAdAdapter {
    @Nullable
    public cs a;
    @Nullable
    public NativeAd b;

    public class a implements NativeAd.NativeAdListener {
        @NonNull
        public final MediationNativeAdAdapter.MediationNativeAdListener a;

        public a(MediationNativeAdAdapter.MediationNativeAdListener mediationNativeAdListener) {
            this.a = mediationNativeAdListener;
        }

        @Override // com.my.target.nativeads.NativeAd.NativeAdListener
        public void onClick(@NonNull NativeAd nativeAd) {
            ae.a("MyTargetNativeAdAdapter: ad clicked");
            this.a.onClick(MyTargetNativeAdAdapter.this);
        }

        @Override // com.my.target.nativeads.NativeAd.NativeAdListener
        public void onLoad(@NonNull NativePromoBanner nativePromoBanner, @NonNull NativeAd nativeAd) {
            ae.a("MyTargetNativeAdAdapter: ad loaded");
            this.a.onLoad(nativePromoBanner, MyTargetNativeAdAdapter.this);
        }

        @Override // com.my.target.nativeads.NativeAd.NativeAdListener
        public void onNoAd(@NonNull String str, @NonNull NativeAd nativeAd) {
            ae.a("MyTargetNativeAdAdapter: no ad (" + str + ")");
            this.a.onNoAd(str, MyTargetNativeAdAdapter.this);
        }

        @Override // com.my.target.nativeads.NativeAd.NativeAdListener
        public void onShow(@NonNull NativeAd nativeAd) {
            ae.a("MyTargetNativeAdAdapter: ad shown");
            this.a.onShow(MyTargetNativeAdAdapter.this);
        }

        @Override // com.my.target.nativeads.NativeAd.NativeAdListener
        public void onVideoComplete(@NonNull NativeAd nativeAd) {
            ae.a("MyTargetNativeAdAdapter: video completed");
            this.a.onVideoComplete(MyTargetNativeAdAdapter.this);
        }

        @Override // com.my.target.nativeads.NativeAd.NativeAdListener
        public void onVideoPause(@NonNull NativeAd nativeAd) {
            ae.a("MyTargetNativeAdAdapter: video paused");
            this.a.onVideoPause(MyTargetNativeAdAdapter.this);
        }

        @Override // com.my.target.nativeads.NativeAd.NativeAdListener
        public void onVideoPlay(@NonNull NativeAd nativeAd) {
            ae.a("MyTargetNativeAdAdapter: video playing");
            this.a.onVideoPlay(MyTargetNativeAdAdapter.this);
        }
    }

    @Override // com.my.target.mediation.MediationAdapter
    public void destroy() {
        NativeAd nativeAd = this.b;
        if (nativeAd != null) {
            nativeAd.unregisterView();
            this.b.setListener(null);
            this.b = null;
        }
    }

    @Override // com.my.target.mediation.MediationNativeAdAdapter
    @Nullable
    public View getMediaView(@NonNull Context context) {
        return null;
    }

    @Override // com.my.target.mediation.MediationNativeAdAdapter
    public void load(@NonNull MediationNativeAdConfig mediationNativeAdConfig, @NonNull MediationNativeAdAdapter.MediationNativeAdListener mediationNativeAdListener, @NonNull Context context) {
        String placementId = mediationNativeAdConfig.getPlacementId();
        try {
            int parseInt = Integer.parseInt(placementId);
            NativeAd nativeAd = new NativeAd(parseInt, context);
            this.b = nativeAd;
            nativeAd.setMediationEnabled(false);
            this.b.setListener(new a(mediationNativeAdListener));
            this.b.setCachePolicy(mediationNativeAdConfig.getCachePolicy());
            CustomParams customParams = this.b.getCustomParams();
            customParams.setAge(mediationNativeAdConfig.getAge());
            customParams.setGender(mediationNativeAdConfig.getGender());
            for (Map.Entry<String, String> entry : mediationNativeAdConfig.getServerParams().entrySet()) {
                customParams.setCustomParam(entry.getKey(), entry.getValue());
            }
            String payload = mediationNativeAdConfig.getPayload();
            if (this.a != null) {
                ae.a("MyTargetNativeAdAdapter: got banner from mediation response");
                this.b.handleSection(this.a);
            } else if (TextUtils.isEmpty(payload)) {
                ae.a("MyTargetNativeAdAdapter: load id " + parseInt);
                this.b.load();
            } else {
                ae.a("MyTargetNativeAdAdapter: load id " + parseInt + " from BID " + payload);
                this.b.loadFromBid(payload);
            }
        } catch (Throwable unused) {
            String e3 = a2.b.a.a.a.e3("failed to request ad, unable to convert slotId ", placementId, " to int");
            ae.b("MyTargetNativeAdAdapter error: " + e3);
            mediationNativeAdListener.onNoAd(e3, this);
        }
    }

    @Override // com.my.target.mediation.MediationNativeAdAdapter
    public void registerView(@NonNull View view, @Nullable List<View> list, int i) {
        NativeAd nativeAd = this.b;
        if (nativeAd != null) {
            nativeAd.setAdChoicesPlacement(i);
            this.b.registerView(view, list);
        }
    }

    public void setSection(@Nullable cs csVar) {
        this.a = csVar;
    }

    @Override // com.my.target.mediation.MediationNativeAdAdapter
    public void unregisterView() {
        NativeAd nativeAd = this.b;
        if (nativeAd != null) {
            nativeAd.unregisterView();
        }
    }
}

package com.my.target.mediation;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ads.MyTargetView;
import com.my.target.ae;
import com.my.target.common.CustomParams;
import com.my.target.cu;
import com.my.target.mediation.MediationStandardAdAdapter;
import java.util.Map;
public final class MyTargetStandardAdAdapter implements MediationStandardAdAdapter {
    @Nullable
    public cu a;
    @Nullable
    public MyTargetView b;

    public class a implements MyTargetView.MyTargetViewListener {
        @NonNull
        public final MediationStandardAdAdapter.MediationStandardAdListener a;

        public a(MediationStandardAdAdapter.MediationStandardAdListener mediationStandardAdListener) {
            this.a = mediationStandardAdListener;
        }

        @Override // com.my.target.ads.MyTargetView.MyTargetViewListener
        public void onClick(@NonNull MyTargetView myTargetView) {
            ae.a("MyTargetStandardAdAdapter: ad clicked");
            this.a.onClick(MyTargetStandardAdAdapter.this);
        }

        @Override // com.my.target.ads.MyTargetView.MyTargetViewListener
        public void onLoad(@NonNull MyTargetView myTargetView) {
            ae.a("MyTargetStandardAdAdapter: ad loaded");
            this.a.onLoad(myTargetView, MyTargetStandardAdAdapter.this);
        }

        @Override // com.my.target.ads.MyTargetView.MyTargetViewListener
        public void onNoAd(@NonNull String str, @NonNull MyTargetView myTargetView) {
            ae.a("MyTargetStandardAdAdapter: no ad (" + str + ")");
            this.a.onNoAd(str, MyTargetStandardAdAdapter.this);
        }

        @Override // com.my.target.ads.MyTargetView.MyTargetViewListener
        public void onShow(@NonNull MyTargetView myTargetView) {
            ae.a("MyTargetStandardAdAdapter: ad shown");
            this.a.onShow(MyTargetStandardAdAdapter.this);
        }
    }

    @Override // com.my.target.mediation.MediationAdapter
    public void destroy() {
        MyTargetView myTargetView = this.b;
        if (myTargetView != null) {
            myTargetView.setListener(null);
            this.b.destroy();
            this.b = null;
        }
    }

    @Override // com.my.target.mediation.MediationStandardAdAdapter
    public void load(@NonNull MediationAdConfig mediationAdConfig, @NonNull MyTargetView.AdSize adSize, @NonNull MediationStandardAdAdapter.MediationStandardAdListener mediationStandardAdListener, @NonNull Context context) {
        String placementId = mediationAdConfig.getPlacementId();
        try {
            int parseInt = Integer.parseInt(placementId);
            MyTargetView myTargetView = new MyTargetView(context);
            this.b = myTargetView;
            myTargetView.setSlotId(parseInt);
            this.b.setAdSize(adSize);
            this.b.setRefreshAd(false);
            this.b.setMediationEnabled(false);
            this.b.setListener(new a(mediationStandardAdListener));
            CustomParams customParams = this.b.getCustomParams();
            customParams.setAge(mediationAdConfig.getAge());
            customParams.setGender(mediationAdConfig.getGender());
            for (Map.Entry<String, String> entry : mediationAdConfig.getServerParams().entrySet()) {
                customParams.setCustomParam(entry.getKey(), entry.getValue());
            }
            String payload = mediationAdConfig.getPayload();
            if (this.a != null) {
                ae.a("MyTargetStandardAdAdapter: got banner from mediation response");
                this.b.handleSection(this.a, adSize);
            } else if (TextUtils.isEmpty(payload)) {
                ae.a("MyTargetStandardAdAdapter: load id " + parseInt);
                this.b.load();
            } else {
                ae.a("MyTargetStandardAdAdapter: load id " + parseInt + " from BID " + payload);
                this.b.loadFromBid(payload);
            }
        } catch (Throwable unused) {
            String e3 = a2.b.a.a.a.e3("failed to request ad, unable to convert slotId ", placementId, " to int");
            ae.b("MyTargetStandardAdAdapter error: " + e3);
            mediationStandardAdListener.onNoAd(e3, this);
        }
    }

    public void setSection(@Nullable cu cuVar) {
        this.a = cuVar;
    }
}

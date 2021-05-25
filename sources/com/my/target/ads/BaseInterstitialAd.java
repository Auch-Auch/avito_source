package com.my.target.ads;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ae;
import com.my.target.ap;
import com.my.target.cn;
import com.my.target.common.BaseAd;
import com.my.target.cq;
import com.my.target.il;
import com.my.target.o;
public abstract class BaseInterstitialAd extends BaseAd {
    @NonNull
    public final Context b;
    @Nullable
    public ap c;
    public boolean d = true;

    public class a implements o.b {
        public a() {
        }

        @Override // com.my.target.b.AbstractC0305b
        public void onResult(@Nullable cn cnVar, @Nullable String str) {
            BaseInterstitialAd.this.a((cq) cnVar, str);
        }
    }

    public class b implements o.b {
        public b() {
        }

        @Override // com.my.target.b.AbstractC0305b
        public void onResult(@Nullable cn cnVar, @Nullable String str) {
            BaseInterstitialAd.this.a((cq) cnVar, str);
        }
    }

    public BaseInterstitialAd(int i, @NonNull String str, @NonNull Context context) {
        super(i, str);
        this.b = context;
    }

    public abstract void a(@Nullable cq cqVar, @Nullable String str);

    public void destroy() {
        ap apVar = this.c;
        if (apVar != null) {
            apVar.destroy();
            this.c = null;
        }
    }

    public void dismiss() {
        ap apVar = this.c;
        if (apVar != null) {
            apVar.dismiss();
        }
    }

    @Nullable
    public String getAdSource() {
        ap apVar = this.c;
        if (apVar != null) {
            return apVar.ad();
        }
        return null;
    }

    public float getAdSourcePriority() {
        ap apVar = this.c;
        if (apVar != null) {
            return apVar.ae();
        }
        return 0.0f;
    }

    public final void handleSection(@NonNull cq cqVar) {
        o.a(cqVar, this.adConfig).a(new b()).a(this.b);
    }

    public boolean isMediationEnabled() {
        return this.adConfig.isMediationEnabled();
    }

    public boolean isUseExoPlayer() {
        return this.d;
    }

    public final void load() {
        if (isLoadCalled()) {
            ae.a("Interstitial/Rewarded doesn't support multiple load");
        } else {
            o.a(this.adConfig).a(new a()).a(this.b);
        }
    }

    public void loadFromBid(@NonNull String str) {
        this.adConfig.setBidId(str);
        load();
    }

    public void setMediationEnabled(boolean z) {
        this.adConfig.setMediationEnabled(z);
    }

    public void show() {
        show(null);
    }

    public void show(@Nullable Context context) {
        ap apVar = this.c;
        if (apVar == null) {
            ae.c("InterstitialAd.show: No ad");
            return;
        }
        if (context == null) {
            context = this.b;
        }
        apVar.o(context);
    }

    public void useExoPlayer(boolean z) {
        this.d = z;
        if (!z) {
            il.fe();
        }
    }
}

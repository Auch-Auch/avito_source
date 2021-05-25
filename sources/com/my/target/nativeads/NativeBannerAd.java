package com.my.target.nativeads;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.Cif;
import com.my.target.ae;
import com.my.target.ar;
import com.my.target.bc;
import com.my.target.bh;
import com.my.target.cg;
import com.my.target.cl;
import com.my.target.cn;
import com.my.target.common.BaseAd;
import com.my.target.cs;
import com.my.target.nativeads.banners.NativeBanner;
import com.my.target.s;
import java.util.List;
public final class NativeBannerAd extends BaseAd implements INativeAd {
    @NonNull
    public final Context b;
    @Nullable
    public ar c;
    @Nullable
    public NativeBannerAdListener d;
    @Nullable
    public NativeBannerAdMediaListener e;
    public int f = 0;

    public interface NativeBannerAdListener {
        void onClick(@NonNull NativeBannerAd nativeBannerAd);

        void onLoad(@NonNull NativeBanner nativeBanner, @NonNull NativeBannerAd nativeBannerAd);

        void onNoAd(@NonNull String str, @NonNull NativeBannerAd nativeBannerAd);

        void onShow(@NonNull NativeBannerAd nativeBannerAd);
    }

    public interface NativeBannerAdMediaListener {
        void onIconLoad(@NonNull NativeBannerAd nativeBannerAd);
    }

    public class a implements s.b {
        public a() {
        }

        @Override // com.my.target.b.AbstractC0305b
        public void onResult(@Nullable cn cnVar, @Nullable String str) {
            NativeBannerAd.a(NativeBannerAd.this, (cs) cnVar, str);
        }
    }

    public class b implements s.b {
        public b() {
        }

        @Override // com.my.target.b.AbstractC0305b
        public void onResult(@Nullable cn cnVar, @Nullable String str) {
            NativeBannerAd.a(NativeBannerAd.this, (cs) cnVar, str);
        }
    }

    public class c implements s.b {
        public c() {
        }

        @Override // com.my.target.b.AbstractC0305b
        public void onResult(@Nullable cn cnVar, @Nullable String str) {
            NativeBannerAd.a(NativeBannerAd.this, (cs) cnVar, str);
        }
    }

    public NativeBannerAd(int i, @NonNull Context context) {
        super(i, "nativebanner");
        this.b = context.getApplicationContext();
        ae.c("NativeBannerAd created. Version: 5.12.2");
    }

    public static void a(NativeBannerAd nativeBannerAd, cs csVar, String str) {
        cl clVar;
        if (nativeBannerAd.d != null) {
            cg cgVar = null;
            if (csVar != null) {
                cgVar = csVar.ch();
                clVar = csVar.bQ();
            } else {
                clVar = null;
            }
            if (cgVar != null) {
                bh a3 = bh.a(nativeBannerAd, cgVar);
                nativeBannerAd.c = a3;
                a3.setMediaListener(nativeBannerAd.e);
                NativeBanner ag = nativeBannerAd.c.ag();
                if (ag != null) {
                    nativeBannerAd.d.onLoad(ag, nativeBannerAd);
                }
            } else if (clVar != null) {
                bc a4 = bc.a(nativeBannerAd, clVar, nativeBannerAd.adConfig);
                nativeBannerAd.c = a4;
                a4.s(nativeBannerAd.b);
            } else {
                NativeBannerAdListener nativeBannerAdListener = nativeBannerAd.d;
                if (str == null) {
                    str = "no ad";
                }
                nativeBannerAdListener.onNoAd(str, nativeBannerAd);
            }
        }
    }

    @Override // com.my.target.nativeads.INativeAd
    public int getAdChoicesPlacement() {
        return this.f;
    }

    @Nullable
    public String getAdSource() {
        ar arVar = this.c;
        if (arVar != null) {
            return arVar.ad();
        }
        return null;
    }

    public float getAdSourcePriority() {
        ar arVar = this.c;
        if (arVar != null) {
            return arVar.ae();
        }
        return 0.0f;
    }

    @Nullable
    public NativeBanner getBanner() {
        ar arVar = this.c;
        if (arVar == null) {
            return null;
        }
        return arVar.ag();
    }

    @Override // com.my.target.nativeads.INativeAd
    public int getCachePolicy() {
        return this.adConfig.getCachePolicy();
    }

    @Nullable
    public NativeBannerAdListener getListener() {
        return this.d;
    }

    @Nullable
    public NativeBannerAdMediaListener getMediaListener() {
        return this.e;
    }

    @Override // com.my.target.nativeads.INativeAd
    public void handleData(@NonNull String str) {
        s.a(str, this.adConfig).a(new c()).a(this.b);
    }

    public final void handleSection(@NonNull cs csVar) {
        s.a(csVar, this.adConfig).a(new b()).a(this.b);
    }

    public boolean isMediationEnabled() {
        return this.adConfig.isMediationEnabled();
    }

    @Override // com.my.target.nativeads.INativeAd
    public final void load() {
        if (isLoadCalled()) {
            ae.a("NativeBannerAd doesn't support multiple load");
        } else {
            s.a(this.adConfig).a(new a()).a(this.b);
        }
    }

    @Override // com.my.target.nativeads.INativeAd
    public void loadFromBid(@NonNull String str) {
        this.adConfig.setBidId(str);
        load();
    }

    @Override // com.my.target.nativeads.INativeAd
    public final void registerView(@NonNull View view) {
        registerView(view, null);
    }

    @Override // com.my.target.nativeads.INativeAd
    public final void registerView(@NonNull View view, @Nullable List<View> list) {
        Cif.a(view, this);
        ar arVar = this.c;
        if (arVar != null) {
            arVar.registerView(view, list, this.f);
        }
    }

    @Override // com.my.target.nativeads.INativeAd
    public void setAdChoicesPlacement(int i) {
        this.f = i;
    }

    @Override // com.my.target.nativeads.INativeAd
    public void setCachePolicy(int i) {
        this.adConfig.setCachePolicy(i);
    }

    public void setListener(@Nullable NativeBannerAdListener nativeBannerAdListener) {
        this.d = nativeBannerAdListener;
    }

    public void setMediaListener(@Nullable NativeBannerAdMediaListener nativeBannerAdMediaListener) {
        this.e = nativeBannerAdMediaListener;
        ar arVar = this.c;
        if (arVar != null) {
            arVar.setMediaListener(nativeBannerAdMediaListener);
        }
    }

    public void setMediationEnabled(boolean z) {
        this.adConfig.setMediationEnabled(z);
    }

    @Override // com.my.target.nativeads.INativeAd
    public final void unregisterView() {
        Cif.a(this);
        ar arVar = this.c;
        if (arVar != null) {
            arVar.unregisterView();
        }
    }
}

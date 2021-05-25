package com.my.target.nativeads;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.Cif;
import com.my.target.ae;
import com.my.target.aq;
import com.my.target.bb;
import com.my.target.bf;
import com.my.target.cg;
import com.my.target.cl;
import com.my.target.cn;
import com.my.target.common.BaseAd;
import com.my.target.cs;
import com.my.target.il;
import com.my.target.nativeads.banners.NativePromoBanner;
import com.my.target.s;
import java.util.List;
public final class NativeAd extends BaseAd implements INativeAd {
    @NonNull
    public final Context b;
    @Nullable
    public aq c;
    @Nullable
    public NativeAdListener d;
    @Nullable
    public NativeAdMediaListener e;
    public int f = 0;
    public boolean g = true;

    public interface NativeAdListener {
        void onClick(@NonNull NativeAd nativeAd);

        void onLoad(@NonNull NativePromoBanner nativePromoBanner, @NonNull NativeAd nativeAd);

        void onNoAd(@NonNull String str, @NonNull NativeAd nativeAd);

        void onShow(@NonNull NativeAd nativeAd);

        void onVideoComplete(@NonNull NativeAd nativeAd);

        void onVideoPause(@NonNull NativeAd nativeAd);

        void onVideoPlay(@NonNull NativeAd nativeAd);
    }

    public interface NativeAdMediaListener {
        void onIconLoad(@NonNull NativeAd nativeAd);

        void onImageLoad(@NonNull NativeAd nativeAd);
    }

    public class a implements s.b {
        public a() {
        }

        @Override // com.my.target.b.AbstractC0305b
        public void onResult(@Nullable cn cnVar, @Nullable String str) {
            NativeAd.a(NativeAd.this, (cs) cnVar, str);
        }
    }

    public class b implements s.b {
        public b() {
        }

        @Override // com.my.target.b.AbstractC0305b
        public void onResult(@Nullable cn cnVar, @Nullable String str) {
            NativeAd.a(NativeAd.this, (cs) cnVar, str);
        }
    }

    public class c implements s.b {
        public c() {
        }

        @Override // com.my.target.b.AbstractC0305b
        public void onResult(@Nullable cn cnVar, @Nullable String str) {
            NativeAd.a(NativeAd.this, (cs) cnVar, str);
        }
    }

    public NativeAd(int i, @NonNull Context context) {
        super(i, "nativeads");
        this.b = context.getApplicationContext();
        ae.c("NativeAd created. Version: 5.12.2");
    }

    public static void a(NativeAd nativeAd, cs csVar, String str) {
        cl clVar;
        if (nativeAd.d != null) {
            cg cgVar = null;
            if (csVar != null) {
                cgVar = csVar.ch();
                clVar = csVar.bQ();
            } else {
                clVar = null;
            }
            if (cgVar != null) {
                bf a3 = bf.a(nativeAd, cgVar);
                nativeAd.c = a3;
                a3.setMediaListener(nativeAd.e);
                if (nativeAd.c.af() != null) {
                    nativeAd.d.onLoad(nativeAd.c.af(), nativeAd);
                }
            } else if (clVar != null) {
                bb a4 = bb.a(nativeAd, clVar, nativeAd.adConfig);
                nativeAd.c = a4;
                a4.s(nativeAd.b);
            } else {
                NativeAdListener nativeAdListener = nativeAd.d;
                if (str == null) {
                    str = "no ad";
                }
                nativeAdListener.onNoAd(str, nativeAd);
            }
        }
    }

    @Override // com.my.target.nativeads.INativeAd
    public int getAdChoicesPlacement() {
        return this.f;
    }

    @Nullable
    public String getAdSource() {
        aq aqVar = this.c;
        if (aqVar != null) {
            return aqVar.ad();
        }
        return null;
    }

    public float getAdSourcePriority() {
        aq aqVar = this.c;
        if (aqVar != null) {
            return aqVar.ae();
        }
        return 0.0f;
    }

    @Nullable
    public NativePromoBanner getBanner() {
        aq aqVar = this.c;
        if (aqVar == null) {
            return null;
        }
        return aqVar.af();
    }

    @Override // com.my.target.nativeads.INativeAd
    public int getCachePolicy() {
        return this.adConfig.getCachePolicy();
    }

    @Nullable
    public NativeAdListener getListener() {
        return this.d;
    }

    @Nullable
    public NativeAdMediaListener getMediaListener() {
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

    public boolean isUseExoPlayer() {
        return this.g;
    }

    @Override // com.my.target.nativeads.INativeAd
    public final void load() {
        if (isLoadCalled()) {
            ae.a("NativeAd doesn't support multiple load");
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
        aq aqVar = this.c;
        if (aqVar != null) {
            aqVar.a(view, list, this.f, null);
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

    public void setListener(@Nullable NativeAdListener nativeAdListener) {
        this.d = nativeAdListener;
    }

    public void setMediaListener(@Nullable NativeAdMediaListener nativeAdMediaListener) {
        this.e = nativeAdMediaListener;
        aq aqVar = this.c;
        if (aqVar != null) {
            aqVar.setMediaListener(nativeAdMediaListener);
        }
    }

    public void setMediationEnabled(boolean z) {
        this.adConfig.setMediationEnabled(z);
    }

    @Override // com.my.target.nativeads.INativeAd
    public final void unregisterView() {
        Cif.a(this);
        aq aqVar = this.c;
        if (aqVar != null) {
            aqVar.unregisterView();
        }
    }

    public void useExoPlayer(boolean z) {
        this.g = z;
        if (!z) {
            il.fe();
        }
    }
}

package com.my.target;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.an;
import com.my.target.nativeads.NativeAd;
import com.my.target.nativeads.banners.NativePromoBanner;
import com.my.target.nativeads.views.MediaAdView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class bf implements aq {
    @NonNull
    public final NativeAd a;
    @NonNull
    public final ArrayList<ch> b = new ArrayList<>();
    @NonNull
    public final ArrayList<ch> c = new ArrayList<>();
    @NonNull
    public final cg d;
    @NonNull
    public final hx e = hx.eC();
    @NonNull
    public final an f;
    @Nullable
    public final NativePromoBanner g;
    @Nullable
    public NativeAd.NativeAdMediaListener h;
    public boolean i;

    public static class a implements an.b {
        @NonNull
        public final bf a;
        @NonNull
        public final NativeAd b;

        public a(@NonNull bf bfVar, @NonNull NativeAd nativeAd) {
            this.a = bfVar;
            this.b = nativeAd;
        }

        @Override // com.my.target.am.b
        public void R() {
            bf bfVar = this.a;
            NativeAd.NativeAdListener listener = bfVar.a.getListener();
            if (listener != null) {
                listener.onVideoPlay(bfVar.a);
            }
        }

        @Override // com.my.target.am.b
        public void S() {
            bf bfVar = this.a;
            NativeAd.NativeAdListener listener = bfVar.a.getListener();
            if (listener != null) {
                listener.onVideoPause(bfVar.a);
            }
        }

        @Override // com.my.target.am.b
        public void T() {
            bf bfVar = this.a;
            NativeAd.NativeAdListener listener = bfVar.a.getListener();
            if (listener != null) {
                listener.onVideoComplete(bfVar.a);
            }
        }

        @Override // com.my.target.am.b
        public void U() {
            bf bfVar = this.a;
            Objects.requireNonNull(bfVar);
            ae.a("Video error");
            bfVar.f.W();
        }

        @Override // com.my.target.al.a
        public void a(@NonNull ci ciVar, @Nullable String str, @NonNull Context context) {
            bf bfVar = this.a;
            Objects.requireNonNull(bfVar);
            ae.a("Click on native content received");
            bfVar.c(ciVar, str, context);
            im.a(bfVar.d.getStatHolder().K("click"), context);
        }

        @Override // com.my.target.an.b
        public void ab() {
            NativeAd.NativeAdMediaListener nativeAdMediaListener = this.a.h;
            if (nativeAdMediaListener != null) {
                nativeAdMediaListener.onIconLoad(this.b);
            }
        }

        @Override // com.my.target.an.b
        public void ac() {
            NativeAd.NativeAdMediaListener nativeAdMediaListener = this.a.h;
            if (nativeAdMediaListener != null) {
                nativeAdMediaListener.onImageLoad(this.b);
            }
        }

        @Override // com.my.target.gn.a
        public void b(int i, @NonNull Context context) {
            bf bfVar = this.a;
            List<ch> nativeAdCards = bfVar.d.getNativeAdCards();
            ch chVar = (i < 0 || i >= nativeAdCards.size()) ? null : nativeAdCards.get(i);
            if (chVar != null && !bfVar.c.contains(chVar)) {
                im.a(chVar.getStatHolder().K("render"), context);
                bfVar.c.add(chVar);
            }
        }

        @Override // com.my.target.gn.a
        public void b(@NonNull int[] iArr, @NonNull Context context) {
            this.a.b(iArr, context);
        }

        @Override // com.my.target.an.b
        public void n(@NonNull Context context) {
            bf bfVar = this.a;
            if (!bfVar.i) {
                bfVar.i = true;
                im.a(bfVar.d.getStatHolder().K("playbackStarted"), context);
                int[] V = bfVar.f.V();
                if (V != null) {
                    bfVar.b(V, context);
                }
                NativeAd.NativeAdListener listener = bfVar.a.getListener();
                StringBuilder L = a2.b.a.a.a.L("Ad shown, banner Id = ");
                L.append(bfVar.d.getId());
                ae.a(L.toString());
                if (listener != null) {
                    listener.onShow(bfVar.a);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@Nullable View view) {
            bf bfVar = this.a;
            Objects.requireNonNull(bfVar);
            ae.a("Click received by native ad");
            if (view != null) {
                bfVar.c(bfVar.d, null, view.getContext());
            }
        }

        @Override // com.my.target.gn.a
        public void b(@NonNull View view, int i) {
            bf bfVar = this.a;
            Objects.requireNonNull(bfVar);
            ae.a("Click on native card received");
            List<ch> nativeAdCards = bfVar.d.getNativeAdCards();
            if (i >= 0 && i < nativeAdCards.size()) {
                bfVar.c(nativeAdCards.get(i), null, view.getContext());
            }
            cz statHolder = bfVar.d.getStatHolder();
            Context context = view.getContext();
            if (context != null) {
                im.a(statHolder.K("click"), context);
            }
        }
    }

    public bf(@NonNull NativeAd nativeAd, @NonNull cg cgVar) {
        this.a = nativeAd;
        this.d = cgVar;
        this.g = NativePromoBanner.newBanner(cgVar);
        this.f = an.a(cgVar, new a(this, nativeAd), nativeAd.isUseExoPlayer());
    }

    @NonNull
    public static bf a(@NonNull NativeAd nativeAd, @NonNull cg cgVar) {
        return new bf(nativeAd, cgVar);
    }

    @Override // com.my.target.aq
    public void a(@NonNull View view, @Nullable List<View> list, int i2, @Nullable MediaAdView mediaAdView) {
        unregisterView();
        this.f.a(view, list, i2, mediaAdView);
    }

    @Override // com.my.target.aq
    @Nullable
    public String ad() {
        return "myTarget";
    }

    @Override // com.my.target.aq
    public float ae() {
        return 0.0f;
    }

    @Override // com.my.target.aq
    @Nullable
    public NativePromoBanner af() {
        return this.g;
    }

    public void b(@NonNull int[] iArr, @NonNull Context context) {
        if (this.i) {
            List<ch> nativeAdCards = this.d.getNativeAdCards();
            for (int i2 : iArr) {
                ch chVar = null;
                if (i2 >= 0 && i2 < nativeAdCards.size()) {
                    chVar = nativeAdCards.get(i2);
                }
                if (chVar != null && !this.b.contains(chVar)) {
                    im.a(chVar.getStatHolder().K("playbackStarted"), context);
                    im.a(chVar.getStatHolder().K("show"), context);
                    this.b.add(chVar);
                }
            }
        }
    }

    public final void c(@Nullable by byVar, @Nullable String str, @NonNull Context context) {
        if (byVar != null) {
            if (str != null) {
                this.e.c(byVar, str, context);
            } else {
                this.e.a(byVar, context);
            }
        }
        NativeAd.NativeAdListener listener = this.a.getListener();
        if (listener != null) {
            listener.onClick(this.a);
        }
    }

    @Override // com.my.target.aq
    public void setMediaListener(@Nullable NativeAd.NativeAdMediaListener nativeAdMediaListener) {
        this.h = nativeAdMediaListener;
    }

    @Override // com.my.target.aq
    public void unregisterView() {
        this.f.unregisterView();
    }
}

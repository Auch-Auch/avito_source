package com.my.target;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ao;
import com.my.target.nativeads.NativeBannerAd;
import com.my.target.nativeads.banners.NativeBanner;
import java.util.List;
import java.util.Objects;
public class bh implements ar {
    @NonNull
    public final NativeBannerAd a;
    @NonNull
    public final cg b;
    @NonNull
    public final hx c = hx.eC();
    @NonNull
    public final ao d;
    @NonNull
    public final NativeBanner e;
    @Nullable
    public NativeBannerAd.NativeBannerAdMediaListener f;

    public static class a implements ao.b {
        @NonNull
        public final bh a;
        @NonNull
        public final NativeBannerAd b;

        public a(@NonNull bh bhVar, @NonNull NativeBannerAd nativeBannerAd) {
            this.a = bhVar;
            this.b = nativeBannerAd;
        }

        @Override // com.my.target.ao.b
        public void ab() {
            NativeBannerAd.NativeBannerAdMediaListener nativeBannerAdMediaListener = this.a.f;
            if (nativeBannerAdMediaListener != null) {
                nativeBannerAdMediaListener.onIconLoad(this.b);
            }
        }

        @Override // com.my.target.ao.b
        public void n(@NonNull Context context) {
            bh bhVar = this.a;
            im.a(bhVar.b.getStatHolder().K("playbackStarted"), context);
            NativeBannerAd.NativeBannerAdListener listener = bhVar.a.getListener();
            StringBuilder L = a2.b.a.a.a.L("Ad shown, banner Id = ");
            L.append(bhVar.b.getId());
            ae.a(L.toString());
            if (listener != null) {
                listener.onShow(bhVar.a);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(@Nullable View view) {
            Context context;
            bh bhVar = this.a;
            Objects.requireNonNull(bhVar);
            ae.a("Click received by native banner ad");
            if (view != null) {
                cg cgVar = bhVar.b;
                if (!(cgVar == null || (context = view.getContext()) == null)) {
                    bhVar.c.a(cgVar, context);
                }
                NativeBannerAd.NativeBannerAdListener listener = bhVar.a.getListener();
                if (listener != null) {
                    listener.onClick(bhVar.a);
                }
            }
        }
    }

    public bh(@NonNull NativeBannerAd nativeBannerAd, @NonNull cg cgVar) {
        this.a = nativeBannerAd;
        this.b = cgVar;
        this.e = NativeBanner.newBanner(cgVar);
        this.d = ao.a(cgVar, new a(this, nativeBannerAd));
    }

    @NonNull
    public static bh a(@NonNull NativeBannerAd nativeBannerAd, @NonNull cg cgVar) {
        return new bh(nativeBannerAd, cgVar);
    }

    @Override // com.my.target.ar
    @NonNull
    public String ad() {
        return "myTarget";
    }

    @Override // com.my.target.ar
    public float ae() {
        return 0.0f;
    }

    @Override // com.my.target.ar
    @NonNull
    public NativeBanner ag() {
        return this.e;
    }

    @Override // com.my.target.ar
    public void registerView(@NonNull View view, @Nullable List<View> list, int i) {
        unregisterView();
        this.d.registerView(view, list, i);
    }

    @Override // com.my.target.ar
    public void setMediaListener(@Nullable NativeBannerAd.NativeBannerAdMediaListener nativeBannerAdMediaListener) {
        this.f = nativeBannerAdMediaListener;
    }

    @Override // com.my.target.ar
    public void unregisterView() {
        this.d.unregisterView();
    }
}

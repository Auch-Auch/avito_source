package com.my.target.nativeads;

import android.content.Context;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.ae;
import com.my.target.bg;
import com.my.target.cj;
import com.my.target.cn;
import com.my.target.common.BaseAd;
import com.my.target.common.models.ImageData;
import com.my.target.ct;
import com.my.target.hx;
import com.my.target.ia;
import com.my.target.ih;
import com.my.target.im;
import com.my.target.nativeads.banners.NativeAppwallBanner;
import com.my.target.nativeads.views.AppwallAdView;
import com.my.target.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
public final class NativeAppwallAd extends BaseAd {
    @NonNull
    public final Context b;
    @NonNull
    public final hx c = hx.eC();
    @NonNull
    public final HashMap<NativeAppwallBanner, cj> d = new HashMap<>();
    @NonNull
    public final ArrayList<NativeAppwallBanner> e = new ArrayList<>();
    @Nullable
    public AppwallAdListener f;
    @Nullable
    public ct g;
    @Nullable
    public bg h;
    @Nullable
    public WeakReference<AppwallAdView> i;
    @NonNull
    public String j = "Apps";
    public int k = -12232093;
    public int l = -13220531;
    public int m = -1;
    public boolean n = false;

    public interface AppwallAdListener {
        void onClick(@NonNull NativeAppwallBanner nativeAppwallBanner, @NonNull NativeAppwallAd nativeAppwallAd);

        void onDismiss(@NonNull NativeAppwallAd nativeAppwallAd);

        void onDisplay(@NonNull NativeAppwallAd nativeAppwallAd);

        void onLoad(@NonNull NativeAppwallAd nativeAppwallAd);

        void onNoAd(@NonNull String str, @NonNull NativeAppwallAd nativeAppwallAd);
    }

    public class a implements w.b {
        public a() {
        }

        @Override // com.my.target.b.AbstractC0305b
        public void onResult(@Nullable cn cnVar, @Nullable String str) {
            ct ctVar = (ct) cnVar;
            NativeAppwallAd nativeAppwallAd = NativeAppwallAd.this;
            AppwallAdListener appwallAdListener = nativeAppwallAd.f;
            if (appwallAdListener == null) {
                return;
            }
            if (ctVar == null) {
                if (str == null) {
                    str = "no ad";
                }
                appwallAdListener.onNoAd(str, nativeAppwallAd);
                return;
            }
            nativeAppwallAd.g = ctVar;
            for (cj cjVar : ctVar.ca()) {
                NativeAppwallBanner newBanner = NativeAppwallBanner.newBanner(cjVar);
                nativeAppwallAd.e.add(newBanner);
                nativeAppwallAd.d.put(newBanner, cjVar);
            }
            nativeAppwallAd.f.onLoad(nativeAppwallAd);
        }
    }

    public class b implements AppwallAdView.AppwallAdViewListener {
        public b() {
        }

        @Override // com.my.target.nativeads.views.AppwallAdView.AppwallAdViewListener
        public void onBannerClick(@NonNull NativeAppwallBanner nativeAppwallBanner) {
            AppwallAdView appwallAdView;
            NativeAppwallAd.this.handleBannerClick(nativeAppwallBanner);
            WeakReference<AppwallAdView> weakReference = NativeAppwallAd.this.i;
            if (weakReference != null && (appwallAdView = weakReference.get()) != null) {
                appwallAdView.notifyDataSetChanged();
            }
        }

        @Override // com.my.target.nativeads.views.AppwallAdView.AppwallAdViewListener
        public void onBannersShow(@NonNull List<NativeAppwallBanner> list) {
            NativeAppwallAd.this.handleBannersShow(list);
        }
    }

    public NativeAppwallAd(int i2, @NonNull Context context) {
        super(i2, "appwall");
        this.b = context;
        this.adConfig.setCachePolicy(0);
        ae.c("NativeAppwallAd created. Version: 5.12.2");
    }

    public static void loadImageToView(@NonNull ImageData imageData, @NonNull ImageView imageView) {
        ia.a(imageData, imageView);
    }

    public void destroy() {
        unregisterAppwallAdView();
        bg bgVar = this.h;
        if (bgVar != null) {
            bgVar.destroy();
            this.h = null;
        }
        this.f = null;
    }

    public void dismiss() {
        bg bgVar = this.h;
        if (bgVar != null) {
            bgVar.dismiss();
        }
    }

    @NonNull
    public ArrayList<NativeAppwallBanner> getBanners() {
        return this.e;
    }

    public long getCachePeriod() {
        return this.adConfig.getCachePeriod();
    }

    @Nullable
    public AppwallAdListener getListener() {
        return this.f;
    }

    @NonNull
    public String getTitle() {
        return this.j;
    }

    public int getTitleBackgroundColor() {
        return this.k;
    }

    public int getTitleSupplementaryColor() {
        return this.l;
    }

    public int getTitleTextColor() {
        return this.m;
    }

    public void handleBannerClick(NativeAppwallBanner nativeAppwallBanner) {
        cj cjVar = this.d.get(nativeAppwallBanner);
        if (cjVar != null) {
            this.c.a(cjVar, this.b);
            if (this.g != null) {
                nativeAppwallBanner.setHasNotification(false);
                ih.a(this.g, this.adConfig).a(cjVar, false, this.b);
            }
            AppwallAdListener appwallAdListener = this.f;
            if (appwallAdListener != null) {
                appwallAdListener.onClick(nativeAppwallBanner, this);
                return;
            }
            return;
        }
        StringBuilder L = a2.b.a.a.a.L("unable to handle banner click: no internal banner for id ");
        L.append(nativeAppwallBanner.getId());
        ae.a(L.toString());
    }

    public void handleBannerShow(@NonNull NativeAppwallBanner nativeAppwallBanner) {
        cj cjVar = this.d.get(nativeAppwallBanner);
        if (cjVar != null) {
            im.a(cjVar.getStatHolder().K("playbackStarted"), this.b);
            return;
        }
        StringBuilder L = a2.b.a.a.a.L("unable to handle banner show: no internal banner for id ");
        L.append(nativeAppwallBanner.getId());
        ae.a(L.toString());
    }

    public void handleBannersShow(@NonNull List<NativeAppwallBanner> list) {
        ArrayList arrayList = new ArrayList();
        for (NativeAppwallBanner nativeAppwallBanner : list) {
            cj cjVar = this.d.get(nativeAppwallBanner);
            if (cjVar != null) {
                StringBuilder L = a2.b.a.a.a.L("Ad shown, banner Id = ");
                L.append(nativeAppwallBanner.getId());
                ae.a(L.toString());
                arrayList.addAll(cjVar.getStatHolder().K("playbackStarted"));
            } else {
                StringBuilder L2 = a2.b.a.a.a.L("unable to handle banner show: no internal banner for id ");
                L2.append(nativeAppwallBanner.getId());
                ae.a(L2.toString());
            }
        }
        if (arrayList.size() > 0) {
            im.a(arrayList, this.b);
        }
    }

    public boolean hasNotifications() {
        for (NativeAppwallBanner nativeAppwallBanner : this.d.keySet()) {
            if (nativeAppwallBanner.isHasNotification()) {
                return true;
            }
        }
        return false;
    }

    public boolean isAutoLoadImages() {
        int cachePolicy = this.adConfig.getCachePolicy();
        return cachePolicy == 0 || cachePolicy == 1;
    }

    public boolean isHideStatusBarInDialog() {
        return this.n;
    }

    public void load() {
        if (isLoadCalled()) {
            ae.a("Appwall ad doesn't support multiple load");
        } else {
            w.a(this.adConfig).a(new a()).a(this.b);
        }
    }

    @Nullable
    public String prepareBannerClickLink(NativeAppwallBanner nativeAppwallBanner) {
        cj cjVar = this.d.get(nativeAppwallBanner);
        if (cjVar != null) {
            im.a(cjVar.getStatHolder().K("click"), this.b);
            ct ctVar = this.g;
            if (ctVar != null) {
                ih.a(ctVar, this.adConfig).a(cjVar, false, this.b);
            }
            return cjVar.getTrackingLink();
        }
        StringBuilder L = a2.b.a.a.a.L("unable to handle banner click: no internal banner for id ");
        L.append(nativeAppwallBanner.getId());
        ae.a(L.toString());
        return null;
    }

    public void registerAppwallAdView(@NonNull AppwallAdView appwallAdView) {
        unregisterAppwallAdView();
        this.i = new WeakReference<>(appwallAdView);
        appwallAdView.setAppwallAdViewListener(new b());
    }

    public void setAutoLoadImages(boolean z) {
        this.adConfig.setCachePolicy(0);
    }

    public void setCachePeriod(long j2) {
        this.adConfig.setCachePeriod(j2);
    }

    public void setHideStatusBarInDialog(boolean z) {
        this.n = z;
    }

    public void setListener(@Nullable AppwallAdListener appwallAdListener) {
        this.f = appwallAdListener;
    }

    public void setTitle(@NonNull String str) {
        this.j = str;
    }

    public void setTitleBackgroundColor(int i2) {
        this.k = i2;
    }

    public void setTitleSupplementaryColor(int i2) {
        this.l = i2;
    }

    public void setTitleTextColor(int i2) {
        this.m = i2;
    }

    public void show() {
        if (this.g == null || this.e.size() <= 0) {
            ae.c("NativeAppwallAd.show: No ad");
            return;
        }
        if (this.h == null) {
            this.h = bg.a(this);
        }
        this.h.o(this.b);
    }

    public void unregisterAppwallAdView() {
        WeakReference<AppwallAdView> weakReference = this.i;
        if (weakReference != null) {
            AppwallAdView appwallAdView = weakReference.get();
            if (appwallAdView != null) {
                appwallAdView.setAppwallAdViewListener(null);
            }
            this.i.clear();
            this.i = null;
        }
    }
}

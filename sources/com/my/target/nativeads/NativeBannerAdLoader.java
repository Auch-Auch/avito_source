package com.my.target.nativeads;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.my.target.ae;
import com.my.target.b;
import com.my.target.bh;
import com.my.target.cg;
import com.my.target.cn;
import com.my.target.common.BaseAd;
import com.my.target.cs;
import com.my.target.s;
import java.util.ArrayList;
import java.util.List;
public final class NativeBannerAdLoader extends BaseAd {
    @NonNull
    public final Context b;
    @Nullable
    public OnLoad c;
    @Nullable
    public b<cs> d;

    public interface OnLoad {
        void onLoad(@NonNull List<NativeBannerAd> list);
    }

    public class a implements s.b {
        public final /* synthetic */ b a;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // com.my.target.b.AbstractC0305b
        public void onResult(@Nullable cn cnVar, @Nullable String str) {
            cs csVar = (cs) cnVar;
            b<cs> bVar = this.a;
            NativeBannerAdLoader nativeBannerAdLoader = NativeBannerAdLoader.this;
            if (bVar == nativeBannerAdLoader.d) {
                List<cg> list = null;
                nativeBannerAdLoader.d = null;
                if (nativeBannerAdLoader.c != null) {
                    if (csVar != null) {
                        list = csVar.ca();
                    }
                    if (list == null || list.size() < 1) {
                        nativeBannerAdLoader.c.onLoad(new ArrayList());
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (cg cgVar : list) {
                        NativeBannerAd nativeBannerAd = new NativeBannerAd(nativeBannerAdLoader.adConfig.getSlotId(), nativeBannerAdLoader.b);
                        nativeBannerAd.setCachePolicy(nativeBannerAdLoader.adConfig.getCachePolicy());
                        nativeBannerAd.c = bh.a(nativeBannerAd, cgVar);
                        arrayList.add(nativeBannerAd);
                    }
                    nativeBannerAdLoader.c.onLoad(arrayList);
                }
            }
        }
    }

    public NativeBannerAdLoader(int i, int i2, @NonNull Context context) {
        super(i, "nativebanner");
        if (i2 < 1) {
            ae.a("NativeBannerAdLoader: invalid bannersCount < 1, bannersCount set to 1");
            i2 = 1;
        }
        this.adConfig.setBannersCount(i2);
        this.adConfig.setMediationEnabled(false);
        this.b = context.getApplicationContext();
        ae.c("NativeBannerAdLoader created. Version: 5.12.2");
    }

    @NonNull
    public static NativeBannerAdLoader newLoader(int i, int i2, @NonNull Context context) {
        return new NativeBannerAdLoader(i, i2, context);
    }

    public int getCachePolicy() {
        return this.adConfig.getCachePolicy();
    }

    @NonNull
    @UiThread
    public NativeBannerAdLoader load() {
        b<cs> a3 = s.a(this.adConfig);
        this.d = a3;
        a3.a(new a(a3)).a(this.b);
        return this;
    }

    public void setCachePolicy(int i) {
        this.adConfig.setCachePolicy(i);
    }

    @NonNull
    @UiThread
    public NativeBannerAdLoader setOnLoad(@Nullable OnLoad onLoad) {
        this.c = onLoad;
        return this;
    }
}

package com.my.target.nativeads;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import com.my.target.ae;
import com.my.target.b;
import com.my.target.bf;
import com.my.target.cg;
import com.my.target.cn;
import com.my.target.common.BaseAd;
import com.my.target.cs;
import com.my.target.s;
import java.util.ArrayList;
import java.util.List;
public final class NativeAdLoader extends BaseAd {
    @NonNull
    public final Context b;
    @Nullable
    public OnLoad c;
    @Nullable
    public b<cs> d;

    public interface OnLoad {
        void onLoad(@NonNull List<NativeAd> list);
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
            NativeAdLoader nativeAdLoader = NativeAdLoader.this;
            if (bVar == nativeAdLoader.d) {
                List<cg> list = null;
                nativeAdLoader.d = null;
                if (nativeAdLoader.c != null) {
                    if (csVar != null) {
                        list = csVar.ca();
                    }
                    if (list == null || list.size() < 1) {
                        nativeAdLoader.c.onLoad(new ArrayList());
                        return;
                    }
                    ArrayList arrayList = new ArrayList();
                    for (cg cgVar : list) {
                        NativeAd nativeAd = new NativeAd(nativeAdLoader.adConfig.getSlotId(), nativeAdLoader.b);
                        nativeAd.setCachePolicy(nativeAdLoader.adConfig.getCachePolicy());
                        nativeAd.c = bf.a(nativeAd, cgVar);
                        arrayList.add(nativeAd);
                    }
                    nativeAdLoader.c.onLoad(arrayList);
                }
            }
        }
    }

    public NativeAdLoader(int i, int i2, @NonNull Context context) {
        super(i, "nativeads");
        if (i2 < 1) {
            ae.a("NativeAdLoader: invalid bannersCount < 1, bannersCount set to 1");
            i2 = 1;
        }
        this.adConfig.setBannersCount(i2);
        this.adConfig.setMediationEnabled(false);
        this.b = context.getApplicationContext();
        ae.c("NativeAdLoader created. Version: 5.12.2");
    }

    @NonNull
    public static NativeAdLoader newLoader(int i, int i2, @NonNull Context context) {
        return new NativeAdLoader(i, i2, context);
    }

    public int getCachePolicy() {
        return this.adConfig.getCachePolicy();
    }

    @NonNull
    @UiThread
    public NativeAdLoader load() {
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
    public NativeAdLoader setOnLoad(@Nullable OnLoad onLoad) {
        this.c = onLoad;
        return this;
    }
}

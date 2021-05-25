package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.yandex.mobile.ads.impl.hv;
import java.util.HashMap;
import ru.sravni.android.bankproduct.analytic.v2.BaseAnalyticKt;
public final class dh {
    @NonNull
    private final dg a;
    @NonNull
    private final cv b = new cv();
    @NonNull
    private final ht c;
    @NonNull
    private final fo d;
    @NonNull
    private final dk e;
    @Nullable
    private a f;
    @Nullable
    private hv.a g;
    private long h;

    public enum a {
        BROWSER(BaseAnalyticKt.ANALYTIC_MODULE_BROWSER),
        WEBVIEW("webview");
        
        public final String c;

        private a(String str) {
            this.c = str;
        }
    }

    public dh(@NonNull Context context, @NonNull fo foVar, @NonNull dk dkVar) {
        this.d = foVar;
        this.e = dkVar;
        this.a = new dg(context, foVar);
        this.c = ht.a(context);
    }

    public final void a(@Nullable hv.a aVar) {
        this.g = aVar;
    }

    public final void b(@Nullable a aVar) {
        if (this.h != 0 && this.f == aVar) {
            long currentTimeMillis = System.currentTimeMillis() - this.h;
            int i = (currentTimeMillis > 1000 ? 1 : (currentTimeMillis == 1000 ? 0 : -1));
            String str = i < 0 ? "<1" : (i <= 0 || currentTimeMillis > 2000) ? (currentTimeMillis <= 2000 || currentTimeMillis > 3000) ? (currentTimeMillis <= 3000 || currentTimeMillis > 5000) ? (currentTimeMillis <= 5000 || currentTimeMillis > 10000) ? (currentTimeMillis <= 10000 || currentTimeMillis > 15000) ? (currentTimeMillis <= 15000 || currentTimeMillis > SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US) ? ">20" : "15-20" : "10-15" : "5-10" : "3-5" : "2-3" : "1-2";
            HashMap hashMap = new HashMap();
            hashMap.put("type", aVar.c);
            hashMap.put(AppEventsConstants.EVENT_PARAM_AD_TYPE, this.d.a().a());
            hashMap.put("block_id", this.d.e());
            hashMap.put("interval", str);
            hashMap.putAll(cv.a(this.d.c()));
            hv.a aVar2 = this.g;
            if (aVar2 != null) {
                hashMap.putAll(aVar2.a());
            }
            this.c.a(new hv(hv.b.RETURNED_TO_APP, hashMap));
            if (currentTimeMillis <= this.e.b()) {
                this.a.a(this.e.a());
            }
            this.h = 0;
            this.f = null;
        }
    }

    public final void a(@NonNull a aVar) {
        this.h = System.currentTimeMillis();
        this.f = aVar;
    }
}

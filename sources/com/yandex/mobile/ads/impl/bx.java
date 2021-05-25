package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.text.TextUtils;
import com.yandex.mobile.ads.b;
import com.yandex.mobile.ads.impl.bq;
import com.yandex.mobile.ads.impl.bt;
import com.yandex.mobile.ads.impl.tb;
import com.yandex.mobile.ads.impl.x;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
public abstract class bx<T> extends tc<fo, x<T>> {
    private final String a;
    private final Context b;
    private final fo c;
    @NonNull
    private final cd d = new cd();
    @NonNull
    private final cf e = new cf();
    @NonNull
    private final cc f = new cc();
    @NonNull
    private final ed g;
    @NonNull
    private final ao h;

    public bx(@NonNull Context context, @NonNull fo foVar, @NonNull String str, @NonNull String str2, @NonNull tb.a<x<T>> aVar, @NonNull hw<fo, x<T>> hwVar) {
        super(context, foVar.l(), str, aVar, foVar, hwVar);
        a((sc) new rt(foVar.m(), 0, 1.0f));
        this.a = str2;
        this.c = foVar;
        this.b = context.getApplicationContext();
        this.g = new ed(context);
        this.h = new ao();
    }

    public static boolean a(int i) {
        return 204 == i;
    }

    @Override // com.yandex.mobile.ads.impl.ry
    public final Map<String, String> a() throws se {
        HashMap hashMap = new HashMap();
        String a3 = dt.a(this.b);
        if (a3 != null) {
            hashMap.put(rq.YMAD_SESSION_DATA.a(), a3);
        }
        hashMap.put(rq.YMAD_RENDER_AD_IDS.a(), this.h.a(this.b));
        hashMap.put(rq.YMAD_IMPRESSION_AD_IDS.a(), this.h.b(this.b));
        return hashMap;
    }

    @Nullable
    public abstract T a_(@NonNull rx rxVar);

    @VisibleForTesting
    public boolean b(@NonNull rx rxVar, int i) {
        return 200 == i && b(rxVar);
    }

    @Override // com.yandex.mobile.ads.impl.ry
    public final byte[] c() throws se {
        byte[] c2 = super.c();
        if (1 != d()) {
            return c2;
        }
        try {
            String str = this.a;
            return str != null ? str.getBytes("UTF-8") : c2;
        } catch (UnsupportedEncodingException unused) {
            return c2;
        }
    }

    public static boolean b(@NonNull rx rxVar) {
        byte[] bArr = rxVar.b;
        return bArr != null && bArr.length > 0;
    }

    @Override // com.yandex.mobile.ads.impl.ry
    public final String b() {
        String b2 = super.b();
        if (d() == 0) {
            b2 = Uri.parse(b2).buildUpon().encodedQuery(this.a).build().toString();
        }
        return this.g.a(b2);
    }

    @Override // com.yandex.mobile.ads.impl.tc
    public final sa<x<T>> a(@NonNull rx rxVar, int i) {
        if (b(rxVar, i)) {
            Map<String, String> map = rxVar.c;
            b a3 = b.a(bt.a(map, rq.YMAD_TYPE));
            if (a3 == this.c.a()) {
                x.a aVar = new x.a();
                aVar.c(this.c.e());
                aVar.a(a3);
                int c2 = bt.c(map, rq.YMAD_HEADER_WIDTH);
                int c3 = bt.c(map, rq.YMAD_HEADER_HEIGHT);
                aVar.a(c2);
                aVar.b(c3);
                String a4 = bt.a(map, rq.YMAD_TYPE_FORMAT);
                String a5 = bt.a(map, rq.YMAD_PRODUCT_TYPE);
                aVar.a(a4);
                aVar.b(a5);
                am b2 = this.c.b();
                dk dkVar = null;
                aVar.a(b2 != null ? b2.c() : null);
                aVar.a(bt.e(map, rq.YMAD_SHOW_NOTICE));
                aVar.c(bt.a(map, rq.YMAD_NOTICE_DELAY, new bt.a<Long>() { // from class: com.yandex.mobile.ads.impl.bx.1
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // com.yandex.mobile.ads.impl.bt.a
                    @Nullable
                    public final /* synthetic */ Long a(String str) {
                        return dt.a(str, (Long) 0L);
                    }
                }));
                aVar.d(bt.a(map, rq.YMAD_VISIBILITY_PERCENT, new bt.a<Integer>() { // from class: com.yandex.mobile.ads.impl.bx.2
                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // com.yandex.mobile.ads.impl.bt.a
                    @NonNull
                    public final /* synthetic */ Integer a(String str) {
                        return Integer.valueOf(Math.min(dt.b(str), x.a.intValue()));
                    }
                }));
                aVar.b(bt.e(map, rq.YMAD_RENDER_TRACKING_URLS));
                aVar.f(bt.c(map, rq.YMAD_PREFETCH_COUNT));
                aVar.c(bt.c(map, rq.YMAD_REFRESH_PERIOD));
                aVar.d(bt.c(map, rq.YMAD_RELOAD_TIMEOUT));
                aVar.e(bt.c(map, rq.YMAD_EMPTY_INTERVAL));
                aVar.d(bt.a(map, rq.YMAD_RENDERER));
                Map<String, String> map2 = rxVar.c;
                Integer c4 = dt.c(bt.a(map2, rq.YMAD_REWARD_AMOUNT));
                String a6 = bt.a(map2, rq.YMAD_REWARD_TYPE);
                String a8 = a6 != null ? ca.a(a6.getBytes()) : null;
                bp bpVar = (c4 == null || TextUtils.isEmpty(a8)) ? null : new bp(c4.intValue(), a8);
                String d2 = bt.d(map2, rq.YMAD_REWARD_URL);
                aVar.a(new bq.a().a(bpVar).a(!TextUtils.isEmpty(d2) ? new br(d2) : null).a(bt.b(map2, rq.YMAD_SERVER_SIDE_REWARD)).a());
                Map<String, String> map3 = rxVar.c;
                String d3 = bt.d(map3, rq.YMAD_FALSE_CLICK_URL);
                Long a9 = dt.a(bt.a(map3, rq.YMAD_FALSE_CLICK_INTERVAL), (Long) null);
                if (!(d3 == null || a9 == null)) {
                    dkVar = new dk(d3, a9.longValue());
                }
                aVar.a(dkVar);
                rq rqVar = rq.YMAD_SESSION_DATA;
                String a10 = bt.a(map, rqVar);
                rqVar.a();
                dt.a(this.b, a10);
                aVar.a(bt.b(map, rq.YMAD_ROTATION_ENABLED));
                aVar.b(bt.b(map, rq.YMAD_NON_SKIPPABLE_AD_ENABLED));
                if (bt.b(map, rq.YMAD_MEDIATION)) {
                    aVar.a(cd.a(rxVar));
                } else {
                    aVar.a((x.a) a_(rxVar));
                }
                aVar.e(bt.a(map, rq.YMAD_SOURCE));
                aVar.f(bt.a(map, rq.YMAD_ID));
                aVar.c(bt.b(map, rq.YMAD_ADAPTER_IMPRESSION_ENABLED));
                x<T> a11 = aVar.a();
                if (!a(i)) {
                    return sa.a(a11, sp.a(rxVar));
                }
            }
        }
        return sa.a(r.a(rxVar));
    }

    @Override // com.yandex.mobile.ads.impl.tc, com.yandex.mobile.ads.impl.ry
    public final sl a(sl slVar) {
        return super.a((sl) r.a(slVar.a));
    }
}

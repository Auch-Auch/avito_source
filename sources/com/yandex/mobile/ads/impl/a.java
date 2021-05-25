package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import com.yandex.mobile.ads.AdEventListener;
import com.yandex.mobile.ads.AdRequestError;
import com.yandex.mobile.ads.VideoController;
import com.yandex.mobile.ads.impl.am;
import com.yandex.mobile.ads.impl.ir;
import com.yandex.mobile.ads.mediation.banner.b;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
public final class a extends h {
    @NonNull
    private final c h;
    @NonNull
    private final VideoController i;
    @NonNull
    private final ei j;
    @NonNull
    private final km k;
    @NonNull
    private final js l;
    @Nullable
    private e m;
    @Nullable
    private b n;
    @Nullable
    private b o;
    private final ViewTreeObserver.OnPreDrawListener p = new ViewTreeObserver.OnPreDrawListener() { // from class: com.yandex.mobile.ads.impl.a.3
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public final boolean onPreDraw() {
            a.this.D();
            a.this.a.postDelayed(new Runnable() { // from class: com.yandex.mobile.ads.impl.a.3.1
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.c(false);
                }
            }, 50);
            return true;
        }
    };

    public a(@NonNull Context context, @NonNull e eVar, @NonNull c cVar) {
        super(context, new b(eVar), com.yandex.mobile.ads.b.BANNER);
        this.h = cVar;
        eVar.setHorizontalScrollBarEnabled(false);
        eVar.setVerticalScrollBarEnabled(false);
        eVar.setVisibility(8);
        eVar.setBackgroundColor(0);
        this.m = eVar;
        ei eiVar = new ei();
        this.j = eiVar;
        this.i = new VideoController(eiVar);
        this.k = new km();
        js jsVar = new js();
        this.l = jsVar;
        cVar.a(jsVar);
    }

    @Override // com.yandex.mobile.ads.impl.at.a
    public final void f() {
        this.h.a();
    }

    @Override // com.yandex.mobile.ads.impl.at.a
    public final void g() {
        this.h.b();
    }

    @NonNull
    public final VideoController h() {
        return this.i;
    }

    @Override // com.yandex.mobile.ads.impl.ab
    @Nullable
    public final AdEventListener i() {
        return this.h.c();
    }

    @Override // com.yandex.mobile.ads.impl.h, com.yandex.mobile.ads.impl.ab, com.yandex.mobile.ads.AdEventListener
    public final /* bridge */ /* synthetic */ void onAdFailedToLoad(@NonNull AdRequestError adRequestError) {
        super.onAdFailedToLoad(adRequestError);
    }

    @Override // com.yandex.mobile.ads.impl.ab, com.yandex.mobile.ads.AdEventListener
    public final void onAdLoaded() {
        super.onAdLoaded();
        b bVar = this.o;
        if (bVar != this.n) {
            a(this.b, bVar);
            this.o = this.n;
        }
    }

    private boolean c(@Nullable am amVar) {
        am b;
        if (amVar == null || (b = this.f.b()) == null) {
            return false;
        }
        return a(amVar, b);
    }

    @Override // com.yandex.mobile.ads.impl.h, com.yandex.mobile.ads.impl.iv, com.yandex.mobile.ads.impl.ab, com.yandex.mobile.ads.impl.ah.b
    public final /* bridge */ /* synthetic */ void a(@NonNull Intent intent) {
        super.a(intent);
    }

    @Override // com.yandex.mobile.ads.impl.h, com.yandex.mobile.ads.impl.iv
    public final /* bridge */ /* synthetic */ void b(int i2) {
        super.b(i2);
    }

    @Override // com.yandex.mobile.ads.impl.h, com.yandex.mobile.ads.impl.iv, com.yandex.mobile.ads.impl.it, com.yandex.mobile.ads.impl.ab
    public final void d() {
        super.d();
        this.h.a((AdEventListener) null);
        if (this.m != null) {
            c(true);
            this.m.setVisibility(8);
            eg.a(this.m);
            this.m = null;
        }
    }

    @Override // com.yandex.mobile.ads.impl.iv, com.yandex.mobile.ads.impl.ab
    public final void e() {
        a(this.b, this.o, this.n);
        super.e();
    }

    @Override // com.yandex.mobile.ads.impl.iv
    public final boolean b() {
        View findViewById;
        e eVar = this.m;
        if (!(eVar == null || (findViewById = eVar.findViewById(2)) == null)) {
            Rect b = eg.b(findViewById);
            Rect rect = new Rect();
            findViewById.getWindowVisibleDisplayFrame(rect);
            if (!((b.bottom <= rect.top || b.top >= rect.bottom) || (b.right <= rect.left || b.left >= rect.right))) {
                return true;
            }
        }
        return false;
    }

    @Nullable
    public final e a() {
        return this.m;
    }

    public final boolean c() {
        x z = z();
        am e = z != null ? z.e() : null;
        return e != null && c(e);
    }

    @Override // com.yandex.mobile.ads.impl.iv, com.yandex.mobile.ads.impl.er
    public final void a(@Nullable WebView webView, @Nullable Map<String, String> map) {
        if (webView != null) {
            final d dVar = (d) webView;
            if (this.m != null && c(dVar.c())) {
                this.m.setVisibility(0);
                this.a.post(new Runnable() { // from class: com.yandex.mobile.ads.impl.a.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        e a3 = a.this.a();
                        if (a3 != null && a3.indexOfChild(dVar) == -1) {
                            RelativeLayout.LayoutParams a4 = ir.d.a(a.this.b, dVar.c());
                            a.a(a.this, a3, dVar);
                            a3.addView(dVar, a4);
                            eg.a(dVar, a.this.p);
                        }
                    }
                });
                super.a(webView, map);
            }
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private void c(boolean z) {
        int childCount;
        e eVar = this.m;
        if (eVar != null && eVar.getChildCount() > 0 && (childCount = eVar.getChildCount() - (!z ? 1 : 0)) > 0) {
            ArrayList arrayList = new ArrayList(childCount);
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = eVar.getChildAt(i2);
                if (childAt instanceof ac) {
                    arrayList.add((ac) childAt);
                }
            }
            eVar.removeViews(0, childCount);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                ((ac) arrayList.get(i3)).g();
            }
            arrayList.clear();
        }
    }

    @Override // com.yandex.mobile.ads.impl.iv
    public final boolean a(int i2) {
        e eVar = this.m;
        if (eVar != null) {
            return eg.b(eVar.findViewById(2), i2);
        }
        return false;
    }

    @Override // com.yandex.mobile.ads.impl.it
    public final boolean a(@NonNull am amVar) {
        return amVar.b(this.b) >= 0 && amVar.a(this.b) >= 0;
    }

    private static void a(@NonNull Context context, @NonNull b... bVarArr) {
        Iterator it = new HashSet(Arrays.asList(bVarArr)).iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar != null) {
                bVar.a(context);
            }
        }
    }

    @Override // com.yandex.mobile.ads.impl.iv, com.yandex.mobile.ads.impl.ab
    public final void a(@NonNull x<String> xVar) {
        super.a(xVar);
        this.l.a(xVar);
        b a = km.a(xVar).a(this);
        this.n = a;
        a.a(this.b, xVar);
    }

    @Override // com.yandex.mobile.ads.impl.ab
    public final void a(@Nullable AdEventListener adEventListener) {
        super.a((AdEventListener) this.h);
        this.h.a(adEventListener);
    }

    @Override // com.yandex.mobile.ads.impl.iv
    @NonNull
    public final ja a(@NonNull String str, @NonNull x<String> xVar, @NonNull am amVar, @NonNull at atVar) {
        d dVar = new d(this.b, xVar, amVar);
        new jb();
        boolean a = jb.a(str);
        je.a();
        return je.a(a).a(dVar, this, this.j, atVar);
    }

    public static /* synthetic */ void a(a aVar, final e eVar, final d dVar) {
        am c = dVar.c();
        if (c == null || c.c() == am.a.FIXED) {
            dVar.setVisibility(0);
            return;
        }
        Integer num = dVar.d;
        if (num != null) {
            eVar.setBackgroundColor(num.intValue());
        } else {
            aVar.a.postDelayed(new Runnable() { // from class: com.yandex.mobile.ads.impl.a.2
                @Override // java.lang.Runnable
                public final void run() {
                    e eVar2 = eVar;
                    Bitmap c2 = eg.c(dVar);
                    Integer num2 = 0;
                    if (c2 != null) {
                        int width = c2.getWidth();
                        int height = c2.getHeight();
                        int i2 = width * height;
                        int[] iArr = new int[i2];
                        c2.getPixels(iArr, 0, width, 0, 0, width, height);
                        int i3 = 0;
                        for (int i4 = 0; i4 < height; i4++) {
                            for (int i5 = 0; i5 < width; i5++) {
                                if (Color.alpha(iArr[(i4 * width) + i5]) != 255) {
                                    i3++;
                                }
                            }
                        }
                        if (!(((float) i3) >= ((float) i2) * 0.1f)) {
                            int[][][] iArr2 = (int[][][]) Array.newInstance(int.class, 16, 16, 16);
                            for (int i6 = 0; i6 < height; i6++) {
                                for (int i7 = 0; i7 < width; i7++) {
                                    int i8 = iArr[(i6 * width) + i7];
                                    int red = Color.red(i8) / 16;
                                    int green = Color.green(i8) / 16;
                                    int blue = Color.blue(i8) / 16;
                                    iArr2[red][green][blue] = iArr2[red][green][blue] + 1;
                                }
                            }
                            int i9 = 0;
                            int i10 = 0;
                            for (int i11 = 0; i11 < 16; i11++) {
                                for (int i12 = 0; i12 < 16; i12++) {
                                    for (int i13 = 0; i13 < 16; i13++) {
                                        int i14 = iArr2[i13][i12][i11];
                                        if (i14 > i10) {
                                            i9 = Color.rgb(i13 * 16, i12 * 16, i11 * 16);
                                            i10 = i14;
                                        }
                                    }
                                }
                            }
                            num2 = Integer.valueOf(i9);
                        }
                    }
                    eVar2.setBackgroundColor(num2.intValue());
                    dVar.setVisibility(0);
                }
            }, 200);
        }
    }
}

package com.my.target;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.avito.android.remote.model.category_parameters.MultiselectParameterKt;
import com.avito.android.search.map.view.PanelStateKt;
import com.my.target.bk;
import com.my.target.et;
import com.my.target.fk;
import com.my.target.fu;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Objects;
public class es implements et, fk.a {
    @NonNull
    public final bk a;
    @NonNull
    public final fv b;
    @NonNull
    public final Context c;
    @NonNull
    public final WeakReference<Activity> d;
    @NonNull
    public final bn e;
    @NonNull
    public final b f;
    @NonNull
    public final bk.a g;
    @NonNull
    public final fu.a h = new d(null);
    @NonNull
    public String i;
    @Nullable
    public bk j;
    @Nullable
    public ga k;
    @Nullable
    public ga l;
    @Nullable
    public et.a m;
    @Nullable
    public c n;
    @Nullable
    public ck o;
    public boolean p;
    @Nullable
    public Uri q;
    @Nullable
    public fu r;
    @Nullable
    public fk s;
    @Nullable
    public ViewGroup t;
    @Nullable
    public g u;
    @Nullable
    public f v;

    public class b implements View.OnLayoutChangeListener {
        @NonNull
        public final bk a;

        public b(bk bkVar) {
            this.a = bkVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            es esVar = es.this;
            esVar.v = null;
            esVar.c();
            this.a.a(es.this.e);
        }
    }

    public interface c {
        void a(float f, float f2, @NonNull ck ckVar, @NonNull Context context);

        void a(@NonNull String str, @NonNull ck ckVar, @NonNull Context context);

        void ah();

        void ai();

        void onLoad();

        void onNoAd(@NonNull String str);
    }

    public class d implements fu.a {
        public d(a aVar) {
        }

        @Override // com.my.target.fu.a
        public void onClose() {
            fk fkVar = es.this.s;
            if (fkVar != null) {
                fkVar.dismiss();
            }
        }
    }

    @VisibleForTesting
    public static class e implements Runnable {
        @NonNull
        public ck a;
        @NonNull
        public Context b;
        @NonNull
        public fk c;
        @NonNull
        public Uri d;
        @NonNull
        public bk e;

        public class a implements Runnable {
            public final /* synthetic */ String a;

            public a(String str) {
                this.a = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (!TextUtils.isEmpty(this.a)) {
                    e.this.e.h(this.a);
                    return;
                }
                e.this.e.a(Tracker.Events.CREATIVE_EXPAND, "Failed to handling mraid");
                e.this.c.dismiss();
            }
        }

        public e(@NonNull ck ckVar, @NonNull fk fkVar, @NonNull Uri uri, @NonNull bk bkVar, @NonNull Context context) {
            this.a = ckVar;
            this.b = context.getApplicationContext();
            this.c = fkVar;
            this.d = uri;
            this.e = bkVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            db cE = db.cE();
            cE.f(this.d.toString(), this.b);
            af.c(new a(dn.g(this.a.getMraidJs(), (String) cE.cJ())));
        }
    }

    public static class f {
        public boolean a = true;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        @Nullable
        public Rect g;
        @Nullable
        public Rect h;
        public int i;
        public int j;

        public int dL() {
            return this.d;
        }

        public int dM() {
            return this.e;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0062, code lost:
        if (r4 == null) goto L_0x0064;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public es(@androidx.annotation.NonNull android.view.ViewGroup r8) {
        /*
            r7 = this;
            java.lang.String r0 = "inline"
            com.my.target.bk r1 = com.my.target.bk.g(r0)
            com.my.target.ga r2 = new com.my.target.ga
            android.content.Context r3 = r8.getContext()
            r2.<init>(r3)
            com.my.target.fv r3 = new com.my.target.fv
            android.content.Context r4 = r8.getContext()
            r3.<init>(r4)
            r7.<init>()
            com.my.target.es$d r4 = new com.my.target.es$d
            r5 = 0
            r4.<init>(r5)
            r7.h = r4
            r7.a = r1
            r7.k = r2
            r7.b = r3
            android.content.Context r3 = r8.getContext()
            r7.c = r3
            boolean r4 = r3 instanceof android.app.Activity
            r6 = 16908290(0x1020002, float:2.3877235E-38)
            if (r4 == 0) goto L_0x004d
            java.lang.ref.WeakReference r8 = new java.lang.ref.WeakReference
            r4 = r3
            android.app.Activity r4 = (android.app.Activity) r4
            r8.<init>(r4)
            r7.d = r8
            android.view.Window r8 = r4.getWindow()
            android.view.View r8 = r8.getDecorView()
            android.view.View r8 = r8.findViewById(r6)
            goto L_0x0064
        L_0x004d:
            java.lang.ref.WeakReference r4 = new java.lang.ref.WeakReference
            r4.<init>(r5)
            r7.d = r4
            android.view.View r8 = r8.getRootView()
            if (r8 == 0) goto L_0x0068
            android.view.View r4 = r8.findViewById(r6)
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            r7.t = r4
            if (r4 != 0) goto L_0x0068
        L_0x0064:
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8
            r7.t = r8
        L_0x0068:
            java.lang.String r8 = "loading"
            r7.i = r8
            com.my.target.bn r8 = com.my.target.bn.u(r3)
            r7.e = r8
            r7.b(r2)
            com.my.target.es$g r8 = new com.my.target.es$g
            r8.<init>(r1, r0)
            r7.g = r8
            r1.a(r8)
            com.my.target.es$b r8 = new com.my.target.es$b
            r8.<init>(r1)
            r7.f = r8
            r2.addOnLayoutChangeListener(r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.my.target.es.<init>(android.view.ViewGroup):void");
    }

    @NonNull
    public static es e(@NonNull ViewGroup viewGroup) {
        return new es(viewGroup);
    }

    @Override // com.my.target.et
    public void a(@NonNull ck ckVar) {
        ga gaVar;
        this.o = ckVar;
        String source = ckVar.getSource();
        if (source == null || (gaVar = this.k) == null) {
            c cVar = this.n;
            if (cVar != null) {
                cVar.onNoAd("failed to load, failed MRAID initialization");
                return;
            }
            return;
        }
        this.a.a(gaVar);
        this.a.h(source);
    }

    public void a(@Nullable c cVar) {
        this.n = cVar;
    }

    @Override // com.my.target.et
    public void a(@Nullable et.a aVar) {
        this.m = aVar;
    }

    public void a(@NonNull String str) {
        a2.b.a.a.a.U0("MRAID state set to ", str);
        this.i = str;
        this.a.j(str);
        bk bkVar = this.j;
        if (bkVar != null) {
            bkVar.j(str);
        }
        if (PanelStateKt.PANEL_HIDDEN.equals(str)) {
            ae.a("MraidPresenter: Mraid on close");
        }
    }

    @Override // com.my.target.fk.a
    public void a(boolean z) {
        bk bkVar = this.j;
        if (bkVar == null) {
            bkVar = this.a;
        }
        bkVar.q(z);
        ga gaVar = this.l;
        if (gaVar == null) {
            return;
        }
        if (z) {
            gaVar.onResume();
        } else {
            gaVar.D(false);
        }
    }

    public void b(@NonNull ga gaVar) {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 1;
        this.b.addView(gaVar, 0);
        gaVar.setLayoutParams(layoutParams);
    }

    @VisibleForTesting
    public void c() {
        bn bnVar;
        int i2;
        int i3;
        int measuredWidth;
        int i4;
        ga gaVar;
        int[] iArr = new int[2];
        DisplayMetrics displayMetrics = this.c.getResources().getDisplayMetrics();
        this.e.a(displayMetrics.widthPixels, displayMetrics.heightPixels);
        ViewGroup viewGroup = this.t;
        if (viewGroup != null) {
            viewGroup.getLocationOnScreen(iArr);
            this.e.c(iArr[0], iArr[1], this.t.getMeasuredWidth() + iArr[0], this.t.getMeasuredHeight() + iArr[1]);
        }
        if (!this.i.equals(PanelStateKt.PANEL_EXPANDED) && !this.i.equals("resized")) {
            this.b.getLocationOnScreen(iArr);
            this.e.a(iArr[0], iArr[1], this.b.getMeasuredWidth() + iArr[0], this.b.getMeasuredHeight() + iArr[1]);
        }
        ga gaVar2 = this.l;
        if (gaVar2 != null) {
            gaVar2.getLocationOnScreen(iArr);
            bnVar = this.e;
            i2 = iArr[0];
            i3 = iArr[1];
            measuredWidth = this.l.getMeasuredWidth() + iArr[0];
            i4 = iArr[1];
            gaVar = this.l;
        } else {
            ga gaVar3 = this.k;
            if (gaVar3 != null) {
                gaVar3.getLocationOnScreen(iArr);
                bnVar = this.e;
                i2 = iArr[0];
                i3 = iArr[1];
                measuredWidth = this.k.getMeasuredWidth() + iArr[0];
                i4 = iArr[1];
                gaVar = this.k;
            } else {
                return;
            }
        }
        bnVar.b(i2, i3, measuredWidth, gaVar.getMeasuredHeight() + i4);
    }

    @Override // com.my.target.et
    @NonNull
    public fv dJ() {
        return this.b;
    }

    @Override // com.my.target.et
    public void destroy() {
        a(PanelStateKt.PANEL_HIDDEN);
        a((c) null);
        a((et.a) null);
        this.a.detach();
        fu fuVar = this.r;
        if (fuVar != null) {
            fuVar.removeAllViews();
            this.r.setOnCloseListener(null);
            ViewParent parent = this.r.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.r);
            }
            this.r = null;
        }
        ga gaVar = this.k;
        if (gaVar != null) {
            gaVar.D(true);
            if (this.k.getParent() != null) {
                ((ViewGroup) this.k.getParent()).removeView(this.k);
            }
            this.k.destroy();
            this.k = null;
        }
        bk bkVar = this.j;
        if (bkVar != null) {
            bkVar.detach();
            this.j = null;
        }
        ga gaVar2 = this.l;
        if (gaVar2 != null) {
            gaVar2.D(true);
            if (this.l.getParent() != null) {
                ((ViewGroup) this.l.getParent()).removeView(this.l);
            }
            this.l.destroy();
            this.l = null;
        }
    }

    @Override // com.my.target.fk.a
    public void o() {
        this.b.setVisibility(0);
        if (this.q != null) {
            this.q = null;
            bk bkVar = this.j;
            if (bkVar != null) {
                bkVar.q(false);
                this.j.j(PanelStateKt.PANEL_HIDDEN);
                this.j.detach();
                this.j = null;
                this.a.q(true);
            }
            ga gaVar = this.l;
            if (gaVar != null) {
                gaVar.D(true);
                if (this.l.getParent() != null) {
                    ((ViewGroup) this.l.getParent()).removeView(this.l);
                }
                this.l.destroy();
                this.l = null;
            }
        } else {
            ga gaVar2 = this.k;
            if (gaVar2 != null) {
                if (gaVar2.getParent() != null) {
                    ((ViewGroup) this.k.getParent()).removeView(this.k);
                }
                b(this.k);
            }
        }
        fu fuVar = this.r;
        if (!(fuVar == null || fuVar.getParent() == null)) {
            ((ViewGroup) this.r.getParent()).removeView(this.r);
        }
        this.r = null;
        a("default");
        c cVar = this.n;
        if (cVar != null) {
            cVar.ai();
        }
        c();
        this.a.a(this.e);
        this.k.onResume();
    }

    @Override // com.my.target.et
    public void pause() {
        ga gaVar;
        if ((this.s == null || this.j != null) && (gaVar = this.k) != null) {
            gaVar.D(false);
        }
    }

    @Override // com.my.target.et
    public void resume() {
        ga gaVar;
        if ((this.s == null || this.j != null) && (gaVar = this.k) != null) {
            gaVar.onResume();
        }
    }

    @Override // com.my.target.et
    public void start() {
        ck ckVar;
        et.a aVar = this.m;
        if (aVar != null && (ckVar = this.o) != null) {
            aVar.a(ckVar);
        }
    }

    @Override // com.my.target.et
    public void stop() {
        ga gaVar;
        if ((this.s == null || this.j != null) && (gaVar = this.k) != null) {
            gaVar.D(true);
        }
    }

    public class g implements bk.a {
        @NonNull
        public final bk a;

        public class a implements fu.a {
            public a() {
            }

            @Override // com.my.target.fu.a
            public void onClose() {
                g gVar = g.this;
                es esVar = es.this;
                fu fuVar = esVar.r;
                if (fuVar != null && esVar.k != null) {
                    if (fuVar.getParent() != null) {
                        ((ViewGroup) es.this.r.getParent()).removeView(es.this.r);
                        es.this.r.removeAllViews();
                        es esVar2 = es.this;
                        esVar2.b(esVar2.k);
                        es.this.a("default");
                        es.this.r.setOnCloseListener(null);
                        es.this.r = null;
                    }
                    c cVar = es.this.n;
                    if (cVar != null) {
                        cVar.ai();
                    }
                }
            }
        }

        public g(bk bkVar, @NonNull String str) {
            this.a = bkVar;
        }

        @Override // com.my.target.bk.a
        public boolean a(int i, int i2, int i3, int i4, boolean z, int i5) {
            String str;
            bk bkVar;
            es.this.v = new f();
            es esVar = es.this;
            if (esVar.t == null) {
                ae.a("Unable to set resize properties: container view for resize is not defined");
                bkVar = this.a;
                str = "container view for resize is not defined";
            } else if (i < 50 || i2 < 50) {
                ae.a("Unable to set resize properties: properties cannot be less than closeable container");
                bkVar = this.a;
                str = "properties cannot be less than closeable container";
            } else {
                io af = io.af(esVar.c);
                f fVar = es.this.v;
                fVar.a = z;
                int L = af.L(i);
                int L2 = af.L(i2);
                int L3 = af.L(i3);
                int L4 = af.L(i4);
                fVar.d = L;
                fVar.e = L2;
                fVar.b = L3;
                fVar.c = L4;
                fVar.f = i5;
                if (!z) {
                    Rect rect = new Rect();
                    es.this.t.getGlobalVisibleRect(rect);
                    f fVar2 = es.this.v;
                    if (!(fVar2.d <= rect.width() && fVar2.e <= rect.height())) {
                        StringBuilder L5 = a2.b.a.a.a.L("Unable to set resize properties: allowOffscreen is false, maxSize is (");
                        L5.append(rect.width());
                        L5.append(",");
                        L5.append(rect.height());
                        L5.append(") resize properties: (");
                        L5.append(es.this.v.dL());
                        L5.append(",");
                        L5.append(es.this.v.dM());
                        L5.append(")");
                        ae.a(L5.toString());
                        bkVar = this.a;
                        str = "resize properties with allowOffscreen false out of viewport";
                    }
                }
                return true;
            }
            bkVar.a("setResizeProperties", str);
            es.this.v = null;
            return false;
        }

        @Override // com.my.target.bk.a
        public boolean a(@NonNull ConsoleMessage consoleMessage, @NonNull bk bkVar) {
            StringBuilder L = a2.b.a.a.a.L("Console message: from ");
            L.append(bkVar == es.this.j ? " second " : " primary ");
            L.append("webview: ");
            L.append(consoleMessage.message());
            ae.a(L.toString());
            return true;
        }

        @Override // com.my.target.bk.a
        public boolean a(@NonNull String str, @NonNull JsResult jsResult) {
            ae.a("JS Alert: " + str);
            jsResult.confirm();
            return true;
        }

        @Override // com.my.target.bk.a
        public boolean a(boolean z, bm bmVar) {
            ae.a("Orientation properties isn't supported in standard banners");
            return false;
        }

        @Override // com.my.target.bk.a
        public void aN() {
        }

        @Override // com.my.target.bk.a
        public void aO() {
            es.this.p = true;
        }

        @Override // com.my.target.bk.a
        public boolean aP() {
            ga gaVar;
            boolean z;
            Rect rect;
            if (!es.this.i.equals("default")) {
                StringBuilder L = a2.b.a.a.a.L("Unable to resize: wrong state for resize: ");
                L.append(es.this.i);
                ae.a(L.toString());
                bk bkVar = this.a;
                StringBuilder L2 = a2.b.a.a.a.L("wrong state for resize ");
                L2.append(es.this.i);
                bkVar.a("resize", L2.toString());
                return false;
            }
            es esVar = es.this;
            f fVar = esVar.v;
            if (fVar == null) {
                ae.a("Unable to resize: resize properties not set");
                this.a.a("resize", "resize properties not set");
                return false;
            }
            ViewGroup viewGroup = esVar.t;
            if (viewGroup == null || (gaVar = esVar.k) == null) {
                ae.a("Unable to resize: views not initialized");
                this.a.a("resize", "views not initialized");
                return false;
            }
            Objects.requireNonNull(fVar);
            fVar.g = new Rect();
            fVar.h = new Rect();
            if (!(viewGroup.getGlobalVisibleRect(fVar.g) && gaVar.getGlobalVisibleRect(fVar.h))) {
                ae.a("Unable to resize: views not visible");
                this.a.a("resize", "views not visible");
                return false;
            }
            es.this.r = new fu(es.this.c);
            es esVar2 = es.this;
            f fVar2 = esVar2.v;
            fu fuVar = esVar2.r;
            Rect rect2 = fVar2.h;
            if (rect2 == null || (rect = fVar2.g) == null) {
                ae.a("Setup views before resizing");
            } else {
                int i = (rect2.top - rect.top) + fVar2.c;
                fVar2.i = i;
                fVar2.j = (rect2.left - rect.left) + fVar2.b;
                if (!fVar2.a) {
                    if (i + fVar2.e > rect.height()) {
                        ae.a("Try to reposition creative vertically because of resize allowOffscreen:false and out of max size properties");
                        fVar2.i = fVar2.g.height() - fVar2.e;
                    }
                    if (fVar2.j + fVar2.d > fVar2.g.width()) {
                        ae.a("Try to reposition creative horizontally because of resize allowOffscreen:false and out of max size properties");
                        fVar2.j = fVar2.g.width() - fVar2.d;
                    }
                }
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(fVar2.d, fVar2.e);
                layoutParams.topMargin = fVar2.i;
                layoutParams.leftMargin = fVar2.j;
                fuVar.setLayoutParams(layoutParams);
                fuVar.setCloseGravity(fVar2.f);
            }
            es esVar3 = es.this;
            f fVar3 = esVar3.v;
            fu fuVar2 = esVar3.r;
            if (fVar3.g == null) {
                z = false;
            } else {
                int i2 = fVar3.j;
                int i3 = fVar3.i;
                Rect rect3 = fVar3.g;
                Rect rect4 = new Rect(i2, i3, rect3.right, rect3.bottom);
                int i4 = fVar3.j;
                int i5 = fVar3.i;
                Rect rect5 = new Rect(i4, i5, fVar3.d + i4, fVar3.e + i5);
                Rect rect6 = new Rect();
                fuVar2.a(fVar3.f, rect5, rect6);
                z = rect4.contains(rect6);
            }
            if (!z) {
                ae.a("Unable to resize: close button is out of visible range");
                this.a.a("resize", "close button is out of visible range");
                es.this.r = null;
                return false;
            }
            ViewGroup viewGroup2 = (ViewGroup) es.this.k.getParent();
            if (viewGroup2 != null) {
                viewGroup2.removeView(es.this.k);
            }
            es esVar4 = es.this;
            esVar4.r.addView(esVar4.k, new FrameLayout.LayoutParams(-1, -1));
            es.this.r.setOnCloseListener(new a());
            es esVar5 = es.this;
            esVar5.t.addView(esVar5.r);
            es.this.a("resized");
            c cVar = es.this.n;
            if (cVar != null) {
                cVar.ah();
            }
            return true;
        }

        @Override // com.my.target.bk.a
        public void b(@NonNull Uri uri) {
            ck ckVar;
            es esVar = es.this;
            et.a aVar = esVar.m;
            if (aVar != null && (ckVar = esVar.o) != null) {
                aVar.a(ckVar, uri.toString());
            }
        }

        @Override // com.my.target.bk.a
        public boolean b(float f, float f2) {
            c cVar;
            ck ckVar;
            es esVar = es.this;
            if (!esVar.p) {
                this.a.a("playheadEvent", "Calling VPAID command before VPAID init");
                return false;
            } else if (f < 0.0f || f2 < 0.0f || (cVar = esVar.n) == null || (ckVar = esVar.o) == null) {
                return true;
            } else {
                cVar.a(f, f2, ckVar, esVar.c);
                return true;
            }
        }

        @Override // com.my.target.bk.a
        public void c(@NonNull bk bkVar) {
            String str;
            es esVar;
            c cVar;
            ga gaVar;
            StringBuilder L = a2.b.a.a.a.L("onPageLoaded callback from ");
            L.append(bkVar == es.this.j ? " second " : " primary ");
            L.append("webview");
            ae.a(L.toString());
            ArrayList<String> arrayList = new ArrayList<>();
            es esVar2 = es.this;
            Activity activity = esVar2.d.get();
            if ((activity == null || (gaVar = esVar2.k) == null) ? false : io.a(activity, gaVar)) {
                arrayList.add("'inlineVideo'");
            }
            arrayList.add("'vpaid'");
            bkVar.a(arrayList);
            bkVar.i(MultiselectParameterKt.DISPLAY_TYPE_INLINE);
            bkVar.q(bkVar.isVisible());
            fk fkVar = es.this.s;
            if (fkVar == null || !fkVar.isShowing()) {
                esVar = es.this;
                str = "default";
            } else {
                esVar = es.this;
                str = PanelStateKt.PANEL_EXPANDED;
            }
            esVar.a(str);
            bkVar.aL();
            es esVar3 = es.this;
            if (bkVar != esVar3.j && (cVar = esVar3.n) != null) {
                cVar.onLoad();
            }
        }

        @Override // com.my.target.bk.a
        public boolean m(@NonNull String str) {
            ck ckVar;
            es esVar = es.this;
            if (!esVar.p) {
                this.a.a("vpaidEvent", "Calling VPAID command before VPAID init");
                return false;
            }
            c cVar = esVar.n;
            if (cVar == null || (ckVar = esVar.o) == null) {
                return true;
            }
            cVar.a(str, ckVar, esVar.c);
            return true;
        }

        @Override // com.my.target.bk.a
        public void onClose() {
            fk fkVar = es.this.s;
            if (fkVar != null) {
                fkVar.dismiss();
            }
        }

        @Override // com.my.target.bk.a
        public void onVisibilityChanged(boolean z) {
            if (!z || es.this.s == null) {
                this.a.q(z);
            }
        }

        @Override // com.my.target.bk.a
        public boolean c(@Nullable Uri uri) {
            es esVar = es.this;
            if (esVar.k == null) {
                ae.a("Cannot expand: webview destroyed");
                return false;
            } else if (!esVar.i.equals("default") && !esVar.i.equals("resized")) {
                return false;
            } else {
                esVar.q = uri;
                fk.a(esVar, esVar.c).show();
                return true;
            }
        }
    }

    @Override // com.my.target.fk.a
    public void a(@NonNull fk fkVar, @NonNull FrameLayout frameLayout) {
        Uri uri;
        this.s = fkVar;
        fu fuVar = new fu(this.c);
        this.r = fuVar;
        this.b.setVisibility(8);
        frameLayout.addView(fuVar, new ViewGroup.LayoutParams(-1, -1));
        if (this.q != null) {
            this.j = bk.g(MultiselectParameterKt.DISPLAY_TYPE_INLINE);
            ga gaVar = new ga(this.c);
            this.l = gaVar;
            bk bkVar = this.j;
            g gVar = new g(bkVar, MultiselectParameterKt.DISPLAY_TYPE_INLINE);
            this.u = gVar;
            bkVar.a(gVar);
            fuVar.addView(gaVar, new ViewGroup.LayoutParams(-1, -1));
            bkVar.a(gaVar);
            fk fkVar2 = this.s;
            if (fkVar2 != null) {
                ck ckVar = this.o;
                if (ckVar == null || (uri = this.q) == null) {
                    fkVar2.dismiss();
                } else {
                    af.a(new e(ckVar, fkVar2, uri, bkVar, this.c));
                }
            }
        } else {
            ga gaVar2 = this.k;
            if (!(gaVar2 == null || gaVar2.getParent() == null)) {
                ((ViewGroup) this.k.getParent()).removeView(this.k);
                fuVar.addView(this.k, new ViewGroup.LayoutParams(-1, -1));
                a(PanelStateKt.PANEL_EXPANDED);
            }
        }
        fuVar.setCloseVisible(true);
        fuVar.setOnCloseListener(this.h);
        c cVar = this.n;
        if (cVar != null && this.q == null) {
            cVar.ah();
        }
        ae.a("MRAIDMRAID dialog create");
    }
}

package com.my.target;

import a2.l.a.m;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
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
import com.avito.android.search.map.view.PanelStateKt;
import com.my.target.bk;
import com.my.target.er;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
public class ei implements bk.a, er {
    @NonNull
    public final fu a;
    @NonNull
    public final bn b;
    @NonNull
    public final bk c;
    @NonNull
    public final WeakReference<Activity> d;
    @NonNull
    public final Context e;
    @NonNull
    public String f;
    @Nullable
    public Integer g;
    public boolean h = true;
    public bm i = bm.aQ();
    @Nullable
    public ga j;
    public boolean k;
    @Nullable
    public er.a l;
    public boolean m;
    @Nullable
    public cc n;
    public long o;
    public long p;
    @NonNull
    public final Handler q;
    @NonNull
    public final a r;

    public static class a implements Runnable {
        @NonNull
        public final fu a;

        public a(@NonNull fu fuVar) {
            this.a = fuVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            ae.a("banner became just closeable");
            this.a.setCloseVisible(true);
        }
    }

    public ei(@NonNull Context context) {
        bk g2 = bk.g("interstitial");
        Handler handler = new Handler(Looper.getMainLooper());
        fu fuVar = new fu(context);
        this.c = g2;
        this.e = context.getApplicationContext();
        this.q = handler;
        this.a = fuVar;
        this.d = context instanceof Activity ? new WeakReference<>((Activity) context) : new WeakReference<>(null);
        this.f = "loading";
        this.b = bn.u(context);
        fuVar.setOnCloseListener(new m(this));
        this.r = new a(fuVar);
        g2.a(this);
    }

    @NonNull
    public static ei z(@NonNull Context context) {
        return new ei(context);
    }

    @Override // com.my.target.er
    public void a(@NonNull cq cqVar, @NonNull cc ccVar) {
        this.n = ccVar;
        long allowCloseDelay = (long) (ccVar.getAllowCloseDelay() * 1000.0f);
        this.o = allowCloseDelay;
        if (allowCloseDelay > 0) {
            this.a.setCloseVisible(false);
            ae.a("banner will be allowed to close in " + this.o + " millis");
            long j2 = this.o;
            this.q.removeCallbacks(this.r);
            this.p = System.currentTimeMillis();
            this.q.postDelayed(this.r, j2);
        } else {
            ae.a("banner is allowed to close");
            this.a.setCloseVisible(true);
        }
        String source = ccVar.getSource();
        if (source != null) {
            ga gaVar = new ga(this.e);
            this.j = gaVar;
            this.c.a(gaVar);
            this.a.addView(this.j, new FrameLayout.LayoutParams(-1, -1));
            this.c.h(source);
        }
    }

    @Override // com.my.target.er
    public void a(@Nullable er.a aVar) {
        this.l = aVar;
    }

    public final void a(@NonNull String str) {
        a2.b.a.a.a.U0("MRAID state set to ", str);
        this.f = str;
        this.c.j(str);
        if (PanelStateKt.PANEL_HIDDEN.equals(str)) {
            ae.a("InterstitialMraidPresenter: Mraid on close");
            er.a aVar = this.l;
            if (aVar != null) {
                aVar.p();
            }
        }
    }

    @Override // com.my.target.bk.a
    public boolean a(int i2, int i3, int i4, int i5, boolean z, int i6) {
        ae.a("setResizeProperties method not used with interstitials");
        return false;
    }

    @Override // com.my.target.bk.a
    public boolean a(@NonNull ConsoleMessage consoleMessage, @NonNull bk bkVar) {
        StringBuilder L = a2.b.a.a.a.L("Console message: ");
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
    public void aN() {
        f();
    }

    @Override // com.my.target.bk.a
    public void aO() {
        this.m = true;
    }

    @Override // com.my.target.bk.a
    public boolean aP() {
        ae.a("resize method not used with interstitials");
        return false;
    }

    @Override // com.my.target.bk.a
    public void b(@NonNull Uri uri) {
        er.a aVar = this.l;
        if (aVar != null) {
            aVar.b(this.n, uri.toString(), this.a.getContext());
        }
    }

    @Override // com.my.target.bk.a
    public boolean b(float f2, float f3) {
        er.a aVar;
        cc ccVar;
        if (!this.m) {
            this.c.a("playheadEvent", "Calling VPAID command before VPAID init");
            return false;
        } else if (f2 < 0.0f || f3 < 0.0f || (aVar = this.l) == null || (ccVar = this.n) == null) {
            return true;
        } else {
            aVar.a(ccVar, f2, f3, this.e);
            return true;
        }
    }

    @VisibleForTesting
    public boolean b(bm bmVar) {
        if ("none".equals(bmVar.toString())) {
            return true;
        }
        Activity activity = this.d.get();
        if (activity == null) {
            return false;
        }
        try {
            ActivityInfo activityInfo = activity.getPackageManager().getActivityInfo(new ComponentName(activity, activity.getClass()), 0);
            int i2 = activityInfo.screenOrientation;
            if (i2 != -1) {
                return i2 == bmVar.aR();
            }
            int i3 = activityInfo.configChanges;
            if ((i3 & 128) != 0) {
                if ((i3 & 1024) != 0) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.my.target.bk.a
    public void c(@NonNull bk bkVar) {
        cc ccVar;
        ga gaVar;
        this.f = "default";
        f();
        ArrayList<String> arrayList = new ArrayList<>();
        Activity activity = this.d.get();
        if ((activity == null || (gaVar = this.j) == null) ? false : io.a(activity, gaVar)) {
            arrayList.add("'inlineVideo'");
        }
        arrayList.add("'vpaid'");
        bkVar.a(arrayList);
        bkVar.i("interstitial");
        bkVar.q(bkVar.isVisible());
        a("default");
        bkVar.aL();
        bkVar.a(this.b);
        er.a aVar = this.l;
        if (aVar != null && (ccVar = this.n) != null) {
            aVar.a(ccVar, this.a);
        }
    }

    @Override // com.my.target.bk.a
    public boolean c(@Nullable Uri uri) {
        ae.a("Expand method not used with interstitials");
        return false;
    }

    @Override // com.my.target.ej
    @NonNull
    public View cZ() {
        return this.a;
    }

    @VisibleForTesting
    public void d() {
        Integer num;
        Activity activity = this.d.get();
        if (!(activity == null || (num = this.g) == null)) {
            activity.setRequestedOrientation(num.intValue());
        }
        this.g = null;
    }

    @Override // com.my.target.ej
    public void destroy() {
        this.q.removeCallbacks(this.r);
        if (!this.k) {
            this.k = true;
            ga gaVar = this.j;
            if (gaVar != null) {
                gaVar.D(true);
            }
        }
        ViewParent parent = this.a.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(this.a);
        }
        this.c.detach();
        ga gaVar2 = this.j;
        if (gaVar2 != null) {
            gaVar2.destroy();
            this.j = null;
        }
        this.a.removeAllViews();
    }

    @VisibleForTesting
    public void e() {
        if (this.j != null && !"loading".equals(this.f) && !PanelStateKt.PANEL_HIDDEN.equals(this.f)) {
            d();
            if ("default".equals(this.f)) {
                this.a.setVisibility(4);
                a(PanelStateKt.PANEL_HIDDEN);
            }
        }
    }

    public final void f() {
        DisplayMetrics displayMetrics = this.e.getResources().getDisplayMetrics();
        this.b.a(displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.b.a(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.b.b(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
        this.b.c(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
    }

    @VisibleForTesting
    public boolean g(int i2) {
        Activity activity = this.d.get();
        if (activity == null || !b(this.i)) {
            bk bkVar = this.c;
            StringBuilder L = a2.b.a.a.a.L("Attempted to lock orientation to unsupported value: ");
            L.append(this.i.toString());
            bkVar.a("setOrientationProperties", L.toString());
            return false;
        }
        if (this.g == null) {
            this.g = Integer.valueOf(activity.getRequestedOrientation());
        }
        activity.setRequestedOrientation(i2);
        return true;
    }

    @Override // com.my.target.bk.a
    public boolean m(@NonNull String str) {
        boolean z = false;
        if (!this.m) {
            this.c.a("vpaidEvent", "Calling VPAID command before VPAID init");
            return false;
        }
        er.a aVar = this.l;
        boolean z2 = aVar != null;
        cc ccVar = this.n;
        if (ccVar != null) {
            z = true;
        }
        if (z && z2) {
            aVar.a(ccVar, str, this.e);
        }
        return true;
    }

    @Override // com.my.target.bk.a
    public void onClose() {
        e();
    }

    @Override // com.my.target.bk.a
    public void onVisibilityChanged(boolean z) {
        this.c.q(z);
    }

    @Override // com.my.target.ej
    public void pause() {
        this.k = true;
        ga gaVar = this.j;
        if (gaVar != null) {
            gaVar.D(false);
        }
        this.q.removeCallbacks(this.r);
        if (this.p > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.p;
            if (currentTimeMillis > 0) {
                long j2 = this.o;
                if (currentTimeMillis < j2) {
                    this.o = j2 - currentTimeMillis;
                    return;
                }
            }
            this.o = 0;
        }
    }

    @Override // com.my.target.ej
    public void resume() {
        this.k = false;
        ga gaVar = this.j;
        if (gaVar != null) {
            gaVar.onResume();
        }
        long j2 = this.o;
        if (j2 > 0) {
            this.q.removeCallbacks(this.r);
            this.p = System.currentTimeMillis();
            this.q.postDelayed(this.r, j2);
        }
    }

    @Override // com.my.target.ej
    public void stop() {
        this.k = true;
        ga gaVar = this.j;
        if (gaVar != null) {
            gaVar.D(false);
        }
    }

    @Override // com.my.target.bk.a
    public boolean a(boolean z, bm bmVar) {
        int i2;
        if (!b(bmVar)) {
            bk bkVar = this.c;
            bkVar.a("setOrientationProperties", "Unable to force orientation to " + bmVar);
            return false;
        }
        this.h = z;
        this.i = bmVar;
        if (!"none".equals(bmVar.toString())) {
            i2 = this.i.aR();
        } else if (this.h) {
            d();
            return true;
        } else {
            Activity activity = this.d.get();
            if (activity == null) {
                this.c.a("setOrientationProperties", "Unable to set MRAID expand orientation to 'none'; expected passed in Activity Context.");
                return false;
            }
            i2 = io.a(activity);
        }
        return g(i2);
    }
}

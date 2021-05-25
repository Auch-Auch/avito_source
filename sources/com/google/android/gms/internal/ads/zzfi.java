package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
public final class zzfi implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final Handler zzaah = new Handler(Looper.getMainLooper());
    private final Context zzaai;
    @Nullable
    private final PowerManager zzaaj;
    @Nullable
    private final KeyguardManager zzaak;
    private BroadcastReceiver zzaal;
    private WeakReference<ViewTreeObserver> zzaam;
    @Nullable
    private WeakReference<View> zzaan;
    private zzej zzaao;
    private byte zzaap = -1;
    private int zzaaq = -1;
    private long zzaar = -3;
    private Application zzyh;
    private final zzev zzyt;

    public zzfi(Context context, zzev zzev) {
        Context applicationContext = context.getApplicationContext();
        this.zzaai = applicationContext;
        this.zzyt = zzev;
        this.zzaaj = (PowerManager) applicationContext.getSystemService("power");
        this.zzaak = (KeyguardManager) applicationContext.getSystemService("keyguard");
        if (applicationContext instanceof Application) {
            this.zzyh = (Application) applicationContext;
            this.zzaao = new zzej((Application) applicationContext, this);
        }
        zze(null);
    }

    @Nullable
    private final View getCurrentView() {
        WeakReference<View> weakReference = this.zzaan;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    private final void zza(Activity activity, int i) {
        Window window;
        if (this.zzaan != null && (window = activity.getWindow()) != null) {
            View peekDecorView = window.peekDecorView();
            View currentView = getCurrentView();
            if (currentView != null && peekDecorView != null && currentView.getRootView() == peekDecorView.getRootView()) {
                this.zzaaq = i;
            }
        }
    }

    private final void zzct() {
        zzaah.post(new zzfh(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0064, code lost:
        if (r7 == false) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzcv() {
        /*
            r9 = this;
            java.lang.ref.WeakReference<android.view.View> r0 = r9.zzaan
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            android.view.View r0 = r9.getCurrentView()
            r1 = -1
            r2 = -3
            if (r0 != 0) goto L_0x0013
            r9.zzaar = r2
            r9.zzaap = r1
            return
        L_0x0013:
            int r4 = r0.getVisibility()
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x001d
            r4 = 1
            goto L_0x001e
        L_0x001d:
            r4 = 0
        L_0x001e:
            boolean r7 = r0.isShown()
            if (r7 != 0) goto L_0x0027
            r4 = r4 | 2
            byte r4 = (byte) r4
        L_0x0027:
            android.os.PowerManager r7 = r9.zzaaj
            if (r7 == 0) goto L_0x0034
            boolean r7 = r7.isScreenOn()
            if (r7 != 0) goto L_0x0034
            r4 = r4 | 4
            byte r4 = (byte) r4
        L_0x0034:
            com.google.android.gms.internal.ads.zzev r7 = r9.zzyt
            boolean r7 = r7.zzcb()
            if (r7 != 0) goto L_0x0068
            android.app.KeyguardManager r7 = r9.zzaak
            if (r7 == 0) goto L_0x0067
            boolean r7 = r7.inKeyguardRestrictedInputMode()
            if (r7 == 0) goto L_0x0067
            android.app.Activity r7 = com.google.android.gms.internal.ads.zzfg.zzd(r0)
            if (r7 == 0) goto L_0x0063
            android.view.Window r7 = r7.getWindow()
            if (r7 != 0) goto L_0x0054
            r7 = 0
            goto L_0x0058
        L_0x0054:
            android.view.WindowManager$LayoutParams r7 = r7.getAttributes()
        L_0x0058:
            if (r7 == 0) goto L_0x0063
            int r7 = r7.flags
            r8 = 524288(0x80000, float:7.34684E-40)
            r7 = r7 & r8
            if (r7 == 0) goto L_0x0063
            r7 = 1
            goto L_0x0064
        L_0x0063:
            r7 = 0
        L_0x0064:
            if (r7 == 0) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            r5 = 0
        L_0x0068:
            if (r5 != 0) goto L_0x006d
            r4 = r4 | 8
            byte r4 = (byte) r4
        L_0x006d:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getGlobalVisibleRect(r5)
            if (r5 != 0) goto L_0x007b
            r4 = r4 | 16
            byte r4 = (byte) r4
        L_0x007b:
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            boolean r5 = r0.getLocalVisibleRect(r5)
            if (r5 != 0) goto L_0x0089
            r4 = r4 | 32
            byte r4 = (byte) r4
        L_0x0089:
            int r0 = r0.getWindowVisibility()
            int r5 = r9.zzaaq
            if (r5 == r1) goto L_0x0092
            r0 = r5
        L_0x0092:
            if (r0 == 0) goto L_0x0097
            r0 = r4 | 64
            byte r4 = (byte) r0
        L_0x0097:
            byte r0 = r9.zzaap
            if (r0 == r4) goto L_0x00a9
            r9.zzaap = r4
            if (r4 != 0) goto L_0x00a4
            long r0 = android.os.SystemClock.elapsedRealtime()
            goto L_0x00a7
        L_0x00a4:
            long r0 = (long) r4
            long r0 = r2 - r0
        L_0x00a7:
            r9.zzaar = r0
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfi.zzcv():void");
    }

    private final void zzf(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzaam = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzaal == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            zzfk zzfk = new zzfk(this);
            this.zzaal = zzfk;
            this.zzaai.registerReceiver(zzfk, intentFilter);
        }
        Application application = this.zzyh;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzaao);
            } catch (Exception unused) {
            }
        }
    }

    private final void zzg(View view) {
        try {
            WeakReference<ViewTreeObserver> weakReference = this.zzaam;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzaam = null;
            }
        } catch (Exception unused) {
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception unused2) {
        }
        BroadcastReceiver broadcastReceiver = this.zzaal;
        if (broadcastReceiver != null) {
            try {
                this.zzaai.unregisterReceiver(broadcastReceiver);
            } catch (Exception unused3) {
            }
            this.zzaal = null;
        }
        Application application = this.zzyh;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzaao);
            } catch (Exception unused4) {
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzcv();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        zzcv();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzcv();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzcv();
        zzct();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzcv();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzcv();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        zzcv();
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzcv();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzcv();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        this.zzaaq = -1;
        zzf(view);
        zzcv();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.zzaaq = -1;
        zzcv();
        zzct();
        zzg(view);
    }

    public final long zzcu() {
        if (this.zzaar <= -2 && getCurrentView() == null) {
            this.zzaar = -3;
        }
        return this.zzaar;
    }

    public final void zze(View view) {
        View currentView = getCurrentView();
        if (currentView != null) {
            currentView.removeOnAttachStateChangeListener(this);
            zzg(currentView);
        }
        this.zzaan = new WeakReference<>(view);
        if (view != null) {
            if ((view.getWindowToken() == null && view.getWindowVisibility() == 8) ? false : true) {
                zzf(view);
            }
            view.addOnAttachStateChangeListener(this);
            this.zzaar = -2;
            return;
        }
        this.zzaar = -3;
    }
}

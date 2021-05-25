package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.ads.internal.zzp;
public final class zzbaq {
    private final View view;
    private boolean zzbro;
    private boolean zzbvt;
    private Activity zzecv;
    private boolean zzecw;
    private ViewTreeObserver.OnGlobalLayoutListener zzecx;
    private ViewTreeObserver.OnScrollChangedListener zzecy = null;

    public zzbaq(Activity activity, View view2, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.zzecv = activity;
        this.view = view2;
        this.zzecx = onGlobalLayoutListener;
    }

    private static ViewTreeObserver zzi(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }

    private final void zzyk() {
        ViewTreeObserver zzi;
        if (!this.zzecw) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzecx;
            if (onGlobalLayoutListener != null) {
                Activity activity = this.zzecv;
                if (!(activity == null || (zzi = zzi(activity)) == null)) {
                    zzi.addOnGlobalLayoutListener(onGlobalLayoutListener);
                }
                zzp.zzlm();
                zzbby.zza(this.view, this.zzecx);
            }
            this.zzecw = true;
        }
    }

    private final void zzyl() {
        ViewTreeObserver zzi;
        Activity activity = this.zzecv;
        if (activity != null && this.zzecw) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzecx;
            if (!(onGlobalLayoutListener == null || (zzi = zzi(activity)) == null)) {
                zzp.zzkr();
                zzi.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            this.zzecw = false;
        }
    }

    public final void onAttachedToWindow() {
        this.zzbro = true;
        if (this.zzbvt) {
            zzyk();
        }
    }

    public final void onDetachedFromWindow() {
        this.zzbro = false;
        zzyl();
    }

    public final void zzh(Activity activity) {
        this.zzecv = activity;
    }

    public final void zzyi() {
        this.zzbvt = true;
        if (this.zzbro) {
            zzyk();
        }
    }

    public final void zzyj() {
        this.zzbvt = false;
        zzyl();
    }
}

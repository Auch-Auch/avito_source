package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;
public final class zzcgo extends zzaiw implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzadf {
    private boolean zzeoa = false;
    private zzyg zzfxs;
    private View zzfxx;
    private zzcco zzfyz;
    private boolean zzgce = false;

    public zzcgo(zzcco zzcco, zzccv zzccv) {
        this.zzfxx = zzccv.zzalr();
        this.zzfxs = zzccv.getVideoController();
        this.zzfyz = zzcco;
        if (zzccv.zzals() != null) {
            zzccv.zzals().zza(this);
        }
    }

    private final void zzanc() {
        View view = this.zzfxx;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.zzfxx);
            }
        }
    }

    private final void zzand() {
        View view;
        zzcco zzcco = this.zzfyz;
        if (zzcco != null && (view = this.zzfxx) != null) {
            zzcco.zzb(view, Collections.emptyMap(), Collections.emptyMap(), zzcco.zzz(this.zzfxx));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzait
    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zzanc();
        zzcco zzcco = this.zzfyz;
        if (zzcco != null) {
            zzcco.destroy();
        }
        this.zzfyz = null;
        this.zzfxx = null;
        this.zzfxs = null;
        this.zzeoa = true;
    }

    @Override // com.google.android.gms.internal.ads.zzait
    public final zzyg getVideoController() throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (!this.zzeoa) {
            return this.zzfxs;
        }
        zzbbd.zzfc("getVideoController: Instream ad should not be used after destroyed");
        return null;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        zzand();
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        zzand();
    }

    @Override // com.google.android.gms.internal.ads.zzait
    public final void zza(IObjectWrapper iObjectWrapper, zzaiy zzaiy) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzeoa) {
            zzbbd.zzfc("Instream ad can not be shown after destroy().");
            zza(zzaiy, 2);
            return;
        }
        View view = this.zzfxx;
        if (view == null || this.zzfxs == null) {
            String str = view == null ? "can not get video view." : "can not get video controller.";
            zzbbd.zzfc(str.length() != 0 ? "Instream internal error: ".concat(str) : new String("Instream internal error: "));
            zza(zzaiy, 0);
        } else if (this.zzgce) {
            zzbbd.zzfc("Instream ad should not be used again.");
            zza(zzaiy, 1);
        } else {
            this.zzgce = true;
            zzanc();
            ((ViewGroup) ObjectWrapper.unwrap(iObjectWrapper)).addView(this.zzfxx, new ViewGroup.LayoutParams(-1, -1));
            zzp.zzlm();
            zzbby.zza(this.zzfxx, (ViewTreeObserver.OnGlobalLayoutListener) this);
            zzp.zzlm();
            zzbby.zza(this.zzfxx, (ViewTreeObserver.OnScrollChangedListener) this);
            zzand();
            try {
                zzaiy.zzsy();
            } catch (RemoteException e) {
                zzbbd.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final /* synthetic */ void zzane() {
        try {
            destroy();
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzait
    public final void zzr(IObjectWrapper iObjectWrapper) throws RemoteException {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        zza(iObjectWrapper, new zzcgq(this));
    }

    @Override // com.google.android.gms.internal.ads.zzadf
    public final void zzsc() {
        zzayh.zzeaj.post(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcgn
            private final zzcgo zzgcd;

            {
                this.zzgcd = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgcd.zzane();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzait
    public final zzadr zzss() {
        Preconditions.checkMainThread("#008 Must be called on the main UI thread.");
        if (this.zzeoa) {
            zzbbd.zzfc("getVideoController: Instream ad should not be used after destroyed");
            return null;
        }
        zzcco zzcco = this.zzfyz;
        if (zzcco == null || zzcco.zzalk() == null) {
            return null;
        }
        return this.zzfyz.zzalk().zzss();
    }

    private static void zza(zzaiy zzaiy, int i) {
        try {
            zzaiy.zzdc(i);
        } catch (RemoteException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
        }
    }
}

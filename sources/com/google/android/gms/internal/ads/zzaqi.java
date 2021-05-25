package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;
public final class zzaqi {
    private static final Object lock = new Object();
    @VisibleForTesting
    @GuardedBy("lock")
    private static boolean zzdnl = false;
    @VisibleForTesting
    @GuardedBy("lock")
    private static boolean zzzh = false;
    @VisibleForTesting
    private zzdpt zzdnm;

    @VisibleForTesting
    private final void zzq(Context context) {
        synchronized (lock) {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzctq)).booleanValue() && !zzdnl) {
                try {
                    zzdnl = true;
                    this.zzdnm = (zzdpt) zzbbc.zza(context, "com.google.android.gms.ads.omid.DynamiteOmid", zzaqh.zzbxs);
                } catch (zzbbe e) {
                    zzbbd.zze("#007 Could not call remote method.", e);
                }
            }
        }
    }

    @Nullable
    public final String getVersion(Context context) {
        if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzctq)).booleanValue()) {
            return null;
        }
        try {
            zzq(context);
            String valueOf = String.valueOf(this.zzdnm.getVersion());
            return valueOf.length() != 0 ? "a.".concat(valueOf) : new String("a.");
        } catch (RemoteException | NullPointerException e) {
            zzbbd.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    @Nullable
    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4) {
        return zza(str, webView, str2, str3, str4, "Google");
    }

    public final void zzab(IObjectWrapper iObjectWrapper) {
        synchronized (lock) {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzctq)).booleanValue()) {
                if (zzzh) {
                    try {
                        this.zzdnm.zzab(iObjectWrapper);
                    } catch (RemoteException | NullPointerException e) {
                        zzbbd.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final void zzac(IObjectWrapper iObjectWrapper) {
        synchronized (lock) {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzctq)).booleanValue()) {
                if (zzzh) {
                    try {
                        this.zzdnm.zzac(iObjectWrapper);
                    } catch (RemoteException | NullPointerException e) {
                        zzbbd.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, View view) {
        synchronized (lock) {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzctq)).booleanValue()) {
                if (zzzh) {
                    try {
                        this.zzdnm.zzd(iObjectWrapper, ObjectWrapper.wrap(view));
                    } catch (RemoteException | NullPointerException e) {
                        zzbbd.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }

    public final boolean zzp(Context context) {
        synchronized (lock) {
            if (!((Boolean) zzwe.zzpu().zzd(zzaat.zzctq)).booleanValue()) {
                return false;
            }
            if (zzzh) {
                return true;
            }
            try {
                zzq(context);
                boolean zzau = this.zzdnm.zzau(ObjectWrapper.wrap(context));
                zzzh = zzau;
                return zzau;
            } catch (RemoteException | NullPointerException e) {
                zzbbd.zze("#007 Could not call remote method.", e);
                return false;
            }
        }
    }

    @Nullable
    public final IObjectWrapper zza(String str, WebView webView, String str2, String str3, String str4, String str5) {
        synchronized (lock) {
            try {
                if (((Boolean) zzwe.zzpu().zzd(zzaat.zzctq)).booleanValue()) {
                    if (zzzh) {
                        try {
                            return this.zzdnm.zza(str, ObjectWrapper.wrap(webView), str2, str3, str4, str5);
                        } catch (RemoteException | NullPointerException e) {
                            zzbbd.zze("#007 Could not call remote method.", e);
                            return null;
                        }
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, View view) {
        synchronized (lock) {
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzctq)).booleanValue()) {
                if (zzzh) {
                    try {
                        this.zzdnm.zzc(iObjectWrapper, ObjectWrapper.wrap(view));
                    } catch (RemoteException | NullPointerException e) {
                        zzbbd.zze("#007 Could not call remote method.", e);
                    }
                }
            }
        }
    }
}

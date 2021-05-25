package com.google.android.gms.ads.formats;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaed;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzwe;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
public final class NativeAdViewHolder {
    public static WeakHashMap<View, NativeAdViewHolder> zzbnq = new WeakHashMap<>();
    private zzaed zzbnp;
    private WeakReference<View> zzbnr;

    public NativeAdViewHolder(View view, Map<String, View> map, Map<String, View> map2) {
        Preconditions.checkNotNull(view, "ContainerView must not be null");
        if ((view instanceof NativeAdView) || (view instanceof UnifiedNativeAdView)) {
            zzbbd.zzfc("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
        } else if (zzbnq.get(view) != null) {
            zzbbd.zzfc("The provided containerView is already in use with another NativeAdViewHolder.");
        } else {
            zzbnq.put(view, this);
            this.zzbnr = new WeakReference<>(view);
            this.zzbnp = zzwe.zzpr().zza(view, zzb(map), zzb(map2));
        }
    }

    private final void zza(IObjectWrapper iObjectWrapper) {
        WeakReference<View> weakReference = this.zzbnr;
        View view = weakReference != null ? weakReference.get() : null;
        if (view == null) {
            zzbbd.zzfe("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zzbnq.containsKey(view)) {
            zzbnq.put(view, this);
        }
        zzaed zzaed = this.zzbnp;
        if (zzaed != null) {
            try {
                zzaed.zza(iObjectWrapper);
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    private static HashMap<String, View> zzb(Map<String, View> map) {
        if (map == null) {
            return new HashMap<>();
        }
        return new HashMap<>(map);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzbnp.zze(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbbd.zzc("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    public final void setNativeAd(NativeAd nativeAd) {
        zza((IObjectWrapper) nativeAd.zzjq());
    }

    public final void unregisterNativeAd() {
        zzaed zzaed = this.zzbnp;
        if (zzaed != null) {
            try {
                zzaed.unregisterNativeAd();
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to call unregisterNativeAd on delegate", e);
            }
        }
        WeakReference<View> weakReference = this.zzbnr;
        View view = weakReference != null ? weakReference.get() : null;
        if (view != null) {
            zzbnq.remove(view);
        }
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        zza((IObjectWrapper) unifiedNativeAd.zzjq());
    }
}

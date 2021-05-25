package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
@ParametersAreNonnullByDefault
public final class zzcdq extends zzaeg implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcep {
    @GuardedBy("this")
    private zzcco zzfyz;
    private zzqq zzfza;
    private final WeakReference<View> zzfzd;
    private final Map<String, WeakReference<View>> zzfze = new HashMap();
    private final Map<String, WeakReference<View>> zzfzf = new HashMap();
    private final Map<String, WeakReference<View>> zzfzg = new HashMap();

    public zzcdq(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        zzp.zzlm();
        zzbby.zza(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzp.zzlm();
        zzbby.zza(view, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzfzd = new WeakReference<>(view);
        for (Map.Entry<String, View> entry : hashMap.entrySet()) {
            String key = entry.getKey();
            View value = entry.getValue();
            if (value != null) {
                this.zzfze.put(key, new WeakReference<>(value));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(key) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(key)) {
                    value.setOnTouchListener(this);
                    value.setClickable(true);
                    value.setOnClickListener(this);
                }
            }
        }
        this.zzfzg.putAll(this.zzfze);
        for (Map.Entry<String, View> entry2 : hashMap2.entrySet()) {
            View value2 = entry2.getValue();
            if (value2 != null) {
                this.zzfzf.put(entry2.getKey(), new WeakReference<>(value2));
                value2.setOnTouchListener(this);
                value2.setClickable(false);
            }
        }
        this.zzfzg.putAll(this.zzfzf);
        this.zzfza = new zzqq(view.getContext(), view);
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        zzcco zzcco = this.zzfyz;
        if (zzcco != null) {
            zzcco.zza(view, zzahq(), zzamo(), zzamp(), true);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        zzcco zzcco = this.zzfyz;
        if (zzcco != null) {
            zzcco.zzb(zzahq(), zzamo(), zzamp(), zzcco.zzz(zzahq()));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        zzcco zzcco = this.zzfyz;
        if (zzcco != null) {
            zzcco.zzb(zzahq(), zzamo(), zzamp(), zzcco.zzz(zzahq()));
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        zzcco zzcco = this.zzfyz;
        if (zzcco != null) {
            zzcco.zza(view, motionEvent, zzahq());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final synchronized void unregisterNativeAd() {
        zzcco zzcco = this.zzfyz;
        if (zzcco != null) {
            zzcco.zzb(this);
            this.zzfyz = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final synchronized void zza(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof zzcco)) {
            zzbbd.zzfe("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        zzcco zzcco = this.zzfyz;
        if (zzcco != null) {
            zzcco.zzb(this);
        }
        if (((zzcco) unwrap).zzali()) {
            zzcco zzcco2 = (zzcco) unwrap;
            this.zzfyz = zzcco2;
            zzcco2.zza(this);
            this.zzfyz.zzaa(zzahq());
            return;
        }
        zzbbd.zzfc("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
    }

    @Override // com.google.android.gms.internal.ads.zzcep
    @Nullable
    public final View zzahq() {
        return this.zzfzd.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcep
    public final synchronized Map<String, WeakReference<View>> zzamo() {
        return this.zzfzg;
    }

    @Override // com.google.android.gms.internal.ads.zzcep
    public final synchronized Map<String, WeakReference<View>> zzamp() {
        return this.zzfze;
    }

    @Override // com.google.android.gms.internal.ads.zzcep
    @Nullable
    public final synchronized Map<String, WeakReference<View>> zzamq() {
        return this.zzfzf;
    }

    @Override // com.google.android.gms.internal.ads.zzcep
    public final synchronized String zzamr() {
        return NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
    }

    @Override // com.google.android.gms.internal.ads.zzcep
    @Nullable
    public final FrameLayout zzams() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcep
    public final zzqq zzamt() {
        return this.zzfza;
    }

    @Override // com.google.android.gms.internal.ads.zzcep
    @Nullable
    public final synchronized IObjectWrapper zzamu() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzaed
    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        if (this.zzfyz != null) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof View)) {
                zzbbd.zzfe("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.zzfyz.setClickConfirmingView((View) unwrap);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcep
    public final synchronized View zzgf(String str) {
        WeakReference<View> weakReference = this.zzfzg.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcep
    public final synchronized void zza(String str, View view, boolean z) {
        if (view == null) {
            this.zzfzg.remove(str);
            this.zzfze.remove(str);
            this.zzfzf.remove(str);
            return;
        }
        this.zzfzg.put(str, new WeakReference<>(view));
        if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str)) {
            this.zzfze.put(str, new WeakReference<>(view));
            view.setClickable(true);
            view.setOnClickListener(this);
            view.setOnTouchListener(this);
        }
    }
}

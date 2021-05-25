package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Nonnull;
public final class zzarj {
    @Nonnull
    private final View zzaat;
    @Nullable
    private final Map<String, WeakReference<View>> zzdpj;
    @Nullable
    private final zzawu zzdpk;

    public zzarj(zzark zzark) {
        View zza = zzark.zza(zzark);
        this.zzaat = zza;
        Map<String, WeakReference<View>> zzb = zzark.zzb(zzark);
        this.zzdpj = zzb;
        zzawu zzs = zzarh.zzs(zzark.zza(zzark).getContext());
        this.zzdpk = zzs;
        if (zzs != null && zzb != null && !zzb.isEmpty()) {
            try {
                zzs.zza(new zzarn(ObjectWrapper.wrap(zza).asBinder(), ObjectWrapper.wrap(zzb).asBinder()));
            } catch (RemoteException unused) {
                zzbbd.zzfc("Failed to call remote method.");
            }
        }
    }

    public final void reportTouchEvent(MotionEvent motionEvent) {
        zzawu zzawu = this.zzdpk;
        if (zzawu == null) {
            zzbbd.zzef("Failed to get internal reporting info generator.");
            return;
        }
        try {
            zzawu.zzan(ObjectWrapper.wrap(motionEvent));
        } catch (RemoteException unused) {
            zzbbd.zzfc("Failed to call remote method.");
        }
    }

    public final void updateClickUrl(Uri uri, UpdateClickUrlCallback updateClickUrlCallback) {
        if (this.zzdpk == null) {
            updateClickUrlCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzdpk.zzb(new ArrayList(Arrays.asList(uri)), ObjectWrapper.wrap(this.zzaat), new zzarl(this, updateClickUrlCallback));
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateClickUrlCallback.onFailure(sb.toString());
        }
    }

    public final void updateImpressionUrls(List<Uri> list, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        if (this.zzdpk == null) {
            updateImpressionUrlsCallback.onFailure("Failed to get internal reporting info generator.");
        }
        try {
            this.zzdpk.zza(list, ObjectWrapper.wrap(this.zzaat), new zzari(this, updateImpressionUrlsCallback));
        } catch (RemoteException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(valueOf.length() + 16);
            sb.append("Internal error: ");
            sb.append(valueOf);
            updateImpressionUrlsCallback.onFailure(sb.toString());
        }
    }
}

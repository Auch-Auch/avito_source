package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzayy;
@VisibleForTesting
public final class zzj extends RelativeLayout {
    @VisibleForTesting
    private zzayy zzdol;
    @VisibleForTesting
    public boolean zzdom;

    public zzj(Context context, String str, String str2) {
        super(context);
        zzayy zzayy = new zzayy(context, str);
        this.zzdol = zzayy;
        zzayy.zzae(str2);
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzdom) {
            return false;
        }
        this.zzdol.zzd(motionEvent);
        return false;
    }
}

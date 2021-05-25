package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zzbfq;
@VisibleForTesting
public final class zzi {
    public final int index;
    public final ViewGroup parent;
    public final ViewGroup.LayoutParams zzdok;
    public final Context zzvr;

    public zzi(zzbfq zzbfq) throws zzg {
        this.zzdok = zzbfq.getLayoutParams();
        ViewParent parent2 = zzbfq.getParent();
        this.zzvr = zzbfq.zzaaz();
        if (parent2 == null || !(parent2 instanceof ViewGroup)) {
            throw new zzg("Could not get the parent of the WebView for an overlay.");
        }
        ViewGroup viewGroup = (ViewGroup) parent2;
        this.parent = viewGroup;
        this.index = viewGroup.indexOfChild(zzbfq.getView());
        viewGroup.removeView(zzbfq.getView());
        zzbfq.zzax(true);
    }
}

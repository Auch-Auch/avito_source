package com.google.android.gms.internal.ads;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import org.json.JSONException;
import org.json.JSONObject;
public class zzaqg {
    private final zzbfq zzdgc;
    private final String zzdnk;

    public zzaqg(zzbfq zzbfq) {
        this(zzbfq, "");
    }

    public final void zza(int i, int i2, int i3, int i4, float f, int i5) {
        try {
            this.zzdgc.zzb("onScreenInfoChanged", new JSONObject().put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i).put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i2).put("maxSizeWidth", i3).put("maxSizeHeight", i4).put("density", (double) f).put("rotation", i5));
        } catch (JSONException e) {
            zzbbd.zzc("Error occurred while obtaining screen information.", e);
        }
    }

    public final void zzb(int i, int i2, int i3, int i4) {
        try {
            this.zzdgc.zzb("onSizeChanged", new JSONObject().put("x", i).put("y", i2).put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i3).put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i4));
        } catch (JSONException e) {
            zzbbd.zzc("Error occurred while dispatching size change.", e);
        }
    }

    public final void zzc(int i, int i2, int i3, int i4) {
        try {
            this.zzdgc.zzb("onDefaultPositionReceived", new JSONObject().put("x", i).put("y", i2).put(ViewHierarchyConstants.DIMENSION_WIDTH_KEY, i3).put(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, i4));
        } catch (JSONException e) {
            zzbbd.zzc("Error occurred while dispatching default position.", e);
        }
    }

    public final void zzdx(String str) {
        try {
            JSONObject put = new JSONObject().put("message", str).put("action", this.zzdnk);
            zzbfq zzbfq = this.zzdgc;
            if (zzbfq != null) {
                zzbfq.zzb("onError", put);
            }
        } catch (JSONException e) {
            zzbbd.zzc("Error occurred while dispatching error event.", e);
        }
    }

    public final void zzdy(String str) {
        try {
            this.zzdgc.zzb("onReadyEventReceived", new JSONObject().put("js", str));
        } catch (JSONException e) {
            zzbbd.zzc("Error occurred while dispatching ready Event.", e);
        }
    }

    public final void zzdz(String str) {
        try {
            this.zzdgc.zzb("onStateChanged", new JSONObject().put("state", str));
        } catch (JSONException e) {
            zzbbd.zzc("Error occurred while dispatching state change.", e);
        }
    }

    public zzaqg(zzbfq zzbfq, String str) {
        this.zzdgc = zzbfq;
        this.zzdnk = str;
    }
}

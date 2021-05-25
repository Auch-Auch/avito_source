package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.ads.internal.zzp;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
public final class zzbly implements zzaln<zzbmc> {
    private final PowerManager zzaaj;
    private final zzqo zzfme;
    private final Context zzvr;

    public zzbly(Context context, zzqo zzqo) {
        this.zzvr = context;
        this.zzfme = zzqo;
        this.zzaaj = (PowerManager) context.getSystemService("power");
    }

    /* renamed from: zza */
    public final JSONObject zzj(zzbmc zzbmc) throws JSONException {
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        zzqr zzqr = zzbmc.zzfmw;
        if (zzqr == null) {
            jSONObject = new JSONObject();
        } else if (this.zzfme.zzlt() != null) {
            boolean z = zzqr.zzbro;
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("afmaVersion", this.zzfme.zzls()).put("activeViewJSON", this.zzfme.zzlt()).put("timestamp", zzbmc.timestamp).put("adFormat", this.zzfme.zzlr()).put("hashCode", this.zzfme.getUniqueId()).put("isMraid", false).put("isStopped", false).put("isPaused", zzbmc.zzfmt).put("isNative", this.zzfme.isNative()).put("isScreenOn", this.zzaaj.isInteractive()).put("appMuted", zzp.zzku().zzqe()).put("appVolume", (double) zzp.zzku().zzqd()).put("deviceVolume", (double) zzayz.zzbh(this.zzvr.getApplicationContext()));
            Rect rect = new Rect();
            Display defaultDisplay = ((WindowManager) this.zzvr.getSystemService("window")).getDefaultDisplay();
            rect.right = defaultDisplay.getWidth();
            rect.bottom = defaultDisplay.getHeight();
            jSONObject3.put("windowVisibility", zzqr.zzaaq).put("isAttachedToWindow", z).put("viewBox", new JSONObject().put("top", zzqr.zzbrp.top).put("bottom", zzqr.zzbrp.bottom).put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, zzqr.zzbrp.left).put("right", zzqr.zzbrp.right)).put("adBox", new JSONObject().put("top", zzqr.zzbrq.top).put("bottom", zzqr.zzbrq.bottom).put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, zzqr.zzbrq.left).put("right", zzqr.zzbrq.right)).put("globalVisibleBox", new JSONObject().put("top", zzqr.zzbrr.top).put("bottom", zzqr.zzbrr.bottom).put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, zzqr.zzbrr.left).put("right", zzqr.zzbrr.right)).put("globalVisibleBoxVisible", zzqr.zzbrs).put("localVisibleBox", new JSONObject().put("top", zzqr.zzbrt.top).put("bottom", zzqr.zzbrt.bottom).put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, zzqr.zzbrt.left).put("right", zzqr.zzbrt.right)).put("localVisibleBoxVisible", zzqr.zzbru).put("hitBox", new JSONObject().put("top", zzqr.zzbrv.top).put("bottom", zzqr.zzbrv.bottom).put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, zzqr.zzbrv.left).put("right", zzqr.zzbrv.right)).put("screenDensity", (double) this.zzvr.getResources().getDisplayMetrics().density);
            jSONObject3.put("isVisible", zzbmc.zzbrk);
            if (((Boolean) zzwe.zzpu().zzd(zzaat.zzcpn)).booleanValue()) {
                JSONArray jSONArray2 = new JSONArray();
                List<Rect> list = zzqr.zzbrx;
                if (list != null) {
                    for (Rect rect2 : list) {
                        jSONArray2.put(new JSONObject().put("top", rect2.top).put("bottom", rect2.bottom).put(ViewHierarchyConstants.DIMENSION_LEFT_KEY, rect2.left).put("right", rect2.right));
                    }
                }
                jSONObject3.put("scrollableContainerBoxes", jSONArray2);
            }
            if (!TextUtils.isEmpty(zzbmc.zzfmv)) {
                jSONObject3.put("doneReasonCode", "u");
            }
            jSONObject = jSONObject3;
        } else {
            throw new JSONException("Active view Info cannot be null.");
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}

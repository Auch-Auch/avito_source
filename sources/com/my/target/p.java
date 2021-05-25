package com.my.target;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.VideoData;
import com.my.target.du;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
public class p extends c<cq> implements du.a {
    @Nullable
    public String a;

    public static void a(@NonNull JSONObject jSONObject, @NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        bp d = dl.a(bpVar, aVar, context).d(jSONObject);
        if (d != null) {
            bpVar.b(d);
        }
    }

    @NonNull
    public static c<cq> f() {
        return new p();
    }

    @Nullable
    public cq a(@NonNull String str, @NonNull bp bpVar, @Nullable cq cqVar, @NonNull a aVar, @NonNull Context context) {
        JSONObject jSONObject;
        JSONObject optJSONObject;
        JSONObject optJSONObject2;
        cl i;
        if (c.c(str)) {
            ec a3 = ec.a(aVar, bpVar);
            a3.S(str);
            if (!a3.cU().isEmpty()) {
                if (cqVar == null) {
                    cqVar = cq.bW();
                }
                cf<VideoData> cfVar = (cf) a3.cU().get(0);
                ce newBanner = ce.newBanner();
                newBanner.setCtaText(cfVar.getCtaText());
                newBanner.setVideoBanner(cfVar);
                newBanner.setStyle(1);
                newBanner.setTrackingLink(cfVar.getTrackingLink());
                Boolean bg = bpVar.bg();
                if (bg != null) {
                    cfVar.setAllowClose(bg.booleanValue());
                }
                Boolean bh = bpVar.bh();
                if (bh != null) {
                    cfVar.setAllowPause(bh.booleanValue());
                }
                Boolean bo = bpVar.bo();
                if (bo != null) {
                    cfVar.setAllowReplay(bo.booleanValue());
                }
                Boolean bm = bpVar.bm();
                if (bm != null) {
                    newBanner.setDirectLink(bm.booleanValue());
                }
                Boolean bn = bpVar.bn();
                if (bn != null) {
                    newBanner.setOpenInBrowser(bn.booleanValue());
                }
                float allowCloseDelay = bpVar.getAllowCloseDelay();
                if (allowCloseDelay >= 0.0f) {
                    cfVar.setAllowCloseDelay(allowCloseDelay);
                }
                for (cy cyVar : cfVar.getStatHolder().K("click")) {
                    newBanner.getStatHolder().b(cyVar);
                }
                cqVar.a(newBanner);
                Iterator<bz> it = cfVar.getCompanionBanners().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    bz next = it.next();
                    ca caVar = null;
                    if (next.getHtmlResource() != null) {
                        caVar = cc.fromCompanion(next);
                        continue;
                    } else if (next.getStaticResource() != null) {
                        caVar = cd.fromCompanion(next);
                        continue;
                    } else {
                        continue;
                    }
                    if (caVar != null) {
                        newBanner.setEndCard(caVar);
                        break;
                    }
                }
            }
            return cqVar;
        }
        JSONObject a4 = a(str, context);
        if (a4 != null) {
            if (cqVar == null) {
                cqVar = cq.bW();
            }
            this.a = a4.optString("mraid.js");
            String format = aVar.getFormat();
            if (Tracker.Events.CREATIVE_FULLSCREEN.equals(format) || "rewarded".equals(format)) {
                jSONObject = a4.optJSONObject(Tracker.Events.CREATIVE_FULLSCREEN);
                if (jSONObject == null) {
                    jSONObject = a4.optJSONObject("rewarded");
                }
            } else {
                jSONObject = a4.optJSONObject(format);
            }
            if (jSONObject != null) {
                JSONArray optJSONArray = jSONObject.optJSONArray("banners");
                if (!(optJSONArray == null || optJSONArray.length() <= 0 || (optJSONObject = optJSONArray.optJSONObject(0)) == null)) {
                    if ("additionalData".equals(optJSONObject.optString("type", ""))) {
                        a(optJSONObject, bpVar, aVar, context);
                    } else {
                        ca c = dr.e(bpVar, aVar, context).c(optJSONObject, this.a);
                        if (c != null) {
                            cqVar.a(c);
                        }
                    }
                }
            } else if (!(!aVar.isMediationEnabled() || (optJSONObject2 = a4.optJSONObject("mediation")) == null || (i = du.a(this, bpVar, aVar, context).i(optJSONObject2)) == null)) {
                cqVar.a(i);
            }
        }
        return cqVar;
    }

    @Override // com.my.target.du.a
    @Nullable
    public cn b(@NonNull JSONObject jSONObject, @NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        ca c = dr.e(bpVar, aVar, context).c(jSONObject, this.a);
        if (c == null) {
            return null;
        }
        cq bW = cq.bW();
        bW.a(c);
        return bW;
    }
}

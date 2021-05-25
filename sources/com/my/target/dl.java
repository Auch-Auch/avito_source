package com.my.target;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
public class dl {
    @NonNull
    public final bp a;
    @NonNull
    public final a b;
    @NonNull
    public final Context c;
    @NonNull
    public final eb d;

    public dl(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        this.a = bpVar;
        this.b = aVar;
        this.c = context;
        this.d = eb.k(bpVar, aVar, context);
    }

    public static dl a(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        return new dl(bpVar, aVar, context);
    }

    public final void b(@NonNull String str, @NonNull String str2) {
        dh.M(str).N(str2).v(this.b.getSlotId()).O(this.a.getUrl()).v(this.c);
    }

    @Nullable
    public bp d(@NonNull JSONObject jSONObject) {
        cy a3;
        int be = this.a.be();
        Boolean bool = null;
        if (be >= 5) {
            ae.a("got additional data, but max redirects limit exceeded");
            return null;
        }
        int optInt = jSONObject.optInt("id", this.a.getId());
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            b("Required field", "No url in additionalData Id = " + optInt);
            return null;
        }
        bp p = bp.p(optString);
        p.f(be + 1);
        p.setId(optInt);
        p.r(jSONObject.optBoolean("doAfter", p.aY()));
        p.g(jSONObject.optInt("doOnEmptyResponseFromId", p.aZ()));
        boolean optBoolean = jSONObject.optBoolean("isMidrollPoint", p.ba());
        p.t(optBoolean);
        float allowCloseDelay = this.a.getAllowCloseDelay();
        if (allowCloseDelay < 0.0f) {
            allowCloseDelay = (float) jSONObject.optDouble("allowCloseDelay", (double) p.getAllowCloseDelay());
        }
        p.setAllowCloseDelay(allowCloseDelay);
        Boolean bg = this.a.bg();
        if (bg == null) {
            bg = jSONObject.has("allowClose") ? Boolean.valueOf(jSONObject.optBoolean("allowClose")) : null;
        }
        p.a(bg);
        Boolean bh = this.a.bh();
        if (bh == null) {
            bh = jSONObject.has("hasPause") ? Boolean.valueOf(jSONObject.optBoolean("hasPause")) : null;
        }
        p.b(bh);
        Boolean bi = this.a.bi();
        if (bi == null) {
            bi = jSONObject.has("allowSeek") ? Boolean.valueOf(jSONObject.optBoolean("allowSeek")) : null;
        }
        p.c(bi);
        Boolean bj = this.a.bj();
        if (bj == null) {
            bj = jSONObject.has("allowSkip") ? Boolean.valueOf(jSONObject.optBoolean("allowSkip")) : null;
        }
        p.d(bj);
        Boolean bk = this.a.bk();
        if (bk == null) {
            bk = jSONObject.has("allowTrackChange") ? Boolean.valueOf(jSONObject.optBoolean("allowTrackChange")) : null;
        }
        p.e(bk);
        Boolean bn = this.a.bn();
        if (bn == null) {
            bn = jSONObject.has("openInBrowser") ? Boolean.valueOf(jSONObject.optBoolean("openInBrowser")) : null;
        }
        p.g(bn);
        Boolean bm = this.a.bm();
        if (bm == null) {
            bm = jSONObject.has("directLink") ? Boolean.valueOf(jSONObject.optBoolean("directLink")) : null;
        }
        p.f(bm);
        Boolean bo = this.a.bo();
        if (bo == null) {
            if (jSONObject.has("allowReplay")) {
                bool = Boolean.valueOf(jSONObject.optBoolean("allowReplay"));
            }
            bo = bool;
        }
        p.h(bo);
        float point = this.a.getPoint();
        if (point < 0.0f && jSONObject.has("point")) {
            point = (float) jSONObject.optDouble("point");
            if (point < 0.0f) {
                b("Bad value", "Wrong value " + point + " for point in additionalData object");
            }
        }
        p.setPoint(point);
        float pointP = this.a.getPointP();
        if (pointP < 0.0f && jSONObject.has("pointP")) {
            pointP = (float) jSONObject.optDouble("pointP");
            if (pointP < 0.0f) {
                b("Bad value", "Wrong value " + pointP + " for pointP in additionalData object");
            }
        }
        if (optBoolean && point < 0.0f && pointP < 0.0f) {
            pointP = 50.0f;
        }
        p.setPointP(pointP);
        p.d(this.a.bd());
        JSONArray optJSONArray = jSONObject.optJSONArray("serviceStatistics");
        if (optJSONArray != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (!(optJSONObject == null || (a3 = this.d.a(optJSONObject, -1.0f)) == null)) {
                    p.a(a3);
                }
            }
        }
        this.d.a(p.bl(), jSONObject, String.valueOf(p.getId()), -1.0f);
        return p;
    }
}

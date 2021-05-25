package com.my.target;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;
public class eb {
    @NonNull
    public final Context a;
    @NonNull
    public final bp b;
    @NonNull
    public final a c;
    @Nullable
    public String d;
    public boolean e = true;

    public eb(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        this.b = bpVar;
        this.c = aVar;
        this.a = context;
    }

    @NonNull
    public static eb k(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        return new eb(bpVar, aVar, context);
    }

    @Nullable
    public cx a(@NonNull JSONObject jSONObject, @NonNull String str, float f) {
        cx J = cx.J(str);
        if (jSONObject.has("pvalue")) {
            float optDouble = (float) jSONObject.optDouble("pvalue", (double) J.cv());
            if (optDouble >= 0.0f && optDouble <= 100.0f) {
                if (f > 0.0f) {
                    J.l((optDouble * f) / 100.0f);
                } else {
                    J.m(optDouble);
                }
                return J;
            }
        }
        if (!jSONObject.has("value")) {
            return null;
        }
        float optDouble2 = (float) jSONObject.optDouble("value", (double) J.cu());
        if (optDouble2 < 0.0f) {
            return null;
        }
        J.l(optDouble2);
        return J;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: com.my.target.cw */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public cy a(@NonNull JSONObject jSONObject, float f) {
        cy cyVar;
        String str;
        cv cvVar;
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString("url");
        cy cyVar2 = null;
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            f("Required field", "failed to parse stat: no type or url");
            return null;
        }
        optString.hashCode();
        if (!optString.equals("playheadViewabilityValue")) {
            cyVar = !optString.equals("playheadReachedValue") ? cy.c(optString, optString2) : a(jSONObject, optString2, f);
        } else {
            int optInt = jSONObject.optInt("viewablePercent", -1);
            if (optInt < 0 || optInt > 100) {
                str = "failed to parse viewabilityStat: invalid viewable percent value";
            } else {
                if (jSONObject.has("ovv")) {
                    cw I = cw.I(optString2);
                    I.u(optInt);
                    I.v(jSONObject.optBoolean("ovv", false));
                    if (jSONObject.has("pvalue")) {
                        float optDouble = (float) jSONObject.optDouble("pvalue", (double) I.cv());
                        if (optDouble >= 0.0f && optDouble <= 100.0f) {
                            if (f > 0.0f) {
                                I.l((optDouble * f) / 100.0f);
                                cvVar = I;
                            } else {
                                I.m(optDouble);
                                cvVar = I;
                            }
                        }
                    }
                    if (jSONObject.has("value")) {
                        float optDouble2 = (float) jSONObject.optDouble("value", (double) I.cu());
                        if (optDouble2 >= 0.0f) {
                            I.l(optDouble2);
                            cvVar = I;
                        }
                    }
                    cyVar = cyVar2;
                } else if (jSONObject.has("duration")) {
                    cv H = cv.H(optString2);
                    H.u(optInt);
                    float optDouble3 = (float) jSONObject.optDouble("duration", (double) H.getDuration());
                    if (optDouble3 >= 0.0f) {
                        H.setDuration(optDouble3);
                        cvVar = H;
                    }
                    cyVar = cyVar2;
                } else {
                    str = "failed to parse viewabilityStat: no ovv or duration";
                }
                cyVar2 = cvVar;
                cyVar = cyVar2;
            }
            f("Bad value", str);
            cyVar = cyVar2;
        }
        if (cyVar != null) {
            cyVar.w(jSONObject.optBoolean("needDecodeUrl", cyVar.cw()));
        }
        return cyVar;
    }

    public void a(@NonNull cz czVar, @NonNull JSONObject jSONObject, @NonNull String str, float f) {
        int length;
        cy a3;
        czVar.a(this.b.bl(), f);
        JSONArray optJSONArray = jSONObject.optJSONArray("statistics");
        if (optJSONArray != null && (length = optJSONArray.length()) > 0) {
            this.d = str;
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (!(optJSONObject == null || (a3 = a(optJSONObject, f)) == null)) {
                    czVar.b(a3);
                }
            }
        }
    }

    public void f(@NonNull String str, @NonNull String str2) {
        if (this.e) {
            dh.M(str).N(str2).v(this.c.getSlotId()).P(this.d).O(this.b.getUrl()).v(this.a);
        }
    }

    public void i(@Nullable Boolean bool) {
        this.e = bool.booleanValue();
    }
}

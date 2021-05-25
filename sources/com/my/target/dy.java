package com.my.target;

import a2.b.a.a.a;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
public class dy extends eb {
    public dy(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        super(bpVar, aVar, context);
    }

    public static dy i(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        return new dy(bpVar, aVar, context);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.my.target.eb
    @Nullable
    public cy a(@NonNull JSONObject jSONObject, float f) {
        char c;
        StringBuilder sb;
        String str;
        String str2;
        String str3;
        StringBuilder sb2;
        String optString = jSONObject.optString("type");
        String optString2 = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            f("Required field", "failed to parse stat: no type or url");
            return null;
        }
        optString.hashCode();
        switch (optString.hashCode()) {
            case -1053159584:
                if (optString.equals("playheadTimerValue")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 1669348544:
                if (optString.equals("playheadViewabilityValue")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1788134515:
                if (optString.equals("playheadReachedValue")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                if (!optString2.contains("[CONTENTPLAYHEAD]")) {
                    f("Required field", "failed to parse researchTimerStat: no [CONTENTPLAYHEAD] macros");
                    return null;
                }
                int optInt = jSONObject.optInt("startTimer", 0);
                int optInt2 = jSONObject.optInt("endTimer", 0);
                if (optInt < 0) {
                    sb = new StringBuilder();
                    str = "failed to parse researchTimerStat: wrong start timer ";
                } else if (optInt2 < 0) {
                    sb = new StringBuilder();
                    str = "failed to parse researchTimerStat: wrong end timer ";
                } else if (optInt2 == 0 || optInt < optInt2) {
                    bv s = bv.s(optString2);
                    s.q(jSONObject.optInt("rate", 1));
                    s.o(optInt);
                    s.p(optInt2);
                    return s;
                } else {
                    sb = a.N("failed to parse researchTimerStat: start timer (", optInt, ") cannot be less than end timer (", optInt, ")");
                    f("Bad value", sb.toString());
                    return null;
                }
                sb.append(str);
                sb.append(optInt);
                f("Bad value", sb.toString());
                return null;
            case 1:
                int optInt3 = jSONObject.optInt("viewablePercent", -1);
                if (optInt3 < 0 || optInt3 > 100) {
                    str2 = "failed to parse viewabilityStat: invalid viewable percent value";
                } else {
                    int optInt4 = jSONObject.optInt("duration", -1);
                    if (optInt4 < 0) {
                        return null;
                    }
                    int optInt5 = jSONObject.optInt("startTimer", 0);
                    int optInt6 = jSONObject.optInt("endTimer", 0);
                    if (optInt5 < 0) {
                        sb2 = new StringBuilder();
                        str3 = "failed to parse viewabilityStat: wrong start timer ";
                    } else if (optInt6 < 0) {
                        sb2 = new StringBuilder();
                        str3 = "failed to parse viewabilityStat: wrong end timer ";
                    } else if (optInt6 == 0 || optInt5 < optInt6) {
                        bw t = bw.t(optString2);
                        t.u(optInt3);
                        t.setDuration((float) optInt4);
                        t.o(optInt5);
                        t.p(optInt6);
                        return t;
                    } else {
                        str2 = a.S2("failed to parse viewabilityStat: start timer (", optInt5, ") cannot be less than end timer (", optInt6, ")");
                    }
                    sb2.append(str3);
                    sb2.append(optInt5);
                    str2 = sb2.toString();
                }
                f("Bad value", str2);
                return null;
            case 2:
                cx a = a(jSONObject, optString2, f);
                if (a == null || a.cu() < 0.0f) {
                    return null;
                }
                return a;
            default:
                return super.a(jSONObject, f);
        }
    }
}

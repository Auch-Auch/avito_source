package com.my.target;

import a2.b.a.a.a;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
public class dz {
    @NonNull
    public final bp a;
    @NonNull
    public final a b;
    @NonNull
    public final Context c;
    @NonNull
    public final dn d;
    public boolean e = true;

    public dz(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        this.a = bpVar;
        this.b = aVar;
        this.c = context;
        this.d = dn.c(bpVar, aVar, context);
    }

    @NonNull
    public static dz j(@NonNull bp bpVar, @NonNull a aVar, @NonNull Context context) {
        return new dz(bpVar, aVar, context);
    }

    public boolean a(@NonNull JSONObject jSONObject, @NonNull ck ckVar, @Nullable String str) {
        this.d.a(jSONObject, ckVar);
        this.e = ckVar.isLogErrors();
        if (!"html".equals(ckVar.getType())) {
            StringBuilder L = a.L("standard banner with unsupported type ");
            L.append(ckVar.getType());
            ae.a(L.toString());
            return false;
        }
        if (jSONObject.has("timeout")) {
            int optInt = jSONObject.optInt("timeout");
            if (optInt >= 5) {
                ckVar.setTimeout(optInt);
            } else {
                b("Required field", a.M2("Wrong banner timeout: ", optInt), ckVar.getId());
            }
        }
        String e2 = dn.e(jSONObject);
        if (TextUtils.isEmpty(e2)) {
            b("Required field", "Banner has no source field", ckVar.getId());
            return false;
        }
        if (!TextUtils.isEmpty(str)) {
            ckVar.setMraidJs(str);
            String g = dn.g(str, e2);
            if (g != null) {
                ckVar.setSource(g);
                ckVar.setType("mraid");
                e2 = g;
            }
        }
        ckVar.setSource(e2);
        return true;
    }

    public final void b(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        if (this.e) {
            dh.M(str).N(str2).v(this.b.getSlotId()).P(str3).O(this.a.getUrl()).v(this.c);
        }
    }
}

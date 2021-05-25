package com.my.target;

import a2.b.a.a.a;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.avito.android.remote.model.payment.status.PaymentStateKt;
import com.my.target.cn;
import org.json.JSONObject;
public abstract class c<T extends cn> {
    public static boolean c(@NonNull String str) {
        String trim = str.trim();
        return trim.startsWith("<VAST") || trim.startsWith("<?xml");
    }

    @Nullable
    public abstract T a(@NonNull String str, @NonNull bp bpVar, @Nullable T t, @NonNull a aVar, @NonNull Context context);

    @Nullable
    public JSONObject a(@Nullable String str, @NonNull Context context) {
        String str2;
        if (str != null) {
            str = str.trim();
        }
        if (str == null || "".equals(str)) {
            str2 = "parsing ad response: empty data";
        } else {
            ae.a("Converting to JSON...");
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!ae.enabled && jSONObject.optBoolean("sdk_debug_mode", false)) {
                    ae.enabled = true;
                }
                ae.a(PaymentStateKt.PAYMENT_STATE_DONE);
                if (b(jSONObject)) {
                    return jSONObject;
                }
                ae.a("invalid json version");
                return null;
            } catch (Throwable th) {
                StringBuilder L = a.L("parsing ad response error: ");
                L.append(th.getMessage());
                str2 = L.toString();
            }
        }
        ae.a(str2);
        return null;
    }

    public final boolean b(@NonNull JSONObject jSONObject) {
        try {
            String string = jSONObject.getString("version");
            ae.a("json version: " + string);
            int indexOf = string.indexOf(".");
            return indexOf > 0 && Integer.parseInt(string.substring(0, indexOf), 10) == 2;
        } catch (Throwable th) {
            a.q1(th, a.L("Check version failed: "));
        }
    }
}

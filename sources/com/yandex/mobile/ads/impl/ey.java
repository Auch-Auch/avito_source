package com.yandex.mobile.ads.impl;

import android.support.annotation.NonNull;
import org.json.JSONObject;
public final class ey {
    private final ev a;

    public ey(@NonNull ev evVar) {
        this.a = evVar;
    }

    private void b(@NonNull String str) {
        c(String.format("window.mraidbridge.%s", str));
    }

    private void c(@NonNull String str) {
        this.a.loadUrl("javascript: ".concat(String.valueOf(str)));
    }

    public final void a(String str) {
        this.a.b(str);
    }

    public final void a() {
        b("notifyReadyEvent();");
    }

    public final void a(@NonNull fb fbVar, @NonNull String str) {
        b("notifyErrorEvent(" + JSONObject.quote(fbVar.a()) + ", " + JSONObject.quote(str) + ")");
    }

    public final void a(@NonNull fb fbVar) {
        b("nativeCallComplete(" + JSONObject.quote(fbVar.a()) + ")");
    }

    public final void a(@NonNull fk... fkVarArr) {
        if (fkVarArr.length > 0) {
            StringBuilder sb = new StringBuilder("fireChangeEvent({");
            int length = fkVarArr.length;
            int i = 0;
            String str = "";
            while (i < length) {
                fk fkVar = fkVarArr[i];
                sb.append(str);
                sb.append(fkVar.a());
                i++;
                str = ", ";
            }
            sb.append("})");
            b(sb.toString());
        }
    }
}

package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import java.util.List;
import org.json.JSONObject;
public class aaf {
    @Nullable
    private zv a;

    public void a(@NonNull zx zxVar, @NonNull View view, @NonNull zt ztVar) {
        zv a3 = zxVar.a(null, view, 0);
        this.a = a3;
        a(zxVar, a3, view, 1, ztVar);
    }

    @NonNull
    public JSONObject a(@NonNull aah aah, int i) {
        zv zvVar = this.a;
        JSONObject jSONObject = zvVar != null ? zvVar.a(aah, i, 0).c : null;
        return jSONObject == null ? new JSONObject() : jSONObject;
    }

    private void a(@NonNull zx zxVar, @NonNull zv zvVar, @NonNull View view, int i, @NonNull zt ztVar) {
        List<View> a3 = zxVar.a(view, i);
        if (a3.size() == 0) {
            ztVar.a(zvVar.a());
            return;
        }
        for (View view2 : a3) {
            zv a4 = zxVar.a(zvVar.a(), view2, i);
            zvVar.a(a4);
            a(zxVar, a4, view2, i + 1, ztVar);
        }
    }
}

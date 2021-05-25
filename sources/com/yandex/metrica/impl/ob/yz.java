package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.ve;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
public class yz {
    @NonNull
    private final on a;

    public yz() {
        this(new on());
    }

    @NonNull
    public void a(@NonNull yx yxVar, @NonNull JSONObject jSONObject) {
        yxVar.a(this.a.a(a(jSONObject)));
    }

    @VisibleForTesting
    public yz(@NonNull on onVar) {
        this.a = onVar;
    }

    @NonNull
    private ve.a.l a(@NonNull JSONObject jSONObject) {
        ve.a.l lVar = new ve.a.l();
        JSONObject optJSONObject = jSONObject.optJSONObject("ui_parsing");
        if (optJSONObject != null) {
            lVar.b = optJSONObject.optInt("too_long_text_bound", lVar.b);
            lVar.c = optJSONObject.optInt("truncated_text_bound", lVar.c);
            lVar.d = optJSONObject.optInt("max_visited_children_in_level", lVar.d);
            lVar.e = abw.a(abc.a(optJSONObject, "after_create_timeout"), TimeUnit.SECONDS, lVar.e);
            lVar.f = optJSONObject.optBoolean("relative_text_size_calculation", lVar.f);
        }
        return lVar;
    }
}

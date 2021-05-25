package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.yandex.metrica.impl.ob.ve;
import org.json.JSONObject;
public class yy {
    @NonNull
    private om a;

    public yy() {
        this(new om());
    }

    private ve.a.k b(@NonNull JSONObject jSONObject, @NonNull String str) {
        ve.a.k kVar = new ve.a.k();
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject != null) {
            kVar.b = optJSONObject.optBoolean("text_size_collecting", kVar.b);
            kVar.c = optJSONObject.optBoolean("relative_text_size_collecting", kVar.c);
            kVar.d = optJSONObject.optBoolean("text_visibility_collecting", kVar.d);
            kVar.e = optJSONObject.optBoolean("text_style_collecting", kVar.e);
            kVar.j = optJSONObject.optBoolean("info_collecting", kVar.j);
            kVar.k = optJSONObject.optBoolean("non_content_view_collecting", kVar.k);
            kVar.l = optJSONObject.optBoolean("text_length_collecting", kVar.l);
            kVar.f = optJSONObject.optInt("too_long_text_bound", kVar.f);
            kVar.g = optJSONObject.optInt("truncated_text_bound", kVar.g);
            kVar.h = optJSONObject.optInt("max_entities_count", kVar.h);
            kVar.i = optJSONObject.optInt("max_full_content_length", kVar.i);
        }
        return kVar;
    }

    @NonNull
    public aah a(@NonNull JSONObject jSONObject, @NonNull String str) {
        return this.a.a(b(jSONObject, str));
    }

    @VisibleForTesting
    public yy(@NonNull om omVar) {
        this.a = omVar;
    }
}

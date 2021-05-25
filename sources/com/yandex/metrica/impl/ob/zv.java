package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
public class zv {
    @NonNull
    private final List<zv> a = new ArrayList();
    @NonNull
    private final aam b;

    public static class a {
        public final int a;
        public final int b;
        @Nullable
        public final JSONObject c;

        public a(int i, int i2, @Nullable JSONObject jSONObject) {
            this.a = i;
            this.b = i2;
            this.c = jSONObject;
        }
    }

    public zv(@NonNull aam aam) {
        this.b = aam;
    }

    public void a(@NonNull zv zvVar) {
        this.a.add(zvVar);
    }

    @NonNull
    public aam a() {
        return this.b;
    }

    @NonNull
    public a a(@NonNull aah aah, int i, int i2) {
        int i3;
        JSONObject jSONObject = new JSONObject();
        int i4 = i2 + 1;
        try {
            if (aah.f || this.b.a()) {
                jSONObject = this.b.c(aah);
            }
            i3 = jSONObject.toString().getBytes().length + i;
            try {
                JSONArray jSONArray = new JSONArray();
                jSONObject.put("ch", jSONArray);
                i3 += 8;
                if (i3 <= aah.k) {
                    if (i4 <= aah.j) {
                        Iterator<zv> it = this.a.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            a a3 = it.next().a(aah, jSONArray, i3, i4);
                            int i5 = a3.a;
                            if (i5 == 0) {
                                break;
                            }
                            i4 += a3.b;
                            i3 += i5;
                        }
                        return new a(i3 - i, i4 - i2, jSONObject);
                    }
                }
                return new a(0, 0, null);
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            i3 = i;
        }
    }

    @NonNull
    private a a(@NonNull aah aah, @NonNull JSONArray jSONArray, int i, int i2) {
        a a3 = a(aah, i + 1, i2);
        JSONObject jSONObject = a3.c;
        if (jSONObject != null) {
            jSONArray.put(jSONObject);
        }
        return a3;
    }
}

package com.yandex.metrica.impl.ob;

import android.support.annotation.NonNull;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
public class zo {
    @NonNull
    private final LinkedList<JSONObject> a = new LinkedList<>();
    @NonNull
    private final mn b;
    @NonNull
    private final LinkedList<String> c = new LinkedList<>();
    private int d;

    public zo(int i, @NonNull mn mnVar) {
        this.d = i;
        this.b = mnVar;
        a(mnVar);
    }

    @NonNull
    private JSONObject c() {
        JSONObject removeLast = this.a.removeLast();
        this.c.removeLast();
        return removeLast;
    }

    public void a(@NonNull JSONObject jSONObject) {
        if (this.a.size() == this.d) {
            c();
        }
        b(jSONObject);
        if (!this.c.isEmpty()) {
            this.b.b(this.c);
        }
    }

    @NonNull
    public JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("cxts", new JSONArray((Collection) this.a));
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    private void b(@NonNull JSONObject jSONObject) {
        String jSONObject2 = jSONObject.toString();
        this.a.addFirst(jSONObject);
        this.c.addFirst(jSONObject2);
    }

    @NonNull
    public List<JSONObject> a() {
        return this.a;
    }

    private void a(@NonNull mn mnVar) {
        List<String> h = mnVar.h();
        for (int max = Math.max(0, h.size() - this.d); max < h.size(); max++) {
            String str = h.get(max);
            try {
                a(new JSONObject(str), str);
            } catch (Throwable unused) {
            }
        }
    }

    private void a(@NonNull JSONObject jSONObject, @NonNull String str) {
        this.a.addLast(jSONObject);
        this.c.addLast(str);
    }
}

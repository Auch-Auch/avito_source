package com.yandex.metrica.impl.ob;

import org.json.JSONObject;
public class ai {
    private abj a = new abj();
    private adj b;

    public ai(adj adj) {
        this.b = adj;
    }

    public void a(String str, String str2) {
        this.b.a(this.a, str, str2);
    }

    public String a() {
        if (this.a.isEmpty()) {
            return null;
        }
        return new JSONObject(this.a).toString();
    }
}

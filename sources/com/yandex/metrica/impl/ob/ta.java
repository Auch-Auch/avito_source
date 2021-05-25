package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.Map;
public abstract class ta {
    private static final th d = new th("UNDEFINED_");
    public th a;
    public final String b;
    public final SharedPreferences c;
    private final Map<String, Object> e = new HashMap();
    private boolean f = false;

    public ta(Context context, String str) {
        this.b = str;
        this.c = a(context);
        this.a = new th(d.a(), str);
    }

    private SharedPreferences a(Context context) {
        return ti.a(context, f());
    }

    public abstract String f();

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.yandex.metrica.impl.ob.ta */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends ta> T h(String str) {
        synchronized (this) {
            this.e.put(str, this);
        }
        return this;
    }

    public String i() {
        return this.b;
    }

    public void j() {
        synchronized (this) {
            a();
            this.e.clear();
            this.f = false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.yandex.metrica.impl.ob.ta */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends ta> T a(String str, Object obj) {
        synchronized (this) {
            if (obj != null) {
                this.e.put(str, obj);
            }
        }
        return this;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.yandex.metrica.impl.ob.ta */
    /* JADX WARN: Multi-variable type inference failed */
    public <T extends ta> T h() {
        synchronized (this) {
            this.f = true;
            this.e.clear();
        }
        return this;
    }

    private void a() {
        SharedPreferences.Editor edit = this.c.edit();
        if (this.f) {
            edit.clear();
            a(edit);
            return;
        }
        for (Map.Entry<String, Object> entry : this.e.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == this) {
                edit.remove(key);
            } else if (value instanceof String) {
                edit.putString(key, (String) value);
            } else if (value instanceof Long) {
                edit.putLong(key, ((Long) value).longValue());
            } else if (value instanceof Integer) {
                edit.putInt(key, ((Integer) value).intValue());
            } else if (value instanceof Boolean) {
                edit.putBoolean(key, ((Boolean) value).booleanValue());
            } else if (value != null) {
                throw new UnsupportedOperationException();
            }
        }
        a(edit);
    }

    private void a(SharedPreferences.Editor editor) {
        editor.apply();
    }
}

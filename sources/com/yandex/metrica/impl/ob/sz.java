package com.yandex.metrica.impl.ob;

import android.content.Context;
import java.util.Map;
@Deprecated
public class sz extends ta {
    private final th d = new th("init_event_pref_key", i());
    private final th e = new th("init_event_pref_key");
    private final th f = new th("first_event_pref_key", i());
    private final th g = new th("fitst_event_description_key", i());

    public sz(Context context, String str) {
        super(context, str);
    }

    public static String f(String str) {
        return new th("init_event_pref_key", str).b();
    }

    public void a() {
        a(this.d.b(), "DONE").j();
    }

    public String b(String str) {
        return this.c.getString(this.d.b(), str);
    }

    public String c(String str) {
        return this.c.getString(this.f.b(), str);
    }

    @Deprecated
    public void d(String str) {
        a(new th("init_event_pref_key", str));
    }

    public String e(String str) {
        return this.c.getString(this.g.b(), str);
    }

    @Override // com.yandex.metrica.impl.ob.ta
    public String f() {
        return "_initpreferences";
    }

    public Map<String, ?> g() {
        return this.c.getAll();
    }

    public static String g(String str) {
        return str.replace("init_event_pref_key", "");
    }

    @Deprecated
    public String a(String str) {
        return this.c.getString(this.e.b(), str);
    }

    @Deprecated
    public void b() {
        a(this.e);
    }

    public void c() {
        a(this.d);
    }

    public void d() {
        a(this.f);
    }

    public void e() {
        a(this.g);
    }

    private void a(th thVar) {
        this.c.edit().remove(thVar.b()).apply();
    }
}

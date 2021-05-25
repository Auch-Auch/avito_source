package com.yandex.metrica.impl.ob;
public class mm extends mp {
    private final th a = new th("init_event_pref_key");
    private final th b = new th("first_event_pref_key");
    private final th c = new th("first_event_description_key");
    private final th d = new th("preload_info_auto_tracking_enabled");

    public mm(lx lxVar) {
        super(lxVar);
    }

    public void a() {
        b(this.a.b(), "DONE").q();
    }

    public void b() {
        b(this.b.b(), "DONE").q();
    }

    public boolean c() {
        return a(null) != null;
    }

    public boolean d() {
        return b(null) != null;
    }

    public void e() {
        a(this.c);
    }

    public String a(String str) {
        return c(this.a.b(), str);
    }

    public String b(String str) {
        return c(this.b.b(), str);
    }

    public void c(String str) {
        b(this.c.b(), str).q();
    }

    public String d(String str) {
        return c(this.c.b(), str);
    }

    public void a(boolean z) {
        a(this.d.b(), z).q();
    }

    public boolean b(boolean z) {
        return b(this.d.b(), z);
    }

    private void a(th thVar) {
        r(thVar.b()).q();
    }
}

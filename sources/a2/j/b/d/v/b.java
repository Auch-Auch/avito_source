package a2.j.b.d.v;
public class b {
    public static final a a = new a();
    public static final a b = new C0049b();
    public static final a c = new c();
    public static final a d = new d();

    public static class a implements a {
        @Override // a2.j.b.d.v.a
        public c a(float f, float f2, float f3) {
            return new c(255, k.g(0, 255, f2, f3, f), true);
        }
    }

    /* renamed from: a2.j.b.d.v.b$b  reason: collision with other inner class name */
    public static class C0049b implements a {
        @Override // a2.j.b.d.v.a
        public c a(float f, float f2, float f3) {
            return c.a(k.g(255, 0, f2, f3, f), 255);
        }
    }

    public static class c implements a {
        @Override // a2.j.b.d.v.a
        public c a(float f, float f2, float f3) {
            return c.a(k.g(255, 0, f2, f3, f), k.g(0, 255, f2, f3, f));
        }
    }

    public static class d implements a {
        @Override // a2.j.b.d.v.a
        public c a(float f, float f2, float f3) {
            float b = a2.b.a.a.a.b(f3, f2, 0.35f, f2);
            return c.a(k.g(255, 0, f2, b, f), k.g(0, 255, b, f3, f));
        }
    }
}

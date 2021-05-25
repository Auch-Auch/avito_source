package l6.v.a;
public class o<T> {

    public static class a {
        public b a;

        public synchronized b a() {
            b bVar = this.a;
            if (bVar == null) {
                return null;
            }
            this.a = bVar.a;
            return bVar;
        }

        public synchronized void b(int i) {
            b bVar;
            while (true) {
                bVar = this.a;
                if (bVar == null || bVar.b != i) {
                    break;
                }
                this.a = bVar.a;
                bVar.d();
            }
            if (bVar != null) {
                b bVar2 = bVar.a;
                while (bVar2 != null) {
                    b bVar3 = bVar2.a;
                    if (bVar2.b == i) {
                        bVar.a = bVar3;
                        bVar2.d();
                    } else {
                        bVar = bVar2;
                    }
                    bVar2 = bVar3;
                }
            }
        }

        public synchronized void c(b bVar) {
            b bVar2 = this.a;
            if (bVar2 == null) {
                this.a = bVar;
                return;
            }
            while (true) {
                b bVar3 = bVar2.a;
                if (bVar3 != null) {
                    bVar2 = bVar3;
                } else {
                    bVar2.a = bVar;
                    return;
                }
            }
        }
    }

    public static class b {
        public static b i;
        public static final Object j = new Object();
        public b a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public Object h;

        public static b a(int i2, int i3, int i4) {
            return b(i2, i3, i4, 0, 0, 0, null);
        }

        public static b b(int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
            b bVar;
            synchronized (j) {
                bVar = i;
                if (bVar == null) {
                    bVar = new b();
                } else {
                    i = bVar.a;
                    bVar.a = null;
                }
                bVar.b = i2;
                bVar.c = i3;
                bVar.d = i4;
                bVar.e = i5;
                bVar.f = i6;
                bVar.g = i7;
                bVar.h = obj;
            }
            return bVar;
        }

        public static b c(int i2, int i3, Object obj) {
            return b(i2, i3, 0, 0, 0, 0, obj);
        }

        public void d() {
            this.a = null;
            this.g = 0;
            this.f = 0;
            this.e = 0;
            this.d = 0;
            this.c = 0;
            this.b = 0;
            this.h = null;
            synchronized (j) {
                b bVar = i;
                if (bVar != null) {
                    this.a = bVar;
                }
                i = this;
            }
        }
    }
}

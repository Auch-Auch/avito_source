package l6.v.a;

import androidx.core.util.Pools;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.analytics.ecommerce.ProductAction;
import java.util.ArrayList;
import java.util.List;
import l6.v.a.p;
public class a implements p.a {
    public Pools.Pool<b> a = new Pools.SimplePool(30);
    public final ArrayList<b> b = new ArrayList<>();
    public final ArrayList<b> c = new ArrayList<>();
    public final AbstractC0537a d;
    public final p e;
    public int f = 0;

    /* renamed from: l6.v.a.a$a  reason: collision with other inner class name */
    public interface AbstractC0537a {
    }

    public static class b {
        public int a;
        public int b;
        public Object c;
        public int d;

        public b(int i, int i2, int i3, Object obj) {
            this.a = i;
            this.b = i2;
            this.d = i3;
            this.c = obj;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            int i = this.a;
            if (i != bVar.a) {
                return false;
            }
            if (i == 8 && Math.abs(this.d - this.b) == 1 && this.d == bVar.b && this.b == bVar.d) {
                return true;
            }
            if (this.d != bVar.d || this.b != bVar.b) {
                return false;
            }
            Object obj2 = this.c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.c)) {
                    return false;
                }
            } else if (bVar.c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.a * 31) + this.b) * 31) + this.d;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append("[");
            int i = this.a;
            sb.append(i != 1 ? i != 2 ? i != 4 ? i != 8 ? "??" : "mv" : "up" : "rm" : ProductAction.ACTION_ADD);
            sb.append(",s:");
            sb.append(this.b);
            sb.append("c:");
            sb.append(this.d);
            sb.append(",p:");
            return a2.b.a.a.a.r(sb, this.c, "]");
        }
    }

    public a(AbstractC0537a aVar) {
        this.d = aVar;
        this.e = new p(this);
    }

    public final boolean a(int i) {
        int size = this.c.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.c.get(i2);
            int i3 = bVar.a;
            if (i3 == 8) {
                if (f(bVar.d, i2 + 1) == i) {
                    return true;
                }
            } else if (i3 == 1) {
                int i4 = bVar.b;
                int i5 = bVar.d + i4;
                while (i4 < i5) {
                    if (f(i4, i2 + 1) == i) {
                        return true;
                    }
                    i4++;
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    public void b() {
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            ((r) this.d).a(this.c.get(i));
        }
        l(this.c);
        this.f = 0;
    }

    public void c() {
        b();
        int size = this.b.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.b.get(i);
            int i2 = bVar.a;
            if (i2 == 1) {
                ((r) this.d).a(bVar);
                ((r) this.d).d(bVar.b, bVar.d);
            } else if (i2 == 2) {
                ((r) this.d).a(bVar);
                AbstractC0537a aVar = this.d;
                int i3 = bVar.b;
                int i4 = bVar.d;
                r rVar = (r) aVar;
                rVar.a.J(i3, i4, true);
                RecyclerView recyclerView = rVar.a;
                recyclerView.k0 = true;
                recyclerView.h0.d += i4;
            } else if (i2 == 4) {
                ((r) this.d).a(bVar);
                ((r) this.d).c(bVar.b, bVar.d, bVar.c);
            } else if (i2 == 8) {
                ((r) this.d).a(bVar);
                ((r) this.d).e(bVar.b, bVar.d);
            }
        }
        l(this.b);
        this.f = 0;
    }

    public final void d(b bVar) {
        int i;
        int i2 = bVar.a;
        if (i2 == 1 || i2 == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int m = m(bVar.b, i2);
        int i3 = bVar.b;
        int i4 = bVar.a;
        if (i4 == 2) {
            i = 0;
        } else if (i4 == 4) {
            i = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i5 = 1;
        for (int i6 = 1; i6 < bVar.d; i6++) {
            int m2 = m((i * i6) + bVar.b, bVar.a);
            int i7 = bVar.a;
            if (i7 == 2 ? m2 == m : i7 == 4 && m2 == m + 1) {
                i5++;
            } else {
                b h = h(i7, m, i5, bVar.c);
                e(h, i3);
                k(h);
                if (bVar.a == 4) {
                    i3 += i5;
                }
                m = m2;
                i5 = 1;
            }
        }
        Object obj = bVar.c;
        k(bVar);
        if (i5 > 0) {
            b h2 = h(bVar.a, m, i5, obj);
            e(h2, i3);
            k(h2);
        }
    }

    public void e(b bVar, int i) {
        ((r) this.d).a(bVar);
        int i2 = bVar.a;
        if (i2 == 2) {
            AbstractC0537a aVar = this.d;
            int i3 = bVar.d;
            r rVar = (r) aVar;
            rVar.a.J(i, i3, true);
            RecyclerView recyclerView = rVar.a;
            recyclerView.k0 = true;
            recyclerView.h0.d += i3;
        } else if (i2 == 4) {
            ((r) this.d).c(i, bVar.d, bVar.c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    public int f(int i, int i2) {
        int size = this.c.size();
        while (i2 < size) {
            b bVar = this.c.get(i2);
            int i3 = bVar.a;
            if (i3 == 8) {
                int i4 = bVar.b;
                if (i4 == i) {
                    i = bVar.d;
                } else {
                    if (i4 < i) {
                        i--;
                    }
                    if (bVar.d <= i) {
                        i++;
                    }
                }
            } else {
                int i5 = bVar.b;
                if (i5 > i) {
                    continue;
                } else if (i3 == 2) {
                    int i6 = bVar.d;
                    if (i < i5 + i6) {
                        return -1;
                    }
                    i -= i6;
                } else if (i3 == 1) {
                    i += bVar.d;
                }
            }
            i2++;
        }
        return i;
    }

    public boolean g() {
        return this.b.size() > 0;
    }

    public b h(int i, int i2, int i3, Object obj) {
        b acquire = this.a.acquire();
        if (acquire == null) {
            return new b(i, i2, i3, obj);
        }
        acquire.a = i;
        acquire.b = i2;
        acquire.d = i3;
        acquire.c = obj;
        return acquire;
    }

    public final void i(b bVar) {
        this.c.add(bVar);
        int i = bVar.a;
        if (i == 1) {
            ((r) this.d).d(bVar.b, bVar.d);
        } else if (i == 2) {
            AbstractC0537a aVar = this.d;
            r rVar = (r) aVar;
            rVar.a.J(bVar.b, bVar.d, false);
            rVar.a.k0 = true;
        } else if (i == 4) {
            ((r) this.d).c(bVar.b, bVar.d, bVar.c);
        } else if (i == 8) {
            ((r) this.d).e(bVar.b, bVar.d);
        } else {
            throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:173:0x00a3 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x00d2 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0127 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:181:0x0118 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:185:0x0009 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x008e  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00ff  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void j() {
        /*
        // Method dump skipped, instructions count: 671
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.v.a.a.j():void");
    }

    public void k(b bVar) {
        bVar.c = null;
        this.a.release(bVar);
    }

    public void l(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            k(list.get(i));
        }
        list.clear();
    }

    public final int m(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.c.size() - 1; size >= 0; size--) {
            b bVar = this.c.get(size);
            int i5 = bVar.a;
            if (i5 == 8) {
                int i6 = bVar.b;
                int i7 = bVar.d;
                if (i6 < i7) {
                    i4 = i6;
                    i3 = i7;
                } else {
                    i3 = i6;
                    i4 = i7;
                }
                if (i < i4 || i > i3) {
                    if (i < i6) {
                        if (i2 == 1) {
                            bVar.b = i6 + 1;
                            bVar.d = i7 + 1;
                        } else if (i2 == 2) {
                            bVar.b = i6 - 1;
                            bVar.d = i7 - 1;
                        }
                    }
                } else if (i4 == i6) {
                    if (i2 == 1) {
                        bVar.d = i7 + 1;
                    } else if (i2 == 2) {
                        bVar.d = i7 - 1;
                    }
                    i++;
                } else {
                    if (i2 == 1) {
                        bVar.b = i6 + 1;
                    } else if (i2 == 2) {
                        bVar.b = i6 - 1;
                    }
                    i--;
                }
            } else {
                int i8 = bVar.b;
                if (i8 <= i) {
                    if (i5 == 1) {
                        i -= bVar.d;
                    } else if (i5 == 2) {
                        i += bVar.d;
                    }
                } else if (i2 == 1) {
                    bVar.b = i8 + 1;
                } else if (i2 == 2) {
                    bVar.b = i8 - 1;
                }
            }
        }
        for (int size2 = this.c.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.c.get(size2);
            if (bVar2.a == 8) {
                int i9 = bVar2.d;
                if (i9 == bVar2.b || i9 < 0) {
                    this.c.remove(size2);
                    k(bVar2);
                }
            } else if (bVar2.d <= 0) {
                this.c.remove(size2);
                k(bVar2);
            }
        }
        return i;
    }
}

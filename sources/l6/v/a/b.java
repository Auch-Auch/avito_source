package l6.v.a;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class b {
    public final AbstractC0538b a;
    public final a b = new a();
    public final List<View> c = new ArrayList();

    public static class a {
        public long a = 0;
        public a b;

        public void a(int i) {
            if (i >= 64) {
                a aVar = this.b;
                if (aVar != null) {
                    aVar.a(i - 64);
                    return;
                }
                return;
            }
            this.a &= ~(1 << i);
        }

        public int b(int i) {
            a aVar = this.b;
            if (aVar == null) {
                if (i >= 64) {
                    return Long.bitCount(this.a);
                }
                return Long.bitCount(this.a & ((1 << i) - 1));
            } else if (i < 64) {
                return Long.bitCount(this.a & ((1 << i) - 1));
            } else {
                return Long.bitCount(this.a) + aVar.b(i - 64);
            }
        }

        public final void c() {
            if (this.b == null) {
                this.b = new a();
            }
        }

        public boolean d(int i) {
            if (i < 64) {
                return (this.a & (1 << i)) != 0;
            }
            c();
            return this.b.d(i - 64);
        }

        public void e(int i, boolean z) {
            if (i >= 64) {
                c();
                this.b.e(i - 64, z);
                return;
            }
            long j = this.a;
            boolean z2 = (Long.MIN_VALUE & j) != 0;
            long j2 = (1 << i) - 1;
            this.a = ((j & (~j2)) << 1) | (j & j2);
            if (z) {
                h(i);
            } else {
                a(i);
            }
            if (z2 || this.b != null) {
                c();
                this.b.e(0, z2);
            }
        }

        public boolean f(int i) {
            if (i >= 64) {
                c();
                return this.b.f(i - 64);
            }
            long j = 1 << i;
            long j2 = this.a;
            boolean z = (j2 & j) != 0;
            long j3 = j2 & (~j);
            this.a = j3;
            long j4 = j - 1;
            this.a = (j3 & j4) | Long.rotateRight((~j4) & j3, 1);
            a aVar = this.b;
            if (aVar != null) {
                if (aVar.d(0)) {
                    h(63);
                }
                this.b.f(0);
            }
            return z;
        }

        public void g() {
            this.a = 0;
            a aVar = this.b;
            if (aVar != null) {
                aVar.g();
            }
        }

        public void h(int i) {
            if (i >= 64) {
                c();
                this.b.h(i - 64);
                return;
            }
            this.a |= 1 << i;
        }

        public String toString() {
            if (this.b == null) {
                return Long.toBinaryString(this.a);
            }
            return this.b.toString() + "xx" + Long.toBinaryString(this.a);
        }
    }

    /* renamed from: l6.v.a.b$b  reason: collision with other inner class name */
    public interface AbstractC0538b {
    }

    public b(AbstractC0538b bVar) {
        this.a = bVar;
    }

    public void a(View view, int i, boolean z) {
        int i2;
        if (i < 0) {
            i2 = ((q) this.a).b();
        } else {
            i2 = f(i);
        }
        this.b.e(i2, z);
        if (z) {
            i(view);
        }
        q qVar = (q) this.a;
        qVar.a.addView(view, i2);
        RecyclerView recyclerView = qVar.a;
        Objects.requireNonNull(recyclerView);
        RecyclerView.ViewHolder D = RecyclerView.D(view);
        recyclerView.onChildAttachedToWindow(view);
        RecyclerView.Adapter adapter = recyclerView.l;
        if (!(adapter == null || D == null)) {
            adapter.onViewAttachedToWindow(D);
        }
        List<RecyclerView.OnChildAttachStateChangeListener> list = recyclerView.C;
        if (list != null) {
            int size = list.size();
            while (true) {
                size--;
                if (size >= 0) {
                    recyclerView.C.get(size).onChildViewAttachedToWindow(view);
                } else {
                    return;
                }
            }
        }
    }

    public void b(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int i2;
        if (i < 0) {
            i2 = ((q) this.a).b();
        } else {
            i2 = f(i);
        }
        this.b.e(i2, z);
        if (z) {
            i(view);
        }
        q qVar = (q) this.a;
        Objects.requireNonNull(qVar);
        RecyclerView.ViewHolder D = RecyclerView.D(view);
        if (D != null) {
            if (D.l() || D.r()) {
                D.i &= -257;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("Called attach on a child which is not detached: ");
                sb.append(D);
                throw new IllegalArgumentException(a2.b.a.a.a.v2(qVar.a, sb));
            }
        }
        qVar.a.attachViewToParent(view, i2, layoutParams);
    }

    public void c(int i) {
        RecyclerView.ViewHolder D;
        int f = f(i);
        this.b.f(f);
        q qVar = (q) this.a;
        View childAt = qVar.a.getChildAt(f);
        if (!(childAt == null || (D = RecyclerView.D(childAt)) == null)) {
            if (!D.l() || D.r()) {
                D.b(256);
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append("called detach on an already detached child ");
                sb.append(D);
                throw new IllegalArgumentException(a2.b.a.a.a.v2(qVar.a, sb));
            }
        }
        qVar.a.detachViewFromParent(f);
    }

    public View d(int i) {
        return ((q) this.a).a(f(i));
    }

    public int e() {
        return ((q) this.a).b() - this.c.size();
    }

    public final int f(int i) {
        if (i < 0) {
            return -1;
        }
        int b2 = ((q) this.a).b();
        int i2 = i;
        while (i2 < b2) {
            int b3 = i - (i2 - this.b.b(i2));
            if (b3 == 0) {
                while (this.b.d(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += b3;
        }
        return -1;
    }

    public View g(int i) {
        return ((q) this.a).a.getChildAt(i);
    }

    public int h() {
        return ((q) this.a).b();
    }

    public final void i(View view) {
        this.c.add(view);
        q qVar = (q) this.a;
        Objects.requireNonNull(qVar);
        RecyclerView.ViewHolder D = RecyclerView.D(view);
        if (D != null) {
            RecyclerView recyclerView = qVar.a;
            int i = D.p;
            if (i != -1) {
                D.o = i;
            } else {
                D.o = ViewCompat.getImportantForAccessibility(D.itemView);
            }
            recyclerView.X(D, 4);
        }
    }

    public int j(View view) {
        int indexOfChild = ((q) this.a).a.indexOfChild(view);
        if (indexOfChild != -1 && !this.b.d(indexOfChild)) {
            return indexOfChild - this.b.b(indexOfChild);
        }
        return -1;
    }

    public boolean k(View view) {
        return this.c.contains(view);
    }

    public void l(int i) {
        int f = f(i);
        View a3 = ((q) this.a).a(f);
        if (a3 != null) {
            if (this.b.f(f)) {
                m(a3);
            }
            ((q) this.a).c(f);
        }
    }

    public final boolean m(View view) {
        if (!this.c.remove(view)) {
            return false;
        }
        q qVar = (q) this.a;
        Objects.requireNonNull(qVar);
        RecyclerView.ViewHolder D = RecyclerView.D(view);
        if (D == null) {
            return true;
        }
        qVar.a.X(D, D.o);
        D.o = 0;
        return true;
    }

    public String toString() {
        return this.b.toString() + ", hidden list:" + this.c.size();
    }
}

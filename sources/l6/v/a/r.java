package l6.v.a;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import l6.v.a.a;
public class r implements a.AbstractC0537a {
    public final /* synthetic */ RecyclerView a;

    public r(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    public void a(a.b bVar) {
        int i = bVar.a;
        if (i == 1) {
            RecyclerView recyclerView = this.a;
            recyclerView.m.onItemsAdded(recyclerView, bVar.b, bVar.d);
        } else if (i == 2) {
            RecyclerView recyclerView2 = this.a;
            recyclerView2.m.onItemsRemoved(recyclerView2, bVar.b, bVar.d);
        } else if (i == 4) {
            RecyclerView recyclerView3 = this.a;
            recyclerView3.m.onItemsUpdated(recyclerView3, bVar.b, bVar.d, bVar.c);
        } else if (i == 8) {
            RecyclerView recyclerView4 = this.a;
            recyclerView4.m.onItemsMoved(recyclerView4, bVar.b, bVar.d, 1);
        }
    }

    public RecyclerView.ViewHolder b(int i) {
        RecyclerView.ViewHolder A = this.a.A(i, true);
        if (A != null && !this.a.e.k(A.itemView)) {
            return A;
        }
        return null;
    }

    public void c(int i, int i2, Object obj) {
        int i3;
        int i4;
        RecyclerView recyclerView = this.a;
        int h = recyclerView.e.h();
        int i5 = i2 + i;
        for (int i6 = 0; i6 < h; i6++) {
            View g = recyclerView.e.g(i6);
            RecyclerView.ViewHolder D = RecyclerView.D(g);
            if (D != null && !D.r() && (i4 = D.b) >= i && i4 < i5) {
                D.b(2);
                D.a(obj);
                ((RecyclerView.LayoutParams) g.getLayoutParams()).c = true;
            }
        }
        RecyclerView.Recycler recycler = recyclerView.b;
        int size = recycler.c.size();
        while (true) {
            size--;
            if (size >= 0) {
                RecyclerView.ViewHolder viewHolder = recycler.c.get(size);
                if (viewHolder != null && (i3 = viewHolder.b) >= i && i3 < i5) {
                    viewHolder.b(2);
                    recycler.d(size);
                }
            } else {
                this.a.l0 = true;
                return;
            }
        }
    }

    public void d(int i, int i2) {
        RecyclerView recyclerView = this.a;
        int h = recyclerView.e.h();
        for (int i3 = 0; i3 < h; i3++) {
            RecyclerView.ViewHolder D = RecyclerView.D(recyclerView.e.g(i3));
            if (D != null && !D.r() && D.b >= i) {
                D.o(i2, false);
                recyclerView.h0.g = true;
            }
        }
        RecyclerView.Recycler recycler = recyclerView.b;
        int size = recycler.c.size();
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView.ViewHolder viewHolder = recycler.c.get(i4);
            if (viewHolder != null && viewHolder.b >= i) {
                viewHolder.o(i2, true);
            }
        }
        recyclerView.requestLayout();
        this.a.k0 = true;
    }

    public void e(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        RecyclerView recyclerView = this.a;
        int h = recyclerView.e.h();
        int i10 = -1;
        if (i < i2) {
            i5 = i;
            i4 = i2;
            i3 = -1;
        } else {
            i4 = i;
            i5 = i2;
            i3 = 1;
        }
        for (int i11 = 0; i11 < h; i11++) {
            RecyclerView.ViewHolder D = RecyclerView.D(recyclerView.e.g(i11));
            if (D != null && (i9 = D.b) >= i5 && i9 <= i4) {
                if (i9 == i) {
                    D.o(i2 - i, false);
                } else {
                    D.o(i3, false);
                }
                recyclerView.h0.g = true;
            }
        }
        RecyclerView.Recycler recycler = recyclerView.b;
        if (i < i2) {
            i7 = i;
            i6 = i2;
        } else {
            i6 = i;
            i7 = i2;
            i10 = 1;
        }
        int size = recycler.c.size();
        for (int i12 = 0; i12 < size; i12++) {
            RecyclerView.ViewHolder viewHolder = recycler.c.get(i12);
            if (viewHolder != null && (i8 = viewHolder.b) >= i7 && i8 <= i6) {
                if (i8 == i) {
                    viewHolder.o(i2 - i, false);
                } else {
                    viewHolder.o(i10, false);
                }
            }
        }
        recyclerView.requestLayout();
        this.a.k0 = true;
    }
}

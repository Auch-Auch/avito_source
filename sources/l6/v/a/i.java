package l6.v.a;

import android.annotation.SuppressLint;
import androidx.core.os.TraceCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.TimeUnit;
public final class i implements Runnable {
    public static final ThreadLocal<i> e = new ThreadLocal<>();
    public static Comparator<c> f = new a();
    public ArrayList<RecyclerView> a = new ArrayList<>();
    public long b;
    public long c;
    public ArrayList<c> d = new ArrayList<>();

    public static class a implements Comparator<c> {
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0017, code lost:
            if (r0 == null) goto L_0x0023;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0020, code lost:
            if (r0 != false) goto L_0x0022;
         */
        @Override // java.util.Comparator
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public int compare(l6.v.a.i.c r7, l6.v.a.i.c r8) {
            /*
                r6 = this;
                l6.v.a.i$c r7 = (l6.v.a.i.c) r7
                l6.v.a.i$c r8 = (l6.v.a.i.c) r8
                androidx.recyclerview.widget.RecyclerView r0 = r7.d
                r1 = 1
                r2 = 0
                if (r0 != 0) goto L_0x000c
                r3 = 1
                goto L_0x000d
            L_0x000c:
                r3 = 0
            L_0x000d:
                androidx.recyclerview.widget.RecyclerView r4 = r8.d
                if (r4 != 0) goto L_0x0013
                r4 = 1
                goto L_0x0014
            L_0x0013:
                r4 = 0
            L_0x0014:
                r5 = -1
                if (r3 == r4) goto L_0x001a
                if (r0 != 0) goto L_0x0022
                goto L_0x0023
            L_0x001a:
                boolean r0 = r7.a
                boolean r3 = r8.a
                if (r0 == r3) goto L_0x0025
                if (r0 == 0) goto L_0x0023
            L_0x0022:
                r1 = -1
            L_0x0023:
                r2 = r1
                goto L_0x0036
            L_0x0025:
                int r0 = r8.b
                int r1 = r7.b
                int r0 = r0 - r1
                if (r0 == 0) goto L_0x002e
                r2 = r0
                goto L_0x0036
            L_0x002e:
                int r7 = r7.c
                int r8 = r8.c
                int r7 = r7 - r8
                if (r7 == 0) goto L_0x0036
                r2 = r7
            L_0x0036:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: l6.v.a.i.a.compare(java.lang.Object, java.lang.Object):int");
        }
    }

    @SuppressLint({"VisibleForTests"})
    public static class b implements RecyclerView.LayoutManager.LayoutPrefetchRegistry {
        public int a;
        public int b;
        public int[] c;
        public int d;

        public void a(RecyclerView recyclerView, boolean z) {
            this.d = 0;
            int[] iArr = this.c;
            if (iArr != null) {
                Arrays.fill(iArr, -1);
            }
            RecyclerView.LayoutManager layoutManager = recyclerView.m;
            if (recyclerView.l != null && layoutManager != null && layoutManager.isItemPrefetchEnabled()) {
                if (z) {
                    if (!recyclerView.d.g()) {
                        layoutManager.collectInitialPrefetchPositions(recyclerView.l.getItemCount(), this);
                    }
                } else if (!recyclerView.hasPendingAdapterUpdates()) {
                    layoutManager.collectAdjacentPrefetchPositions(this.a, this.b, recyclerView.h0, this);
                }
                int i = this.d;
                if (i > layoutManager.m) {
                    layoutManager.m = i;
                    layoutManager.n = z;
                    recyclerView.b.j();
                }
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager.LayoutPrefetchRegistry
        public void addPosition(int i, int i2) {
            if (i < 0) {
                throw new IllegalArgumentException("Layout positions must be non-negative");
            } else if (i2 >= 0) {
                int i3 = this.d * 2;
                int[] iArr = this.c;
                if (iArr == null) {
                    int[] iArr2 = new int[4];
                    this.c = iArr2;
                    Arrays.fill(iArr2, -1);
                } else if (i3 >= iArr.length) {
                    int[] iArr3 = new int[(i3 * 2)];
                    this.c = iArr3;
                    System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
                }
                int[] iArr4 = this.c;
                iArr4[i3] = i;
                iArr4[i3 + 1] = i2;
                this.d++;
            } else {
                throw new IllegalArgumentException("Pixel distance must be non-negative");
            }
        }

        public boolean b(int i) {
            if (this.c != null) {
                int i2 = this.d * 2;
                for (int i3 = 0; i3 < i2; i3 += 2) {
                    if (this.c[i3] == i) {
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public static class c {
        public boolean a;
        public int b;
        public int c;
        public RecyclerView d;
        public int e;
    }

    public void a(RecyclerView recyclerView, int i, int i2) {
        if (recyclerView.isAttachedToWindow() && this.b == 0) {
            this.b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        b bVar = recyclerView.g0;
        bVar.a = i;
        bVar.b = i2;
    }

    public void b(long j) {
        c cVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        c cVar2;
        int size = this.a.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            RecyclerView recyclerView3 = this.a.get(i2);
            if (recyclerView3.getWindowVisibility() == 0) {
                recyclerView3.g0.a(recyclerView3, false);
                i += recyclerView3.g0.d;
            }
        }
        this.d.ensureCapacity(i);
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            RecyclerView recyclerView4 = this.a.get(i4);
            if (recyclerView4.getWindowVisibility() == 0) {
                b bVar = recyclerView4.g0;
                int abs = Math.abs(bVar.b) + Math.abs(bVar.a);
                for (int i5 = 0; i5 < bVar.d * 2; i5 += 2) {
                    if (i3 >= this.d.size()) {
                        cVar2 = new c();
                        this.d.add(cVar2);
                    } else {
                        cVar2 = this.d.get(i3);
                    }
                    int[] iArr = bVar.c;
                    int i6 = iArr[i5 + 1];
                    cVar2.a = i6 <= abs;
                    cVar2.b = abs;
                    cVar2.c = i6;
                    cVar2.d = recyclerView4;
                    cVar2.e = iArr[i5];
                    i3++;
                }
            }
        }
        Collections.sort(this.d, f);
        int i7 = 0;
        while (i7 < this.d.size() && (recyclerView = (cVar = this.d.get(i7)).d) != null) {
            RecyclerView.ViewHolder c2 = c(recyclerView, cVar.e, cVar.a ? Long.MAX_VALUE : j);
            if (!(c2 == null || c2.a == null || !c2.h() || c2.i() || (recyclerView2 = c2.a.get()) == null)) {
                if (recyclerView2.D && recyclerView2.e.h() != 0) {
                    recyclerView2.R();
                }
                b bVar2 = recyclerView2.g0;
                bVar2.a(recyclerView2, true);
                if (bVar2.d != 0) {
                    try {
                        TraceCompat.beginSection("RV Nested Prefetch");
                        RecyclerView.State state = recyclerView2.h0;
                        RecyclerView.Adapter adapter = recyclerView2.l;
                        state.e = 1;
                        state.f = adapter.getItemCount();
                        state.h = false;
                        state.i = false;
                        state.j = false;
                        for (int i8 = 0; i8 < bVar2.d * 2; i8 += 2) {
                            c(recyclerView2, bVar2.c[i8], j);
                        }
                    } finally {
                        TraceCompat.endSection();
                    }
                }
            }
            cVar.a = false;
            cVar.b = 0;
            cVar.c = 0;
            cVar.d = null;
            cVar.e = 0;
            i7++;
        }
    }

    public final RecyclerView.ViewHolder c(RecyclerView recyclerView, int i, long j) {
        boolean z;
        int h = recyclerView.e.h();
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            if (i2 >= h) {
                z = false;
                break;
            }
            RecyclerView.ViewHolder D = RecyclerView.D(recyclerView.e.g(i2));
            if (D.b == i && !D.i()) {
                z = true;
                break;
            }
            i2++;
        }
        if (z) {
            return null;
        }
        RecyclerView.Recycler recycler = recyclerView.b;
        try {
            recyclerView.K();
            RecyclerView.ViewHolder h2 = recycler.h(i, false, j);
            if (h2 != null) {
                if (!h2.h() || h2.i()) {
                    recycler.a(h2, false);
                } else {
                    recycler.recycleView(h2.itemView);
                }
            }
            return h2;
        } finally {
            recyclerView.L(z2);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        long j = 0;
        try {
            TraceCompat.beginSection("RV Prefetch");
            if (!this.a.isEmpty()) {
                int size = this.a.size();
                long j2 = 0;
                for (int i = 0; i < size; i++) {
                    RecyclerView recyclerView = this.a.get(i);
                    if (recyclerView.getWindowVisibility() == 0) {
                        j2 = Math.max(recyclerView.getDrawingTime(), j2);
                    }
                }
                if (j2 != 0) {
                    b(TimeUnit.MILLISECONDS.toNanos(j2) + this.c);
                    this.b = 0;
                    TraceCompat.endSection();
                }
            }
        } finally {
            this.b = j;
            TraceCompat.endSection();
        }
    }
}

package l6.c0.b;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
public final class f extends RecyclerView.OnScrollListener {
    public ViewPager2.OnPageChangeCallback a;
    @NonNull
    public final ViewPager2 b;
    @NonNull
    public final RecyclerView c;
    @NonNull
    public final LinearLayoutManager d;
    public int e;
    public int f;
    public a g = new a();
    public int h;
    public int i;
    public boolean j;
    public boolean k;
    public boolean l;
    public boolean m;

    public static final class a {
        public int a;
        public float b;
        public int c;

        public void a() {
            this.a = -1;
            this.b = 0.0f;
            this.c = 0;
        }
    }

    public f(@NonNull ViewPager2 viewPager2) {
        this.b = viewPager2;
        RecyclerView recyclerView = viewPager2.j;
        this.c = recyclerView;
        this.d = (LinearLayoutManager) recyclerView.getLayoutManager();
        d();
    }

    public final void a(int i2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.a;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i2);
        }
    }

    public final void b(int i2) {
        if ((this.e != 3 || this.f != 0) && this.f != i2) {
            this.f = i2;
            ViewPager2.OnPageChangeCallback onPageChangeCallback = this.a;
            if (onPageChangeCallback != null) {
                onPageChangeCallback.onPageScrollStateChanged(i2);
            }
        }
    }

    public boolean c() {
        return this.f == 0;
    }

    public final void d() {
        this.e = 0;
        this.f = 0;
        this.g.a();
        this.h = -1;
        this.i = -1;
        this.j = false;
        this.k = false;
        this.m = false;
        this.l = false;
    }

    public final void e(boolean z) {
        this.m = z;
        this.e = z ? 4 : 1;
        int i2 = this.i;
        if (i2 != -1) {
            this.h = i2;
            this.i = -1;
        } else if (this.h == -1) {
            this.h = this.d.findFirstVisibleItemPosition();
        }
        b(1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0131, code lost:
        if (r4[r2 - 1][1] >= r3) goto L_0x0134;
     */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x014a  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x015e  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0163  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x016b  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x015b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void f() {
        /*
        // Method dump skipped, instructions count: 397
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.c0.b.f.f():void");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback;
        int i3 = this.e;
        boolean z = true;
        if (!(i3 == 1 && this.f == 1) && i2 == 1) {
            e(false);
            return;
        }
        if (!(i3 == 1 || i3 == 4) || i2 != 2) {
            if ((i3 == 1 || i3 == 4) && i2 == 0) {
                f();
                if (!this.k) {
                    int i4 = this.g.a;
                    if (!(i4 == -1 || (onPageChangeCallback = this.a) == null)) {
                        onPageChangeCallback.onPageScrolled(i4, 0.0f, 0);
                    }
                } else {
                    a aVar = this.g;
                    if (aVar.c == 0) {
                        int i5 = this.h;
                        int i6 = aVar.a;
                        if (i5 != i6) {
                            a(i6);
                        }
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    b(0);
                    d();
                }
            }
            if (this.e == 2 && i2 == 0 && this.l) {
                f();
                a aVar2 = this.g;
                if (aVar2.c == 0) {
                    int i7 = this.i;
                    int i8 = aVar2.a;
                    if (i7 != i8) {
                        if (i8 == -1) {
                            i8 = 0;
                        }
                        a(i8);
                    }
                    b(0);
                    d();
                }
            }
        } else if (this.k) {
            b(2);
            this.j = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if ((r6 < 0) == r4.b.b()) goto L_0x0022;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onScrolled(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView r5, int r6, int r7) {
        /*
            r4 = this;
            r5 = 1
            r4.k = r5
            r4.f()
            boolean r0 = r4.j
            r1 = 0
            r2 = -1
            if (r0 == 0) goto L_0x003d
            r4.j = r1
            if (r7 > 0) goto L_0x0022
            if (r7 != 0) goto L_0x0020
            if (r6 >= 0) goto L_0x0016
            r6 = 1
            goto L_0x0017
        L_0x0016:
            r6 = 0
        L_0x0017:
            androidx.viewpager2.widget.ViewPager2 r7 = r4.b
            boolean r7 = r7.b()
            if (r6 != r7) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r6 = 0
            goto L_0x0023
        L_0x0022:
            r6 = 1
        L_0x0023:
            if (r6 == 0) goto L_0x002f
            l6.c0.b.f$a r6 = r4.g
            int r7 = r6.c
            if (r7 == 0) goto L_0x002f
            int r6 = r6.a
            int r6 = r6 + r5
            goto L_0x0033
        L_0x002f:
            l6.c0.b.f$a r6 = r4.g
            int r6 = r6.a
        L_0x0033:
            r4.i = r6
            int r7 = r4.h
            if (r7 == r6) goto L_0x004b
            r4.a(r6)
            goto L_0x004b
        L_0x003d:
            int r6 = r4.e
            if (r6 != 0) goto L_0x004b
            l6.c0.b.f$a r6 = r4.g
            int r6 = r6.a
            if (r6 != r2) goto L_0x0048
            r6 = 0
        L_0x0048:
            r4.a(r6)
        L_0x004b:
            l6.c0.b.f$a r6 = r4.g
            int r7 = r6.a
            if (r7 != r2) goto L_0x0052
            r7 = 0
        L_0x0052:
            float r0 = r6.b
            int r6 = r6.c
            androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback r3 = r4.a
            if (r3 == 0) goto L_0x005d
            r3.onPageScrolled(r7, r0, r6)
        L_0x005d:
            l6.c0.b.f$a r6 = r4.g
            int r7 = r6.a
            int r0 = r4.i
            if (r7 == r0) goto L_0x0067
            if (r0 != r2) goto L_0x0075
        L_0x0067:
            int r6 = r6.c
            if (r6 != 0) goto L_0x0075
            int r6 = r4.f
            if (r6 == r5) goto L_0x0075
            r4.b(r1)
            r4.d()
        L_0x0075:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.c0.b.f.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }
}

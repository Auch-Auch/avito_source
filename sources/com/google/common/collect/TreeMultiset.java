package com.google.common.collect;

import a2.j.d.c.c1;
import a2.j.d.c.d5;
import a2.j.d.c.o;
import a2.j.d.c.q2;
import androidx.appcompat.app.AppCompatDelegateImpl;
import com.avito.android.tariff.tariff_package_info.viewmodel.TariffPackageInfoConverterKt;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(emulated = true)
public final class TreeMultiset<E> extends o<E> implements Serializable {
    public static final /* synthetic */ int h = 0;
    @GwtIncompatible
    private static final long serialVersionUID = 1;
    public final transient e<d<E>> e;
    public final transient c1<E> f;
    public final transient d<E> g;

    public class a implements Iterator<Multiset.Entry<E>> {
        public d<E> a;
        @NullableDecl
        public Multiset.Entry<E> b;

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0048, code lost:
            if (r5.f.b(r0.a) != false) goto L_0x004b;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public a() {
            /*
                r4 = this;
                com.google.common.collect.TreeMultiset.this = r5
                r4.<init>()
                com.google.common.collect.TreeMultiset$e<com.google.common.collect.TreeMultiset$d<E>> r0 = r5.e
                T r0 = r0.a
                com.google.common.collect.TreeMultiset$d r0 = (com.google.common.collect.TreeMultiset.d) r0
                if (r0 != 0) goto L_0x000e
                goto L_0x004a
            L_0x000e:
                a2.j.d.c.c1<E> r1 = r5.f
                boolean r2 = r1.b
                if (r2 == 0) goto L_0x0038
                T r1 = r1.c
                java.util.Comparator r2 = r5.comparator()
                com.google.common.collect.TreeMultiset$d r0 = r0.e(r2, r1)
                if (r0 != 0) goto L_0x0021
                goto L_0x004a
            L_0x0021:
                a2.j.d.c.c1<E> r2 = r5.f
                com.google.common.collect.BoundType r2 = r2.d
                com.google.common.collect.BoundType r3 = com.google.common.collect.BoundType.OPEN
                if (r2 != r3) goto L_0x003c
                java.util.Comparator r2 = r5.comparator()
                E r3 = r0.a
                int r1 = r2.compare(r1, r3)
                if (r1 != 0) goto L_0x003c
                com.google.common.collect.TreeMultiset$d<E> r0 = r0.i
                goto L_0x003c
            L_0x0038:
                com.google.common.collect.TreeMultiset$d<E> r0 = r5.g
                com.google.common.collect.TreeMultiset$d<E> r0 = r0.i
            L_0x003c:
                com.google.common.collect.TreeMultiset$d<E> r1 = r5.g
                if (r0 == r1) goto L_0x004a
                a2.j.d.c.c1<E> r5 = r5.f
                E r1 = r0.a
                boolean r5 = r5.b(r1)
                if (r5 != 0) goto L_0x004b
            L_0x004a:
                r0 = 0
            L_0x004b:
                r4.a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.TreeMultiset.a.<init>(com.google.common.collect.TreeMultiset):void");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            d<E> dVar = this.a;
            if (dVar == null) {
                return false;
            }
            if (!TreeMultiset.this.f.d(dVar.a)) {
                return true;
            }
            this.a = null;
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext()) {
                TreeMultiset treeMultiset = TreeMultiset.this;
                d<E> dVar = this.a;
                int i = TreeMultiset.h;
                Objects.requireNonNull(treeMultiset);
                d5 d5Var = new d5(treeMultiset, dVar);
                this.b = d5Var;
                d<E> dVar2 = this.a.i;
                if (dVar2 == TreeMultiset.this.g) {
                    this.a = null;
                } else {
                    this.a = dVar2;
                }
                return d5Var;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.b != null, "no calls to next() since the last call to remove()");
            TreeMultiset.this.setCount(this.b.getElement(), 0);
            this.b = null;
        }
    }

    public class b implements Iterator<Multiset.Entry<E>> {
        public d<E> a;
        public Multiset.Entry<E> b;

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
            if (r6.f.b(r0.a) != false) goto L_0x004c;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public b() {
            /*
                r5 = this;
                com.google.common.collect.TreeMultiset.this = r6
                r5.<init>()
                com.google.common.collect.TreeMultiset$e<com.google.common.collect.TreeMultiset$d<E>> r0 = r6.e
                T r0 = r0.a
                com.google.common.collect.TreeMultiset$d r0 = (com.google.common.collect.TreeMultiset.d) r0
                r1 = 0
                if (r0 != 0) goto L_0x000f
                goto L_0x004b
            L_0x000f:
                a2.j.d.c.c1<E> r2 = r6.f
                boolean r3 = r2.e
                if (r3 == 0) goto L_0x0039
                T r2 = r2.f
                java.util.Comparator r3 = r6.comparator()
                com.google.common.collect.TreeMultiset$d r0 = r0.h(r3, r2)
                if (r0 != 0) goto L_0x0022
                goto L_0x004b
            L_0x0022:
                a2.j.d.c.c1<E> r3 = r6.f
                com.google.common.collect.BoundType r3 = r3.g
                com.google.common.collect.BoundType r4 = com.google.common.collect.BoundType.OPEN
                if (r3 != r4) goto L_0x003d
                java.util.Comparator r3 = r6.comparator()
                E r4 = r0.a
                int r2 = r3.compare(r2, r4)
                if (r2 != 0) goto L_0x003d
                com.google.common.collect.TreeMultiset$d<E> r0 = r0.h
                goto L_0x003d
            L_0x0039:
                com.google.common.collect.TreeMultiset$d<E> r0 = r6.g
                com.google.common.collect.TreeMultiset$d<E> r0 = r0.h
            L_0x003d:
                com.google.common.collect.TreeMultiset$d<E> r2 = r6.g
                if (r0 == r2) goto L_0x004b
                a2.j.d.c.c1<E> r6 = r6.f
                E r2 = r0.a
                boolean r6 = r6.b(r2)
                if (r6 != 0) goto L_0x004c
            L_0x004b:
                r0 = r1
            L_0x004c:
                r5.a = r0
                r5.b = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.TreeMultiset.b.<init>(com.google.common.collect.TreeMultiset):void");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            d<E> dVar = this.a;
            if (dVar == null) {
                return false;
            }
            if (!TreeMultiset.this.f.e(dVar.a)) {
                return true;
            }
            this.a = null;
            return false;
        }

        @Override // java.util.Iterator
        public Object next() {
            if (hasNext()) {
                TreeMultiset treeMultiset = TreeMultiset.this;
                d<E> dVar = this.a;
                int i = TreeMultiset.h;
                Objects.requireNonNull(treeMultiset);
                d5 d5Var = new d5(treeMultiset, dVar);
                this.b = d5Var;
                d<E> dVar2 = this.a.h;
                if (dVar2 == TreeMultiset.this.g) {
                    this.a = null;
                } else {
                    this.a = dVar2;
                }
                return d5Var;
            }
            throw new NoSuchElementException();
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.checkState(this.b != null, "no calls to next() since the last call to remove()");
            TreeMultiset.this.setCount(this.b.getElement(), 0);
            this.b = null;
        }
    }

    public enum c {
        SIZE {
            @Override // com.google.common.collect.TreeMultiset.c
            public int a(d<?> dVar) {
                return dVar.b;
            }

            @Override // com.google.common.collect.TreeMultiset.c
            public long b(@NullableDecl d<?> dVar) {
                if (dVar == null) {
                    return 0;
                }
                return dVar.d;
            }
        },
        DISTINCT {
            @Override // com.google.common.collect.TreeMultiset.c
            public int a(d<?> dVar) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.c
            public long b(@NullableDecl d<?> dVar) {
                if (dVar == null) {
                    return 0;
                }
                return (long) dVar.c;
            }
        };

        /* access modifiers changed from: public */
        c(d5 d5Var) {
        }

        public abstract int a(d<?> dVar);

        public abstract long b(@NullableDecl d<?> dVar);
    }

    public static final class d<E> {
        @NullableDecl
        public final E a;
        public int b;
        public int c;
        public long d;
        public int e;
        @NullableDecl
        public d<E> f;
        @NullableDecl
        public d<E> g;
        @NullableDecl
        public d<E> h;
        @NullableDecl
        public d<E> i;

        public d(@NullableDecl E e2, int i2) {
            Preconditions.checkArgument(i2 > 0);
            this.a = e2;
            this.b = i2;
            this.d = (long) i2;
            this.c = 1;
            this.e = 1;
            this.f = null;
            this.g = null;
        }

        public static int i(@NullableDecl d<?> dVar) {
            if (dVar == null) {
                return 0;
            }
            return dVar.e;
        }

        public d<E> a(Comparator<? super E> comparator, @NullableDecl E e2, int i2, int[] iArr) {
            int compare = comparator.compare(e2, this.a);
            boolean z = true;
            if (compare < 0) {
                d<E> dVar = this.f;
                if (dVar == null) {
                    iArr[0] = 0;
                    b(e2, i2);
                    return this;
                }
                int i3 = dVar.e;
                d<E> a3 = dVar.a(comparator, e2, i2, iArr);
                this.f = a3;
                if (iArr[0] == 0) {
                    this.c++;
                }
                this.d += (long) i2;
                return a3.e == i3 ? this : j();
            } else if (compare > 0) {
                d<E> dVar2 = this.g;
                if (dVar2 == null) {
                    iArr[0] = 0;
                    c(e2, i2);
                    return this;
                }
                int i4 = dVar2.e;
                d<E> a4 = dVar2.a(comparator, e2, i2, iArr);
                this.g = a4;
                if (iArr[0] == 0) {
                    this.c++;
                }
                this.d += (long) i2;
                return a4.e == i4 ? this : j();
            } else {
                int i5 = this.b;
                iArr[0] = i5;
                long j = (long) i2;
                if (((long) i5) + j > 2147483647L) {
                    z = false;
                }
                Preconditions.checkArgument(z);
                this.b += i2;
                this.d += j;
                return this;
            }
        }

        public final d<E> b(E e2, int i2) {
            d<E> dVar = new d<>(e2, i2);
            this.f = dVar;
            d<E> dVar2 = this.h;
            int i3 = TreeMultiset.h;
            dVar2.i = dVar;
            dVar.h = dVar2;
            dVar.i = this;
            this.h = dVar;
            this.e = Math.max(2, this.e);
            this.c++;
            this.d += (long) i2;
            return this;
        }

        public final d<E> c(E e2, int i2) {
            d<E> dVar = new d<>(e2, i2);
            this.g = dVar;
            d<E> dVar2 = this.i;
            int i3 = TreeMultiset.h;
            this.i = dVar;
            dVar.h = this;
            dVar.i = dVar2;
            dVar2.h = dVar;
            this.e = Math.max(2, this.e);
            this.c++;
            this.d += (long) i2;
            return this;
        }

        public final int d() {
            return i(this.f) - i(this.g);
        }

        @NullableDecl
        public final d<E> e(Comparator<? super E> comparator, E e2) {
            int compare = comparator.compare(e2, this.a);
            if (compare < 0) {
                d<E> dVar = this.f;
                return dVar == null ? this : (d) MoreObjects.firstNonNull(dVar.e(comparator, e2), this);
            } else if (compare == 0) {
                return this;
            } else {
                d<E> dVar2 = this.g;
                if (dVar2 == null) {
                    return null;
                }
                return dVar2.e(comparator, e2);
            }
        }

        public int f(Comparator<? super E> comparator, E e2) {
            int compare = comparator.compare(e2, this.a);
            if (compare < 0) {
                d<E> dVar = this.f;
                if (dVar == null) {
                    return 0;
                }
                return dVar.f(comparator, e2);
            } else if (compare <= 0) {
                return this.b;
            } else {
                d<E> dVar2 = this.g;
                if (dVar2 == null) {
                    return 0;
                }
                return dVar2.f(comparator, e2);
            }
        }

        public final d<E> g() {
            int i2 = this.b;
            this.b = 0;
            d<E> dVar = this.h;
            d<E> dVar2 = this.i;
            int i3 = TreeMultiset.h;
            dVar.i = dVar2;
            dVar2.h = dVar;
            d<E> dVar3 = this.f;
            if (dVar3 == null) {
                return this.g;
            }
            d<E> dVar4 = this.g;
            if (dVar4 == null) {
                return dVar3;
            }
            if (dVar3.e >= dVar4.e) {
                d<E> dVar5 = this.h;
                dVar5.f = dVar3.n(dVar5);
                dVar5.g = this.g;
                dVar5.c = this.c - 1;
                dVar5.d = this.d - ((long) i2);
                return dVar5.j();
            }
            d<E> dVar6 = this.i;
            dVar6.g = dVar4.o(dVar6);
            dVar6.f = this.f;
            dVar6.c = this.c - 1;
            dVar6.d = this.d - ((long) i2);
            return dVar6.j();
        }

        @NullableDecl
        public final d<E> h(Comparator<? super E> comparator, E e2) {
            int compare = comparator.compare(e2, this.a);
            if (compare > 0) {
                d<E> dVar = this.g;
                return dVar == null ? this : (d) MoreObjects.firstNonNull(dVar.h(comparator, e2), this);
            } else if (compare == 0) {
                return this;
            } else {
                d<E> dVar2 = this.f;
                if (dVar2 == null) {
                    return null;
                }
                return dVar2.h(comparator, e2);
            }
        }

        public final d<E> j() {
            int d2 = d();
            if (d2 == -2) {
                if (this.g.d() > 0) {
                    this.g = this.g.q();
                }
                return p();
            } else if (d2 != 2) {
                l();
                return this;
            } else {
                if (this.f.d() < 0) {
                    this.f = this.f.p();
                }
                return q();
            }
        }

        public final void k() {
            int i2;
            long j;
            d<E> dVar = this.f;
            int i3 = TreeMultiset.h;
            int i4 = 0;
            if (dVar == null) {
                i2 = 0;
            } else {
                i2 = dVar.c;
            }
            int i5 = i2 + 1;
            d<E> dVar2 = this.g;
            if (dVar2 != null) {
                i4 = dVar2.c;
            }
            this.c = i5 + i4;
            long j2 = (long) this.b;
            long j3 = 0;
            if (dVar == null) {
                j = 0;
            } else {
                j = dVar.d;
            }
            long j4 = j2 + j;
            if (dVar2 != null) {
                j3 = dVar2.d;
            }
            this.d = j4 + j3;
            l();
        }

        public final void l() {
            this.e = Math.max(i(this.f), i(this.g)) + 1;
        }

        public d<E> m(Comparator<? super E> comparator, @NullableDecl E e2, int i2, int[] iArr) {
            int compare = comparator.compare(e2, this.a);
            if (compare < 0) {
                d<E> dVar = this.f;
                if (dVar == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f = dVar.m(comparator, e2, i2, iArr);
                if (iArr[0] > 0) {
                    if (i2 >= iArr[0]) {
                        this.c--;
                        this.d -= (long) iArr[0];
                    } else {
                        this.d -= (long) i2;
                    }
                }
                return iArr[0] == 0 ? this : j();
            } else if (compare > 0) {
                d<E> dVar2 = this.g;
                if (dVar2 == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.g = dVar2.m(comparator, e2, i2, iArr);
                if (iArr[0] > 0) {
                    if (i2 >= iArr[0]) {
                        this.c--;
                        this.d -= (long) iArr[0];
                    } else {
                        this.d -= (long) i2;
                    }
                }
                return j();
            } else {
                int i3 = this.b;
                iArr[0] = i3;
                if (i2 >= i3) {
                    return g();
                }
                this.b = i3 - i2;
                this.d -= (long) i2;
                return this;
            }
        }

        public final d<E> n(d<E> dVar) {
            d<E> dVar2 = this.g;
            if (dVar2 == null) {
                return this.f;
            }
            this.g = dVar2.n(dVar);
            this.c--;
            this.d -= (long) dVar.b;
            return j();
        }

        public final d<E> o(d<E> dVar) {
            d<E> dVar2 = this.f;
            if (dVar2 == null) {
                return this.g;
            }
            this.f = dVar2.o(dVar);
            this.c--;
            this.d -= (long) dVar.b;
            return j();
        }

        public final d<E> p() {
            Preconditions.checkState(this.g != null);
            d<E> dVar = this.g;
            this.g = dVar.f;
            dVar.f = this;
            dVar.d = this.d;
            dVar.c = this.c;
            k();
            dVar.l();
            return dVar;
        }

        public final d<E> q() {
            Preconditions.checkState(this.f != null);
            d<E> dVar = this.f;
            this.f = dVar.g;
            dVar.g = this;
            dVar.d = this.d;
            dVar.c = this.c;
            k();
            dVar.l();
            return dVar;
        }

        public d<E> r(Comparator<? super E> comparator, @NullableDecl E e2, int i2, int i3, int[] iArr) {
            int compare = comparator.compare(e2, this.a);
            if (compare < 0) {
                d<E> dVar = this.f;
                if (dVar == null) {
                    iArr[0] = 0;
                    if (i2 == 0 && i3 > 0) {
                        b(e2, i3);
                    }
                    return this;
                }
                this.f = dVar.r(comparator, e2, i2, i3, iArr);
                if (iArr[0] == i2) {
                    if (i3 == 0 && iArr[0] != 0) {
                        this.c--;
                    } else if (i3 > 0 && iArr[0] == 0) {
                        this.c++;
                    }
                    this.d += (long) (i3 - iArr[0]);
                }
                return j();
            } else if (compare > 0) {
                d<E> dVar2 = this.g;
                if (dVar2 == null) {
                    iArr[0] = 0;
                    if (i2 == 0 && i3 > 0) {
                        c(e2, i3);
                    }
                    return this;
                }
                this.g = dVar2.r(comparator, e2, i2, i3, iArr);
                if (iArr[0] == i2) {
                    if (i3 == 0 && iArr[0] != 0) {
                        this.c--;
                    } else if (i3 > 0 && iArr[0] == 0) {
                        this.c++;
                    }
                    this.d += (long) (i3 - iArr[0]);
                }
                return j();
            } else {
                int i4 = this.b;
                iArr[0] = i4;
                if (i2 == i4) {
                    if (i3 == 0) {
                        return g();
                    }
                    this.d += (long) (i3 - i4);
                    this.b = i3;
                }
                return this;
            }
        }

        public d<E> s(Comparator<? super E> comparator, @NullableDecl E e2, int i2, int[] iArr) {
            int compare = comparator.compare(e2, this.a);
            if (compare < 0) {
                d<E> dVar = this.f;
                if (dVar == null) {
                    iArr[0] = 0;
                    if (i2 > 0) {
                        b(e2, i2);
                    }
                    return this;
                }
                this.f = dVar.s(comparator, e2, i2, iArr);
                if (i2 == 0 && iArr[0] != 0) {
                    this.c--;
                } else if (i2 > 0 && iArr[0] == 0) {
                    this.c++;
                }
                this.d += (long) (i2 - iArr[0]);
                return j();
            } else if (compare > 0) {
                d<E> dVar2 = this.g;
                if (dVar2 == null) {
                    iArr[0] = 0;
                    if (i2 > 0) {
                        c(e2, i2);
                    }
                    return this;
                }
                this.g = dVar2.s(comparator, e2, i2, iArr);
                if (i2 == 0 && iArr[0] != 0) {
                    this.c--;
                } else if (i2 > 0 && iArr[0] == 0) {
                    this.c++;
                }
                this.d += (long) (i2 - iArr[0]);
                return j();
            } else {
                int i3 = this.b;
                iArr[0] = i3;
                if (i2 == 0) {
                    return g();
                }
                this.d += (long) (i2 - i3);
                this.b = i2;
                return this;
            }
        }

        public String toString() {
            return Multisets.immutableEntry(this.a, this.b).toString();
        }
    }

    public static final class e<T> {
        @NullableDecl
        public T a;

        public e(d5 d5Var) {
        }

        public void a(@NullableDecl T t, T t2) {
            if (this.a == t) {
                this.a = t2;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    public TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.f = c1.a(comparator);
        d<E> dVar = new d<>(null, 1);
        this.g = dVar;
        dVar.i = dVar;
        dVar.h = dVar;
        this.e = new e<>(null);
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        AppCompatDelegateImpl.i.D0(o.class, "comparator").a(this, comparator);
        AppCompatDelegateImpl.i.D0(TreeMultiset.class, "range").a(this, c1.a(comparator));
        AppCompatDelegateImpl.i.D0(TreeMultiset.class, "rootReference").a(this, new e(null));
        d<E> dVar = new d<>(null, 1);
        AppCompatDelegateImpl.i.D0(TreeMultiset.class, TariffPackageInfoConverterKt.HEADER_STRING_ID).a(this, dVar);
        dVar.i = dVar;
        dVar.h = dVar;
        AppCompatDelegateImpl.i.B1(this, objectInputStream);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(mo6elementSet().comparator());
        AppCompatDelegateImpl.i.v2(this, objectOutputStream);
    }

    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int add(@NullableDecl E e2, int i) {
        AppCompatDelegateImpl.i.z(i, "occurrences");
        if (i == 0) {
            return count(e2);
        }
        Preconditions.checkArgument(this.f.b(e2));
        T t = this.e.a;
        if (t == null) {
            comparator().compare(e2, e2);
            d<E> dVar = new d<>(e2, i);
            d<E> dVar2 = this.g;
            dVar2.i = dVar;
            dVar.h = dVar2;
            dVar.i = dVar2;
            dVar2.h = dVar;
            this.e.a(t, dVar);
            return 0;
        }
        int[] iArr = new int[1];
        T t2 = (T) t.a(comparator(), e2, i, iArr);
        e<d<E>> eVar = this.e;
        if (eVar.a == t) {
            eVar.a = t2;
            return iArr[0];
        }
        throw new ConcurrentModificationException();
    }

    @Override // a2.j.d.c.i
    public int b() {
        return Ints.saturatedCast(i(c.DISTINCT));
    }

    @Override // a2.j.d.c.i
    public Iterator<E> c() {
        return new q2(new a());
    }

    @Override // a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        c1<E> c1Var = this.f;
        if (c1Var.b || c1Var.e) {
            Iterators.b(new a());
            return;
        }
        d<E> dVar = this.g.i;
        while (true) {
            d<E> dVar2 = this.g;
            if (dVar != dVar2) {
                d<E> dVar3 = dVar.i;
                dVar.b = 0;
                dVar.f = null;
                dVar.g = null;
                dVar.h = null;
                dVar.i = null;
                dVar = dVar3;
            } else {
                dVar2.i = dVar2;
                dVar2.h = dVar2;
                this.e.a = null;
                return;
            }
        }
    }

    @Override // a2.j.d.c.o, com.google.common.collect.SortedMultiset, a2.j.d.c.q3
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(@NullableDecl Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.Multiset
    public int count(@NullableDecl Object obj) {
        try {
            T t = this.e.a;
            if (this.f.b(obj)) {
                if (t != null) {
                    return t.f(comparator(), obj);
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // a2.j.d.c.i
    public Iterator<Multiset.Entry<E>> d() {
        return new a();
    }

    @Override // a2.j.d.c.o, com.google.common.collect.SortedMultiset
    /* renamed from: descendingMultiset */
    public /* bridge */ /* synthetic */ SortedMultiset mo11descendingMultiset() {
        return super.mo11descendingMultiset();
    }

    @Override // a2.j.d.c.o
    public Iterator<Multiset.Entry<E>> e() {
        return new b();
    }

    @Override // a2.j.d.c.o, a2.j.d.c.i, com.google.common.collect.Multiset
    /* renamed from: elementSet */
    public /* bridge */ /* synthetic */ NavigableSet mo6elementSet() {
        return super.mo6elementSet();
    }

    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public final long f(c cVar, @NullableDecl d<E> dVar) {
        long j;
        long j2;
        if (dVar == null) {
            return 0;
        }
        int compare = comparator().compare(this.f.f, dVar.a);
        if (compare > 0) {
            return f(cVar, dVar.g);
        }
        if (compare == 0) {
            int ordinal = this.f.g.ordinal();
            if (ordinal == 0) {
                j2 = (long) cVar.a(dVar);
                j = cVar.b(dVar.g);
            } else if (ordinal == 1) {
                return cVar.b(dVar.g);
            } else {
                throw new AssertionError();
            }
        } else {
            j2 = cVar.b(dVar.g) + ((long) cVar.a(dVar));
            j = f(cVar, dVar.f);
        }
        return j + j2;
    }

    @Override // a2.j.d.c.o, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    public final long h(c cVar, @NullableDecl d<E> dVar) {
        long j;
        long j2;
        if (dVar == null) {
            return 0;
        }
        int compare = comparator().compare(this.f.c, dVar.a);
        if (compare < 0) {
            return h(cVar, dVar.f);
        }
        if (compare == 0) {
            int ordinal = this.f.d.ordinal();
            if (ordinal == 0) {
                j2 = (long) cVar.a(dVar);
                j = cVar.b(dVar.f);
            } else if (ordinal == 1) {
                return cVar.b(dVar.f);
            } else {
                throw new AssertionError();
            }
        } else {
            j2 = cVar.b(dVar.f) + ((long) cVar.a(dVar));
            j = h(cVar, dVar.g);
        }
        return j + j2;
    }

    @Override // com.google.common.collect.SortedMultiset
    /* renamed from: headMultiset */
    public SortedMultiset<E> mo12headMultiset(@NullableDecl E e2, BoundType boundType) {
        return new TreeMultiset(this.e, this.f.c(new c1<>(comparator(), false, null, BoundType.OPEN, true, e2, boundType)), this.g);
    }

    public final long i(c cVar) {
        T t = this.e.a;
        long b2 = cVar.b(t);
        if (this.f.b) {
            b2 -= h(cVar, t);
        }
        return this.f.e ? b2 - f(cVar, t) : b2;
    }

    @Override // a2.j.d.c.i, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator<E> iterator() {
        return new Multisets.k(this, entrySet().iterator());
    }

    @Override // a2.j.d.c.o, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    @Override // a2.j.d.c.o, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // a2.j.d.c.o, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int remove(@NullableDecl Object obj, int i) {
        AppCompatDelegateImpl.i.z(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        T t = this.e.a;
        int[] iArr = new int[1];
        try {
            if (this.f.b(obj)) {
                if (t != null) {
                    T t2 = (T) t.m(comparator(), obj, i, iArr);
                    e<d<E>> eVar = this.e;
                    if (eVar.a == t) {
                        eVar.a = t2;
                        return iArr[0];
                    }
                    throw new ConcurrentModificationException();
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public int setCount(@NullableDecl E e2, int i) {
        AppCompatDelegateImpl.i.z(i, "count");
        boolean z = true;
        if (!this.f.b(e2)) {
            if (i != 0) {
                z = false;
            }
            Preconditions.checkArgument(z);
            return 0;
        }
        T t = this.e.a;
        if (t == null) {
            if (i > 0) {
                add(e2, i);
            }
            return 0;
        }
        int[] iArr = new int[1];
        T t2 = (T) t.s(comparator(), e2, i, iArr);
        e<d<E>> eVar = this.e;
        if (eVar.a == t) {
            eVar.a = t2;
            return iArr[0];
        }
        throw new ConcurrentModificationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.saturatedCast(i(c.SIZE));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // a2.j.d.c.o, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(@NullableDecl Object obj, BoundType boundType, @NullableDecl Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.SortedMultiset
    /* renamed from: tailMultiset */
    public SortedMultiset<E> mo13tailMultiset(@NullableDecl E e2, BoundType boundType) {
        return new TreeMultiset(this.e, this.f.c(new c1<>(comparator(), true, e2, boundType, false, null, BoundType.OPEN)), this.g);
    }

    public static <E> TreeMultiset<E> create(@NullableDecl Comparator<? super E> comparator) {
        return comparator == null ? new TreeMultiset<>(Ordering.natural()) : new TreeMultiset<>(comparator);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable<? extends E> iterable) {
        TreeMultiset<E> create = create();
        Iterables.addAll(create, iterable);
        return create;
    }

    public TreeMultiset(e<d<E>> eVar, c1<E> c1Var, d<E> dVar) {
        super(c1Var.a);
        this.e = eVar;
        this.f = c1Var;
        this.g = dVar;
    }

    @Override // a2.j.d.c.i, com.google.common.collect.Multiset
    @CanIgnoreReturnValue
    public boolean setCount(@NullableDecl E e2, int i, int i2) {
        AppCompatDelegateImpl.i.z(i2, "newCount");
        AppCompatDelegateImpl.i.z(i, "oldCount");
        Preconditions.checkArgument(this.f.b(e2));
        T t = this.e.a;
        if (t != null) {
            int[] iArr = new int[1];
            T t2 = (T) t.r(comparator(), e2, i, i2, iArr);
            e<d<E>> eVar = this.e;
            if (eVar.a == t) {
                eVar.a = t2;
                if (iArr[0] == i) {
                    return true;
                }
                return false;
            }
            throw new ConcurrentModificationException();
        } else if (i != 0) {
            return false;
        } else {
            if (i2 > 0) {
                add(e2, i2);
            }
            return true;
        }
    }
}

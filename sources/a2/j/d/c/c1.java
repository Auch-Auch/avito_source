package a2.j.d.c;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.BoundType;
import java.io.Serializable;
import java.util.Comparator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtCompatible(serializable = true)
public final class c1<T> implements Serializable {
    public final Comparator<? super T> a;
    public final boolean b;
    @NullableDecl
    public final T c;
    public final BoundType d;
    public final boolean e;
    @NullableDecl
    public final T f;
    public final BoundType g;

    public c1(Comparator<? super T> comparator, boolean z, @NullableDecl T t, BoundType boundType, boolean z2, @NullableDecl T t2, BoundType boundType2) {
        this.a = (Comparator) Preconditions.checkNotNull(comparator);
        this.b = z;
        this.e = z2;
        this.c = t;
        this.d = (BoundType) Preconditions.checkNotNull(boundType);
        this.f = t2;
        this.g = (BoundType) Preconditions.checkNotNull(boundType2);
        if (z) {
            comparator.compare(t, t);
        }
        if (z2) {
            comparator.compare(t2, t2);
        }
        if (z && z2) {
            int compare = comparator.compare(t, t2);
            boolean z3 = true;
            Preconditions.checkArgument(compare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", t, t2);
            if (compare == 0) {
                BoundType boundType3 = BoundType.OPEN;
                Preconditions.checkArgument((boundType != boundType3) | (boundType2 == boundType3 ? false : z3));
            }
        }
    }

    public static <T> c1<T> a(Comparator<? super T> comparator) {
        BoundType boundType = BoundType.OPEN;
        return new c1<>(comparator, false, null, boundType, false, null, boundType);
    }

    public boolean b(@NullableDecl T t) {
        return !e(t) && !d(t);
    }

    public c1<T> c(c1<T> c1Var) {
        BoundType boundType;
        BoundType boundType2;
        T t;
        int compare;
        BoundType boundType3;
        int compare2;
        int compare3;
        Preconditions.checkNotNull(c1Var);
        Preconditions.checkArgument(this.a.equals(c1Var.a));
        boolean z = this.b;
        T t2 = this.c;
        BoundType boundType4 = this.d;
        if (!z) {
            z = c1Var.b;
            t2 = c1Var.c;
            boundType4 = c1Var.d;
        } else if (c1Var.b && ((compare3 = this.a.compare(t2, c1Var.c)) < 0 || (compare3 == 0 && c1Var.d == BoundType.OPEN))) {
            t2 = c1Var.c;
            boundType4 = c1Var.d;
        }
        boolean z2 = this.e;
        T t3 = this.f;
        BoundType boundType5 = this.g;
        if (!z2) {
            z2 = c1Var.e;
            t3 = c1Var.f;
            boundType5 = c1Var.g;
        } else if (c1Var.e && ((compare2 = this.a.compare(t3, c1Var.f)) > 0 || (compare2 == 0 && c1Var.g == BoundType.OPEN))) {
            t3 = c1Var.f;
            boundType5 = c1Var.g;
        }
        if (!z || !z2 || ((compare = this.a.compare(t2, t3)) <= 0 && !(compare == 0 && boundType4 == (boundType3 = BoundType.OPEN) && boundType5 == boundType3))) {
            t = t2;
            boundType2 = boundType4;
            boundType = boundType5;
        } else {
            boundType2 = BoundType.OPEN;
            boundType = BoundType.CLOSED;
            t = t3;
        }
        return new c1<>(this.a, z, t, boundType2, z2, t3, boundType);
    }

    public boolean d(@NullableDecl T t) {
        boolean z = false;
        if (!this.e) {
            return false;
        }
        int compare = this.a.compare(t, this.f);
        boolean z2 = compare > 0;
        boolean z3 = compare == 0;
        if (this.g == BoundType.OPEN) {
            z = true;
        }
        return (z3 & z) | z2;
    }

    public boolean e(@NullableDecl T t) {
        boolean z = false;
        if (!this.b) {
            return false;
        }
        int compare = this.a.compare(t, this.c);
        boolean z2 = compare < 0;
        boolean z3 = compare == 0;
        if (this.d == BoundType.OPEN) {
            z = true;
        }
        return (z3 & z) | z2;
    }

    @Override // java.lang.Object
    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof c1)) {
            return false;
        }
        c1 c1Var = (c1) obj;
        if (!this.a.equals(c1Var.a) || this.b != c1Var.b || this.e != c1Var.e || !this.d.equals(c1Var.d) || !this.g.equals(c1Var.g) || !Objects.equal(this.c, c1Var.c) || !Objects.equal(this.f, c1Var.f)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return Objects.hashCode(this.a, this.c, this.d, this.f, this.g);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append(":");
        BoundType boundType = this.d;
        BoundType boundType2 = BoundType.CLOSED;
        sb.append(boundType == boundType2 ? '[' : '(');
        sb.append(this.b ? this.c : "-∞");
        sb.append(',');
        sb.append(this.e ? this.f : "∞");
        sb.append(this.g == boundType2 ? ']' : ')');
        return sb.toString();
    }
}

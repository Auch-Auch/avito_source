package arrow.core;

import a2.b.a.a.a;
import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import arrow.higherkind;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@higherkind
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\b\b\u0018\u0000 1*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u0001*\u0006\b\u0003\u0010\u0004 \u0001*\u0006\b\u0004\u0010\u0005 \u0001*\u0006\b\u0005\u0010\u0006 \u00012ò\u0001\u0012¿\u0001\u0012¼\u0001\u0012\u0001\u0012\u0001\u0012Z\u0012X\u00122\u00120\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0004\u0012\u00028\u00010\u0007j\u0014\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b`\t\u0012\u0004\u0012\u00028\u00020\u0007j\u001a\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f`\n\u0012\u0004\u0012\u00028\u00030\u0007j \u0012\u0004\u0012\u00028\r\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011`\u000b\u0012\u0004\u0012\u00028\u00040\u0007j&\u0012\u0004\u0012\u00028\u0012\u0012\u0004\u0012\u00028\u0013\u0012\u0004\u0012\u00028\u0014\u0012\u0004\u0012\u00028\u0015\u0012\u0004\u0012\u00028\u0016\u0012\u0004\u0012\u00028\u0017`\f\u0012\u0004\u0012\u00028\u00050\u0007j&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005`\r:\u00011B7\u0012\u0006\u0010\u0015\u001a\u00028\u0000\u0012\u0006\u0010\u0016\u001a\u00028\u0001\u0012\u0006\u0010\u0017\u001a\u00028\u0002\u0012\u0006\u0010\u0018\u001a\u00028\u0003\u0012\u0006\u0010\u0019\u001a\u00028\u0004\u0012\u0006\u0010\u001a\u001a\u00028\u0005¢\u0006\u0004\b/\u00100J\u0010\u0010\u000e\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000fJ\u0010\u0010\u0011\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u000fJ\u0010\u0010\u0012\u001a\u00028\u0003HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000fJ\u0010\u0010\u0013\u001a\u00028\u0004HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u000fJ\u0010\u0010\u0014\u001a\u00028\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u000fJp\u0010\u001b\u001a&\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u00050\u00002\b\b\u0002\u0010\u0015\u001a\u00028\u00002\b\b\u0002\u0010\u0016\u001a\u00028\u00012\b\b\u0002\u0010\u0017\u001a\u00028\u00022\b\b\u0002\u0010\u0018\u001a\u00028\u00032\b\b\u0002\u0010\u0019\u001a\u00028\u00042\b\b\u0002\u0010\u001a\u001a\u00028\u0005HÆ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001e\u001a\u00020\u001dHÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010!\u001a\u00020 HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010#HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0019\u0010\u0019\u001a\u00028\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010(\u001a\u0004\b)\u0010\u000fR\u0019\u0010\u0016\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b*\u0010\u000fR\u0019\u0010\u0018\u001a\u00028\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010(\u001a\u0004\b+\u0010\u000fR\u0019\u0010\u0017\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b,\u0010\u000fR\u0019\u0010\u001a\u001a\u00028\u00058\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010(\u001a\u0004\b-\u0010\u000fR\u0019\u0010\u0015\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b.\u0010\u000f¨\u00062"}, d2 = {"Larrow/core/Tuple6;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "Larrow/Kind;", "Larrow/core/ForTuple6;", "Larrow/Kind2;", "Larrow/Kind3;", "Larrow/Kind4;", "Larrow/Kind5;", "Larrow/core/Tuple6Of;", "component1", "()Ljava/lang/Object;", "component2", "component3", "component4", "component5", "component6", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "c", "d", "e", "f", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Larrow/core/Tuple6;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getE", "getB", "getD", "getC", "getF", "getA", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "Companion", "arrow-core"}, k = 1, mv = {1, 4, 0})
public final class Tuple6<A, B, C, D, E, F> implements Kind<Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends ForTuple6, ? extends A>, ? extends B>, ? extends C>, ? extends D>, ? extends E>, F> {
    public static final Companion Companion = new Companion(null);
    public final A a;
    public final B b;
    public final C c;
    public final D d;
    public final E e;
    public final F f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Larrow/core/Tuple6$Companion;", "", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public Tuple6(A a3, B b2, C c2, D d2, E e2, F f2) {
        this.a = a3;
        this.b = b2;
        this.c = c2;
        this.d = d2;
        this.e = e2;
        this.f = f2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: arrow.core.Tuple6 */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static /* bridge */ /* synthetic */ Tuple6 copy$default(Tuple6 tuple6, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, int i, Object obj7) {
        if ((i & 1) != 0) {
            obj = tuple6.a;
        }
        if ((i & 2) != 0) {
            obj2 = tuple6.b;
        }
        if ((i & 4) != 0) {
            obj3 = tuple6.c;
        }
        if ((i & 8) != 0) {
            obj4 = tuple6.d;
        }
        if ((i & 16) != 0) {
            obj5 = tuple6.e;
        }
        if ((i & 32) != 0) {
            obj6 = tuple6.f;
        }
        return tuple6.copy(obj, obj2, obj3, obj4, obj5, obj6);
    }

    public final A component1() {
        return this.a;
    }

    public final B component2() {
        return this.b;
    }

    public final C component3() {
        return this.c;
    }

    public final D component4() {
        return this.d;
    }

    public final E component5() {
        return this.e;
    }

    public final F component6() {
        return this.f;
    }

    @NotNull
    public final Tuple6<A, B, C, D, E, F> copy(A a3, B b2, C c2, D d2, E e2, F f2) {
        return new Tuple6<>(a3, b2, c2, d2, e2, f2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tuple6)) {
            return false;
        }
        Tuple6 tuple6 = (Tuple6) obj;
        return Intrinsics.areEqual(this.a, tuple6.a) && Intrinsics.areEqual(this.b, tuple6.b) && Intrinsics.areEqual(this.c, tuple6.c) && Intrinsics.areEqual(this.d, tuple6.d) && Intrinsics.areEqual(this.e, tuple6.e) && Intrinsics.areEqual(this.f, tuple6.f);
    }

    public final A getA() {
        return this.a;
    }

    public final B getB() {
        return this.b;
    }

    public final C getC() {
        return this.c;
    }

    public final D getD() {
        return this.d;
    }

    public final E getE() {
        return this.e;
    }

    public final F getF() {
        return this.f;
    }

    public int hashCode() {
        A a3 = this.a;
        int i = 0;
        int hashCode = (a3 != null ? a3.hashCode() : 0) * 31;
        B b2 = this.b;
        int hashCode2 = (hashCode + (b2 != null ? b2.hashCode() : 0)) * 31;
        C c2 = this.c;
        int hashCode3 = (hashCode2 + (c2 != null ? c2.hashCode() : 0)) * 31;
        D d2 = this.d;
        int hashCode4 = (hashCode3 + (d2 != null ? d2.hashCode() : 0)) * 31;
        E e2 = this.e;
        int hashCode5 = (hashCode4 + (e2 != null ? e2.hashCode() : 0)) * 31;
        F f2 = this.f;
        if (f2 != null) {
            i = f2.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        StringBuilder L = a.L("Tuple6(a=");
        L.append((Object) this.a);
        L.append(", b=");
        L.append((Object) this.b);
        L.append(", c=");
        L.append((Object) this.c);
        L.append(", d=");
        L.append((Object) this.d);
        L.append(", e=");
        L.append((Object) this.e);
        L.append(", f=");
        return a.r(L, this.f, ")");
    }
}

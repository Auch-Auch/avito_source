package arrow.core;

import a2.b.a.a.a;
import a2.g.r.g;
import androidx.exifinterface.media.ExifInterface;
import arrow.Kind;
import arrow.higherkind;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@higherkind
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\b\b\u0018\u0000 J*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u0001*\u0006\b\u0002\u0010\u0003 \u0001*\u0006\b\u0003\u0010\u0004 \u0001*\u0006\b\u0004\u0010\u0005 \u0001*\u0006\b\u0005\u0010\u0006 \u0001*\u0006\b\u0006\u0010\u0007 \u0001*\u0006\b\u0007\u0010\b \u0001*\u0006\b\b\u0010\t \u0001*\u0006\b\t\u0010\n \u0001*\u0006\b\n\u0010\u000b \u00012ø\u0004\u0012§\u0004\u0012¤\u0004\u0012Ó\u0003\u0012Ð\u0003\u0012\u0003\u0012\u0003\u0012½\u0002\u0012º\u0002\u0012û\u0001\u0012ø\u0001\u0012¿\u0001\u0012¼\u0001\u0012\u0001\u0012\u0001\u0012Z\u0012X\u00122\u00120\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00028\u00000\f\u0012\u0004\u0012\u00028\u00010\fj\u0014\u0012\u0004\u0012\u00028\u000b\u0012\u0004\u0012\u00028\f\u0012\u0004\u0012\u00028\r`\u000e\u0012\u0004\u0012\u00028\u00020\fj\u001a\u0012\u0004\u0012\u00028\u000e\u0012\u0004\u0012\u00028\u000f\u0012\u0004\u0012\u00028\u0010\u0012\u0004\u0012\u00028\u0011`\u000f\u0012\u0004\u0012\u00028\u00030\fj \u0012\u0004\u0012\u00028\u0012\u0012\u0004\u0012\u00028\u0013\u0012\u0004\u0012\u00028\u0014\u0012\u0004\u0012\u00028\u0015\u0012\u0004\u0012\u00028\u0016`\u0010\u0012\u0004\u0012\u00028\u00040\fj&\u0012\u0004\u0012\u00028\u0017\u0012\u0004\u0012\u00028\u0018\u0012\u0004\u0012\u00028\u0019\u0012\u0004\u0012\u00028\u001a\u0012\u0004\u0012\u00028\u001b\u0012\u0004\u0012\u00028\u001c`\u0011\u0012\u0004\u0012\u00028\u00050\fj,\u0012\u0004\u0012\u00028\u001d\u0012\u0004\u0012\u00028\u001e\u0012\u0004\u0012\u00028\u001f\u0012\u0004\u0012\u00028 \u0012\u0004\u0012\u00028!\u0012\u0004\u0012\u00028\"\u0012\u0004\u0012\u00028#`\u0012\u0012\u0004\u0012\u00028\u00060\fj2\u0012\u0004\u0012\u00028$\u0012\u0004\u0012\u00028%\u0012\u0004\u0012\u00028&\u0012\u0004\u0012\u00028'\u0012\u0004\u0012\u00028(\u0012\u0004\u0012\u00028)\u0012\u0004\u0012\u00028*\u0012\u0004\u0012\u00028+`\u0013\u0012\u0004\u0012\u00028\u00070\fj8\u0012\u0004\u0012\u00028,\u0012\u0004\u0012\u00028-\u0012\u0004\u0012\u00028.\u0012\u0004\u0012\u00028/\u0012\u0004\u0012\u000280\u0012\u0004\u0012\u000281\u0012\u0004\u0012\u000282\u0012\u0004\u0012\u000283\u0012\u0004\u0012\u000284`\u0014\u0012\u0004\u0012\u00028\b0\fj>\u0012\u0004\u0012\u000285\u0012\u0004\u0012\u000286\u0012\u0004\u0012\u000287\u0012\u0004\u0012\u000288\u0012\u0004\u0012\u000289\u0012\u0004\u0012\u00028:\u0012\u0004\u0012\u00028;\u0012\u0004\u0012\u00028<\u0012\u0004\u0012\u00028=\u0012\u0004\u0012\u00028>`\u0015\u0012\u0004\u0012\u00028\t0\fjD\u0012\u0004\u0012\u00028?\u0012\u0004\u0012\u00028@\u0012\u0004\u0012\u00028A\u0012\u0004\u0012\u00028B\u0012\u0004\u0012\u00028C\u0012\u0004\u0012\u00028D\u0012\u0004\u0012\u00028E\u0012\u0004\u0012\u00028F\u0012\u0004\u0012\u00028G\u0012\u0004\u0012\u00028H\u0012\u0004\u0012\u00028I`\u0016\u0012\u0004\u0012\u00028\n0\fjD\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n`\u0017:\u0001JB_\u0012\u0006\u0010$\u001a\u00028\u0000\u0012\u0006\u0010%\u001a\u00028\u0001\u0012\u0006\u0010&\u001a\u00028\u0002\u0012\u0006\u0010'\u001a\u00028\u0003\u0012\u0006\u0010(\u001a\u00028\u0004\u0012\u0006\u0010)\u001a\u00028\u0005\u0012\u0006\u0010*\u001a\u00028\u0006\u0012\u0006\u0010+\u001a\u00028\u0007\u0012\u0006\u0010,\u001a\u00028\b\u0012\u0006\u0010-\u001a\u00028\t\u0012\u0006\u0010.\u001a\u00028\n¢\u0006\u0004\bH\u0010IJ\u0010\u0010\u0018\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0019J\u0010\u0010\u001b\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0019J\u0010\u0010\u001c\u001a\u00028\u0003HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u0019J\u0010\u0010\u001d\u001a\u00028\u0004HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u0019J\u0010\u0010\u001e\u001a\u00028\u0005HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u0019J\u0010\u0010\u001f\u001a\u00028\u0006HÆ\u0003¢\u0006\u0004\b\u001f\u0010\u0019J\u0010\u0010 \u001a\u00028\u0007HÆ\u0003¢\u0006\u0004\b \u0010\u0019J\u0010\u0010!\u001a\u00028\bHÆ\u0003¢\u0006\u0004\b!\u0010\u0019J\u0010\u0010\"\u001a\u00028\tHÆ\u0003¢\u0006\u0004\b\"\u0010\u0019J\u0010\u0010#\u001a\u00028\nHÆ\u0003¢\u0006\u0004\b#\u0010\u0019JÀ\u0001\u0010/\u001aD\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u0004\u0012\u0004\u0012\u00028\u0005\u0012\u0004\u0012\u00028\u0006\u0012\u0004\u0012\u00028\u0007\u0012\u0004\u0012\u00028\b\u0012\u0004\u0012\u00028\t\u0012\u0004\u0012\u00028\n0\u00002\b\b\u0002\u0010$\u001a\u00028\u00002\b\b\u0002\u0010%\u001a\u00028\u00012\b\b\u0002\u0010&\u001a\u00028\u00022\b\b\u0002\u0010'\u001a\u00028\u00032\b\b\u0002\u0010(\u001a\u00028\u00042\b\b\u0002\u0010)\u001a\u00028\u00052\b\b\u0002\u0010*\u001a\u00028\u00062\b\b\u0002\u0010+\u001a\u00028\u00072\b\b\u0002\u0010,\u001a\u00028\b2\b\b\u0002\u0010-\u001a\u00028\t2\b\b\u0002\u0010.\u001a\u00028\nHÆ\u0001¢\u0006\u0004\b/\u00100J\u0010\u00102\u001a\u000201HÖ\u0001¢\u0006\u0004\b2\u00103J\u0010\u00105\u001a\u000204HÖ\u0001¢\u0006\u0004\b5\u00106J\u001a\u0010:\u001a\u0002092\b\u00108\u001a\u0004\u0018\u000107HÖ\u0003¢\u0006\u0004\b:\u0010;R\u0019\u0010*\u001a\u00028\u00068\u0006@\u0006¢\u0006\f\n\u0004\b*\u0010<\u001a\u0004\b=\u0010\u0019R\u0019\u0010.\u001a\u00028\n8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010<\u001a\u0004\b>\u0010\u0019R\u0019\u0010%\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010<\u001a\u0004\b?\u0010\u0019R\u0019\u0010(\u001a\u00028\u00048\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010<\u001a\u0004\b@\u0010\u0019R\u0019\u0010&\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010<\u001a\u0004\bA\u0010\u0019R\u0019\u0010,\u001a\u00028\b8\u0006@\u0006¢\u0006\f\n\u0004\b,\u0010<\u001a\u0004\bB\u0010\u0019R\u0019\u0010'\u001a\u00028\u00038\u0006@\u0006¢\u0006\f\n\u0004\b'\u0010<\u001a\u0004\bC\u0010\u0019R\u0019\u0010)\u001a\u00028\u00058\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010<\u001a\u0004\bD\u0010\u0019R\u0019\u0010-\u001a\u00028\t8\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010<\u001a\u0004\bE\u0010\u0019R\u0019\u0010$\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010<\u001a\u0004\bF\u0010\u0019R\u0019\u0010+\u001a\u00028\u00078\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010<\u001a\u0004\bG\u0010\u0019¨\u0006K"}, d2 = {"Larrow/core/Tuple11;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", "G", "H", "I", "J", "K", "Larrow/Kind;", "Larrow/core/ForTuple11;", "Larrow/Kind2;", "Larrow/Kind3;", "Larrow/Kind4;", "Larrow/Kind5;", "Larrow/Kind6;", "Larrow/Kind7;", "Larrow/Kind8;", "Larrow/Kind9;", "Larrow/Kind10;", "Larrow/core/Tuple11Of;", "component1", "()Ljava/lang/Object;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "c", "d", "e", "f", g.a, "h", "i", "j", "k", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Larrow/core/Tuple11;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Object;", "getG", "getK", "getB", "getE", "getC", "getI", "getD", "getF", "getJ", "getA", "getH", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V", "Companion", "arrow-core"}, k = 1, mv = {1, 4, 0})
public final class Tuple11<A, B, C, D, E, F, G, H, I, J, K> implements Kind<Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends Kind<? extends ForTuple11, ? extends A>, ? extends B>, ? extends C>, ? extends D>, ? extends E>, ? extends F>, ? extends G>, ? extends H>, ? extends I>, ? extends J>, K> {
    public static final Companion Companion = new Companion(null);
    public final A a;
    public final B b;
    public final C c;
    public final D d;
    public final E e;
    public final F f;
    public final G g;
    public final H h;
    public final I i;
    public final J j;
    public final K k;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Larrow/core/Tuple11$Companion;", "", "<init>", "()V", "arrow-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public Tuple11(A a3, B b2, C c2, D d2, E e2, F f2, G g2, H h2, I i2, J j2, K k2) {
        this.a = a3;
        this.b = b2;
        this.c = c2;
        this.d = d2;
        this.e = e2;
        this.f = f2;
        this.g = g2;
        this.h = h2;
        this.i = i2;
        this.j = j2;
        this.k = k2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r13v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r15v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r16v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r17v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r18v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r19v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r20v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r21v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r22v0, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r23v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @NotNull
    public static /* bridge */ /* synthetic */ Tuple11 copy$default(Tuple11 tuple11, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10, Object obj11, int i2, Object obj12) {
        return tuple11.copy((i2 & 1) != 0 ? tuple11.a : obj, (i2 & 2) != 0 ? tuple11.b : obj2, (i2 & 4) != 0 ? tuple11.c : obj3, (i2 & 8) != 0 ? tuple11.d : obj4, (i2 & 16) != 0 ? tuple11.e : obj5, (i2 & 32) != 0 ? tuple11.f : obj6, (i2 & 64) != 0 ? tuple11.g : obj7, (i2 & 128) != 0 ? tuple11.h : obj8, (i2 & 256) != 0 ? tuple11.i : obj9, (i2 & 512) != 0 ? tuple11.j : obj10, (i2 & 1024) != 0 ? tuple11.k : obj11);
    }

    public final A component1() {
        return this.a;
    }

    public final J component10() {
        return this.j;
    }

    public final K component11() {
        return this.k;
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

    public final G component7() {
        return this.g;
    }

    public final H component8() {
        return this.h;
    }

    public final I component9() {
        return this.i;
    }

    @NotNull
    public final Tuple11<A, B, C, D, E, F, G, H, I, J, K> copy(A a3, B b2, C c2, D d2, E e2, F f2, G g2, H h2, I i2, J j2, K k2) {
        return new Tuple11<>(a3, b2, c2, d2, e2, f2, g2, h2, i2, j2, k2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Tuple11)) {
            return false;
        }
        Tuple11 tuple11 = (Tuple11) obj;
        return Intrinsics.areEqual(this.a, tuple11.a) && Intrinsics.areEqual(this.b, tuple11.b) && Intrinsics.areEqual(this.c, tuple11.c) && Intrinsics.areEqual(this.d, tuple11.d) && Intrinsics.areEqual(this.e, tuple11.e) && Intrinsics.areEqual(this.f, tuple11.f) && Intrinsics.areEqual(this.g, tuple11.g) && Intrinsics.areEqual(this.h, tuple11.h) && Intrinsics.areEqual(this.i, tuple11.i) && Intrinsics.areEqual(this.j, tuple11.j) && Intrinsics.areEqual(this.k, tuple11.k);
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

    public final G getG() {
        return this.g;
    }

    public final H getH() {
        return this.h;
    }

    public final I getI() {
        return this.i;
    }

    public final J getJ() {
        return this.j;
    }

    public final K getK() {
        return this.k;
    }

    public int hashCode() {
        A a3 = this.a;
        int i2 = 0;
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
        int hashCode6 = (hashCode5 + (f2 != null ? f2.hashCode() : 0)) * 31;
        G g2 = this.g;
        int hashCode7 = (hashCode6 + (g2 != null ? g2.hashCode() : 0)) * 31;
        H h2 = this.h;
        int hashCode8 = (hashCode7 + (h2 != null ? h2.hashCode() : 0)) * 31;
        I i3 = this.i;
        int hashCode9 = (hashCode8 + (i3 != null ? i3.hashCode() : 0)) * 31;
        J j2 = this.j;
        int hashCode10 = (hashCode9 + (j2 != null ? j2.hashCode() : 0)) * 31;
        K k2 = this.k;
        if (k2 != null) {
            i2 = k2.hashCode();
        }
        return hashCode10 + i2;
    }

    public String toString() {
        StringBuilder L = a.L("Tuple11(a=");
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
        L.append((Object) this.f);
        L.append(", g=");
        L.append((Object) this.g);
        L.append(", h=");
        L.append((Object) this.h);
        L.append(", i=");
        L.append((Object) this.i);
        L.append(", j=");
        L.append((Object) this.j);
        L.append(", k=");
        return a.r(L, this.k, ")");
    }
}

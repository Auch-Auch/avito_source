package org.kodein.di;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\b\b\u0018\u0000 1*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u00042 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00000\u0005:\u00011BM\u0012\u0006\u0010\u000e\u001a\u00028\u0000\u0012\u0006\u0010\u000f\u001a\u00028\u0001\u0012\u0006\u0010\u0010\u001a\u00028\u0002\u0012\u0006\u0010\u0011\u001a\u00028\u0003\u0012$\u0010\u0012\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00000\u000b¢\u0006\u0004\b/\u00100J\u0010\u0010\u0006\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\b\u0010\u0007J\u0010\u0010\t\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0007J\u0010\u0010\n\u001a\u00028\u0003HÆ\u0003¢\u0006\u0004\b\n\u0010\u0007J.\u0010\f\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00000\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJx\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002\b\b\u0002\u0010\u000e\u001a\u00028\u00002\b\b\u0002\u0010\u000f\u001a\u00028\u00012\b\b\u0002\u0010\u0010\u001a\u00028\u00022\b\b\u0002\u0010\u0011\u001a\u00028\u00032&\b\u0002\u0010\u0012\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00000\u000bHÆ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fR\u0019\u0010\u000e\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0007R:\u0010\u0012\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00000\u000b8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\rR\u0019\u0010\u000f\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b'\u0010\u0007R.\u0010*\u001a\u001a\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)R\u0019\u0010\u0010\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010!\u001a\u0004\b,\u0010\u0007R\u0019\u0010\u0011\u001a\u00028\u00038\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010!\u001a\u0004\b.\u0010\u0007¨\u00062"}, d2 = {"Lorg/kodein/di/Multi4;", "A1", "A2", "A3", "A4", "Lorg/kodein/di/Typed;", "component1", "()Ljava/lang/Object;", "component2", "component3", "component4", "Lorg/kodein/di/TypeToken;", "component5", "()Lorg/kodein/di/TypeToken;", "a1", "a2", "a3", "a4", "type", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lorg/kodein/di/TypeToken;)Lorg/kodein/di/Multi4;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getA1", "e", "Lorg/kodein/di/TypeToken;", "getType", AuthSource.BOOKING_ORDER, "getA2", "getValue", "()Lorg/kodein/di/Multi4;", "value", "c", "getA3", "d", "getA4", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lorg/kodein/di/TypeToken;)V", "Companion", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class Multi4<A1, A2, A3, A4> implements Typed<Multi4<A1, A2, A3, A4>> {
    public static final Companion Companion = new Companion(null);
    public final A1 a;
    public final A2 b;
    public final A3 c;
    public final A4 d;
    @NotNull
    public final TypeToken<Multi4<A1, A2, A3, A4>> e;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lorg/kodein/di/Multi4$Companion;", "", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public Multi4(A1 a1, A2 a22, A3 a3, A4 a4, @NotNull TypeToken<Multi4<A1, A2, A3, A4>> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        this.a = a1;
        this.b = a22;
        this.c = a3;
        this.d = a4;
        this.e = typeToken;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: org.kodein.di.Multi4 */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Multi4 copy$default(Multi4 multi4, Object obj, Object obj2, Object obj3, Object obj4, TypeToken typeToken, int i, Object obj5) {
        if ((i & 1) != 0) {
            obj = multi4.a;
        }
        if ((i & 2) != 0) {
            obj2 = multi4.b;
        }
        if ((i & 4) != 0) {
            obj3 = multi4.c;
        }
        if ((i & 8) != 0) {
            obj4 = multi4.d;
        }
        if ((i & 16) != 0) {
            typeToken = multi4.getType();
        }
        return multi4.copy(obj, obj2, obj3, obj4, typeToken);
    }

    public final A1 component1() {
        return this.a;
    }

    public final A2 component2() {
        return this.b;
    }

    public final A3 component3() {
        return this.c;
    }

    public final A4 component4() {
        return this.d;
    }

    @NotNull
    public final TypeToken<Multi4<A1, A2, A3, A4>> component5() {
        return getType();
    }

    @NotNull
    public final Multi4<A1, A2, A3, A4> copy(A1 a1, A2 a22, A3 a3, A4 a4, @NotNull TypeToken<Multi4<A1, A2, A3, A4>> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return new Multi4<>(a1, a22, a3, a4, typeToken);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Multi4)) {
            return false;
        }
        Multi4 multi4 = (Multi4) obj;
        return Intrinsics.areEqual(this.a, multi4.a) && Intrinsics.areEqual(this.b, multi4.b) && Intrinsics.areEqual(this.c, multi4.c) && Intrinsics.areEqual(this.d, multi4.d) && Intrinsics.areEqual(getType(), multi4.getType());
    }

    public final A1 getA1() {
        return this.a;
    }

    public final A2 getA2() {
        return this.b;
    }

    public final A3 getA3() {
        return this.c;
    }

    public final A4 getA4() {
        return this.d;
    }

    @Override // org.kodein.di.Typed
    @NotNull
    public TypeToken<Multi4<A1, A2, A3, A4>> getType() {
        return this.e;
    }

    @Override // org.kodein.di.Typed
    @NotNull
    public Multi4<A1, A2, A3, A4> getValue() {
        return this;
    }

    public int hashCode() {
        A1 a1 = this.a;
        int i = 0;
        int hashCode = (a1 != null ? a1.hashCode() : 0) * 31;
        A2 a22 = this.b;
        int hashCode2 = (hashCode + (a22 != null ? a22.hashCode() : 0)) * 31;
        A3 a3 = this.c;
        int hashCode3 = (hashCode2 + (a3 != null ? a3.hashCode() : 0)) * 31;
        A4 a4 = this.d;
        int hashCode4 = (hashCode3 + (a4 != null ? a4.hashCode() : 0)) * 31;
        TypeToken<Multi4<A1, A2, A3, A4>> type = getType();
        if (type != null) {
            i = type.hashCode();
        }
        return hashCode4 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Multi4(a1=");
        L.append((Object) this.a);
        L.append(", a2=");
        L.append((Object) this.b);
        L.append(", a3=");
        L.append((Object) this.c);
        L.append(", a4=");
        L.append((Object) this.d);
        L.append(", type=");
        L.append(getType());
        L.append(")");
        return L.toString();
    }
}

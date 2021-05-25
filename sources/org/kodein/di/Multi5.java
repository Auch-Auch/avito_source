package org.kodein.di;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u0000 6*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u0003*\u0004\b\u0003\u0010\u0004*\u0004\b\u0004\u0010\u00052&\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00000\u0006:\u00016B[\u0012\u0006\u0010\u0010\u001a\u00028\u0000\u0012\u0006\u0010\u0011\u001a\u00028\u0001\u0012\u0006\u0010\u0012\u001a\u00028\u0002\u0012\u0006\u0010\u0013\u001a\u00028\u0003\u0012\u0006\u0010\u0014\u001a\u00028\u0004\u0012*\u0010\u0015\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00000\r¢\u0006\u0004\b4\u00105J\u0010\u0010\u0007\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\t\u0010\bJ\u0010\u0010\n\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\bJ\u0010\u0010\u000b\u001a\u00028\u0003HÆ\u0003¢\u0006\u0004\b\u000b\u0010\bJ\u0010\u0010\f\u001a\u00028\u0004HÆ\u0003¢\u0006\u0004\b\f\u0010\bJ4\u0010\u000e\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00000\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0001\u0010\u0016\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00002\b\b\u0002\u0010\u0010\u001a\u00028\u00002\b\b\u0002\u0010\u0011\u001a\u00028\u00012\b\b\u0002\u0010\u0012\u001a\u00028\u00022\b\b\u0002\u0010\u0013\u001a\u00028\u00032\b\b\u0002\u0010\u0014\u001a\u00028\u00042,\b\u0002\u0010\u0015\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00000\rHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0018HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001c\u001a\u00020\u001bHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÖ\u0003¢\u0006\u0004\b!\u0010\"R@\u0010\u0015\u001a&\u0012\"\u0012 \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00000\r8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b#\u0010$\u001a\u0004\b%\u0010\u000fR\u0019\u0010\u0011\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010\bR\u0019\u0010\u0013\u001a\u00028\u00038\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010'\u001a\u0004\b*\u0010\bR\u0019\u0010\u0010\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b+\u0010'\u001a\u0004\b,\u0010\bR\u0019\u0010\u0012\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b-\u0010'\u001a\u0004\b.\u0010\bR\u0019\u0010\u0014\u001a\u00028\u00048\u0006@\u0006¢\u0006\f\n\u0004\b/\u0010'\u001a\u0004\b0\u0010\bR4\u00103\u001a \u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u0003\u0012\u0004\u0012\u00028\u00040\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b1\u00102¨\u00067"}, d2 = {"Lorg/kodein/di/Multi5;", "A1", "A2", "A3", "A4", "A5", "Lorg/kodein/di/Typed;", "component1", "()Ljava/lang/Object;", "component2", "component3", "component4", "component5", "Lorg/kodein/di/TypeToken;", "component6", "()Lorg/kodein/di/TypeToken;", "a1", "a2", "a3", "a4", "a5", "type", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lorg/kodein/di/TypeToken;)Lorg/kodein/di/Multi5;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "f", "Lorg/kodein/di/TypeToken;", "getType", AuthSource.BOOKING_ORDER, "Ljava/lang/Object;", "getA2", "d", "getA4", AuthSource.SEND_ABUSE, "getA1", "c", "getA3", "e", "getA5", "getValue", "()Lorg/kodein/di/Multi5;", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lorg/kodein/di/TypeToken;)V", "Companion", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class Multi5<A1, A2, A3, A4, A5> implements Typed<Multi5<A1, A2, A3, A4, A5>> {
    public static final Companion Companion = new Companion(null);
    public final A1 a;
    public final A2 b;
    public final A3 c;
    public final A4 d;
    public final A5 e;
    @NotNull
    public final TypeToken<Multi5<A1, A2, A3, A4, A5>> f;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lorg/kodein/di/Multi5$Companion;", "", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public Multi5(A1 a1, A2 a22, A3 a3, A4 a4, A5 a5, @NotNull TypeToken<Multi5<A1, A2, A3, A4, A5>> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        this.a = a1;
        this.b = a22;
        this.c = a3;
        this.d = a4;
        this.e = a5;
        this.f = typeToken;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: org.kodein.di.Multi5 */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Multi5 copy$default(Multi5 multi5, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, TypeToken typeToken, int i, Object obj6) {
        if ((i & 1) != 0) {
            obj = multi5.a;
        }
        if ((i & 2) != 0) {
            obj2 = multi5.b;
        }
        if ((i & 4) != 0) {
            obj3 = multi5.c;
        }
        if ((i & 8) != 0) {
            obj4 = multi5.d;
        }
        if ((i & 16) != 0) {
            obj5 = multi5.e;
        }
        if ((i & 32) != 0) {
            typeToken = multi5.getType();
        }
        return multi5.copy(obj, obj2, obj3, obj4, obj5, typeToken);
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

    public final A5 component5() {
        return this.e;
    }

    @NotNull
    public final TypeToken<Multi5<A1, A2, A3, A4, A5>> component6() {
        return getType();
    }

    @NotNull
    public final Multi5<A1, A2, A3, A4, A5> copy(A1 a1, A2 a22, A3 a3, A4 a4, A5 a5, @NotNull TypeToken<Multi5<A1, A2, A3, A4, A5>> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return new Multi5<>(a1, a22, a3, a4, a5, typeToken);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Multi5)) {
            return false;
        }
        Multi5 multi5 = (Multi5) obj;
        return Intrinsics.areEqual(this.a, multi5.a) && Intrinsics.areEqual(this.b, multi5.b) && Intrinsics.areEqual(this.c, multi5.c) && Intrinsics.areEqual(this.d, multi5.d) && Intrinsics.areEqual(this.e, multi5.e) && Intrinsics.areEqual(getType(), multi5.getType());
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

    public final A5 getA5() {
        return this.e;
    }

    @Override // org.kodein.di.Typed
    @NotNull
    public TypeToken<Multi5<A1, A2, A3, A4, A5>> getType() {
        return this.f;
    }

    @Override // org.kodein.di.Typed
    @NotNull
    public Multi5<A1, A2, A3, A4, A5> getValue() {
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
        A5 a5 = this.e;
        int hashCode5 = (hashCode4 + (a5 != null ? a5.hashCode() : 0)) * 31;
        TypeToken<Multi5<A1, A2, A3, A4, A5>> type = getType();
        if (type != null) {
            i = type.hashCode();
        }
        return hashCode5 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Multi5(a1=");
        L.append((Object) this.a);
        L.append(", a2=");
        L.append((Object) this.b);
        L.append(", a3=");
        L.append((Object) this.c);
        L.append(", a4=");
        L.append((Object) this.d);
        L.append(", a5=");
        L.append((Object) this.e);
        L.append(", type=");
        L.append(getType());
        L.append(")");
        return L.toString();
    }
}

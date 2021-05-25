package org.kodein.di;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0011\b\b\u0018\u0000 '*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u0003:\u0001'B1\u0012\u0006\u0010\n\u001a\u00028\u0000\u0012\u0006\u0010\u000b\u001a\u00028\u0001\u0012\u0018\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u0007¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0004\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0005J\"\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJL\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\n\u001a\u00028\u00002\b\b\u0002\u0010\u000b\u001a\u00028\u00012\u001a\b\u0002\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u0007HÆ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0018\u001a\u00020\u00172\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÖ\u0003¢\u0006\u0004\b\u0018\u0010\u0019R\"\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR.\u0010\f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00000\u00078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\tR\u0019\u0010\n\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u0005R\u0019\u0010\u000b\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010!\u001a\u0004\b$\u0010\u0005¨\u0006("}, d2 = {"Lorg/kodein/di/Multi2;", "A1", "A2", "Lorg/kodein/di/Typed;", "component1", "()Ljava/lang/Object;", "component2", "Lorg/kodein/di/TypeToken;", "component3", "()Lorg/kodein/di/TypeToken;", "a1", "a2", "type", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/kodein/di/TypeToken;)Lorg/kodein/di/Multi2;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "getValue", "()Lorg/kodein/di/Multi2;", "value", "c", "Lorg/kodein/di/TypeToken;", "getType", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "getA1", AuthSource.BOOKING_ORDER, "getA2", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Lorg/kodein/di/TypeToken;)V", "Companion", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class Multi2<A1, A2> implements Typed<Multi2<A1, A2>> {
    public static final Companion Companion = new Companion(null);
    public final A1 a;
    public final A2 b;
    @NotNull
    public final TypeToken<Multi2<A1, A2>> c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lorg/kodein/di/Multi2$Companion;", "", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public Multi2(A1 a1, A2 a22, @NotNull TypeToken<Multi2<A1, A2>> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        this.a = a1;
        this.b = a22;
        this.c = typeToken;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.kodein.di.Multi2 */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Multi2 copy$default(Multi2 multi2, Object obj, Object obj2, TypeToken typeToken, int i, Object obj3) {
        if ((i & 1) != 0) {
            obj = multi2.a;
        }
        if ((i & 2) != 0) {
            obj2 = multi2.b;
        }
        if ((i & 4) != 0) {
            typeToken = multi2.getType();
        }
        return multi2.copy(obj, obj2, typeToken);
    }

    public final A1 component1() {
        return this.a;
    }

    public final A2 component2() {
        return this.b;
    }

    @NotNull
    public final TypeToken<Multi2<A1, A2>> component3() {
        return getType();
    }

    @NotNull
    public final Multi2<A1, A2> copy(A1 a1, A2 a22, @NotNull TypeToken<Multi2<A1, A2>> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return new Multi2<>(a1, a22, typeToken);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Multi2)) {
            return false;
        }
        Multi2 multi2 = (Multi2) obj;
        return Intrinsics.areEqual(this.a, multi2.a) && Intrinsics.areEqual(this.b, multi2.b) && Intrinsics.areEqual(getType(), multi2.getType());
    }

    public final A1 getA1() {
        return this.a;
    }

    public final A2 getA2() {
        return this.b;
    }

    @Override // org.kodein.di.Typed
    @NotNull
    public TypeToken<Multi2<A1, A2>> getType() {
        return this.c;
    }

    @Override // org.kodein.di.Typed
    @NotNull
    public Multi2<A1, A2> getValue() {
        return this;
    }

    public int hashCode() {
        A1 a1 = this.a;
        int i = 0;
        int hashCode = (a1 != null ? a1.hashCode() : 0) * 31;
        A2 a22 = this.b;
        int hashCode2 = (hashCode + (a22 != null ? a22.hashCode() : 0)) * 31;
        TypeToken<Multi2<A1, A2>> type = getType();
        if (type != null) {
            i = type.hashCode();
        }
        return hashCode2 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Multi2(a1=");
        L.append((Object) this.a);
        L.append(", a2=");
        L.append((Object) this.b);
        L.append(", type=");
        L.append(getType());
        L.append(")");
        return L.toString();
    }
}

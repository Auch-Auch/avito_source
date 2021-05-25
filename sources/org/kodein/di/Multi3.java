package org.kodein.di;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0013\b\b\u0018\u0000 ,*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00000\u0004:\u0001,B?\u0012\u0006\u0010\f\u001a\u00028\u0000\u0012\u0006\u0010\r\u001a\u00028\u0001\u0012\u0006\u0010\u000e\u001a\u00028\u0002\u0012\u001e\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00000\t¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0005\u001a\u00028\u0000HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0007\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0006J\u0010\u0010\b\u001a\u00028\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0006J(\u0010\n\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00000\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJb\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\f\u001a\u00028\u00002\b\b\u0002\u0010\r\u001a\u00028\u00012\b\b\u0002\u0010\u000e\u001a\u00028\u00022 \b\u0002\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00000\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0013\u001a\u00020\u0012HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0015HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001a\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÖ\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0019\u0010\r\u001a\u00028\u00018\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\u0006R4\u0010\u000f\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00000\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\u000bR\u0019\u0010\u000e\u001a\u00028\u00028\u0006@\u0006¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b$\u0010\u0006R\u0019\u0010\f\u001a\u00028\u00008\u0006@\u0006¢\u0006\f\n\u0004\b%\u0010\u001e\u001a\u0004\b&\u0010\u0006R(\u0010)\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00008V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010(¨\u0006-"}, d2 = {"Lorg/kodein/di/Multi3;", "A1", "A2", "A3", "Lorg/kodein/di/Typed;", "component1", "()Ljava/lang/Object;", "component2", "component3", "Lorg/kodein/di/TypeToken;", "component4", "()Lorg/kodein/di/TypeToken;", "a1", "a2", "a3", "type", "copy", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lorg/kodein/di/TypeToken;)Lorg/kodein/di/Multi3;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.BOOKING_ORDER, "Ljava/lang/Object;", "getA2", "d", "Lorg/kodein/di/TypeToken;", "getType", "c", "getA3", AuthSource.SEND_ABUSE, "getA1", "getValue", "()Lorg/kodein/di/Multi3;", "value", "<init>", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lorg/kodein/di/TypeToken;)V", "Companion", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public final class Multi3<A1, A2, A3> implements Typed<Multi3<A1, A2, A3>> {
    public static final Companion Companion = new Companion(null);
    public final A1 a;
    public final A2 b;
    public final A3 c;
    @NotNull
    public final TypeToken<Multi3<A1, A2, A3>> d;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lorg/kodein/di/Multi3$Companion;", "", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public Multi3(A1 a1, A2 a22, A3 a3, @NotNull TypeToken<Multi3<A1, A2, A3>> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        this.a = a1;
        this.b = a22;
        this.c = a3;
        this.d = typeToken;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.kodein.di.Multi3 */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Multi3 copy$default(Multi3 multi3, Object obj, Object obj2, Object obj3, TypeToken typeToken, int i, Object obj4) {
        if ((i & 1) != 0) {
            obj = multi3.a;
        }
        if ((i & 2) != 0) {
            obj2 = multi3.b;
        }
        if ((i & 4) != 0) {
            obj3 = multi3.c;
        }
        if ((i & 8) != 0) {
            typeToken = multi3.getType();
        }
        return multi3.copy(obj, obj2, obj3, typeToken);
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

    @NotNull
    public final TypeToken<Multi3<A1, A2, A3>> component4() {
        return getType();
    }

    @NotNull
    public final Multi3<A1, A2, A3> copy(A1 a1, A2 a22, A3 a3, @NotNull TypeToken<Multi3<A1, A2, A3>> typeToken) {
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        return new Multi3<>(a1, a22, a3, typeToken);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Multi3)) {
            return false;
        }
        Multi3 multi3 = (Multi3) obj;
        return Intrinsics.areEqual(this.a, multi3.a) && Intrinsics.areEqual(this.b, multi3.b) && Intrinsics.areEqual(this.c, multi3.c) && Intrinsics.areEqual(getType(), multi3.getType());
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

    @Override // org.kodein.di.Typed
    @NotNull
    public TypeToken<Multi3<A1, A2, A3>> getType() {
        return this.d;
    }

    @Override // org.kodein.di.Typed
    @NotNull
    public Multi3<A1, A2, A3> getValue() {
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
        TypeToken<Multi3<A1, A2, A3>> type = getType();
        if (type != null) {
            i = type.hashCode();
        }
        return hashCode3 + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("Multi3(a1=");
        L.append((Object) this.a);
        L.append(", a2=");
        L.append((Object) this.b);
        L.append(", a3=");
        L.append((Object) this.c);
        L.append(", type=");
        L.append(getType());
        L.append(")");
        return L.toString();
    }
}

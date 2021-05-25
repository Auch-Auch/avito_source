package org.kodein.di.internal;

import a2.b.a.a.a;
import com.avito.android.authorization.auth.tracker.check.CheckTrackerModule;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.TypeToken;
import org.kodein.di.TypeTokenKt;
import t6.r.a.j;
public abstract class TypeChecker {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\n\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0017\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R \u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lorg/kodein/di/internal/TypeChecker$Down;", "Lorg/kodein/di/internal/TypeChecker;", "Lorg/kodein/di/TypeToken;", "other", "", CheckTrackerModule.NAME, "(Lorg/kodein/di/TypeToken;)Z", "component1", "()Lorg/kodein/di/TypeToken;", "type", "copy", "(Lorg/kodein/di/TypeToken;)Lorg/kodein/di/internal/TypeChecker$Down;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Z", "isAny", "()Z", AuthSource.BOOKING_ORDER, "Lorg/kodein/di/TypeToken;", "getType", "<init>", "(Lorg/kodein/di/TypeToken;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class Down extends TypeChecker {
        public final boolean a = Intrinsics.areEqual(getType(), TypeTokenKt.getAnyToken());
        @NotNull
        public final TypeToken<?> b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Down(@NotNull TypeToken<?> typeToken) {
            super(null);
            Intrinsics.checkParameterIsNotNull(typeToken, "type");
            this.b = typeToken;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.kodein.di.internal.TypeChecker$Down */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Down copy$default(Down down, TypeToken typeToken, int i, Object obj) {
            if ((i & 1) != 0) {
                typeToken = down.getType();
            }
            return down.copy(typeToken);
        }

        @Override // org.kodein.di.internal.TypeChecker
        public boolean check(@NotNull TypeToken<?> typeToken) {
            Intrinsics.checkParameterIsNotNull(typeToken, "other");
            return this.a || getType().isAssignableFrom(typeToken);
        }

        @NotNull
        public final TypeToken<?> component1() {
            return getType();
        }

        @NotNull
        public final Down copy(@NotNull TypeToken<?> typeToken) {
            Intrinsics.checkParameterIsNotNull(typeToken, "type");
            return new Down(typeToken);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Down) && Intrinsics.areEqual(getType(), ((Down) obj).getType());
            }
            return true;
        }

        @Override // org.kodein.di.internal.TypeChecker
        @NotNull
        public TypeToken<?> getType() {
            return this.b;
        }

        public int hashCode() {
            TypeToken<?> type = getType();
            if (type != null) {
                return type.hashCode();
            }
            return 0;
        }

        public final boolean isAny() {
            return this.a;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Down(type=");
            L.append(getType());
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001b\u0010\u0005\u001a\u00020\u00042\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001e\u0010\n\u001a\u00020\u00002\f\b\u0002\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u0002HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R \u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\b¨\u0006\u001a"}, d2 = {"Lorg/kodein/di/internal/TypeChecker$Up;", "Lorg/kodein/di/internal/TypeChecker;", "Lorg/kodein/di/TypeToken;", "other", "", CheckTrackerModule.NAME, "(Lorg/kodein/di/TypeToken;)Z", "component1", "()Lorg/kodein/di/TypeToken;", "type", "copy", "(Lorg/kodein/di/TypeToken;)Lorg/kodein/di/internal/TypeChecker$Up;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lorg/kodein/di/TypeToken;", "getType", "<init>", "(Lorg/kodein/di/TypeToken;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class Up extends TypeChecker {
        @NotNull
        public final TypeToken<?> a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Up(@NotNull TypeToken<?> typeToken) {
            super(null);
            Intrinsics.checkParameterIsNotNull(typeToken, "type");
            this.a = typeToken;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.kodein.di.internal.TypeChecker$Up */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Up copy$default(Up up, TypeToken typeToken, int i, Object obj) {
            if ((i & 1) != 0) {
                typeToken = up.getType();
            }
            return up.copy(typeToken);
        }

        @Override // org.kodein.di.internal.TypeChecker
        public boolean check(@NotNull TypeToken<?> typeToken) {
            Intrinsics.checkParameterIsNotNull(typeToken, "other");
            return Intrinsics.areEqual(typeToken, TypeTokenKt.getAnyToken()) || typeToken.isAssignableFrom(getType());
        }

        @NotNull
        public final TypeToken<?> component1() {
            return getType();
        }

        @NotNull
        public final Up copy(@NotNull TypeToken<?> typeToken) {
            Intrinsics.checkParameterIsNotNull(typeToken, "type");
            return new Up(typeToken);
        }

        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Up) && Intrinsics.areEqual(getType(), ((Up) obj).getType());
            }
            return true;
        }

        @Override // org.kodein.di.internal.TypeChecker
        @NotNull
        public TypeToken<?> getType() {
            return this.a;
        }

        public int hashCode() {
            TypeToken<?> type = getType();
            if (type != null) {
                return type.hashCode();
            }
            return 0;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Up(type=");
            L.append(getType());
            L.append(")");
            return L.toString();
        }
    }

    public TypeChecker() {
    }

    public abstract boolean check(@NotNull TypeToken<?> typeToken);

    @NotNull
    public abstract TypeToken<?> getType();

    public TypeChecker(j jVar) {
    }
}

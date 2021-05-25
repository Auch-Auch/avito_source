package org.kodein.di;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\n\bf\u0018\u0000 \n*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003\n\u000b\fR\u001e\u0010\u0006\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00028\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lorg/kodein/di/KodeinContext;", "C", "", "Lorg/kodein/di/TypeToken;", "getType", "()Lorg/kodein/di/TypeToken;", "type", "getValue", "()Ljava/lang/Object;", "value", "Companion", "Lazy", "Value", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public interface KodeinContext<C> {
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\f\u0010\rJ4\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0001\u0010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u00032\u0006\u0010\u0005\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\u0007\u0010\bJ:\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006\"\u0004\b\u0001\u0010\u00022\u000e\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\tH\u0002¢\u0006\u0004\b\u0007\u0010\u000b¨\u0006\u000e"}, d2 = {"Lorg/kodein/di/KodeinContext$Companion;", "", "C", "Lorg/kodein/di/TypeToken;", "type", "value", "Lorg/kodein/di/KodeinContext;", "invoke", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Lorg/kodein/di/KodeinContext;", "Lkotlin/Function0;", "getValue", "(Lorg/kodein/di/TypeToken;Lkotlin/jvm/functions/Function0;)Lorg/kodein/di/KodeinContext;", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        @NotNull
        public final <C> KodeinContext<C> invoke(@NotNull TypeToken<? super C> typeToken, C c) {
            Intrinsics.checkParameterIsNotNull(typeToken, "type");
            return new Value(typeToken, c);
        }

        @NotNull
        public final <C> KodeinContext<C> invoke(@NotNull TypeToken<? super C> typeToken, @NotNull Function0<? extends C> function0) {
            Intrinsics.checkParameterIsNotNull(typeToken, "type");
            Intrinsics.checkParameterIsNotNull(function0, "getValue");
            return new Lazy(typeToken, function0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B%\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0003\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001d\u0010\r\u001a\u00028\u00018V@\u0016X\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lorg/kodein/di/KodeinContext$Lazy;", "C", "Lorg/kodein/di/KodeinContext;", "Lorg/kodein/di/TypeToken;", AuthSource.BOOKING_ORDER, "Lorg/kodein/di/TypeToken;", "getType", "()Lorg/kodein/di/TypeToken;", "type", AuthSource.SEND_ABUSE, "Lkotlin/Lazy;", "getValue", "()Ljava/lang/Object;", "value", "Lkotlin/Function0;", "c", "Lkotlin/jvm/functions/Function0;", "getGetValue", "()Lkotlin/jvm/functions/Function0;", "<init>", "(Lorg/kodein/di/TypeToken;Lkotlin/jvm/functions/Function0;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class Lazy<C> implements KodeinContext<C> {
        public static final /* synthetic */ KProperty[] d = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(Lazy.class), "value", "getValue()Ljava/lang/Object;"))};
        public final kotlin.Lazy a;
        @NotNull
        public final TypeToken<? super C> b;
        @NotNull
        public final Function0<C> c;

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function0<? extends C> */
        /* JADX WARN: Multi-variable type inference failed */
        public Lazy(@NotNull TypeToken<? super C> typeToken, @NotNull Function0<? extends C> function0) {
            Intrinsics.checkParameterIsNotNull(typeToken, "type");
            Intrinsics.checkParameterIsNotNull(function0, "getValue");
            this.b = typeToken;
            this.c = function0;
            this.a = c.lazy(function0);
        }

        @NotNull
        public final Function0<C> getGetValue() {
            return this.c;
        }

        @Override // org.kodein.di.KodeinContext
        @NotNull
        public TypeToken<? super C> getType() {
            return this.b;
        }

        @Override // org.kodein.di.KodeinContext
        public C getValue() {
            kotlin.Lazy lazy = this.a;
            KProperty kProperty = d[0];
            return (C) lazy.getValue();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u00028\u00010\u0002B\u001f\u0012\u000e\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0003\u0012\u0006\u0010\t\u001a\u00028\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u0004\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u0003HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00028\u0001HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J2\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\u0010\b\u0002\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u00032\b\b\u0002\u0010\t\u001a\u00028\u0001HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R$\u0010\b\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00010\u00038\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u0005R\u001c\u0010\t\u001a\u00028\u00018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007¨\u0006\u001f"}, d2 = {"Lorg/kodein/di/KodeinContext$Value;", "C", "Lorg/kodein/di/KodeinContext;", "Lorg/kodein/di/TypeToken;", "component1", "()Lorg/kodein/di/TypeToken;", "component2", "()Ljava/lang/Object;", "type", "value", "copy", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)Lorg/kodein/di/KodeinContext$Value;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Lorg/kodein/di/TypeToken;", "getType", AuthSource.BOOKING_ORDER, "Ljava/lang/Object;", "getValue", "<init>", "(Lorg/kodein/di/TypeToken;Ljava/lang/Object;)V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class Value<C> implements KodeinContext<C> {
        @NotNull
        public final TypeToken<? super C> a;
        public final C b;

        public Value(@NotNull TypeToken<? super C> typeToken, C c) {
            Intrinsics.checkParameterIsNotNull(typeToken, "type");
            this.a = typeToken;
            this.b = c;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: org.kodein.di.KodeinContext$Value */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Value copy$default(Value value, TypeToken typeToken, Object obj, int i, Object obj2) {
            if ((i & 1) != 0) {
                typeToken = value.getType();
            }
            if ((i & 2) != 0) {
                obj = value.getValue();
            }
            return value.copy(typeToken, obj);
        }

        @NotNull
        public final TypeToken<? super C> component1() {
            return getType();
        }

        public final C component2() {
            return getValue();
        }

        @NotNull
        public final Value<C> copy(@NotNull TypeToken<? super C> typeToken, C c) {
            Intrinsics.checkParameterIsNotNull(typeToken, "type");
            return new Value<>(typeToken, c);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Value)) {
                return false;
            }
            Value value = (Value) obj;
            return Intrinsics.areEqual(getType(), value.getType()) && Intrinsics.areEqual(getValue(), value.getValue());
        }

        @Override // org.kodein.di.KodeinContext
        @NotNull
        public TypeToken<? super C> getType() {
            return this.a;
        }

        @Override // org.kodein.di.KodeinContext
        public C getValue() {
            return this.b;
        }

        public int hashCode() {
            TypeToken<? super C> type = getType();
            int i = 0;
            int hashCode = (type != null ? type.hashCode() : 0) * 31;
            C value = getValue();
            if (value != null) {
                i = value.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Value(type=");
            L.append(getType());
            L.append(", value=");
            L.append((Object) getValue());
            L.append(")");
            return L.toString();
        }
    }

    @NotNull
    TypeToken<? super C> getType();

    C getValue();
}

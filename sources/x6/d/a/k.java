package x6.d.a;

import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.TypeToken;
import org.kodein.di.Typed;
import t6.c;
public final class k<A> implements Typed<A> {
    public static final /* synthetic */ KProperty[] c = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(k.class), "value", "getValue()Ljava/lang/Object;"))};
    public final Lazy a;
    @NotNull
    public final TypeToken<A> b;

    public k(@NotNull Function0<? extends A> function0, @NotNull TypeToken<A> typeToken) {
        Intrinsics.checkParameterIsNotNull(function0, "func");
        Intrinsics.checkParameterIsNotNull(typeToken, "type");
        this.b = typeToken;
        this.a = c.lazy(function0);
    }

    @Override // org.kodein.di.Typed
    @NotNull
    public TypeToken<A> getType() {
        return this.b;
    }

    @Override // org.kodein.di.Typed
    public A getValue() {
        Lazy lazy = this.a;
        KProperty kProperty = c[0];
        return (A) lazy.getValue();
    }
}

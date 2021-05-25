package org.kodein.di;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0006\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00028\u00000\u0002¢\u0006\u0002\b\u0004H\b¢\u0006\u0004\b\u0006\u0010\u0007\"\u0017\u0010\u000b\u001a\u00020\b*\u00020\u00018F@\u0006¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"T", "Lorg/kodein/di/DKodeinAware;", "Lkotlin/Function1;", "Lorg/kodein/di/DKodein;", "Lkotlin/ExtensionFunctionType;", "creator", "newInstance", "(Lorg/kodein/di/DKodeinAware;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lorg/kodein/di/Kodein;", "getLazy", "(Lorg/kodein/di/DKodeinAware;)Lorg/kodein/di/Kodein;", "lazy", "kodein-di-core"}, k = 2, mv = {1, 4, 0})
public final class DKodeinKt {
    @NotNull
    public static final Kodein getLazy(@NotNull DKodeinAware dKodeinAware) {
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$lazy");
        return dKodeinAware.getDkodein().getLazy();
    }

    public static final <T> T newInstance(@NotNull DKodeinAware dKodeinAware, @NotNull Function1<? super DKodein, ? extends T> function1) {
        Intrinsics.checkParameterIsNotNull(dKodeinAware, "$this$newInstance");
        Intrinsics.checkParameterIsNotNull(function1, "creator");
        return (T) function1.invoke(dKodeinAware.getDkodein());
    }
}

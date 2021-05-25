package org.kodein.di;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Copy;
import org.kodein.di.Kodein;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aG\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u0019\b\u0004\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\tH\b¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lorg/kodein/di/Kodein;", "parentKodein", "", "allowSilentOverride", "Lorg/kodein/di/Copy;", "copy", "Lkotlin/Function1;", "Lorg/kodein/di/Kodein$MainBuilder;", "", "Lkotlin/ExtensionFunctionType;", "init", "Lorg/kodein/di/LazyKodein;", "subKodein", "(Lorg/kodein/di/Kodein;ZLorg/kodein/di/Copy;Lkotlin/jvm/functions/Function1;)Lorg/kodein/di/LazyKodein;", "kodein-di-core"}, k = 2, mv = {1, 4, 0})
public final class SubsKt {
    @NotNull
    public static final LazyKodein subKodein(@NotNull Kodein kodein, boolean z, @NotNull Copy copy, @NotNull Function1<? super Kodein.MainBuilder, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(kodein, "parentKodein");
        Intrinsics.checkParameterIsNotNull(copy, "copy");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        return Kodein.Companion.lazy(z, new SubsKt$subKodein$1(kodein, copy, function1));
    }

    public static /* synthetic */ LazyKodein subKodein$default(Kodein kodein, boolean z, Copy copy, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            copy = Copy.NonCached.INSTANCE;
        }
        Intrinsics.checkParameterIsNotNull(kodein, "parentKodein");
        Intrinsics.checkParameterIsNotNull(copy, "copy");
        Intrinsics.checkParameterIsNotNull(function1, "init");
        return Kodein.Companion.lazy(z, new SubsKt$subKodein$1(kodein, copy, function1));
    }
}

package org.kodein.di.bindings;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.Kodein;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000 \t2\u00020\u0001:\u0001\tJ?\u0010\u0007\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00022\u0012\u0010\u0005\u001a\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lorg/kodein/di/bindings/ExternalSource;", "", "Lorg/kodein/di/bindings/BindingKodein;", "kodein", "Lorg/kodein/di/Kodein$Key;", "key", "Lkotlin/Function1;", "getFactory", "(Lorg/kodein/di/bindings/BindingKodein;Lorg/kodein/di/Kodein$Key;)Lkotlin/jvm/functions/Function1;", "Companion", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public interface ExternalSource {
    public static final Companion Companion = Companion.a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJQ\u0010\t\u001a\u00020\b2?\b\u0004\u0010\u0007\u001a9\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003\u0012\u0010\u0012\u000e\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004\u0012\u0014\u0012\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00050\u0002¢\u0006\u0002\b\u0006H\n¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lorg/kodein/di/bindings/ExternalSource$Companion;", "", "Lkotlin/Function2;", "Lorg/kodein/di/bindings/BindingKodein;", "Lorg/kodein/di/Kodein$Key;", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "f", "Lorg/kodein/di/bindings/ExternalSource;", "invoke", "(Lkotlin/jvm/functions/Function2;)Lorg/kodein/di/bindings/ExternalSource;", "<init>", "()V", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
    public static final class Companion {
        public static final /* synthetic */ Companion a = new Companion();

        @NotNull
        public final ExternalSource invoke(@NotNull Function2<? super BindingKodein<?>, ? super Kodein.Key<?, ?, ?>, ? extends Function1<Object, ? extends Object>> function2) {
            Intrinsics.checkParameterIsNotNull(function2, "f");
            return new ExternalSource$Companion$invoke$1(function2);
        }
    }

    @Nullable
    Function1<Object, Object> getFactory(@NotNull BindingKodein<?> bindingKodein, @NotNull Kodein.Key<?, ?, ?> key);
}

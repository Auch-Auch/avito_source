package org.kodein.di.bindings;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.DKodein;
import org.kodein.di.Kodein;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003J\u001d\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H&¢\u0006\u0004\b\b\u0010\u0007¨\u0006\t"}, d2 = {"Lorg/kodein/di/bindings/SimpleBindingKodein;", "C", "Lorg/kodein/di/DKodein;", "Lorg/kodein/di/bindings/WithContext;", "Lkotlin/Function1;", "", "overriddenFactory", "()Lkotlin/jvm/functions/Function1;", "overriddenFactoryOrNull", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
@Kodein.KodeinDsl
public interface SimpleBindingKodein<C> extends DKodein, WithContext<C> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        @NotNull
        public static <C> Kodein getKodein(SimpleBindingKodein<? extends C> simpleBindingKodein) {
            return DKodein.DefaultImpls.getKodein(simpleBindingKodein);
        }
    }

    @NotNull
    Function1<Object, Object> overriddenFactory();

    @Nullable
    Function1<Object, Object> overriddenFactoryOrNull();
}

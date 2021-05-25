package org.kodein.di.bindings;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.DKodein;
import org.kodein.di.Kodein;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u00022\b\u0012\u0004\u0012\u00028\u00000\u0003J\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004H&¢\u0006\u0004\b\b\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H&¢\u0006\u0004\b\t\u0010\nJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lorg/kodein/di/bindings/NoArgSimpleBindingKodein;", "C", "Lorg/kodein/di/DKodein;", "Lorg/kodein/di/bindings/WithContext;", "Lkotlin/Function0;", "", "overriddenProvider", "()Lkotlin/jvm/functions/Function0;", "overriddenProviderOrNull", "overriddenInstance", "()Ljava/lang/Object;", "overriddenInstanceOrNull", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
@Kodein.KodeinDsl
public interface NoArgSimpleBindingKodein<C> extends DKodein, WithContext<C> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        @NotNull
        public static <C> Kodein getKodein(NoArgSimpleBindingKodein<? extends C> noArgSimpleBindingKodein) {
            return DKodein.DefaultImpls.getKodein(noArgSimpleBindingKodein);
        }
    }

    @NotNull
    Object overriddenInstance();

    @Nullable
    Object overriddenInstanceOrNull();

    @NotNull
    Function0<Object> overriddenProvider();

    @Nullable
    Function0<Object> overriddenProviderOrNull();
}

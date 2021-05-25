package org.kodein.di.bindings;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.kodein.di.Kodein;
import org.kodein.di.bindings.SimpleBindingKodein;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u00028\u00000\u0002¨\u0006\u0003"}, d2 = {"Lorg/kodein/di/bindings/BindingKodein;", "C", "Lorg/kodein/di/bindings/SimpleBindingKodein;", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public interface BindingKodein<C> extends SimpleBindingKodein<C> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        @NotNull
        public static <C> Kodein getKodein(BindingKodein<? extends C> bindingKodein) {
            return SimpleBindingKodein.DefaultImpls.getKodein(bindingKodein);
        }
    }
}

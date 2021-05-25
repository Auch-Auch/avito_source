package org.kodein.di.bindings;

import kotlin.Metadata;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.kodein.di.TypeToken;
import org.kodein.di.TypeTokenKt;
import org.kodein.di.bindings.KodeinBinding;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0003*\u00020\u00022\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00010\u00042\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00010\u0006R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lorg/kodein/di/bindings/NoArgKodeinBinding;", "C", "", "T", "Lorg/kodein/di/bindings/KodeinBinding;", "", "Lorg/kodein/di/bindings/Binding;", "Lorg/kodein/di/TypeToken;", "getArgType", "()Lorg/kodein/di/TypeToken;", "argType", "kodein-di-core"}, k = 1, mv = {1, 4, 0})
public interface NoArgKodeinBinding<C, T> extends KodeinBinding<C, Unit, T>, Binding<C, Unit, T> {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        @NotNull
        public static <C, T> String factoryFullName(NoArgKodeinBinding<C, T> noArgKodeinBinding) {
            return KodeinBinding.DefaultImpls.factoryFullName(noArgKodeinBinding);
        }

        @NotNull
        public static <C, T> TypeToken<Unit> getArgType(NoArgKodeinBinding<C, T> noArgKodeinBinding) {
            return TypeTokenKt.getUnitToken();
        }

        @Nullable
        public static <C, T> KodeinBinding.Copier<C, Unit, T> getCopier(NoArgKodeinBinding<C, T> noArgKodeinBinding) {
            return KodeinBinding.DefaultImpls.getCopier(noArgKodeinBinding);
        }

        @NotNull
        public static <C, T> String getDescription(NoArgKodeinBinding<C, T> noArgKodeinBinding) {
            return KodeinBinding.DefaultImpls.getDescription(noArgKodeinBinding);
        }

        @NotNull
        public static <C, T> String getFullDescription(NoArgKodeinBinding<C, T> noArgKodeinBinding) {
            return KodeinBinding.DefaultImpls.getFullDescription(noArgKodeinBinding);
        }

        @Nullable
        public static <C, T> Scope<C> getScope(NoArgKodeinBinding<C, T> noArgKodeinBinding) {
            return KodeinBinding.DefaultImpls.getScope(noArgKodeinBinding);
        }

        public static <C, T> boolean getSupportSubTypes(NoArgKodeinBinding<C, T> noArgKodeinBinding) {
            return KodeinBinding.DefaultImpls.getSupportSubTypes(noArgKodeinBinding);
        }
    }

    /* Return type fixed from 'org.kodein.di.TypeToken<kotlin.Unit>' to match base method */
    @Override // org.kodein.di.bindings.KodeinBinding
    @NotNull
    TypeToken<? super Unit> getArgType();
}

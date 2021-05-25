package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
public interface Substitutable<T extends DeclarationDescriptorNonRoot> {
    @NotNull
    /* renamed from: substitute */
    T mo426substitute(@NotNull TypeSubstitutor typeSubstitutor);
}

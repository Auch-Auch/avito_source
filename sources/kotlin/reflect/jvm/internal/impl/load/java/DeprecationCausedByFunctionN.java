package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import org.jetbrains.annotations.NotNull;
public final class DeprecationCausedByFunctionN {
    @NotNull
    public final DeclarationDescriptor a;

    public DeprecationCausedByFunctionN(@NotNull DeclarationDescriptor declarationDescriptor) {
        Intrinsics.checkNotNullParameter(declarationDescriptor, "target");
        this.a = declarationDescriptor;
    }
}

package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Collection;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public interface ValueParameterDescriptor extends ParameterDescriptor, VariableDescriptor {

    public static final class DefaultImpls {
        public static boolean isLateInit(@NotNull ValueParameterDescriptor valueParameterDescriptor) {
            Intrinsics.checkNotNullParameter(valueParameterDescriptor, "this");
            return false;
        }
    }

    @NotNull
    ValueParameterDescriptor copy(@NotNull CallableDescriptor callableDescriptor, @NotNull Name name, int i);

    boolean declaresDefaultValue();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.ValueDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    CallableDescriptor getContainingDeclaration();

    int getIndex();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    ValueParameterDescriptor getOriginal();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    Collection<ValueParameterDescriptor> getOverriddenDescriptors();

    @Nullable
    KotlinType getVarargElementType();

    boolean isCrossinline();

    boolean isNoinline();
}

package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
public interface ConstructorDescriptor extends FunctionDescriptor {
    @NotNull
    ClassDescriptor getConstructedClass();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorNonRoot, kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor
    @NotNull
    ClassifierDescriptorWithTypeParameters getContainingDeclaration();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    KotlinType getReturnType();

    @Override // kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor
    @NotNull
    List<TypeParameterDescriptor> getTypeParameters();

    boolean isPrimary();

    /* Return type fixed from 'kotlin.reflect.jvm.internal.impl.descriptors.ConstructorDescriptor' to match base method */
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor, kotlin.reflect.jvm.internal.impl.descriptors.Substitutable
    @Nullable
    /* renamed from: substitute */
    CallableDescriptor mo426substitute(@NotNull TypeSubstitutor typeSubstitutor);
}

package kotlin.reflect.jvm.internal.impl.descriptors;

import org.jetbrains.annotations.NotNull;
public interface DeclarationDescriptorWithVisibility extends DeclarationDescriptor {
    @Override // kotlin.reflect.jvm.internal.impl.descriptors.MemberDescriptor
    @NotNull
    DescriptorVisibility getVisibility();
}

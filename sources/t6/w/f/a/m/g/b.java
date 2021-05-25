package t6.w.f.a.m.g;

import kotlin.jvm.functions.Function1;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
public final class b implements Function1<CallableMemberDescriptor, Boolean> {
    public final /* synthetic */ DeclarationDescriptor a;

    public b(DeclarationDescriptor declarationDescriptor) {
        this.a = declarationDescriptor;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        return Boolean.valueOf(callableMemberDescriptor.getContainingDeclaration() == this.a);
    }
}

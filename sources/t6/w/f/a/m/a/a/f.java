package t6.w.f.a.m.a.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JvmBuiltInsCustomizer;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
public final class f extends Lambda implements Function1<CallableMemberDescriptor, Boolean> {
    public final /* synthetic */ JvmBuiltInsCustomizer a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(JvmBuiltInsCustomizer jvmBuiltInsCustomizer) {
        super(1);
        this.a = jvmBuiltInsCustomizer;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(CallableMemberDescriptor callableMemberDescriptor) {
        CallableMemberDescriptor callableMemberDescriptor2 = callableMemberDescriptor;
        return Boolean.valueOf(callableMemberDescriptor2.getKind() == CallableMemberDescriptor.Kind.DECLARATION && this.a.b.isMutable((ClassDescriptor) callableMemberDescriptor2.getContainingDeclaration()));
    }
}

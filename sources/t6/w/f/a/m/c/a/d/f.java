package t6.w.f.a.m.c.a.d;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
public final class f extends Lambda implements Function1<CallableMemberDescriptor, KotlinType> {
    public static final f a = new f();

    public f() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public KotlinType invoke(CallableMemberDescriptor callableMemberDescriptor) {
        CallableMemberDescriptor callableMemberDescriptor2 = callableMemberDescriptor;
        Intrinsics.checkNotNullParameter(callableMemberDescriptor2, "it");
        KotlinType returnType = callableMemberDescriptor2.getReturnType();
        Intrinsics.checkNotNull(returnType);
        return returnType;
    }
}

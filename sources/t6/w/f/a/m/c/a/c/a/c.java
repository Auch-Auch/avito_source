package t6.w.f.a.m.c.a.c.a;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
public final class c extends Lambda implements Function1<SimpleFunctionDescriptor, CallableDescriptor> {
    public static final c a = new c();

    public c() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public CallableDescriptor invoke(SimpleFunctionDescriptor simpleFunctionDescriptor) {
        SimpleFunctionDescriptor simpleFunctionDescriptor2 = simpleFunctionDescriptor;
        Intrinsics.checkNotNullParameter(simpleFunctionDescriptor2, "<this>");
        return simpleFunctionDescriptor2;
    }
}
